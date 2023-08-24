package net.beyondredemption2122.voidascension.setup;

import net.beyondredemption2122.voidascension.VoidAscension;
import net.beyondredemption2122.voidascension.setup.customblocks.*;
//import net.beyondredemption2122.voidascension.setup.customblocks.tileentities.AltarTileEntity;
import net.beyondredemption2122.voidascension.setup.moditems.ModItems;
import net.beyondredemption2122.voidascension.setup.entity.custom.EliteVoidSpawnEntity;
import net.beyondredemption2122.voidascension.setup.entity.custom.InjectorEntity;
import net.beyondredemption2122.voidascension.setup.entity.custom.VoidSpawnEntity;
import net.beyondredemption2122.voidascension.setup.entity.model.EliteVoidSpawnModel;
import net.beyondredemption2122.voidascension.setup.entity.model.InjectorModel;
import net.beyondredemption2122.voidascension.setup.entity.model.VoidSpawnModel;
import net.beyondredemption2122.voidascension.setup.entity.render.EliteVoidSpawnRenderer;
import net.beyondredemption2122.voidascension.setup.entity.render.InjectorRenderer;
import net.beyondredemption2122.voidascension.setup.entity.render.VoidSpawnRenderer;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = VoidAscension.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class Registration {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, VoidAscension.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, VoidAscension.MOD_ID);

    public static void register(IEventBus eventBus) {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);


//        AltarTileEntity.register();
        Chalice.register();
        Pedestal.register();
        ModBlocks.register(eventBus);
        ModItems.register(eventBus);
    }
}
