package net.sefalonzophry.voidascension.setup.worldgen.world.entity;

import net.minecraft.world.entity.MobCategory;
import net.sefalonzophry.voidascension.VoidAscension;
import net.sefalonzophry.voidascension.setup.worldgen.world.entity.projectile.VoidArrow;
import net.minecraft.world.entity.EntityType;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityType {

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, VoidAscension.MOD_ID);

    public static final RegistryObject<EntityType<VoidArrow>> VOID_ARROW = ENTITIES.register("void_arrow", () -> EntityType.Builder.<VoidArrow>of(VoidArrow::new, MobCategory.MISC).sized(0.5F,0.5F).clientTrackingRange(4).updateInterval(20).build(new ResourceLocation(VoidAscension.MOD_ID, "void_arrow").toString()));

    public static void register(IEventBus eventbus) {
        ENTITIES.register(eventbus);
    }
}
