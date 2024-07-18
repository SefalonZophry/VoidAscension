package net.sefalonzophry.voidascension.data;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.sefalonzophry.voidascension.VoidAscension;
import net.sefalonzophry.voidascension.setup.curios.curiositems.items.RiftFormer;
import net.sefalonzophry.voidascension.setup.customblocks.ModBlocks;
import net.sefalonzophry.voidascension.setup.moditems.ModItems;

public class VoidAscensionCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, VoidAscension.MOD_ID);

    public static final RegistryObject<CreativeModeTab> VOID_ASCENSION_TAB = CREATIVE_MODE_TABS.register("void_ascension_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RIFT_CRYSTAL.get()))
                    .title(Component.translatable("creativetab.void_ascension_tab"))
                    .displayItems((pParameters, pOutput) -> {

                        //Items
                        pOutput.accept(ModItems.RIFT_FORMER.get());
                        pOutput.accept(ModItems.RIFT_CRYSTAL.get());
                        pOutput.accept(ModItems.UNSTABLE_RIFT_CRYSTAL.get());
                        pOutput.accept(ModItems.VOID_ESSENCE.get());
                        pOutput.accept(ModItems.EMPOWERED_VOID_ESSENCE.get());
                        pOutput.accept(ModItems.LIVING_VOID_INGOT.get());
                        pOutput.accept(ModItems.VOID_ARROW.get());
                        pOutput.accept(ModItems.VOID_ARROW_HEAD.get());
                        pOutput.accept(ModItems.VOID_ARROW_SHAFT.get());
                        pOutput.accept(ModItems.VOID_BOW.get());
                        pOutput.accept(ModItems.VOID_BOW_BODY.get());
                        pOutput.accept(ModItems.VOID_BOW_UNPOWERED_BODY.get());
                        pOutput.accept(ModItems.EMPTY_SYRINGE.get());
                        pOutput.accept(ModItems.FILLED_VOID_ESSENCE_SYRINGE.get());
                        pOutput.accept(ModItems.EMPTY_VOID_ESSENCE_CAPSULE.get());
                        pOutput.accept(ModItems.RELIC.get());
                        pOutput.accept(ModItems.NE_RELIC_PIECE.get());
                        pOutput.accept(ModItems.NW_RELIC_PIECE.get());
                        pOutput.accept(ModItems.SE_RELIC_PIECE.get());
                        pOutput.accept(ModItems.SW_RELIC_PIECE.get());
                        pOutput.accept(ModItems.VOID_HELMET.get());
                        pOutput.accept(ModItems.VOID_CHESTPLATE.get());
                        pOutput.accept(ModItems.VOID_LEGGINGS.get());
                        pOutput.accept(ModItems.VOID_BOOTS.get());
                        pOutput.accept(ModItems.VOID_RELIC_HELMET.get());
                        pOutput.accept(ModItems.VOID_RELIC_CHESTPLATE.get());
                        pOutput.accept(ModItems.VOID_RELIC_LEGGINGS.get());
                        pOutput.accept(ModItems.VOID_RELIC_BOOTS.get());
                        pOutput.accept(ModItems.VOID_TOOL_HANDLE.get());
                        pOutput.accept(ModItems.VOID_SWORD_POWERED.get());
                        pOutput.accept(ModItems.VOID_SWORD_UNPOWERED.get());
                        pOutput.accept(ModItems.VOID_SWORD_BLADE.get());
                        pOutput.accept(ModItems.VOID_SWORD_GUARD.get());
                        pOutput.accept(ModItems.VOID_SWORD_HANDLE.get());
                        pOutput.accept(ModItems.VOID_SWORD_LOWER_HALF.get());
                        pOutput.accept(ModItems.VOID_BATTLE_AXE.get());
                        pOutput.accept(ModItems.VOID_BATTLE_AXE_HEAD.get());
                        pOutput.accept(ModItems.VOID_PICKAXE.get());
                        pOutput.accept(ModItems.VOID_PICKAXE_HEAD.get());
                        pOutput.accept(ModItems.VOID_SHOVEL.get());
                        pOutput.accept(ModItems.VOID_SHOVEL_HEAD.get());
                        pOutput.accept(ModItems.VOID_SPAWN_SPAWN_EGG.get());
                        pOutput.accept(ModItems.ELITE_VOID_SPAWN_SPAWN_EGG.get());
                        pOutput.accept(ModItems.INJECTOR_SPAWN_EGG.get());
                        //Blocks
                        pOutput.accept(ModBlocks.RIFT_CRYSTAL_ORE_BLOCK.get());
                        pOutput.accept(ModBlocks.CHALICE.get());
                        pOutput.accept(ModBlocks.VOID_FENCE.get());
                        pOutput.accept(ModBlocks.VOID_STAIRS.get());
                        pOutput.accept(ModBlocks.VOID_SLAB.get());
                        pOutput.accept(ModBlocks.VOID_STONE.get());
                        pOutput.accept(ModBlocks.VOID_PILLAR_TOP.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_RIFT_CRYSTAL_ORE_BLOCK.get());

                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
