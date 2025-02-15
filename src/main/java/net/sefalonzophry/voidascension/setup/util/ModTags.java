package net.sefalonzophry.voidascension.setup.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.sefalonzophry.voidascension.VoidAscension;

public class ModTags {
    public static final class Blocks {

        public static final TagKey<Block> NEEDS_TIER_1_TOOLS = tag("needs_tier_1_tools");
        public static final TagKey<Block> NEEDS_TIER_2_TOOLS = tag("needs_tier_2_tools");
        public static final TagKey<Block> TIER_0_WEAPONS = tag("tier_0_weapons");
        public static final TagKey<Block> TIER_1_WEAPONS = tag("tier_1_weapons");
        public static final TagKey<Block> TIER_2_WEAPONS = tag("tier_2_weapons");
        public static final TagKey<Block> TIER_3_WEAPONS = tag("tier_3_weapons");
        public static final TagKey<Block> TIER_4_WEAPONS = tag("tier_4_weapons");
        public static final TagKey<Block> TIER_5_WEAPONS = tag("tier_5_weapons");


        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(VoidAscension.MOD_ID, name));
        }
    }

    public static final class Items {

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(VoidAscension.MOD_ID, name));
        }
    }

    public static final class Biomes {

        public static TagKey<Biome> VOID_TOUCHED_FOREST =
                TagKey.create(Registries.BIOME, new ResourceLocation(VoidAscension.MOD_ID, "void_touched_forest"));

        public static TagKey<Biome> DEEP_VOID =
                TagKey.create(Registries.BIOME, new ResourceLocation(VoidAscension.MOD_ID, "deep_void"));
    }
}
