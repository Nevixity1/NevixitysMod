package net.nevixity.nothingmod.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.nevixity.nothingmod.Entity.custom.ScytheChargeProjectileEntity;

public class OdiumScytheItem extends SwordItem {

    public OdiumScytheItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemstack = user.getStackInHand(hand);

        user.getItemCooldownManager().set(this, 80);

        if (!world.isClient()) {
             ScytheChargeProjectileEntity scytheChargeProjectile = new ScytheChargeProjectileEntity(world, user);
            scytheChargeProjectile.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 0.25F);
            world.spawnEntity(scytheChargeProjectile);
         }

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!user.getAbilities().creativeMode) {
            itemstack.damage(1, user, p -> p.sendToolBreakStatus(hand));
        }

        return TypedActionResult.success(itemstack, world.isClient());
    }
}