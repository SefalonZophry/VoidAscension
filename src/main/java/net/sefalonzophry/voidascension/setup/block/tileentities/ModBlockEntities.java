package net.sefalonzophry.voidascension.setup.block.tileentities;

import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sefalonzophry.voidascension.VoidAscension;
import net.sefalonzophry.voidascension.setup.block.ModBlocks;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, VoidAscension.MOD_ID);

    public static final RegistryObject<BlockEntityType<VoidDestabilizerBlockEntity>> VOID_DESTABILIZER_BE =
            BLOCK_ENTITIES.register("void_destabilizer_be", () ->
                    BlockEntityType.Builder.of(VoidDestabilizerBlockEntity::new,
                            ModBlocks.VOID_DESTABILIZER.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
