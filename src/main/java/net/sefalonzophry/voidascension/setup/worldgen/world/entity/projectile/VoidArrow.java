package net.sefalonzophry.voidascension.setup.worldgen.world.entity.projectile;

import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.level.Level;
import net.sefalonzophry.voidascension.setup.moditems.ModItems;
import net.sefalonzophry.voidascension.setup.worldgen.world.entity.ModEntityType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.protocol.Packet;
import net.minecraftforge.network.NetworkHooks;

public class VoidArrow extends AbstractArrow {
    private final Item referenceItem;

    public VoidArrow(EntityType<? extends AbstractArrow> type, Level level) {
        super(type, level);
        this.referenceItem = ModItems.VOID_ARROW.get();
    }

    public VoidArrow(LivingEntity pShooter, Level pLevel, Item referenceItem) {
        super(ModEntityType.VOID_ARROW.get(), pShooter, pLevel);
        this.referenceItem = referenceItem;
    }

    @Override
    public ItemStack getPickupItem() {
        return new ItemStack(this.referenceItem);
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
