package net.sefalonzophry.voidascension.proxy;


import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;

public class ClientProxy extends CommonProxy {

    @Override
    public void commonSetup(FMLCommonSetupEvent event) {
        super.commonSetup(event);
    }

    @Override
    public void clientSetup(FMLClientSetupEvent event) {
        super.clientSetup(event);
    }

    @Override
    public void serverSetup(FMLDedicatedServerSetupEvent event) {
        super.serverSetup(event);
    }
}
