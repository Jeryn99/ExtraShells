package mc.craig.software.extra_shells.client.models.doors;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;
import whocraft.tardis_refined.client.model.blockentity.shell.ShellModel;
import whocraft.tardis_refined.common.blockentity.shell.GlobalShellBlockEntity;

public class SeaBlueDoorModel extends ShellModel {
    private final ModelPart left_door;
    private final ModelPart right_door;
    private final ModelPart frame;
    private final ModelPart bb_main;

    public SeaBlueDoorModel(ModelPart root) {
        super(root);
        this.left_door = root.getChild("left_door");
        this.right_door = root.getChild("right_door");
        this.frame = root.getChild("frame");
        this.bb_main = root.getChild("bb_main");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition right_door = partdefinition.addOrReplaceChild("right_door", CubeListBuilder.create(), PartPose.offset(-8.0F, 24.0F, 5.0F));

        PartDefinition cube_r1 = right_door.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(15, 0).addBox(0.0F, -20.0F, -5.025F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 6).addBox(1.0F, -23.0F, -7.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(68, 88).addBox(0.05F, -33.0F, -6.025F, 8.0F, 29.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 4.0F, -5.0F, -3.1416F, 0.0F, 3.1416F));

        PartDefinition left_door = partdefinition.addOrReplaceChild("left_door", CubeListBuilder.create(), PartPose.offset(8.0F, 24.0F, 5.0F));

        PartDefinition cube_r2 = left_door.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 31).addBox(-7.0F, -25.0F, -5.0F, 5.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(16, 15).addBox(-7.0F, -25.0F, -4.5F, 4.0F, 4.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(16, 19).addBox(-6.0F, -24.0F, -5.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-1.025F, -20.0F, -5.025F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(86, 88).addBox(-7.975F, -33.0F, -6.0F, 8.0F, 29.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 4.0F, -5.0F, -3.1416F, 0.0F, 3.1416F));

        PartDefinition frame = partdefinition.addOrReplaceChild("frame", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition signage = frame.addOrReplaceChild("signage", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 1.0F));

        PartDefinition cube_r3 = signage.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(12, 108).addBox(-12.0F, -38.0F, 4.075F, 24.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, -1.0F, 0.0F, 0.0F, 0.0F));

        PartDefinition posts = frame.addOrReplaceChild("posts", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r4 = posts.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(96, 0).addBox(8.0F, -39.0F, -8.0F, 3.0F, 35.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(106, 36).addBox(-11.0F, -39.0F, -8.0F, 3.0F, 35.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -3.1416F, 0.0F, 3.1416F));

        PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition portal_r1 = bb_main.addOrReplaceChild("portal_r1", CubeListBuilder.create().texOffs(88, 131).addBox(-8.0F, -33.0F, -7.9F, 16.0F, 29.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -3.1416F, 0.0F, 3.1416F));

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
    public void setDoorPosition(boolean open) {
        this.right_door.yRot = open ? (float) Math.toRadians(75) : 0.0F;
        this.left_door.yRot = open ? (float) -Math.toRadians(75) : 0.0F;
    }

    public void renderShell(GlobalShellBlockEntity entity, boolean open, boolean isBaseModel, PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
    }

    public boolean isDoorModel() {
        return true;
    }
}
