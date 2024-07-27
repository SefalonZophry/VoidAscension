package net.sefalonzophry.voidascension.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.sefalonzophry.voidascension.data.client.*;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.data.event.GatherDataEvent;
import net.sefalonzophry.voidascension.VoidAscension;
import net.sefalonzophry.voidascension.data.client.loot.ModGlobalLootModifiersProvider;
import net.sefalonzophry.voidascension.data.client.loot.ModLootTableProvider;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = VoidAscension.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    private DataGenerators() {
    }

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), ModLootTableProvider.create(packOutput));

        generator.addProvider(event.includeClient(), new ModBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModItemModelProvider(packOutput, existingFileHelper));

        generator.addProvider(event.includeServer(), new ModWorldGenProvider(packOutput, lookupProvider));

        generator.addProvider(event.includeServer(), new ModGlobalLootModifiersProvider(packOutput));
    }
}