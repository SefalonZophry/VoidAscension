package net.sefalonzophry.voidascension.data.client;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.sefalonzophry.voidascension.VoidAscension;
import net.sefalonzophry.voidascension.setup.block.ModBlocks;
import net.sefalonzophry.voidascension.setup.ModTags;
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
                .add(ModBlocks.DEEPSLATE_VOID_CRYSTAL_ORE_BLOCK.get()).addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.LOGS_THAT_BURN);

        this.tag(BlockTags.PLANKS)
                .add(ModBlocks.VOID_TOUCHED_PLANKS.get());

        this.tag(BlockTags.LOGS)
                .add(ModBlocks.VOID_TOUCHED_LOG.get());

        this.tag(BlockTags.LEAVES)
                .add(ModBlocks.VOID_TOUCHED_LEAVES.get());
    }
}
