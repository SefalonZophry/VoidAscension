
package net.sefalonzophry.voidascension.events;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import net.sefalonzophry.voidascension.VoidAscension;
import net.sefalonzophry.voidascension.setup.customeffects.ModDamageSource;
import net.sefalonzophry.voidascension.setup.moditems.ModItems;
import net.sefalonzophry.voidascension.setup.worldgen.dimension.ModDimensions;

import java.util.List;


public class ForgeEventBusSubscriber {

    @Mod.EventBusSubscriber(modid = VoidAscension.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class ForgeEvents {
        @SubscribeEvent
        public static void ifInsideDeepVoid(TickEvent.PlayerTickEvent event) {
            if (event.side == LogicalSide.SERVER) {
                if (event.player.level().dimension() == ModDimensions.VOID_LEVEL_KEY) {
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
        public static void Purification(ItemExpireEvent event) {
            if (event.getEntity()) {
                if (event.getEntity)
            }
        }
         */

    }

    @Mod.EventBusSubscriber(modid = VoidAscension.MOD_ID)
    public static class ModEvents {
        @SubscribeEvent
        public static void addCustomWanderingTrades(WandererTradesEvent event) {
            List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
            List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

            genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 5),
                    new ItemStack(ModItems.EMPTY_VOID_ESSENCE_CAPSULE.get(), 2),
                    8, 6, 0.10f));
        }
    }
}



