package net.sefalonzophry.voidascension.setup.customeffects;


import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.RegistryObject;
import net.sefalonzophry.voidascension.VoidAscension;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS
            = DeferredRegister.create((ForgeRegistries.MOB_EFFECTS), VoidAscension.MOD_ID);

    public static final RegistryObject<MobEffect> VOID_DECAY = MOB_EFFECTS.register("void_decay",
            () -> new VoidDecayEffect(MobEffectCategory.HARMFUL, 2536796));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
