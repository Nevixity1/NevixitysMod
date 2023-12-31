package net.nevixity.nevixitysmod.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;

public class OdiumHammerEntityModel extends Model {
    private final ModelPart root;

    public OdiumHammerEntityModel(ModelPart root) {
        super(RenderLayer::getEntitySolid);
        this.root = root.getChild("bone");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData bone = modelPartData.addChild("bone", ModelPartBuilder.create().uv(16, 49).cuboid(-13.5F, -21.5F, 7.0F, 11.0F, 7.0F, 6.0F, new Dilation(0.0F)).uv(30, 34).cuboid(-9.0F, -17.5F, 9.0F, 2.0F, 12.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(8.0F, 24.0F, -8.0F));

        ModelPartData cube_r1 = bone.addChild("cube_r1", ModelPartBuilder.create().uv(27, 29).mirrored().cuboid(-5.125F, 0.5F, -3.5F, 7.5F, 3.0F, 6.5F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-3.0277F, -18.9367F, 10.25F, 0.0F, 0.0F, -0.7854F));

        ModelPartData cube_r2 = bone.addChild("cube_r2", ModelPartBuilder.create().uv(34, 29).mirrored().cuboid(-4.125F, -2.25F, -3.65F, 7.75F, 2.75F, 6.5F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-3.0277F, -18.9367F, 10.25F, 0.0F, 0.0F, 0.7854F));

        ModelPartData cube_r3 = bone.addChild("cube_r3", ModelPartBuilder.create().uv(34, 29).cuboid(-3.625F, -2.25F, -3.65F, 7.75F, 2.75F, 6.5F, new Dilation(0.0F)), ModelTransform.of(-12.9723F, -18.9367F, 10.25F, 0.0F, 0.0F, -0.7854F));

        ModelPartData cube_r4 = bone.addChild("cube_r4", ModelPartBuilder.create().uv(27, 29).cuboid(-2.375F, 0.5F, -3.5F, 7.5F, 3.0F, 6.5F, new Dilation(0.0F)), ModelTransform.of(-12.9723F, -18.9367F, 10.25F, 0.0F, 0.0F, 0.7854F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        root.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }
}