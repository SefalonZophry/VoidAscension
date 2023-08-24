package net.beyondredemption2122.voidascension.data.client;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.beyondredemption2122.voidascension.VoidAscension;
import net.beyondredemption2122.voidascension.setup.customblocks.ModBlocks;
import net.beyondredemption2122.voidascension.setup.ModTags;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(DataGenerator  generatorIn, ExistingFileHelper existingFileHelper) {
        super(generatorIn, VoidAscension.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(ModTags.Blocks.VOID_STONE).add(ModBlocks.VOID_STONE.get());
        tag(ModTags.Blocks.VOID_PILLAR_TOP).add(ModBlocks.VOID_PILLAR_TOP.get());
        tag(ModTags.Blocks.VOID_FENCE).add(ModBlocks.VOID_FENCE.get());
        tag(ModTags.Blocks.VOID_SLAB).add(ModBlocks.VOID_SLAB.get());
        tag(ModTags.Blocks.VOID_STAIRS).add(ModBlocks.VOID_STAIRS.get());
//        tag(ModTags.Blocks.ALTAR).add(ModBlocks.ALTAR.get());
//        tag(ModTags.Blocks.CHALICE).add(ModBlocks.ALTAR.get());
    }
}