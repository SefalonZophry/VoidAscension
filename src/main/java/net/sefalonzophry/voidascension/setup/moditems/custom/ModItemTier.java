package net.sefalonzophry.voidascension.setup.moditems.custom;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import net.sefalonzophry.voidascension.VoidAscension;
import net.sefalonzophry.voidascension.setup.util.ModTags;
import net.sefalonzophry.voidascension.setup.moditems.ModItems;

import java.util.List;

public class ModItemTier {
    public static final Tier VOID_TOOLS = TierSortingRegistry.registerTier(
            new ForgeTier(5,1250,10F,4,5,
                    ModTags.Blocks.NEEDS_TIER_1_TOOLS, () -> Ingredient.of(ModItems.VOID_CRYSTAL.get())),
            new ResourceLocation(VoidAscension.MOD_ID, "void_tools"), List.of(Tiers.NETHERITE), List.of());

    public static final Tier VOID_NYTHRIL_TOOLS = TierSortingRegistry.registerTier(
            new ForgeTier(8,1550,10F,4,5,
                    ModTags.Blocks.NEEDS_TIER_2_TOOLS, () -> Ingredient.of(ModItems.VOID_NYTHRIL_SHARD.get())),
            new ResourceLocation(VoidAscension.MOD_ID, "void_nythril_tools"), List.of(Tiers.NETHERITE), List.of());

    public static final Tier VOID_UNPOWERED = TierSortingRegistry.registerTier(
            new ForgeTier(5,800,10F,4,2,
                    ModTags.Blocks.TIER_0_WEAPONS, () -> Ingredient.of(ModItems.VOID_CRYSTAL.get())),
            new ResourceLocation(VoidAscension.MOD_ID, "void_unpowered"), List.of(Tiers.NETHERITE), List.of());

    public static final Tier VOID_FLAWED = TierSortingRegistry.registerTier(
            new ForgeTier(5,1000,10F,6,2,
                    ModTags.Blocks.TIER_1_WEAPONS, () -> Ingredient.of(ModItems.VOID_CRYSTAL.get())),
            new ResourceLocation(VoidAscension.MOD_ID, "void_flawed"), List.of(Tiers.NETHERITE), List.of());

    public static final Tier VOID_ACCEPTABLE = TierSortingRegistry.registerTier(
            new ForgeTier(5,1200,10F,7,3,
                    ModTags.Blocks.TIER_2_WEAPONS, () -> Ingredient.of(ModItems.VOID_NYTHRIL_SHARD.get())),
            new ResourceLocation(VoidAscension.MOD_ID, "void_acceptable"), List.of(Tiers.NETHERITE), List.of());

    public static final Tier VOID_EXCEPTIONAL = TierSortingRegistry.registerTier(
            new ForgeTier(5,1500,10F,8,3,
                    ModTags.Blocks.TIER_3_WEAPONS, () -> Ingredient.of(ModItems.VOID_CRYSTAL.get())),
            new ResourceLocation(VoidAscension.MOD_ID, "void_exceptional"), List.of(Tiers.NETHERITE), List.of());

    public static final Tier VOID_FLAWLESS = TierSortingRegistry.registerTier(
            new ForgeTier(5,2000,10F,10,4,
                    ModTags.Blocks.TIER_4_WEAPONS, () -> Ingredient.of(ModItems.VOID_CRYSTAL.get())),
            new ResourceLocation(VoidAscension.MOD_ID, "void_flawless"), List.of(Tiers.NETHERITE), List.of());

    public static final Tier VOID_MASTERWORK = TierSortingRegistry.registerTier(
            new ForgeTier(5,2500,10F,12,7,
                    ModTags.Blocks.TIER_5_WEAPONS, () -> Ingredient.of(ModItems.VOID_CRYSTAL.get())),
            new ResourceLocation(VoidAscension.MOD_ID, "void_masterwork"), List.of(Tiers.NETHERITE), List.of());
}