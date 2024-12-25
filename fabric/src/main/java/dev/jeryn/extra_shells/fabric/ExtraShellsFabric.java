package dev.jeryn.extra_shells.fabric;

import dev.jeryn.extra_shells.ExtraShells;
import net.fabricmc.api.ModInitializer;

public class ExtraShellsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ExtraShells.init();
    }
}