package dev.jeryn.extra_shells.client.models;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;
import whocraft.tardis_refined.client.model.blockentity.shell.ShellModel;
import whocraft.tardis_refined.common.blockentity.shell.GlobalShellBlockEntity;

public class OldSchoolShellModel extends ShellModel {

    private final ModelPart door;
    private final ModelPart shell;
    private final ModelPart root;


    public OldSchoolShellModel(ModelPart root) {
        super(root);
        this.root = root;
        this.door = root.getChild("door");
        this.shell = root.getChild("frame");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition door = partdefinition.addOrReplaceChild("door", CubeListBuilder.create().texOffs(1, 1).addBox(-0.152F, -16.0F, -3.1525F, 16.0F, 32.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.848F, 8.0F, -7.8475F));

        PartDefinition shell = partdefinition.addOrReplaceChild("shell", CubeListBuilder.create().texOffs(1, 43).addBox(-8.0F, 0.0F, 8.0F, 16.0F, 32.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(36, 76).addBox(-8.0F, -8.0F, -8.0F, 16.0F, 8.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(40, 26).addBox(-7.0F, 31.0F, -7.0F, 14.0F, 1.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, 0.0F));

        PartDefinition cube_r1 = shell.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(1, 43).addBox(-8.0F, -16.0F, 5.0F, 16.0F, 32.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.0F, 16.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r2 = shell.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(1, 43).addBox(-8.0F, -16.0F, 4.0F, 16.0F, 32.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 16.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
        addMaterializationPart(partdefinition);
        return LayerDefinition.create(meshdefinition, 100, 100);
    }

    @Override
    public void setDoorPosition(boolean open) {
        this.door.yRot = open ? (float) Math.toRadians(90) : 0.0F;
    }

    @Override
    public void renderShell(GlobalShellBlockEntity entity, boolean open, boolean isBaseModel, PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        if (isBaseModel) {
            poseStack.scale(1.05F, 1.05F, 1.05F);
            poseStack.translate(0.0, -0.07, 0.0);
        }

        this.handleAllAnimations(entity, this.root(), isBaseModel, open, poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart root() {
        return root;
    }

    @Override
    public void setupAnim(Entity entity, float f, float g, float h, float i, float j) {

    }
}