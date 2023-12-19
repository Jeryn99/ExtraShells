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

public class RTDDoorModel extends ShellDoorModel {
    private final ModelPart left_door;
    private final ModelPart right_door;
    private final ModelPart frame;
    private final ModelPart bb_main;

    public RTDDoorModel(ModelPart root) {
        this.left_door = root.getChild("left_door");
        this.right_door = root.getChild("right_door");
        this.frame = root.getChild("frame");
        this.bb_main = root.getChild("bb_main");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition frame = partdefinition.addOrReplaceChild("frame", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition signage = frame.addOrReplaceChild("signage", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r1 = signage.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(54, 57).addBox(-9.0F, -36.0F, 7.0F, 18.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, -2.0F, 0.0F, 0.0F, 0.0F));

        PartDefinition posts = frame.addOrReplaceChild("posts", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r2 = posts.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(62, 99).addBox(8.0F, -37.0F, -11.0F, 3.0F, 34.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(50, 99).addBox(-11.0F, -37.0F, -11.0F, 3.0F, 34.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, -2.0F, -3.1416F, 0.0F, 3.1416F));

        PartDefinition panels = frame.addOrReplaceChild("panels", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition right_door = partdefinition.addOrReplaceChild("right_door", CubeListBuilder.create(), PartPose.offset(-8.0F, 24.0F, 7.0F));

        PartDefinition cube_r3 = right_door.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 18).addBox(0.0F, -19.0F, -9.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(98, 0).addBox(0.0F, -33.0F, -10.0F, 8.0F, 30.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(1.0F, -22.0F, -11.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 3.0F, -9.0F, -3.1416F, 0.0F, 3.1416F));

        PartDefinition left_door = partdefinition.addOrReplaceChild("left_door", CubeListBuilder.create(), PartPose.offset(8.0F, 24.0F, 7.0F));

        PartDefinition cube_r4 = left_door.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(16, 15).addBox(-7.0F, -24.0F, -8.5F, 4.0F, 4.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(12, 19).addBox(-6.0F, -23.0F, -9.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 5).addBox(-1.0F, -19.0F, -9.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(80, 26).addBox(-8.0F, -33.0F, -10.0F, 8.0F, 30.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 3.0F, -9.0F, -3.1416F, 0.0F, 3.1416F));

        PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(85, 109).addBox(-8.0F, -30.0F, 7.9F, 16.0F, 30.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 256, 256);
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
