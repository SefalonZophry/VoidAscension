package net.sefalonzophry.voidascension.events;

import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import net.sefalonzophry.voidascension.VoidAscension;
import net.sefalonzophry.voidascension.setup.customeffects.damagesources.ModDamageSource;
//import net.sefalonzophry.voidascension.setup.customeffects.effects.ModEffects;
import net.sefalonzophry.voidascension.setup.moditems.ModItems;
import net.sefalonzophry.voidascension.setup.worldgen.dimensions.Dimensions;

public class ForgeEventBusSubscriber {

    @Mod.EventBusSubscriber(modid = VoidAscension.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class ForgeEvents {
        @SubscribeEvent
        public static void ifInsideVoid(TickEvent.PlayerTickEvent event) {
            if (event.side == LogicalSide.SERVER) {
                if (event.player.level().dimension() == Dimensions.VOID_LEVEL_KEY) {
                    if (event.player.getInventory().contains(new ItemStack(ModItems.VOID_ENVIRONMENTAL_REFLECTOR.get()))) {
                    } else {
                        if (!event.player.getInventory().contains(new ItemStack(ModItems.VOID_ENVIRONMENTAL_REFLECTOR.get()))) {
                            DamageSource void_decay = new ModDamageSource(event.player.level().registryAccess()).void_decay();
                            event.player.hurt(void_decay, 1.5f);
                        }
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void ifInsideDeepVoid(TickEvent.PlayerTickEvent event) {
        if (event.side == LogicalSide.SERVER) {
            if (event.player.level().dimension() == Dimensions.DEEP_VOID_LEVEL_KEY) {
                if (event.player.getInventory().contains(new ItemStack(ModItems.VOID_ENVIRONMENTAL_REFLECTOR.get()))) {
                } else {
                    if (!event.player.getInventory().contains(new ItemStack(ModItems.VOID_ENVIRONMENTAL_REFLECTOR.get()))) {
                        DamageSource void_decay = new ModDamageSource(event.player.level().registryAccess()).void_decay();
                        event.player.hurt(void_decay, 1.5f);
                    }
                }
            }
        }
    }
/*
    @SubscribeEvent
    public static void oneWithTheVoid(TickEvent.ServerTickEvent servertick, TickEvent.PlayerTickEvent playertick, Player player) {
        if (playertick.side == LogicalSide.SERVER) {
            if () {
                player.addEffect(new MobEffectInstance(ModEffects.ONE_WITH_THE_VOID.get(), 72000));
            }
        }
    }
*/
}