package net.nevixity.nothingmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.nevixity.nothingmod.NothingMod;

public class ModBlocks {
    public static final Block ODIUM_BLOCK = registerBlock("odium_block", new Block(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block ODIUM_ORE = registerBlock("odium_ore", new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.MEDIUM_AMETHYST_BUD)),
            new FabricItemSettings().fireproof().rarity(Rarity.EPIC));

    private static Block registerBlock(String id, Block block) {
        registerBlockItem(id, block);
        return Registry.register(Registries.BLOCK, new Identifier(NothingMod.MOD_ID, id), block);
    }

    private static Block registerBlock(String id, Block block, FabricItemSettings settings) {
        registerBlockItem(id, block, settings);
        return Registry.register(Registries.BLOCK, new Identifier(NothingMod.MOD_ID, id), block);
    }

    private static Item registerBlockItem(String id, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(NothingMod.MOD_ID, id), new BlockItem(block, new FabricItemSettings()));
    }
    private static Item registerBlockItem(String id, Block block, FabricItemSettings settings) {
        return Registry.register(Registries.ITEM, new Identifier(NothingMod.MOD_ID, id), new BlockItem(block, settings));
    }

    public static void registerModBlocks() {
        NothingMod.LOGGER.info("Registering ModBlocks for" + NothingMod.MOD_ID);
    }
}
