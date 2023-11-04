package net.nevixity.nothingmod.util;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.nevixity.nothingmod.Entity.ModEntities;
import net.nevixity.nothingmod.Entity.custom.CapybaraEntity;
import net.nevixity.nothingmod.Entity.custom.RedpandaEntity;

public class ModRegistries {
    public static void registerModStuffs() {

        registerAttributes();
    }


    private static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntities.REDPANDA, RedpandaEntity.createRedpandaAttributes());

        FabricDefaultAttributeRegistry.register(ModEntities.CAPYBARA, CapybaraEntity.createCapybaraAttributes());


    }





    }
