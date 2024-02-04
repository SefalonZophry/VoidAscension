package net.sefalonzophry.voidascension.client.renderer.entity;

import net.minecraft.resources.ResourceLocation;
import net.sefalonzophry.voidascension.VoidAscension;
import net.sefalonzophry.voidascension.setup.worldgen.world.entity.projectile.VoidArrow;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class VoidArrowRenderer extends ArrowRenderer<VoidArrow> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(VoidAscension.MOD_ID, "textures/entity/void_arrow.png");

    public VoidArrowRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
    }

    public ResourceLocation getTextureLocation(VoidArrow arrow) {
        return TEXTURE;
    }
}