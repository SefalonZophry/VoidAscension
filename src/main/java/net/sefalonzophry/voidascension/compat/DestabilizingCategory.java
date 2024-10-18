package net.sefalonzophry.voidascension.compat;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.sefalonzophry.voidascension.VoidAscension;
import net.sefalonzophry.voidascension.setup.block.ModBlocks;
import net.sefalonzophry.voidascension.setup.block.tileentities.recipe.VoidDestabilizerRecipes;
import net.sefalonzophry.voidascension.setup.moditems.ModItems;

public class DestabilizingCategory implements IRecipeCategory<VoidDestabilizerRecipes> {
    public static final ResourceLocation UID = new ResourceLocation(VoidAscension.MOD_ID, "destabilizing");
    public static final ResourceLocation TEXTURE = new ResourceLocation(VoidAscension.MOD_ID, "textures/gui/void_destabilizer_jei_gui.png");

    public static final RecipeType<VoidDestabilizerRecipes> DESTABILIZING_TYPE =
            new RecipeType<>(UID, VoidDestabilizerRecipes.class);

    private final IDrawable background;
    private final IDrawable icon;

    public DestabilizingCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0,0,176,85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.VOID_DESTABILIZER.get()));
    }

    @Override
    public RecipeType<VoidDestabilizerRecipes> getRecipeType() {
        return DESTABILIZING_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.voidascension.void_destabilizer");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder iRecipeLayoutBuilder, VoidDestabilizerRecipes voidDestabilizerRecipes, IFocusGroup iFocusGroup) {
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 52, 11).addIngredients(Ingredient.of(ModItems.VOID_ASH.get()));
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 80, 11).addIngredients(Ingredient.of(ModItems.FILLED_VOID_ESSENCE_CAPSULE.get()));
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 107, 11).addIngredients(Ingredient.of(ModItems.VOID_ASH.get()));

        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.OUTPUT, 80, 59).addItemStack(voidDestabilizerRecipes.getResultItem(null));
    }
}
