package net.sefalonzophry.voidascension.setup.worldgen;

import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.sefalonzophry.voidascension.VoidAscension;

public class ModConfiguredSurfaceBuilder {

    public static ConfiguredSurfaceBuilder<?> VOID_TOUCHED_BIOME = register("void_touched_biome",
             SurfaceBuilder.DEFAULT.configured(new SurfaceBuilderConfig(
                    Blocks.GRASS_BLOCK.defaultBlockState(),
                    Blocks.DIRT.defaultBlockState(),
                    Blocks.DIRT.defaultBlockState()
            )));

    public static ConfiguredSurfaceBuilder<?> DEEP_VOID = register("deep_void",
            SurfaceBuilder.DEFAULT.configured(new SurfaceBuilderConfig(
                    Blocks.GRASS_BLOCK.defaultBlockState(),
                    Blocks.DIRT.defaultBlockState(),
                    Blocks.DIRT.defaultBlockState()
            )));

    private static <SC extends ISurfaceBuilderConfig>ConfiguredSurfaceBuilder<SC> register(String name,
                                                                                           ConfiguredSurfaceBuilder<SC> csb) {
        return WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_SURFACE_BUILDER,
                new ResourceLocation(VoidAscension.MOD_ID, name), csb);
    }
}
