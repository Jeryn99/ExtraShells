package dev.jeryn.extra_shells.client.models.doors;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import dev.jeryn.frame.tardis.Frame;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import whocraft.tardis_refined.client.model.blockentity.door.interior.ShellDoorModel;
import whocraft.tardis_refined.common.blockentity.door.GlobalDoorBlockEntity;

public class DeloreanShellDoorModel extends ShellDoorModel {

    private final ModelPart root;
    private final ModelPart left_door;

    public DeloreanShellDoorModel(ModelPart root) {
        this.root = root;
        this.left_door = Frame.findPart(this, "left_door");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition left_door = partdefinition.addOrReplaceChild("left_door", CubeListBuilder.create().texOffs(156, 62).addBox(0.0F, 0.0F, -1.7F, 8.0F, 1.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(143, 128).addBox(10.25F, 10.0F, -10.7905F, 2.0F, 2.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.75F, 4.1793F, 6.7457F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r1 = left_door.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(93, 144).addBox(-1.0F, 0.0F, -6.0905F, 1.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.25F, 12.0F, -4.7F, 0.0F, 0.0F, 0.3054F));

        PartDefinition bone6 = left_door.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, -6.525F, 1.0F, 11.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(71, 121).addBox(-0.95F, 0.0F, -14.5F, 1.0F, 11.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, 3.8F, 0.0F, 0.0F, -0.3491F));

        PartDefinition cube_r2 = bone6.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(77, 68).addBox(-1.475F, 0.0F, 0.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 4.8357F, -14.0905F, -0.0873F, 0.0F, 0.0F));

        PartDefinition cube_r3 = bone6.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 31).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -6.5F, -1.0036F, 0.0F, 0.0F));

        PartDefinition bone8 = bone6.addOrReplaceChild("bone8", CubeListBuilder.create().texOffs(0, 31).addBox(-0.475F, -3.0F, -2.5F, 1.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 7.8357F, -11.5905F));

        return LayerDefinition.create(meshdefinition, 256, 256);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.root().render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart root() {
        return root;
    }

    @Override
    public void renderFrame(GlobalDoorBlockEntity doorBlockEntity, boolean open, boolean isBaseModel, PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.setDoorPosition(open);
        this.root().getAllParts().forEach((modelPart) -> {
            modelPart.visible = true;
        });
        this.root().render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public void renderPortalMask(GlobalDoorBlockEntity globalDoorBlockEntity, boolean b, boolean b1, PoseStack poseStack, VertexConsumer vertexConsumer, int i, int i1, float v, float v1, float v2, float v3) {

    }

    @Override
    public void setDoorPosition(boolean open) {
        this.left_door.xRot = (float) Math.toRadians(90);
        this.left_door.yRot = (float) Math.toRadians(open ? 180:  90);
        this.left_door.zRot = (float) Math.toRadians(90);

    }
}
