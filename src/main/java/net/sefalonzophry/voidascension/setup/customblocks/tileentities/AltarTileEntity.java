/*package net.sefalonzophry.voidascension.setup.customblocks.tileentities;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

import java.util.stream.Stream;

public class AltarTileEntity extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.FACING;

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.box(7, 2, 7, 9, 11, 9),
            Block.box(4, 0, 4, 12, 1, 12),
            Block.box(5, 1, 5, 11, 2, 11),
            Block.box(6, 11, 6, 10, 12, 10),
            Block.box(6, 11, 3, 7, 13, 6),
            Block.box(9, 11, 3, 10, 13, 6),
            Block.box(7, 11, 4, 9, 12, 6),
            Block.box(7, 11, 3, 9, 13, 4),
            Block.box(10, 11, 9, 13, 13, 10),
            Block.box(10, 11, 7, 12, 12, 9),
            Block.box(12, 11, 7, 13, 13, 9),
            Block.box(10, 11, 6, 13, 13, 7),
            Block.box(6, 11, 10, 7, 13, 13),
            Block.box(7, 11, 12, 9, 13, 13),
            Block.box(7, 11, 10, 9, 12, 12),
            Block.box(9, 11, 10, 10, 13, 13),
            Block.box(3, 11, 6, 6, 13, 7),
            Block.box(4, 11, 7, 6, 12, 9),
            Block.box(3, 11, 9, 6, 13, 10),
            Block.box(3, 11, 7, 4, 13, 9),
            Block.box(5, 12, 10, 6, 14, 11),
            Block.box(5, 12, 5, 6, 14, 6),
            Block.box(10, 12, 5, 11, 14, 6),
            Block.box(10, 12, 10, 11, 14, 11)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();


    public AltarTileEntity() {
        super (AbstractBlock.Properties.of(Material.METAL)
                .strength(3.0f,2.0f)
                .sound(SoundType.ANVIL)
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



    public static void register() {}


}*/

