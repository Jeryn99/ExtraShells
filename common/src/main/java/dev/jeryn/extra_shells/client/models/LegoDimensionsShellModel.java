package dev.jeryn.extra_shells.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;
import whocraft.tardis_refined.client.model.blockentity.shell.ShellModel;
import whocraft.tardis_refined.common.blockentity.shell.GlobalShellBlockEntity;

public class LegoDimensionsShellModel extends ShellModel {

    private final ModelPart root;
    private final ModelPart frame;
    private final ModelPart right_door;
    private final ModelPart left_door;
    private final ModelPart portal;

    public LegoDimensionsShellModel(ModelPart root) {
        super(root);
        this.root = root;
        this.frame = root.getChild("frame");
        this.right_door = root.getChild("right_door");
        this.left_door = root.getChild("left_door");
        this.portal = root.getChild("portal");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        addMaterializationPart(partdefinition);

        PartDefinition frame = partdefinition.addOrReplaceChild("frame", CubeListBuilder.create().texOffs(0, 50).addBox(-9.0F, -35.0F, -9.0F, 18.0F, 3.0F, 18.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-11.0F, -32.0F, -11.0F, 22.0F, 3.0F, 22.0F, new CubeDeformation(0.0F))
                .texOffs(0, 25).addBox(-11.0F, -3.0F, -11.0F, 22.0F, 3.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition lamp = frame.addOrReplaceChild("lamp", CubeListBuilder.create(), PartPose.offset(0.0F, -36.0F, 0.0F));

        PartDefinition cube_r1 = lamp.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 9).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-1.5F, -4.0F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition panels = frame.addOrReplaceChild("panels", CubeListBuilder.create().texOffs(68, 67).addBox(-10.0F, -29.0F, 5.0F, 20.0F, 26.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r2 = panels.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(88, 30).addBox(-11.0F, -26.0F, -8.0F, 10.0F, 26.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 71).addBox(-11.0F, -26.0F, 6.0F, 10.0F, 26.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -3.0F, -1.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition right_door = partdefinition.addOrReplaceChild("right_door", CubeListBuilder.create().texOffs(80, 97).addBox(-1.0F, -29.0F, -9.0F, 10.0F, 26.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-9.0F, 24.0F, 0.0F));

        PartDefinition cube_r3 = right_door.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(52, 97).addBox(-1.0F, -26.0F, -8.0F, 10.0F, 26.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, -3.0F, -1.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition left_door = partdefinition.addOrReplaceChild("left_door", CubeListBuilder.create().texOffs(88, 0).addBox(-9.0F, -29.0F, -9.0F, 10.0F, 26.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(9.0F, 24.0F, 0.0F));

        PartDefinition cube_r4 = left_door.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(28, 71).addBox(-9.0F, -26.0F, -8.0F, 10.0F, 26.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, -3.0F, -1.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition portal = partdefinition.addOrReplaceChild("portal", CubeListBuilder.create().texOffs(0, 102).addBox(-9.0F, -29.0F, -0.025F, 18.0F, 26.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public ModelPart root() {
        return this.root;
    }

    public void setDoorPosition(boolean open) {
        this.right_door.yRot = open ? (float) Math.toRadians(75) : 0.0F;
        this.left_door.yRot = open ? (float) Math.toRadians(-75) : 0.0F;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        frame.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        right_door.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        left_door.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        portal.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public void renderShell(GlobalShellBlockEntity entity, boolean open, boolean isBaseModel, PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.handleAllAnimations(entity, this.root(), isBaseModel, open, poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }
}
