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
    public static final Tier VOID_TOOLS = TierSortingRegistry.registerTier(
            new ForgeTier(5,1000,10F,4,5,
                    ModTags.Blocks.NEEDS_VOID_TOOL, () -> Ingredient.of(ModItems.VOID_CRYSTAL.get())),
            new ResourceLocation(VoidAscension.MOD_ID, "void_tools"), List.of(Tiers.NETHERITE), List.of());

    public static final Tier VOID_UNPOWERED = TierSortingRegistry.registerTier(
            new ForgeTier(5,250,10F,1,2,
                    ModTags.Blocks.NEEDS_VOID_TOOL, () -> Ingredient.of(ModItems.VOID_CRYSTAL.get())),
            new ResourceLocation(VoidAscension.MOD_ID, "void_unpowered"), List.of(Tiers.NETHERITE), List.of());

    public static final Tier VOID_FLAWED = TierSortingRegistry.registerTier(
            new ForgeTier(5,500,10F,2,2,
                    ModTags.Blocks.NEEDS_VOID_TOOL, () -> Ingredient.of(ModItems.VOID_CRYSTAL.get())),
            new ResourceLocation(VoidAscension.MOD_ID, "void_flawed"), List.of(Tiers.NETHERITE), List.of());

    public static final Tier VOID_ACCEPTABLE = TierSortingRegistry.registerTier(
            new ForgeTier(5,1000,10F,4,3,
                    ModTags.Blocks.NEEDS_VOID_TOOL, () -> Ingredient.of(ModItems.VOID_CRYSTAL.get())),
            new ResourceLocation(VoidAscension.MOD_ID, "void_acceptable"), List.of(Tiers.NETHERITE), List.of());

    public static final Tier VOID_EXCEPTIONAL = TierSortingRegistry.registerTier(
            new ForgeTier(5,1500,10F,5,3,
                    ModTags.Blocks.NEEDS_VOID_TOOL, () -> Ingredient.of(ModItems.VOID_CRYSTAL.get())),
            new ResourceLocation(VoidAscension.MOD_ID, "void_exceptional"), List.of(Tiers.NETHERITE), List.of());

    public static final Tier VOID_FLAWLESS = TierSortingRegistry.registerTier(
            new ForgeTier(5,2000,10F,8,4,
                    ModTags.Blocks.NEEDS_VOID_TOOL, () -> Ingredient.of(ModItems.VOID_CRYSTAL.get())),
            new ResourceLocation(VoidAscension.MOD_ID, "void_flawless"), List.of(Tiers.NETHERITE), List.of());

    public static final Tier VOID_MASTERWORK = TierSortingRegistry.registerTier(
            new ForgeTier(5,2500,10F,10,7,
                    ModTags.Blocks.NEEDS_VOID_TOOL, () -> Ingredient.of(ModItems.VOID_CRYSTAL.get())),
            new ResourceLocation(VoidAscension.MOD_ID, "void_masterwork"), List.of(Tiers.NETHERITE), List.of());
}