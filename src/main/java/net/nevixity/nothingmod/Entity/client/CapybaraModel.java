package net.nevixity.nothingmod.Entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.nevixity.nothingmod.Entity.animations.CapybaraModAnimations;
import net.nevixity.nothingmod.Entity.custom.CapybaraEntity;

public class CapybaraModel<T extends CapybaraEntity> extends SinglePartEntityModel<T> {
private final ModelPart capybara;
private final ModelPart head;

    public CapybaraModel(ModelPart root) {
        this.capybara = root.getChild("torso");
        this.head = capybara.getChild("head");
    }


    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData torso = modelPartData.addChild("torso", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 16.0F, 3.0F));

        ModelPartData body = torso.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(-3.0F, -0.5F, -1.0F));

        ModelPartData cube_r1 = body.addChild("cube_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-7.5F, -4.5F, -4.0F, 15.0F, 9.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(3.25F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        ModelPartData leg1 = torso.addChild("leg1", ModelPartBuilder.create(), ModelTransform.pivot(-5.25F, 2.625F, -6.0F));

        ModelPartData cube_r2 = leg1.addChild("cube_r2", ModelPartBuilder.create().uv(29, 27).cuboid(-2.0F, -2.25F, -1.5F, 4.0F, 6.75F, 3.0F, new Dilation(0.0F)), ModelTransform.of(3.25F, 0.875F, 0.0F, 0.0F, -1.5708F, 0.0F));

        ModelPartData leg2 = torso.addChild("leg2", ModelPartBuilder.create(), ModelTransform.pivot(-0.75F, 2.625F, -6.0F));

        ModelPartData cube_r3 = leg2.addChild("cube_r3", ModelPartBuilder.create().uv(0, 30).cuboid(-2.0F, -2.25F, -1.5F, 4.0F, 6.75F, 3.0F, new Dilation(0.0F)), ModelTransform.of(3.25F, 0.875F, 0.0F, 0.0F, -1.5708F, 0.0F));

        ModelPartData leg3 = torso.addChild("leg3", ModelPartBuilder.create(), ModelTransform.pivot(-0.75F, 2.625F, 4.0F));

        ModelPartData cube_r4 = leg3.addChild("cube_r4", ModelPartBuilder.create().uv(32, 17).cuboid(-2.25F, -2.0F, -1.5F, 4.0F, 6.75F, 3.0F, new Dilation(0.0F)), ModelTransform.of(3.25F, 0.625F, 0.25F, 0.0F, -1.5708F, 0.0F));

        ModelPartData leg4 = torso.addChild("leg4", ModelPartBuilder.create(), ModelTransform.pivot(-5.0F, 3.0F, 4.0F));

        ModelPartData cube_r5 = leg4.addChild("cube_r5", ModelPartBuilder.create().uv(14, 30).cuboid(-2.25F, -2.25F, -1.75F, 4.0F, 6.75F, 3.0F, new Dilation(0.0F)), ModelTransform.of(2.75F, 0.5F, 0.25F, 0.0F, -1.5708F, 0.0F));

        ModelPartData head = torso.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(-3.0135F, -2.6782F, -7.5283F));

        ModelPartData cube_r6 = head.addChild("cube_r6", ModelPartBuilder.create().uv(0, 17).cuboid(-0.5F, -1.5F, -1.75F, 1.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(1.5722F, -4.38F, -0.8246F, -1.327F, 1.4823F, -1.7608F));

        ModelPartData cube_r7 = head.addChild("cube_r7", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -1.5F, -1.75F, 1.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(4.9143F, -4.4272F, -0.9217F, -1.327F, -1.4823F, 1.7608F));

        ModelPartData nose = head.addChild("nose", ModelPartBuilder.create(), ModelTransform.pivot(0.0135F, -0.8218F, 0.0283F));

        ModelPartData cube_r8 = nose.addChild("cube_r8", ModelPartBuilder.create().uv(0, 17).cuboid(-10.0F, -3.5F, -3.0F, 10.0F, 7.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(3.25F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }
    @Override
    public void setAngles(CapybaraEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
            this.getPart().traverse().forEach(ModelPart::resetTransform);
            this.setHeadAngles(entity, netHeadYaw, headPitch, ageInTicks);


            this.animateMovement(CapybaraModAnimations.WALKING, limbSwing, limbSwingAmount, 2f, 2.5f);
            this.updateAnimation(entity.idleAnimationState, CapybaraModAnimations.IDLE, ageInTicks, 1f);
        this.updateAnimation(entity.attackAnimationState, CapybaraModAnimations.ATTACKING, ageInTicks, 1f);
        this.updateAnimation(entity.sitAnimationState, CapybaraModAnimations.SITTING, ageInTicks, 1f);
    }

   public void setHeadAngles(CapybaraEntity entity, float headYaw, float headPitch, float animationProgress) {
    headYaw = MathHelper.clamp(headYaw, -20, 20);
       headPitch = MathHelper.clamp(headPitch, -25, 45);

     this.head.yaw = headYaw * 0.017453292F;
       this.head.pitch = headPitch * 0.017453292F;

   }






    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        capybara.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart getPart() {
        return capybara;
    }



    }


