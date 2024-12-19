package dev.jeryn.extra_shells.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.Entity;
import whocraft.tardis_refined.client.model.blockentity.shell.ShellModel;
import whocraft.tardis_refined.common.blockentity.shell.GlobalShellBlockEntity;

public class MadDocShellBase extends ShellModel {

    private final ModelPart left_door;
    private final ModelPart right_door;
    private final ModelPart root;

    public MadDocShellBase(ModelPart root) {
        super(root);
        this.left_door = root.getChild("door1");
        this.right_door = root.getChild("door2");
        this.root = root;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(180));
        this.root().render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        poseStack.popPose();
    }

    @Override
    public ModelPart root() {
        return this.root;
    }

    public void setupAnim(Entity entity, float f, float g, float h, float i, float j) {
    }

    @Override
    public void setDoorPosition(boolean open) {
        this.right_door.yRot = open ? (float) Math.toRadians(70) : 0.0F;
        this.left_door.yRot = open ? (float) Math.toRadians(-70) : 0.0F;
    }

    @Override
    public void renderShell(GlobalShellBlockEntity entity, boolean open, boolean isBaseModel, PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
       /* poseStack.mulPose(Vector3f.YP.rotationDegrees(180));

        if(!isBaseModel){
        poseStack.translate(0.0, -0.07, 0.0);
}*/

        this.handleAllAnimations(entity, this.root(), isBaseModel, open, poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

}
