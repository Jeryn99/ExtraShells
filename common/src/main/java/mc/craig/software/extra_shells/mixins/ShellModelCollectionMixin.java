package mc.craig.software.extra_shells.mixins;

import mc.craig.software.extra_shells.ESModelRegistry;
import mc.craig.software.extra_shells.TEShellThemes;
import mc.craig.software.extra_shells.client.models.tommy.*;
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
        if (theme == TEShellThemes.SEA_BLUE) {

            if (ESModelRegistry.TOMMY_EXT_MODEL == null) {
                ESModelRegistry.TOMMY_EXT_MODEL = new SeaBlueShellModel(Minecraft.getInstance().getEntityModels().bakeLayer(ESModelRegistry.TOMMY_EXT));
            }
            cir.setReturnValue(ESModelRegistry.TOMMY_EXT_MODEL);
        }

        if (theme == TEShellThemes.ENGINEERS) {

            if (ESModelRegistry.ENGINEERS_EXT_MODEL == null) {
                ESModelRegistry.ENGINEERS_EXT_MODEL = new EngineersShellModel(Minecraft.getInstance().getEntityModels().bakeLayer(ESModelRegistry.ENGINEERS_EXT));
            }
            cir.setReturnValue(ESModelRegistry.ENGINEERS_EXT_MODEL);
        }

        if (theme == TEShellThemes.ELLEN) {

            if (ESModelRegistry.ELLEN_EXT_MODEL == null) {
                ESModelRegistry.ELLEN_EXT_MODEL = new EllenShellModel(Minecraft.getInstance().getEntityModels().bakeLayer(ESModelRegistry.ELLEN_EXT));
            }
            cir.setReturnValue(ESModelRegistry.ELLEN_EXT_MODEL);
        }

        if (theme == TEShellThemes.MOFFAT) {

            if (ESModelRegistry.MOFFAT_EXT_MODEL == null) {
                ESModelRegistry.MOFFAT_EXT_MODEL = new MoffatShellModel(Minecraft.getInstance().getEntityModels().bakeLayer(ESModelRegistry.MOFFAT_EXT));
            }
            cir.setReturnValue(ESModelRegistry.MOFFAT_EXT_MODEL);
        }

        if (theme == TEShellThemes.RTD) {

            if (ESModelRegistry.RTD_EXT_MODEL == null) {
                ESModelRegistry.RTD_EXT_MODEL = new RTDShellModel(Minecraft.getInstance().getEntityModels().bakeLayer(ESModelRegistry.RTD_EXT));
            }
            cir.setReturnValue(ESModelRegistry.RTD_EXT_MODEL);
        }

    }
}
