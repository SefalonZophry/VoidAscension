package net.sefalonzophry.voidascension.setup.worldgen.biome;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.sefalonzophry.voidascension.VoidAscension;
import net.sefalonzophry.voidascension.setup.entity.ModEntityTypes;

import static net.sefalonzophry.voidascension.setup.worldgen.biome.DeepVoid.DEEP_VOID;
import static net.sefalonzophry.voidascension.setup.worldgen.biome.DeepVoid.deepvoid;

public class VoidTouchedBiome {
    public static final ResourceKey<Biome> VOID_TOUCHED_BIOME = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(VoidAscension.MOD_ID, "void_touched_biome"));

    public static void boostrap(BootstapContext<Biome> context) {
        context.register(VOID_TOUCHED_BIOME, voidtouchedbiome(context));
        context.register(DEEP_VOID, deepvoid(context));
    }

    public static void globalOverworldGenerationVoidTouchedBiome(BiomeGenerationSettings.Builder builder) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
    }

    public static Biome voidtouchedbiome(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntityTypes.INJECTOR.get(), 2, 3, 5));

        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntityTypes.VOIDSPAWN.get(), 5, 4, 4));

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        //we need to follow the same order as vanilla biomes for the BiomeDefaultFeatures
        globalOverworldGenerationVoidTouchedBiome(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);

        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .downfall(0.9f)
                .temperature(1.5f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(1447445)
                        .waterFogColor(1447445)
                        .skyColor(1447445)
                        .grassColorOverride(1447445)
                        .foliageColorOverride(1447445)
                        .fogColor(1447445)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build())
                .build();
    }
}
