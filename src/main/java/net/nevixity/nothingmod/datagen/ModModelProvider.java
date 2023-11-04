package net.nevixity.nothingmod.datagen;

import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.nevixity.nothingmod.item.ModItems;

public class ModModelProvider {

    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.ODIUM_PICKAXE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.ODIUM_SCYTHE, Models.HANDHELD);




    }
}
