package net.sefalonzophry.voidascension.setup.moditems;

import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.sefalonzophry.voidascension.VoidAscension;
import net.sefalonzophry.voidascension.setup.*;
import net.sefalonzophry.voidascension.setup.customblocks.ModBlocks;
import net.sefalonzophry.voidascension.setup.moditems.custom.ModArmorItem;
import net.sefalonzophry.voidascension.setup.moditems.custom.ModItemTier;
import net.sefalonzophry.voidascension.setup.moditems.custom.VoidArrowItem;
import net.sefalonzophry.voidascension.setup.moditems.custom.VoidBow;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import net.sefalonzophry.voidascension.setup.entity.ModEntityTypes;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, VoidAscension.MOD_ID);

    //Items
    public static final RegistryObject<Item> RIFT_FORMER = ITEMS.register("rift_former", () ->
            new Item(new Item.Properties()));

    public static final RegistryObject<Item> RIFT_CRYSTAL = ITEMS.register("rift_crystal", () ->
            new Item(new Item.Properties()));

    public static final RegistryObject<Item> UNSTABLE_RIFT_CRYSTAL = ITEMS.register("unstable_rift_crystal", () ->
            new Item(new Item.Properties()));

    public static final RegistryObject<Item> VOID_INFUSED_STRING = ITEMS.register("void_infused_string", () ->
            new Item(new Item.Properties()));

    public static final RegistryObject<Item> LIVING_VOID_INGOT = ITEMS.register("living_void_ingot", () ->
            new Item(new Item.Properties()));

    public static final RegistryObject<Item> VOID_ESSENCE = ITEMS.register("void_essence", () ->
            new Item(new Item.Properties()));

    public static final RegistryObject<Item> EMPOWERED_VOID_ESSENCE = ITEMS.register("empowered_void_essence", () ->
            new Item(new Item.Properties()));

    public static final RegistryObject<Item> NE_RELIC_PIECE = ITEMS.register("ne_relic_piece", () ->
            new Item(new Item.Properties()));

    public static final RegistryObject<Item> SE_RELIC_PIECE = ITEMS.register("se_relic_piece", () ->
            new Item(new Item.Properties()));

    public static final RegistryObject<Item> SW_RELIC_PIECE = ITEMS.register("sw_relic_piece", () ->
            new Item(new Item.Properties()));

    public static final RegistryObject<Item> NW_RELIC_PIECE = ITEMS.register("nw_relic_piece", () ->
            new Item(new Item.Properties()));

    public static final RegistryObject<Item> RELIC = ITEMS.register("relic", () ->
            new Item(new Item.Properties()));

    public static final RegistryObject<Item> VOID_ESSENCE_CAPSULE = ITEMS.register("void_essence_capsule", () ->
            new Item(new Item.Properties()));

    public static final RegistryObject<Item> EMPTY_VOID_ESSENCE_CAPSULE = ITEMS.register("empty_void_essence_capsule", () ->
            new Item(new Item.Properties()));

    public static final RegistryObject<Item> EMPTY_SYRINGE = ITEMS.register("empty_syringe", () ->
            new Item(new Item.Properties()));

    public static final RegistryObject<Item> FILLED_VOID_ESSENCE_SYRINGE = ITEMS.register("filled_void_essence_syringe", () ->
            new Item(new Item.Properties()));

    //Tool Workables
    public static final RegistryObject<Item> VOID_PICKAXE_HEAD = ITEMS.register("void_pickaxe_head", () ->
            new Item(new Item.Properties()));

    public static final RegistryObject<Item> VOID_TOOL_HANDLE = ITEMS.register("void_tool_handle", () ->
            new Item(new Item.Properties()));

    public static final RegistryObject<Item> VOID_SWORD_GUARD = ITEMS.register("void_sword_guard", () ->
            new Item(new Item.Properties()));

    public static final RegistryObject<Item> VOID_SWORD_HANDLE = ITEMS.register("void_sword_handle", () ->
            new Item(new Item.Properties()));

    public static final RegistryObject<Item> VOID_SWORD_LOWER_HALF = ITEMS.register("void_sword_lower_half", () ->
            new Item(new Item.Properties()));

    public static final RegistryObject<Item> VOID_SWORD_BLADE = ITEMS.register("void_sword_blade", () ->
            new Item(new Item.Properties()));

    public static final RegistryObject<Item> VOID_BOW_BODY = ITEMS.register("void_bow_body", () ->
            new Item(new Item.Properties()));

    public static final RegistryObject<Item> VOID_BOW_UNPOWERED_BODY = ITEMS.register("void_bow_unpowered_body", () ->
            new Item(new Item.Properties()));

    public static final RegistryObject<Item> VOID_SHOVEL_HEAD = ITEMS.register("void_shovel_head", () ->
            new Item(new Item.Properties()));

    public static final RegistryObject<Item> VOID_BATTLE_AXE_HEAD = ITEMS.register("void_battle_axe_head", () ->
            new Item(new Item.Properties()));


   //Tools
    public static final RegistryObject<Item> VOID_SWORD_UNPOWERED = ITEMS.register("void_sword_unpowered", () ->
            new SwordItem(ModItemTier.VOID,6, -2.5F,
                    new Item.Properties()));

    public static final RegistryObject<Item> VOID_SWORD_POWERED = ITEMS.register("void_sword_powered", () ->
            new SwordItem(ModItemTier.VOID,13, -2.3F,
                    new Item.Properties()));

    public static final RegistryObject<Item> VOID_PICKAXE = ITEMS.register("void_pickaxe", () ->
            new PickaxeItem(ModItemTier.VOID, 2,  -2.4F,
                    new Item.Properties()));

    public static final RegistryObject<Item> VOID_SHOVEL = ITEMS.register("void_shovel", () ->
            new ShovelItem(ModItemTier.VOID, 2,  -2.3F,
                    new Item.Properties()));

    public static final RegistryObject<Item> VOID_BATTLE_AXE = ITEMS.register("void_battle_axe", () ->
            new AxeItem(ModItemTier.VOID, 19, -2.7F,
                    new Item.Properties()));

    public static final RegistryObject<Item> VOID_BOW = ITEMS.register("void_bow", () ->
            new VoidBow(new Item.Properties().stacksTo(1) .durability( 2500)));

    //Arrows
    public static final RegistryObject<Item> VOID_ARROW = ITEMS.register("void_arrow", () ->
            new VoidArrowItem(new Item.Properties(), 1.5F));

    //Arrow Workables
    public static final RegistryObject<Item> VOID_ARROW_SHAFT = ITEMS.register("void_arrow_shaft", () ->
            new Item(new Item.Properties()));

    public static final RegistryObject<Item> VOID_ARROW_HEAD = ITEMS.register("void_arrow_head", () ->
            new Item(new Item.Properties()));

    //Armor
    public static final RegistryObject<Item> VOID_HELMET = ITEMS.register("void_helmet", () ->
            new ArmorItem(ModArmorMaterial.VOID, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<Item> VOID_CHESTPLATE = ITEMS.register("void_chestplate", () ->
            new ArmorItem(ModArmorMaterial.VOID, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    public static final RegistryObject<Item> VOID_LEGGINGS = ITEMS.register("void_leggings", () ->
            new ArmorItem(ModArmorMaterial.VOID, ArmorItem.Type.LEGGINGS, new Item.Properties()));

    public static final RegistryObject<Item> VOID_BOOTS = ITEMS.register("void_boots", () ->
            new ArmorItem(ModArmorMaterial.VOID, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> VOID_RELIC_HELMET = ITEMS.register("void_relic_helmet", () ->
            new ModArmorItem(ModArmorMaterial.VOID_RELIC, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<Item> VOID_RELIC_CHESTPLATE = ITEMS.register("void_relic_chestplate", () ->
            new ModArmorItem(ModArmorMaterial.VOID_RELIC, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    public static final RegistryObject<Item> VOID_RELIC_LEGGINGS = ITEMS.register("void_relic_leggings", () ->
            new ModArmorItem(ModArmorMaterial.VOID_RELIC, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> VOID_RELIC_BOOTS = ITEMS.register("void_relic_boots", () ->
            new ModArmorItem(ModArmorMaterial.VOID_RELIC, ArmorItem.Type.BOOTS, new Item.Properties()));

    //SpawnEggs
    public static final RegistryObject<ForgeSpawnEggItem> VOID_SPAWN_SPAWN_EGG = ITEMS.register("void_spawn_spawn_egg", () ->
            new ForgeSpawnEggItem(ModEntityTypes.VOIDSPAWN, 0x464F57, 0x1D6338,
                    new Item.Properties()));

    public static final RegistryObject<ForgeSpawnEggItem> INJECTOR_SPAWN_EGG = ITEMS.register("injector_spawn_egg", () ->
            new ForgeSpawnEggItem(ModEntityTypes.INJECTOR, 0x464F51, 0x1D6330,
                    new Item.Properties()));

    public static final RegistryObject<ForgeSpawnEggItem> ELITE_VOID_SPAWN_SPAWN_EGG = ITEMS.register("elite_void_spawn_spawn_egg", () ->
            new ForgeSpawnEggItem(ModEntityTypes.ELITEVOIDSPAWN, 0x464F51, 0x1D6330,
                    new Item.Properties()));



    // Block Items

//    public static final RegistryObject<Item> ALTAR_ITEM = ITEMS.register("altar", () -> new BlockItem(ModBlocks.ALTAR.get(), new Item.Properties()(RiftsItemGroup.creativeTab)));

    public static final RegistryObject<Item> CHALICE = ITEMS.register("chalice", () -> new BlockItem(ModBlocks.CHALICE.get(), new Item.Properties()));

//    public static final RegistryObject<Item> PEDESTAL = ITEMS.register("pedestal", () -> new BlockItem(ModBlocks.PEDESTAL.get(), new Item.Properties()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
