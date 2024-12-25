package dev.jeryn.extra_shells.forge.data;

import dev.jeryn.extra_shells.ESShellRegistry;
import dev.jeryn.extra_shells.ESSounds;
import dev.jeryn.extra_shells.ExtraShells;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import whocraft.tardis_refined.common.data.ShellPatternProvider;
import whocraft.tardis_refined.patterns.PatternTexture;
import whocraft.tardis_refined.patterns.ShellPattern;
import whocraft.tardis_refined.patterns.ShellPatterns;
import whocraft.tardis_refined.patterns.sound.ConfiguredSound;
import whocraft.tardis_refined.patterns.sound.ShellSoundProfile;
import whocraft.tardis_refined.patterns.sound.TRShellSoundProfiles;

import java.util.Optional;

public class ESPatterns extends ShellPatternProvider {


    @Override
    protected void addPatterns() {
        quickAdd(ESShellRegistry.MADDOC_WHITTAKER.getId(), "default", false);
        quickAdd(ESShellRegistry.MADDOC_NEWBERRY.getId(), "default", false);
        quickAdd(ESShellRegistry.MADDOC_2005.getId(), "tennant", false);
        quickAdd(ESShellRegistry.MADDOC_2005.getId(), "eccleston", false);

        quickAdd(ESShellRegistry.MADDOC_SMITH.getId(), "default", false);
        quickAdd(ESShellRegistry.MADDOC_BRACHACKI.getId(), "default", false);

        quickAdd(ESShellRegistry.OLD_SCHOOL.getId(), "default", false);

        quickAdd(ESShellRegistry.EMERALD.getId(), "default", true);
        quickAdd(ESShellRegistry.ENGINEERS.getId(), "default", true);
        quickAdd(ESShellRegistry.SEA_BLUE.getId(), "default", true);

        quickAdd(ESShellRegistry.RTD_ERA.getId(), "default", true);
        quickAdd(ESShellRegistry.RTD_ERA.getId(), "tenth", true);
        quickAdd(ESShellRegistry.RTD_ERA.getId(), "bad_wolf", true);
        quickAdd(ESShellRegistry.RTD_ERA.getId(), "overgrown", true);

        quickAdd(ESShellRegistry.MOFFAT_ERA.getId(), "default", true);
        quickAdd(ESShellRegistry.MOFFAT_ERA.getId(), "twelfth", true);

        quickAdd(ESShellRegistry.GLASGOW.getId(), "default", true);

        quickAdd(ESShellRegistry.CHIBNALL_RTD_ERA.getId(), "default", true);
        quickAdd(ESShellRegistry.CHIBNALL_RTD_ERA.getId(), "fourteen", true);

        quickAdd(ESShellRegistry.ANCIENT.getId(), "default", true);
        quickAdd(ESShellRegistry.ANCIENT.getId(), "damaged", true);

        quickAdd(ESShellRegistry.LEGO.getId(), "default", true);
        quickAdd(ESShellRegistry.LEGO.getId(), "piece", true);
        quickAdd(ESShellRegistry.LEGO.getId(), "dimensions", true);

        ShellSoundProfile soundProfile = new ShellSoundProfile();
        soundProfile.setDoorClose(new ConfiguredSound(ESSounds.DELOREAN_CLOSED.get()));
        soundProfile.setDoorOpen(new ConfiguredSound(ESSounds.DELOREAN_OPEN.get()));
        soundProfile.setDoorLocked(new ConfiguredSound(ESSounds.DELOREAN_LOCKED.get()));

        quickAdd(ESShellRegistry.DELOREAN.getId(), "default", true, soundProfile);
        quickAdd(ESShellRegistry.DELOREAN.getId(), "future", true, soundProfile);

      /*  quickAdd(ESShellRegistry.HUDOLIN.getId(), "default", true);
        quickAdd(ESShellRegistry.HUDOLIN.getId(), "edwardian_worn", true);
        quickAdd(ESShellRegistry.HUDOLIN.getId(), "edwardian_alt", true);
        quickAdd(ESShellRegistry.HUDOLIN.getId(), "eight", true);*/

    }

    public void quickAdd(ResourceLocation themeId, String patternName, boolean hasEmissiveTexture) {
        addPattern(themeId, createPattern(themeId, patternName, hasEmissiveTexture));
    }

    public void quickAdd(ResourceLocation themeId, String patternName, boolean hasEmissiveTexture, ShellSoundProfile soundProfile) {
        addPattern(themeId, createPattern(themeId, patternName, hasEmissiveTexture, soundProfile));
    }


    public ShellPattern createPattern(ResourceLocation themeId, String patternName, boolean hasEmissiveTexture) {
        ResourceLocation exteriorTextureLocation = ShellPatterns.exteriorTextureLocation(themeId, ExtraShells.MODID, patternName);
        ResourceLocation interiorTextureLocation = ShellPatterns.interiorTextureLocation(themeId, ExtraShells.MODID, patternName);
        ShellSoundProfile soundProfile = TRShellSoundProfiles.defaultSoundProfilesByTheme().getOrDefault(themeId, TRShellSoundProfiles.DEFAULT_SOUND_PROFILE);
        ShellPattern pattern = new ShellPattern(new ResourceLocation(themeId.getNamespace(), patternName), new PatternTexture(exteriorTextureLocation, hasEmissiveTexture), new PatternTexture(interiorTextureLocation, hasEmissiveTexture), Optional.of(soundProfile));
        pattern.setThemeId(themeId);

        return ShellPatterns.addDefaultPattern(themeId, pattern);
    }

    public ShellPattern createPattern(ResourceLocation themeId, String patternName, boolean hasEmissiveTexture, ShellSoundProfile soundProfile) {
        ResourceLocation exteriorTextureLocation = ShellPatterns.exteriorTextureLocation(themeId, ExtraShells.MODID, patternName);
        ResourceLocation interiorTextureLocation = ShellPatterns.interiorTextureLocation(themeId, ExtraShells.MODID, patternName);;
        ShellPattern pattern = new ShellPattern(new ResourceLocation(themeId.getNamespace(), patternName), new PatternTexture(exteriorTextureLocation, hasEmissiveTexture), new PatternTexture(interiorTextureLocation, hasEmissiveTexture), Optional.of(soundProfile));
        pattern.setThemeId(themeId);

        return ShellPatterns.addDefaultPattern(themeId, pattern);
    }

    public ESPatterns(DataGenerator generator) {
        super(generator, ExtraShells.MODID, false);
    }

    @Override
    public String getName() {
        return "ExtraShells Patterns";
    }


}
