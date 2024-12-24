package dev.jeryn.extra_shells.neoforge.data;

import dev.jeryn.extra_shells.ESShellRegistry;
import dev.jeryn.extra_shells.ExtraShells;
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
        addShell(ESShellRegistry.MOFFAT_ERA.get(), "Moffat Era");
        addShell(ESShellRegistry.RTD_ERA.get(), "RTD Era");
        addShell(ESShellRegistry.CHIBNALL_RTD_ERA.get(), "Chibnall/RTD2");
        addShell(ESShellRegistry.GLASGOW.get(), "Glasgow");
        addShell(ESShellRegistry.ANCIENT.get(), "Ancient");
        addShell(ESShellRegistry.LEGO.get(), "Lego");
        addShell(ESShellRegistry.OLD_SCHOOL.get(), "Old School");

        addShell(ESShellRegistry.MADDOC_SMITH.get(), "(Maddoc) Smith");
        addShell(ESShellRegistry.MADDOC_2005.get(), "(Maddoc) Tennant");
        addShell(ESShellRegistry.MADDOC_WHITTAKER.get(), "(Maddoc) Whittaker");
        addShell(ESShellRegistry.MADDOC_BRACHACKI.get(), "(Maddoc) Brachaki");
        addShell(ESShellRegistry.MADDOC_NEWBERRY.get(), "(Maddoc) Newberry");
        addShell(ESShellRegistry.DELOREAN.get(), "Delorean");
    }

    public void addShell(ShellTheme theme, String name) {
        this.add(theme.getTranslationKey(), name);
    }
}
