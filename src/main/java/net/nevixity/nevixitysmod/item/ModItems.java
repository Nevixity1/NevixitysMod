package net.nevixity.nevixitysmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.nevixity.nevixitysmod.NevixitysMod;
import net.nevixity.nevixitysmod.entity.ModEntityTypes;
import net.nevixity.nevixitysmod.item.custom.OdiumHammerItem;
import net.nevixity.nevixitysmod.item.custom.OdiumScytheItem;
import net.nevixity.nevixitysmod.item.custom.SmokeBombItem;
import net.nevixity.nevixitysmod.sound.ModSoundEvents;

public class ModItems {
    public static final Item ODIUM_INGOT = registerItem("odium_ingot", new Item(new FabricItemSettings().rarity(Rarity.EPIC).fireproof()));
    public static final Item ODIUM_SCRAP = registerItem("odium_scrap", new Item(new FabricItemSettings().rarity(Rarity.EPIC)));
    public static final Item ODIUM_APPLE = registerItem("odium_apple", new Item(new FabricItemSettings().rarity(Rarity.EPIC).food(ModFoodComponents.ODIUM_APPLE).fireproof()));
    public static final Item RAW_ODIUM = registerItem("raw_odium", new Item(new FabricItemSettings().rarity(Rarity.EPIC)));
    public static final Item ODIUM_PICKAXE = registerItem("odium_pickaxe", new PickaxeItem(ModToolMaterials.ODIUM, -1, -2f,
            new FabricItemSettings().rarity(Rarity.EPIC).fireproof()));
    public static final Item ODIUM_SCYTHE = registerItem("odium_scythe", new OdiumScytheItem(ModToolMaterials.ODIUM, 4, -2.5f,
            new FabricItemSettings().rarity(Rarity.EPIC).fireproof()));
    public static final Item REDPANDA_SPAWN_EGG = registerItem("redpanda_spawn_egg", new SpawnEggItem(ModEntityTypes.REDPANDA, 0xa53314, 0x3b260f,
            new FabricItemSettings()));
    public static final Item CAPYBARA_SPAWN_EGG = registerItem("capybara_spawn_egg", new SpawnEggItem(ModEntityTypes.CAPYBARA, 0xa577755, 0x3b260f,
            new FabricItemSettings()));

    public static final Item BRUTE_BOSS_SPAWN_EGG = registerItem("brute_boss_spawn_egg", new SpawnEggItem(ModEntityTypes.BRUTE_BOSS, 0xa764785, 0x3b260f,
            new FabricItemSettings()));
    public static final Item ODIUM_HAMMER = registerItem("odium_hammer", new OdiumHammerItem(new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
    public static final Item MUSIC_DISC_AUTUMN_FALLS = registerItem("music_disc_autumn_falls", new MusicDiscItem(9,
            ModSoundEvents.AUTUMN_FALLS_DISC, new FabricItemSettings().rarity(Rarity.RARE).maxCount(1), 23));
    public static final Item SMOKE_BOMB = registerItem("smoke_bomb", new SmokeBombItem(new FabricItemSettings().rarity(Rarity.RARE).maxCount(16)));

    private static void addItemsToIngredientsItemGroup(FabricItemGroupEntries entries) {

    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(NevixitysMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        NevixitysMod.LOGGER.info("Registering ModItems for " + NevixitysMod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientsItemGroup);
    }
}