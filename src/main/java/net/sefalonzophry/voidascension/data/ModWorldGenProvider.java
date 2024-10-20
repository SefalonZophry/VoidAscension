package net.sefalonzophry.voidascension.data;


import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;
import net.sefalonzophry.voidascension.VoidAscension;
import net.sefalonzophry.voidascension.setup.customeffects.VoidDecayDamage;
import net.sefalonzophry.voidascension.setup.worldgen.ModBiomeModifiers;
import net.sefalonzophry.voidascension.setup.worldgen.ModConfiguredFeatures;
import net.sefalonzophry.voidascension.setup.worldgen.ModPlacedFeatures;
import net.sefalonzophry.voidascension.setup.worldgen.biome.VoidTouchedBiome;
import net.sefalonzophry.voidascension.setup.worldgen.dimension.ModDimensions;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.DAMAGE_TYPE, VoidDecayDamage::bootstrap)
            .add(Registries.DIMENSION_TYPE, ModDimensions::bootstrapType)
            .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap)
            .add(Registries.BIOME, VoidTouchedBiome::boostrap)
            .add(Registries.LEVEL_STEM, ModDimensions::bootstrapStem);

    public ModWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(VoidAscension.MOD_ID));
    }
}
