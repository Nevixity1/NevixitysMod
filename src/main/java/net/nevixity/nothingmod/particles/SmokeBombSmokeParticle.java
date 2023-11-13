package net.nevixity.nothingmod.particles;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

public class SmokeBombSmokeParticle extends SpriteBillboardParticle {
    public SmokeBombSmokeParticle(ClientWorld world, double x, double y, double z, SpriteProvider spriteset, double velocityX, double velocityY, double velocityZ) {
        super(world, x, y, z, velocityX, velocityY, velocityZ);

        this.velocityMultiplier = 0.10f;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.velocityZ = velocityZ;

        this.scale += 3f;
        this.maxAge = 300;
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
            return new SmokeBombSmokeParticle(clientWorld, x ,y ,z, this.sprites, velocityX, velocityY, velocityZ);
        }
    }
}
