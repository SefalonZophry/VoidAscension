package net.sefalonzophry.voidascension.events;

import net.sefalonzophry.voidascension.VoidAscension;
import net.sefalonzophry.voidascension.data.client.ModItemModelProperties;
import net.sefalonzophry.voidascension.setup.entity.ModEntityTypes;
import net.sefalonzophry.voidascension.setup.entity.custom.EliteVoidSpawnEntity;
import net.sefalonzophry.voidascension.setup.entity.custom.InjectorEntity;
import net.sefalonzophry.voidascension.setup.entity.custom.VoidSpawnEntity;
import net.sefalonzophry.voidascension.setup.entity.model.EliteVoidSpawnModel;
import net.sefalonzophry.voidascension.setup.entity.model.InjectorModel;
import net.sefalonzophry.voidascension.setup.entity.model.VoidSpawnModel;
import net.sefalonzophry.voidascension.setup.entity.render.EliteVoidSpawnRenderer;
import net.sefalonzophry.voidascension.setup.entity.render.InjectorRenderer;
import net.sefalonzophry.voidascension.setup.entity.render.VoidSpawnRenderer;
import net.sefalonzophry.voidascension.setup.moditems.ModItems;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = VoidAscension.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {


    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.INJECTOR.get(), InjectorRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.VOIDSPAWN.get(), VoidSpawnRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ELITEVOIDSPAWN.get(), EliteVoidSpawnRenderer::new);

        InjectorRenderer.register();
        InjectorModel.register();
        InjectorEntity.register();
        VoidSpawnRenderer.register();
        VoidSpawnModel.register();
        VoidSpawnEntity.register();
        EliteVoidSpawnRenderer.register();
        EliteVoidSpawnModel.register();
        EliteVoidSpawnEntity.register();

        ModItemModelProperties.makeBow(ModItems.VOID_BOW.get());
    }
}
