package dev.jeryn.extra_shells;

import net.minecraft.resources.ResourceLocation;
import whocraft.tardis_refined.common.tardis.themes.ShellTheme;
import whocraft.tardis_refined.registry.DeferredRegistry;
import whocraft.tardis_refined.registry.RegistrySupplier;
import whocraft.tardis_refined.registry.RegistrySupplier;

import static whocraft.tardis_refined.patterns.ShellPatterns.interiorTextureLocation;

public class ESShellRegistry {

    public static final DeferredRegistry<ShellTheme> SHELL_THEMES = DeferredRegistry.create(ExtraShells.MODID, ShellTheme.SHELL_THEME_REGISTRY_KEY);

    public static final RegistrySupplier<ShellTheme> ENGINEERS = registerShellTheme("engineers");
    public static final RegistrySupplier<ShellTheme> SEA_BLUE = registerShellTheme("sea_blue");
    public static final RegistrySupplier<ShellTheme> MOFFAT_ERA = registerShellTheme("moffat_era");
    public static final RegistrySupplier<ShellTheme> RTD_ERA = registerShellTheme("rtd_era");
    public static final RegistrySupplier<ShellTheme> GLASGOW = registerShellTheme("glasgow");
    public static final RegistrySupplier<ShellTheme> LEGO = registerShellTheme("lego");
    public static final RegistrySupplier<ShellTheme> CHIBNALL_RTD_ERA = registerShellTheme("chibnall_rtd_era");
    public static final RegistrySupplier<ShellTheme> ANCIENT = registerShellTheme("ancient");
    public static final RegistrySupplier<ShellTheme> EMERALD = registerShellTheme("emerald");
    public static final RegistrySupplier<ShellTheme> OLD_SCHOOL = registerShellTheme("old_school");
    public static final RegistrySupplier<ShellTheme> MADDOC_WHITTAKER = registerShellTheme("maddoc_whittaker");
    public static final RegistrySupplier<ShellTheme> MADDOC_NEWBERRY = registerShellTheme("maddoc_newberry");
    public static final RegistrySupplier<ShellTheme> MADDOC_2005 = registerShellTheme("maddoc_2005");

    public static final RegistrySupplier<ShellTheme> MADDOC_SMITH = registerShellTheme("maddoc_smith");
    public static final RegistrySupplier<ShellTheme> MADDOC_BRACHACKI = registerShellTheme("maddoc_brachacki");
    public static final RegistrySupplier<ShellTheme> DELOREAN = registerShellTheme("delorean");


    private static RegistrySupplier<ShellTheme> registerShellTheme(String id) {
        return SHELL_THEMES.register(id, () -> new ShellTheme(new ResourceLocation(ExtraShells.MODID, id)));
    }



}
