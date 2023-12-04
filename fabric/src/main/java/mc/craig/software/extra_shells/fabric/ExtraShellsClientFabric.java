package mc.craig.software.extra_shells.fabric;

import mc.craig.software.extra_shells.ESModelRegistry;
import net.fabricmc.api.ClientModInitializer;

public class ExtraShellsClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ESModelRegistry.init();
    }
}
