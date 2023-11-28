package net.nevixity.nothingmod.mixin;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.BeaconScreen;
import net.minecraft.item.ItemStack;
import net.nevixity.nothingmod.item.ModItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BeaconScreen.class)
public class BeaconScreenMixin {
    @Inject(at = @At("TAIL"), method = "drawBackground")
    private void drawBackground(DrawContext context, float delta, int mouseX, int mouseY, CallbackInfo ci) {
        int i = (((BeaconScreen) (Object) this).width - 230) / 2;
        int j = (((BeaconScreen) (Object) this).height - 219) / 2;
        context.getMatrices().push();
        context.getMatrices().translate(0.0f, 0.0f, 100.0f);
        context.drawItem(new ItemStack(ModItems.ODIUM_INGOT), i - 2, j + 109);
        context.getMatrices().pop();
    }
}