package mc.craig.software.extra_shells.client.models.doors;

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

public class LegoIdeasDoorModel extends ShellModel {

    private final ModelPart left_door;
    private final ModelPart right_door;
    private final ModelPart model;
    private final ModelPart root;

    public LegoIdeasDoorModel(ModelPart root) {
        super(root);
        this.root = root;
        this.model = root.getChild("frame");
        this.right_door = root.getChild("right_door");
        this.left_door = root.getChild("left_door");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition frame = partdefinition.addOrReplaceChild("frame", CubeListBuilder.create(), PartPose.offset(0.0F, 23.0F, 0.0F));

        PartDefinition signage = frame.addOrReplaceChild("signage", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r1 = signage.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -39.0F, -9.0F, 24.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, -3.1416F, 0.0F, 3.1416F));

        PartDefinition posts = frame.addOrReplaceChild("posts", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r2 = posts.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 46).addBox(-9.0F, -2.025F, 6.0F, 18.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, -1.0F, 0.0F, 0.0F, 0.0F));

        PartDefinition cube_r3 = posts.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(40, 16).addBox(9.0F, -31.0F, -9.0F, 3.0F, 30.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(40, 16).addBox(-12.0F, -31.0F, -9.0F, 3.0F, 30.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, -1.0F, -3.1416F, 0.0F, 3.1416F));

        PartDefinition right_door = partdefinition.addOrReplaceChild("right_door", CubeListBuilder.create(), PartPose.offset(-9.0F, 8.0F, 6.0F));

        PartDefinition cube_r4 = right_door.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(20, 16).addBox(0.0F, -32.0F, -8.0F, 9.0F, 29.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 18.0F, -7.0F, -3.1416F, 0.0F, 3.1416F));

        PartDefinition left_door = partdefinition.addOrReplaceChild("left_door", CubeListBuilder.create(), PartPose.offset(9.0F, 8.0F, 6.0F));

        PartDefinition cube_r5 = left_door.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 16).addBox(-9.0F, -32.0F, -8.0F, 9.0F, 29.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 18.0F, -7.0F, -3.1416F, 0.0F, 3.1416F));
        splice(partdefinition);
        return LayerDefinition.create(meshdefinition, 128, 128);
    }


    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        root().render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
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

    public void renderShell(GlobalShellBlockEntity entity, boolean open, boolean isBaseModel, PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
    }

    public boolean isDoorModel() {
        return true;
    }
}
