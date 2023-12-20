package mc.craig.software.extra_shells.client.models;

import mc.craig.software.extra_shells.ESModelRegistry;
import mc.craig.software.extra_shells.ESShellRegistry;
import whocraft.tardis_refined.client.model.blockentity.shell.ShellModelCollection;
import whocraft.tardis_refined.common.tardis.themes.ShellTheme;

public class ShellEntryRegistry {

    public static void init(){
        ShellModelCollection.registerShellEntry(ESShellRegistry.ENGINEERS.get(), ESModelRegistry.ENGINEERS_EXT_MODEL, ESModelRegistry.ENGINEERS_INT_MODEL);
        ShellModelCollection.registerShellEntry(ESShellRegistry.ELLEN.get(), ESModelRegistry.ELLEN_EXT_MODEL, ESModelRegistry.ELLEN_INT_MODEL);
        ShellModelCollection.registerShellEntry(ESShellRegistry.SEA_BLUE.get(), ESModelRegistry.TOMMY_EXT_MODEL, ESModelRegistry.TOMMY_INT_MODEL);
        ShellModelCollection.registerShellEntry(ESShellRegistry.MOFFAT_ERA.get(), ESModelRegistry.MOFFAT_EXT_MODEL, ESModelRegistry.MOFFAT_INT_MODEL);
        ShellModelCollection.registerShellEntry(ESShellRegistry.RTD_ERA.get(), ESModelRegistry.RTD_EXT_MODEL, ESModelRegistry.RTD_INT_MODEL);
        ShellModelCollection.registerShellEntry(ESShellRegistry.GLASGOW.get(), ESModelRegistry.GLASGOW_EXT_MODEL, ESModelRegistry.GLASGOW_INT_MODEL);
        ShellModelCollection.registerShellEntry(ESShellRegistry.LEGO.get(), ESModelRegistry.LEGO_IDEAS_EXT_MODEL, ESModelRegistry.LEGO_IDEAS_INT_MODEL);
        ShellModelCollection.registerShellEntry(ESShellRegistry.HUDOLIN.get(), ESModelRegistry.HUDOLIN_EXT_MODEL, ESModelRegistry.HUDOLIN_INT_MODEL);
        ShellModelCollection.registerShellEntry(ESShellRegistry.CHIBNALL_RTD_ERA.get(), ESModelRegistry.CHIBNALL_EXT_MODEL, ESModelRegistry.CHIBNALL_INT_MODEL);
        ShellModelCollection.registerShellEntry(ESShellRegistry.JACK_CUSTOM.get(), ESModelRegistry.JACK_CUSTOM_EXT_MODEL, ESModelRegistry.JACK_CUSTOM_INT_MODEL);
    }
}
