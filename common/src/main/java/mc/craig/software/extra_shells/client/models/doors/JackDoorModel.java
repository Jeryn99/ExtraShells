package mc.craig.software.extra_shells.client.models.doors;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.Entity;
import whocraft.tardis_refined.client.model.blockentity.door.interior.ShellDoorModel;
import whocraft.tardis_refined.client.model.blockentity.shell.ShellModel;
import whocraft.tardis_refined.common.blockentity.door.GlobalDoorBlockEntity;
import whocraft.tardis_refined.common.blockentity.shell.GlobalShellBlockEntity;

public class JackDoorModel extends ShellDoorModel {

    private final ModelPart left_door;
    private final ModelPart right_door;
    private final ModelPart model;
    private final ModelPart root;

    public JackDoorModel(ModelPart root) {
        this.root = root;
        this.model = root.getChild("bone");
        this.left_door = model.getChild("left_door");
        this.right_door = model.getChild("right_door");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(0.0F, 26.0F, -3.0F));

        PartDefinition left_door = bone.addOrReplaceChild("left_door", CubeListBuilder.create().texOffs(100, 107).addBox(-0.5F, -15.0F, 0.0F, 8.0F, 30.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 6).addBox(5.5F, -4.0F, 1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.5F, -18.0F, 11.0F));

        PartDefinition right_door = bone.addOrReplaceChild("right_door", CubeListBuilder.create().texOffs(114, 34).addBox(-7.5F, -15.0F, 0.0F, 8.0F, 30.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(1, 165).addBox(-4.5F, -5.0F, -2.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(7.5F, -18.0F, 11.0F));

        PartDefinition Signs = bone.addOrReplaceChild("Signs", CubeListBuilder.create().texOffs(18, 171).addBox(0.6F, -36.2F, 10.7F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(22, 162).addBox(1.1F, -37.2F, 11.2F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(18, 171).addBox(4.6F, -36.2F, 10.7F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(22, 162).addBox(5.1F, -37.2F, 11.2F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(18, 171).addBox(-7.0F, -36.2F, 10.7F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(22, 162).addBox(-6.5F, -37.2F, 11.2F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(18, 171).addBox(-3.1F, -36.2F, 10.7F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(22, 162).addBox(-2.6F, -37.2F, 11.2F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r1 = Signs.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 80).addBox(13.0F, -37.0F, -11.0F, 1.0F, 4.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition Lamp = bone.addOrReplaceChild("Lamp", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Roof = bone.addOrReplaceChild("Roof", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Doors = bone.addOrReplaceChild("Doors", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r2 = Doors.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(38, 38).addBox(10.0F, -39.0F, -8.0F, 3.0F, 2.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(38, 38).addBox(10.0F, -34.0F, -8.0F, 3.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition pillars = bone.addOrReplaceChild("pillars", CubeListBuilder.create().texOffs(0, 106).addBox(-11.0F, -39.0F, 10.0F, 3.0F, 37.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(70, 103).addBox(8.0F, -39.0F, 10.0F, 3.0F, 37.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 256, 256);
    }


    @Override
    public void renderInteriorDoor(GlobalDoorBlockEntity doorBlockEntity, boolean open, boolean isBaseModel, PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        root().render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }

    @Override
    public void setDoorPosition(boolean open) {
        this.right_door.yRot = open ? (float) Math.toRadians(-75) : 0.0F;
        this.left_door.yRot = open ? (float) Math.toRadians(75) : 0.0F;
    }
}
