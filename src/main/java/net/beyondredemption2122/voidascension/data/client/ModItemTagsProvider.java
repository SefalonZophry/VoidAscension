package net.beyondredemption2122.voidascension.data.client;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.beyondredemption2122.voidascension.VoidAscension;
import net.beyondredemption2122.voidascension.setup.moditems.ModItems;
import net.beyondredemption2122.voidascension.setup.ModTags;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagsProvider,  ExistingFileHelper existingFileHelper) {
        super(dataGenerator, blockTagsProvider, VoidAscension.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        //Blocks

        copy(ModTags.Blocks.RIFT_CRYSTAL_ORE_BLOCK, ModTags.Items.RIFT_CRYSTAL_ORE_BLOCK);
//        copy(ModTags.Blocks.ALTAR, ModTags.Items.ALTAR);
        copy(ModTags.Blocks.CHALICE, ModTags.Items.CHALICE);
        copy(ModTags.Blocks.PEDESTAL, ModTags.Items.PEDESTAL);
        copy(ModTags.Blocks.VOID_STONE, ModTags.Items.VOID_STONE);
        copy(ModTags.Blocks.VOID_PILLAR_TOP, ModTags.Items.VOID_PILLAR_TOP);


        //Items

        tag(ModTags.Items.RIFT_FORMER).add(ModItems.RIFT_FORMER.get());
        tag(ModTags.Items.VOID_ESSENCE).add(ModItems.VOID_ESSENCE.get());
        tag(ModTags.Items.EMPOWERED_VOID_ESSENCE).add(ModItems.EMPOWERED_VOID_ESSENCE.get());
        tag(ModTags.Items.RIFT_CRYSTAL).add(ModItems.RIFT_CRYSTAL.get());
        tag(ModTags.Items.VOID_INFUSED_STRING).add(ModItems.VOID_INFUSED_STRING.get());
        tag(ModTags.Items.UNSTABLE_RIFT_CRYSTAL).add(ModItems.UNSTABLE_RIFT_CRYSTAL.get());
        tag(ModTags.Items.LIVING_VOID_INGOT).add(ModItems.LIVING_VOID_INGOT.get());
        tag(ModTags.Items.NE_RELIC_PIECE).add(ModItems.NE_RELIC_PIECE.get());
        tag(ModTags.Items.SE_RELIC_PIECE).add(ModItems.SE_RELIC_PIECE.get());
        tag(ModTags.Items.SW_RELIC_PIECE).add(ModItems.SW_RELIC_PIECE.get());
        tag(ModTags.Items.NW_RELIC_PIECE).add(ModItems.NW_RELIC_PIECE.get());
        tag(ModTags.Items.RELIC).add(ModItems.RELIC.get());
        tag(ModTags.Items.VOID_ESSENCE_CAPSULE).add(ModItems.VOID_ESSENCE_CAPSULE.get());
        tag(ModTags.Items.EMPTY_VOID_ESSENCE_CAPSULE).add(ModItems.EMPTY_VOID_ESSENCE_CAPSULE.get());
        tag(ModTags.Items.EMPTY_SYRINGE).add(ModItems.EMPTY_SYRINGE.get());
        tag(ModTags.Items.FILLED_VOID_ESSENCE_SYRINGE).add(ModItems.FILLED_VOID_ESSENCE_SYRINGE.get());
        tag(ModTags.Items.VOID_SPAWN_SPAWN_EGG).add(ModItems.VOID_SPAWN_SPAWN_EGG.get());
        tag(ModTags.Items.INJECTOR_SPAWN_EGG).add(ModItems.INJECTOR_SPAWN_EGG.get());
        tag(ModTags.Items.ELITE_VOID_SPAWN_SPAWN_EGG).add(ModItems.ELITE_VOID_SPAWN_SPAWN_EGG.get());


        //Tools
        tag(ModTags.Items.VOID_SWORD_UNPOWERED).add(ModItems.VOID_SWORD_UNPOWERED.get());
        tag(ModTags.Items.VOID_SWORD_POWERED).add(ModItems.VOID_SWORD_POWERED.get());
        tag(ModTags.Items.VOID_PICKAXE).add(ModItems.VOID_PICKAXE.get());
        tag(ModTags.Items.VOID_BOW).add(ModItems.VOID_BOW.get());



        //Tool Workables
        tag(ModTags.Items.VOID_PICKAXE_HEAD).add(ModItems.VOID_PICKAXE_HEAD.get());
        tag(ModTags.Items.VOID_SWORD_HANDLE).add(ModItems.VOID_SWORD_HANDLE.get());
        tag(ModTags.Items.VOID_SWORD_LOWER_HALF).add(ModItems.VOID_SWORD_LOWER_HALF.get());
        tag(ModTags.Items.VOID_TOOL_HANDLE).add(ModItems.VOID_TOOL_HANDLE.get());
        tag(ModTags.Items.VOID_SWORD_BLADE).add(ModItems.VOID_SWORD_BLADE.get());
        tag(ModTags.Items.VOID_SWORD_GUARD).add(ModItems.VOID_SWORD_GUARD.get());
        tag(ModTags.Items.VOID_BOW_BODY).add(ModItems.VOID_BOW_BODY.get());
        tag(ModTags.Items.VOID_BOW_UNPOWERED_BODY).add(ModItems.VOID_BOW_UNPOWERED_BODY.get());


        //Armor
        tag(ModTags.Items.VOID_HELMET).add(ModItems.VOID_HELMET.get());
        tag(ModTags.Items.VOID_CHESTPLATE).add(ModItems.VOID_CHESTPLATE.get());
        tag(ModTags.Items.VOID_LEGGINGS).add(ModItems.VOID_LEGGINGS.get());
        tag(ModTags.Items.VOID_BOOTS).add(ModItems.VOID_BOOTS.get());
        tag(ModTags.Items.VOID_RELIC_HELMET).add(ModItems.VOID_RELIC_HELMET.get());
        tag(ModTags.Items.VOID_RELIC_CHESTPLATE).add(ModItems.VOID_RELIC_CHESTPLATE.get());
        tag(ModTags.Items.VOID_RELIC_LEGGINGS).add(ModItems.VOID_RELIC_LEGGINGS.get());
        tag(ModTags.Items.VOID_RELIC_BOOTS).add(ModItems.VOID_RELIC_BOOTS.get());

    }
}
