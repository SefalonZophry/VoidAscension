package net.sefalonzophry.voidascension.setup.worldgen.biome;

import net.minecraftforge.common.BiomeDictionary;
import net.sefalonzophry.voidascension.setup.worldgen.ModConfiguredSurfaceBuilder;
import net.minecraft.entity.EntityClassification;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.sefalonzophry.voidascension.VoidAscension;
import net.sefalonzophry.voidascension.setup.entity.ModEntityTypes;

import java.util.function.Supplier;

public class VoidTouchedBome {
    public static final DeferredRegister<Biome> BIOMES
            =DeferredRegister.create(ForgeRegistries.BIOMES, VoidAscension.MOD_ID);

    public static final RegistryObject<Biome> VOID_TOUCHED_BIOME = BIOMES.register("void_touched_biome",
            () -> makeVoidBiome(() -> ModConfiguredSurfaceBuilder.VOID_TOUCHED_BIOME, 0.25f, 0.05f));



    private static Biome makeVoidBiome (final Supplier<ConfiguredSurfaceBuilder<?>> surfaceBuilder, float depth, float scale) {
        MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
        mobspawninfo$builder.addSpawn(EntityClassification.MONSTER,
                new MobSpawnInfo.Spawners(ModEntityTypes.VOIDSPAWN.get(), 100, 2, 3));
        BiomeGenerationSettings.Builder biomegenerationsettings$builder =
                (new BiomeGenerationSettings.Builder()).surfaceBuilder(surfaceBuilder);
        mobspawninfo$builder.addSpawn(EntityClassification.MONSTER,
                new MobSpawnInfo.Spawners(ModEntityTypes.INJECTOR.get(), 100, 3, 4));

        DefaultBiomeFeatures.addDefaultUndergroundVariety(biomegenerationsettings$builder);
        DefaultBiomeFeatures.addDefaultCarvers(biomegenerationsettings$builder);

        DefaultBiomeFeatures.addBadlandsTrees(biomegenerationsettings$builder);
        DefaultBiomeFeatures.addPlainGrass(biomegenerationsettings$builder);
        DefaultBiomeFeatures.addDefaultLakes(biomegenerationsettings$builder);
        DefaultBiomeFeatures.addDefaultMonsterRoom(biomegenerationsettings$builder);
        DefaultBiomeFeatures.addDefaultOres(biomegenerationsettings$builder);

        return (new Biome.Builder()).precipitation(Biome.RainType.NONE).biomeCategory(Biome.Category.PLAINS).depth(depth).scale(scale)
                .temperature(1.5F).downfall(0.9F).specialEffects((new BiomeAmbience.Builder()).waterColor(1447445).waterFogColor(1447445)
                        .fogColor(1447445).skyColor(getSkyColorWithTemperatureModifier(1447445)).foliageColorOverride(1447445).grassColorOverride(1447445)
                        .ambientLoopSound(SoundEvents.AMBIENT_CRIMSON_FOREST_LOOP)
                        .ambientMoodSound(new MoodSoundAmbience(SoundEvents.AMBIENT_WARPED_FOREST_MOOD, 6000, 8, 2.0D))
                        .ambientAdditionsSound(new SoundAdditionsAmbience(SoundEvents.AMBIENT_NETHER_WASTES_ADDITIONS, 0.0111D))
                        .build())
                .mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(biomegenerationsettings$builder.build()).build();
    }

    private static int getSkyColorWithTemperatureModifier(float temperature) {
        float lvt_1_1_ = temperature / 3.0F;
        lvt_1_1_ = MathHelper.clamp(lvt_1_1_, -1.0F, 1.0F);
        return MathHelper.hsvToRgb(0 - lvt_1_1_ * 0, 0 + lvt_1_1_ * 0, 0);
    }

    public static void register(IEventBus eventBus) {
        BIOMES.register(eventBus);
    }
}
