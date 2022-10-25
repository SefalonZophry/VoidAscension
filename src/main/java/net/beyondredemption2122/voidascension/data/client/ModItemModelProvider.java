package net.beyondredemption2122.voidascension.data.client;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.beyondredemption2122.voidascension.VoidAscension;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, VoidAscension.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        //Items
        withExistingParent("rift_crystal",
                modLoc("item/rift_crystal"));

        withExistingParent("void_infused_string",
                modLoc("item/void_infused_string"));

        withExistingParent("void_essence",
                modLoc("item/void_essence"));

        withExistingParent("empowered_void_essence",
                modLoc("item/empowered_void_essence"));

        withExistingParent("living_void_steel_ingot",
                modLoc("item/living_void_steel_ingot"));

        withExistingParent("ne_relic_piece",
                modLoc("item/ne_relic_piece"));

        withExistingParent("se_relic_piece",
                modLoc("item/se_relic_piece"));

        withExistingParent("sw_relic_piece",
                modLoc("item/sw_relic_piece"));

        withExistingParent("nw_relic_piece",
                modLoc("item/nw_relic_piece"));

        withExistingParent("relic",
                modLoc("item/relic"));

        withExistingParent("void_essence_capsule",
                modLoc("item/void_essence_capsule"));

        //Blocks
        withExistingParent("rift_crystal_ore_block",
                modLoc("block/rift_crystal_ore_block"));

        withExistingParent("void_stone",
                modLoc("block/void_stone"));

        withExistingParent("void_pillar_top",
                modLoc("block/void_pillar_top"));


        //Workables
        withExistingParent("void_pickaxe_head",
                modLoc("item/void_pickaxe_head"));

        withExistingParent("void_pickaxe_handle",
                modLoc("item/void_pickaxe_handle"));

        withExistingParent("void_sword_guard",
                modLoc("item/void_sword_guard"));

        withExistingParent("void_sword_handle",
                modLoc("item/void_sword_handle"));

        withExistingParent("void_sword_lower_half",
                modLoc("item/void_sword_lower_half"));

        withExistingParent("void_sword_blade",
                modLoc("item/void_sword_blade"));


        ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));


        //Items
        builder(itemGenerated,
                "rift_former");
        builder(itemGenerated,
                "void_essence");
        builder(itemGenerated,
                "empowered_void_essence");
        builder(itemGenerated,
                "rift_crystal");
        builder(itemGenerated,
                "void_infused_string");
        builder(itemGenerated,
                "unstable_rift_crystal");
        builder(itemGenerated,
                "living_void_steel_ingot");
        builder(itemGenerated,
                "ne_relic_piece");
        builder(itemGenerated,
                "se_relic_piece");
        builder(itemGenerated,
                "sw_relic_piece");
        builder(itemGenerated,
                "nw_relic_piece");
        builder(itemGenerated,
                "relic");
        builder(itemGenerated,
                "void_essence_capsule");




        //Blocks



        //Workables
        builder(itemGenerated,
                "void_pickaxe_head");
        builder(itemGenerated,
                "void_pickaxe_handle");
        builder(itemGenerated,
                "void_sword_handle");
        builder(itemGenerated,
                "void_sword_guard");
        builder(itemGenerated,
                "void_sword_lower_half");
        builder(itemGenerated,
                "void_sword_blade");

    }

    private ItemModelBuilder builder(ModelFile itemGenerated, String name) {
        return getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + name);
    }
}
