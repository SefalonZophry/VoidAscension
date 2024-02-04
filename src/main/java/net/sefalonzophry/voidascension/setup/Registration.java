package net.sefalonzophry.voidascension.setup;

import net.sefalonzophry.voidascension.VoidAscension;
import net.sefalonzophry.voidascension.setup.customblocks.*;
//import net.sefalonzophry.voidascension.setup.customblocks.tileentities.AltarTileEntity;
import net.sefalonzophry.voidascension.setup.moditems.ModItems;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.*;
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
//        Pedestal.register();
        ModBlocks.register(eventBus);
        ModItems.register(eventBus);
    }
}
