package net.sefalonzophry.voidascension.setup.customblocks;


import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
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

    public static final VoxelShape SHAPE_N = Block.box(0, 0, 0, 6, 7, 6);

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
                .requiresCorrectToolForDrops());
    }
    public VoxelShape getShape(BlockState p_220053_1_, BlockState p_220053_2_, BlockPos p_220053_3_, CollisionContext p_220053_4_) {
        return SHAPE_N;
    }

    public static void register() {}
}
