package net.sefalonzophry.voidascension.setup.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.sefalonzophry.voidascension.setup.moditems.ModItems;

public class DarkenedVoidStone extends Block {

    public DarkenedVoidStone() {
        super(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK)
                .strength(3, 2)
                .sound(SoundType.STONE)
                .requiresCorrectToolForDrops());
    }
    /*
    @Override
    public boolean canHarvestBlock(BlockState state, BlockGetter level, BlockPos pos, Player player) {
        if (player.getItemInHand(InteractionHand.MAIN_HAND).is(ModItems.VOID_NYTHRIL_PICKAXE.get()))
            return true;
    }
*/
}
