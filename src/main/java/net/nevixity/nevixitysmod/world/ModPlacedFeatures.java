package net.nevixity.nevixitysmod.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.nevixity.nevixitysmod.NevixitysMod;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> ODIUM_ORE_PLACED_KEY = registerKey("odium_ore_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        RegistryEntryLookup<ConfiguredFeature<?, ?>> configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, ODIUM_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ODIUM_ORE_KEY),
                ModOrePlacement.modifiersWithCount(1, // Veins per Chunk
                HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));
    }


    public static RegistryKey<PlacedFeature> registerKey(String id) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(NevixitysMod.MOD_ID, id));
    }

    private static void register(Registerable<PlacedFeature> featureRegisterable, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> feature,
                                 List<PlacementModifier> modifiers) {
        featureRegisterable.register(key, new PlacedFeature(feature, List.copyOf(modifiers)));
    }

    private static void register(Registerable<PlacedFeature> featureRegisterable, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> feature,
                                 PlacementModifier ... modifiers) {
        register(featureRegisterable, key, feature, List.of(modifiers));
    }
}


