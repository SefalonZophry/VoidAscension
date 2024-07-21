package net.sefalonzophry.voidascension.setup.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.sefalonzophry.voidascension.setup.block.ModBlocks;
import net.sefalonzophry.voidascension.setup.moditems.ModItems;
import org.jetbrains.annotations.Nullable;

public class ModFlammableRotatedPillarBlock extends RotatedPillarBlock {
    public ModFlammableRotatedPillarBlock(Properties pProperties) {
        super(pProperties);
    }

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

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        if (context.getItemInHand().getItem() == ModItems.VOID_BATTLE_AXE.get()) {
            if (state.is(ModBlocks.VOID_TOUCHED_LOG.get())) {
                return ModBlocks.STRIPPED_VOID_TOUCHED_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }

            if (state.is(ModBlocks.VOID_TOUCHED_WOOD.get())) {
                return ModBlocks.STRIPPED_VOID_TOUCHED_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
        }

        return super.getToolModifiedState(state, context, toolAction, simulate);
    }
}
