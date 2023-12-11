package net.nevixity.nevixitysmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.nevixity.nevixitysmod.block.ModBlocks;
import net.nevixity.nevixitysmod.entity.ModEntityTypes;
import net.nevixity.nevixitysmod.item.ModItems;

public class ModLanguageProvider extends FabricLanguageProvider {
    public ModLanguageProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.ODIUM_INGOT, "Odium Ingot");
        translationBuilder.add(ModItems.ODIUM_SCRAP, "Odium Scrap");
        translationBuilder.add(ModItems.ODIUM_APPLE, "Odium Apple");
        translationBuilder.add(ModItems.ODIUM_SCYTHE, "Odium Scythe");
        translationBuilder.add(ModItems.ODIUM_PICKAXE, "Odium Pickaxe");
        translationBuilder.add(ModItems.ODIUM_HAMMER, "Odium Hammer");
        translationBuilder.add(ModItems.REDPANDA_SPAWN_EGG, "Red Panda Spawn Egg");
        translationBuilder.add(ModItems.CAPYBARA_SPAWN_EGG, "Capybara Spawn Egg");
        translationBuilder.add(ModItems.BRUTE_BOSS_SPAWN_EGG, "Brute Spawn Egg");
        translationBuilder.add(ModItems.SMOKE_BOMB, "Smoke Bomb");
        translationBuilder.add(ModItems.RAW_ODIUM, "Raw Odium");
        translationBuilder.add(ModItems.MUSIC_DISC_AUTUMN_FALLS, "Music Disc");

        translationBuilder.add(ModItems.MUSIC_DISC_AUTUMN_FALLS.getTranslationKey() + ".desc", "Nevixity - Autumn Falls");
        translationBuilder.add(ModItems.ODIUM_SCYTHE.getTranslationKey() + ".tooltip", "Shoots Toxic Odium Flame Upon Right Click");

        translationBuilder.add(ModBlocks.ODIUM_BLOCK, "Block Of Odium");
        translationBuilder.add(ModBlocks.ODIUM_ORE, "Odium Ore");

        translationBuilder.add(ModEntityTypes.BRUTE_BOSS, "Piglin Brute Boss");
        translationBuilder.add(ModEntityTypes.REDPANDA, "Red Panda");
        translationBuilder.add(ModEntityTypes.CAPYBARA, "Capybara");
        translationBuilder.add(ModEntityTypes.ODIUM_HAMMER, "Odium Hammer");
        translationBuilder.add(ModEntityTypes.SCYTHE_CHARGE_PROJECTILE, "Thrown Scythe Charge");
        translationBuilder.add(ModEntityTypes.SMOKE_BOMB_PROJECTILE, "Thrown Smoke Bomb");
    }
}
