package mc.craig.software.extra_shells.client.models.tommy.doors;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;
import whocraft.tardis_refined.client.model.blockentity.shell.ShellModel;
import whocraft.tardis_refined.common.blockentity.shell.GlobalShellBlockEntity;

public class GlasgowInspiredDoorModel extends ShellModel {
    private final ModelPart left_door;
    private final ModelPart right_door;
    private final ModelPart frame;
    private final ModelPart root;

    public GlasgowInspiredDoorModel(ModelPart root) {
        super(root);
        ModelPart fullModel = root.getChild("full_model");
        this.left_door = fullModel.getChild("left_door");
        this.right_door = fullModel.getChild("right_door");
        this.frame = fullModel.getChild("shell");
        this.root = root;
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition full_model = partdefinition.addOrReplaceChild("full_model", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 24.0F, -3.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition left_door = full_model.addOrReplaceChild("left_door", CubeListBuilder.create().texOffs(222, 82).addBox(-8.0F, -34.0F, -11.0F, 9.0F, 34.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 0.0F, 0.0F));

        PartDefinition shell = full_model.addOrReplaceChild("shell", CubeListBuilder.create().texOffs(18, 63).addBox(-11.5F, -40.0F, -11.8F, 24.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 101).addBox(-12.5F, -41.0F, -12.5F, 4.0F, 41.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 101).addBox(9.5F, -41.0F, -12.5F, 4.0F, 41.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition right_door = full_model.addOrReplaceChild("right_door", CubeListBuilder.create().texOffs(106, 92).addBox(-9.0F, -17.0F, 0.0F, 9.0F, 34.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(9.5F, -17.0F, -11.0F));
        splice(partdefinition);
        return LayerDefinition.create(meshdefinition, 244, 244);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        left_door.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        right_door.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        frame.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

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
