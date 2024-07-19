package net.sefalonzophry.voidascension.setup;

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

        //Blocks

        public static final TagKey<Block> ORES = tag("voidascension/ores");
        public static final TagKey<Block> VOID_STONE = tag("voidascension/block");
        public static final TagKey<Block> VOID_PILLAR_TOP = tag("voidascension/block");
        //        public static final TagKey<Block> ALTAR = tag("voidascension/block");
        public static final TagKey<Block> CHALICE = tag("voidacension/block");
        public static final TagKey<Block> PEDESTAL = tag("voidascension/block");
        public static final TagKey<Block> VOID_FENCE = tag("voidascension/block");
        public static final TagKey<Block> VOID_SLAB = tag("voidascension/block");
        public static final TagKey<Block> VOID_STAIRS = tag("voidascension/block");
        public static final TagKey<Block> NEEDS_VOID_TOOL = tag("voidascension/needs_void_tool");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation("tag", name));
        }

        private static TagKey<Block> mod(String name) {
            return BlockTags.create(new ResourceLocation(VoidAscension.MOD_ID, name));
        }
    }

    public static final class Items {

        //Items
        public static final TagKey<Item> VOID_ENVIRONMENTAL_REFLECTOR = tag("voidascension/misc");
        public static final TagKey<Item> VOID_ESSENCE = tag("voidascension/misc");
        public static final TagKey<Item> EMPOWERED_VOID_ESSENCE = tag("voidascension/misc");
        public static final TagKey<Item> VOID_CRYSTAL = tag("voidascension/misc");
        public static final TagKey<Item> UNSTABLE_VOID_CRYSTAL = tag("voidascension/misc");
        public static final TagKey<Item> VOID_INFUSED_STRING = tag("voidascension/misc");
        public static final TagKey<Item> LIVING_VOID_INGOT = tag("voidascension/misc");
        public static final TagKey<Item> NE_RELIC_PIECE = tag("voidascension/misc");
        public static final TagKey<Item> SE_RELIC_PIECE = tag("voidascension/misc");
        public static final TagKey<Item> SW_RELIC_PIECE = tag("voidascension/misc");
        public static final TagKey<Item> NW_RELIC_PIECE = tag("voidascension/misc");
        public static final TagKey<Item> RELIC = tag("voidascension/misc");
        public static final TagKey<Item> VOID_SPAWN_SPAWN_EGG = tag("voidascension/misc");
        public static final TagKey<Item> INJECTOR_SPAWN_EGG = tag("voidascension/misc");
        public static final TagKey<Item> ELITE_VOID_SPAWN_SPAWN_EGG = tag("voidascension/misc");
        public static final TagKey<Item> VOID_ESSENCE_CAPSULE = tag("voidascension/misc");
        public static final TagKey<Item> EMPTY_VOID_ESSENCE_CAPSULE = tag("voidascension/misc");
        public static final TagKey<Item> EMPTY_SYRINGE = tag("voidascension/misc");
        public static final TagKey<Item> FILLED_VOID_ESSENCE_SYRINGE = tag("voidascension/misc");


        //Blocks
//        public static final TagKey<Item> VOID_CRYSTAL_ORE_BLOCK = tag("voidascension/ore");
        public static final TagKey<Item> VOID_STONE = tag("voidascension/block");
        public static final TagKey<Item> VOID_PILLAR_TOP = tag("voidascension/block");
//        public static final TagKey<Item> ALTAR = tag("voidascension/block");
        public static final TagKey<Item> CHALICE = tag("voidascension/block");
        public static final TagKey<Item> PEDESTAL = tag("voidascension/block");


        //Tools
        public static final TagKey<Item> VOID_SWORD_UNPOWERED = tag("voidascension/tool");
        public static final TagKey<Item> VOID_SWORD_POWERED = tag("voidascension/tool");
        public static final TagKey<Item> VOID_PICKAXE = tag("voidascension/tool");
        public static final TagKey<Item> VOID_BOW = tag("voidascension/tool");
        public static final TagKey<Item> VOID_SHOVEL = tag("voidascension/tool");
        public static final TagKey<Item> VOID_BATTLE_AXE = tag("voidascension/tool");


        //Tool Workables
        public static final TagKey<Item> VOID_PICKAXE_HEAD = tag("voidascension/workables");
        public static final TagKey<Item> VOID_SWORD_HANDLE = tag("voidascension/workables");
        public static final TagKey<Item> VOID_SWORD_GUARD = tag("voidascension/workables");
        public static final TagKey<Item> VOID_SWORD_LOWER_HALF = tag("voidascension/workables");
        public static final TagKey<Item> VOID_TOOL_HANDLE = tag("voidascension/workables");
        public static final TagKey<Item> VOID_SWORD_BLADE = tag("voidascension/workables");
        public static final TagKey<Item> VOID_BOW_BODY = tag("voidascension/workables");
        public static final TagKey<Item> VOID_BOW_UNPOWERED_BODY = tag("voidascension/workables");
        public static final TagKey<Item> VOID_ARROW_SHAFT = tag("voidascension/workables");
        public static final TagKey<Item> VOID_ARROW_HEAD = tag("voidascension/workables");
        public static final TagKey<Item> VOID_SHOVEL_HEAD = tag("voidascension/workables");
        public static final TagKey<Item> VOID_BATTLE_AXE_HEAD = tag("voidascension/workables");


        //Armor
        public static final TagKey<Item> VOID_HELMET = tag("voidascension/armor");
        public static final TagKey<Item> VOID_CHESTPLATE = tag("voidascension/armor");
        public static final TagKey<Item> VOID_LEGGINGS = tag("voidascension/armor");
        public static final TagKey<Item> VOID_BOOTS = tag("voidascension/armor");
        public static final TagKey<Item> VOID_RELIC_HELMET = tag("voidascension/armor");
        public static final TagKey<Item> VOID_RELIC_CHESTPLATE = tag("voidascension/armor");
        public static final TagKey<Item> VOID_RELIC_LEGGINGS = tag("voidascension/armor");
        public static final TagKey<Item> VOID_RELIC_BOOTS = tag("voidascension/armor");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation("tag", name));
        }

        private static TagKey<Item> mod(String name) {
            return ItemTags.create(new ResourceLocation(VoidAscension.MOD_ID, name));
        }
    }

    public static final class Biomes {

        public static TagKey<Biome> VOID_TOUCHED_BIOME =
                TagKey.create(Registries.BIOME, new ResourceLocation(VoidAscension.MOD_ID, "void_touched_biome"));

        public static TagKey<Biome> DEEP_VOID =
                TagKey.create(Registries.BIOME, new ResourceLocation(VoidAscension.MOD_ID, "deep_void"));
    }
}
