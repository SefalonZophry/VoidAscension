package net.sefalonzophry.voidascension.events;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.sefalonzophry.voidascension.VoidAscension;
import net.sefalonzophry.voidascension.data.client.ModItemModelProperties;
import net.sefalonzophry.voidascension.setup.entity.ModEntityTypes;
import net.sefalonzophry.voidascension.setup.entity.ModModelLayers;
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
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = VoidAscension.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.INJECTOR, InjectorModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.VOID_SPAWN, VoidSpawnModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.ELITE_VOID_SPAWN, EliteVoidSpawnModel::createBodyLayer);
    }


    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        EntityRenderers.register(ModEntityTypes.INJECTOR.get(), InjectorRenderer::new);
        EntityRenderers.register(ModEntityTypes.VOIDSPAWN.get(), VoidSpawnRenderer::new);
        EntityRenderers.register(ModEntityTypes.ELITEVOIDSPAWN.get(), EliteVoidSpawnRenderer::new);

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
