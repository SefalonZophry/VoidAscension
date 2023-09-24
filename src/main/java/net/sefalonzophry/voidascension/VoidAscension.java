package net.sefalonzophry.voidascension;

import net.sefalonzophry.voidascension.client.renderer.entity.VoidArrowRenderer;
import net.sefalonzophry.voidascension.setup.CustomDimensionRenders;
import net.sefalonzophry.voidascension.setup.customeffects.ModEffects;
import net.sefalonzophry.voidascension.setup.init.ContainerTypesinit;
import net.sefalonzophry.voidascension.setup.init.TileEntityTypesInit;
import net.sefalonzophry.voidascension.setup.worldgen.world.entity.ModEntityType;
import net.sefalonzophry.voidascension.setup.worldgen.biome.DeepVoid;
import net.sefalonzophry.voidascension.setup.worldgen.structure.ModStructures;
import net.sefalonzophry.voidascension.setup.entity.render.EliteVoidSpawnRenderer;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.sefalonzophry.voidascension.setup.Registration;
import net.sefalonzophry.voidascension.setup.worldgen.biome.VoidTouchedBome;
import net.sefalonzophry.voidascension.setup.worldgen.ModBiomeGeneration;
import net.sefalonzophry.voidascension.setup.entity.ModEntityTypes;
import net.sefalonzophry.voidascension.setup.entity.render.InjectorRenderer;
import net.sefalonzophry.voidascension.setup.entity.render.VoidSpawnRenderer;

@Mod(VoidAscension.MOD_ID)
public class VoidAscension {
    public static final String MOD_ID = "voidascension";

    public VoidAscension() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus eventBus = modEventBus;

        Registration.register(eventBus);

        ModEntityTypes.register(eventBus);
        VoidTouchedBome.register(eventBus);
        DeepVoid.register(eventBus);

        ModStructures.register(eventBus);

        ModEffects.register(eventBus);

        ModEntityType.register(FMLJavaModLoadingContext.get().getModEventBus());

        TileEntityTypesInit.TILE_ENTITY_TYPE.register(eventBus);
        ContainerTypesinit.CONTAINER_TYPES.register(eventBus);

        modEventBus.addListener(this::setup);

        modEventBus.addListener(this::enqueueIMC);

        modEventBus.addListener(this::processIMC);

        modEventBus.addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {

        ModBiomeGeneration.generateBiomes();

        ModStructures.setupStructures();

        EntitySpawnPlacementRegistry.register(ModEntityTypes.VOIDSPAWN.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::checkMonsterSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.ELITEVOIDSPAWN.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::checkMonsterSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.INJECTOR.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::checkMonsterSpawnRules);

        ModEntityType.register(FMLJavaModLoadingContext.get().getModEventBus());



    }


    private void doClientStuff(final FMLClientSetupEvent event) {

        CustomDimensionRenders.init();

        RenderingRegistry.registerEntityRenderingHandler(ModEntityType.VOID_ARROW.get(), VoidArrowRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.VOIDSPAWN.get(), VoidSpawnRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ELITEVOIDSPAWN.get(), EliteVoidSpawnRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.INJECTOR.get(), InjectorRenderer::new);

    }

    private void enqueueIMC(final InterModEnqueueEvent event) {


    }

    private void processIMC(final InterModProcessEvent event) {


    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {

    }
}
