package net.nevixity.nevixitysmod.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.nevixity.nevixitysmod.entity.animations.BruteBossModAnimations;
import net.nevixity.nevixitysmod.entity.custom.BruteBossEntity;



public class BruteBossModel<T extends BruteBossEntity> extends SinglePartEntityModel<T> {

    private final ModelPart bone;
    private final ModelPart head;

    public BruteBossModel(ModelPart root) {
        this.bone = root.getChild("bone");
        this.head = bone.getChild("head");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData bone = modelPartData.addChild("bone", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -20.0F, 0.0F));

        ModelPartData head = bone.addChild("head", ModelPartBuilder.create().uv(83, 108).cuboid(-5.5F, -9.5F, -4.25F, 11.0F, 9.0F, 9.0F, new Dilation(0.0F))
                .uv(92, 87).cuboid(-1.5F, -12.5F, -4.25F, 3.0F, 3.0F, 7.0F, new Dilation(0.0F))
                .uv(40, 111).cuboid(0.0F, -17.5F, -5.25F, 0.0F, 8.0F, 9.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-5.0F, -8.0F, -4.0F, 10.0F, 8.0F, 8.0F, new Dilation(0.0F))
                .uv(28, 1).cuboid(-2.0F, -4.0F, -5.0F, 4.0F, 4.0F, 1.0F, new Dilation(0.0F))
                .uv(2, 0).cuboid(2.0F, -2.0F, -5.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(2, 0).cuboid(-3.0F, -2.0F, -5.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.25F, -6.25F, -3.5F));

        ModelPartData head_r1 = head.addChild("head_r1", ModelPartBuilder.create().uv(63, 113).cuboid(0.0F, -3.0F, -4.0F, 0.0F, 9.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-0.001F, -13.6596F, 6.4888F, -2.4435F, 0.0F, 3.1416F));

        ModelPartData left_ear = head.addChild("left_ear", ModelPartBuilder.create().uv(38, 0).cuboid(-0.5736F, 0.8192F, -2.0F, 1.0F, 5.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(4.5F, -7.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

        ModelPartData right_ear = head.addChild("right_ear", ModelPartBuilder.create().uv(38, 0).cuboid(-1.0F, 0.0F, -2.0F, 1.0F, 5.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-4.5F, -6.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

        ModelPartData left_leg = bone.addChild("left_leg", ModelPartBuilder.create(), ModelTransform.pivot(4.0F, 16.0F, -1.0F));

        ModelPartData left_leg_r1 = left_leg.addChild("left_leg_r1", ModelPartBuilder.create().uv(12, 27).mirrored().cuboid(-4.25F, -7.0F, -4.0F, 8.0F, 13.0F, 7.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(2.8117F, 4.5786F, -2.6746F, 2.766F, -0.4091F, -0.0439F));

        ModelPartData bone2 = left_leg.addChild("bone2", ModelPartBuilder.create(), ModelTransform.pivot(2.3059F, 9.9385F, -0.1687F));

        ModelPartData left_leg_r2 = bone2.addChild("left_leg_r2", ModelPartBuilder.create().uv(48, 0).mirrored().cuboid(-2.0F, -1.5F, -4.25F, 4.0F, 8.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, -2.0F, -1.0F, 1.1952F, -0.4091F, -0.0439F));

        ModelPartData left_leg_r3 = bone2.addChild("left_leg_r3", ModelPartBuilder.create().uv(48, 0).mirrored().cuboid(-2.0F, -7.0F, -1.5F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
                .uv(64, 5).mirrored().cuboid(-2.5F, 4.0F, -2.75F, 5.0F, 5.0F, 6.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-0.8059F, 9.0615F, 1.1687F, 0.0F, -0.3927F, 0.0F));

        ModelPartData right_arm = bone.addChild("right_arm", ModelPartBuilder.create(), ModelTransform.of(-8.468F, -4.1095F, -0.9131F, 0.0F, 0.0F, 0.0436F));

        ModelPartData right_arm_r1 = right_arm.addChild("right_arm_r1", ModelPartBuilder.create().uv(86, 85).mirrored().cuboid(-3.8597F, -2.2732F, -3.1615F, 8.0F, 10.0F, 7.0F, new Dilation(0.0F)).mirrored(false)
                .uv(92, 12).mirrored().cuboid(-2.8597F, -14.0232F, -2.6615F, 6.0F, 26.0F, 6.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-4.8332F, 11.1656F, -1.1601F, -0.9424F, -1.4136F, 1.0676F));

        ModelPartData right_arm_r2 = right_arm.addChild("right_arm_r2", ModelPartBuilder.create().uv(87, 86).cuboid(-3.3597F, -2.8614F, -2.9106F, 7.0F, 7.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-4.5616F, -3.8512F, 0.9041F, 0.0612F, -1.4136F, 1.0676F));

        ModelPartData axe = right_arm.addChild("axe", ModelPartBuilder.create(), ModelTransform.pivot(-6.3514F, 20.948F, -2.2501F));

        ModelPartData right_arm_r3 = axe.addChild("right_arm_r3", ModelPartBuilder.create().uv(99, 96).mirrored().cuboid(-11.6097F, 5.4768F, -1.9115F, 4.0F, 2.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
                .uv(69, 81).mirrored().cuboid(-11.1097F, -19.5232F, -1.4115F, 3.0F, 31.0F, 3.0F, new Dilation(0.0F)).mirrored(false)
                .uv(105, 88).mirrored().cuboid(-7.6097F, -16.5232F, -0.9115F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(103, 86).mirrored().cuboid(-11.6097F, -16.5232F, -1.9115F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
                .uv(99, 85).mirrored().cuboid(-14.6097F, -16.5232F, -0.9115F, 3.0F, 4.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(99, 91).mirrored().cuboid(-19.6097F, -16.5232F, -0.9115F, 5.0F, 8.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(1.5182F, -9.7824F, 1.09F, 1.4779F, -0.127F, -1.4397F));

        ModelPartData right_arm_r4 = axe.addChild("right_arm_r4", ModelPartBuilder.create().uv(95, 89).mirrored().cuboid(-8.5F, -3.5F, -0.85F, 4.0F, 5.0F, 1.75F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-0.922F, -0.5063F, -12.2206F, 1.4545F, 0.6546F, -1.5225F));

        ModelPartData right_arm_r5 = axe.addChild("right_arm_r5", ModelPartBuilder.create().uv(99, 93).mirrored().cuboid(-1.75F, -1.75F, -0.8197F, 3.5F, 4.5F, 1.75F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-2.0F, 4.0F, -18.0F, 1.4208F, -0.9074F, -1.333F));

        ModelPartData left_arm = bone.addChild("left_arm", ModelPartBuilder.create(), ModelTransform.of(8.4173F, -4.0895F, -0.9962F, 0.0F, 0.0F, -0.0436F));

        ModelPartData left_arm_r1 = left_arm.addChild("left_arm_r1", ModelPartBuilder.create().uv(92, 8).cuboid(-3.1403F, -14.0232F, -3.6615F, 6.0F, 26.0F, 6.0F, new Dilation(0.0F))
                .uv(89, 85).cuboid(-4.1403F, -2.2732F, -4.1615F, 8.0F, 10.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(4.5651F, 11.3142F, -1.0771F, -0.9424F, 1.4136F, -1.0676F));

        ModelPartData left_arm_r2 = left_arm.addChild("left_arm_r2", ModelPartBuilder.create().uv(94, 86).mirrored().cuboid(-3.3903F, -4.7835F, -2.6233F, 7.0F, 7.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(5.5359F, -2.359F, 1.1487F, -0.0261F, 1.4136F, -1.0676F));

        ModelPartData axe2 = left_arm.addChild("axe2", ModelPartBuilder.create(), ModelTransform.of(4.7632F, 21.428F, -2.167F, -0.0038F, -0.1307F, -0.2177F));

        ModelPartData right_arm_r6 = axe2.addChild("right_arm_r6", ModelPartBuilder.create().uv(99, 96).mirrored().cuboid(-11.6097F, 5.4768F, -1.9115F, 4.0F, 2.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
                .uv(69, 81).mirrored().cuboid(-11.1097F, -19.5232F, -1.4115F, 3.0F, 31.0F, 3.0F, new Dilation(0.0F)).mirrored(false)
                .uv(105, 88).mirrored().cuboid(-7.6097F, -16.5232F, -0.9115F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(103, 86).mirrored().cuboid(-11.6097F, -16.5232F, -1.9115F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
                .uv(99, 85).mirrored().cuboid(-14.6097F, -16.5232F, -0.9115F, 3.0F, 4.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(99, 91).mirrored().cuboid(-19.6097F, -16.5232F, -0.9115F, 5.0F, 8.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(1.5182F, -9.7824F, 1.09F, 1.4779F, -0.127F, -1.4397F));

        ModelPartData right_arm_r7 = axe2.addChild("right_arm_r7", ModelPartBuilder.create().uv(95, 89).mirrored().cuboid(-8.5F, -3.5F, -0.85F, 4.0F, 5.0F, 1.75F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-0.922F, -0.5063F, -12.2206F, 1.4545F, 0.6546F, -1.5225F));

        ModelPartData right_arm_r8 = axe2.addChild("right_arm_r8", ModelPartBuilder.create().uv(99, 93).mirrored().cuboid(-1.75F, -1.75F, -0.8197F, 3.5F, 4.5F, 1.75F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-2.0F, 4.0F, -18.0F, 1.4208F, -0.9074F, -1.333F));

        ModelPartData body = bone.addChild("body", ModelPartBuilder.create().uv(0, 108).cuboid(-6.0F, 4.25F, -6.25F, 12.0F, 12.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 1.25F, 0.0F));

        ModelPartData body2 = body.addChild("body2", ModelPartBuilder.create().uv(67, 52).cuboid(-9.5F, -14.75F, -6.75F, 19.0F, 12.0F, 11.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 7.0F, 0.0F));

        ModelPartData right_leg = bone.addChild("right_leg", ModelPartBuilder.create(), ModelTransform.pivot(-4.0F, 17.0F, 0.0F));

        ModelPartData right_leg_r1 = right_leg.addChild("right_leg_r1", ModelPartBuilder.create().uv(12, 27).cuboid(-3.75F, -7.0F, -4.0F, 8.0F, 13.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-2.8117F, 3.5786F, -3.6746F, 2.766F, 0.4091F, 0.0439F));

        ModelPartData bone3 = right_leg.addChild("bone3", ModelPartBuilder.create(), ModelTransform.pivot(-2.5183F, 10.1573F, -2.033F));

        ModelPartData right_leg_r2 = bone3.addChild("right_leg_r2", ModelPartBuilder.create().uv(48, 0).cuboid(-2.0F, -1.5F, -4.25F, 4.0F, 8.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.2124F, -3.2188F, -0.1357F, 1.1952F, 0.4091F, 0.0439F));

        ModelPartData right_leg_r3 = bone3.addChild("right_leg_r3", ModelPartBuilder.create().uv(48, 0).cuboid(-2.0F, -7.0F, -1.5F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F))
                .uv(64, 5).cuboid(-2.5F, 4.0F, -2.75F, 5.0F, 5.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(1.0183F, 7.8427F, 2.033F, 0.0F, 0.3927F, 0.0F));
        return TexturedModelData.of(modelData, 128, 128);
    }
    @Override
    public void setAngles(BruteBossEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(entity, netHeadYaw, headPitch, ageInTicks);

        this.animateMovement(BruteBossModAnimations.WALKING, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, BruteBossModAnimations.IDLE, ageInTicks, 1f);
        this.updateAnimation(entity.attackAnimationState, BruteBossModAnimations.ATTACK, ageInTicks, 1f);
        this.updateAnimation(entity.deathAnimationState, BruteBossModAnimations.DEATH, ageInTicks, 1f);
    }

    public void setHeadAngles(BruteBossEntity entity, float headYaw, float headPitch, float animationProgress) {
        headYaw = MathHelper.clamp(headYaw, -30, 30);
        headPitch = MathHelper.clamp(headPitch, -30, 30);

        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        bone.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart getPart() {
        return bone;
    }
}