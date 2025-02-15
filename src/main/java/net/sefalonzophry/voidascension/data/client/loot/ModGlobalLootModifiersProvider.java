package net.sefalonzophry.voidascension.data.client.loot;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.sefalonzophry.voidascension.VoidAscension;
import net.sefalonzophry.voidascension.setup.block.ModBlocks;
import net.sefalonzophry.voidascension.setup.moditems.ModItems;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, VoidAscension.MOD_ID);
    }

    @Override
    protected void start() {
//        add("void_essence_from_void_crystal_ore", new AddItemModifier(new LootItemCondition[] {
//                LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.VOID_CRYSTAL_ORE_BLOCK.get()).build(),
//                LootItemRandomChanceCondition.randomChance(0.35f).build()}, ModItems.VOID_ESSENCE.get()));
    }
}
