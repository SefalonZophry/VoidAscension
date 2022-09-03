package net.beyondredemption2122.voidascension.setup.worldgen;

import net.beyondredemption2122.voidascension.setup.worldgen.biome.DeepVoid;
import net.beyondredemption2122.voidascension.setup.worldgen.biome.VoidTouchedBome;
import net.beyondredemption2122.voidascension.setup.worldgen.structure.ModStructures;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public class ModStructureGeneration {
    public static void generateStructures(final BiomeLoadingEvent event) {
        RegistryKey<Biome> key = RegistryKey.create(Registry.BIOME_REGISTRY, event.getName());
        Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);

        if(key.location().equals(VoidTouchedBome.VOID_TOUCHED_BIOME.get().getRegistryName()))  {
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.ALTAR.get().configured(IFeatureConfig.NONE));
        }

        if(key.location().equals(DeepVoid.DEEP_VOID.get().getRegistryName()))  {
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.ALTAR.get().configured(IFeatureConfig.NONE));
        }

        if(key.location().equals(DeepVoid.DEEP_VOID.get().getRegistryName()))  {
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.FUSER.get().configured(IFeatureConfig.NONE));
        }
    }
}
