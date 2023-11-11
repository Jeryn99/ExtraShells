package mc.craig.software.extra_shells.forge.data;

import mc.craig.software.extra_shells.ExtraShells;
import mc.craig.software.extra_shells.TEShellThemes;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;
import whocraft.tardis_refined.common.tardis.themes.ShellTheme;

public class ESEnglish extends LanguageProvider {

    public ESEnglish(DataGenerator gen) {
        super(gen, ExtraShells.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        addShell(TEShellThemes.ELLEN, "Ellen");
        addShell(TEShellThemes.ENGINEERS, "Engineers");
        addShell(TEShellThemes.SEA_BLUE, "Sea Blue");
        addShell(TEShellThemes.MOFFAT, "Moffat");
        addShell(TEShellThemes.RTD, "RTD");
    }

    public void addShell(ShellTheme theme, String name) {
        this.add(theme.getTranslationKey(), name);
    }
}
