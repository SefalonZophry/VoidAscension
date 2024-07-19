package net.sefalonzophry.voidascension.setup.worldgen;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;
import net.sefalonzophry.voidascension.VoidAscension;
import net.sefalonzophry.voidascension.setup.ModTags;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_VOID_CRYSTAL_ORE_VTB = registerKey("add_void_crystal_ore_vtb");
    public static final ResourceKey<BiomeModifier> ADD_VOID_CRYSTAL_ORE_DV = registerKey("add_void_crystal_ore_dv");
    public static final ResourceKey<BiomeModifier> ADD_NETHER_VOID_CRYSTAL_ORE = registerKey("add_nether_void_crystal_ore");
    public static final ResourceKey<BiomeModifier> ADD_END_VOID_CRYSTAL_ORE = registerKey("add_end_void_crystal_ore");


    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_VOID_CRYSTAL_ORE_VTB, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(ModTags.Biomes.VOID_TOUCHED_BIOME),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.VOID_CRYSTAL_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_VOID_CRYSTAL_ORE_DV, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(ModTags.Biomes.DEEP_VOID),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.VOID_CRYSTAL_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
/*
        context.register(ADD_NETHER_VOID_CRYSTAL_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.NETHER_VOID_CRYSTAL_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_END_VOID_CRYSTAL_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.END_VOID_CRYSTAL_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
*/
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(VoidAscension.MOD_ID, name));
    }
}
