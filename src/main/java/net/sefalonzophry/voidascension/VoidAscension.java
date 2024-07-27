package net.sefalonzophry.voidascension;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.sefalonzophry.voidascension.client.renderer.entity.VoidArrowRenderer;
import net.sefalonzophry.voidascension.data.VoidAscensionCreativeTab;
//import net.sefalonzophry.voidascension.setup.CustomDimensionRenders;
//import net.sefalonzophry.voidascension.setup.init.ContainerTypesinit;
//import net.sefalonzophry.voidascension.setup.init.TileEntityTypesInit;
//import net.sefalonzophry.voidascension.setup.customeffects.ModEffects;
import net.sefalonzophry.voidascension.data.client.loot.ModLootModifiers;
import net.sefalonzophry.voidascension.setup.worldgen.ModConfiguredSurfaceBuilder;
import net.sefalonzophry.voidascension.setup.worldgen.Terrablender;
import net.sefalonzophry.voidascension.setup.worldgen.world.entity.ModEntityType;
import net.sefalonzophry.voidascension.setup.entity.render.EliteVoidSpawnRenderer;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.sefalonzophry.voidascension.setup.Registration;
import net.sefalonzophry.voidascension.setup.entity.ModEntityTypes;
import net.sefalonzophry.voidascension.setup.entity.render.InjectorRenderer;
import net.sefalonzophry.voidascension.setup.entity.render.VoidSpawnRenderer;
import terrablender.api.SurfaceRuleManager;

@Mod(VoidAscension.MOD_ID)
public class VoidAscension {
    public static final String MOD_ID = "voidascension";

    public VoidAscension() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus eventBus = modEventBus;

        VoidAscensionCreativeTab.register(eventBus);

        Registration.register(eventBus);

        ModEntityTypes.register(eventBus);

        ModLootModifiers.register(eventBus);

//        ModEffects.register(eventBus);

        Terrablender.registerBiomes();

        ModEntityType.register(FMLJavaModLoadingContext.get().getModEventBus());

//        TileEntityTypesInit.TILE_ENTITY_TYPE.register(eventBus);
//        ContainerTypesinit.CONTAINER_TYPES.register(eventBus);

        modEventBus.addListener(this::setup);

        modEventBus.addListener(this::enqueueIMC);

        modEventBus.addListener(this::processIMC);

        modEventBus.addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {

        SpawnPlacements.register(ModEntityTypes.VOIDSPAWN.get(), SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
        SpawnPlacements.register(ModEntityTypes.ELITEVOIDSPAWN.get(), SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
        SpawnPlacements.register(ModEntityTypes.INJECTOR.get(), SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);


        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, ModConfiguredSurfaceBuilder.makeRules());

        ModEntityType.register(FMLJavaModLoadingContext.get().getModEventBus());



    }


    private void doClientStuff(final FMLClientSetupEvent event) {

//        CustomDimensionRenders.init();

        EntityRenderers.register(ModEntityType.VOID_ARROW.get(), VoidArrowRenderer::new);
        EntityRenderers.register(ModEntityTypes.VOIDSPAWN.get(), VoidSpawnRenderer::new);
        EntityRenderers.register(ModEntityTypes.ELITEVOIDSPAWN.get(), EliteVoidSpawnRenderer::new);
        EntityRenderers.register(ModEntityTypes.INJECTOR.get(), InjectorRenderer::new);

    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
    }

    private void processIMC(final InterModProcessEvent event) {


    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }
}
