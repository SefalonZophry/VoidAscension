package net.beyondredemption2122.voidascension.setup.customblocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class CrystalOre extends Block {

    public CrystalOre() {
        super(AbstractBlock.Properties.of(Material.STONE)
                .strength(2.5f, 3.0f)
                .sound(SoundType.STONE)
                .harvestLevel(3)
                .harvestTool(ToolType.PICKAXE)
                .requiresCorrectToolForDrops());
    }

    public static void register() {}
}
