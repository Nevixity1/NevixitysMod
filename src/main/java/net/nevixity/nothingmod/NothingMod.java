package net.nevixity.nothingmod;

import net.fabricmc.api.ModInitializer;

import net.nevixity.nothingmod.Entity.ModEntities;
import net.nevixity.nothingmod.block.ModBlocks;
import net.nevixity.nothingmod.datagen.ModWorldGenerator;
import net.nevixity.nothingmod.item.ModItemGroups;
import net.nevixity.nothingmod.item.ModItems;
import net.nevixity.nothingmod.particles.ModParticles;
import net.nevixity.nothingmod.sound.ModSounds;
import net.nevixity.nothingmod.util.ModRegistries;
import net.nevixity.nothingmod.world.ModOrePlacement;
import net.nevixity.nothingmod.world.ModPlacedFeatures;
import net.nevixity.nothingmod.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NothingMod implements ModInitializer {
	public static final String MOD_ID = "nevixitysmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModParticles.registerParticles();
		ModEntities.registerModEntites();
		ModRegistries.registerModStuffs();
		ModWorldGeneration.generateModWorldGeneration();
		ModSounds.registersounds();
	}
}