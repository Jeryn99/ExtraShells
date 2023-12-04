package mc.craig.software.extra_shells.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import mc.craig.software.extra_shells.ESModelRegistry;
import mc.craig.software.extra_shells.TEShellThemes;
import mc.craig.software.extra_shells.client.models.doors.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import whocraft.tardis_refined.client.TardisClientData;
import whocraft.tardis_refined.client.model.blockentity.shell.ShellModel;
import whocraft.tardis_refined.common.block.door.GlobalDoorBlock;
import whocraft.tardis_refined.common.blockentity.door.GlobalDoorBlockEntity;
import whocraft.tardis_refined.common.tardis.themes.ShellTheme;
import whocraft.tardis_refined.patterns.ShellPattern;

public class RenderDoorHook {

    public static ShellModel currentModel;

    public static void renderDoorModel(GlobalDoorBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay, CallbackInfo ci) {


        TardisClientData tardisClientData = TardisClientData.getInstance(blockEntity.getLevel().dimension());
        ShellPattern pattern = tardisClientData.shellPattern();
        
        poseStack.pushPose();
        poseStack.translate(0.5, 1.5, 0.5);
        poseStack.mulPose(Vector3f.ZP.rotationDegrees(180.0F));
        BlockState blockstate = blockEntity.getBlockState();
        float rotation = blockstate.getValue(GlobalDoorBlock.FACING).toYRot();
        poseStack.mulPose(Vector3f.YP.rotationDegrees(rotation));
        ShellTheme theme = blockstate.getValue(GlobalDoorBlock.SHELL);
        boolean isOpen = blockstate.getValue(GlobalDoorBlock.OPEN);
        poseStack.translate(0.0, 0.0, -0.01);


        if (theme == TEShellThemes.SEA_BLUE) {

            if (ESModelRegistry.TOMMY_INT_MODEL == null) {
                ESModelRegistry.TOMMY_INT_MODEL = new SeaBlueDoorModel(Minecraft.getInstance().getEntityModels().bakeLayer(ESModelRegistry.TOMMY_INT));
            }
            currentModel = ESModelRegistry.TOMMY_INT_MODEL;
        }

        if (theme == TEShellThemes.ENGINEERS) {
            poseStack.translate(0.0, 0.0, -0.5 / 2);

            if (ESModelRegistry.ENGINEERS_INT_MODEL == null) {
                ESModelRegistry.ENGINEERS_INT_MODEL = new EngineerDoorModel(Minecraft.getInstance().getEntityModels().bakeLayer(ESModelRegistry.ENGINEERS_INT));
            }
            currentModel = ESModelRegistry.ENGINEERS_INT_MODEL;
           // poseStack.mulPose(Vector3f.YP.rotationDegrees(180));
        }

        if (theme == TEShellThemes.ELLEN) {

            if (ESModelRegistry.ELLEN_INT_MODEL == null) {
                ESModelRegistry.ELLEN_INT_MODEL = new EllenDoorModel(Minecraft.getInstance().getEntityModels().bakeLayer(ESModelRegistry.ELLEN_INT));
            }
            currentModel = ESModelRegistry.ELLEN_INT_MODEL;
        }

        if (theme == TEShellThemes.MOFFAT) {

            if (ESModelRegistry.MOFFAT_INT_MODEL == null) {
                ESModelRegistry.MOFFAT_INT_MODEL = new MoffatDoorModel(Minecraft.getInstance().getEntityModels().bakeLayer(ESModelRegistry.MOFFAT_INT));
            }
            currentModel = ESModelRegistry.MOFFAT_INT_MODEL;
        }

        if (theme == TEShellThemes.GLASGOW) {

            if (ESModelRegistry.GLASGOW_INT_MODEL == null) {
                ESModelRegistry.GLASGOW_INT_MODEL = new GlasgowInspiredDoorModel(Minecraft.getInstance().getEntityModels().bakeLayer(ESModelRegistry.GLASGOW_INT));
            }
            currentModel = ESModelRegistry.GLASGOW_INT_MODEL;
        }

        if (theme == TEShellThemes.RTD) {

            if (ESModelRegistry.RTD_INT_MODEL == null) {
                ESModelRegistry.RTD_INT_MODEL = new RTDDoorModel(Minecraft.getInstance().getEntityModels().bakeLayer(ESModelRegistry.RTD_INT));
            }
            currentModel = ESModelRegistry.RTD_INT_MODEL;
        }

        if (theme == TEShellThemes.CHIBNALL) {

            if(pattern.id().getPath().contains("default")) {
                if (ESModelRegistry.CHIBNALL_INT_MODEL == null) {
                    ESModelRegistry.CHIBNALL_INT_MODEL = new ChibnallDoorModel(Minecraft.getInstance().getEntityModels().bakeLayer(ESModelRegistry.CHIBNALL_INT));
                }
                poseStack.mulPose(Vector3f.YP.rotationDegrees(180));
                poseStack.translate(0.0, 0.0, 0.2);
                currentModel = ESModelRegistry.CHIBNALL_INT_MODEL;
            } else {
                if (ESModelRegistry.RTD2_INT_MODEL == null) {
                    ESModelRegistry.RTD2_INT_MODEL = new RTD2DoorModel(Minecraft.getInstance().getEntityModels().bakeLayer(ESModelRegistry.RTD2_INT));
                }
                currentModel = ESModelRegistry.RTD2_INT_MODEL;
            }
        }

        TardisClientData reactions = TardisClientData.getInstance(blockEntity.getLevel().dimension());
        ShellPattern shellPattern = reactions.shellPattern();
        currentModel.setDoorPosition(isOpen);
        currentModel.renderToBuffer(poseStack, bufferSource.getBuffer(RenderType.entityTranslucent(currentModel.texture(shellPattern, false))), packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        poseStack.popPose();

    }

}
