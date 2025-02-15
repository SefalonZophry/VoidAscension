/*
package net.sefalonzophry.voidascension.data.client;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.sefalonzophry.voidascension.VoidAscension;
import net.sefalonzophry.voidascension.setup.util.ModTags;
import net.sefalonzophry.voidascension.setup.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, VoidAscension.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.ORES)
                .add(ModBlocks.VOID_CRYSTAL_ORE_BLOCK.get()).addTag(Tags.Blocks.ORES)
                .add(ModBlocks.DEEPSLATE_VOID_CRYSTAL_ORE_BLOCK.get()).addTag(Tags.Blocks.ORES)
                .add(ModBlocks.VOID_NYTHRIL_ORE.get()).addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).replace(false)
                .add(ModBlocks.VOID_STONE.get(),
                        ModBlocks.VOID_STAIRS.get(),
                        ModBlocks.VOID_FENCE.get(),
                        ModBlocks.DARKENED_VOID_STONE.get(),
                        ModBlocks.VOID_SLAB.get(),
                        ModBlocks.VOID_PILLAR_TOP.get(),
                        ModBlocks.VOID_DESTABILIZER.get(),
                        ModBlocks.VOID_SPIKE_HEART.get(),
                        ModBlocks.VOID_CRYSTAL_ORE_BLOCK.get(),
                        ModBlocks.DEEPSLATE_VOID_CRYSTAL_ORE_BLOCK.get(),
                        ModBlocks.VOID_NYTHRIL_ORE.get());

        this.tag(ModTags.Blocks.NEEDS_VOID_TOOL).replace(false)
                .add(ModBlocks.VOID_STONE.get(),
                        ModBlocks.VOID_FENCE.get(),
                        ModBlocks.VOID_SLAB.get(),
                        ModBlocks.VOID_PILLAR_TOP.get(),
                        ModBlocks.VOID_DESTABILIZER.get(),
                        ModBlocks.VOID_CRYSTAL_ORE_BLOCK.get(),
                        ModBlocks.DEEPSLATE_VOID_CRYSTAL_ORE_BLOCK.get(),
                        ModBlocks.VOID_NYTHRIL_ORE.get());

        this.tag(ModTags.Blocks.NEEDS_NYTHRIL_TOOL).replace(false)
                .add(ModBlocks.VOID_STONE.get(),
                        ModBlocks.VOID_FENCE.get(),
                        ModBlocks.DARKENED_VOID_STONE.get(),
                        ModBlocks.VOID_SLAB.get(),
                        ModBlocks.VOID_PILLAR_TOP.get(),
                        ModBlocks.VOID_DESTABILIZER.get(),
                        ModBlocks.VOID_SPIKE_HEART.get(),
                        ModBlocks.VOID_CRYSTAL_ORE_BLOCK.get(),
                        ModBlocks.DEEPSLATE_VOID_CRYSTAL_ORE_BLOCK.get(),
                        ModBlocks.VOID_NYTHRIL_ORE.get());

        this.tag(ModTags.Blocks.MACHINES)
                .add(ModBlocks.VOID_DESTABILIZER.get());

        this.tag(ModTags.Blocks.PORTALS)
                .add(ModBlocks.CHALICE.get());

//        this.tag(ModTags.Blocks.DECOR)
//                .add(ModBlocks.VOID_PILLAR_TOP.get(),
//                        ModBlocks.VOID_STONE.get(),
//                        ModBlocks.DARKENED_VOID_STONE.get());

//        this.tag(ModTags.Blocks.LIVING_VOID)
//                .add(ModBlocks.VOID_SPIKE_HEART.get());

        this.tag(BlockTags.PLANKS)
                .add(ModBlocks.VOID_TOUCHED_PLANKS.get());

        this.tag(BlockTags.LOGS)
                .add(ModBlocks.VOID_TOUCHED_LOG.get());

        this.tag(BlockTags.LEAVES)
                .add(ModBlocks.VOID_TOUCHED_LEAVES.get());

        this.tag(BlockTags.STAIRS)
                .add(ModBlocks.VOID_STAIRS.get());

        this.tag(BlockTags.FENCES)
                .add(ModBlocks.VOID_FENCE.get());

        this.tag(BlockTags.SLABS)
                .add(ModBlocks.VOID_SLAB.get());
    }
}
/*
 */