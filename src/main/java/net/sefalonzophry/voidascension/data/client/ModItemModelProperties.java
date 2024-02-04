package net.sefalonzophry.voidascension.data.client;

import net.minecraft.world.item.*;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;

public class ModItemModelProperties {
    public static void makeBow(Item item) {
        ItemProperties.register(item, new ResourceLocation("pull"), (p_174635_, p_174636_, p_174637_, p_174638_) -> {
            if (p_174637_ == null) {
                return 0.0F;
            } else {
                return p_174637_.getUseItem() != p_174635_ ? 0.0F : (float)(p_174635_.getUseDuration() - p_174637_.getUseItemRemainingTicks()) / 20.0F;
            }
        });

        ItemProperties.register(item, new ResourceLocation("pulling"), (p_272332_, p_272333_, p_272334_, p_272335_) -> {
            return p_272334_ != null && p_272334_.isUsingItem() && p_272334_.getUseItem() == p_272332_ ? 1.0F : 0.0F;
        });
    }
}
