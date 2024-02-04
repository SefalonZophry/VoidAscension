package net.sefalonzophry.voidascension.setup.worldgen;

import net.minecraft.resources.ResourceLocation;
import net.sefalonzophry.voidascension.VoidAscension;
import terrablender.api.Regions;

public class Terrablender {

    public static void registerBiomes() {
        Regions.register(new ModOverworldRegion(new ResourceLocation(VoidAscension.MOD_ID, "overworld"), 5));
    }
}
