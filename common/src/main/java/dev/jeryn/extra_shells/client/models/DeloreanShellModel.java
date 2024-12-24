package dev.jeryn.extra_shells.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import dev.jeryn.frame.tardis.Frame;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;
import whocraft.tardis_refined.client.model.blockentity.shell.ShellModel;
import whocraft.tardis_refined.common.blockentity.shell.GlobalShellBlockEntity;

public class DeloreanShellModel extends ShellModel {

    private final ModelPart left_door;
    private final ModelPart right_door;
    private final ModelPart root;
    private final ModelPart fade;

    public DeloreanShellModel(ModelPart root) {
        super(root);
        this.root = root;
        this.left_door = Frame.findPart(this, "left_door");
        this.right_door = Frame.findPart(this, "right_door");
        this.fade = Frame.findPart(this, "fade_value");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bone4 = partdefinition.addOrReplaceChild("bone4", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
        addMaterializationPart(partdefinition);

        PartDefinition techshit = bone4.addOrReplaceChild("techshit", CubeListBuilder.create().texOffs(135, 156).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(163, 92).addBox(-6.0F, -2.0F, -9.0F, 12.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 58).addBox(-3.0F, -6.0F, -12.0F, 6.0F, 11.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(111, 122).addBox(-2.5F, -5.5F, -15.75F, 5.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 23).mirror().addBox(2.15F, -4.75F, -15.5F, 11.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 23).addBox(-13.15F, -4.75F, -15.5F, 11.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(111, 129).mirror().addBox(-9.0F, -4.0F, -11.5F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(111, 129).addBox(3.0F, -4.0F, -11.5F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 121).addBox(12.25F, 2.0F, -11.5F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(0, 109).addBox(-15.35F, 1.0F, -11.5F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(77, 68).addBox(-12.1F, -1.0F, -11.0F, 1.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 82).addBox(13.25F, -1.0F, -11.0F, 1.0F, 3.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 93).addBox(14.5F, 2.25F, -11.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 73).addBox(-5.0F, -4.5F, -7.0F, 10.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 49).addBox(-5.0F, 2.0F, 5.0F, 10.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(93, 122).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -16.8792F, 27.0457F));

        PartDefinition cube_r1 = techshit.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(58, 132).addBox(-4.0F, -0.5F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r2 = techshit.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(27, 110).addBox(-5.0F, 0.0F, -7.0F, 18.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.25F, -1.0F, -0.3491F, 0.0F, 0.0F));

        PartDefinition bone51 = techshit.addOrReplaceChild("bone51", CubeListBuilder.create().texOffs(14, 0).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.85F, 2.5F, -1.5F, 0.0F, 0.48F, 0.4363F));

        PartDefinition bone50 = techshit.addOrReplaceChild("bone50", CubeListBuilder.create().texOffs(74, 88).mirror().addBox(-2.5F, 0.0F, -3.0F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.5F, 1.0F, 1.0F));

        PartDefinition cube_r3 = bone50.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(159, 161).mirror().addBox(-3.5F, 0.0F, 0.0F, 6.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.3491F, 0.0F, 0.0F));

        PartDefinition bone49 = techshit.addOrReplaceChild("bone49", CubeListBuilder.create().texOffs(74, 88).addBox(-1.5F, 0.0F, -3.0F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(7.5F, 1.0F, 1.0F));

        PartDefinition cube_r4 = bone49.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(159, 161).addBox(-2.5F, 0.0F, 0.0F, 6.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.3491F, 0.0F, 0.0F));

        PartDefinition basecar = bone4.addOrReplaceChild("basecar", CubeListBuilder.create().texOffs(86, 31).addBox(-12.0F, 6.0F, -16.0F, 25.0F, 1.0F, 20.0F, new CubeDeformation(0.0F))
                .texOffs(103, 52).addBox(-14.5F, 4.0F, 3.425F, 30.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -10.0F, -19.0F));

        PartDefinition cube_r5 = basecar.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(115, 150).addBox(-12.5F, -4.0F, 0.0F, 25.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 7.0F, -16.0F, 0.6981F, 0.0F, 0.0F));

        PartDefinition cube_r6 = basecar.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 141).mirror().addBox(0.0F, -4.0F, -13.0F, 2.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-12.0F, 7.0F, -3.0F, 0.0F, 0.0F, -0.4363F));

        PartDefinition cube_r7 = basecar.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 141).addBox(-2.0F, -4.0F, -13.0F, 2.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.0F, 7.0F, -3.0F, 0.0F, 0.0F, 0.4363F));

        PartDefinition top = basecar.addOrReplaceChild("top", CubeListBuilder.create().texOffs(89, 26).addBox(-11.5F, -8.8207F, 16.0457F, 24.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(27, 126).addBox(-12.0F, -9.8207F, 29.0457F, 25.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));

        PartDefinition cube_r8 = top.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(32, 154).addBox(-5.0F, 0.0F, -12.0F, 10.0F, 1.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -9.8207F, 29.0457F, 0.0873F, 0.0F, 0.0F));

        PartDefinition cube_r9 = top.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(142, 119).addBox(-13.0F, 0.0F, 0.0F, 27.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.5F, -15.0F, -0.6109F, 0.0F, 0.0F));

        PartDefinition cube_r10 = top.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 58).addBox(-13.0F, 0.0F, 0.0F, 27.0F, 1.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.5F, -15.0F, 0.0873F, 0.0F, 0.0F));

        PartDefinition bone2 = top.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.0F, -1.5F, -16.0F, 0.0873F, 0.0F, 0.0F));

        PartDefinition cube_r11 = bone2.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(62, 171).addBox(-3.474F, 6.2886F, 0.0218F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(61, 181).addBox(-3.474F, 0.5386F, 0.0218F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(16.0F, 0.0F, 23.0F, 0.0F, 0.0F, -0.4189F));

        PartDefinition cube_r12 = bone2.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 109).addBox(-1.0218F, 0.0844F, 0.9962F, 1.0F, 7.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(16.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2531F));

        PartDefinition bone3 = top.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, -1.5F, -16.0F, 0.0873F, 0.0F, 0.0F));

        PartDefinition cube_r13 = bone3.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(62, 171).mirror().addBox(0.474F, 6.2886F, 0.0218F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(61, 181).mirror().addBox(0.474F, 0.5386F, 0.0218F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-16.0F, 0.0F, 23.0F, 0.0F, 0.0F, 0.4189F));

        PartDefinition cube_r14 = bone3.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 109).mirror().addBox(0.0218F, 0.0844F, 0.9962F, 1.0F, 7.0F, 25.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-16.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2531F));

        PartDefinition bone5 = top.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(11, 37).addBox(0.0F, 0.0F, 0.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(11, 37).addBox(25.0F, 0.0F, 0.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(77, 110).addBox(2.0F, 0.25F, 0.0F, 23.0F, 1.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.0F, -3.4042F, 7.1321F, 0.5236F, 0.0F, 0.0F));

        PartDefinition cube_r15 = bone5.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(77, 58).addBox(-2.0F, 0.0F, 0.0F, 2.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(27.0F, 0.0F, 2.0F, 0.0F, -0.1745F, 0.0F));

        PartDefinition cube_r16 = bone5.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(77, 58).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, 0.0F, 0.1745F, 0.0F));

        PartDefinition bone10 = top.addOrReplaceChild("bone10", CubeListBuilder.create().texOffs(24, 141).addBox(0.0F, 0.0F, -1.5F, 9.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(134, 115).addBox(-0.2F, -0.8F, 0.0F, 10.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(11, 31).addBox(8.1F, 0.0F, -1.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.0F, -9.8207F, 30.5457F, 0.0F, 0.0F, 1.0559F));

        PartDefinition bone38 = top.addOrReplaceChild("bone38", CubeListBuilder.create().texOffs(24, 141).mirror().addBox(-9.0F, 0.0F, -1.5F, 9.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(134, 115).mirror().addBox(-9.8F, -0.8F, 0.0F, 10.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(11, 31).mirror().addBox(-9.1F, 0.0F, -1.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-12.0F, -9.8207F, 30.5457F, 0.0F, 0.0F, -1.0559F));

        PartDefinition bone12 = top.addOrReplaceChild("bone12", CubeListBuilder.create().texOffs(31, 132).addBox(-3.0F, 0.0F, 0.0F, 3.0F, 1.0F, 21.0F, new CubeDeformation(0.0F))
                .texOffs(31, 132).mirror().addBox(-25.0F, 0.0F, 0.0F, 3.0F, 1.0F, 21.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(73, 88).addBox(-22.0F, 0.0F, 0.0F, 19.0F, 1.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.0F, -9.8207F, 34.0457F, -0.3927F, 0.0F, 0.0F));

        PartDefinition cube_r17 = bone12.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(147, 14).mirror().addBox(-7.9324F, 1.3237F, -15.75F, 8.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(113, 122).mirror().addBox(-4.0F, 0.0F, -16.0F, 4.0F, 1.0F, 21.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-25.0F, 0.0F, 16.0F, 0.0F, 0.0F, -0.829F));

        PartDefinition cube_r18 = bone12.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(147, 14).addBox(-0.0676F, 1.3237F, -15.75F, 8.0F, 1.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(113, 122).addBox(0.0F, 0.0F, -16.0F, 4.0F, 1.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 16.0F, 0.0F, 0.0F, 0.829F));

        PartDefinition bone = basecar.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 0).addBox(-14.5F, 2.0958F, -18.8679F, 30.0F, 2.0F, 29.0F, new CubeDeformation(0.0F))
                .texOffs(86, 40).addBox(13.5F, 0.5958F, -15.8679F, 3.0F, 4.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(86, 40).mirror().addBox(-15.5F, 0.5958F, -15.8679F, 3.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(89, 0).addBox(-16.5F, -2.9042F, 28.9552F, 34.0F, 8.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(17.5F, -2.6792F, 30.4552F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).mirror().addBox(-17.5F, -2.6792F, 30.4552F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(89, 14).addBox(-15.5F, -9.9042F, 29.0707F, 32.0F, 7.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(53, 233).addBox(-3.5F, -8.9042F, 27.0707F, 8.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 31).addBox(-15.0F, 5.0F, 9.0F, 31.0F, 3.0F, 24.0F, new CubeDeformation(0.0F))
                .texOffs(0, 210).addBox(-3.5F, 1.0F, 10.0F, 6.0F, 4.0F, 19.0F, new CubeDeformation(0.0F))
                .texOffs(32, 206).addBox(-5.5F, -3.75F, 9.0F, 10.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(35, 198).addBox(-9.5F, -4.75F, 10.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(53, 221).addBox(4.5F, -4.0F, 8.5F, 7.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(62, 209).addBox(7.5F, -3.0F, 12.4F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(1, 210).addBox(-2.5F, -2.0F, 18.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(33, 220).addBox(-2.5F, 0.5F, 13.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 237).addBox(-3.5F, -1.0F, 22.0F, 6.0F, 2.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(80, 62).addBox(-13.5F, -2.8792F, 35.0457F, 28.0F, 6.0F, 20.0F, new CubeDeformation(0.0F))
                .texOffs(132, 88).addBox(-13.0F, 2.3708F, 51.9957F, 27.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r19 = bone.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(64, 153).mirror().addBox(0.0F, -1.0F, -0.7F, 2.0F, 2.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-14.5F, 3.0958F, -4.8679F, 0.0F, -0.0829F, 0.0F));

        PartDefinition cube_r20 = bone.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(64, 153).addBox(-2.0F, -1.0F, -0.7F, 2.0F, 2.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.5F, 3.0958F, -4.8679F, 0.0F, 0.0829F, 0.0F));

        PartDefinition cube_r21 = bone.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(0, 82).addBox(-13.0F, -7.0F, 4.0F, 27.0F, 7.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0958F, 28.9552F, 0.0873F, 0.0F, 0.0F));

        PartDefinition bone20 = bone.addOrReplaceChild("bone20", CubeListBuilder.create().texOffs(86, 31).addBox(12.5F, 4.0F, 10.0F, 2.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, -5.0F, -14.8679F));

        PartDefinition bone18 = bone20.addOrReplaceChild("bone18", CubeListBuilder.create().texOffs(87, 68).addBox(-1.0F, 0.0F, -4.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.5F, 4.0F, 10.0F, 0.7854F, 0.0F, 0.0F));

        PartDefinition bone19 = bone20.addOrReplaceChild("bone19", CubeListBuilder.create().texOffs(14, 7).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.5F, 4.0F, 18.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition bone30 = bone.addOrReplaceChild("bone30", CubeListBuilder.create().texOffs(86, 31).mirror().addBox(-14.5F, 4.0F, 10.0F, 2.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-0.5F, -5.0F, -14.8679F));

        PartDefinition bone31 = bone30.addOrReplaceChild("bone31", CubeListBuilder.create().texOffs(87, 68).mirror().addBox(-1.0F, 0.0F, -4.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-13.5F, 4.0F, 10.0F, 0.7854F, 0.0F, 0.0F));

        PartDefinition bone32 = bone30.addOrReplaceChild("bone32", CubeListBuilder.create().texOffs(14, 7).mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-13.5F, 4.0F, 18.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition bone21 = bone.addOrReplaceChild("bone21", CubeListBuilder.create().texOffs(86, 31).addBox(12.5F, 4.0F, 10.0F, 2.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5F, -5.0F, 25.1321F));

        PartDefinition bone22 = bone21.addOrReplaceChild("bone22", CubeListBuilder.create().texOffs(87, 68).addBox(-1.0F, 0.0F, -4.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.5F, 4.0F, 10.0F, 0.7854F, 0.0F, 0.0F));

        PartDefinition bone23 = bone21.addOrReplaceChild("bone23", CubeListBuilder.create().texOffs(14, 7).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.5F, 4.0F, 18.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition bone39 = bone.addOrReplaceChild("bone39", CubeListBuilder.create().texOffs(86, 31).mirror().addBox(-14.5F, 4.0F, 10.0F, 2.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.5F, -5.0F, 25.1321F));

        PartDefinition bone40 = bone39.addOrReplaceChild("bone40", CubeListBuilder.create().texOffs(87, 68).mirror().addBox(-1.0F, 0.0F, -4.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-13.5F, 4.0F, 10.0F, 0.7854F, 0.0F, 0.0F));

        PartDefinition bone41 = bone39.addOrReplaceChild("bone41", CubeListBuilder.create().texOffs(14, 7).mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-13.5F, 4.0F, 18.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition bone11 = bone.addOrReplaceChild("bone11", CubeListBuilder.create().texOffs(135, 92).addBox(-5.0F, -2.5F, 0.0F, 5.0F, 5.0F, 18.0F, new CubeDeformation(0.0F))
                .texOffs(93, 122).addBox(0.075F, -2.275F, 0.325F, 1.0F, 3.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(27, 109).addBox(-0.925F, -2.275F, 16.325F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(17.5F, -0.4042F, 34.9552F, 0.0F, -0.1745F, 0.0F));

        PartDefinition bone13 = bone.addOrReplaceChild("bone13", CubeListBuilder.create().texOffs(135, 92).mirror().addBox(0.0F, -2.5F, 0.0F, 5.0F, 5.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(93, 122).mirror().addBox(-1.075F, -2.275F, 0.325F, 1.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(27, 109).mirror().addBox(-1.075F, -2.275F, 16.325F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-16.5F, -0.4042F, 34.9552F, 0.0F, 0.1745F, 0.0F));

        PartDefinition bone57 = bone.addOrReplaceChild("bone57", CubeListBuilder.create(), PartPose.offsetAndRotation(8.0F, -2.5F, 13.5F, 0.5236F, 0.0F, 0.0F));

        PartDefinition bone58 = bone57.addOrReplaceChild("bone58", CubeListBuilder.create().texOffs(61, 214).addBox(-2.5F, -2.5F, -0.5F, 5.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.48F));

        PartDefinition bone54 = bone.addOrReplaceChild("bone54", CubeListBuilder.create().texOffs(32, 215).addBox(-1.0F, -3.5F, -0.5F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(32, 219).addBox(-0.5F, -2.5F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.5F, 14.5F, -0.6545F, 0.0F, 0.0F));

        PartDefinition bone53 = bone.addOrReplaceChild("bone53", CubeListBuilder.create().texOffs(1, 219).addBox(-1.0F, -1.5F, -1.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -3.0F, 20.0F, 0.0F, -0.5672F, 0.0F));

        PartDefinition bone55 = bone.addOrReplaceChild("bone55", CubeListBuilder.create().texOffs(0, 183).addBox(-5.0F, -2.0F, -9.0F, 10.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 5.0F, 24.0F));

        PartDefinition cube_r22 = bone55.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(0, 196).addBox(-5.0F, -11.0F, -2.0F, 10.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

        PartDefinition bone56 = bone.addOrReplaceChild("bone56", CubeListBuilder.create().texOffs(0, 183).mirror().addBox(-5.0F, -2.0F, -9.0F, 10.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, 5.0F, 24.0F));

        PartDefinition cube_r23 = bone56.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(0, 196).mirror().addBox(-5.0F, -11.0F, -2.0F, 10.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

        PartDefinition bone52 = basecar.addOrReplaceChild("bone52", CubeListBuilder.create().texOffs(0, 169).addBox(-13.0F, 0.0F, -4.0F, 26.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -3.25F, 12.425F, -0.2618F, 0.0F, 0.0F));

        PartDefinition right_door = bone4.addOrReplaceChild("right_door", CubeListBuilder.create().texOffs(156, 62).mirror().addBox(-8.0F, 0.0F, -1.7F, 8.0F, 1.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(143, 128).mirror().addBox(-12.25F, 10.0F, -10.7905F, 2.0F, 2.0F, 20.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.25F, -19.8207F, 0.7457F));

        PartDefinition cube_r24 = right_door.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(93, 144).mirror().addBox(0.0F, 0.0F, -6.0905F, 1.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-12.25F, 12.0F, -4.7F, 0.0F, 0.0F, -0.3054F));

        PartDefinition bone47 = right_door.addOrReplaceChild("bone47", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, -6.525F, 1.0F, 11.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(71, 121).mirror().addBox(-0.05F, 0.0F, -14.5F, 1.0F, 11.0F, 20.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.0F, 0.0F, 3.8F, 0.0F, 0.0F, 0.3491F));

        PartDefinition cube_r25 = bone47.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(77, 68).mirror().addBox(-0.525F, 0.0F, 0.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.5F, 4.8357F, -14.0905F, -0.0873F, 0.0F, 0.0F));

        PartDefinition cube_r26 = bone47.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(0, 31).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, -6.5F, -1.0036F, 0.0F, 0.0F));

        PartDefinition bone48 = bone47.addOrReplaceChild("bone48", CubeListBuilder.create().texOffs(0, 31).mirror().addBox(-0.525F, -3.0F, -2.5F, 1.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.5F, 7.8357F, -11.5905F));

        PartDefinition left_door = bone4.addOrReplaceChild("left_door", CubeListBuilder.create().texOffs(156, 62).addBox(0.0F, 0.0F, -1.7F, 8.0F, 1.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(143, 128).addBox(10.25F, 10.0F, -10.7905F, 2.0F, 2.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(4.25F, -19.8207F, 0.7457F));

        PartDefinition cube_r27 = left_door.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(93, 144).addBox(-1.0F, 0.0F, -6.0905F, 1.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.25F, 12.0F, -4.7F, 0.0F, 0.0F, 0.3054F));

        PartDefinition bone6 = left_door.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, -6.525F, 1.0F, 11.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(71, 121).addBox(-0.95F, 0.0F, -14.5F, 1.0F, 11.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, 3.8F, 0.0F, 0.0F, -0.3491F));

        PartDefinition cube_r28 = bone6.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(77, 68).addBox(-1.475F, 0.0F, 0.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 4.8357F, -14.0905F, -0.0873F, 0.0F, 0.0F));

        PartDefinition cube_r29 = bone6.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(0, 31).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -6.5F, -1.0036F, 0.0F, 0.0F));

        PartDefinition bone8 = bone6.addOrReplaceChild("bone8", CubeListBuilder.create().texOffs(0, 31).addBox(-0.475F, -3.0F, -2.5F, 1.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 7.8357F, -11.5905F));

        PartDefinition rear_r = bone4.addOrReplaceChild("rear_r", CubeListBuilder.create().texOffs(156, 31).mirror().addBox(-3.0F, -5.0F, -5.0F, 6.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-15.0F, -5.0F, 20.1321F));

        PartDefinition bone43 = rear_r.addOrReplaceChild("bone43", CubeListBuilder.create().texOffs(142, 128).mirror().addBox(-1.975F, 0.0F, -3.0F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 141).mirror().addBox(-1.975F, 0.0F, -4.2426F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, -2.0F, 5.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition bone44 = rear_r.addOrReplaceChild("bone44", CubeListBuilder.create().texOffs(142, 128).mirror().addBox(-1.975F, 0.0F, -3.0F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 141).mirror().addBox(-1.975F, 0.0F, -4.2426F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, -5.0F, -2.0F, 0.7854F, 0.0F, 0.0F));

        PartDefinition bone45 = rear_r.addOrReplaceChild("bone45", CubeListBuilder.create().texOffs(132, 98).mirror().addBox(-1.975F, -3.0F, 1.25F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(132, 92).mirror().addBox(-1.975F, -3.0F, 0.0074F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 2.0F, -5.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition bone46 = rear_r.addOrReplaceChild("bone46", CubeListBuilder.create().texOffs(132, 98).addBox(-1.975F, -3.0F, -3.0F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(132, 92).addBox(-1.975F, -3.0F, -4.2426F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 2.0F, 5.0F, 0.7854F, 0.0F, 0.0F));

        PartDefinition rear_l = bone4.addOrReplaceChild("rear_l", CubeListBuilder.create().texOffs(156, 31).addBox(-3.0F, -5.0F, -5.0F, 6.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(15.0F, -5.0F, 20.1321F));

        PartDefinition bone26 = rear_l.addOrReplaceChild("bone26", CubeListBuilder.create().texOffs(142, 128).addBox(-4.025F, 0.0F, -3.0F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 141).addBox(-4.025F, 0.0F, -4.2426F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -2.0F, 5.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition bone27 = rear_l.addOrReplaceChild("bone27", CubeListBuilder.create().texOffs(142, 128).addBox(-4.025F, 0.0F, -3.0F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 141).addBox(-4.025F, 0.0F, -4.2426F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -5.0F, -2.0F, 0.7854F, 0.0F, 0.0F));

        PartDefinition bone28 = rear_l.addOrReplaceChild("bone28", CubeListBuilder.create().texOffs(132, 98).addBox(-4.025F, -3.0F, 1.25F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(132, 92).addBox(-4.025F, -3.0F, 0.0074F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 2.0F, -5.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition bone29 = rear_l.addOrReplaceChild("bone29", CubeListBuilder.create().texOffs(132, 98).mirror().addBox(-4.025F, -3.0F, -3.0F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(132, 92).mirror().addBox(-4.025F, -3.0F, -4.2426F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 2.0F, 5.0F, 0.7854F, 0.0F, 0.0F));

        PartDefinition front_r = bone4.addOrReplaceChild("front_r", CubeListBuilder.create().texOffs(156, 31).mirror().addBox(-3.0F, -5.0F, -5.0F, 6.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-13.0F, -5.0F, -19.8679F));

        PartDefinition bone34 = front_r.addOrReplaceChild("bone34", CubeListBuilder.create().texOffs(142, 128).mirror().addBox(-1.975F, 0.0F, -3.0F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 141).mirror().addBox(-1.975F, 0.0F, -4.2426F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, -2.0F, 5.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition bone35 = front_r.addOrReplaceChild("bone35", CubeListBuilder.create().texOffs(142, 128).mirror().addBox(-1.975F, 0.0F, -3.0F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 141).mirror().addBox(-1.975F, 0.0F, -4.2426F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, -5.0F, -2.0F, 0.7854F, 0.0F, 0.0F));

        PartDefinition bone36 = front_r.addOrReplaceChild("bone36", CubeListBuilder.create().texOffs(132, 98).mirror().addBox(-1.975F, -3.0F, 1.25F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(132, 92).mirror().addBox(-1.975F, -3.0F, 0.0074F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 2.0F, -5.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition bone37 = front_r.addOrReplaceChild("bone37", CubeListBuilder.create().texOffs(132, 98).addBox(-1.975F, -3.0F, -3.0F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(132, 92).addBox(-1.975F, -3.0F, -4.2426F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 2.0F, 5.0F, 0.7854F, 0.0F, 0.0F));

        PartDefinition front_l = bone4.addOrReplaceChild("front_l", CubeListBuilder.create().texOffs(156, 31).addBox(-3.0F, -5.0F, -5.0F, 6.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(13.0F, -5.0F, -19.8679F));

        PartDefinition bone14 = front_l.addOrReplaceChild("bone14", CubeListBuilder.create().texOffs(142, 128).addBox(-4.025F, 0.0F, -3.0F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 141).addBox(-4.025F, 0.0F, -4.2426F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -2.0F, 5.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition bone15 = front_l.addOrReplaceChild("bone15", CubeListBuilder.create().texOffs(142, 128).addBox(-4.025F, 0.0F, -3.0F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 141).addBox(-4.025F, 0.0F, -4.2426F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -5.0F, -2.0F, 0.7854F, 0.0F, 0.0F));

        PartDefinition bone16 = front_l.addOrReplaceChild("bone16", CubeListBuilder.create().texOffs(132, 98).addBox(-4.025F, -3.0F, 1.25F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(132, 92).addBox(-4.025F, -3.0F, 0.0074F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 2.0F, -5.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition bone17 = front_l.addOrReplaceChild("bone17", CubeListBuilder.create().texOffs(132, 98).mirror().addBox(-4.025F, -3.0F, -3.0F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(132, 92).mirror().addBox(-4.025F, -3.0F, -4.2426F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 2.0F, 5.0F, 0.7854F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 256, 256);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(180));
        poseStack.mulPose(Axis.YN.rotationDegrees(90));
        this.root().render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        poseStack.popPose();
    }

    @Override
    public ModelPart root() {
        return this.root;
    }

    public void setupAnim(Entity entity, float f, float g, float h, float i, float j) {
    }

    @Override
    public void setDoorPosition(boolean open) {
        this.right_door.zRot = open ? (float) Math.toRadians(90) : 0.0F;
       // this.left_door.zRot = open ? (float) Math.toRadians(-90) : 0.0F;
    }

    @Override
    public void renderShell(GlobalShellBlockEntity entity, boolean open, boolean isBaseModel, PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        fade.visible = false;
        poseStack.mulPose(Axis.YN.rotationDegrees(90));
        this.handleAllAnimations(entity, this.root(), isBaseModel, open, poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

}
