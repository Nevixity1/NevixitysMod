package net.nevixity.nevixitysmod.entity.layer;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.nevixity.nevixitysmod.NevixitysMod;

public class ModModelLayers {
    public static final EntityModelLayer SCYTHE_CHARGE_PROJECTILE = new EntityModelLayer(new Identifier(NevixitysMod.MOD_ID, "scythe_charge_projectile"), "main");
    public static final EntityModelLayer REDPANDA = new EntityModelLayer(new Identifier(NevixitysMod.MOD_ID, "redpanda"), "main");
    public static final EntityModelLayer CAPYBARA = new EntityModelLayer(new Identifier(NevixitysMod.MOD_ID, "capybara"), "main");
    public static final EntityModelLayer ODIUM_HAMMER = new EntityModelLayer(new Identifier(NevixitysMod.MOD_ID, "odium_hammer"), "main");

    public static final EntityModelLayer BRUTE_BOSS = new EntityModelLayer(new Identifier(NevixitysMod.MOD_ID, "brute_boss"), "main");
}
