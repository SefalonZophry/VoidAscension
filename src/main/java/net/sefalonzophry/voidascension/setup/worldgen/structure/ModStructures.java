package net.sefalonzophry.voidascension.setup.worldgen.structure;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import net.sefalonzophry.voidascension.VoidAscension;
import net.sefalonzophry.voidascension.setup.worldgen.structure.structures.AltarStructure;
import net.sefalonzophry.voidascension.setup.worldgen.structure.structures.FuserStructure;
import net.sefalonzophry.voidascension.setup.worldgen.structure.structures.KeepStructure;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.Map;

public class ModStructures {
    public static final DeferredRegister<Structure<?>> STRUCTURES =
            DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, VoidAscension.MOD_ID);

    public static final RegistryObject<Structure<NoFeatureConfig>> ALTAR =
            STRUCTURES.register("altar", AltarStructure::new);

    public static final RegistryObject<Structure<NoFeatureConfig>> FUSER =
            STRUCTURES.register("fuser", FuserStructure::new);

    public static final RegistryObject<Structure<NoFeatureConfig>> KEEP =
            STRUCTURES.register("keep", KeepStructure::new);

    public static void setupStructures() {
        setupMapSpacingAndLand(ALTAR.get(),
                new StructureSeparationSettings(70,25, 1234567890),
                true);

        setupMapSpacingAndLand(FUSER.get(),
                new StructureSeparationSettings(125, 30, 547983755),
                true);

        setupMapSpacingAndLand(KEEP.get(),
                new StructureSeparationSettings(65, 25, 754359374),
                true);
    }

    public static <F extends Structure<?>> void setupMapSpacingAndLand(F structure, StructureSeparationSettings structureSeparationSettings,
                                                                       boolean transformSurroundingLand) {

        Structure.STRUCTURES_REGISTRY.put(structure.getRegistryName().toString(), structure);

        if (transformSurroundingLand) {
            Structure.NOISE_AFFECTING_FEATURES = ImmutableList.<Structure<?>>builder()
                    .addAll(Structure.NOISE_AFFECTING_FEATURES)
                    .add(structure)
                    .build();
        }

        DimensionStructuresSettings.DEFAULTS =
                ImmutableMap.<Structure<?>, StructureSeparationSettings>builder()
                        .putAll(DimensionStructuresSettings.DEFAULTS)
                        .put(structure, structureSeparationSettings)
                        .build();

        WorldGenRegistries.NOISE_GENERATOR_SETTINGS.entrySet().forEach(settings -> {
            Map<Structure<?>, StructureSeparationSettings> structureMap =
                    settings.getValue().structureSettings().structureConfig();

            if (structureMap instanceof ImmutableMap) {
                Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(structureMap);
                tempMap.put(structure, structureSeparationSettings);
                settings.getValue().structureSettings().structureConfig();

            } else {
                structureMap.put(structure, structureSeparationSettings);
            }
        });
    }

    public static void register(IEventBus eventBus) {
        STRUCTURES.register(eventBus);
    }
}
