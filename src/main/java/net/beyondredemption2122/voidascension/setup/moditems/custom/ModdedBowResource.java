package net.beyondredemption2122.voidascension.setup.moditems.custom;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.stats.Stats;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

import java.util.function.Predicate;

public class ModdedBowResource extends BowItem {
    public ModdedBowResource(Properties p_i48522_1_) {
        super(p_i48522_1_);
    }

    public void releaseUsing(ItemStack bowStack, World pLevel, LivingEntity pEntityLiving, int pTimeLeft) {
        if (pEntityLiving instanceof PlayerEntity) {
            PlayerEntity playerentity = (PlayerEntity)pEntityLiving;
            boolean hasInfinity = playerentity.abilities.instabuild || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, bowStack) > 0;
            ItemStack ammoStack = playerentity.getProjectile(bowStack);

            int timeDrawn = this.getUseDuration(bowStack) - pTimeLeft;
            timeDrawn = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(bowStack, pLevel, playerentity, timeDrawn, !ammoStack.isEmpty() || hasInfinity);
            if (timeDrawn < 0) return;

            if (!ammoStack.isEmpty() || hasInfinity) {
                if (ammoStack.isEmpty()) {
                    ammoStack = new ItemStack(Items.ARROW);


                }
                boolean isTippedArrow = ammoStack.getItem() == Items.SPECTRAL_ARROW || ammoStack.getItem() == Items.TIPPED_ARROW;

                float velocity = getPowerForTime(timeDrawn);
                if (!((double)velocity < 0.1D)) {
                    boolean flag1 = playerentity.abilities.instabuild || (ammoStack.getItem() instanceof ArrowItem && ((ArrowItem)ammoStack.getItem()).isInfinite(ammoStack, bowStack, playerentity));
                    if (!pLevel.isClientSide) {
                        AbstractArrowEntity arrowEntity = createArrow(pLevel, ammoStack, playerentity);
                        arrowEntity = customArrow(arrowEntity);
                        arrowEntity.shootFromRotation(playerentity, playerentity.xRot, playerentity.yRot, 0.0F, velocity * 3.0F, 1.0F);
                        if (velocity == 1.0F) {
                            arrowEntity.setCritArrow(true);
                        }

                        double damage =  getArrowDamage(bowStack, arrowEntity);
                        arrowEntity.setBaseDamage(damage);

                        int knockback = getArrowKnockback(bowStack, arrowEntity);
                        arrowEntity.setKnockback(knockback);



                        if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS, bowStack) > 0) {
                            arrowEntity.setSecondsOnFire(100);
                        }

                        bowStack.hurtAndBreak(1, playerentity, (p_220009_1_) -> {
                            p_220009_1_.broadcastBreakEvent(playerentity.getUsedItemHand());
                        });
                        if (hasInfinity) {
                            arrowEntity.pickup = AbstractArrowEntity.PickupStatus.CREATIVE_ONLY;
                        }

                        pLevel.addFreshEntity(arrowEntity);
                    }

                    pLevel.playSound((PlayerEntity)null, playerentity.getX(), playerentity.getY(), playerentity.getZ(), SoundEvents.ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F / (random.nextFloat() * 0.4F + 1.2F) + velocity * 0.5F);

                    boolean shouldConsumeArrow = !hasInfinity || isTippedArrow;
                    if (shouldConsumeArrow) {
                        ammoStack.shrink(1);
                        if (ammoStack.isEmpty()) {
                            playerentity.inventory.removeItem(ammoStack);
                        }
                    }

                    playerentity.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }

    protected AbstractArrowEntity createArrow(World pLevel, ItemStack ammoStack, PlayerEntity playerentity) {
        ArrowItem arrowitem = (ArrowItem)(ammoStack.getItem() instanceof ArrowItem ? ammoStack.getItem() : Items.ARROW);
        return arrowitem.createArrow(pLevel, ammoStack, playerentity);
    }
    protected double getArrowDamage(ItemStack bowStack, AbstractArrowEntity arrowEntity) {
        int powerLevel = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.POWER_ARROWS, bowStack);

        if (powerLevel > 0) return arrowEntity.getBaseDamage() + (double)powerLevel * 0.5D +0.5D;
        else return arrowEntity.getBaseDamage();
    }

    protected int getArrowKnockback(ItemStack bowStack, AbstractArrowEntity arrowEntity) {
        return EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PUNCH_ARROWS, bowStack);

    }

    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return ARROW_ONLY;
    }
}
