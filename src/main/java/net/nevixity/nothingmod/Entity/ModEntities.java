package net.nevixity.nothingmod.Entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.nevixity.nothingmod.Entity.custom.*;
import net.nevixity.nothingmod.NothingMod;

public class ModEntities {

    public static final EntityType<ScytheChargeProjectileEntity> SCYTHE_CHARGE_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(NothingMod.MOD_ID, "scythe_charge_projectile"),
            FabricEntityTypeBuilder.<ScytheChargeProjectileEntity>create(SpawnGroup.MISC, ScytheChargeProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(2.0f, 0.7f)).build());

    public static final EntityType<SmokeBombEntity> SMOKE_BOMB_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(NothingMod.MOD_ID, "smoke_bomb_projectile"),
            FabricEntityTypeBuilder.<SmokeBombEntity>create(SpawnGroup.MISC, SmokeBombEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());


    public static final EntityType<OdiumHammerEntity> ODIUM_HAMMER = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(NothingMod.MOD_ID, "odium_hammer"),
            FabricEntityTypeBuilder.<OdiumHammerEntity>create(SpawnGroup.MISC, OdiumHammerEntity::new)
                    .dimensions(EntityDimensions.fixed(0.55f, 0.55f)).build());


    public static final EntityType<CapybaraEntity> CAPYBARA = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(NothingMod.MOD_ID, "capybara"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, CapybaraEntity::new)
                    .dimensions(EntityDimensions.fixed(0.85f, 0.85f)).build());





    public static final EntityType<RedpandaEntity> REDPANDA = Registry.register(Registries.ENTITY_TYPE,
        new Identifier(NothingMod.MOD_ID, "redpanda"),
        FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, RedpandaEntity::new)
                .dimensions(EntityDimensions.fixed(0.55f, 0.35f)).build());





public static void registerModEntites() {
    NothingMod.LOGGER.info("Registering Mod Entities for " + NothingMod.MOD_ID);
}

}