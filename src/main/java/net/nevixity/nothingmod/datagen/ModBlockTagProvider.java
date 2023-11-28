package net.nevixity.nothingmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.nevixity.nothingmod.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.ODIUM_BLOCK)
                .add(ModBlocks.ODIUM_ORE);
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE);
        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE);
        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE);
        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL);
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL);
        getOrCreateTagBuilder(TagKey.of(Registries.BLOCK.getKey(), new Identifier("fabric", "needs_tool_level_4")));
        getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS)
                .add(ModBlocks.ODIUM_BLOCK);

    }
}
