package net.nevixity.nothingmod.Entity.ai;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.Hand;
import net.nevixity.nothingmod.Entity.custom.RedpandaEntity;

public class RedpandaAttackGoal extends MeleeAttackGoal {
    private final RedpandaEntity entity;
    private int attackDelay = 6;
    private int ticksUntilNextAttack = 6;
    private boolean shouldCountTillNextAttack = false;




    public RedpandaAttackGoal(PathAwareEntity mob, double speed, boolean pauseWhenMobIdle) {
        super(mob, speed, pauseWhenMobIdle);
    entity = ((RedpandaEntity) mob);

    }

    @Override
    public void start() {
        super.start();
      attackDelay = 6;
      ticksUntilNextAttack = 6;

    }


    @Override
    protected void attack(LivingEntity pEnemy, double pDistToEnemySqr) {
        if (isEnemyWithinAttackDistance(pEnemy, pDistToEnemySqr)) {
            shouldCountTillNextAttack = true;

            if(isTimeToStartAttackAnimation()) {
                entity.setAttacking(true);
            }

            if(isTimeToAttack()) {
                this.mob.getLookControl().lookAt(pEnemy.getX(), pEnemy.getEyeY(), pEnemy.getZ());
                performAttack(pEnemy);
            }
        } else {
            resetAttackCooldown();
            shouldCountTillNextAttack = false;
            entity.setAttacking(false);
            entity.attackAnimationTimeout = 0;
        }
    }



    private boolean isEnemyWithinAttackDistance(LivingEntity pEnemy, double pDistToEnemySqr){
      return pDistToEnemySqr <= this.getSquaredMaxAttackDistance(pEnemy);
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
     if(shouldCountTillNextAttack) {
         this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
     }


    }

    @Override
    public void stop() {
        entity.setAttacking(false);
        super.stop();



    }
}
