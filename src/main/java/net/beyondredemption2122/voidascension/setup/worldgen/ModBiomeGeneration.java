package net.beyondredemption2122.voidascension.setup.worldgen;

import net.beyondredemption2122.voidascension.setup.worldgen.biome.DeepVoid;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.registries.ForgeRegistries;
import net.beyondredemption2122.voidascension.setup.worldgen.biome.VoidTouchedBome;

import java.util.Objects;

public class ModBiomeGeneration {
    public static void generateBiomes() {
        addBiome(VoidTouchedBome.VOID_TOUCHED_BIOME.get(), BiomeManager.BiomeType.COOL, 20);
    }

    private static void addBiome(Biome biome, BiomeManager.BiomeType type, int weight, BiomeDictionary.Type... types) {
        RegistryKey<Biome> key = RegistryKey.create(ForgeRegistries.Keys.BIOMES,
                Objects.requireNonNull(ForgeRegistries.BIOMES.getKey(biome)));

        BiomeDictionary.addTypes(key, types);
        BiomeManager.addBiome(type, new BiomeManager.BiomeEntry(key, weight));
    }
}
