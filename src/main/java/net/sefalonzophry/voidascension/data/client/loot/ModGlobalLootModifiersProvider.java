package net.sefalonzophry.voidascension.data.client.loot;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.sefalonzophry.voidascension.VoidAscension;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, VoidAscension.MOD_ID);
    }

    @Override
    protected void start() {


    }
}
