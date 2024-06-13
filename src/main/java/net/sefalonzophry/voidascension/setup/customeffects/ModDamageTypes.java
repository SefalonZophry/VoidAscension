
package net.sefalonzophry.voidascension.setup.customeffects;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;

public class ModDamageTypes {
    public static final ResourceKey<DamageType> VOID_DECAY = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("voidascension", "void_decay"));

    public static void bootstrap(BootstapContext<DamageType> context) { context.register(VOID_DECAY, new DamageType("void_decay", 0.2F)); }
}
