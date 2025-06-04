package net.sefalonzophry.voidascension.events;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.SpawnData;
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
                    3,6,0.04f));

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.VOID_CRYSTAL.get(), 1),
                    new ItemStack(ModItems.VOID_ESSENCE.get(), 5),
                    5,3,0.03f));

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.VOID_ARROW_HEAD.get(), 2),
                    new ItemStack(ModItems.VOID_ARROW_SHAFT.get(), 2),
                    new ItemStack(ModItems.VOID_ARROW.get(), 4),
                    8,3,0.03f));

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.VOID_CRYSTAL.get(), 2),
                    new ItemStack(Items.DIAMOND, 2),
                    new ItemStack(ModItems.EMPOWERED_VOID_CRYSTAL.get(), 1),
                    3,3,0.03f));

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.LIVING_VOID_INGOT.get(), 5),
                    new ItemStack(ModItems.FILLED_VOID_ESSENCE_CAPSULE.get(), 4),
                    new ItemStack(ModItems.QUICK_ACTION_RELEASE_SYSTEM_EMPTY.get(), 1),
                    2,3,0.03f));

            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.EMPOWERED_VOID_CRYSTAL.get(), 2),
                    new ItemStack(ModItems.VOID_NYTHRIL_LIVING_CRYSTAL.get(), 1),
                    new ItemStack(ModItems.VOID_ENVIRONMENTAL_REFLECTOR.get(), 1),
                    1,3,0.03f));

        }
    }


}