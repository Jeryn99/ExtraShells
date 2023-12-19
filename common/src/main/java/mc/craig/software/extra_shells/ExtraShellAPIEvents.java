package mc.craig.software.extra_shells;

import whocraft.tardis_refined.api.event.TardisEvents;

public class ExtraShellAPIEvents {

    public static void init(){
        TardisEvents.SHELLENTRY_MODELS_SETUP.register(ESModelRegistry::setupModelInstances);
    }

}



