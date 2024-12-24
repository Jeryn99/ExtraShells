package dev.jeryn.extra_shells.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.Entity;
import whocraft.tardis_refined.client.model.blockentity.shell.ShellModel;
import whocraft.tardis_refined.common.blockentity.shell.GlobalShellBlockEntity;

public class LegoPieceShellModel extends ShellModel {

    private final ModelPart root;
    private final ModelPart frame;
    private final ModelPart doorclosed;
    private final ModelPart dooropen;
    private final ModelPart portal;

    public LegoPieceShellModel(ModelPart root) {
        super(root);
        this.root = root;
        this.frame = root.getChild("frame");
        this.doorclosed = root.getChild("doorclosed");
        this.dooropen = root.getChild("dooropen");
        this.portal = root.getChild("portal");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        addMaterializationPart(partdefinition);

        PartDefinition frame = partdefinition.addOrReplaceChild("frame", CubeListBuilder.create().texOffs(0, 3).addBox(-1.0F, -22.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-4.0F, -21.0F, -4.0F, 8.0F, 17.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 28.0F, 0.0F));

        PartDefinition cube_r1 = frame.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 25).addBox(-4.0F, -19.0F, -5.9F, 8.0F, 15.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 0.1F, 0.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition cube_r2 = frame.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 25).addBox(-4.0F, -19.0F, -5.9F, 8.0F, 15.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 0.1F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r3 = frame.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(24, 0).addBox(-1.5F, 0.5F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -23.5F, 0.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r4 = frame.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 25).addBox(-4.0F, -19.0F, -5.9F, 8.0F, 15.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 0.1F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition doorclosed = partdefinition.addOrReplaceChild("doorclosed", CubeListBuilder.create().texOffs(20, 25).addBox(-4.0F, -19.0F, -5.9F, 8.0F, 15.0F, 2.0F, new CubeDeformation(-0.09F)), PartPose.offset(0.0F, 28.1F, 0.0F));

        PartDefinition dooropen = partdefinition.addOrReplaceChild("dooropen", CubeListBuilder.create().texOffs(20, 43).addBox(-4.0F, -14.9F, -5.9F, 8.0F, 15.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition portal = partdefinition.addOrReplaceChild("portal", CubeListBuilder.create().texOffs(56, 51).addBox(-0.925F, -12.85F, -5.875F, 3.0F, 12.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offset(0.0F, 24.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.doorclosed.visible = true;
        this.doorclosed.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        this.frame.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public ModelPart root() {
        return this.root;
    }

    public void setDoorPosition(boolean open) {
    }


    @Override
    public void renderShell(GlobalShellBlockEntity entity, boolean open, boolean isBaseModel, PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.handleAllAnimations(entity, this.root(), isBaseModel, open, poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        this.dooropen.visible = open;
        this.doorclosed.visible = !open;
        this.dooropen.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, this.getCurrentAlpha());
        this.doorclosed.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, this.getCurrentAlpha());
    }

    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }
}
