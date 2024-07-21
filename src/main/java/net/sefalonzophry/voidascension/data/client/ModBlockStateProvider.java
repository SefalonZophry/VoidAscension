package net.sefalonzophry.voidascension.data.client;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sefalonzophry.voidascension.VoidAscension;
import net.sefalonzophry.voidascension.setup.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, VoidAscension.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.VOID_STONE);
        blockWithItem(ModBlocks.VOID_PILLAR_TOP);

        logBlock(((RotatedPillarBlock) ModBlocks.VOID_TOUCHED_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.VOID_TOUCHED_WOOD.get()), blockTexture(ModBlocks.VOID_TOUCHED_LOG.get()), blockTexture(ModBlocks.VOID_TOUCHED_LOG.get()));

        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_VOID_TOUCHED_LOG.get()), blockTexture(ModBlocks.STRIPPED_VOID_TOUCHED_LOG.get()),
                new ResourceLocation(VoidAscension.MOD_ID, "block/stripped_void_touched_log_top"));

        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_VOID_TOUCHED_WOOD.get()), blockTexture(ModBlocks.STRIPPED_VOID_TOUCHED_LOG.get()),
                blockTexture(ModBlocks.STRIPPED_VOID_TOUCHED_LOG.get()));

        blockItem(ModBlocks.VOID_TOUCHED_LOG);
        blockItem(ModBlocks.VOID_TOUCHED_WOOD);
        blockItem(ModBlocks.STRIPPED_VOID_TOUCHED_LOG);
        blockItem(ModBlocks.STRIPPED_VOID_TOUCHED_WOOD);

        blockWithItem(ModBlocks.VOID_TOUCHED_PLANKS);

        leavesBlock(ModBlocks.VOID_TOUCHED_LEAVES);

        saplingBlock(ModBlocks.VOID_TOUCHED_TREE_SAPLING);
    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), new ResourceLocation("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(VoidAscension.MOD_ID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}