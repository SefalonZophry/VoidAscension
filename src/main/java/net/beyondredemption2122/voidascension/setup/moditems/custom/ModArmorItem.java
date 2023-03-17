package net.beyondredemption2122.voidascension.setup.moditems.custom;

import com.google.common.collect.ImmutableMap;
import net.beyondredemption2122.voidascension.VoidAscension;
import net.beyondredemption2122.voidascension.setup.ModArmorMaterial;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

import java.util.Map;
import java.util.Objects;

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
//        System.out.println(player.inventory.armor.get(0).getItem().equals(Items.AIR));

//        System.out.println(player.inventory.armor.get(0).getItem() instanceof ModArmorItem);

        ItemStack boots = player.inventory.getArmor(0);
        ItemStack leggings = player.inventory.getArmor(1);
        ItemStack breastplate = player.inventory.getArmor(2);
        ItemStack helmet = player.inventory.getArmor(3);


//        return false;

        return !Items.AIR() && !breastplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
    }

    private boolean hasCorrectArmorOn(IArmorMaterial material, PlayerEntity player) {
        for (ItemStack armorStack : player.inventory.armor) {
            if (!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }


            ArmorItem boots = ((ArmorItem) player.inventory.getArmor(0).getItem());
            ArmorItem leggings = ((ArmorItem) player.inventory.getArmor(1).getItem());
            ArmorItem breastplate = ((ArmorItem) player.inventory.getArmor(2).getItem());
            ArmorItem helmet = ((ArmorItem) player.inventory.getArmor(3).getItem());

            return helmet.getMaterial() == material && breastplate.getMaterial() == material &&
                    leggings.getMaterial() == material && boots.getMaterial() == material;
    }
}
