package net.nevixity.nevixitysmod.util;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.nevixity.nevixitysmod.entity.ModEntities;
import net.nevixity.nevixitysmod.entity.custom.BruteBossEntity;
import net.nevixity.nevixitysmod.entity.custom.CapybaraEntity;
import net.nevixity.nevixitysmod.entity.custom.RedpandaEntity;

public class ModRegistries {
    public static void registerModStuffs() {
        registerAttributes();
    }

    private static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntities.REDPANDA, RedpandaEntity.createRedpandaAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.CAPYBARA, CapybaraEntity.createCapybaraAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.BRUTE_BOSS, BruteBossEntity.createBrutebossAttributes());

    }
}
