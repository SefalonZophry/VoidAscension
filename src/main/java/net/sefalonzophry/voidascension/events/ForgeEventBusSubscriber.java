package net.sefalonzophry.voidascension.events;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sefalonzophry.voidascension.VoidAscension;
import net.sefalonzophry.voidascension.setup.customeffects.ModDamageSources;
import net.sefalonzophry.voidascension.setup.customeffects.ModEffects;
import net.sefalonzophry.voidascension.setup.moditems.ModItems;
import net.sefalonzophry.voidascension.setup.worldgen.dimension.ModDimensions;

import static net.minecraftforge.eventbus.api.Event.Result.DENY;

@Mod.EventBusSubscriber(modid = VoidAscension.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEventBusSubscriber {

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void PlayerTravelsToDeepVoid(TickEvent.PlayerTickEvent e) {
        Player player = e.player;
        Level level = player.level();

        if (level.dimension() == ModDimensions.VOID_LEVEL_KEY) {
            player.addEffect(new MobEffectInstance(ModEffects.VOID_DECAY.get()));
            DamageSource void_decay = new ModDamageSources(e.player.level().registryAccess()).void_decay();
            e.player.hurt(void_decay, 2f);
        } else {
            if (player.getMainHandItem().getItem() == ModItems.RIFT_FORMER.get()) {

            } else {
                if (player.getOffhandItem().getItem() == ModItems.RIFT_FORMER.get());
                {

                }
            }
        }
        DamageSource void_decay = new ModDamageSources(e.player.level().registryAccess()).void_decay();
        e.player.removeEffect(ModEffects.VOID_DECAY.get());
        e.setResult(DENY);
        e.player.;
        return
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void PlayerTravelsOutOfDeepVoid(TickEvent.PlayerTickEvent e) {
        Player player = e.player;
        Level level = player.level();

        if (level.dimension() == Level.OVERWORLD)
            player.removeEffect(ModEffects.VOID_DECAY.get());
    }
}







