package net.sefalonzophry.voidascension.setup.customeffects;

import net.minecraft.world.damagesource.*;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.fml.common.Mod;
import net.sefalonzophry.voidascension.VoidAscension;

@Mod.EventBusSubscriber(modid = VoidAscension.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class VoidDecayEffect extends MobEffect {

    public VoidDecayEffect(MobEffectCategory mobEffectCategory, int Color) {
        super(mobEffectCategory, Color);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if (!pLivingEntity.level().isClientSide()) {

            DamageSource Void_Decay = new ModDamageSources(pLivingEntity.level().registryAccess()).void_decay();
            pLivingEntity.hurt(Void_Decay, 2f);
        }
    }
}
