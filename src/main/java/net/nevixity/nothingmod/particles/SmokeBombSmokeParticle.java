package net.nevixity.nothingmod.particles;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

public class SmokeBombSmokeParticle extends SpriteBillboardParticle {
    public SmokeBombSmokeParticle(ClientWorld world, double xcoord, double ycoord, double zcoord,
                                     SpriteProvider spriteset, double xd, double yd, double zd) {
        super(world, xcoord, ycoord, zcoord, xd, yd, zd);

        this.velocityMultiplier = 0.10f;
        this.velocityX = xd;
        this.velocityY = yd;
        this.velocityZ = zd;


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

        public Particle createParticle(DefaultParticleType particleType, ClientWorld clientWorld,
                                       double x, double y, double z, double xd, double yd, double zd) {

            return new SmokeBombSmokeParticle(clientWorld, x ,y ,z, this.sprites, xd, yd, zd);
        }
    }

}
