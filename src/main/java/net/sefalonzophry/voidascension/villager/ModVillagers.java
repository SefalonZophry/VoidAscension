package net.sefalonzophry.voidascension.villager;

import com.google.common.collect.ImmutableSet;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sefalonzophry.voidascension.VoidAscension;
import net.sefalonzophry.voidascension.setup.block.ModBlocks;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, VoidAscension.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, VoidAscension.MOD_ID);

    public static final RegistryObject<PoiType> VOID_POI = POI_TYPES.register("void_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.VOID_DESTABILIZER.get().getStateDefinition().getPossibleStates()),
                    1,1));

    public static final RegistryObject<VillagerProfession> VOID_SPECIALIST =
            VILLAGER_PROFESSIONS.register("voidspecialist", () -> new VillagerProfession("voidspecialist",
                    holder -> holder.get() == VOID_POI.get(), holder -> holder.get() == VOID_POI.get(),
                    ImmutableSet.of(), ImmutableSet.of(), SoundEvents.EMPTY));

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
