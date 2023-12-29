package mc.craig.software.extra_shells.mixins;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import whocraft.tardis_refined.client.renderer.blockentity.shell.GlobalShellRenderer;
import whocraft.tardis_refined.common.blockentity.shell.GlobalShellBlockEntity;

@Mixin(GlobalShellRenderer.class)
public class GlobalShellRendererMixin implements GeoRenderer<GlobalShellBlockEntityMixin> {


    @Override
    public GeoModel<GlobalShellBlockEntity> getGeoModel() {
        return null;
    }

    @Override
    public GlobalShellBlockEntity getAnimatable() {
        return null;
    }

    @Override
    public void fireCompileRenderLayersEvent() {

    }

    @Override
    public boolean firePreRenderEvent(PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {
        return false;
    }

    @Override
    public void firePostRenderEvent(PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {

    }

    @Override
    public void updateAnimatedTextureFrame(GlobalShellBlockEntityMixin animatable) {

    }

    @Override
    public void updateAnimatedTextureFrame(GlobalShellBlockEntity animatable) {

    }
}
