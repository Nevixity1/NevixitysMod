package net.nevixity.nevixitysmod.entity.ai;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.Hand;
import net.nevixity.nevixitysmod.entity.custom.CapybaraEntity;

public class CapybaraAttackGoal extends MeleeAttackGoal {
    private final CapybaraEntity entity;
    private int attackDelay = 6;
    private int ticksUntilNextAttack = 6;
    private boolean shouldCountTillNextAttack = false;


    public CapybaraAttackGoal(PathAwareEntity mob, double speed, boolean pauseWhenMobIdle) {
        super(mob, speed, pauseWhenMobIdle);
        entity = ((CapybaraEntity) mob);
    }

    @Override
    public void start() {
        super.start();
        attackDelay = 6;
        ticksUntilNextAttack = 6;
    }


    @Override
    protected void attack(LivingEntity target, double squaredDistance) {
        if (isEnemyWithinAttackDistance(target, squaredDistance)) {
            shouldCountTillNextAttack = true;

            if (isTimeToStartAttackAnimation()) {
                entity.setAttacking(true);
            }

            if (isTimeToAttack()) {
                this.mob.getLookControl().lookAt(target.getX(), target.getEyeY(), target.getZ());
                performAttack(target);
            }
        } else {
            resetAttackCooldown();
            shouldCountTillNextAttack = false;
            entity.setAttacking(false);
            entity.attackAnimationTimeout = 0;
        }
    }


    private boolean isEnemyWithinAttackDistance(LivingEntity target, double squaredDistance) {
        return squaredDistance <= this.getSquaredMaxAttackDistance(target);
    }

    protected void resetAttackCooldown() {
        this.ticksUntilNextAttack = this.getTickCount(attackDelay * 2);
    }

    protected boolean isTimeToStartAttackAnimation() {
        return this.ticksUntilNextAttack <= attackDelay;
    }


    protected void performAttack(LivingEntity pEnemy) {
        this.resetAttackCooldown();
        this.mob.swingHand(Hand.MAIN_HAND);
        this.mob.tryAttack(pEnemy);
    }


    protected boolean isTimeToAttack() {
        return this.ticksUntilNextAttack <= 0;
    }


    @Override
    public void tick() {
        super.tick();
        if (shouldCountTillNextAttack) {
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
        }
    }

    @Override
    public void stop() {
        entity.setAttacking(false);
        super.stop();
    }
}
