package net.sefalonzophry.voidascension.setup.worldgen.dimensions;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.sefalonzophry.voidascension.VoidAscension;
import net.sefalonzophry.voidascension.setup.worldgen.biomes.Biomes;

import java.util.List;
import java.util.OptionalLong;

public class Dimensions {
    public static final ResourceKey<LevelStem> VOID_KEY = ResourceKey.create(Registries.LEVEL_STEM,
            new ResourceLocation(VoidAscension.MOD_ID, "void"));

    public static final ResourceKey<Level> VOID_LEVEL_KEY = ResourceKey.create(Registries.DIMENSION,
            new ResourceLocation(VoidAscension.MOD_ID, "void"));

    public static final ResourceKey<DimensionType> VOID_DIM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE,
            new ResourceLocation(VoidAscension.MOD_ID, "voiddim_type"));

    public static final ResourceKey<LevelStem> DEEP_VOID_KEY = ResourceKey.create(Registries.LEVEL_STEM,
            new ResourceLocation(VoidAscension.MOD_ID, "deep_void"));

    public static final ResourceKey<Level> DEEP_VOID_LEVEL_KEY = ResourceKey.create(Registries.DIMENSION,
            new ResourceLocation(VoidAscension.MOD_ID, "deep_void"));

    public static final ResourceKey<DimensionType> DEEP_VOID_DIM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE,
            new ResourceLocation(VoidAscension.MOD_ID, "deep_voiddim_type"));

    public static void bootstrapType(BootstapContext<DimensionType> context) {
        context.register(VOID_DIM_TYPE, new DimensionType(
                OptionalLong.of(15000), // fixedTime
                false, // hasSkylight
                false, // hasCeiling
                false, // ultraWarm
                false, // natural
                1.0, // coordinateScale
                false, // bedWorks
                false, // respawnAnchorWorks
                -64, // minY
                384, // height
                384, // logicalHeight
                BlockTags.INFINIBURN_OVERWORLD, // infiniburn
                BuiltinDimensionTypes.NETHER_EFFECTS,// , // effectsLocation
                0f, // ambientLight
                new DimensionType.MonsterSettings(false, false, ConstantInt.of(0), 0)));

        context.register(DEEP_VOID_DIM_TYPE, new DimensionType(
                OptionalLong.of(15000), // fixedTime
                false, // hasSkylight
                false, // hasCeiling
                false, // ultraWarm
                false, // natural
                1.0, // coordinateScale
                false, // bedWorks
                false, // respawnAnchorWorks
                -64, // minY
                384, // height
                384, // logicalHeight
                BlockTags.INFINIBURN_OVERWORLD, // infiniburn
                BuiltinDimensionTypes.NETHER_EFFECTS, // effectsLocation
                0f, // ambientLight
                new DimensionType.MonsterSettings(false, false, ConstantInt.of(0), 0)));
    }

    public static void bootstrapStem(BootstapContext<LevelStem> context) {
        HolderGetter<Biome> biomeRegistry = context.lookup(Registries.BIOME);
        HolderGetter<DimensionType> voiddimType = context.lookup(Registries.DIMENSION_TYPE);
        HolderGetter<NoiseGeneratorSettings> noiseGenSettings = context.lookup(Registries.NOISE_SETTINGS);
        HolderGetter<Biome> deepVoidBiomeReg = context.lookup(Registries.BIOME);
        HolderGetter<DimensionType> deepdimType = context.lookup(Registries.DIMENSION_TYPE);
        HolderGetter<NoiseGeneratorSettings> deepVoidNoiseGenSettings = context.lookup(Registries.NOISE_SETTINGS);

        NoiseBasedChunkGenerator voidWrappedChunkGenerator = new NoiseBasedChunkGenerator(
                new FixedBiomeSource(biomeRegistry.getOrThrow(Biomes.VOID_TOUCHED_FOREST)),
                noiseGenSettings.getOrThrow(NoiseGeneratorSettings.OVERWORLD));

        NoiseBasedChunkGenerator deepVoidWrappedChunkGenerator = new NoiseBasedChunkGenerator(
                new FixedBiomeSource(deepVoidBiomeReg.getOrThrow(Biomes.DeepVoid.DEEP_VOID)),
                deepVoidNoiseGenSettings.getOrThrow(NoiseGeneratorSettings.OVERWORLD));


        NoiseBasedChunkGenerator voidNoiseBasedChunkGenerator = new NoiseBasedChunkGenerator(
                MultiNoiseBiomeSource.createFromList(
                        new Climate.ParameterList<>(List.of(Pair.of(
                                        Climate.parameters(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(Biomes.VOID_TOUCHED_FOREST)),
                                Pair.of(
                                        Climate.parameters(0.1F, 0.2F, 0.0F, 0.2F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(net.minecraft.world.level.biome.Biomes.BIRCH_FOREST)),
                                Pair.of(
                                        Climate.parameters(0.3F, 0.6F, 0.1F, 0.1F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(net.minecraft.world.level.biome.Biomes.OCEAN)),
                                Pair.of(
                                        Climate.parameters(0.4F, 0.3F, 0.2F, 0.1F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(net.minecraft.world.level.biome.Biomes.DARK_FOREST))

                        ))),
                deepVoidNoiseGenSettings.getOrThrow(NoiseGeneratorSettings.OVERWORLD));

        NoiseBasedChunkGenerator deepVoidNoiseBasedChunkGenerator = new NoiseBasedChunkGenerator(
                MultiNoiseBiomeSource.createFromList(
                        new Climate.ParameterList<>(List.of(Pair.of(
                                        Climate.parameters(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), deepVoidBiomeReg.getOrThrow(Biomes.VOID_TOUCHED_FOREST)),
                                Pair.of(
                                        Climate.parameters(0.1F, 0.2F, 0.0F, 0.2F, 0.0F, 0.0F, 0.0F), deepVoidBiomeReg.getOrThrow(net.minecraft.world.level.biome.Biomes.BIRCH_FOREST)),
                                Pair.of(
                                        Climate.parameters(0.3F, 0.6F, 0.1F, 0.1F, 0.0F, 0.0F, 0.0F), deepVoidBiomeReg.getOrThrow(net.minecraft.world.level.biome.Biomes.OCEAN)),
                                Pair.of(
                                        Climate.parameters(0.4F, 0.3F, 0.2F, 0.1F, 0.0F, 0.0F, 0.0F), deepVoidBiomeReg.getOrThrow(net.minecraft.world.level.biome.Biomes.DARK_FOREST))

                        ))),
                noiseGenSettings.getOrThrow(NoiseGeneratorSettings.OVERWORLD));

        LevelStem voidstem = new LevelStem(voiddimType.getOrThrow(Dimensions.VOID_DIM_TYPE), voidWrappedChunkGenerator);

        context.register(VOID_KEY, voidstem);

        LevelStem deepvoidstem = new LevelStem(deepdimType.getOrThrow(DEEP_VOID_DIM_TYPE), deepVoidWrappedChunkGenerator);

        context.register(DEEP_VOID_KEY, deepvoidstem);
    }
}
