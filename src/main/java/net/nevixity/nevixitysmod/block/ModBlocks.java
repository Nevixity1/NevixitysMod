package net.nevixity.nevixitysmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.nevixity.nevixitysmod.NevixitysMod;

public class ModBlocks {
    public static final Block ODIUM_BLOCK = registerBlock("odium_block", new Block(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)),
            new FabricItemSettings().fireproof().rarity(Rarity.EPIC));

    public static final Block ODIUM_ORE = registerBlock("odium_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.MEDIUM_AMETHYST_BUD), UniformIntProvider.create(4, 7)),
            new FabricItemSettings().fireproof().rarity(Rarity.EPIC));

    private static Block registerBlock(String id, Block block) {
        registerBlockItem(id, block);
        return Registry.register(Registries.BLOCK, new Identifier(NevixitysMod.MOD_ID, id), block);
    }

    private static Block registerBlock(String id, Block block, FabricItemSettings settings) {
        registerBlockItem(id, block, settings);
        return Registry.register(Registries.BLOCK, new Identifier(NevixitysMod.MOD_ID, id), block);
    }

    private static Item registerBlockItem(String id, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(NevixitysMod.MOD_ID, id), new BlockItem(block, new FabricItemSettings()));
    }
    private static Item registerBlockItem(String id, Block block, FabricItemSettings settings) {
        return Registry.register(Registries.ITEM, new Identifier(NevixitysMod.MOD_ID, id), new BlockItem(block, settings));
    }

    public static void registerModBlocks() {
        NevixitysMod.LOGGER.info("Registering ModBlocks for " + NevixitysMod.MOD_ID);
    }
}
