package net.sefalonzophry.voidascension.screen;

import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sefalonzophry.voidascension.VoidAscension;
import net.sefalonzophry.voidascension.screen.voiddestabilizer.VoidDestabilizerMenu;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, VoidAscension.MOD_ID);

    public static final RegistryObject<MenuType<VoidDestabilizerMenu>> VOID_DESTABILIZER_MENU =
            registerMenuType("void_destabilizer_menu", VoidDestabilizerMenu::new);

    private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> registerMenuType(String name, IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventbus) {
        MENUS.register(eventbus);
    }
}
