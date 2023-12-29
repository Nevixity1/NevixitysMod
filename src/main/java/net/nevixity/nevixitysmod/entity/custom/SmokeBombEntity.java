package net.nevixity.nevixitysmod.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;
import net.nevixity.nevixitysmod.entity.ModEntityTypes;
import net.nevixity.nevixitysmod.particles.ModParticles;


public class SmokeBombEntity extends ThrownItemEntity {
    public SmokeBombEntity(EntityType<? extends SmokeBombEntity> entityType, World world) {
        super(entityType, world);
    }

    public SmokeBombEntity(LivingEntity owner, World world) {
        super(ModEntityTypes.SMOKE_BOMB_PROJECTILE, owner, world);
    }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }

    @Override
    protected Item getDefaultItem() {
        return null;
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {

        BlockState blockState = this.getWorld().getBlockState(blockHitResult.getBlockPos());
        blockState.onProjectileHit(this.getWorld(), blockState, blockHitResult, this);

        for (int x = 0; x < 18; ++x) {
            for (int y = 0; y < 18; ++y) {
                this.getWorld().addParticle(ModParticles.SMOKE_BOMB_SMOKE, this.getX(), this.getY(), this.getZ(),
                        Math.cos(x * 20) * 3.15d, Math.cos(y * 3) * 3.10d, Math.sin(x * 20) * 3.15d);
            }
        }

        super.onBlockHit(blockHitResult);
    }
}

