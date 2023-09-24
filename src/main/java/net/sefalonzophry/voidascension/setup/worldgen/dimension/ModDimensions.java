package net.sefalonzophry.voidascension.setup.worldgen.dimension;

import net.sefalonzophry.voidascension.VoidAscension;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class ModDimensions {
    public static RegistryKey<World> Void = RegistryKey.create(Registry.DIMENSION_REGISTRY,
            new ResourceLocation(VoidAscension.MOD_ID, "void"));
}
