package net.sefalonzophry.voidascension.setup.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.sefalonzophry.voidascension.VoidAscension;
import net.sefalonzophry.voidascension.setup.Registration;
//import net.sefalonzophry.voidascension.setup.customblocks.tileentities.AltarTileEntity;
import net.sefalonzophry.voidascension.setup.block.custom.Chalice;
import net.sefalonzophry.voidascension.setup.block.custom.ModFlammableRotatedPillarBlock;
import net.sefalonzophry.voidascension.setup.moditems.ModItems;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.sefalonzophry.voidascension.setup.worldgen.tree.VoidTouchedTreeGrower;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, VoidAscension.MOD_ID);


    //Custom Blocks

//    public static final RegistryObject<Block> ALTAR = Registration.BLOCKS.register("altar", AltarTileEntity::new);

    public static final RegistryObject<Block> CHALICE = Registration.BLOCKS.register("chalice", Chalice::new);

//    public static final RegistryObject<Block> PEDESTAL = Registration.BLOCKS.register("pedestal", Pedestal::new);

    //Blocks

    public static final RegistryObject<Block> VOID_STONE = registerBlock("void_stone", () ->
            new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(3, 10)
                    .sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> VOID_PILLAR_TOP = registerBlock("void_pillar_top", () ->
            new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(3, 10)
                    .sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> VOID_STAIRS = registerBlock("void_stairs",
            () -> new StairBlock(() -> VOID_STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE)
                            .strength(3,10)
                            .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> VOID_FENCE = registerBlock("void_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(3,10)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> VOID_SLAB = registerBlock("void_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(3,10)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> VOID_TOUCHED_LOG = registerBlock("void_touched_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)
                    .strength(3,10)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> VOID_TOUCHED_WOOD = registerBlock("void_touched_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)
                    .strength(3,10)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> STRIPPED_VOID_TOUCHED_LOG = registerBlock("stripped_void_touched_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)
                    .strength(3,10)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> STRIPPED_VOID_TOUCHED_WOOD = registerBlock("stripped_void_touched_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)
                    .strength(3,10)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> VOID_TOUCHED_PLANKS = registerBlock("void_touched_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)
                    .requiresCorrectToolForDrops()) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return false;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 0;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 0;
                }
            });

    public static final RegistryObject<Block> VOID_TOUCHED_LEAVES = registerBlock("void_touched_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return false;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 0;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 0;
                }
            });

    public static final RegistryObject<Block> VOID_TOUCHED_TREE_SAPLING = registerBlock("void_touched_tree_sapling",
            () -> new SaplingBlock(new VoidTouchedTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    //Ore Blocks

    public static final RegistryObject<Block> VOID_CRYSTAL_ORE_BLOCK = registerBlock("void_crystal_ore_block", () ->
            new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(3, 10)
                    .sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> DEEPSLATE_VOID_CRYSTAL_ORE_BLOCK = registerBlock("deepslate_void_crystal_ore_block", () ->
            new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(3, 10)
                    .sound(SoundType.DEEPSLATE)
                    .requiresCorrectToolForDrops()));

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
