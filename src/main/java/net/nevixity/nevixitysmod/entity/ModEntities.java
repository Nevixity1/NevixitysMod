package net.nevixity.nevixitysmod.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.nevixity.nevixitysmod.NevixitysMod;
import net.nevixity.nevixitysmod.entity.custom.*;

public class ModEntities {
    public static final EntityType<ScytheChargeProjectileEntity> SCYTHE_CHARGE_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(NevixitysMod.MOD_ID, "scythe_charge_projectile"),
            FabricEntityTypeBuilder.<ScytheChargeProjectileEntity>create(SpawnGroup.MISC, ScytheChargeProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(2.0f, 0.7f)).build());

    public static final EntityType<SmokeBombEntity> SMOKE_BOMB_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(NevixitysMod.MOD_ID, "smoke_bomb_projectile"), FabricEntityTypeBuilder.<SmokeBombEntity>create(SpawnGroup.MISC, SmokeBombEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());

    public static final EntityType<OdiumHammerEntity> ODIUM_HAMMER = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(NevixitysMod.MOD_ID, "odium_hammer"), FabricEntityTypeBuilder.<OdiumHammerEntity>create(SpawnGroup.MISC, OdiumHammerEntity::new)
                    .dimensions(EntityDimensions.fixed(0.55f, 0.55f)).fireImmune().build());

    public static final EntityType<CapybaraEntity> CAPYBARA = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(NevixitysMod.MOD_ID, "capybara"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, CapybaraEntity::new)
                    .dimensions(EntityDimensions.fixed(0.85f, 0.85f)).build());

    public static final EntityType<RedpandaEntity> REDPANDA = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(NevixitysMod.MOD_ID, "redpanda"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, RedpandaEntity::new)
                    .dimensions(EntityDimensions.fixed(0.55f, 0.35f)).build());


    public static final EntityType<BruteBossEntity> BRUTE_BOSS = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(NevixitysMod.MOD_ID, "brute_boss"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, BruteBossEntity::new)
                    .dimensions(EntityDimensions.fixed(2f, 4.1f)).build());




    public static void registerModEntites() {
        NevixitysMod.LOGGER.info("Registering ModEntities for " + NevixitysMod.MOD_ID);
    }
}