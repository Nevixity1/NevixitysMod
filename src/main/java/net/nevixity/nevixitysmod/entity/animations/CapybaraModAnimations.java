package net.nevixity.nevixitysmod.entity.animations;

import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;

public class CapybaraModAnimations {

    public static final Animation IDLE = Animation.Builder.create(0.8343334f).looping()
            .addBoneAnimation("head",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("torso",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("leg1",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("leg2",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("leg4",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("body",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("body",
                    new Transformation(Transformation.Targets.SCALE,
                            new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.4583433f, AnimationHelper.createScalingVector(1f, 1.03f, 1f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.8343334f, AnimationHelper.createScalingVector(1f, 1f, 1f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("nose",
                    new Transformation(Transformation.Targets.SCALE,
                            new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.4167667f, AnimationHelper.createScalingVector(1f, 1.03f, 1f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.8343334f, AnimationHelper.createScalingVector(1f, 1f, 1f),
                                    Transformation.Interpolations.LINEAR))).build();
    public static final Animation SITTING = Animation.Builder.create(1.5416767f).looping()
            .addBoneAnimation("head",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, -2.25f, 0.25f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.0416767f, AnimationHelper.createTranslationalVector(0f, -2.25f, 0.25f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("head",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(25f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("torso",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, -1.25f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.0416767f, AnimationHelper.createTranslationalVector(0f, -1.25f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("torso",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(-32.5f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("leg1",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(-1f, -4.25f, 2.5f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.0416767f, AnimationHelper.createTranslationalVector(-1f, -4.25f, 2.5f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("leg1",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(-90.31f, 22.92f, 15.63f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("leg2",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(1.5f, -5.5f, -0.5f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.0416767f, AnimationHelper.createTranslationalVector(1.5f, -5.5f, -0.5f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("leg2",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(-90.9f, -20.88f, -26.21f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("leg3",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(1.5f, -5.5f, -1.5f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.0416767f, AnimationHelper.createTranslationalVector(1.5f, -5.5f, -1.5f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("leg3",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(-90.9f, -20.88f, -14.07f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("leg4",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(-1f, -4.25f, 0.5f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.0416767f, AnimationHelper.createTranslationalVector(-1f, -4.25f, 0.5f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("leg4",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(-90.31f, 22.92f, 15.63f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("body",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, -4.25f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.0416767f, AnimationHelper.createTranslationalVector(0f, -4.25f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("body",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0.5f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("body",
                    new Transformation(Transformation.Targets.SCALE,
                            new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.8343334f, AnimationHelper.createScalingVector(1f, 1.05f, 1f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.5416767f, AnimationHelper.createScalingVector(1f, 1f, 1f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("nose",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("nose",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("nose",
                    new Transformation(Transformation.Targets.SCALE,
                            new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.75f, AnimationHelper.createScalingVector(1f, 1.03f, 1f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.5416767f, AnimationHelper.createScalingVector(1f, 1f, 1f),
                                    Transformation.Interpolations.LINEAR))).build();
    public static final Animation WALKING = Animation.Builder.create(0.625f).looping()
            .addBoneAnimation("head",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.375f, AnimationHelper.createTranslationalVector(0f, -0.25f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.625f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("leg1",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 1f, -1f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.16766666f, AnimationHelper.createTranslationalVector(0f, 0f, -0.75f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.4167667f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.625f, AnimationHelper.createTranslationalVector(0f, 1f, -1f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("leg2",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.16766666f, AnimationHelper.createTranslationalVector(0f, 1.25f, -0.25f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.4167667f, AnimationHelper.createTranslationalVector(0f, 0f, -1f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.625f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("leg3",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 1f, -1f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.16766666f, AnimationHelper.createTranslationalVector(0f, 0f, -0.75f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.4167667f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.625f, AnimationHelper.createTranslationalVector(0f, 1f, -1f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("leg4",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.16766666f, AnimationHelper.createTranslationalVector(0f, 1.25f, -0.25f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.4167667f, AnimationHelper.createTranslationalVector(0f, 0f, -1f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.625f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("body",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0.25f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.375f, AnimationHelper.createTranslationalVector(0f, -0.25f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.625f, AnimationHelper.createTranslationalVector(0f, 0.25f, 0f),
                                    Transformation.Interpolations.LINEAR))).build();
    public static final Animation ATTACKING = Animation.Builder.create(0.7916766f).looping()
            .addBoneAnimation("head",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.25f, AnimationHelper.createRotationalVector(30f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.4167667f, AnimationHelper.createRotationalVector(-27.5f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.5834334f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.7916766f, AnimationHelper.createRotationalVector(-2.5f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("torso",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 1f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.2916767f, AnimationHelper.createTranslationalVector(0f, 1f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.5834334f, AnimationHelper.createTranslationalVector(0f, 1f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("torso",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0.16766666f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.5f, AnimationHelper.createRotationalVector(-20f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.7916766f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("leg1",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.25f, AnimationHelper.createRotationalVector(10f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.7083434f, AnimationHelper.createRotationalVector(7.5f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.7916766f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("leg2",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.25f, AnimationHelper.createRotationalVector(10f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.7083434f, AnimationHelper.createRotationalVector(5f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.7916766f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("leg3",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.5f, AnimationHelper.createRotationalVector(17.5f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.7916766f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("leg4",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.25f, AnimationHelper.createRotationalVector(17.5f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.7916766f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR))).build();






}
