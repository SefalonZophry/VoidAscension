package net.sefalonzophry.voidascension.client.renderer.entity;

import net.sefalonzophry.voidascension.VoidAscension;
import net.sefalonzophry.voidascension.setup.worldgen.world.entity.projectile.VoidArrow;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class VoidArrowRenderer extends ArrowRenderer<VoidArrow> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(VoidAscension.MOD_ID, "textures/entity/void_arrow.png");

    public VoidArrowRenderer(EntityRendererManager manager) {
        super(manager);
    }

    public ResourceLocation getTextureLocation(VoidArrow arrow) {
        return TEXTURE;
    }
}