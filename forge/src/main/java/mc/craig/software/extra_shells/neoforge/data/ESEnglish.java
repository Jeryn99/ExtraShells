package mc.craig.software.extra_shells.neoforge.data;

import mc.craig.software.extra_shells.ESShellRegistry;
import mc.craig.software.extra_shells.ExtraShells;
import net.minecraft.data.DataGenerator;
import net.neoforged.neoforge.common.data.LanguageProvider;
import whocraft.tardis_refined.common.tardis.themes.ShellTheme;

public class ESEnglish extends LanguageProvider {

    public ESEnglish(DataGenerator gen) {
        super(gen.getPackOutput(), ExtraShells.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        addShell(ESShellRegistry.EMERALD.get(), "Emerald");
        addShell(ESShellRegistry.ENGINEERS.get(), "Engineers");
        addShell(ESShellRegistry.SEA_BLUE.get(), "Sea Blue");
        addShell(ESShellRegistry.MOFFAT_ERA.get(), "Moffat");
        addShell(ESShellRegistry.RTD_ERA.get(), "RTD");
        addShell(ESShellRegistry.CHIBNALL_RTD_ERA.get(), "Chibnall/RTD2");
        addShell(ESShellRegistry.GLASGOW.get(), "Glasgow");
        addShell(ESShellRegistry.ANCIENT.get(), "Ancient");
        addShell(ESShellRegistry.LEGO.get(), "Lego");
        addShell(ESShellRegistry.OLD_SCHOOL.get(), "Old School");
      //  addShell(ESShellRegistry.HUDOLIN.get(), "Hudolin");
    }

    public void addShell(ShellTheme theme, String name) {
        this.add(theme.getTranslationKey(), name);
    }
}
