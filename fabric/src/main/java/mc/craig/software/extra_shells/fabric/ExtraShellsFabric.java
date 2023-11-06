package mc.craig.software.extra_shells.fabric;

import mc.craig.software.extra_shells.ExtraShells;
import net.fabricmc.api.ModInitializer;

public class ExtraShellsFabric implements ModInitializer {
    @Override
    public void onInitialize() {



        ExtraShells.init();
    }
}