package net.sefalonzophry.voidascension.setup.init;

import net.sefalonzophry.voidascension.VoidAscension;
import net.sefalonzophry.voidascension.setup.customblocks.ModBlocks;
import net.sefalonzophry.voidascension.setup.customblocks.tileentities.PedestalTileEntity;
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
