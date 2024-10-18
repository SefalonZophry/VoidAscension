package net.sefalonzophry.voidascension.setup.block.tileentities.recipe;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sefalonzophry.voidascension.VoidAscension;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, VoidAscension.MOD_ID);

    public static final RegistryObject<RecipeSerializer<VoidDestabilizerRecipes>> VOID_DESTABILIZER_SERIALIZER =
            SERIALIZERS.register("void_destabilizing", () -> VoidDestabilizerRecipes.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
