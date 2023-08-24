package net.beyondredemption2122.voidascension.setup.worldgen.world.entity.projectile;

import net.beyondredemption2122.voidascension.setup.moditems.ModItems;
import net.beyondredemption2122.voidascension.setup.worldgen.world.entity.ModEntityType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class VoidArrow extends AbstractArrowEntity {
    private final Item referenceItem;
    public VoidArrow(EntityType<? extends AbstractArrowEntity> type, World level) {
        super(type, level);
        this.referenceItem = ModItems.VOID_ARROW.get();
    }

    public VoidArrow(LivingEntity pShooter, World pLevel, Item referenceItem) {
        super(ModEntityType.VOID_ARROW.get(), pShooter, pLevel);
        this.referenceItem = referenceItem;
    }

    @Override
    public ItemStack getPickupItem() {
        return new ItemStack(this.referenceItem);
    }

    @Override
    public IPacket<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
