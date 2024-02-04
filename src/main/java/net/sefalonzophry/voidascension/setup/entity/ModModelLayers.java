package net.sefalonzophry.voidascension.setup.entity;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.sefalonzophry.voidascension.VoidAscension;

public class ModModelLayers {
    public static final ModelLayerLocation INJECTOR = new ModelLayerLocation(
            new ResourceLocation(VoidAscension.MOD_ID, "injector"), "main");

    public static final ModelLayerLocation VOID_SPAWN = new ModelLayerLocation(
            new ResourceLocation(VoidAscension.MOD_ID, "void_spawn"), "main");

    public static final ModelLayerLocation ELITE_VOID_SPAWN = new ModelLayerLocation(
            new ResourceLocation(VoidAscension.MOD_ID, "elite_void_spawn"), "main");
}
