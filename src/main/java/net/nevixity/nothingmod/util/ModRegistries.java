package net.nevixity.nothingmod.util;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.nevixity.nothingmod.entity.ModEntities;
import net.nevixity.nothingmod.entity.custom.BruteBossEntity;
import net.nevixity.nothingmod.entity.custom.CapybaraEntity;
import net.nevixity.nothingmod.entity.custom.RedpandaEntity;

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
