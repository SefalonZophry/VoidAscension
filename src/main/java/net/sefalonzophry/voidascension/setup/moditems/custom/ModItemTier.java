package net.sefalonzophry.voidascension.setup.moditems.custom;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import net.sefalonzophry.voidascension.VoidAscension;
import net.sefalonzophry.voidascension.setup.ModTags;
import net.sefalonzophry.voidascension.setup.moditems.ModItems;

import java.util.List;

public class ModItemTier {
    public static final Tier VOID = TierSortingRegistry.registerTier(
            new ForgeTier(5,2500,10F,10,5,
                    ModTags.Blocks.NEEDS_VOID_TOOL, () -> Ingredient.of(ModItems.VOID_CRYSTAL.get())),
            new ResourceLocation(VoidAscension.MOD_ID, "void"), List.of(Tiers.NETHERITE), List.of());
}