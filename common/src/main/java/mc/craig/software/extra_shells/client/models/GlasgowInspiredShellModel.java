package mc.craig.software.extra_shells.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;
import whocraft.tardis_refined.client.model.blockentity.shell.ShellModel;
import whocraft.tardis_refined.common.blockentity.shell.GlobalShellBlockEntity;

public class GlasgowInspiredShellModel extends ShellModel {

    private final ModelPart left_door;
    private final ModelPart right_door;
    private final ModelPart frame;
    private final ModelPart root;

    public GlasgowInspiredShellModel(ModelPart root) {
        super(root);
        this.left_door = root.getChild("left_door");
        this.right_door = root.getChild("right_door");
        this.frame = root.getChild("frame");
        this.root = root;
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition left_door = partdefinition.addOrReplaceChild("left_door", CubeListBuilder.create().texOffs(78, 84).addBox(0.0F, -17.0F, -2.0F, 9.0F, 34.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.5F, 5.0F, -9.0F));

        PartDefinition right_door = partdefinition.addOrReplaceChild("right_door", CubeListBuilder.create().texOffs(56, 84).addBox(-9.0F, -17.0F, -2.0F, 9.0F, 34.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(9.5F, 5.0F, -9.0F));

        PartDefinition frame = partdefinition.addOrReplaceChild("frame", CubeListBuilder.create().texOffs(0, 29).addBox(-11.5F, -42.0F, -11.5F, 24.0F, 6.0F, 24.0F, new CubeDeformation(0.0F))
                .texOffs(66, 59).addBox(-9.5F, -41.0F, -13.5F, 20.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 59).addBox(-10.5F, -45.0F, -10.5F, 22.0F, 3.0F, 22.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-1.5F, -50.0F, -1.5F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(40, 84).addBox(-12.5F, -43.0F, -12.5F, 4.0F, 41.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(40, 84).addBox(9.5F, -43.0F, -12.5F, 4.0F, 41.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(40, 84).addBox(9.5F, -43.0F, 9.5F, 4.0F, 41.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(40, 84).addBox(-12.5F, -43.0F, 9.5F, 4.0F, 41.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-13.0F, -2.0F, -13.0F, 27.0F, 2.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition Sign_r1 = frame.addOrReplaceChild("Sign_r1", CubeListBuilder.create().texOffs(66, 59).addBox(-10.5F, -41.0F, -14.5F, 20.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, 0.0F, 3.1416F));

        PartDefinition Sign_r2 = frame.addOrReplaceChild("Sign_r2", CubeListBuilder.create().texOffs(66, 59).addBox(-9.5F, -41.0F, -14.5F, 20.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition Sign_r3 = frame.addOrReplaceChild("Sign_r3", CubeListBuilder.create().texOffs(66, 59).addBox(-10.5F, -41.0F, -13.5F, 20.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition Wall_r1 = frame.addOrReplaceChild("Wall_r1", CubeListBuilder.create().texOffs(0, 84).addBox(-9.0F, -17.0F, -1.0F, 18.0F, 34.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -19.0F, 11.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition Wall_r2 = frame.addOrReplaceChild("Wall_r2", CubeListBuilder.create().texOffs(0, 84).addBox(1.5F, -17.0F, -11.5F, 18.0F, 34.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -19.0F, 11.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition Wall_r3 = frame.addOrReplaceChild("Wall_r3", CubeListBuilder.create().texOffs(0, 84).addBox(-9.0F, -17.0F, -1.0F, 18.0F, 34.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.0F, -19.0F, 0.5F, 0.0F, -1.5708F, 0.0F));
        addMaterializationPart(partdefinition);
        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.root().render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);

    }

    @Override
    public ModelPart root() {
        return this.root;
    }

    public void setupAnim(Entity entity, float f, float g, float h, float i, float j) {
    }

    @Override
    public void setDoorPosition(boolean open) {
        this.right_door.yRot = open ? -275.0F : 0.0F;
    }

    @Override
    public void renderShell(GlobalShellBlockEntity entity, boolean open, boolean isBaseModel, PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        if (isBaseModel) {
            poseStack.scale(1.05F, 1.05F, 1.05F);
            poseStack.translate(0.0, -0.07, 0.0);
        }
        this.handleAllAnimations(entity, this.root(), isBaseModel, open, poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public boolean isDoorModel() {
        return false;
    }
}
