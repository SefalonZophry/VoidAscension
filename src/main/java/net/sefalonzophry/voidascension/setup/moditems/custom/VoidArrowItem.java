package net.sefalonzophry.voidascension.setup.moditems.custom;

import net.sefalonzophry.voidascension.setup.moditems.ModItems;
import net.sefalonzophry.voidascension.setup.worldgen.world.entity.projectile.VoidArrow;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class VoidArrowItem extends ArrowItem {
    public final float damage;

    public VoidArrowItem(Properties properties, float damage) {
        super(properties);
        this.damage = damage;
    }
    @Override
    public AbstractArrowEntity createArrow(World pLevel, ItemStack pStack, LivingEntity pShooter) {
        VoidArrow arrowentity = new VoidArrow(pShooter, pLevel, ModItems.VOID_ARROW.get());
        arrowentity.setBaseDamage(this.damage);
        return arrowentity;
    }

    @Override
    public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.entity.player.PlayerEntity player) {
        int enchant = net.minecraft.enchantment.EnchantmentHelper.getItemEnchantmentLevel(net.minecraft.enchantment.Enchantments.INFINITY_ARROWS, bow);
        return enchant <= 0 ? false : this.getClass() == VoidArrowItem.class;
    }
}
