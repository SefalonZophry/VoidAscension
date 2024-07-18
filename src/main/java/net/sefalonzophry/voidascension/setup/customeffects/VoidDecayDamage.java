package net.sefalonzophry.voidascension.setup.customeffects;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fml.common.Mod;
import net.sefalonzophry.voidascension.VoidAscension;
import org.jetbrains.annotations.Nullable;

@Mod.EventBusSubscriber(modid = VoidAscension.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class VoidDecayDamage extends DamageSource implements DamageTypes {


    public static final ResourceKey<DamageType> VOID_DECAY = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("voidascension", "void_decay"));

    public VoidDecayDamage(Holder<DamageType> pType, @Nullable Entity pDirectEntity, @Nullable Entity pCausingEntity, @Nullable Vec3 pDamageSourcePosition) {
        super(pType, pDirectEntity, pCausingEntity, pDamageSourcePosition);
    }

    public static void bootstrap(BootstapContext<DamageType> context) {
        context.register(VoidDecayDamage.VOID_DECAY, new DamageType("void_decay", 5F));
    }
}







