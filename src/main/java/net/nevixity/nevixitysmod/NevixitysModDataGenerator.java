package net.nevixity.nevixitysmod;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import net.nevixity.nevixitysmod.datagen.*;
import net.nevixity.nevixitysmod.world.ModConfiguredFeatures;
import net.nevixity.nevixitysmod.world.ModPlacedFeatures;

public class NevixitysModDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModWorldGenerator::new);
        pack.addProvider(ModItemTagProvider::new);
        pack.addProvider(ModAdvancementProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModLanguageProvider::new);
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
    }
}
