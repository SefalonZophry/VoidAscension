package net.sefalonzophry.voidascension.setup.moditems.custom;

import net.sefalonzophry.voidascension.setup.moditems.ModItems;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;

import java.util.function.Predicate;


public class VoidBow extends ModdedBowResource{
    public VoidBow(Properties p_i48522_1_) {
        super(p_i48522_1_);
    }
    protected double getArrowDamage(ItemStack bowStack, AbstractArrow arrowEntity) {
        int powerLevel = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.POWER_ARROWS, bowStack);

        return (double)powerLevel * 8.0D +3.0D;
    }
    @Override
    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return (ammoStack) -> {
            return ammoStack.getItem() == ModItems.VOID_ARROW.get();
        };
    }
}
