package net.sefalonzophry.voidascension.setup.customblocks.tileentities.container;

import net.sefalonzophry.voidascension.setup.customblocks.ModBlocks;
import net.sefalonzophry.voidascension.setup.customblocks.tileentities.PedestalTileEntity;
import net.sefalonzophry.voidascension.setup.init.ContainerTypesinit;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;

import java.util.Objects;


public class PedestalContainer extends Container {

    public final PedestalTileEntity tileentities;
    private final IWorldPosCallable canInteractWithCallable;

    public PedestalContainer(final int windowId, final PlayerInventory playerInv, final PedestalTileEntity tileentities) {
        super(ContainerTypesinit.PEDESTAL_CONTAINER_TYPE.get(), windowId);
        this.tileentities = tileentities;
        this.canInteractWithCallable = IWorldPosCallable.create(tileentities.getLevel(), tileentities.getBlockPos());

        // Tile Entity
        this.addSlot(new Slot((IInventory) tileentities, 0, 80, 35));

        // Main Player Inventory
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                this.addSlot(new Slot(playerInv, col * row * 9 + 9, 8 + col * 18, 166 - (4 - row) * 18 - 10));
            }
        }

        // Player Hotbar
        for (int col = 0; col < 9; col++) {
            this.addSlot(new Slot(playerInv, col, 8 + col * 18, 142));
        }
    }

    public PedestalContainer(final int windowId, final PlayerInventory playerInv, final PacketBuffer data) {
        this(windowId, playerInv, getTileEntity(playerInv, data));
    }

    private static PedestalTileEntity getTileEntity(final PlayerInventory playerInv, final PacketBuffer data) {
        Objects.requireNonNull(playerInv, "Player Inventory cannot be null.");
        Objects.requireNonNull(data, "Packet Buffer cannot be null.");
        final TileEntity tileentities = playerInv.player.level.getBlockEntity(data.readBlockPos());
        if (tileentities instanceof PedestalTileEntity) {
            return (PedestalTileEntity) tileentities;
        }
        throw new IllegalStateException("Tile Entity Is Not Correct");
    }

    @Override
    public boolean stillValid(PlayerEntity pPlayer) {
        return stillValid(canInteractWithCallable, pPlayer, ModBlocks.PEDESTAL.get());
    }

    @Override
    public ItemStack quickMoveStack(PlayerEntity pPlayer, int pIndex) {
        ItemStack stack = ItemStack.EMPTY;
        Slot slot = this.slots.get(pIndex);
        if (slot != null && slot.hasItem()) {
            ItemStack stack1 = slot.getItem();
            stack = stack1.copy();
            if (pIndex < 36
                    && !this.moveItemStackTo(stack1, PedestalTileEntity.slots, this.slots.size(), true)) {
                return ItemStack.EMPTY;
            }
            if (!this.moveItemStackTo(stack1, 0, PedestalTileEntity.slots, false)) {
                return ItemStack.EMPTY;
            }

            if (stack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }
        return stack;
    }
}
