package mc.craig.software.extra_shells.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;
import whocraft.tardis_refined.client.model.blockentity.shell.ShellModel;
import whocraft.tardis_refined.common.blockentity.shell.GlobalShellBlockEntity;

public class JackShellModel extends ShellModel {


    private final ModelPart pillars;
    private final ModelPart Doors;
    private final ModelPart Roof;
    private final ModelPart Lamp;
    private final ModelPart Signs;
    private final ModelPart left_door;
    private final ModelPart right_door;
    private final ModelPart root;

    public JackShellModel(ModelPart root) {
        super(root);
        ModelPart model = root.getChild("model");

        this.pillars = model.getChild("pillars");
        this.Doors = model.getChild("Doors");
        this.Roof = model.getChild("Roof");
        this.Lamp = model.getChild("Lamp");
        this.Signs = model.getChild("Signs");
        this.left_door = model.getChild("left_door");
        this.right_door = model.getChild("right_door");
        this.root = root;
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition model = partdefinition.addOrReplaceChild("model", CubeListBuilder.create().texOffs(0, 30).addBox(-12.0F, -3.0F, -10.0F, 24.0F, 3.0F, 24.0F, new CubeDeformation(0.0F))
                .texOffs(12, 106).addBox(0.0F, -33.0F, -8.0F, 8.0F, 30.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition Signs = model.addOrReplaceChild("Signs", CubeListBuilder.create().texOffs(82, 81).addBox(-13.0F, -37.0F, -9.0F, 1.0F, 4.0F, 22.0F, new CubeDeformation(0.0F))
                .texOffs(0, 80).addBox(12.0F, -37.0F, -9.0F, 1.0F, 4.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r1 = Signs.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(74, 8).addBox(38.0F, -1.0F, -10.5F, 1.0F, 4.0F, 22.0F, new CubeDeformation(0.0F))
                .texOffs(58, 77).addBox(13.0F, -1.0F, -10.5F, 1.0F, 4.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -36.0F, -24.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition Lamp = model.addOrReplaceChild("Lamp", CubeListBuilder.create().texOffs(0, 6).addBox(-2.0F, -47.0F, 0.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(8, 11).addBox(-1.0F, -48.0F, 1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 11).addBox(-0.85F, -47.0F, 0.9F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-2.0F, -44.0F, 0.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-0.5F, -46.0F, 1.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r2 = Lamp.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(12, 0).addBox(-1.925F, 0.0F, -0.1F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0998F, -46.0F, 1.9721F, 0.0F, -0.8727F, 0.0F));

        PartDefinition cube_r3 = Lamp.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(12, 2).addBox(-2.05F, 0.0F, -0.1F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0998F, -46.0F, 1.9721F, 0.0F, -2.3562F, 0.0F));

        PartDefinition Roof = model.addOrReplaceChild("Roof", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -38.0F, -10.0F, 24.0F, 6.0F, 24.0F, new CubeDeformation(0.0F))
                .texOffs(0, 57).addBox(-10.0F, -41.0F, -8.0F, 20.0F, 3.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Doors = model.addOrReplaceChild("Doors", CubeListBuilder.create().texOffs(82, 107).addBox(-8.0F, -33.0F, -8.0F, 8.0F, 30.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(60, 57).addBox(-9.0F, -43.0F, -7.0F, 18.0F, 2.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition door_r1 = Doors.addOrReplaceChild("door_r1", CubeListBuilder.create().texOffs(118, 107).addBox(-12.0F, -15.0F, 18.5F, 8.0F, 30.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(120, 0).addBox(-4.0F, -15.0F, 18.5F, 8.0F, 30.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.5F, -18.0F, -2.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition door_r2 = Doors.addOrReplaceChild("door_r2", CubeListBuilder.create().texOffs(30, 120).addBox(8.5F, -18.0F, 14.5F, 8.0F, 30.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(131, 76).addBox(0.5F, -18.0F, 14.5F, 8.0F, 30.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-24.5F, -15.0F, 10.5F, 0.0F, 1.5708F, 0.0F));

        PartDefinition pillars = model.addOrReplaceChild("pillars", CubeListBuilder.create().texOffs(0, 106).addBox(-11.0F, -39.0F, 10.0F, 3.0F, 37.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(70, 103).addBox(8.0F, -39.0F, 10.0F, 3.0F, 37.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(58, 103).addBox(8.0F, -39.0F, -9.0F, 3.0F, 37.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(46, 80).addBox(-11.0F, -39.0F, -9.0F, 3.0F, 37.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition left_door = model.addOrReplaceChild("left_door", CubeListBuilder.create().texOffs(114, 34).addBox(-8.5F, -15.0F, -1.0F, 8.0F, 30.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(8.5F, -18.0F, 12.0F));

        PartDefinition right_door = model.addOrReplaceChild("right_door", CubeListBuilder.create().texOffs(0, 6).addBox(6.5F, -4.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(100, 107).addBox(0.5F, -15.0F, -1.0F, 8.0F, 30.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.5F, -18.0F, 12.0F));
        splice(partdefinition);
        return LayerDefinition.create(meshdefinition, 256, 256);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        poseStack.pushPose();
        poseStack.mulPose(Vector3f.YP.rotationDegrees(180));
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
        this.right_door.yRot = open ? (float) Math.toRadians(75) : 0.0F;
        this.left_door.yRot = open ? (float) Math.toRadians(-75) : 0.0F;
    }

    @Override
    public void renderShell(GlobalShellBlockEntity entity, boolean open, boolean isBaseModel, PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
       /* poseStack.mulPose(Vector3f.YP.rotationDegrees(180));

        if(!isBaseModel){
        poseStack.translate(0.0, -0.07, 0.0);
}*/

        this.handleAllAnimations(entity, this.root(), isBaseModel, open, poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public boolean isDoorModel() {
        return false;
    }
}
