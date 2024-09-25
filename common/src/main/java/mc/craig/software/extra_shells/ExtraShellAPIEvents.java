package mc.craig.software.extra_shells;


import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import whocraft.tardis_refined.api.event.TardisClientEvents;
import whocraft.tardis_refined.common.util.Platform;

public class ExtraShellAPIEvents {

    public static void init(){
        if(Platform.isClient()) {
            setupEventas();
        }
    }

    @Environment(EnvType.CLIENT)
    private static void setupEventas() {
        TardisClientEvents.SHELLENTRY_MODELS_SETUP.register(ESModelRegistry::setupModelInstances);
    }

}



