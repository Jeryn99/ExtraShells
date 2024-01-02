package mc.craig.software.extra_shells.geo;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import mc.craig.software.extra_shells.AnimationHackery;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;
import software.bernie.geckolib.renderer.GeoObjectRenderer;

public class RenderShellGeo extends GeoObjectRenderer<AnimationHackery> {

    public static RenderShellGeo INSTANCE = new RenderShellGeo();

    public RenderShellGeo() {
        super(new GeoShellModel());
    }

    @Override
    public void render(PoseStack poseStack, AnimationHackery animatable, MultiBufferSource bufferSource, RenderType renderType, VertexConsumer buffer, int packedLight) {
        poseStack.mulPose(Axis.YP.rotationDegrees(90));
        poseStack.translate(0, -0.5, 0);
        super.render(poseStack, animatable, bufferSource, renderType, buffer, packedLight);
    }
}
