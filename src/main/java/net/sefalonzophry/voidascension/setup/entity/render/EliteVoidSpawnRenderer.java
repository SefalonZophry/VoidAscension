package net.sefalonzophry.voidascension.setup.entity.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.sefalonzophry.voidascension.VoidAscension;
import net.sefalonzophry.voidascension.setup.entity.ModModelLayers;
import net.sefalonzophry.voidascension.setup.entity.custom.VoidSpawnEntity;
import net.sefalonzophry.voidascension.setup.entity.model.VoidSpawnModel;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class EliteVoidSpawnRenderer extends MobRenderer<VoidSpawnEntity, VoidSpawnModel<VoidSpawnEntity>> {
    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(VoidAscension.MOD_ID, "textures/entity/elitevoidspawn.png");

    public EliteVoidSpawnRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new VoidSpawnModel<>(pContext.bakeLayer(ModModelLayers.ELITE_VOID_SPAWN)), 0.6F);
    }

    @Override
    public ResourceLocation getTextureLocation(VoidSpawnEntity entity) {
        return TEXTURE;
    }

    public static void register() {}
}
