package net.sefalonzophry.voidascension.setup.block.custom;


import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.sefalonzophry.voidascension.setup.worldgen.dimension.ChaliceTeleporter;
import net.sefalonzophry.voidascension.setup.worldgen.dimension.ModDimensions;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.MinecraftServer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.CollisionContext;

public class Chalice extends Block {

    public static final VoxelShape SHAPE_N = Block.box(0, 0, 0, 16, 16, 16);

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE_N;
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pPlayer.canChangeDimensions()) {
            handleVoidPortal(pPlayer, pPos);
            return InteractionResult.SUCCESS;
        } else {
            return InteractionResult.CONSUME;
        }
    }



    private void handleVoidPortal(Entity player, BlockPos pPos) {
        if (player.level() instanceof ServerLevel serverlevel) {
            MinecraftServer minecraftserver = serverlevel.getServer();
            ResourceKey<Level> resourcekey = player.level().dimension() == ModDimensions.VOID_LEVEL_KEY ?
                    Level.OVERWORLD : ModDimensions.VOID_LEVEL_KEY;

            ServerLevel portalDimension = minecraftserver.getLevel(resourcekey);
            if (portalDimension != null && !player.isPassenger()) {
                if(resourcekey == ModDimensions.VOID_LEVEL_KEY) {
                    player.changeDimension(portalDimension, new ChaliceTeleporter(pPos, true));
                } else {
                    player.changeDimension(portalDimension, new ChaliceTeleporter(pPos, false));
                }
            }
        }
    }
    public Chalice() {
        super (BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                .strength(3.0f,2.0f)
                .requiresCorrectToolForDrops()
                .noOcclusion());
    }

    public static void register() {}
}
