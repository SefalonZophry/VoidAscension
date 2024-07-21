package net.sefalonzophry.voidascension.setup.worldgen.tree;

import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.sefalonzophry.voidascension.setup.worldgen.ModConfiguredFeatures;
import org.jetbrains.annotations.Nullable;

public class VoidTouchedTreeGrower extends AbstractTreeGrower {
    @Nullable
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource pRandom, boolean pHasFlowers) {
        return ModConfiguredFeatures.VOID_TOUCHED_TREE_KEY;
    }
}
