package net.nevixity.nevixitysmod.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.nevixity.nevixitysmod.entity.custom.RedpandaEntity;
import net.nevixity.nevixitysmod.entity.layer.ModModelLayers;
import net.nevixity.nevixitysmod.NevixitysMod;

public class RedpandaRenderer extends MobEntityRenderer<RedpandaEntity, RedpandaModel<RedpandaEntity>> {

    private static final Identifier TEXTURE = new Identifier(NevixitysMod.MOD_ID, "textures/entity/redpanda.png");

    public RedpandaRenderer(EntityRendererFactory.Context ctx) {
        super(ctx,new RedpandaModel<>(ctx.getPart(ModModelLayers.REDPANDA)), 0.3f);
    }

    @Override
    public Identifier getTexture(RedpandaEntity entity) {
        return TEXTURE;
    }


    @Override
    public void render(RedpandaEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {


    if (livingEntity.isBaby()) {
        matrixStack.scale(0.5f,0.5f, 0.5f);
    }else {
        matrixStack.scale(1f,1f,1f);
    }

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
