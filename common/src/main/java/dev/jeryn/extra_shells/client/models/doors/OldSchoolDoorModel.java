package dev.jeryn.extra_shells.client.models.doors;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;
import whocraft.tardis_refined.client.model.blockentity.door.interior.ShellDoorModel;
import whocraft.tardis_refined.client.model.blockentity.shell.ShellModel;
import whocraft.tardis_refined.common.blockentity.door.GlobalDoorBlockEntity;
import whocraft.tardis_refined.common.blockentity.shell.GlobalShellBlockEntity;

public class OldSchoolDoorModel extends ShellDoorModel {

    private final ModelPart door;

    public OldSchoolDoorModel(ModelPart root) {
        this.door = root.getChild("door");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition door = partdefinition.addOrReplaceChild("door", CubeListBuilder.create().texOffs(1, 1).addBox(-0.152F, -16.0F, -3.1525F, 16.0F, 32.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.848F, 8.0F, 8.1525F));
        return LayerDefinition.create(meshdefinition, 100, 100);
    }

    @Override
    public void renderInteriorDoor(GlobalDoorBlockEntity doorBlockEntity, boolean open, boolean isBaseModel, PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        door.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart root() {
        return this.door;
    }

    @Override
    public void setDoorPosition(boolean open) {
        this.door.yRot = open ? (float) Math.toRadians(90) : 0.0F;
    }

}
