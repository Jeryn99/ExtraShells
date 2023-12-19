package mc.craig.software.extra_shells.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;
import whocraft.tardis_refined.client.model.blockentity.shell.ShellModel;
import whocraft.tardis_refined.common.blockentity.shell.GlobalShellBlockEntity;

public class HudolinShellModel extends ShellModel {
    private final ModelPart left_door;
    private final ModelPart right_door;
    private final ModelPart frame;
    private final ModelPart bb_main;
    private final ModelPart root;

    public HudolinShellModel(ModelPart root) {
        super(root);
        this.root = root;
        this.left_door = root.getChild("left_door");
        this.right_door = root.getChild("right_door");
        this.frame = root.getChild("frame");
        this.bb_main = root.getChild("bb_main");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition frame = partdefinition.addOrReplaceChild("frame", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition lamp = frame.addOrReplaceChild("lamp", CubeListBuilder.create().texOffs(0, 10).addBox(-1.0F, -42.4F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(12, 0).addBox(-1.5F, -39.9F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(-0.1F))
                .texOffs(12, 0).addBox(-1.5F, -41.9F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(-0.1F))
                .texOffs(0, 0).addBox(-2.0F, -39.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 5).addBox(-1.5F, -41.9F, -1.5F, 3.0F, 0.3F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 5).addBox(-1.5F, -39.3F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));

        PartDefinition cube_r1 = lamp.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(10, 9).addBox(-0.5F, -41.4F, -1.5F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -2.3562F, 0.0F));

        PartDefinition cube_r2 = lamp.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(10, 9).addBox(-0.5F, -41.4F, -1.5F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition roof = frame.addOrReplaceChild("roof", CubeListBuilder.create().texOffs(2, 51).addBox(-7.0F, -39.0F, -7.0F, 14.0F, 1.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(0, 31).addBox(-8.0F, -38.0F, -8.0F, 16.0F, 2.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(4, 4).addBox(-10.0F, -3.0F, -10.0F, 20.0F, 3.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition signage = frame.addOrReplaceChild("signage", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r3 = signage.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(63, 27).addBox(-8.0F, -36.0F, -12.0F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r4 = signage.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(63, 27).addBox(-8.0F, -36.0F, -12.0F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition cube_r5 = signage.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(63, 27).addBox(-8.0F, -36.0F, -12.0F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition f_r1 = signage.addOrReplaceChild("f_r1", CubeListBuilder.create().texOffs(63, 27).addBox(-8.0F, -36.0F, -12.0F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F));

        PartDefinition posts = frame.addOrReplaceChild("posts", CubeListBuilder.create().texOffs(119, 92).addBox(-9.0F, -37.0F, 7.0F, 2.0F, 34.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(110, 92).addBox(-9.0F, -37.0F, -9.0F, 2.0F, 34.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(101, 92).addBox(7.0F, -37.0F, -9.0F, 2.0F, 34.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(92, 92).addBox(7.0F, -37.0F, 7.0F, 2.0F, 34.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition panels = frame.addOrReplaceChild("panels", CubeListBuilder.create().texOffs(98, 0).addBox(-7.0F, -33.0F, 7.0F, 14.0F, 30.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(39, 66).addBox(-7.0F, -33.0F, 7.0F, 14.0F, 30.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r6 = panels.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(98, 0).addBox(-7.0F, -33.0F, 9.0F, 14.0F, 30.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(33, 97).addBox(-7.0F, -33.0F, 9.0F, 14.0F, 30.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r7 = panels.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(98, 0).addBox(-7.0F, -33.0F, 9.0F, 14.0F, 30.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(1, 97).addBox(-7.0F, -33.0F, 9.0F, 14.0F, 30.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition right_door = partdefinition.addOrReplaceChild("right_door", CubeListBuilder.create().texOffs(1, 66).addBox(-7.0F, -33.0F, 0.0F, 7.0F, 30.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 19).addBox(-7.0F, -21.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 22).addBox(-7.0F, -22.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(5, 18).addBox(-7.0F, -22.0F, 1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, 24.0F, -8.0F));

        PartDefinition left_door = partdefinition.addOrReplaceChild("left_door", CubeListBuilder.create().texOffs(0, 29).addBox(1.0F, -23.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(18, 66).addBox(0.0F, -33.0F, 0.0F, 7.0F, 30.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(5, 21).addBox(6.0F, -22.0F, 1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 19).addBox(1.0F, -22.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 22).addBox(1.0F, -22.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.0F, 24.0F, -8.0F));

        PartDefinition cube_r8 = left_door.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(77, 96).addBox(0.5F, -33.0F, -9.0F, 0.0F, 30.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 0.0F, -7.0F, -3.1416F, 0.0F, 3.1416F));

        PartDefinition cube_r9 = left_door.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 28).addBox(-5.0F, -23.0F, 7.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 0.0F, -6.0F, 0.0F, 0.0F, 0.0F));

        PartDefinition cube_r10 = left_door.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(5, 33).addBox(-6.0F, -24.0F, -3.5F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 0.0F, 5.0F, -3.1416F, 3.1416F, 3.1416F));

        PartDefinition cube_r11 = left_door.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 34).addBox(2.0F, -19.0F, 3.5F, 2.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 0.0F, 5.0F, -3.1416F, 0.0F, 3.1416F));

        PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(80, 54).addBox(-7.5F, -33.1F, -7.0F, 15.0F, 30.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
        addMaterializationPart(partdefinition);
        return LayerDefinition.create(meshdefinition, 128, 128);
    }



    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        left_door.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        right_door.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        frame.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }

    public void setupAnim(Entity entity, float f, float g, float h, float i, float j) {
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

        this.handleAllAnimations(entity, this.root, isBaseModel, open, poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public boolean isDoorModel() {
        return false;
    }
}
