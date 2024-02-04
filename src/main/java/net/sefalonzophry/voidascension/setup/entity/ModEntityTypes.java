package net.sefalonzophry.voidascension.setup.entity;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sefalonzophry.voidascension.VoidAscension;
import net.sefalonzophry.voidascension.setup.entity.custom.InjectorEntity;
import net.sefalonzophry.voidascension.setup.entity.custom.VoidSpawnEntity;

public class ModEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES
            = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, VoidAscension.MOD_ID);

    public static final RegistryObject<EntityType<VoidSpawnEntity>> VOIDSPAWN =
            ENTITY_TYPES.register("voidspawn",
                    () -> EntityType.Builder.of(VoidSpawnEntity::new,
                                    MobCategory.MONSTER).sized(1f, 3f)
                    .build(new ResourceLocation(VoidAscension.MOD_ID, "voidspawn").toString()));

    public static final RegistryObject<EntityType<VoidSpawnEntity>> ELITEVOIDSPAWN =
            ENTITY_TYPES.register("elitevoidspawn",
                    () -> EntityType.Builder.of(VoidSpawnEntity::new,
                                    MobCategory.MONSTER).sized(1f, 3f)
                            .build(new ResourceLocation(VoidAscension.MOD_ID, "elitevoidspawn").toString()));

    public static final RegistryObject<EntityType<InjectorEntity>> INJECTOR =
            ENTITY_TYPES.register("injector",
                    () -> EntityType.Builder.of(InjectorEntity::new,
                                    MobCategory.MONSTER).sized(1f, 3f)
                            .build(new ResourceLocation(VoidAscension.MOD_ID, "injector").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
