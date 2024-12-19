package dev.jeryn.extra_shells.client.models.doors.lego;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import whocraft.tardis_refined.client.model.blockentity.door.interior.ShellDoorModel;
import whocraft.tardis_refined.common.blockentity.door.GlobalDoorBlockEntity;

public class LegoPieceDoors extends ShellDoorModel {

    private final ModelPart opened_doors;
    private final ModelPart closed_doors;
    private final ModelPart root;
    private boolean isOpen = false;

    public LegoPieceDoors(ModelPart root) {
        this.root = root;
        this.opened_doors = root.getChild("dooropen");
        this.closed_doors = root.getChild("doorclosed");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition doorclosed = partdefinition.addOrReplaceChild("doorclosed", CubeListBuilder.create().texOffs(0, 43).addBox(-4.0F, -19.0F, -7.9F, 8.0F, 15.0F, 2.0F, new CubeDeformation(-0.09F)), PartPose.offsetAndRotation(0.0F, 28.1F, 0.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition dooropen = partdefinition.addOrReplaceChild("dooropen", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition doorsopen_r1 = dooropen.addOrReplaceChild("doorsopen_r1", CubeListBuilder.create().texOffs(44, 0).addBox(-4.0F, -19.0F, -7.9F, 8.0F, 15.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 4.1F, 0.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(56, 51).addBox(-2.075F, -12.85F, 5.925F, 3.0F, 12.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void renderFrame(GlobalDoorBlockEntity doorBlockEntity, boolean open, boolean isBaseModel, PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        if (this.isOpen) {
            this.opened_doors.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        } else {
            this.closed_doors.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        }
    }

    @Override
    public void renderPortalMask(GlobalDoorBlockEntity globalDoorBlockEntity, boolean b, boolean b1, PoseStack poseStack, VertexConsumer vertexConsumer, int i, int i1, float v, float v1, float v2, float v3) {

    }

    @Override
    public ModelPart root() {
        return this.root;
    }

    @Override
    public void setDoorPosition(boolean open) {
       isOpen = open;
    }
}
