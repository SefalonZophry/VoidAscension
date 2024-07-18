package net.sefalonzophry.voidascension.setup.customeffects;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;
import net.sefalonzophry.voidascension.VoidAscension;

public interface ModDamageTypes {
    ResourceKey<DamageType> VOID_DECAY = ResourceKey.create(Registries.DAMAGE_TYPE,
            new ResourceLocation(VoidAscension.MOD_ID, "void_decay"));

}
