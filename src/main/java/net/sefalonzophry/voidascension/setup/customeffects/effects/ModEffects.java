/*
package net.sefalonzophry.voidascension.setup.customeffects.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sefalonzophry.voidascension.VoidAscension;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS
            = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, VoidAscension.MOD_ID);

    public static final RegistryObject<MobEffect> VOID_CORRUPTION = MOB_EFFECTS.register("void_corruption", () -> new VoidCorruptionEffect(MobEffectCategory.HARMFUL, 7125567).addAttributeModifier(Attributes.ATTACK_DAMAGE, "432b9a35-6e92-4f9e-8d3e-c1a03d6ae10e", -1.0F, AttributeModifier.Operation.ADDITION).addAttributeModifier(Attributes.ATTACK_SPEED, "867d5ebb-537d-4ca1-91b7-7b4d4f7e73a2", -2.35F, AttributeModifier.Operation.ADDITION));
    public static final RegistryObject<MobEffect> ONE_WITH_THE_VOID = MOB_EFFECTS.register("one_with_the_void", () -> new OneWithTheVoidEffect(MobEffectCategory.BENEFICIAL, 0).addAttributeModifier(Attributes.ATTACK_DAMAGE, "19a6ee88-9e64-43b7-8dd8-4a1d4ec5aaf6", 6.00F, AttributeModifier.Operation.ADDITION).addAttributeModifier(Attributes.ATTACK_SPEED, "53d07ab8-0b9e-47be-944b-06af6f11fa50", 2.50F, AttributeModifier.Operation.ADDITION));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
*/