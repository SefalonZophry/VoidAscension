package net.sefalonzophry.voidascension.data.client;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.sefalonzophry.voidascension.VoidAscension;
import net.sefalonzophry.voidascension.setup.customblocks.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, VoidAscension.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.VOID_STONE.get());
        simpleBlock(ModBlocks.VOID_PILLAR_TOP.get());


    }

    private ModelFile.ExistingModelFile getExistingModel(String blockName) {
        return models().getExistingFile(modLoc(blockName));
    }
}