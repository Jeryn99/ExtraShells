package dev.jeryn.extra_shells.forge;

import dev.jeryn.extra_shells.ESModelRegistry;
import dev.jeryn.extra_shells.ExtraShells;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import whocraft.tardis_refined.api.event.TardisClientEvents;

@Mod.EventBusSubscriber(modid = ExtraShells.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModBus {

    @SubscribeEvent
    public static void event(EntityRenderersEvent.RegisterLayerDefinitions event) {
        ESModelRegistryImpl.register(event);
    }

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        TardisClientEvents.SHELLENTRY_MODELS_SETUP.register(ESModelRegistry::setupModelInstances);
    }

}