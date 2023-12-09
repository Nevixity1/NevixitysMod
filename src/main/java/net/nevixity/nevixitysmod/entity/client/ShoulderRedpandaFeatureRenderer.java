package net.nevixity.nevixitysmod.entity.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.nevixity.nevixitysmod.entity.ModEntities;
import net.nevixity.nevixitysmod.entity.custom.RedpandaEntity;
import net.nevixity.nevixitysmod.entity.layer.ModModelLayers;

@Environment(EnvType.CLIENT)
public class ShoulderRedpandaFeatureRenderer<T extends PlayerEntity> extends FeatureRenderer<T, PlayerEntityModel<T>> {
    private final RedpandaModel model;

    public ShoulderRedpandaFeatureRenderer(FeatureRendererContext<T, PlayerEntityModel<T>> context, EntityModelLoader loader) {
        super(context);
        this.model = new RedpandaModel(loader.getModelPart(ModModelLayers.REDPANDA));
    }
    


    public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, T playerEntity, float f, float g, float h, float j, float k, float l) {
        this.renderShoulderRedPanda(matrixStack, vertexConsumerProvider, i, playerEntity, f, g, k, l, true);
        this.renderShoulderRedPanda(matrixStack, vertexConsumerProvider, i, playerEntity, f, g, k, l, false);
    }

    private void renderShoulderRedPanda(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, T player, float limbAngle, float limbDistance, float headYaw, float headPitch, boolean leftShoulder) {
        NbtCompound nbtCompound = leftShoulder ? player.getShoulderEntityLeft() : player.getShoulderEntityRight();
        java.util.Optional<EntityType<?>> id = EntityType.get(nbtCompound.getString("id"));
        id.filter((type) -> {
            return type == ModEntities.REDPANDA;
        });
        id.ifPresent((type) -> {
            matrices.push();
            matrices.translate(leftShoulder ? 0.4F : -0.4F, player.isInSneakingPose() ? -1.3F : -1.5F, 0.0F);
            VertexConsumer vertexConsumer = null;
            this.model.poseOnShoulder(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, limbAngle, limbDistance, headYaw, headPitch, player.age);
            matrices.pop();
        });
    }

    public static void register() {
        LivingEntityFeatureRendererRegistrationCallback.EVENT.register((entityType, entityRenderer, registrationHelper, context) -> {
            if (entityRenderer instanceof PlayerEntityRenderer) {
                registrationHelper.register(new ShoulderRedpandaFeatureRenderer(entityRenderer, context.getModelLoader()));
            }
        });
    }
}


