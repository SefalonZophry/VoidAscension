package net.beyondredemption2122.voidascension.setup.entity.render;

import net.beyondredemption2122.voidascension.VoidAscension;
import net.beyondredemption2122.voidascension.setup.entity.custom.VoidSpawnEntity;
import net.beyondredemption2122.voidascension.setup.entity.model.VoidSpawnModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class EliteVoidSpawnRenderer extends MobRenderer<VoidSpawnEntity, VoidSpawnModel<VoidSpawnEntity>>
{
    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(VoidAscension.MOD_ID, "textures/entity/elitevoidspawn.png");

    public EliteVoidSpawnRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new VoidSpawnModel<>(), 0.6F);
    }

    @Override
    public ResourceLocation getTextureLocation(VoidSpawnEntity entity) {
        return TEXTURE;
    }

    public static void register() {}
}
