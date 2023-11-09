package net.nevixity.nothingmod.Entity.client;

import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.nevixity.nothingmod.Entity.custom.OdiumHammerEntity;
import net.nevixity.nothingmod.Entity.layer.ModModelLayers;
import net.nevixity.nothingmod.NothingMod;

public class OdiumHammerRenderer extends EntityRenderer<OdiumHammerEntity> {
    public static final Identifier TEXTURE = new Identifier(NothingMod.MOD_ID, "textures/entity/odium_hammer_entity.png");
    protected OdiumHammerModel model;

    public OdiumHammerRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
        model = new OdiumHammerModel(ctx.getPart(ModModelLayers.ODIUM_HAMMER));
    }

    @Override
    public void render(OdiumHammerEntity entity, float yaw, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light) {
        matrices.push();
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp(tickDelta, entity.prevYaw, entity.getYaw()) - 90.0F));
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(MathHelper.lerp(tickDelta, entity.prevPitch, entity.getPitch()) + 90.0F));
        VertexConsumer vertexconsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumers, this.model.getLayer(TEXTURE), false, false);
        this.model.render(matrices, vertexconsumer, light, OverlayTexture.DEFAULT_UV, 5.0F, 5.0F, 5.0F, 5.0F);

        matrices.pop();
        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
    }

    @Override
    public Identifier getTexture(OdiumHammerEntity entity) {
        return TEXTURE;
    }
}
