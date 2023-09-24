package net.sefalonzophry.voidascension.setup.init;

import net.sefalonzophry.voidascension.VoidAscension;
import net.sefalonzophry.voidascension.setup.customblocks.tileentities.container.PedestalContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ContainerTypesinit {

    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = DeferredRegister
            .create(ForgeRegistries.CONTAINERS, VoidAscension.MOD_ID);

    public static final RegistryObject<ContainerType<PedestalContainer>> PEDESTAL_CONTAINER_TYPE = CONTAINER_TYPES
            .register("pedestal", () -> IForgeContainerType.create(PedestalContainer::new));
}
