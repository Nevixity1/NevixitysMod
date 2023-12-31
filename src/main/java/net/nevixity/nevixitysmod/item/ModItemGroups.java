package net.nevixity.nevixitysmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.nevixity.nevixitysmod.NevixitysMod;
import net.nevixity.nevixitysmod.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup NEVIXITYS_MOD = Registry.register(Registries.ITEM_GROUP,
            new Identifier(NevixitysMod.MOD_ID, "nevixitys_mod"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemGroup.nevixitys_mod"))
                    .icon(() -> new ItemStack(ModItems.ODIUM_APPLE))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.ODIUM_INGOT);
                        entries.add(ModBlocks.ODIUM_BLOCK);
                        entries.add(ModBlocks.ODIUM_ORE);
                        entries.add(ModItems.RAW_ODIUM);
                        entries.add(ModItems.MUSIC_DISC_AUTUMN_FALLS);
                        entries.add(ModItems.ODIUM_SCRAP);
                        entries.add(ModItems.ODIUM_APPLE);
                        entries.add(ModItems.ODIUM_HAMMER);
                        entries.add(ModItems.ODIUM_SCYTHE);
                        entries.add(ModItems.ODIUM_PICKAXE);
                        entries.add(ModItems.REDPANDA_SPAWN_EGG);
                        entries.add(ModItems.SMOKE_BOMB);
                        entries.add(ModItems.CAPYBARA_SPAWN_EGG);
                        entries.add(ModItems.BRUTE_BOSS_SPAWN_EGG);
                    }).build());

    public static void registerItemGroups() {
        NevixitysMod.LOGGER.info("Registering Item Groups for " + NevixitysMod.MOD_ID);
    }
}
