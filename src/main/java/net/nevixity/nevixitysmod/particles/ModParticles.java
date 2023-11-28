package net.nevixity.nevixitysmod.particles;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.nevixity.nevixitysmod.NevixitysMod;

public class ModParticles {
    public static final DefaultParticleType SCYTHE_CHARGE_FLAME_PARTICLE = registerParticle("scythe_charge_flame_particle", FabricParticleTypes.simple());
    public static final DefaultParticleType SMOKE_BOMB_SMOKE = registerParticle("smoke_bomb_smoke_particle", FabricParticleTypes.simple());

    private static DefaultParticleType registerParticle(String id, DefaultParticleType particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, new Identifier(NevixitysMod.MOD_ID, id), particleType);
    }

    public static void registerParticles() {
        NevixitysMod.LOGGER.info("Registering Particles for " + NevixitysMod.MOD_ID);
    }
}
