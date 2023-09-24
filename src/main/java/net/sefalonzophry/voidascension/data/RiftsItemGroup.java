package net.sefalonzophry.voidascension.data;


import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.sefalonzophry.voidascension.setup.moditems.ModItems;

public class RiftsItemGroup {

    public static ItemGroup creativeTab = new ItemGroup("VoidAscension") {

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ModItems.RIFT_CRYSTAL.get());
    }

    @Override
    public boolean canScroll() {
        return true;
    }

    };
}

