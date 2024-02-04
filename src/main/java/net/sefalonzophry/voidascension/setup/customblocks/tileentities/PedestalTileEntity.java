/*package net.sefalonzophry.voidascension.setup.customblocks.tileentities;

import net.sefalonzophry.voidascension.VoidAscension;
import net.sefalonzophry.voidascension.setup.customblocks.tileentities.container.PedestalContainer;
import net.sefalonzophry.voidascension.setup.init.TileEntityTypesInit;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class PedestalTileEntity extends LockableLootTileEntity {

    public static int slots = 1;

    protected NonNullList<ItemStack> items = NonNullList.withSize(slots, ItemStack.EMPTY);

    protected PedestalTileEntity(TileEntityType<?> typeIn) {
        super(typeIn);
    }

    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("container." + VoidAscension.MOD_ID + ".pedestal");
    }

    @Override
    protected Container createMenu(int pId, PlayerInventory pPlayer) {
        return new PedestalContainer(pId, pPlayer, this);
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.items;
    }

    public ItemStack getItem() {
        return this.items.get(0);
    }

    @Override
    protected void setItems(NonNullList<ItemStack> pItems) {
        this.items = getItems();
    }

    public PedestalTileEntity() {
        this(TileEntityTypesInit.PEDESTAL_TILE_ENTITY_TYPE.get());
    }

    @Override
    public int getContainerSize() {
        return slots;
    }

    @Override
    public CompoundNBT save(CompoundNBT pCompound) {
        super.save(pCompound);
        if(!this.tryLoadLootTable(pCompound)) {
            ItemStackHelper.saveAllItems(pCompound, this.items);
        }

        return pCompound;
    }

    @Override
    public void load(BlockState p_230337_1_, CompoundNBT p_230337_2_) {
        super.load(p_230337_1_, p_230337_2_);
        this.items = NonNullList.withSize(getContainerSize(), ItemStack.EMPTY);
        if (!this.trySaveLootTable(p_230337_2_)) {
            ItemStackHelper.loadAllItems(p_230337_2_, this.items);
        }
    }
}
*/