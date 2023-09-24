package net.sefalonzophry.voidascension.setup.customblocks;

import net.sefalonzophry.voidascension.VoidAscension;
import net.sefalonzophry.voidascension.setup.Registration;
//import net.sefalonzophry.voidascension.setup.customblocks.tileentities.AltarTileEntity;
import net.sefalonzophry.voidascension.setup.moditems.ModItems;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.sefalonzophry.voidascension.data.RiftsItemGroup;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, VoidAscension.MOD_ID);


    //Custom Blocks

//    public static final RegistryObject<Block> ALTAR = Registration.BLOCKS.register("altar", AltarTileEntity::new);

    public static final RegistryObject<Block> CHALICE = Registration.BLOCKS.register("chalice", Chalice::new);

    public static final RegistryObject<Block> PEDESTAL = Registration.BLOCKS.register("pedestal", Pedestal::new);

    //Blocks

    public static final RegistryObject<Block> VOID_STONE = registerBlock("void_stone", () ->
            new Block(AbstractBlock.Properties.of(Material.STONE)
                    .strength(3, 10)
                    .harvestLevel(5)
                    .harvestTool(ToolType.PICKAXE)
                    .sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> VOID_PILLAR_TOP = registerBlock("void_pillar_top", () ->
            new Block(AbstractBlock.Properties.of(Material.STONE)
                    .strength(3, 10)
                    .harvestLevel(5)
                    .harvestTool(ToolType.PICKAXE)
                    .sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> VOID_STAIRS = registerBlock("void_stairs",
            () -> new StairsBlock(() -> VOID_STONE.get().defaultBlockState(),
                    AbstractBlock.Properties.of(Material.STONE)
                            .strength(3,10)
                            .harvestLevel(5)
                            .harvestTool(ToolType.PICKAXE)
                            .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> VOID_FENCE = registerBlock("void_fence",
            () -> new FenceBlock(AbstractBlock.Properties.of(Material.STONE)
                    .strength(3,10)
                    .harvestLevel(5)
                    .harvestTool(ToolType.PICKAXE)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> VOID_SLAB = registerBlock("void_slab",
            () -> new SlabBlock(AbstractBlock.Properties.of(Material.STONE)
                    .strength(3,10)
                    .harvestLevel(5)
                    .harvestTool(ToolType.PICKAXE)
                    .requiresCorrectToolForDrops()));

    //Ore Blocks

    public static final RegistryObject<Block> RIFT_CRYSTAL_ORE_BLOCK = registerBlock("rift_crystal_ore_block", () ->
            new Block(AbstractBlock.Properties.of(Material.STONE)
                    .strength(3, 10)
                    .harvestLevel(4)
                    .harvestTool(ToolType.PICKAXE)
                    .sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()));

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(RiftsItemGroup.creativeTab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
