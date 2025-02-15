package net.sefalonzophry.voidascension.setup.moditems.custom.usableitems;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.sefalonzophry.voidascension.setup.block.ModBlocks;
import net.sefalonzophry.voidascension.setup.moditems.ModItems;

public class HeartQuickActionReleaseSystem extends Item {
    public HeartQuickActionReleaseSystem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if (!pContext.getLevel().isClientSide()) {
            Player player = pContext.getPlayer();
            Level level = pContext.getLevel();
            BlockPos blockpos = pContext.getClickedPos();
            BlockState blockstate = level.getBlockState(blockpos);

            if (blockstate.is(ModBlocks.VOID_SPIKE_HEART.get())) {

            } else if (!blockstate.is(ModBlocks.VOID_SPIKE_HEART.get())) {
                return InteractionResult.FAIL;
            }
            level.removeBlock(blockpos, false);
            player.addItem(new ItemStack(ModItems.VOID_NYTHRIL_LIVING_CRYSTAL.get()));
        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                player -> player.broadcastBreakEvent(player.getUsedItemHand()));


        return InteractionResult.SUCCESS;
    }
}