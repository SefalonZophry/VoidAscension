package net.sefalonzophry.voidascension.setup.block.tileentities.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.sefalonzophry.voidascension.VoidAscension;
import org.jetbrains.annotations.Nullable;

public class VoidDestabilizerRecipes implements Recipe<SimpleContainer> {
    private final NonNullList<Ingredient> inputItem;
    private final ItemStack output;
    private final ResourceLocation id;

    public VoidDestabilizerRecipes(NonNullList<Ingredient> inputItem, ItemStack output, ResourceLocation id) {
        this.inputItem = inputItem;
        this.output = output;
        this.id = id;
    }

    @Override
    public boolean matches(SimpleContainer simpleContainer, Level level) {
        if(level.isClientSide()) {
            return false;
        }
        return inputItem.get(0).test(simpleContainer.getItem(0)) && inputItem.get(1).test(simpleContainer.getItem(1)) && inputItem.get(0).test(simpleContainer.getItem(2));
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return inputItem;
    }

    @Override
    public ItemStack assemble(SimpleContainer simpleContainer, RegistryAccess registryAccess) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int i, int i1) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess registryAccess) {
        return output.copy();
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<VoidDestabilizerRecipes> {
        public static final Type INSTANCE = new Type();
        public static final String ID = "void_destabilizing";
    }

    public static class Serializer implements RecipeSerializer<VoidDestabilizerRecipes> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID = new ResourceLocation(VoidAscension.MOD_ID, "void_destabilizing");

        @Override
        public VoidDestabilizerRecipes fromJson(ResourceLocation resourceLocation, JsonObject jsonObject) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(jsonObject, "output"));

            JsonArray ingredients = GsonHelper.getAsJsonArray(jsonObject, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(2, Ingredient.EMPTY);

            for(int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new VoidDestabilizerRecipes(inputs, output, resourceLocation);
        }

        @Override
        public @Nullable VoidDestabilizerRecipes fromNetwork(ResourceLocation resourceLocation, FriendlyByteBuf friendlyByteBuf) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(friendlyByteBuf.readInt(), Ingredient.EMPTY);

            for(int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(friendlyByteBuf));
            }

            ItemStack output = friendlyByteBuf.readItem();
            return new VoidDestabilizerRecipes(inputs, output, resourceLocation);
        }

        @Override
        public void toNetwork(FriendlyByteBuf friendlyByteBuf, VoidDestabilizerRecipes voidDestabilizerRecipes) {
            friendlyByteBuf.writeInt(voidDestabilizerRecipes.inputItem.size());

            for (Ingredient ingredient : voidDestabilizerRecipes.getIngredients()) {
                ingredient.toNetwork(friendlyByteBuf);
            }

            friendlyByteBuf.writeItemStack(voidDestabilizerRecipes.getResultItem(null), false);
        }
    }
}
