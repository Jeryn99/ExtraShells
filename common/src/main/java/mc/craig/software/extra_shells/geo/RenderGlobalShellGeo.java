package mc.craig.software.extra_shells.geo;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoObjectRenderer;

public class RenderGlobalShellGeo extends GeoObjectRenderer {
    public RenderGlobalShellGeo(GeoModel model) {
        super(model);
    }



    @Override
    public void render(PoseStack poseStack, GeoAnimatable animatable, MultiBufferSource bufferSource, RenderType renderType, VertexConsumer buffer, int packedLight) {
        super.render(poseStack, animatable, bufferSource, renderType, buffer, packedLight);
    }
}
