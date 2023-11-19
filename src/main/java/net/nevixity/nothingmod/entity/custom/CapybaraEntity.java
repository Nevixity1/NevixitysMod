package net.nevixity.nothingmod.entity.custom;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.EntityView;
import net.minecraft.world.World;
import net.nevixity.nothingmod.entity.ModEntities;
import net.nevixity.nothingmod.entity.ai.CapybaraAttackGoal;
import org.jetbrains.annotations.Nullable;

public class CapybaraEntity extends TameableEntity implements Mount {
    private static final TrackedData<Boolean> STANDING = DataTracker.registerData(CapybaraEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState attackAnimationState = new AnimationState();
    public final AnimationState sitAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;
    private int idleAnimationTimeout = 0;


    public CapybaraEntity(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createCapybaraAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 12).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.5).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2);
    }

    @Override
    protected void initGoals() {
        super.initGoals();

        this.goalSelector.add(0, new SwimGoal(this));

        this.goalSelector.add(0, new SitGoal(this));

        this.goalSelector.add(1, new CapybaraAttackGoal(this, 1.1D, true));
        this.goalSelector.add(1, new AttackWithOwnerGoal(this));

        this.goalSelector.add(4, new FollowOwnerGoal(this, 1.1D, 10f, 3f, false));
        this.goalSelector.add(2, new AnimalMateGoal(this, 1.15D));
        this.goalSelector.add(3, new TemptGoal(this, 1.1D, Ingredient.ofItems(Items.PUMPKIN), false));


        this.goalSelector.add(6, new WanderAroundFarGoal(this, 1.0D));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));

        this.goalSelector.add(1, new RevengeGoal(this));
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }

        if (this.isAttacking() && attackAnimationTimeout <= 0) {
            attackAnimationTimeout = 12;
            attackAnimationState.start(this.age);
        } else {
            --this.attackAnimationTimeout;
        }

        if (!this.isAttacking()) {
            attackAnimationState.stop();
        }

        if (isInSittingPose()) {
            sitAnimationState.startIfNotRunning(this.age);
        } else {
            sitAnimationState.stop();
        }
    }

    @Override
    public boolean shouldRenderName() {
        return false;
    }

    protected void updateLimbs(float v) {
        float f;
        if (this.getPose() == EntityPose.STANDING) {
            f = Math.min(v * 6.0F, 1.0F);
        } else {
            f = 0.0F;
        }

        this.limbAnimator.updateLimbs(f, 0.2F);
    }

    @Override
    public void tick() {
        super.tick();

        if (this.getWorld().isClient()) {
            this.setupAnimationStates();
        }
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.CAPYBARA.create(world);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(STANDING, false);

    }

    public boolean isStanding() {
        return this.dataTracker.get(STANDING);
    }

    public void setStanding(boolean standing) {
        this.dataTracker.set(STANDING, standing);
    }

    /* SOUNDS */

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_FOX_AMBIENT;
    }


    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_CAT_HURT;
    }


    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_CAT_DEATH;
    }


    @Override
    public SoundEvent getEatSound(ItemStack stack) {
        return SoundEvents.ENTITY_FOX_EAT;
    }

    /* TAMABLE */

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);

        Item itemForTaming = Items.MELON_SLICE;

        if (stack.isOf(itemForTaming) && !isTamed()) {
            if (this.getWorld().isClient()) {
                return ActionResult.CONSUME;
            }
            if (!player.getAbilities().creativeMode) {
                stack.decrement(1);
            }
            super.setOwner(player);
            this.navigation.recalculatePath();
            this.setTarget(null);
            this.getWorld().sendEntityStatus(this, (byte) 7);
            setSitting(true);
            setInSittingPose(true);
            return ActionResult.SUCCESS;

        }

        if (isTamed() && isOwner(player) && !stack.isOf(itemForTaming) && !isBreedingItem(stack)) {
            if (!player.isSneaking()) {
                setRiding(player);
            } else {
                boolean sitting = !isSitting();
                setSitting(sitting);
                setInSittingPose(sitting);
            }
            return ActionResult.SUCCESS;
        }
        return super.interactMob(player, hand);
    }


    @Override
    public EntityView method_48926() {
        return this.getWorld();
    }


    /* RIDEABLE */
    @Nullable
    @Override
    public LivingEntity getControllingPassenger() {
        return (LivingEntity) this.getFirstPassenger();
    }

    private void setRiding(PlayerEntity pPlayer) {
        this.setInSittingPose(false);

        pPlayer.setYaw(this.getYaw());
        pPlayer.setPitch(this.getPitch());
        pPlayer.startRiding(this);
    }

    @Override
    public void travel(Vec3d movementInput) {
        if (this.hasPassengers() && getControllingPassenger() instanceof PlayerEntity) {
            LivingEntity livingentity = this.getControllingPassenger();
            this.setYaw(livingentity.getYaw());
            this.prevYaw = this.getYaw();
            this.setPitch(livingentity.getPitch() * 0.5F);
            this.setRotation(this.getYaw(), this.getPitch());
            this.bodyYaw = this.getYaw();
            this.headYaw = this.bodyYaw;
            float f = livingentity.sidewaysSpeed * 0.5F;
            float f1 = livingentity.forwardSpeed;
            if (f1 <= 0.0F) {
                f1 *= 0.25F;
            }

            if (this.isLogicalSideForUpdatingMovement()) {
                float newSpeed = (float) this.getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED);

                if (MinecraftClient.getInstance().options.sprintKey.isPressed()) {
                    newSpeed *= 1.5f;
                }

                this.setMovementSpeed(newSpeed);
                super.travel(new Vec3d(f, movementInput.y, f1));
            }
        } else {
            super.travel(movementInput);
        }
    }

    @Override
    public Vec3d updatePassengerForDismount(LivingEntity passenger) {
        if (isSitting()) {
            this.setInSittingPose(true);
        } else {
            this.setInSittingPose(false);
            Direction direction = this.getMovementDirection();
            if (direction.getAxis() == Direction.Axis.Y) {
                return super.updatePassengerForDismount(passenger);
            }
            int[][] possibleDismountOffsets = Dismounting.getDismountOffsets(direction);
            BlockPos blockPos = this.getBlockPos();
            for (EntityPose entityPose : passenger.getPoses()) {
                Box box = passenger.getBoundingBox(entityPose);
                for (int[] dismountOffsets : possibleDismountOffsets) {
                    BlockPos dismountPos = new BlockPos(blockPos.getX() + dismountOffsets[0], blockPos.getY(), blockPos.getZ() + dismountOffsets[1]);
                    double dismountHeight = this.getWorld().getDismountHeight(dismountPos);
                    if (!Dismounting.canDismountInBlock(dismountHeight)) continue;
                    Vec3d vec3d = Vec3d.ofCenter(dismountPos, dismountHeight);
                    if (!Dismounting.canPlaceEntityAt(this.getWorld(), passenger, box.offset(vec3d))) continue;
                    passenger.setPose(entityPose);
                    return vec3d;
                }
            }
        }
        return super.updatePassengerForDismount(passenger);
    }

    /* BREEDABLE */

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(Items.PUMPKIN);
    }
}


