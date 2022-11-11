package net.beyondredemption2122.voidascension.setup.customblocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.ToolType;

public class CrystalOre extends OreBlock {

    public CrystalOre() {
        super(AbstractBlock.Properties.of(Material.STONE)
                .strength(2.5f, 3.0f)
                .sound(SoundType.STONE)
                .harvestLevel(3)
                .harvestTool(ToolType.PICKAXE)
                .requiresCorrectToolForDrops());
    }

    public static void register() {}

    @Override
    public int getExpDrop(BlockState state, net.minecraft.world.IWorldReader reader, BlockPos pos, int fortune, int silktouch) {
        return silktouch == 0 ? this.xpOnDrop(RANDOM) : 0;
    }
}
