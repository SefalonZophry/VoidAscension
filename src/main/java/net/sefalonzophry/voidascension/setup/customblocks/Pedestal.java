package net.sefalonzophry.voidascension.setup.customblocks;

import net.sefalonzophry.voidascension.setup.customblocks.tileentities.PedestalTileEntity;
import net.sefalonzophry.voidascension.setup.init.TileEntityTypesInit;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;

public class Pedestal extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.FACING;

    private static final VoxelShape SHAPE_N = VoxelShapes.join(
            Block.box(6, 1, 6, 10, 2, 10),
            Block.box(5, 0, 5, 11, 1, 11),
    IBooleanFunction.OR);


    public Pedestal() {
        super(AbstractBlock.Properties.of(Material.STONE)
                .strength(3.0f, 2.0f)
                .sound(SoundType.STONE)
                .harvestTool(ToolType.PICKAXE)
                .requiresCorrectToolForDrops());
    }

    @Override
    public VoxelShape getShape(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {
        return SHAPE_N;
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }
    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> p_206840_1_) {
        p_206840_1_.add(FACING);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return TileEntityTypesInit.PEDESTAL_TILE_ENTITY_TYPE.get().create();
    }

    @Override
    public ActionResultType use(BlockState pState, World pLevel, BlockPos pPos, PlayerEntity pPlayer,
                                Hand pHand, BlockRayTraceResult pHit) {
        if (!pLevel.isClientSide()) {
            TileEntity PedestalTileEntity = pLevel.getBlockEntity(pPos);
            if (PedestalTileEntity instanceof PedestalTileEntity) {
                NetworkHooks.openGui((ServerPlayerEntity) pPlayer, (PedestalTileEntity) PedestalTileEntity, pPos);
            }
        }
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }

    public static void register() {}
}
