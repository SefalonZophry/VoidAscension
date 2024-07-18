package net.sefalonzophry.voidascension.setup.customeffects;

import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

public class ModDamageSource extends DamageSources implements DamageTypes {
    protected Registry<DamageType> damageTypes;

    public DamageSource void_decay;

    public ModDamageSource(RegistryAccess pRegistry) {
        super(pRegistry);
        this.damageTypes = pRegistry.registryOrThrow(Registries.DAMAGE_TYPE);
        this.void_decay = this.source(ModDamageTypes.VOID_DECAY);
    }

    private DamageSource source(ResourceKey<DamageType> pDamageTypeKey) {
        return new DamageSource(this.damageTypes.getHolderOrThrow(pDamageTypeKey));
    }
    private DamageSource source(ResourceKey<DamageType> pDamageTypeKey, @Nullable Entity pEntity) {
        return new DamageSource(this.damageTypes.getHolderOrThrow(pDamageTypeKey), pEntity);
    }

    private DamageSource source(ResourceKey<DamageType> pDamageTypeKey, @Nullable Entity pCausingEntity, @Nullable Entity pDirectEntity) {
        return new DamageSource(this.damageTypes.getHolderOrThrow(pDamageTypeKey), pCausingEntity, pDirectEntity);
    }

    public DamageSource void_decay() {
        return this.void_decay;
    }
}

