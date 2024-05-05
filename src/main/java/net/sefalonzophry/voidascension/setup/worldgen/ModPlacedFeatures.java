package net.sefalonzophry.voidascension.setup.worldgen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.sefalonzophry.voidascension.VoidAscension;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> RIFT_CRYSTAL_ORE_PLACED_KEY = registerKey("rift_crystal_ore_placed");
//    public static final ResourceKey<PlacedFeature> NETHER_RIFT_CRYSTAL_ORE_PLACED_KEY = registerKey("");
//    public static final ResourceKey<PlacedFeature> END_RIFT_CRYSTAL_ORE_PLACED_KEY = registerKey("");


    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, RIFT_CRYSTAL_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_RIFT_CRYSTAL_ORE_KEY),
                ModOrePlacement.commonOrePlacement(64,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-60), VerticalAnchor.absolute(80))));
//        register(context, NETHER_RIFT_CRYSTAL_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_RIFT_CRYSTAL_ORE_PLACED_KEY),
//                ModOrePlacement.commonOrePlacement(12,
//                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
//        register(context, END_RIFT_CRYSTAL_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_RIFT_CRYSTAL_ORE_PLACED_KEY),
//                ModOrePlacement.commonOrePlacement(12,
//                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
    }


    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(VoidAscension.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
