package dev.jeryn.extra_shells.fabric;

import dev.jeryn.extra_shells.ESModelRegistry;
import net.fabricmc.api.ClientModInitializer;

public class ExtraShellsClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ESModelRegistry.init();
    }
}
