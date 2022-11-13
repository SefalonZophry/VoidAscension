package net.beyondredemption2122.voidascension.setup.customblocks;

import net.beyondredemption2122.voidascension.setup.Registration;
import net.beyondredemption2122.voidascension.setup.customblocks.tileentities.AltarTileEntity;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.beyondredemption2122.voidascension.data.RiftsItemGroup;

import java.util.function.Supplier;

public class ModBlocks {

    //Custom Blocks

    public static final RegistryObject<Block> RIFT_CRYSTAL_ORE_BLOCK = Registration.BLOCKS.register("rift_crystal_ore_block", CrystalOre::new);

    public static final RegistryObject<Block> ALTAR = Registration.BLOCKS.register("altar", AltarTileEntity::new);

    public static final RegistryObject<Block> CHALICE = Registration.BLOCKS.register("chalice", Chalice::new);

    public static final RegistryObject<Block> PEDESTAL = Registration.BLOCKS.register("pedestal", Pedestal::new);

    //Blocks

    public static final RegistryObject<Block> VOID_STONE = register("void_stone", () ->
            new Block(AbstractBlock.Properties.of(Material.STONE)
                    .strength(3, 10)
                    .harvestLevel(4)
                    .harvestTool(ToolType.PICKAXE)
                    .sound(SoundType.STONE)));

    public static final RegistryObject<Block> VOID_PILLAR_TOP = register("void_pillar_top", () ->
            new Block(AbstractBlock.Properties.of(Material.STONE)
                    .strength(5, 10)
                    .harvestLevel(4)
                    .harvestTool(ToolType.PICKAXE)
                    .sound(SoundType.STONE)));

    public static final RegistryObject<Block> VOID_STAIRS = register("void_stairs",
            () -> new StairsBlock(() -> VOID_STONE.get().defaultBlockState(),
                    AbstractBlock.Properties.of(Material.STONE)
                            .harvestLevel(3)
                            .harvestTool(ToolType.PICKAXE)));

    public static final RegistryObject<Block> VOID_FENCE = register("void_fence",
            () -> new FenceBlock(AbstractBlock.Properties.of(Material.STONE)
                            .harvestLevel(3)
                            .harvestTool(ToolType.PICKAXE)));

    public static final RegistryObject<Block> VOID_SLAB = register("void_slab",
            () -> new SlabBlock(AbstractBlock.Properties.of(Material.STONE)
                    .harvestLevel(3)
                    .harvestTool(ToolType.PICKAXE)));

    private static <T extends Block> RegistryObject<T> registerNoItem(String name, Supplier<T> block) {
        return Registration.BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> ret = registerNoItem(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(ret.get(), new Item.Properties().tab(RiftsItemGroup.creativeTab)));
        return ret;
    }

    public static void register() {}
}
