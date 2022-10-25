package net.beyondredemption2122.voidascension.setup;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.beyondredemption2122.voidascension.VoidAscension;
import org.lwjgl.system.CallbackI;

public class ModTags {
    public static final class Blocks {

        //Blocks
        public static final ITag.INamedTag<Block> RIFT_CRYSTAL_ORE_BLOCK = forge("voidascension/ore");
        public static final ITag.INamedTag<Block> VOID_STONE = forge("voidascension/block");
        public static final ITag.INamedTag<Block> VOID_PILLAR_TOP = forge("voidascension/block");
        public static final ITag.INamedTag<Block> ALTAR = forge("voidascension/block");
        public static final ITag.INamedTag<Block> CHALICE = forge("voidacension/block");
        public static final ITag.INamedTag<Block> PEDESTAL = forge("voidascension/block");
        public static final ITag.INamedTag<Block> VOID_FENCE = forge("voidascension/block");
        public static final ITag.INamedTag<Block> VOID_SLAB = forge("voidascension/block");
        public static final ITag.INamedTag<Block> VOID_STAIRS = forge("voidascension/block");

        private static ITag.INamedTag<Block> forge(String path) {
            return BlockTags.bind(new ResourceLocation("forge", path).toString());
        }

        private static ITag.INamedTag<Block> mod(String path) {
            return BlockTags.bind(new ResourceLocation(VoidAscension.MOD_ID, path).toString());
        }
    }

    public static final class Items {

        //Items
        public static final ITag.INamedTag<Item> RIFT_FORMER = forge("voidascension/misc");
        public static final ITag.INamedTag<Item> VOID_ESSENCE = forge("voidascension/misc");
        public static final ITag.INamedTag<Item> EMPOWERED_VOID_ESSENCE = forge("voidascension/misc");
        public static final ITag.INamedTag<Item> RIFT_CRYSTAL = forge("voidascension/misc");
        public static final ITag.INamedTag<Item> UNSTABLE_RIFT_CRYSTAL = forge("voidascension/misc");
        public static final ITag.INamedTag<Item> VOID_INFUSED_STRING = forge("voidascension/misc");
        public static final ITag.INamedTag<Item> LIVING_VOID_STEEL_INGOT = forge("voidascension/misc");
        public static final ITag.INamedTag<Item> NE_RELIC_PIECE = forge("voidascension/misc");
        public static final ITag.INamedTag<Item> SE_RELIC_PIECE = forge("voidascension/misc");
        public static final ITag.INamedTag<Item> SW_RELIC_PIECE = forge("voidascension/misc");
        public static final ITag.INamedTag<Item> NW_RELIC_PIECE = forge("voidascension/misc");
        public static final ITag.INamedTag<Item> RELIC = forge("voidascension/misc");
        public static final ITag.INamedTag<Item> VOID_SPAWN_SPAWN_EGG = forge("voidascension/misc");
        public static final ITag.INamedTag<Item> INJECTOR_SPAWN_EGG = forge("voidascension/misc");
        public static final ITag.INamedTag<Item> ELITE_VOID_SPAWN_SPAWN_EGG = forge("voidascension/misc");

        public static final ITag.INamedTag<Item> VOID_ESSENCE_CAPSULE = forge("voidascension/misc");


        //Blocks
        public static final ITag.INamedTag<Item> RIFT_CRYSTAL_ORE_BLOCK = forge("voidascension/ore");
        public static final ITag.INamedTag<Item> VOID_STONE = forge("voidascension/block");
        public static final ITag.INamedTag<Item> VOID_PILLAR_TOP = forge("voidascension/block");
        public static final ITag.INamedTag<Item> ALTAR = forge("voidascension/block");
        public static final ITag.INamedTag<Item> CHALICE = forge("voidascension/block");
        public static final ITag.INamedTag<Item> PEDESTAL = forge("voidascension/block");



        //Tools
        public static final ITag.INamedTag<Item> VOID_SWORD_UNPOWERED = forge("voidascension/tool");
        public static final ITag.INamedTag<Item> VOID_SWORD_POWERED = forge("voidascension/tool");
        public static final ITag.INamedTag<Item> VOID_PICKAXE = forge("voidascension/tool");


        //Tool Workables
        public static final ITag.INamedTag<Item> VOID_PICKAXE_HEAD = forge("voidascension/workables");
        public static final ITag.INamedTag<Item> VOID_SWORD_HANDLE = forge("voidascension/workables");
        public static final ITag.INamedTag<Item> VOID_SWORD_GUARD = forge("voidascension/workables");
        public static final ITag.INamedTag<Item> VOID_SWORD_LOWER_HALF = forge("voidascension/workables");
        public static final ITag.INamedTag<Item> VOID_PICKAXE_HANDLE = forge("voidascension/workables");
        public static final ITag.INamedTag<Item> VOID_SWORD_BLADE = forge("voidascension/workables");


        //Armor
        public static final ITag.INamedTag<Item> VOID_HELMET = forge("voidascension/armor");
        public static final ITag.INamedTag<Item> VOID_CHESTPLATE = forge("voidascension/armor");
        public static final ITag.INamedTag<Item> VOID_LEGGINGS = forge("voidascension/armor");
        public static final ITag.INamedTag<Item> VOID_BOOTS = forge("voidascension/armor");
        public static final ITag.INamedTag<Item> VOID_RELIC_HELMET = forge("voidascension/armor");
        public static final ITag.INamedTag<Item> VOID_RELIC_CHESTPLATE = forge("voidascension/armor");
        public static final ITag.INamedTag<Item> VOID_RELIC_LEGGINGS = forge("voidascension/armor");
        public static final ITag.INamedTag<Item> VOID_RELIC_BOOTS = forge("voidascension/armor");



        private static ITag.INamedTag<Item> forge(String path) {
            return ItemTags.bind(new ResourceLocation("forge", path).toString());
        }

        private static ITag.INamedTag<Item> mod(String path) {
            return ItemTags.bind(new ResourceLocation(VoidAscension.MOD_ID, path).toString());
        }
    }
}
