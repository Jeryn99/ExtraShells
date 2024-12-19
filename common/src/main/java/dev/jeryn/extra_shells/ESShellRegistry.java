package dev.jeryn.extra_shells;

import net.minecraft.resources.ResourceLocation;
import whocraft.tardis_refined.common.tardis.themes.ShellTheme;
import whocraft.tardis_refined.registry.DeferredRegistry;
import whocraft.tardis_refined.registry.RegistrySupplierHolder;

import static whocraft.tardis_refined.patterns.ShellPatterns.interiorTextureLocation;

public class ESShellRegistry {

    public static final DeferredRegistry<ShellTheme> SHELL_THEMES = DeferredRegistry.create(ExtraShells.MODID, ShellTheme.SHELL_THEME_REGISTRY_KEY);

    public static final RegistrySupplierHolder<ShellTheme, ShellTheme> ENGINEERS = registerShellTheme("engineers");
    public static final RegistrySupplierHolder<ShellTheme, ShellTheme> SEA_BLUE = registerShellTheme("sea_blue");
    public static final RegistrySupplierHolder<ShellTheme, ShellTheme> MOFFAT_ERA = registerShellTheme("moffat_era");
    public static final RegistrySupplierHolder<ShellTheme, ShellTheme> RTD_ERA = registerShellTheme("rtd_era");
    public static final RegistrySupplierHolder<ShellTheme, ShellTheme> GLASGOW = registerShellTheme("glasgow");
    public static final RegistrySupplierHolder<ShellTheme, ShellTheme> LEGO = registerShellTheme("lego");
    //public static final RegistrySupplierHolder<ShellTheme, ShellTheme> HUDOLIN = registerShellTheme("hudolin");
    public static final RegistrySupplierHolder<ShellTheme, ShellTheme> CHIBNALL_RTD_ERA = registerShellTheme("chibnall_rtd_era");
    public static final RegistrySupplierHolder<ShellTheme, ShellTheme> ANCIENT = registerShellTheme("ancient");
    public static final RegistrySupplierHolder<ShellTheme, ShellTheme> EMERALD = registerShellTheme("emerald");
    public static final RegistrySupplierHolder<ShellTheme, ShellTheme> OLD_SCHOOL = registerShellTheme("old_school");
    public static final RegistrySupplierHolder<ShellTheme, ShellTheme> MADDOC_WHITTAKER = registerShellTheme("maddoc_whittaker");
    public static final RegistrySupplierHolder<ShellTheme, ShellTheme> MADDOC_NEWBERRY = registerShellTheme("maddoc_newberry");
    public static final RegistrySupplierHolder<ShellTheme, ShellTheme> MADDOC_2005 = registerShellTheme("maddoc_2005");

    public static final RegistrySupplierHolder<ShellTheme, ShellTheme> MADDOC_SMITH = registerShellTheme("maddoc_smith");
    public static final RegistrySupplierHolder<ShellTheme, ShellTheme> MADDOC_BRACHACKI = registerShellTheme("maddoc_brachacki");


    private static RegistrySupplierHolder<ShellTheme, ShellTheme> registerShellTheme(String id) {
        return SHELL_THEMES.registerHolder(id, () -> new ShellTheme(new ResourceLocation(ExtraShells.MODID, id)));
    }



}
