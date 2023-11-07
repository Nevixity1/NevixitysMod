package net.nevixity.nothingmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementDisplay;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.nevixity.nothingmod.NothingMod;
import net.nevixity.nothingmod.item.ModItems;

import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {
    public ModAdvancementProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(Consumer<Advancement> consumer) {
     Advancement rootAdvancement = Advancement.Builder.create()
             .display(new AdvancementDisplay(new ItemStack(ModItems.RAW_ODIUM),
                     Text.literal("This Is New"),Text.literal("Obtain Raw Odium"),
                     new Identifier(NothingMod.MOD_ID, "block/odium_block"), AdvancementFrame.TASK,
                     true, true, false))
             .criterion("has_raw_odium", InventoryChangedCriterion.Conditions.items(ModItems.RAW_ODIUM))
             .build(consumer, NothingMod.MOD_ID + ":nevixitysmod");
    }
}
