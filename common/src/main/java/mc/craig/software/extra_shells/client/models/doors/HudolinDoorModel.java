package mc.craig.software.extra_shells.client.models.doors;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;
import whocraft.tardis_refined.client.model.blockentity.door.interior.ShellDoorModel;
import whocraft.tardis_refined.client.model.blockentity.shell.ShellModel;
import whocraft.tardis_refined.common.blockentity.door.GlobalDoorBlockEntity;
import whocraft.tardis_refined.common.blockentity.shell.GlobalShellBlockEntity;

public class HudolinDoorModel extends ShellDoorModel {
    private final ModelPart left_door;
    private final ModelPart right_door;
    private final ModelPart frame;
    private final ModelPart bb_main;

    public HudolinDoorModel(ModelPart root) {
        this.left_door = root.getChild("left_door");
        this.right_door = root.getChild("right_door");
        this.frame = root.getChild("frame");
        this.bb_main = root.getChild("bb_main");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition frame = partdefinition.addOrReplaceChild("frame", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition roof = frame.addOrReplaceChild("roof", CubeListBuilder.create().texOffs(0, 31).addBox(-8.0F, -35.0F, -8.0F, 16.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition signage = frame.addOrReplaceChild("signage", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r1 = signage.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(63, 33).addBox(-8.0F, -36.0F, -10.0F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r2 = signage.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(63, 33).addBox(-8.0F, -36.0F, -10.0F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition cube_r3 = signage.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(63, 33).addBox(-8.0F, -36.0F, -10.0F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition f_r1 = signage.addOrReplaceChild("f_r1", CubeListBuilder.create().texOffs(63, 27).addBox(-8.0F, -36.0F, -10.0F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.0F));

        PartDefinition posts = frame.addOrReplaceChild("posts", CubeListBuilder.create().texOffs(119, 92).addBox(-8.975F, -34.0F, 6.975F, 2.0F, 34.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(110, 92).addBox(-9.0F, -34.0F, -9.0F, 2.0F, 34.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(101, 92).addBox(7.0F, -34.0F, -9.0F, 2.0F, 34.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(92, 92).addBox(6.975F, -34.0F, 6.975F, 2.0F, 34.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition panels = frame.addOrReplaceChild("panels", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r4 = panels.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(33, 97).addBox(-7.0F, -33.0F, 7.0F, 14.0F, 30.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r5 = panels.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(1, 97).addBox(-7.0F, -33.0F, 7.0F, 14.0F, 30.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition right_door = partdefinition.addOrReplaceChild("right_door", CubeListBuilder.create(), PartPose.offset(-7.0F, 24.0F, 8.0F));

        PartDefinition cube_r6 = right_door.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(5, 18).addBox(0.0F, -22.0F, 11.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 22).addBox(-6.0F, -22.0F, 9.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 22).addBox(0.0F, -22.0F, 9.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 19).addBox(-6.0F, -22.0F, 9.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 19).addBox(0.0F, -21.0F, 9.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(1, 66).addBox(0.0F, -33.0F, 10.0F, 7.0F, 30.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 3.0F, 10.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition left_door = partdefinition.addOrReplaceChild("left_door", CubeListBuilder.create().texOffs(18, 66).addBox(0.0F, -30.0F, 0.0F, 7.0F, 30.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(5, 21).addBox(6.0F, -19.0F, 1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 24.0F, 8.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition cube_r7 = left_door.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 28).addBox(-5.0F, -23.0F, -9.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 3.0F, 10.0F, 0.0F, 0.0F, 0.0F));

        PartDefinition cube_r8 = left_door.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(5, 33).addBox(-6.0F, -24.0F, -19.5F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 3.0F, 21.0F, -3.1416F, 3.1416F, 3.1416F));

        PartDefinition cube_r9 = left_door.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 34).addBox(2.0F, -19.0F, 19.5F, 2.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 3.0F, 21.0F, -3.1416F, 0.0F, 3.1416F));

        PartDefinition cube_r10 = left_door.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(77, 96).addBox(0.5F, -33.0F, 7.0F, 0.0F, 30.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 3.0F, 9.0F, -3.1416F, 0.0F, 3.1416F));

        PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition portal_r1 = bb_main.addOrReplaceChild("portal_r1", CubeListBuilder.create().texOffs(89, 59).addBox(-7.0F, -33.0F, 10.825F, 14.0F, 30.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 18.0F, 0.0F, 3.1416F, 0.0F));
        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void renderInteriorDoor(GlobalDoorBlockEntity doorBlockEntity, boolean open, boolean isBaseModel, PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        left_door.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        right_door.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        frame.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart root() {
        return this.frame;
    }

    @Override
    public void setDoorPosition(boolean open) {
        this.right_door.yRot = open ? -275.0F : 0.0F;
    }

}
