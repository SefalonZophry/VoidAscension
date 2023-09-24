package net.sefalonzophry.voidascension.setup.moditems.custom;

import com.google.common.collect.ImmutableMap;
import net.sefalonzophry.voidascension.setup.ModArmorMaterial;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public class ModArmorItem extends ArmorItem {
    private static final Map<IArmorMaterial, Effect> MATERIAL_TO_EFFECT_MAP_1 =
            new ImmutableMap.Builder<IArmorMaterial, Effect>()
                    .put(ModArmorMaterial.VOID_RELIC, Effects.ABSORPTION)
                    .build();

    private static final Map<IArmorMaterial, Effect> MATERIAL_TO_EFFECT_MAP_2 =
            new ImmutableMap.Builder<IArmorMaterial, Effect>()
                    .put(ModArmorMaterial.VOID_RELIC, Effects.DAMAGE_BOOST)
                    .build();

    public ModArmorItem(IArmorMaterial material, EquipmentSlotType slot, Properties settings) {
        super(material, slot, settings);
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        if (!world.isClientSide()) {
            if (hasFullSuitOfArmorOn(player)) {
                evaluateArmorEffects1(player);
                evaluateArmorEffects2(player);
            }
        }

        super.onArmorTick(stack, world, player);
    }

    private void evaluateArmorEffects1(PlayerEntity player) {
        for (Map.Entry<IArmorMaterial, Effect> entry : MATERIAL_TO_EFFECT_MAP_1.entrySet()) {
            IArmorMaterial mapArmorMaterial = entry.getKey();
            Effect mapStatusEffect = entry.getValue();

            if (hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect);
            }
        }
    }

    private void evaluateArmorEffects2(PlayerEntity player) {
        for (Map.Entry<IArmorMaterial, Effect> entry : MATERIAL_TO_EFFECT_MAP_2.entrySet()) {
            IArmorMaterial mapArmorMaterial = entry.getKey();
            Effect mapStatusEffect = entry.getValue();

            if (hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect);
            }
        }
    }

    private void addStatusEffectForMaterial(PlayerEntity player, IArmorMaterial mapArmorMaterial, Effect mapStatusEffect) {
        boolean hasPlayerEffect = !Objects.equals(player.getEffect(mapStatusEffect), null);

        if (hasCorrectArmorOn(mapArmorMaterial, player) && !hasPlayerEffect) {
            player.addEffect(new EffectInstance(mapStatusEffect, 400));
        }
    }

    private boolean hasFullSuitOfArmorOn(PlayerEntity player) {
        AtomicBoolean fullyArmorOn = new AtomicBoolean(true);

        player.getArmorSlots().forEach(itemStack -> {
            if (itemStack.isEmpty()) fullyArmorOn.set(false);
            return;
        });

        return fullyArmorOn.get();
    }

    private boolean hasCorrectArmorOn(IArmorMaterial material, PlayerEntity player) {
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