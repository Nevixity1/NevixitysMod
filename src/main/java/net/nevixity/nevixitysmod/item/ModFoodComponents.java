package net.nevixity.nevixitysmod.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent ODIUM_APPLE = new FoodComponent.Builder().hunger(4).alwaysEdible().saturationModifier(2)
            .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH,  400, 1),1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 400, 0), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 1400, 2), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 600, 0), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 400, 2),1.0f)
            .build();
}
