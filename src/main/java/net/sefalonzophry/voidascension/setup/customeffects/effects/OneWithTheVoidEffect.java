/*
package net.sefalonzophry.voidascension.setup.customeffects.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class OneWithTheVoidEffect extends MobEffect {
    protected OneWithTheVoidEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if (this == ModEffects.ONE_WITH_THE_VOID.get()) {
            if (pLivingEntity instanceof Player && pLivingEntity.isAlive()) {
                pLivingEntity.addEffect(new MobEffectInstance(ModEffects.ONE_WITH_THE_VOID.get()));
            }
        }
        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
*/