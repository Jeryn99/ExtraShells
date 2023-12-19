package mc.craig.software.extra_shells.forge.data;

import mc.craig.software.extra_shells.ESShellRegistry;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import whocraft.tardis_refined.common.data.ShellPatternProvider;
import whocraft.tardis_refined.patterns.ShellPattern;
import whocraft.tardis_refined.patterns.ShellPatterns;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class TEPatterns extends ShellPatternProvider {


    @Override
    protected void addPatterns() {
        super.addPatterns();
        ESShellRegistry.addDefaultPattern(ESShellRegistry.ELLEN.getId(), "default", true);
        ESShellRegistry.addDefaultPattern(ESShellRegistry.ENGINEERS.getId(), "default", true);
        ESShellRegistry.addDefaultPattern(ESShellRegistry.SEA_BLUE.getId(), "default", true);
        ESShellRegistry.addDefaultPattern(ESShellRegistry.RTD_ERA.getId(), "default", true);
        ESShellRegistry.addDefaultPattern(ESShellRegistry.RTD_ERA.getId(), "tenth", true);
        ESShellRegistry.addDefaultPattern(ESShellRegistry.RTD_ERA.getId(), "bad_wolf", true);
        ESShellRegistry.addDefaultPattern(ESShellRegistry.RTD_ERA.getId(), "jack", true);

        ESShellRegistry.addDefaultPattern(ESShellRegistry.MOFFAT_ERA.getId(), "default", true);
        ESShellRegistry.addDefaultPattern(ESShellRegistry.MOFFAT_ERA.getId(), "twelfth", true);

        ESShellRegistry.addDefaultPattern(ESShellRegistry.GLASGOW.getId(), "default", true);

        ESShellRegistry.addDefaultPattern(ESShellRegistry.CHIBNALL_RTD_ERA.getId(), "default", true);
        ESShellRegistry.addDefaultPattern(ESShellRegistry.CHIBNALL_RTD_ERA.getId(), "fourteen", true);

        ESShellRegistry.addDefaultPattern(ESShellRegistry.JACK_CUSTOM.getId(), "default", true);
        ESShellRegistry.addDefaultPattern(ESShellRegistry.JACK_CUSTOM.getId(), "damaged", true);

        ESShellRegistry.addDefaultPattern(ESShellRegistry.LEGO.getId(), "default", true);

        ESShellRegistry.addDefaultPattern(ESShellRegistry.HUDOLIN.getId(), "edwardian", true);
        ESShellRegistry.addDefaultPattern(ESShellRegistry.HUDOLIN.getId(), "edwardian_worn", true);
        ESShellRegistry.addDefaultPattern(ESShellRegistry.HUDOLIN.getId(), "edwardian_alt", true);
        ESShellRegistry.addDefaultPattern(ESShellRegistry.HUDOLIN.getId(), "eight", true);
    }

    public TEPatterns(DataGenerator generator) {
        super(generator);
    }

    @Override
    public String getName() {
        return "ExtraShells Patterns";
    }


}
