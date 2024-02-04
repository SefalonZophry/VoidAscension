package net.sefalonzophry.voidascension.setup.entity.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.sefalonzophry.voidascension.VoidAscension;
import net.sefalonzophry.voidascension.setup.entity.ModModelLayers;
import net.sefalonzophry.voidascension.setup.entity.custom.InjectorEntity;
import net.sefalonzophry.voidascension.setup.entity.model.InjectorModel;
import net.minecraft.resources.ResourceLocation;

public class InjectorRenderer extends MobRenderer<InjectorEntity, InjectorModel<InjectorEntity>> {
    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(VoidAscension.MOD_ID, "textures/entity/injector.png");

    public InjectorRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new InjectorModel<>(pContext.bakeLayer(ModModelLayers.INJECTOR)), 0.6F);
    }

    @Override
    public ResourceLocation getTextureLocation(InjectorEntity entity) {
        return TEXTURE;
    }

    public static void register() {}
}

