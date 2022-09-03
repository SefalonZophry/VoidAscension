package net.beyondredemption2122.voidascension.setup.customeffects;


import net.beyondredemption2122.voidascension.VoidAscension;
import net.minecraft.potion.Effect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEffects {
    public static final DeferredRegister<Effect> POTIONS
            = DeferredRegister.create((ForgeRegistries.POTIONS), VoidAscension.MOD_ID);

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
