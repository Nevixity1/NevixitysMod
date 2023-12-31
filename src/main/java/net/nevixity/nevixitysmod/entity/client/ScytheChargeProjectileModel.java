package net.nevixity.nevixitysmod.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class ScytheChargeProjectileModel extends EntityModel<Entity> {
    private final ModelPart bb_main;

    public ScytheChargeProjectileModel(ModelPart root) {
        this.bb_main = root.getChild("bb_main");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData bb_main = modelPartData.addChild("bb_main", ModelPartBuilder.create().uv(0, 0).cuboid(-0.0F, -0.0F, -0.0F, 0.0F, 0.0F, 0.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-0.0F, -0.0F, 0.0F, 0.0F, 0.0F, 0.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-0.0F, -0.0F, 0.0F, 0.0F, 0.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r1 = bb_main.addChild("cube_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-0.0F, -0.0F, 0.0F, 0.0F, 0.0F, 0.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-0.0F, -0.0F, 0.0F, 0.0F, 0.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
        return TexturedModelData.of(modelData, 0, 0);
    }

    @Override
    public	void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        bb_main.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }
}