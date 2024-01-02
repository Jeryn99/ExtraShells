package mc.craig.software.extra_shells.mixins;

import com.mojang.blaze3d.vertex.PoseStack;
import mc.craig.software.extra_shells.AnimationHackery;
import mc.craig.software.extra_shells.geo.RenderShellGeo;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import whocraft.tardis_refined.client.model.blockentity.shell.ShellModelCollection;
import whocraft.tardis_refined.client.renderer.blockentity.shell.GlobalShellRenderer;
import whocraft.tardis_refined.common.blockentity.shell.GlobalShellBlockEntity;

@Mixin(GlobalShellRenderer.class)
public class GlobalShellRendererMixin {

    @Inject(cancellable = true, method = "render(Lwhocraft/tardis_refined/common/blockentity/shell/GlobalShellBlockEntity;FLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;II)V", at = @At(value = "HEAD"))
    private void onRenderHead(GlobalShellBlockEntity blockEntity, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay, CallbackInfo ci) {
        if (blockEntity instanceof AnimationHackery geoAnimatable) {
            if(ShellModelCollection.getInstance().getShellEntry(geoAnimatable.getShellEntity().theme()) == null) {
                RenderShellGeo.INSTANCE.render(matrixStack, geoAnimatable, buffer, null, null, combinedLight);
                ci.cancel();
            }
            //PoseStack poseStack, T animatable, @Nullable MultiBufferSource bufferSource, @Nullable RenderType renderType,
            //					   @Nullable VertexConsumer buffer, int packedLight
        }
    }

}
