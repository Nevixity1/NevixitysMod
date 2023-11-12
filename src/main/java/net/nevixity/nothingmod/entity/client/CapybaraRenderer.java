package net.nevixity.nothingmod.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.nevixity.nothingmod.NothingMod;
import net.nevixity.nothingmod.entity.custom.CapybaraEntity;
import net.nevixity.nothingmod.entity.layer.ModModelLayers;

public class CapybaraRenderer extends MobEntityRenderer<CapybaraEntity, CapybaraModel<CapybaraEntity>> {

    private static final Identifier TEXTURE = new Identifier(NothingMod.MOD_ID, "textures/entity/capybara.png");

    public CapybaraRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new CapybaraModel<>(ctx.getPart(ModModelLayers.CAPYBARA)), 0.3f);
    }

    @Override
    public Identifier getTexture(CapybaraEntity entity) {
        return TEXTURE;
    }


    @Override
    public void render(CapybaraEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if (livingEntity.isBaby()) {
            matrixStack.scale(0.7f, 0.7f, 0.7f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }
        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
