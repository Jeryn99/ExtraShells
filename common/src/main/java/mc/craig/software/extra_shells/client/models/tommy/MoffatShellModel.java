package mc.craig.software.extra_shells.client.models.tommy;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;
import whocraft.tardis_refined.client.model.blockentity.shell.ShellModel;
import whocraft.tardis_refined.common.blockentity.shell.GlobalShellBlockEntity;

public class MoffatShellModel extends ShellModel {
    private final ModelPart left_door;
    private final ModelPart right_door;
    private final ModelPart frame;
    private final ModelPart bb_main;

    public MoffatShellModel(ModelPart root) {
        super(root);
        this.left_door = root.getChild("left_door");
        this.right_door = root.getChild("right_door");
        this.frame = root.getChild("frame");
        this.bb_main = root.getChild("bb_main");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition frame = partdefinition.addOrReplaceChild("frame", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -3.0F, -12.0F, 24.0F, 3.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition lamp = frame.addOrReplaceChild("lamp", CubeListBuilder.create().texOffs(0, 5).addBox(-1.5F, -46.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-2.0F, -45.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r1 = lamp.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(12, 0).addBox(-2.5F, -1.5F, -0.5F, 5.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -42.0F, 0.0F, 0.0F, -2.3562F, 0.0F));

        PartDefinition cube_r2 = lamp.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(12, 0).addBox(-2.5F, -1.5F, -0.5F, 5.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -42.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition roof = frame.addOrReplaceChild("roof", CubeListBuilder.create().texOffs(0, 27).addBox(-10.0F, -38.0F, -10.0F, 20.0F, 2.0F, 20.0F, new CubeDeformation(0.0F))
                .texOffs(0, 49).addBox(-9.0F, -40.0F, -9.0F, 18.0F, 2.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition signage = frame.addOrReplaceChild("signage", CubeListBuilder.create().texOffs(54, 58).addBox(-9.0F, -36.0F, 9.0F, 18.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r3 = signage.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(54, 58).addBox(-9.0F, -36.0F, 9.0F, 18.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r4 = signage.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(54, 58).addBox(-9.0F, -36.0F, 9.0F, 18.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r5 = signage.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(54, 58).addBox(-9.0F, -36.0F, 9.0F, 18.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition posts = frame.addOrReplaceChild("posts", CubeListBuilder.create().texOffs(12, 100).addBox(-11.0F, -37.0F, -11.0F, 3.0F, 34.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(24, 100).addBox(8.0F, -37.0F, -11.0F, 3.0F, 34.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(36, 100).addBox(8.0F, -37.0F, 8.0F, 3.0F, 34.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 100).addBox(-11.0F, -37.0F, 8.0F, 3.0F, 34.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition panels = frame.addOrReplaceChild("panels", CubeListBuilder.create().texOffs(68, 69).addBox(-8.0F, -33.0F, 9.0F, 16.0F, 30.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r6 = panels.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 69).addBox(-8.0F, -33.0F, 9.0F, 16.0F, 30.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r7 = panels.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(34, 69).addBox(-8.0F, -33.0F, 9.0F, 16.0F, 30.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition right_door = partdefinition.addOrReplaceChild("right_door", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -19.0F, -2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(98, 0).addBox(-8.0F, -30.0F, -1.0F, 8.0F, 30.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 14).addBox(-8.0F, -16.0F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 21.0F, -9.0F));

        PartDefinition left_door = partdefinition.addOrReplaceChild("left_door", CubeListBuilder.create().texOffs(8, 15).addBox(1.0F, -21.0F, 0.0F, 5.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 17).addBox(7.0F, -16.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(80, 27).addBox(0.0F, -30.0F, -1.0F, 8.0F, 30.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(12, 10).addBox(2.0F, -20.0F, 0.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 6).addBox(1.0F, -21.0F, 0.5F, 4.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, 21.0F, -9.0F));

        PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(49, 101).addBox(-8.5F, -33.025F, -9.0F, 17.0F, 30.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
        splice(partdefinition);
        return LayerDefinition.create(meshdefinition, 256, 256);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        left_door.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        right_door.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        frame.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public ModelPart root() {
        return this.frame;
    }

    public void setupAnim(Entity entity, float f, float g, float h, float i, float j) {
    }

    @Override
    public void setDoorOpen(boolean open) {
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
        this.bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, this.getCurrentAlpha());

    }

    public boolean isDoorModel() {
        return true;
    }
}
