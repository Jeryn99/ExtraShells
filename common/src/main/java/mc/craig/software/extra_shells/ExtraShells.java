package mc.craig.software.extra_shells;

public class ExtraShells {
	public static final String MODID = "extra_shells";

	public static void init() {
		ESShellRegistry.SHELL_THEMES.register();
		ExtraShellAPIEvents.init();
	}
}
