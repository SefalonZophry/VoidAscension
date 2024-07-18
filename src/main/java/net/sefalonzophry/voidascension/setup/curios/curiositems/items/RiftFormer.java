package net.sefalonzophry.voidascension.setup.curios.curiositems.items;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.sefalonzophry.voidascension.setup.customeffects.ModDamageSource;
import net.sefalonzophry.voidascension.setup.moditems.ModItems;
import net.sefalonzophry.voidascension.setup.worldgen.dimension.ModDimensions;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class RiftFormer extends Item implements ICurioItem {

    public RiftFormer(Properties pProperties) {
        super(pProperties);

    }
}
