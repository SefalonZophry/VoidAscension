package net.beyondredemption2122.voidascension.events;

import net.beyondredemption2122.voidascension.setup.customblocks.tileentities.screen.PedestalScreen;
import net.beyondredemption2122.voidascension.setup.customblocks.tileentities.tileentityrenderer.PedestalTileEntityRenderer;
import net.beyondredemption2122.voidascension.setup.init.ContainerTypesinit;
import net.beyondredemption2122.voidascension.setup.init.TileEntityTypesInit;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.beyondredemption2122.voidascension.VoidAscension;
import net.beyondredemption2122.voidascension.setup.ModSpawnEggs;
import net.beyondredemption2122.voidascension.setup.entity.ModEntityTypes;
import net.beyondredemption2122.voidascension.setup.entity.custom.InjectorEntity;
import net.beyondredemption2122.voidascension.setup.entity.custom.VoidSpawnEntity;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;


@Mod.EventBusSubscriber(modid = VoidAscension.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModClientEvents {

    @SubscribeEvent
    public static void addEntityAttribute(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.VOIDSPAWN.get(), VoidSpawnEntity.setCustomAttribute().build());
        event.put(ModEntityTypes.ELITEVOIDSPAWN.get(), VoidSpawnEntity.setCustomAttribute().build());
        event.put(ModEntityTypes.INJECTOR.get(), InjectorEntity.setCustomAttribute().build());
    }

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        ScreenManager.register(ContainerTypesinit.PEDESTAL_CONTAINER_TYPE.get(), PedestalScreen::new);

        ClientRegistry.bindTileEntityRenderer(TileEntityTypesInit.PEDESTAL_TILE_ENTITY_TYPE.get(), PedestalTileEntityRenderer::new);
    }

    @SubscribeEvent
    public static void onRegisterEntities(RegistryEvent.Register<EntityType<?>> event) {
        ModSpawnEggs.initSpawnEggs();
    }
}
