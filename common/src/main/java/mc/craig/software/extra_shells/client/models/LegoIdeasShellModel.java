package mc.craig.software.extra_shells.client.models;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;
import whocraft.tardis_refined.client.model.blockentity.shell.ShellModel;
import whocraft.tardis_refined.common.blockentity.shell.GlobalShellBlockEntity;

public class LegoIdeasShellModel extends ShellModel {

    private final ModelPart right_door;
    private final ModelPart left_door;
    private final ModelPart frame;
    private final ModelPart root;


    public LegoIdeasShellModel(ModelPart root) {
        super(root);
        this.frame = root.getChild("frame");
        this.right_door = root.getChild("right_door");
        this.left_door = root.getChild("left_door");
        this.root = root;
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition frame = partdefinition.addOrReplaceChild("frame", CubeListBuilder.create().texOffs(0, 0).addBox(-13.0F, -2.0F, -13.0F, 26.0F, 3.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 23.0F, 0.0F));

        PartDefinition lamp = frame.addOrReplaceChild("lamp", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -42.0F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));

        PartDefinition roof = frame.addOrReplaceChild("roof", CubeListBuilder.create().texOffs(0, 29).addBox(-11.0F, -37.0F, -11.0F, 22.0F, 3.0F, 22.0F, new CubeDeformation(0.0F))
                .texOffs(66, 29).addBox(-8.0F, -39.0F, -8.0F, 16.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition signage = frame.addOrReplaceChild("signage", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r1 = signage.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(78, 0).addBox(-11.0F, -32.0F, 11.0F, 22.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F));

        PartDefinition cube_r2 = signage.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(78, 0).addBox(-11.0F, -33.0F, 11.0F, 22.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r3 = signage.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(78, 0).addBox(-11.0F, -33.0F, 11.0F, 22.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r4 = signage.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(78, 0).addBox(-11.0F, -33.0F, 11.0F, 22.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition posts = frame.addOrReplaceChild("posts", CubeListBuilder.create().texOffs(54, 54).addBox(-12.0F, -30.0F, -11.0F, 24.0F, 28.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(54, 54).addBox(-12.0F, -30.0F, 8.0F, 24.0F, 28.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r5 = posts.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(54, 54).addBox(-12.0F, -13.0F, 8.0F, 24.0F, 28.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(54, 54).addBox(-12.0F, -13.0F, -11.0F, 24.0F, 28.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -17.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition panels = frame.addOrReplaceChild("panels", CubeListBuilder.create().texOffs(54, 87).addBox(-8.0F, -31.0F, 10.0F, 16.0F, 29.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(71, 87).addBox(-8.0F, -31.0F, -11.0F, 16.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(71, 114).addBox(-8.0F, -4.0F, -11.0F, 16.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r6 = panels.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(54, 87).addBox(-8.0F, -32.0F, 10.0F, 16.0F, 29.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r7 = panels.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(54, 87).addBox(-8.0F, -32.0F, 10.0F, 16.0F, 29.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition right_door = partdefinition.addOrReplaceChild("right_door", CubeListBuilder.create().texOffs(0, 98).addBox(-8.0F, -25.0F, -1.0F, 8.0F, 23.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 21.0F, -10.0F, 0.0F, -0.0873F, 0.0F));

        PartDefinition left_door = partdefinition.addOrReplaceChild("left_door", CubeListBuilder.create().texOffs(88, 91).addBox(0.0F, -25.0F, -1.0F, 8.0F, 23.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, 21.0F, -10.0F));

        PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 54).addBox(-8.5F, -32.05F, -10.0F, 17.0F, 29.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
        splice(partdefinition);
        return LayerDefinition.create(meshdefinition, 256, 256);
    }

    @Override
    public void setDoorPosition(boolean open) {
        this.right_door.yRot = open ? -275.0F : 0.0F;
        this.left_door.yRot = open ? 275.0F : 0.0F;
    }

    @Override
    public boolean isDoorModel() {
        return false;
    }

    @Override
    public void renderShell(GlobalShellBlockEntity entity, boolean open, boolean isBaseModel, PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.handleAllAnimations(entity, this.frame, isBaseModel, open, poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart root() {
        return root;
    }

    @Override
    public void setupAnim(Entity entity, float f, float g, float h, float i, float j) {

    }
}