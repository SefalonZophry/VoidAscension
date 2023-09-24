package net.sefalonzophry.voidascension.setup.entity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.sefalonzophry.voidascension.VoidAscension;
import net.sefalonzophry.voidascension.setup.entity.custom.InjectorEntity;
import net.sefalonzophry.voidascension.setup.entity.custom.VoidSpawnEntity;

public class ModEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES
            = DeferredRegister.create(ForgeRegistries.ENTITIES, VoidAscension.MOD_ID);

    public static final RegistryObject<EntityType<VoidSpawnEntity>> VOIDSPAWN =
            ENTITY_TYPES.register("voidspawn",
                    () -> EntityType.Builder.of(VoidSpawnEntity::new,
                    EntityClassification.MONSTER).sized(1f, 3f)
                    .build(new ResourceLocation(VoidAscension.MOD_ID, "voidspawn").toString()));

    public static final RegistryObject<EntityType<VoidSpawnEntity>> ELITEVOIDSPAWN =
            ENTITY_TYPES.register("elitevoidspawn",
                    () -> EntityType.Builder.of(VoidSpawnEntity::new,
                                    EntityClassification.MONSTER).sized(1f, 3f)
                            .build(new ResourceLocation(VoidAscension.MOD_ID, "elitevoidspawn").toString()));

    public static final RegistryObject<EntityType<InjectorEntity>> INJECTOR =
            ENTITY_TYPES.register("injector",
                    () -> EntityType.Builder.of(InjectorEntity::new,
                                    EntityClassification.MONSTER).sized(1f, 3f)
                            .build(new ResourceLocation(VoidAscension.MOD_ID, "injector").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
