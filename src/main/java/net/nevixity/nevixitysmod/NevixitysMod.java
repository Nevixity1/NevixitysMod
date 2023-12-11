package net.nevixity.nevixitysmod;

import net.fabricmc.api.ModInitializer;
import net.nevixity.nevixitysmod.block.ModBlocks;
import net.nevixity.nevixitysmod.entity.ModEntityTypes;
import net.nevixity.nevixitysmod.item.ModItemGroups;
import net.nevixity.nevixitysmod.item.ModItems;
import net.nevixity.nevixitysmod.particles.ModParticles;
import net.nevixity.nevixitysmod.sound.ModSoundEvents;
import net.nevixity.nevixitysmod.util.ModRegistries;
import net.nevixity.nevixitysmod.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NevixitysMod implements ModInitializer {
	public static final String MOD_ID = "nevixitysmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModParticles.registerParticles();
		ModEntityTypes.registerModEntityTypes();
		ModRegistries.registerModStuffs();
		ModWorldGeneration.generateModWorldGeneration();
		ModSoundEvents.registerModSounds();
	}
}