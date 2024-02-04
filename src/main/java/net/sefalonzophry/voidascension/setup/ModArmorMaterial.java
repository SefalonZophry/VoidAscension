package net.sefalonzophry.voidascension.setup;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.sefalonzophry.voidascension.setup.moditems.ModItems;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.sefalonzophry.voidascension.VoidAscension;

import java.util.function.Supplier;

public enum ModArmorMaterial implements ArmorMaterial {

    VOID("void", 78, new int[] {4, 6, 7, 5}, 15,
            SoundEvents.ARMOR_EQUIP_IRON, 5.0f, 0.4f, () -> {
        return Ingredient.of(ModItems.RIFT_CRYSTAL.get());

    }),
    VOID_RELIC("void_relic", 78, new int[] {6, 10, 12, 7}, 15,
            SoundEvents.ARMOR_EQUIP_DIAMOND, 10.0f, 0.6f, () -> {
        return Ingredient.of(ModItems.UNSTABLE_RIFT_CRYSTAL.get());
    });

    private static final int[] BASE_DURABILITY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmount;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    private ModArmorMaterial(String p_i231593_3_, int p_i231593_4_, int[] p_i231593_5_, int p_i231593_6_, SoundEvent p_i231593_7_, float p_i231593_8_, float p_i231593_9_, Supplier<Ingredient> repairIngredient) {
        this.name = p_i231593_3_;
        this.durabilityMultiplier = p_i231593_4_;
        this.protectionAmount = p_i231593_5_;
        this.enchantmentValue = p_i231593_6_;
        this.sound = p_i231593_7_;
        this.toughness = p_i231593_8_;
        this.knockbackResistance = p_i231593_9_;
        this.repairIngredient = repairIngredient;
    }

    public int getDurabilityForType(ArmorItem.Type pType) {
        return BASE_DURABILITY[pType.ordinal()] * this.durabilityMultiplier;
    }

    public int getDefenseForType(ArmorItem.Type pType) {
        return this.protectionAmount[pType.ordinal()];
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public SoundEvent getEquipSound() {
        return this.sound;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @OnlyIn(Dist.CLIENT)
    public String getName() {
        return VoidAscension.MOD_ID + ":" + this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}