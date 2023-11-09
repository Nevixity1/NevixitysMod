package net.nevixity.nothingmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.nevixity.nothingmod.Entity.ModEntities;
import net.nevixity.nothingmod.Entity.client.*;
import net.nevixity.nothingmod.Entity.layer.ModModelLayers;
import net.nevixity.nothingmod.particles.ModParticles;
import net.nevixity.nothingmod.particles.ScytheChargeFlameParticle;
import net.nevixity.nothingmod.particles.SmokeBombSmokeParticle;

public class NothingModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {


        ParticleFactoryRegistry.getInstance().register(ModParticles.SCYTHE_CHARGE_FLAME_PARTICLE, ScytheChargeFlameParticle.Factory::new);

        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SCYTHE_CHARGE_PROJECTILE, ScytheChargeProjectileModel::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.SCYTHE_CHARGE_PROJECTILE, ScytheChargeProjectileRenderer::new);

      EntityModelLayerRegistry.registerModelLayer(ModModelLayers.REDPANDA, RedpandaModel::getTexturedModelData);

      EntityRendererRegistry.register(ModEntities.REDPANDA, RedpandaRenderer::new);

        EntityRendererRegistry.register(ModEntities.SMOKE_BOMB_PROJECTILE, FlyingItemEntityRenderer::new);

        ParticleFactoryRegistry.getInstance().register(ModParticles.SMOKE_BOMB_SMOKE, SmokeBombSmokeParticle.Factory::new);

        EntityRendererRegistry.register(ModEntities.CAPYBARA, CapybaraRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.CAPYBARA, CapybaraModel::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.ODIUM_HAMMER, OdiumHammerRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.ODIUM_HAMMER, OdiumHammerModel::getTexturedModelData);




    }
}
