package net.sefalonzophry.voidascension.events;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sefalonzophry.voidascension.VoidAscension;
import net.sefalonzophry.voidascension.setup.entity.ModEntityTypes;
import net.sefalonzophry.voidascension.setup.entity.custom.EliteVoidSpawnEntity;
import net.sefalonzophry.voidascension.setup.entity.custom.InjectorEntity;
import net.sefalonzophry.voidascension.setup.entity.custom.VoidSpawnEntity;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.sefalonzophry.voidascension.setup.worldgen.dimension.ModDimensions;

@Mod.EventBusSubscriber(modid = VoidAscension.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModClientEvents {

    @SubscribeEvent
    public static void addEntityAttribute(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.VOIDSPAWN.get(), VoidSpawnEntity.setCustomAttribute().build());
        event.put(ModEntityTypes.ELITEVOIDSPAWN.get(), EliteVoidSpawnEntity.setCustomAttribute().build());
        event.put(ModEntityTypes.INJECTOR.get(), InjectorEntity.setCustomAttribute().build());
    }

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
//        ScreenManager(ContainerTypesinit.PEDESTAL_CONTAINER_TYPE.get(), PedestalScreen::new);

//        ClientRegistry.bindTileEntityRenderer(TileEntityTypesInit.PEDESTAL_TILE_ENTITY_TYPE.get(), PedestalTileEntityRenderer::new);
    }
}
