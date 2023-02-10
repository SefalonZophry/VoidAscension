package net.beyondredemption2122.voidascension.setup.moditems.custom;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ItemStack;

public class VoidBow extends ModdedBowResource{
    public VoidBow(Properties p_i48522_1_) {
        super(p_i48522_1_);
    }
    protected double getArrowDamage(ItemStack bowStack, AbstractArrowEntity arrowEntity) {
        int powerLevel = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.POWER_ARROWS, bowStack);

        return (double)powerLevel * 8.0D +3.0D;

    }
}
