package dev.jeryn.extra_shells;

public class ExtraShells {
	public static final String MODID = "extra_shells";

	public static void init() {
		ESShellRegistry.SHELL_THEMES.registerToModBus();
		ExtraShellAPIEvents.init();
		ESSounds.SOUNDS.registerToModBus();
	}
}
