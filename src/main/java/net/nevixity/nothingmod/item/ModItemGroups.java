package net.nevixity.nothingmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.nevixity.nothingmod.NothingMod;
import net.nevixity.nothingmod.block.ModBlocks;

public class ModItemGroups {
public static final ItemGroup ODIUM_GROUP = Registry.register(Registries.ITEM_GROUP,
        new Identifier(NothingMod.MOD_ID,"odium"),
        FabricItemGroup.builder().displayName(Text.translatable("Nevixity's Mod"))
                .icon(() -> new ItemStack(ModItems.ODIUM_APPLE)).entries((displayContext, entries) -> {

                    entries.add(ModItems.ODIUM_INGOT);
                   entries.add(ModBlocks.ODIUM_BLOCK);
                    entries.add(ModBlocks.ODIUM_ORE);
                     entries.add(ModItems.RAW_ODIUM);
                       entries.add(ModItems.AUTUMN_FALLS_MUSIC_DISC);
                   entries.add(ModItems.ODIUM_SCRAP);
                   entries.add(ModItems.ODIUM_APPLE);
                  entries.add(ModItems.ODIUM_HAMMER);
                    entries.add(ModItems.ODIUM_SCYTHE);
                    entries.add(ModItems.ODIUM_PICKAXE);
                    entries.add(ModItems.REDPANDA_SPAWN_EGG);
                    entries.add(ModItems.SMOKE_BOMB);
                    entries.add(ModItems.CAPYBARA_SPAWN_EGG);



                }).build());

    public static void registerItemGroups() {
        NothingMod.LOGGER.info("Registering Item Groups for" + NothingMod.MOD_ID);
    }
}
