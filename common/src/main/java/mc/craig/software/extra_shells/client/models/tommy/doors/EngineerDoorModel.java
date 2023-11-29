package mc.craig.software.extra_shells.client.models.tommy.doors;

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

public class EngineerDoorModel extends ShellModel {
    private final ModelPart left_door;
    private final ModelPart right_door;
    private final ModelPart frame;
    private final ModelPart portal;
    private final ModelPart root;

    public EngineerDoorModel(ModelPart root) {
        super(root);
        this.root = root;
        this.left_door = root.getChild("left_door");
        this.right_door = root.getChild("right_door");
        this.frame = root.getChild("frame");
        this.portal = root.getChild("portal");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition right_door = partdefinition.addOrReplaceChild("right_door", CubeListBuilder.create(), PartPose.offset(-8.0F, 24.0F, 9.0F));

        PartDefinition cube_r1 = right_door.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(12, 0).addBox(0.0F, -20.0F, -9.025F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 4).addBox(1.0F, -23.0F, -11.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(48, 27).addBox(0.05F, -35.0F, -10.025F, 8.0F, 32.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 3.0F, -9.0F, -3.1416F, 0.0F, 3.1416F));

        PartDefinition left_door = partdefinition.addOrReplaceChild("left_door", CubeListBuilder.create(), PartPose.offset(8.0F, 24.0F, 9.0F));

        PartDefinition cube_r2 = left_door.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(16, 15).addBox(-7.0F, -25.0F, -8.5F, 4.0F, 4.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(92, 27).addBox(-1.0F, -35.0F, -9.0F, 0.0F, 32.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 19).addBox(-6.0F, -24.0F, -9.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-1.025F, -20.0F, -9.025F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(66, 27).addBox(-7.975F, -35.0F, -10.0F, 8.0F, 32.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 3.0F, -9.0F, -3.1416F, 0.0F, 3.1416F));

        PartDefinition frame = partdefinition.addOrReplaceChild("frame", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition roof = frame.addOrReplaceChild("roof", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r3 = roof.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 104).addBox(-10.0F, -41.0F, -10.0F, 20.0F, 3.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, -3.1416F, 0.0F, 3.1416F));

        PartDefinition signage = frame.addOrReplaceChild("signage", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 1.0F));

        PartDefinition cube_r4 = signage.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(48, 60).addBox(-9.0F, -38.0F, -12.0F, 18.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, -1.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r5 = signage.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(48, 60).addBox(-9.0F, -38.0F, -12.0F, 18.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, -1.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r6 = signage.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(48, 60).addBox(-9.0F, -38.0F, -12.0F, 18.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, -1.0F, -3.1416F, 0.0F, 3.1416F));

        PartDefinition cube_r7 = signage.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(48, 60).addBox(-9.0F, -37.975F, -11.0F, 18.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, -1.0F, 0.0F, 0.0F, 0.0F));

        PartDefinition posts = frame.addOrReplaceChild("posts", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r8 = posts.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(12, 27).addBox(7.975F, -40.0F, 7.975F, 3.0F, 37.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 67).addBox(8.0F, -40.0F, -11.0F, 3.0F, 37.0F, 3.0F, new CubeDeformation(0.3F))
                .texOffs(0, 27).addBox(8.0F, -40.0F, -11.0F, 3.0F, 37.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(36, 27).addBox(-10.975F, -40.0F, 7.975F, 3.0F, 37.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(24, 27).addBox(-11.0F, -40.0F, -11.0F, 3.0F, 37.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, -3.1416F, 0.0F, 3.1416F));

        PartDefinition cube_r9 = posts.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 67).addBox(8.0F, -40.0F, -11.0F, 3.0F, 37.0F, 3.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.0F));

        PartDefinition cube_r10 = posts.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 67).addBox(8.0F, -40.0F, -11.0F, 3.0F, 37.0F, 3.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r11 = posts.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 67).addBox(8.0F, -40.0F, -11.0F, 3.0F, 37.0F, 3.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition panels = frame.addOrReplaceChild("panels", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r12 = panels.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(60, 69).addBox(-8.0F, -35.0F, 9.0F, 16.0F, 32.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r13 = panels.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(94, 27).addBox(-8.0F, -35.0F, 9.0F, 16.0F, 32.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition portal = partdefinition.addOrReplaceChild("portal", CubeListBuilder.create().texOffs(27, 70).addBox(-8.0F, -32.0F, 10.9F, 16.0F, 32.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
        splice(partdefinition);
        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        left_door.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        right_door.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        frame.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        portal.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }

    public void setupAnim(Entity entity, float f, float g, float h, float i, float j) {
    }

    @Override
    public void setDoorOpen(boolean open) {
        this.right_door.yRot = open ? -275.0F : 0.0F;
    }

    public void renderShell(GlobalShellBlockEntity entity, boolean open, boolean isBaseModel, PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
    }

    public boolean isDoorModel() {
        return true;
    }
}
