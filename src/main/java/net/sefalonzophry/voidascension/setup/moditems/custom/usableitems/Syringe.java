/*
package net.sefalonzophry.voidascension.setup.moditems.custom.usableitems;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.sefalonzophry.voidascension.setup.customeffects.effects.ModEffects;
import org.jetbrains.annotations.NotNull;

public class Syringe extends Item {
    public Syringe(Properties pProperties) {
        super(pProperties);
    }

    @NotNull
    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        ItemStack stack = pPlayer.getItemInHand(pUsedHand);

        if (!pLevel.isClientSide) {
            if (pPlayer.hasEffect(ModEffects.VOID_CORRUPTION.get())) {
                pPlayer.kill();
            } else {
                pPlayer.addEffect( new MobEffectInstance(ModEffects.VOID_CORRUPTION.get(), 30));
            }
        }
        return new InteractionResultHolder<>(InteractionResult.SUCCESS, stack);
    }
}
*/