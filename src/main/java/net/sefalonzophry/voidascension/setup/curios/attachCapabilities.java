/*
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.CuriosCapability;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurio;

@SubscribeEvent
public void attachCapabilities(AttachCapabilitiesEvent<ItemStack> evt) {
    ItemStack stack = evt.getObject();
    Item item = stack.getItem();
    evt.addCapability(CuriosCapability.ID_ITEM, CuriosApi.createCurioProvider(new ICurio() {

        @Override
        public ItemStack getStack() {
            return stack;
        }

        @Override
        public void curioTick(SlotContext slotContext) {
            // ticking logic here
        }
    }));
}

public void main() {
}
*/