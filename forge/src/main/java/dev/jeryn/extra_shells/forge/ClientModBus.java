package dev.jeryn.extra_shells.forge;

import dev.jeryn.extra_shells.ESModelRegistry;
import dev.jeryn.extra_shells.ExtraShells;
import dev.jeryn.extra_shells.forge.ESModelRegistryImpl;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ExtraShells.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModBus {

    @SubscribeEvent
    public static void event(EntityRenderersEvent.RegisterLayerDefinitions event) {
        ESModelRegistry.init();
        ESModelRegistryImpl.register(event);
    }

}