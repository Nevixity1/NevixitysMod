package net.nevixity.nevixitysmod.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.nevixity.nevixitysmod.NevixitysMod;

public class ModSoundEvents {

    public static final SoundEvent AUTUMN_FALLS_DISC = registerSoundEvent("autumn_falls_disc");

    private static SoundEvent registerSoundEvent(String id) {
        Identifier identifier = new Identifier(NevixitysMod.MOD_ID, id);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }

    public static void registerModSounds() {
        NevixitysMod.LOGGER.info("Registering ModSoundEvents for " + NevixitysMod.MOD_ID);
    }
}
