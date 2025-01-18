package net.sefalonzophry.voidascension.events;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sefalonzophry.voidascension.VoidAscension;
import net.sefalonzophry.voidascension.setup.moditems.ModItems;
import net.sefalonzophry.voidascension.villager.ModVillagers;

import java.util.List;

@Mod.EventBusSubscriber(modid = VoidAscension.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if (event.getType() == ModVillagers.VOID_SPECIALIST.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 4),
                    new ItemStack(ModItems.EMPTY_VOID_ESSENCE_CAPSULE.get(), 5),
                    4,6,0.04f));

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.VOID_CRYSTAL.get(), 1),
                    new ItemStack(ModItems.VOID_ESSENCE.get(), 5),
                    10,3,0.03f));

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.FLAWED_VOID_SWORD_POWERED.get(), 1),
                    new ItemStack(ModItems.UNSTABLE_VOID_CRYSTAL.get(), 2),
                    new ItemStack(ModItems.ACCEPTABLE_VOID_SWORD_POWERED.get(), 1),
                    10,3,0.03f));
        }
    }
}