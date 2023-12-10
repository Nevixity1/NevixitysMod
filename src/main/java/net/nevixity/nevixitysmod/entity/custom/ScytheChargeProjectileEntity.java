package net.nevixity.nevixitysmod.entity.custom;


import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.nevixity.nevixitysmod.entity.ModEntityTypes;
import net.nevixity.nevixitysmod.particles.ModParticles;

public class ScytheChargeProjectileEntity extends PersistentProjectileEntity {
    private static final TrackedData<Boolean> HIT = DataTracker.registerData(ScytheChargeProjectileEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private int totalTicksToLive = 0;

    public ScytheChargeProjectileEntity(EntityType<? extends ScytheChargeProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    public ScytheChargeProjectileEntity(World world, PlayerEntity player) {
        super(ModEntityTypes.SCYTHE_CHARGE_PROJECTILE, world);
        setOwner(player);
        BlockPos blockpos = player.getBlockPos();
        double d0 = (double) blockpos.getX() + 0.5d;
        double d1 = (double) blockpos.getY() + 1.75d;
        double d2 = (double) blockpos.getZ() + 0.5d;
        this.refreshPositionAndAngles(d0, d1, d2, this.getYaw(), this.getPitch());
    }

    @Override
    public void tick() {
        super.tick();
        if (this.inGround) {
            this.discard();
        }

        if (this.dataTracker.get(HIT)) {
            if (this.age >= totalTicksToLive) {
                this.discard();
            }
        }

        if (this.age >= 15) {
            this.discard();
        }

        Vec3d vec3 = this.getVelocity();
        HitResult hitresult = ProjectileUtil.getCollision(this, this::canHit);
        if (hitresult.getType() != HitResult.Type.MISS) this.onCollision(hitresult);

        double d0 = this.getX() + vec3.x;
        double d1 = this.getY() + vec3.y;
        double d2 = this.getZ() + vec3.z;
        this.updateRotation();

        double d5 = vec3.x;
        double d6 = vec3.y;
        double d7 = vec3.z;

        for (int i = 1; i < 5; ++i) {
            this.getWorld().addParticle(ModParticles.SCYTHE_CHARGE_FLAME_PARTICLE, d0 - (d5 * 1), d1 - (d6 * 2), d2 - (d7 * 1), -d5, -d6 - 0.1D, -d7);
        }

        if (this.getWorld().getStatesInBox(this.getBoundingBox()).noneMatch(AbstractBlock.AbstractBlockState::isAir) || this.isInsideWaterOrBubbleColumn()) {
            this.discard();
        } else {
            this.setVelocity(vec3.multiply(0.99F));
            this.setPos(d0, d1, d2);
        }
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        Entity target = entityHitResult.getEntity();
        Entity owner = this.getOwner();

        if (target == owner && this.getWorld().isClient()) {
            return;
        }

        LivingEntity livingOwner = owner instanceof LivingEntity ? (LivingEntity) owner : null;
        float damage = 4f;
        if (target.damage(this.getDamageSources().mobProjectile(this, livingOwner), damage) && target instanceof LivingEntity livingTarget) {
            livingTarget.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 150, 0), owner);
            livingTarget.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 150, 0), owner);
        }

        for (int x = 0; x < 18; ++x) {
            for (int y = 0; y < 18; ++y) {
                this.getWorld().addParticle(ModParticles.SCYTHE_CHARGE_FLAME_PARTICLE, this.getX(), this.getY(), this.getZ(),
                        Math.cos(x * 20) * 1.15d, Math.cos(y * 10) * 0.10d, Math.sin(x * 10) * 1.15d);
            }
        }
    }

    @Override
    protected ItemStack asItemStack() {
        return ItemStack.EMPTY;
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        BlockState blockState = this.getWorld().getBlockState(blockHitResult.getBlockPos());
        blockState.onProjectileHit(this.getWorld(), blockState, blockHitResult, this);

        for (int x = 0; x < 18; ++x) {
            for (int y = 0; y < 18; ++y) {
                this.getWorld().addParticle(ModParticles.SCYTHE_CHARGE_FLAME_PARTICLE, this.getX(), this.getY(), this.getZ(),
                        Math.cos(x * 20) * 1.15d, Math.cos(y * 20) * 1.10d, Math.sin(x * 20) * 1.15d);
            }
        }
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (this.getWorld().isClient()) {
            return;
        }
        if (hitResult.getType() == HitResult.Type.ENTITY && hitResult instanceof EntityHitResult entityHitResult) {
            Entity target = entityHitResult.getEntity();
            Entity owner = this.getOwner();

            if (owner != target) {
                this.dataTracker.set(HIT, true);
                totalTicksToLive = this.age + 5;
            }
        } else if (hitResult.getType() == HitResult.Type.BLOCK) {
            this.dataTracker.set(HIT, true);
            totalTicksToLive = this.age + 5;
        }
    }

    @Override
    public boolean hasNoGravity() {
        return true;
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(HIT, false);
    }
}