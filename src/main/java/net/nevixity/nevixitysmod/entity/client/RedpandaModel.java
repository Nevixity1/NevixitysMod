package net.nevixity.nevixitysmod.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.model.ParrotEntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.AnimationState;
import net.minecraft.util.math.MathHelper;
import net.nevixity.nevixitysmod.entity.animations.RedPandaModAnimations;
import net.nevixity.nevixitysmod.entity.custom.RedpandaEntity;

public class RedpandaModel extends SinglePartEntityModel<RedpandaEntity> {
    private final ModelPart redpandaModelPart;
    private final ModelPart headModelPart;

    public RedpandaModel(ModelPart root) {
        this.redpandaModelPart = root.getChild("body");
        this.headModelPart = redpandaModelPart.getChild("head");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 20.25F, 0.5F));

        ModelPartData torso = body.addChild("torso", ModelPartBuilder.create().uv(22, 34).cuboid(-2.25F, -2.125F, -3.75F, 4.5F, 4.25F, 7.5F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -0.375F, 0.25F));

        ModelPartData tail = body.addChild("tail", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -0.625F, 3.75F));

        ModelPartData cube_r1 = tail.addChild("cube_r1", ModelPartBuilder.create().uv(4, 29).cuboid(-1.75F, -1.875F, -0.25F, 3.5F, 3.5F, 6.75F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

        ModelPartData leg1 = body.addChild("leg1", ModelPartBuilder.create().uv(0, 44).cuboid(-1.0F, -0.25F, -1.0F, 2.0F, 2.5F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.5F, 1.5F, -2.25F));

        ModelPartData leg2 = body.addChild("leg2", ModelPartBuilder.create().uv(0, 44).cuboid(-1.0F, -0.25F, -1.0F, 2.0F, 2.5F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(1.5F, 1.5F, -2.25F));

        ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(45, 0).cuboid(-3.0F, -2.0F, -3.5F, 6.0F, 4.0F, 3.5F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -0.5F, -3.5F));

        ModelPartData cube_r2 = head.addChild("cube_r2", ModelPartBuilder.create().uv(58, 31).cuboid(-1.0F, -1.25F, -0.5F, 2.0F, 2.5F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.366F, -1.884F, -1.75F, 0.0F, 0.0F, 0.5236F));

        ModelPartData cube_r3 = head.addChild("cube_r3", ModelPartBuilder.create().uv(58, 34).cuboid(-1.0F, -1.25F, -0.5F, 2.0F, 2.5F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.366F, -1.884F, -1.75F, 0.0F, 0.0F, -0.5236F));

        ModelPartData nose = head.addChild("nose", ModelPartBuilder.create().uv(49, 9).cuboid(-1.25F, -2.25F, -2.25F, 2.5F, 2.0F, 1.25F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 2.25F, -2.5F));

        ModelPartData leg4 = body.addChild("leg4", ModelPartBuilder.create().uv(0, 44).cuboid(-1.0F, -0.25F, -1.0F, 2.0F, 2.5F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.5F, 1.5F, 2.5F));

        ModelPartData leg3 = body.addChild("leg3", ModelPartBuilder.create().uv(0, 44).cuboid(-1.0F, -0.25F, -1.0F, 2.0F, 2.5F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(1.5F, 1.5F, 2.5F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void setAngles(RedpandaEntity redpandaEntity, float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        headYaw = MathHelper.clamp(headYaw, -40, 40);
        headPitch = MathHelper.clamp(headPitch, -25, 45);

        this.headModelPart.yaw = headYaw * 0.017453292F;
        this.headModelPart.pitch = headPitch * 0.017453292F;

        this.animateMovement(RedPandaModAnimations.WALKING, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(redpandaEntity.idleAnimationState, RedPandaModAnimations.IDLE, ageInTicks, 1f);
        this.updateAnimation(redpandaEntity.attackAnimationState, RedPandaModAnimations.STANDING, ageInTicks, 1f);
        this.updateAnimation(redpandaEntity.sitAnimationState, RedPandaModAnimations.SIT, ageInTicks, 1f);
    }



    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        redpandaModelPart.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart getPart() {
        return redpandaModelPart;
    }

    public void poseOnShoulder(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float limbAngle, float limbDistance, float headYaw, float headPitch, int danceAngle) {
//        this.animateModel(Pose.ON_SHOULDER);
this.animateModel(RedPandaModAnimations.RIDING_PLAYER);
//        this.setAngles(Pose.ON_SHOULDER, danceAngle, limbAngle, limbDistance, 0.0f, headYaw, headPitch); uuuuuuhh
        this.redpandaModelPart.render(matrices, vertexConsumer, light, overlay);
    }


    private void animateModel(Animation ridingPlayer) {
    }



}
