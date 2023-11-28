package net.nevixity.nevixitysmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.util.Identifier;
import net.nevixity.nevixitysmod.block.ModBlocks;
import net.nevixity.nevixitysmod.item.ModItems;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ODIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ODIUM_BLOCK);
        blockStateModelGenerator.registerParentedItemModel(ModItems.CAPYBARA_SPAWN_EGG, new Identifier("item/template_spawn_egg"));
        blockStateModelGenerator.registerParentedItemModel(ModItems.REDPANDA_SPAWN_EGG, new Identifier("item/template_spawn_egg"));
        blockStateModelGenerator.registerParentedItemModel(ModItems.BRUTE_BOSS_SPAWN_EGG, new Identifier("item/template_spawn_egg"));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.ODIUM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ODIUM_APPLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ODIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.ODIUM_SCRAP, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_ODIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.SMOKE_BOMB, Models.GENERATED);
        itemModelGenerator.register(ModItems.MUSIC_DISC_AUTUMN_FALLS, Models.GENERATED);
    }
}
