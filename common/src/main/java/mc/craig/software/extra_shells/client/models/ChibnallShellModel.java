package mc.craig.software.extra_shells.client.models;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;
import whocraft.tardis_refined.client.model.blockentity.shell.ShellModel;
import whocraft.tardis_refined.common.blockentity.shell.GlobalShellBlockEntity;

public class ChibnallShellModel extends ShellModel {

    private final ModelPart right_door;
    private final ModelPart left_door;
    private final ModelPart frame;
    private final ModelPart root;


    public ChibnallShellModel(ModelPart root) {
        super(root);
        this.right_door = root.getChild("right_door");
        this.left_door = root.getChild("left_door");
        this.frame = root.getChild("frame");
        this.root = root;
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition frame = partdefinition.addOrReplaceChild("frame", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -3.0F, -12.0F, 24.0F, 3.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition lamp = frame.addOrReplaceChild("lamp", CubeListBuilder.create().texOffs(0, 10).addBox(-1.0F, -44.4F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(12, 0).addBox(-1.5F, -39.9F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(-0.1F))
                .texOffs(0, 0).addBox(-2.0F, -39.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 5).addBox(-1.5F, -43.9F, -1.5F, 3.0F, 2.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.offset(0.0F, -1.0F, 0.0F));

        PartDefinition cube_r1 = lamp.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(8, 11).addBox(-2.0F, -1.0F, -0.5F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -41.4F, 0.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r2 = lamp.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(8, 11).addBox(-2.0F, -1.0F, -0.5F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -41.4F, 0.0F, 0.0F, -2.3562F, 0.0F));

        PartDefinition roof = frame.addOrReplaceChild("roof", CubeListBuilder.create().texOffs(0, 49).addBox(-8.0F, -39.0F, -8.0F, 16.0F, 1.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(0, 27).addBox(-10.0F, -38.0F, -10.0F, 20.0F, 2.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition signage = frame.addOrReplaceChild("signage", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r3 = signage.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(60, 27).addBox(-10.0F, -36.0F, -12.0F, 20.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r4 = signage.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(60, 27).addBox(-10.0F, -36.0F, -12.0F, 20.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition cube_r5 = signage.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(60, 27).addBox(-10.0F, -36.0F, -12.0F, 20.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition f_r1 = signage.addOrReplaceChild("f_r1", CubeListBuilder.create().texOffs(60, 27).addBox(-10.0F, -36.0F, -12.0F, 20.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));

        PartDefinition posts = frame.addOrReplaceChild("posts", CubeListBuilder.create().texOffs(104, 91).addBox(-11.0F, -37.0F, 8.0F, 3.0F, 34.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(116, 91).addBox(-11.0F, -37.0F, -11.0F, 3.0F, 34.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(80, 91).addBox(8.0F, -37.0F, -11.0F, 3.0F, 34.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(92, 91).addBox(8.0F, -37.0F, 8.0F, 3.0F, 34.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition panels = frame.addOrReplaceChild("panels", CubeListBuilder.create().texOffs(37, 66).addBox(-8.0F, -33.0F, 9.0F, 16.0F, 30.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r6 = panels.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 97).addBox(-8.0F, -33.0F, 9.0F, 16.0F, 30.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r7 = panels.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(34, 97).addBox(-8.0F, -33.0F, 9.0F, 16.0F, 30.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition right_door = partdefinition.addOrReplaceChild("right_door", CubeListBuilder.create().texOffs(0, 66).addBox(-8.0F, -33.0F, -1.0F, 8.0F, 30.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 19).addBox(-7.0F, -19.0F, -2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(5, 18).addBox(-8.0F, -22.0F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 24.0F, -9.0F));

        PartDefinition left_door = partdefinition.addOrReplaceChild("left_door", CubeListBuilder.create().texOffs(0, 29).addBox(2.0F, -23.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 34).addBox(2.0F, -19.0F, 0.5F, 2.0F, 7.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(0, 29).addBox(3.0F, -23.0F, 0.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(18, 66).addBox(0.0F, -33.0F, -1.0F, 8.0F, 30.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(77, 96).addBox(6.5F, -33.0F, 0.0F, 0.0F, 30.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(5, 21).addBox(7.0F, -22.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, 24.0F, -9.0F));

        PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(78, 52).addBox(-8.5F, -33.1F, -9.0F, 17.0F, 30.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
        addMaterializationPart(partdefinition);
        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setDoorPosition(boolean open) {
        this.right_door.yRot = open ? -275.0F : 0.0F;
    }


    @Override
    public void renderShell(GlobalShellBlockEntity entity, boolean open, boolean isBaseModel, PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        if (isBaseModel) {
            poseStack.scale(1.05F, 1.05F, 1.05F);
            poseStack.translate(0.0, -0.07, 0.0);
        }

        this.handleAllAnimations(entity, this.frame, isBaseModel, open, poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        this.frame.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, this.getCurrentAlpha());
        this.left_door.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, this.getCurrentAlpha());
        this.right_door.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, this.getCurrentAlpha());

    }

    @Override
    public ModelPart root() {
        return root;
    }

    @Override
    public void setupAnim(Entity entity, float f, float g, float h, float i, float j) {

    }
}