package net.beyondredemption2122.voidascension.data.client;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.sun.org.apache.xpath.internal.operations.Mod;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.loot.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.beyondredemption2122.voidascension.setup.customblocks.ModBlocks;
import net.beyondredemption2122.voidascension.setup.moditems.ModItems;
import net.beyondredemption2122.voidascension.setup.Registration;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ModLootTableProvider extends LootTableProvider {
    public ModLootTableProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> getTables() {
        return ImmutableList.of(
                Pair.of(ModBlockLootTables::new, LootParameterSets.BLOCK)
        );
    }


    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationTracker validationTracker) {
        map.forEach((p_218436_2_, p_218436_3_) -> LootTableManager.validate(validationTracker, p_218436_2_, p_218436_3_));
    }

    public static class ModBlockLootTables extends BlockLootTables {
        @Override
        protected void addTables() {
//            dropOther(ModBlocks.RIFT_CRYSTAL_ORE_BLOCK.get(), ModItems.RIFT_CRYSTAL.get());
            dropSelf(ModBlocks.ALTAR.get());
            dropSelf(ModBlocks.CHALICE.get());
            dropSelf(ModBlocks.PEDESTAL.get());
            dropSelf(ModBlocks.VOID_STONE.get());
            dropSelf(ModBlocks.VOID_PILLAR_TOP.get());
            dropSelf(ModBlocks.VOID_STAIRS.get());
            dropSelf(ModBlocks.VOID_FENCE.get());
            dropSelf(ModBlocks.VOID_SLAB.get());

        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return Registration.BLOCKS.getEntries().stream()
                    .map(RegistryObject::get)
                    .collect((Collectors.toList()));
        }
    }
}