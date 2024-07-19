package net.sefalonzophry.voidascension.data.client.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraftforge.registries.RegistryObject;
import net.sefalonzophry.voidascension.setup.customblocks.ModBlocks;
import net.sefalonzophry.voidascension.setup.moditems.ModItems;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {


    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.VOID_STONE.get());
        this.dropSelf(ModBlocks.VOID_SLAB.get());
        this.dropSelf(ModBlocks.VOID_PILLAR_TOP.get());
        this.dropSelf(ModBlocks.VOID_STAIRS.get());
        this.dropSelf(ModBlocks.VOID_FENCE.get());

        this.add(ModBlocks.VOID_CRYSTAL_ORE_BLOCK.get(),
                block -> createOreDrop(ModBlocks.VOID_CRYSTAL_ORE_BLOCK.get(), ModItems.VOID_CRYSTAL.get()));
        this.add(ModBlocks.DEEPSLATE_VOID_CRYSTAL_ORE_BLOCK.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_VOID_CRYSTAL_ORE_BLOCK.get(), ModItems.VOID_CRYSTAL.get()));

    }
    protected LootTable.Builder createOreDrop(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
