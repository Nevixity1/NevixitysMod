package net.nevixity.nevixitysmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementDisplay;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.nevixity.nevixitysmod.NevixitysMod;
import net.nevixity.nevixitysmod.item.ModItems;

import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {
    public ModAdvancementProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(Consumer<Advancement> consumer) {
        Advancement rootAdvancement = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModItems.RAW_ODIUM),
                        Text.literal("This Is New"), Text.literal("Obtain Raw Odium"),
                        new Identifier(NevixitysMod.MOD_ID, "textures/block/odium_block.png"),
                        AdvancementFrame.TASK, true, true, false))
                .criterion("has_raw_odium", InventoryChangedCriterion.Conditions.items(ModItems.RAW_ODIUM))
                .build(consumer, NevixitysMod.MOD_ID + ":raw_odium");
    }
}
