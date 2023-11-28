package net.nevixity.nevixitysmod.particles;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

public class ScytheChargeFlameParticle extends SpriteBillboardParticle {
    public ScytheChargeFlameParticle(ClientWorld world, double x, double y, double z, SpriteProvider spriteset, double velocityX, double velocityY, double velocityZ) {
        super(world, x, y, z, velocityX, velocityY, velocityZ);

        this.velocityMultiplier = 0.2f;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.velocityZ = velocityZ;

        this.scale += 0.25f;
        this.maxAge = 15;
        this.setSpriteForAge(spriteset);
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }


    public static class Factory implements ParticleFactory<DefaultParticleType> {
        private final SpriteProvider sprites;

        public Factory(SpriteProvider spriteProvider) {
            this.sprites = spriteProvider;
        }

        public Particle createParticle(DefaultParticleType particleType, ClientWorld clientWorld, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
            return new ScytheChargeFlameParticle(clientWorld, x, y, z, this.sprites, velocityX, velocityY, velocityZ);
        }
    }
}
