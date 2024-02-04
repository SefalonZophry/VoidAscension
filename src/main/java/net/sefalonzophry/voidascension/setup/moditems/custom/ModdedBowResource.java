package net.sefalonzophry.voidascension.setup.moditems.custom;

import net.sefalonzophry.voidascension.setup.moditems.ModItems;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.stats.Stats;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.Level;

import java.util.function.Predicate;

import static org.apache.commons.lang3.RandomUtils.nextFloat;

public class ModdedBowResource extends BowItem {
    public ModdedBowResource(Properties p_i48522_1_) {
        super(p_i48522_1_);
    }

    public void releaseUsing(ItemStack bowStack, Level pLevel, LivingEntity pEntityLiving, int pTimeLeft) {
        if (pEntityLiving instanceof Player) {
            Player playerentity = (Player)pEntityLiving;
            boolean hasInfinity = playerentity.getAbilities().instabuild || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, bowStack) > 0;
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
                    boolean flag1 = playerentity.getAbilities().instabuild || (ammoStack.getItem() instanceof ArrowItem && ((ArrowItem)ammoStack.getItem()).isInfinite(ammoStack, bowStack, playerentity));
                    if (!pLevel.isClientSide) {
                        AbstractArrow arrowEntity = createArrow(pLevel, ammoStack, playerentity);
                        arrowEntity = customArrow(arrowEntity);
                        arrowEntity.shootFromRotation(playerentity, playerentity.xRotO, playerentity.yRotO, 0.0F, velocity * 3.0F, 1.0F);
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
                            arrowEntity.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                        }

                        pLevel.addFreshEntity(arrowEntity);
                    }

                    pLevel.playSound((Player)null, playerentity.getX(), playerentity.getY(), playerentity.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (nextFloat() * 0.4F + 1.2F) + velocity * 0.5F);

                    boolean shouldConsumeArrow = !hasInfinity || isTippedArrow;
                    if (shouldConsumeArrow) {
                        ammoStack.shrink(1);
                        if (ammoStack.isEmpty()) {
                            playerentity.getInventory().removeItem(ammoStack);
                        }
                    }

                    playerentity.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }

    protected AbstractArrow createArrow(Level pLevel, ItemStack ammoStack, Player playerentity) {
        ArrowItem arrowitem = (ArrowItem)(ammoStack.getItem() instanceof ArrowItem ? ammoStack.getItem() : ModItems.VOID_ARROW);
        return arrowitem.createArrow(pLevel, ammoStack, playerentity);
    }
    protected double getArrowDamage(ItemStack bowStack, AbstractArrow arrowEntity) {
        int powerLevel = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.POWER_ARROWS, bowStack);

        if (powerLevel > 0) return arrowEntity.getBaseDamage() + (double)powerLevel * 0.5D +0.5D;
        else return arrowEntity.getBaseDamage();
    }

    protected int getArrowKnockback(ItemStack bowStack, AbstractArrow arrowEntity) {
        return EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PUNCH_ARROWS, bowStack);

    }

    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return (ammoStack) -> {
            return ammoStack.is(ItemTags.ARROWS);
        };
    }
}
