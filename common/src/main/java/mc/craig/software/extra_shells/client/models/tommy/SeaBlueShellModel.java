package mc.craig.software.extra_shells.client.models.tommy;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import whocraft.tardis_refined.client.model.blockentity.shell.ShellModel;
import whocraft.tardis_refined.common.blockentity.shell.GlobalShellBlockEntity;

public class SeaBlueShellModel extends ShellModel {

    private final ModelPart right_door;
    private final ModelPart left_door;
    private final ModelPart frame;
    private final ModelPart root;


    public SeaBlueShellModel(ModelPart root) {
        super(root);
        this.right_door = root.getChild("right_door");
        this.left_door = root.getChild("left_door");
        this.frame = root.getChild("frame");
        this.root = root;
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition right_door = partdefinition.addOrReplaceChild("right_door", CubeListBuilder.create().texOffs(68, 88).addBox(-7.95F, -33.0F, -1.025F, 8.0F, 29.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 6).addBox(-7.0F, -23.0F, -2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(15, 0).addBox(-8.0F, -20.0F, -0.025F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 24.0F, -8.0F));

        PartDefinition left_door = partdefinition.addOrReplaceChild("left_door", CubeListBuilder.create().texOffs(86, 88).addBox(0.025F, -33.0F, -1.0F, 8.0F, 29.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(6.975F, -20.0F, -0.025F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 19).addBox(2.0F, -24.0F, 0.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 15).addBox(1.0F, -25.0F, 0.5F, 4.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, 24.0F, -8.0F));

        PartDefinition frame = partdefinition.addOrReplaceChild("frame", CubeListBuilder.create().texOffs(0, 29).addBox(-12.0F, -4.0F, -12.0F, 24.0F, 4.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition lamp = frame.addOrReplaceChild("lamp", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, 4.0F, -2.5F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.2F))
                .texOffs(0, 0).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.2F))
                .texOffs(0, 6).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offset(0.0F, -47.0F, 0.0F));

        PartDefinition cube_r1 = lamp.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 19).addBox(-3.5F, 1.0F, 0.0F, 7.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r2 = lamp.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 19).addBox(-3.5F, 1.0F, 0.0F, 7.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -2.3562F, 0.0F));

        PartDefinition roof = frame.addOrReplaceChild("roof", CubeListBuilder.create().texOffs(0, 126).addBox(-10.0F, -42.0F, -10.0F, 20.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition signage = frame.addOrReplaceChild("signage", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 1.0F));

        PartDefinition cube_r3 = signage.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -40.0F, -11.0F, 24.0F, 5.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition posts = frame.addOrReplaceChild("posts", CubeListBuilder.create().texOffs(106, 36).addBox(-11.0F, -39.0F, -11.0F, 3.0F, 35.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 108).addBox(-11.0F, -39.0F, 8.0F, 3.0F, 35.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(96, 0).addBox(8.0F, -39.0F, -11.0F, 3.0F, 35.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(104, 85).addBox(8.0F, -39.0F, 8.0F, 3.0F, 35.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition panels = frame.addOrReplaceChild("panels", CubeListBuilder.create().texOffs(34, 77).addBox(-8.0F, -33.0F, 8.0F, 16.0F, 29.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r4 = panels.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 77).addBox(-8.0F, -33.0F, 8.0F, 16.0F, 29.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r5 = panels.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(72, 57).addBox(-8.0F, -33.0F, 8.0F, 16.0F, 29.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(80, 123).addBox(-8.0F, -33.0F, -8.0F, 16.0F, 29.0F, 8.0F, new CubeDeformation(-0.05F)), PartPose.offset(0.0F, 24.0F, 0.0F));
        splice(partdefinition);
        return LayerDefinition.create(meshdefinition, 256, 256);
    }

    @Override
    public void setDoorOpen(boolean open) {
        this.right_door.yRot = open ? (float) Math.toRadians(75) : 0.0F;
        this.left_door.yRot = open ? (float) -Math.toRadians(75) : 0.0F;
    }

    @Override
    public boolean isDoorModel() {
        return false;
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