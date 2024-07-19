
package net.sefalonzophry.voidascension.events;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import net.sefalonzophry.voidascension.VoidAscension;
import net.sefalonzophry.voidascension.setup.customeffects.ModDamageSource;
import net.sefalonzophry.voidascension.setup.moditems.ModItems;
import net.sefalonzophry.voidascension.setup.worldgen.dimension.ModDimensions;


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
            if (event.getEntity(ModItems.UNSTABLE_VOID_CRYSTAL.get())) {
            }
        }
*/
    }
}



