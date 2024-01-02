package mc.craig.software.extra_shells.forge.data;

import mc.craig.software.extra_shells.ESShellRegistry;
import mc.craig.software.extra_shells.ExtraShells;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import whocraft.tardis_refined.common.data.ShellPatternProvider;
import whocraft.tardis_refined.patterns.PatternTexture;
import whocraft.tardis_refined.patterns.ShellPattern;
import whocraft.tardis_refined.patterns.ShellPatterns;

public class TEPatterns extends ShellPatternProvider {


    @Override
    protected void addPatterns() {
        quickAdd(ESShellRegistry.ELLEN.getId(), "ellen", true);
        quickAdd(ESShellRegistry.ENGINEERS.getId(), "engineers", true);
        quickAdd(ESShellRegistry.SEA_BLUE.getId(), "sea_blue", true);

        quickAdd(ESShellRegistry.RTD_ERA.getId(), "rtd_era", true);
        quickAdd(ESShellRegistry.RTD_ERA.getId(), "tenth", true);
        quickAdd(ESShellRegistry.RTD_ERA.getId(), "bad_wolf", true);
        quickAdd(ESShellRegistry.RTD_ERA.getId(), "jack", true);

        quickAdd(ESShellRegistry.MOFFAT_ERA.getId(), "moffat_era", true);
        quickAdd(ESShellRegistry.MOFFAT_ERA.getId(), "twelfth", true);

        quickAdd(ESShellRegistry.GLASGOW.getId(), "glasgow", true);

        quickAdd(ESShellRegistry.CHIBNALL_RTD_ERA.getId(), "chibnall_rtd_era", true);
        quickAdd(ESShellRegistry.CHIBNALL_RTD_ERA.getId(), "fourteen", true);

        quickAdd(ESShellRegistry.JACK_CUSTOM.getId(), "jack_custom", true);
        quickAdd(ESShellRegistry.JACK_CUSTOM.getId(), "damaged", true);

        quickAdd(ESShellRegistry.LEGO.getId(), "lego", true);

        quickAdd(ESShellRegistry.HUDOLIN.getId(), "edwardian", true);
        quickAdd(ESShellRegistry.HUDOLIN.getId(), "edwardian_worn", true);
        quickAdd(ESShellRegistry.HUDOLIN.getId(), "edwardian_alt", true);
        quickAdd(ESShellRegistry.HUDOLIN.getId(), "eight", true);


        quickAdd(ESShellRegistry.TRIGHT_JODIE.getId(), "jodie", false);
    }

    public void quickAdd(ResourceLocation themeId, String patternName, boolean hasEmissiveTexture) {
        addPattern(themeId, createPattern(themeId, patternName, hasEmissiveTexture));
    }


    public static ShellPattern createPattern(ResourceLocation themeId, String patternName, boolean hasEmissiveTexture) {
        ResourceLocation exteriorTextureLocation = ShellPatterns.exteriorTextureLocation(themeId, ExtraShells.MODID, patternName);
        ResourceLocation interiorTextureLocation = ShellPatterns.interiorTextureLocation(themeId, ExtraShells.MODID, patternName);

        ShellPattern shellPattern = new ShellPattern(new ResourceLocation(ExtraShells.MODID, patternName), new PatternTexture(exteriorTextureLocation, hasEmissiveTexture), new PatternTexture(interiorTextureLocation, hasEmissiveTexture));
        shellPattern.setThemeId(themeId);

        return ShellPatterns.addDefaultPattern(themeId, shellPattern);
    }

    public TEPatterns(DataGenerator generator) {
        super(generator, ExtraShells.MODID, false);
    }

    @Override
    public String getName() {
        return "ExtraShells Patterns";
    }


}
