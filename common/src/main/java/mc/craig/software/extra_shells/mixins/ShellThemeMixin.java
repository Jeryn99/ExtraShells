package mc.craig.software.extra_shells.mixins;

import mc.craig.software.extra_shells.TEShellThemes;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import whocraft.tardis_refined.common.tardis.themes.ShellTheme;

import java.util.ArrayList;
import java.util.Arrays;

@Mixin(ShellTheme.class)
public class ShellThemeMixin {
    @Shadow
    @Final
    @Mutable
    private static ShellTheme[] $VALUES;

    @Invoker(value = "<init>")
    private static ShellTheme create(String name, int ordinal, String directoryName) {
        throw new IllegalStateException("Unreachable");
    }

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void classInit(CallbackInfo cb) {
        var teacup = create("ENGINEERS", $VALUES.length, "engineers");
        var tommy_bricks = create("SEA_BLUE", $VALUES.length, "sea_blue");
        var ellen = create("ELLEN", $VALUES.length, "ellen");
        var moffat = create("MOFFAT", $VALUES.length, "moffat");
        var rtd = create("RTD", $VALUES.length, "rtd");

        TEShellThemes.SEA_BLUE = tommy_bricks;
        TEShellThemes.ENGINEERS = teacup;
        TEShellThemes.ELLEN = ellen;
        TEShellThemes.MOFFAT = moffat;
        TEShellThemes.RTD = rtd;

        ArrayList<ShellTheme> arrayList = new ArrayList(Arrays.asList($VALUES));
        arrayList.add(teacup);
        arrayList.add(tommy_bricks);
        arrayList.add(ellen);
        arrayList.add(moffat);
        arrayList.add(rtd);

        $VALUES = arrayList.toArray(new ShellTheme[0]);
    }
}
