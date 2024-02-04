package net.sefalonzophry.voidascension.setup.moditems.custom;

import com.google.common.collect.ImmutableMap;
import net.minecraft.world.entity.Entity;
import net.sefalonzophry.voidascension.setup.ModArmorMaterial;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class ModArmorItem extends ArmorItem {
    private static final Map<ArmorMaterial, MobEffectInstance> MATERIAL_TO_EFFECT_MAP_1 =
            new ImmutableMap.Builder<ArmorMaterial, MobEffectInstance>()
                    .put(ModArmorMaterial.VOID_RELIC, new MobEffectInstance(MobEffects.ABSORPTION, 200, 2,
                            false, false, true)).build();

    private static final Map<ArmorMaterial, MobEffectInstance> MATERIAL_TO_EFFECT_MAP_2 =
            new ImmutableMap.Builder<ArmorMaterial, MobEffectInstance>()
                    .put(ModArmorMaterial.VOID_RELIC, new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 1,
                            false, false, true)).build();

    public ModArmorItem(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    public void inventoryTick(ItemStack stack, Level world, Entity entity, int slot, boolean selected) {
        if (!world.isClientSide()) {
            if (entity instanceof Player) {
                Player player =(Player)entity;

                if(hasFullSuitOfArmorOn(player)) {
                    evaluateArmorEffects1(player);
                    evaluateArmorEffects2(player);
                }
            }
        }
    }

    private void evaluateArmorEffects1(Player player) {
        for (Map.Entry<ArmorMaterial, MobEffectInstance> entry : MATERIAL_TO_EFFECT_MAP_1.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            MobEffectInstance mapStatusEffect = entry.getValue();

            if (hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect);
            }
        }
    }

    private void evaluateArmorEffects2(Player player) {
        for (Map.Entry<ArmorMaterial, MobEffectInstance> entry : MATERIAL_TO_EFFECT_MAP_2.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            MobEffectInstance mapStatusEffect = entry.getValue();

            if (hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect);
            }
        }
    }

    private void addStatusEffectForMaterial(Player player, ArmorMaterial mapArmorMaterial,
                                            MobEffectInstance mapStatusEffect) {
        boolean hasPlayerEffect = player.hasEffect(mapStatusEffect.getEffect());

        if (hasCorrectArmorOn(mapArmorMaterial, player) && !hasPlayerEffect) {
            player.addEffect(new MobEffectInstance(mapStatusEffect));
        }
    }

    private boolean hasFullSuitOfArmorOn(Player player) {
        AtomicBoolean fullyArmorOn = new AtomicBoolean(true);

        player.getArmorSlots().forEach(itemStack -> {
            if (itemStack.isEmpty()) fullyArmorOn.set(false);
            return;
        });

        return fullyArmorOn.get();
    }

    private boolean hasCorrectArmorOn(ArmorMaterial material, Player player) {
        AtomicBoolean correctArmorOn = new AtomicBoolean(true);

        player.getArmorSlots().forEach(itemStack -> {
            if (!(itemStack.getItem() instanceof ArmorItem) || ((ArmorItem) itemStack.getItem()).getMaterial() != material) {
                correctArmorOn.set(false);
            }

            return;
        });

        return correctArmorOn.get();
    }
}