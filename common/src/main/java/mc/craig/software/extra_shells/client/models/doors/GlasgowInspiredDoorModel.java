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

public class GlasgowInspiredDoorModel extends ShellDoorModel {
    private final ModelPart left_door;
    private final ModelPart right_door;
    private final ModelPart frame;
    private final ModelPart root;

    public GlasgowInspiredDoorModel(ModelPart root) {
        this.left_door = root.getChild("left_door");
        this.right_door = root.getChild("right_door");
        this.frame = root.getChild("frame");
        this.root = root;
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition frame = partdefinition.addOrReplaceChild("frame", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition Pillar_r1 = frame.addOrReplaceChild("Pillar_r1", CubeListBuilder.create().texOffs(0, 9).addBox(-12.5F, -43.0F, -12.5F, 4.0F, 41.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 9).addBox(9.5F, -43.0F, -12.5F, 4.0F, 41.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-11.5F, -42.0F, -11.8F, 24.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 2.0F, -4.5F, -3.1416F, 0.0F, 3.1416F));

        PartDefinition left_door = partdefinition.addOrReplaceChild("left_door", CubeListBuilder.create(), PartPose.offset(9.0F, 5.0F, 4.5F));

        PartDefinition Door_r1 = left_door.addOrReplaceChild("Door_r1", CubeListBuilder.create().texOffs(38, 9).addBox(-17.0F, -17.0F, -22.0F, 9.0F, 34.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.0F, 2.0F, -20.0F, -3.1416F, 0.0F, 3.1416F));

        PartDefinition right_door = partdefinition.addOrReplaceChild("right_door", CubeListBuilder.create(), PartPose.offset(-9.0F, 5.0F, 4.5F));

        PartDefinition Door_r2 = right_door.addOrReplaceChild("Door_r2", CubeListBuilder.create().texOffs(16, 9).addBox(10.0F, -17.0F, -22.0F, 9.0F, 34.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(19.0F, 2.0F, -20.0F, -3.1416F, 0.0F, 3.1416F));
        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void renderInteriorDoor(GlobalDoorBlockEntity doorBlockEntity, boolean open, boolean isBaseModel, PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        left_door.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        right_door.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        frame.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public ModelPart root() {
        return this.root;
    }

    @Override
    public void setDoorPosition(boolean open) {
        this.right_door.yRot = open ? -275.0F : 0.0F;
    }
}
