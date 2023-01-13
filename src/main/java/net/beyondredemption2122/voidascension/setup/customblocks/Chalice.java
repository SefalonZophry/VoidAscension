package net.beyondredemption2122.voidascension.setup.customblocks;


import net.beyondredemption2122.voidascension.setup.worldgen.dimension.ChaliceTeleporter;
import net.beyondredemption2122.voidascension.setup.worldgen.dimension.ModDimensions;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;

import java.util.stream.Stream;

public class Chalice extends Block {

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.box(10, 6, 6, 11, 7, 7),
            Block.box(9, 6, 5, 10, 7, 6),
            Block.box(9, 5, 6, 10, 6, 7),
            Block.box(10, 6, 9, 11, 7, 10),
            Block.box(9, 5, 9, 10, 6, 10),
            Block.box(9, 6, 10, 10, 7, 11),
            Block.box(11, 6, 7, 12, 7, 9),
            Block.box(4, 6, 7, 5, 7, 9),
            Block.box(5, 5, 7, 6, 6, 9),
            Block.box(7, 5, 5, 9, 6, 6),
            Block.box(7, 6, 11, 9, 7, 12),
            Block.box(5, 6, 9, 6, 7, 10),
            Block.box(6, 5, 9, 7, 6, 10),
            Block.box(5, 6, 6, 6, 7, 7),
            Block.box(6, 6, 10, 7, 7, 11),
            Block.box(7, 5, 10, 9, 6, 11),
            Block.box(7, 6, 4, 9, 7, 5),
            Block.box(10, 5, 7, 11, 6, 9),
            Block.box(6, 6, 5, 7, 7, 6),
            Block.box(6, 5, 6, 7, 6, 7),
            Block.box(9, 4, 7, 10, 5, 9),
            Block.box(6, 4, 7, 7, 5, 9),
            Block.box(7, 4, 9, 9, 5, 10),
            Block.box(7, 4, 6, 9, 5, 7),
            Block.box(7, 1, 7, 9, 5, 9),
            Block.box(7, 1, 9, 9, 2, 10),
            Block.box(7, 0, 10, 9, 1, 11),
            Block.box(9, 1, 7, 10, 2, 9),
            Block.box(10, 0, 7, 11, 1, 9),
            Block.box(5, 0, 7, 6, 1, 9),
            Block.box(6, 1, 7, 7, 2, 9),
            Block.box(5.9999999999999964, 0, 6, 10, 1, 10),
            Block.box(7, 1, 6, 9, 2, 7),
            Block.box(7, 0, 5, 9, 1, 6)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

    @Override
    public ActionResultType use(BlockState state, World worldIn, BlockPos pos,
                                             PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (!worldIn.isClientSide()) {
            if (!player.isCrouching()) {
                MinecraftServer server = worldIn.getServer();

                if (server != null) {
                    if (worldIn.dimension() == ModDimensions.Void) {
                        ServerWorld overWorld = server.getLevel(World.OVERWORLD);
                        if (overWorld != null) {
                            player.changeDimension(overWorld, new ChaliceTeleporter(pos, false));
                        }
                    } else {
                        ServerWorld vd = server.getLevel(ModDimensions.Void);
                        if (vd != null) {
                            player.changeDimension(vd, new ChaliceTeleporter(pos, true));
                        }
                    }
                    return ActionResultType.SUCCESS;
                }
            }
        }

        return super.use(state, worldIn, pos, player, handIn, hit);
    }

    public Chalice() {
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

    public static void register() {}
}
