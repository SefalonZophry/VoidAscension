package net.sefalonzophry.voidascension.setup.entity.render;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.sefalonzophry.voidascension.VoidAscension;
import net.sefalonzophry.voidascension.setup.entity.custom.InjectorEntity;
import net.sefalonzophry.voidascension.setup.entity.model.InjectorModel;

public class InjectorRenderer extends MobRenderer<InjectorEntity, InjectorModel<InjectorEntity>>
{
    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(VoidAscension.MOD_ID, "textures/entity/injector.png");

    public InjectorRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new InjectorModel<>(), 0.6F);
    }

    @Override
    public ResourceLocation getTextureLocation(InjectorEntity entity) {
        return TEXTURE;
    }

    public static void register() {}
}

