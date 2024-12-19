package dev.jeryn.extra_shells.neoforge;

import dev.jeryn.extra_shells.ESModelRegistry;
import dev.jeryn.extra_shells.ExtraShells;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@Mod.EventBusSubscriber(modid = ExtraShells.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModBus {

    @SubscribeEvent
    public static void event(EntityRenderersEvent.RegisterLayerDefinitions event) {
        ESModelRegistry.init();
        ESModelRegistryImpl.register(event);
    }

}