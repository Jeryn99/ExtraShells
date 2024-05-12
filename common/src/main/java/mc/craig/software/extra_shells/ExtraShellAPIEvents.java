package mc.craig.software.extra_shells;


import whocraft.tardis_refined.api.event.TardisClientEvents;

public class ExtraShellAPIEvents {

    public static void init(){
        TardisClientEvents.SHELLENTRY_MODELS_SETUP.register(ESModelRegistry::setupModelInstances);
    }

}



