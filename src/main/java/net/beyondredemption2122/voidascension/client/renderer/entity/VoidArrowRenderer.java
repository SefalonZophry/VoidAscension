package net.beyondredemption2122.voidascension.client.renderer.entity;

import net.beyondredemption2122.voidascension.VoidAscension;
import net.beyondredemption2122.voidascension.setup.world.entity.projectile.VoidArrow;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class VoidArrowRenderer extends ArrowRenderer<VoidArrow> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(VoidAscension.MOD_ID, "textures/entity/void_arrow.png");

    public VoidArrowRenderer(EntityRendererManager manager) {
        super(manager);
    }

    public ResourceLocation getTextureLocation(VoidArrow arrow) {
        return TEXTURE;
    }
}