package net.beyondredemption2122.voidascension.setup.init;

import net.beyondredemption2122.voidascension.VoidAscension;
import net.beyondredemption2122.voidascension.setup.customblocks.ModBlocks;
import net.beyondredemption2122.voidascension.setup.customblocks.tileentities.PedestalTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityTypesInit {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPE = DeferredRegister
            .create(ForgeRegistries.TILE_ENTITIES, VoidAscension.MOD_ID);

    public static final RegistryObject<TileEntityType<PedestalTileEntity>> PEDESTAL_TILE_ENTITY_TYPE = TILE_ENTITY_TYPE
            .register("pedestal", () -> TileEntityType.Builder.of(PedestalTileEntity::new, ModBlocks.PEDESTAL.get()).build(null));
}
