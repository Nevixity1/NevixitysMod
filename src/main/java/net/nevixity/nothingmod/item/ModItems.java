package net.nevixity.nothingmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.nevixity.nothingmod.Entity.ModEntities;
import net.nevixity.nothingmod.NothingMod;
import net.nevixity.nothingmod.item.custom.OdiumScytheItem;
import net.nevixity.nothingmod.item.custom.SmokeBombItem;
import net.nevixity.nothingmod.item.custom.OdiumHammerItem;
import net.nevixity.nothingmod.sound.ModSounds;

public class ModItems {
public static final Item ODIUM_INGOT = registerItem("odium_ingot", new Item(new FabricItemSettings().rarity(Rarity.EPIC).fireproof()));
public static final Item ODIUM_SCRAP = registerItem("odium_scrap", new Item(new FabricItemSettings().rarity(Rarity.EPIC)));
public static final Item ODIUM_APPLE = registerItem("odium_apple", new Item(new FabricItemSettings().rarity(Rarity.EPIC).food(ModFoodComponents.ODIUM_APPLE).fireproof()));

public static final Item RAW_ODIUM = registerItem("raw_odium", new Item(new FabricItemSettings().rarity(Rarity.EPIC)));
private static void addItemsToIngredientsItemGroup(FabricItemGroupEntries entries) {


}

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(NothingMod.MOD_ID, name),item);
    }

    public static final Item ODIUM_PICKAXE =registerItem("odium_pickaxe",
        new PickaxeItem(ModToolMaterial.ODIUM, -1, -2f, new FabricItemSettings().rarity(Rarity.EPIC).fireproof()));

    public static final Item ODIUM_SCYTHE =registerItem("odium_scythe",
            new OdiumScytheItem (ModToolMaterial.ODIUM, 4, -2.5f, new FabricItemSettings().rarity(Rarity.EPIC).fireproof()));

    public static final Item REDPANDA_SPAWN_EGG =registerItem("redpanda_spawn_egg",
            new SpawnEggItem (ModEntities.REDPANDA, 0xa53314, 0x3b260f, new FabricItemSettings()));

    public static final Item CAPYBARA_SPAWN_EGG =registerItem("capybara_spawn_egg",
            new SpawnEggItem (ModEntities.CAPYBARA, 0xa555555, 0x3b260f, new FabricItemSettings()));

    public static final Item ODIUM_HAMMER =registerItem("odium_hammer",
            new OdiumHammerItem(ModToolMaterial.ODIUM, 6, -2.5f, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));


    public static final Item AUTUMN_FALLS_MUSIC_DISC =registerItem("autumn_falls_music_disc",
            new MusicDiscItem(9, ModSounds.AUTUMN_FALLS_DISC, new FabricItemSettings().rarity(Rarity.RARE).maxCount(1), 23));
public static final Item SMOKE_BOMB =registerItem("smoke_bomb",
        new SmokeBombItem(new FabricItemSettings().rarity(Rarity.RARE).maxCount(16)));

    public static void registerModItems() {
          NothingMod.LOGGER.info("Registering Mod Items for" + NothingMod.MOD_ID);

   ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientsItemGroup);
  }
}