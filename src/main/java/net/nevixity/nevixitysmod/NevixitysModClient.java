package net.nevixity.nevixitysmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.nevixity.nevixitysmod.entity.ModEntities;
import net.nevixity.nevixitysmod.entity.client.*;
import net.nevixity.nevixitysmod.entity.layer.ModModelLayers;
import net.nevixity.nevixitysmod.particles.ModParticles;
import net.nevixity.nevixitysmod.particles.ScytheChargeFlameParticle;
import net.nevixity.nevixitysmod.particles.SmokeBombSmokeParticle;

public class NevixitysModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ParticleFactoryRegistry.getInstance().register(ModParticles.SCYTHE_CHARGE_FLAME_PARTICLE, ScytheChargeFlameParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.SMOKE_BOMB_SMOKE, SmokeBombSmokeParticle.Factory::new);

        EntityRendererRegistry.register(ModEntities.SCYTHE_CHARGE_PROJECTILE, ScytheChargeProjectileRenderer::new);
        EntityRendererRegistry.register(ModEntities.REDPANDA, RedpandaRenderer::new);
        EntityRendererRegistry.register(ModEntities.SMOKE_BOMB_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.CAPYBARA, CapybaraRenderer::new);
        EntityRendererRegistry.register(ModEntities.ODIUM_HAMMER, OdiumHammerEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.BRUTE_BOSS, BruteBossRenderer::new);


        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SCYTHE_CHARGE_PROJECTILE, ScytheChargeProjectileModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.REDPANDA, RedpandaModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.CAPYBARA, CapybaraModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.ODIUM_HAMMER, OdiumHammerEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.BRUTE_BOSS, BruteBossModel::getTexturedModelData);

    }
}