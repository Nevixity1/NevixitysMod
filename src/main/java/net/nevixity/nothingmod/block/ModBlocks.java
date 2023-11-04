package net.nevixity.nothingmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AmethystBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.nevixity.nothingmod.NothingMod;

public class ModBlocks {
public static final Block ODIUM_BLOCK = registerBlock("odium_block",
        new Block(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block ODIUM_ORE_BLOCK = registerBlock("odium_ore_block",
            new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.MEDIUM_AMETHYST_BUD)));

private static Block registerBlock(String name, Block block) {
    registerBlockItem(name, block);
    return Registry.register(Registries.BLOCK, new Identifier(NothingMod.MOD_ID, name), block);
}
    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(NothingMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().fireproof()));
    }
    public static void registerModBlocks() {
        NothingMod.LOGGER.info("Registering ModBlocks for" + NothingMod.MOD_ID);
    }
}
