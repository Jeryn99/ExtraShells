package dev.jeryn.extra_shells.client.models;

import dev.jeryn.extra_shells.ESModelRegistry;
import dev.jeryn.extra_shells.ESShellRegistry;
import dev.jeryn.extra_shells.custom_entries.LegoShellEntry;
import dev.jeryn.extra_shells.custom_entries.RTDChibnallShellEntry;
import whocraft.tardis_refined.client.model.blockentity.shell.ShellModelCollection;

public class ShellEntryRegistry {

    public static void init(){
        ShellModelCollection.registerShellEntry(ESShellRegistry.ENGINEERS.get(), ESModelRegistry.ENGINEERS_EXT_MDL, ESModelRegistry.ENGINEERS_INT_MDL);
        ShellModelCollection.registerShellEntry(ESShellRegistry.EMERALD.get(), ESModelRegistry.ELLEN_EXT_MDL, ESModelRegistry.ELLEN_INT_MDL);
        ShellModelCollection.registerShellEntry(ESShellRegistry.SEA_BLUE.get(), ESModelRegistry.TOMMY_EXT_MDL, ESModelRegistry.TOMMY_INT_MDL);
        ShellModelCollection.registerShellEntry(ESShellRegistry.MOFFAT_ERA.get(), ESModelRegistry.MOFFAT_EXT_MDL, ESModelRegistry.MOFFAT_INT_MDL);
        ShellModelCollection.registerShellEntry(ESShellRegistry.OLD_SCHOOL.get(), ESModelRegistry.OLDSCHOOL_EXT_MDL, ESModelRegistry.OLDSCHOOL_INT_MDL);

        ShellModelCollection.registerShellEntry(ESShellRegistry.RTD_ERA.get(), ESModelRegistry.RTD_EXT_MDL, ESModelRegistry.RTD_INT_MDL);
        ShellModelCollection.registerShellEntry(ESShellRegistry.GLASGOW.get(), ESModelRegistry.GLASGOW_EXT_MDL, ESModelRegistry.GLASGOW_INT_MDL);
        ShellModelCollection.registerShellEntry(ESShellRegistry.LEGO.get(), new LegoShellEntry(ESModelRegistry.LEGO_IDEAS_EXT_MDL, ESModelRegistry.LEGO_IDEAS_INT_MDL));
        ShellModelCollection.registerShellEntry(ESShellRegistry.CHIBNALL_RTD_ERA.get(), new RTDChibnallShellEntry(ESModelRegistry.CHIBNALL_EXT_MDL, ESModelRegistry.CHIBNALL_INT_MDL));
        ShellModelCollection.registerShellEntry(ESShellRegistry.ANCIENT.get(), ESModelRegistry.JACK_CUSTOM_EXT_MDL, ESModelRegistry.JACK_CUSTOM_INT_MDL);


        ShellModelCollection.registerShellEntry(ESShellRegistry.MADDOC_SMITH.get(), ESModelRegistry.MADDOC_SMITHEXT_MDL, ESModelRegistry.MADDOC_SMITHINT_MDL);
        ShellModelCollection.registerShellEntry(ESShellRegistry.MADDOC_2005.get(), ESModelRegistry.MADDOC_TENNANTEXT_MDL, ESModelRegistry.MADDOC_TENNANTINT_MDL);
        ShellModelCollection.registerShellEntry(ESShellRegistry.MADDOC_WHITTAKER.get(), ESModelRegistry.MADDOC_WHITTAKEREXT_MDL, ESModelRegistry.MADDOC_WHITTAKERINT_MDL);
        ShellModelCollection.registerShellEntry(ESShellRegistry.MADDOC_BRACHACKI.get(), ESModelRegistry.MADDOC_BRACHACKIEXT_MDL, ESModelRegistry.MADDOC_BRACHACKIINT_MDL);
        ShellModelCollection.registerShellEntry(ESShellRegistry.MADDOC_NEWBERRY.get(), ESModelRegistry.MADDOC_NEWBERRYEXT_MDL, ESModelRegistry.MADDOC_NEWBERRYINT_MDL);



    }
}
