package mc.craig.software.extra_shells.mixins;

import com.mojang.blaze3d.vertex.PoseStack;
import mc.craig.software.extra_shells.TEShellThemes;
import mc.craig.software.extra_shells.client.models.RenderDoorHook;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import whocraft.tardis_refined.client.renderer.blockentity.door.GlobalDoorRenderer;
import whocraft.tardis_refined.common.block.door.GlobalDoorBlock;
import whocraft.tardis_refined.common.blockentity.door.GlobalDoorBlockEntity;
import whocraft.tardis_refined.common.tardis.themes.ShellTheme;

@Mixin(GlobalDoorRenderer.class)
public class GlobalDoorRendererMixin {


    @Inject(cancellable = true, method = "render(Lwhocraft/tardis_refined/common/blockentity/door/GlobalDoorBlockEntity;FLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;II)V", at = @At("HEAD"), remap = true)
    public void renderDoorModel(GlobalDoorBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay, CallbackInfo ci) {

        BlockState blockstate = blockEntity.getBlockState();
        ShellTheme theme = blockstate.getValue(GlobalDoorBlock.SHELL);

        if (theme == TEShellThemes.HUDOLIN || theme == TEShellThemes.LEGO_IDEAS || theme == TEShellThemes.JACK_CUSTOM || theme == TEShellThemes.RTD || theme == TEShellThemes.CHIBNALL || theme == TEShellThemes.GLASGOW || theme == TEShellThemes.ELLEN || theme == TEShellThemes.ENGINEERS || theme == TEShellThemes.MOFFAT || theme == TEShellThemes.SEA_BLUE ) {
            RenderDoorHook.renderDoorModel(blockEntity, partialTick, poseStack, bufferSource, packedLight, packedOverlay, ci);
            ci.cancel();
        }

    }


}
