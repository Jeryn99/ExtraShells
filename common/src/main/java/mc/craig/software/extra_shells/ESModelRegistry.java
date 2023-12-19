package mc.craig.software.extra_shells;

import dev.architectury.injectables.annotations.ExpectPlatform;
import mc.craig.software.extra_shells.client.models.*;
import mc.craig.software.extra_shells.client.models.doors.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.resources.ResourceLocation;
import whocraft.tardis_refined.TardisRefined;
import whocraft.tardis_refined.common.util.PlatformWarning;

import java.util.function.Supplier;

public class ESModelRegistry {

    public static SeaBlueShellModel TOMMY_EXT_MODEL;
    public static EngineersShellModel ENGINEERS_EXT_MODEL;
    public static EllenShellModel  ELLEN_EXT_MODEL;
    public static MoffatBoxShell MOFFAT_EXT_MODEL;
    public static RTDShellModel RTD_EXT_MODEL;
    public static ChibnallShellModel CHIBNALL_EXT_MODEL;
    public static GlasgowInspiredShellModel GLASGOW_EXT_MODEL;
    public static JackShellModel JACK_CUSTOM_EXT_MODEL;
    public static LegoIdeasShellModel LEGO_IDEAS_EXT_MODEL;

    public static HudolinShellModel HUDOLIN_EXT_MODEL;
    public static HudolinDoorModel HUDOLIN_INT_MODEL;
    public static ModelLayerLocation HUDOLIN_EXT, HUDOLIN_INT;

    public static SeaBlueDoorModel TOMMY_INT_MODEL;
    public static EngineerDoorModel ENGINEERS_INT_MODEL;
    public static EllenDoorModel ELLEN_INT_MODEL;
    public static MoffatDoorModel MOFFAT_INT_MODEL;
    public static RTDDoorModel RTD_INT_MODEL;
    public static ChibnallDoorModel CHIBNALL_INT_MODEL;
    public static RTD2DoorModel RTD2_INT_MODEL;
    public static GlasgowInspiredDoorModel GLASGOW_INT_MODEL;
    public static JackDoorModel JACK_CUSTOM_INT_MODEL;
    public static LegoIdeasDoorModel LEGO_IDEAS_INT_MODEL;

    public static ModelLayerLocation JACK_CUSTOM_EXT, TOMMY_EXT, ENGINEERS_EXT, ELLEN_EXT, MOFFAT_EXT, RTD_EXT, CHIBNALL_EXT, GLASGOW_EXT, LEGO_IDEAS_EXT;
    public static ModelLayerLocation JACK_CUSTOM_INT, TOMMY_INT, ENGINEERS_INT, ELLEN_INT, MOFFAT_INT, RTD_INT, RTD2_INT, CHIBNALL_INT, GLASGOW_INT, LEGO_IDEAS_INT;



    public static void init() {
        ENGINEERS_EXT = register(new ModelLayerLocation(new ResourceLocation(ExtraShells.MODID, "engineers_ext"), "engineers_ext"), EngineersShellModel::createBodyLayer);
        TOMMY_EXT = register(new ModelLayerLocation(new ResourceLocation(ExtraShells.MODID, "tommy_ext"), "tommy_ext"), SeaBlueShellModel::createBodyLayer);
        ELLEN_EXT = register(new ModelLayerLocation(new ResourceLocation(ExtraShells.MODID, "ellen_ext"), "ellen_ext"), EllenShellModel::createBodyLayer);
        MOFFAT_EXT = register(new ModelLayerLocation(new ResourceLocation(ExtraShells.MODID, "moffat_ext"), "moffat_ext"), MoffatBoxShell::createBodyLayer);
        RTD_EXT = register(new ModelLayerLocation(new ResourceLocation(ExtraShells.MODID, "rtd_ext"), "rtd_ext"), RTDShellModel::createBodyLayer);
        GLASGOW_EXT = register(new ModelLayerLocation(new ResourceLocation(ExtraShells.MODID, "glasgow_ext"), "glasgow_ext"), GlasgowInspiredShellModel::createBodyLayer);
        CHIBNALL_EXT = register(new ModelLayerLocation(new ResourceLocation(ExtraShells.MODID, "chibnall_ext"), "chibnall_ext"), ChibnallShellModel::createBodyLayer);
        JACK_CUSTOM_EXT = register(new ModelLayerLocation(new ResourceLocation(ExtraShells.MODID, "jack_ext"), "jack_ext"), JackShellModel::createBodyLayer);
        LEGO_IDEAS_EXT = register(new ModelLayerLocation(new ResourceLocation(ExtraShells.MODID, "lego_ideas_ext"), "lego_ideas_ext"), LegoIdeasShellModel::createBodyLayer);

        ENGINEERS_INT = register(new ModelLayerLocation(new ResourceLocation(ExtraShells.MODID, "engineers_int"), "engineers_int"), EngineerDoorModel::createBodyLayer);
        TOMMY_INT = register(new ModelLayerLocation(new ResourceLocation(ExtraShells.MODID, "tommy_int"), "tommy_int"), SeaBlueDoorModel::createBodyLayer);
        ELLEN_INT = register(new ModelLayerLocation(new ResourceLocation(ExtraShells.MODID, "ellen_int"), "ellen_int"), EllenDoorModel::createBodyLayer);
        MOFFAT_INT = register(new ModelLayerLocation(new ResourceLocation(ExtraShells.MODID, "moffat_int"), "moffat_int"), MoffatDoorModel::createBodyLayer);
        RTD_INT = register(new ModelLayerLocation(new ResourceLocation(ExtraShells.MODID, "rtd_int"), "rtd_int"), RTDDoorModel::createBodyLayer);
        GLASGOW_INT = register(new ModelLayerLocation(new ResourceLocation(ExtraShells.MODID, "glasgow_int_model"), "glasgow_int_model"), GlasgowInspiredDoorModel::createBodyLayer);
        CHIBNALL_INT = register(new ModelLayerLocation(new ResourceLocation(ExtraShells.MODID, "chibnall_int_model"), "chibnall_int_model"), ChibnallDoorModel::createBodyLayer);
        RTD2_INT = register(new ModelLayerLocation(new ResourceLocation(ExtraShells.MODID, "rtd2_int_model"), "rtd2_int_model"), RTD2DoorModel::createBodyLayer);
        JACK_CUSTOM_INT = register(new ModelLayerLocation(new ResourceLocation(ExtraShells.MODID, "jack_int_model"), "jack_int_model"), JackDoorModel::createBodyLayer);
        LEGO_IDEAS_INT = register(new ModelLayerLocation(new ResourceLocation(ExtraShells.MODID, "lego_ideas_int"), "lego_ideas_int"), LegoIdeasDoorModel::createBodyLayer);

        HUDOLIN_EXT = register(new ModelLayerLocation(new ResourceLocation(ExtraShells.MODID, "hudolin_ext"), "hudolin_ext"), HudolinShellModel::createBodyLayer);
        HUDOLIN_INT = register(new ModelLayerLocation(new ResourceLocation(ExtraShells.MODID, "hudolin_int"), "hudolin_int"), HudolinDoorModel::createBodyLayer);

    }

    public static void setupModelInstances(EntityModelSet entityModels) {

        // Shell
        ESModelRegistry.TOMMY_EXT_MODEL = new SeaBlueShellModel(entityModels.bakeLayer(ESModelRegistry.TOMMY_EXT));
        ESModelRegistry.ENGINEERS_EXT_MODEL = new EngineersShellModel(entityModels.bakeLayer(ESModelRegistry.ENGINEERS_EXT));
        ESModelRegistry.ELLEN_EXT_MODEL = new EllenShellModel(entityModels.bakeLayer(ESModelRegistry.ELLEN_EXT));
        ESModelRegistry.MOFFAT_EXT_MODEL = new MoffatBoxShell(entityModels.bakeLayer(ESModelRegistry.MOFFAT_EXT));
        ESModelRegistry.RTD_EXT_MODEL = new RTDShellModel(entityModels.bakeLayer(ESModelRegistry.RTD_EXT));
        ESModelRegistry.GLASGOW_EXT_MODEL = new GlasgowInspiredShellModel(entityModels.bakeLayer(ESModelRegistry.GLASGOW_EXT));
        ESModelRegistry.CHIBNALL_EXT_MODEL = new ChibnallShellModel(entityModels.bakeLayer(ESModelRegistry.CHIBNALL_EXT));
        ESModelRegistry.LEGO_IDEAS_EXT_MODEL = new LegoIdeasShellModel(entityModels.bakeLayer(ESModelRegistry.LEGO_IDEAS_EXT));
        ESModelRegistry.HUDOLIN_EXT_MODEL = new HudolinShellModel(entityModels.bakeLayer(ESModelRegistry.HUDOLIN_EXT));

        // Interior Door
        ESModelRegistry.TOMMY_INT_MODEL = new SeaBlueDoorModel(entityModels.bakeLayer(ESModelRegistry.TOMMY_INT));
        ESModelRegistry.ENGINEERS_INT_MODEL = new EngineerDoorModel(entityModels.bakeLayer(ESModelRegistry.ENGINEERS_INT));
        ESModelRegistry.ELLEN_INT_MODEL = new EllenDoorModel(entityModels.bakeLayer(ESModelRegistry.ELLEN_INT));
        ESModelRegistry.MOFFAT_INT_MODEL = new MoffatDoorModel(entityModels.bakeLayer(ESModelRegistry.MOFFAT_INT));
        ESModelRegistry.GLASGOW_INT_MODEL = new GlasgowInspiredDoorModel(entityModels.bakeLayer(ESModelRegistry.GLASGOW_INT));
        ESModelRegistry.RTD_INT_MODEL = new RTDDoorModel(entityModels.bakeLayer(ESModelRegistry.RTD_INT));
        ESModelRegistry.CHIBNALL_INT_MODEL = new ChibnallDoorModel(entityModels.bakeLayer(ESModelRegistry.CHIBNALL_INT));
        ESModelRegistry.RTD2_INT_MODEL = new RTD2DoorModel(entityModels.bakeLayer(ESModelRegistry.RTD2_INT));
        ESModelRegistry.LEGO_IDEAS_INT_MODEL = new LegoIdeasDoorModel(entityModels.bakeLayer(ESModelRegistry.LEGO_IDEAS_INT));
        ESModelRegistry.HUDOLIN_INT_MODEL = new HudolinDoorModel(entityModels.bakeLayer(ESModelRegistry.HUDOLIN_EXT));

        ShellEntryRegistry.init();
    }

    @ExpectPlatform
    public static ModelLayerLocation register(ModelLayerLocation location, Supplier<LayerDefinition> definitionSupplier) {
        throw new RuntimeException(PlatformWarning.addWarning(ESModelRegistry.class));
    }

}
