package net.sefalonzophry.voidascension.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;
import net.sefalonzophry.voidascension.VoidAscension;
import net.sefalonzophry.voidascension.screen.voiddestabilizer.VoidDestabilizerScreen;
import net.sefalonzophry.voidascension.setup.block.tileentities.recipe.VoidDestabilizerRecipes;

import java.util.List;

@JeiPlugin
public class JEIPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(VoidAscension.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new DestabilizingCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<VoidDestabilizerRecipes> destabilizingRecipes = recipeManager.getAllRecipesFor(VoidDestabilizerRecipes.Type.INSTANCE);
        registration.addRecipes(DestabilizingCategory.DESTABILIZING_TYPE, destabilizingRecipes);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(VoidDestabilizerScreen.class, 58, 30, 59, 26,
                DestabilizingCategory.DESTABILIZING_TYPE);
    }
}
