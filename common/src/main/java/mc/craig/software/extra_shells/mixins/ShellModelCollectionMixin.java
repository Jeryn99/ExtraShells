package mc.craig.software.extra_shells.mixins;

import mc.craig.software.extra_shells.ESModelRegistry;
import mc.craig.software.extra_shells.client.models.tommy.EllenShellModel;
import mc.craig.software.extra_shells.client.models.tommy.EngineersShellModel;
import mc.craig.software.extra_shells.client.models.tommy.SeaBlueShellModel;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import whocraft.tardis_refined.client.model.blockentity.shell.ShellModel;
import whocraft.tardis_refined.client.model.blockentity.shell.ShellModelCollection;
import whocraft.tardis_refined.common.tardis.themes.ShellTheme;

@Mixin(ShellModelCollection.class)
public class ShellModelCollectionMixin {

    @Inject(cancellable = true, method = "getShellModel(Lwhocraft/tardis_refined/common/tardis/themes/ShellTheme;)Lwhocraft/tardis_refined/client/model/blockentity/shell/ShellModel;", at = @At("HEAD"), remap = false)
    public void getShellModel(ShellTheme theme, CallbackInfoReturnable<ShellModel> cir) {
        if (theme.name().contains("SEA_BLUE")) {

            if (ESModelRegistry.TOMMY_EXT_MODEL == null) {
                ESModelRegistry.TOMMY_EXT_MODEL = new SeaBlueShellModel(Minecraft.getInstance().getEntityModels().bakeLayer(ESModelRegistry.TOMMY_EXT));
            }
            cir.setReturnValue(ESModelRegistry.TOMMY_EXT_MODEL);
        }

        if (theme.name().contains("ENGINEERS")) {

            if (ESModelRegistry.ENGINEERS_EXT_MODEL == null) {
                ESModelRegistry.ENGINEERS_EXT_MODEL = new EngineersShellModel(Minecraft.getInstance().getEntityModels().bakeLayer(ESModelRegistry.ENGINEERS_EXT));
            }
            cir.setReturnValue(ESModelRegistry.ENGINEERS_EXT_MODEL);
        }

        if (theme.name().contains("ELLEN")) {

            if (ESModelRegistry.ELLEN_EXT_MODEL == null) {
                ESModelRegistry.ELLEN_EXT_MODEL = new EllenShellModel(Minecraft.getInstance().getEntityModels().bakeLayer(ESModelRegistry.ELLEN_EXT));
            }
            cir.setReturnValue(ESModelRegistry.ELLEN_EXT_MODEL);
        }

    }
}
