package dev.jeryn.extra_shells;

import dev.architectury.injectables.annotations.ExpectPlatform;
import dev.jeryn.extra_shells.client.models.*;
import dev.jeryn.extra_shells.client.models.doors.*;
import dev.jeryn.extra_shells.client.models.doors.lego.LegoPieceDoors;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.resources.ResourceLocation;
import whocraft.tardis_refined.client.model.blockentity.door.interior.DualInteriorDoorModel;
import whocraft.tardis_refined.common.util.PlatformWarning;

import java.util.function.Supplier;

public class ESModelRegistry {

    public static SeaBlueShellModel TOMMY_EXT_MDL;
    public static EngineersShellModel ENGINEERS_EXT_MDL;
    public static EllenShellModel ELLEN_EXT_MDL;
    public static MoffatBoxShell MOFFAT_EXT_MDL;
    public static OldSchoolShellModel OLDSCHOOL_EXT_MDL;
    public static RTDShellModel RTD_EXT_MDL;
    public static ChibnallShellModel CHIBNALL_EXT_MDL;
    public static GlasgowInspiredShellModel GLASGOW_EXT_MDL;
    public static JackShellModel JACK_CUSTOM_EXT_MDL;
    public static LegoIdeasShellModel LEGO_IDEAS_EXT_MDL;
    public static LegoPieceShellModel LEGO_PIECE_EXT_MDL;
    public static LegoDimensionsShellModel LEGO_DIMENSIONS_EXT_MDL;

    public static HudolinShellModel HUDOLIN_EXT_MDL;
    public static HudolinDoorModel HUDOLIN_INT_MDL;
    public static ModelLayerLocation HUDOLIN_EXT, HUDOLIN_INT;

    public static SeaBlueDoorModel TOMMY_INT_MDL;
    public static EngineerDoorModel ENGINEERS_INT_MDL;
    public static EllenDoorModel ELLEN_INT_MDL;
    public static MoffatDoorModel MOFFAT_INT_MDL;
    public static RTDDoorModel RTD_INT_MDL;
    public static ChibnallDoorModel CHIBNALL_INT_MDL;
    public static RTD2DoorModel RTD2_INT_MDL;
    public static GlasgowInspiredDoorModel GLASGOW_INT_MDL;
    public static JackDoorModel JACK_CUSTOM_INT_MDL;
    public static LegoIdeasDoorModel LEGO_IDEAS_INT_MDL;
    public static LegoPieceDoors LEGO_PIECE_INT_MDL;
    public static OldSchoolDoorModel OLDSCHOOL_INT_MDL;
    public static DualInteriorDoorModel MADDOC_NEWBERRYINT_MDL, MADDOC_SMITHINT_MDL, MADDOC_TENNANTINT_MDL, MADDOC_WHITTAKERINT_MDL, MADDOC_BRACHACKIINT_MDL;
    public static MadDocShellBase MADDOC_NEWBERRYEXT_MDL, MADDOC_SMITHEXT_MDL, MADDOC_TENNANTEXT_MDL, MADDOC_WHITTAKEREXT_MDL, MADDOC_BRACHACKIEXT_MDL;

    public static ModelLayerLocation JACK_CUSTOM_EXT, TOMMY_EXT, ENGINEERS_EXT, ELLEN_EXT, MOFFAT_EXT, OLDSCHOOL_EXT, RTD_EXT, CHIBNALL_EXT, GLASGOW_EXT, LEGO_IDEAS_EXT, LEGO_PIECE_EXT, LEGO_DIMENSIONS_EXT;
    public static ModelLayerLocation JACK_CUSTOM_INT, OLDSCHOOL_INT, TOMMY_INT, ENGINEERS_INT, ELLEN_INT, MOFFAT_INT, RTD_INT, RTD2_INT, CHIBNALL_INT, GLASGOW_INT, LEGO_IDEAS_INT, LEGO_PIECE_INT;

    public static ModelLayerLocation MADDOC_SMITHINT = interiorDoor("maddoc_smith_door");
    public static ModelLayerLocation MADDOC_SMITHEXT = shell("maddoc_smith");

    public static ModelLayerLocation MADDOC_TENNANTINT = interiorDoor("maddoc_2005_door");
    public static ModelLayerLocation MADDOC_TENNANTEXT = shell("maddoc_2005");

    public static ModelLayerLocation MADDOC_WHITTAKERINT = interiorDoor("maddoc_whittaker_door");
    public static ModelLayerLocation MADDOC_WHITTAKEREXT = shell("maddoc_whittaker");

    public static ModelLayerLocation MADDOC_BRACHACKIINT = interiorDoor("maddoc_brachacki_door");
    public static ModelLayerLocation MADDOC_BRACHACKIEXT = shell("maddoc_brachacki");

    public static ModelLayerLocation MADDOC_NEWBERYINT = interiorDoor("maddoc_newberry_door");
    public static ModelLayerLocation MADDOC_NEWBERYEXT = shell("maddoc_newberry");


    private static ModelLayerLocation interiorDoor(String name) {
        return createLocation(name, "door");
    }

    private static ModelLayerLocation console(String name) {
        return createLocation(name, "console");
    }

    private static ModelLayerLocation shell(String name) {
        return createLocation(name, "shell");
    }


    private static ModelLayerLocation createLocation(String name, String layer) {
        return new ModelLayerLocation(new ResourceLocation(ExtraShells.MODID, name), layer);
    }        


    public static void init() {
        ExtraShellAPIEvents.init();
        OLDSCHOOL_EXT = register(new ModelLayerLocation(new ResourceLocation(ExtraShells.MODID, "oldschool_ext"), "oldschool_ext"), OldSchoolShellModel::createBodyLayer);
        ENGINEERS_EXT = register(new ModelLayerLocation(new ResourceLocation(ExtraShells.MODID, "engineers_ext"), "engineers_ext"), EngineersShellModel::createBodyLayer);
        TOMMY_EXT = register(new ModelLayerLocation(new ResourceLocation(ExtraShells.MODID, "tommy_ext"), "tommy_ext"), SeaBlueShellModel::createBodyLayer);
        ELLEN_EXT = register(new ModelLayerLocation(new ResourceLocation(ExtraShells.MODID, "ellen_ext"), "ellen_ext"), EllenShellModel::createBodyLayer);
        MOFFAT_EXT = register(new ModelLayerLocation(new ResourceLocation(ExtraShells.MODID, "moffat_ext"), "moffat_ext"), MoffatBoxShell::createBodyLayer);
        RTD_EXT = register(new ModelLayerLocation(new ResourceLocation(ExtraShells.MODID, "rtd_ext"), "rtd_ext"), RTDShellModel::createBodyLayer);
        GLASGOW_EXT = register(new ModelLayerLocation(new ResourceLocation(ExtraShells.MODID, "glasgow_ext"), "glasgow_ext"), GlasgowInspiredShellModel::createBodyLayer);
        CHIBNALL_EXT = register(new ModelLayerLocation(new ResourceLocation(ExtraShells.MODID, "chibnall_ext"), "chibnall_ext"), ChibnallShellModel::createBodyLayer);
        JACK_CUSTOM_EXT = register(new ModelLayerLocation(new ResourceLocation(ExtraShells.MODID, "jack_ext"), "jack_ext"), JackShellModel::createBodyLayer);
        LEGO_IDEAS_EXT = register(new ModelLayerLocation(new ResourceLocation(ExtraShells.MODID, "lego_ideas_ext"), "lego_ideas_ext"), LegoIdeasShellModel::createBodyLayer);

        OLDSCHOOL_INT = register(new ModelLayerLocation(new ResourceLocation(ExtraShells.MODID, "oldschool_int"), "oldschool_int"), OldSchoolDoorModel::createBodyLayer);
        ENGINEERS_INT = register(new ModelLayerLocation(new ResourceLocation(ExtraShells.MODID, "engineers_int"), "engineers_int"), EngineerDoorModel::createBodyLayer);
        TOMMY_INT = register(new ModelLayerLocation(new ResourceLocation(ExtraShells.MODID, "tommy_int"), "tommy_int"), SeaBlueDoorModel::createBodyLayer);
        ELLEN_INT = register(new ModelLayerLocation(new ResourceLocation(ExtraShells.MODID, "ellen_int"), "ellen_int"), EllenDoorModel::createBodyLayer);
        MOFFAT_INT = register(new ModelLayerLocation(new ResourceLocation(ExtraShells.MODID, "moffat_int"), "moffat_int"), MoffatDoorModel::createBodyLayer);
        RTD_INT = register(new ModelLayerLocation(new ResourceLocation(ExtraShells.MODID, "rtd_int"), "rtd_int"), RTDDoorModel::createBodyLayer);
        GLASGOW_INT = register(new ModelLayerLocation(new ResourceLocation(ExtraShells.MODID, "glasgow_int_model"), "glasgow_int_model"), GlasgowInspiredDoorModel::createBodyLayer);
        CHIBNALL_INT = register(new ModelLayerLocation(new ResourceLocation(ExtraShells.MODID, "chibnall_int_model"), "chibnall_int_model"), ChibnallDoorModel::createBodyLayer);
        OLDSCHOOL_INT = register(new ModelLayerLocation(new ResourceLocation(ExtraShells.MODID, "oldschool_int_model"), "oldschool_int_model"), OldSchoolDoorModel::createBodyLayer);
        RTD2_INT = register(new ModelLayerLocation(new ResourceLocation(ExtraShells.MODID, "rtd2_int_model"), "rtd2_int_model"), RTD2DoorModel::createBodyLayer);
        JACK_CUSTOM_INT = register(new ModelLayerLocation(new ResourceLocation(ExtraShells.MODID, "jack_int_model"), "jack_int_model"), JackDoorModel::createBodyLayer);
        LEGO_IDEAS_INT = register(new ModelLayerLocation(new ResourceLocation(ExtraShells.MODID, "lego_ideas_int"), "lego_ideas_int"), LegoIdeasDoorModel::createBodyLayer);

        HUDOLIN_EXT = register(new ModelLayerLocation(new ResourceLocation(ExtraShells.MODID, "hudolin_ext"), "hudolin_ext"), HudolinShellModel::createBodyLayer);
        HUDOLIN_INT = register(new ModelLayerLocation(new ResourceLocation(ExtraShells.MODID, "hudolin_int"), "hudolin_int"), HudolinDoorModel::createBodyLayer);

        LEGO_PIECE_INT = register(new ModelLayerLocation(new ResourceLocation(ExtraShells.MODID, "lego_piece_int"), "lego_piece_int"), LegoPieceDoors::createBodyLayer);
        LEGO_PIECE_EXT = register(new ModelLayerLocation(new ResourceLocation(ExtraShells.MODID, "lego_piece_ext"), "lego_piece_ext"), LegoPieceShellModel::createBodyLayer);

        LEGO_DIMENSIONS_EXT = register(new ModelLayerLocation(new ResourceLocation(ExtraShells.MODID, "lego_dimensions_ext"), "lego_dimensions_ext"), LegoDimensionsShellModel::createBodyLayer);

    }

    public static void setupModelInstances(EntityModelSet entityModels) {

        // Shell
        ESModelRegistry.TOMMY_EXT_MDL = new SeaBlueShellModel(entityModels.bakeLayer(ESModelRegistry.TOMMY_EXT));
        ESModelRegistry.ENGINEERS_EXT_MDL = new EngineersShellModel(entityModels.bakeLayer(ESModelRegistry.ENGINEERS_EXT));
        ESModelRegistry.ELLEN_EXT_MDL = new EllenShellModel(entityModels.bakeLayer(ESModelRegistry.ELLEN_EXT));
        ESModelRegistry.MOFFAT_EXT_MDL = new MoffatBoxShell(entityModels.bakeLayer(ESModelRegistry.MOFFAT_EXT));
        ESModelRegistry.OLDSCHOOL_EXT_MDL = new OldSchoolShellModel(entityModels.bakeLayer(ESModelRegistry.OLDSCHOOL_EXT));
        ESModelRegistry.RTD_EXT_MDL = new RTDShellModel(entityModels.bakeLayer(ESModelRegistry.RTD_EXT));
        ESModelRegistry.GLASGOW_EXT_MDL = new GlasgowInspiredShellModel(entityModels.bakeLayer(ESModelRegistry.GLASGOW_EXT));
        ESModelRegistry.CHIBNALL_EXT_MDL = new ChibnallShellModel(entityModels.bakeLayer(ESModelRegistry.CHIBNALL_EXT));
        ESModelRegistry.LEGO_IDEAS_EXT_MDL = new LegoIdeasShellModel(entityModels.bakeLayer(ESModelRegistry.LEGO_IDEAS_EXT));
        ESModelRegistry.HUDOLIN_EXT_MDL = new HudolinShellModel(entityModels.bakeLayer(ESModelRegistry.HUDOLIN_EXT));
        ESModelRegistry.JACK_CUSTOM_EXT_MDL = new JackShellModel(entityModels.bakeLayer(ESModelRegistry.JACK_CUSTOM_EXT));
        ESModelRegistry.ELLEN_EXT_MDL = new EllenShellModel(entityModels.bakeLayer(ESModelRegistry.ELLEN_EXT));
        ESModelRegistry.LEGO_PIECE_EXT_MDL = new LegoPieceShellModel(entityModels.bakeLayer(ESModelRegistry.LEGO_PIECE_EXT));
        ESModelRegistry.LEGO_DIMENSIONS_EXT_MDL = new LegoDimensionsShellModel(entityModels.bakeLayer(ESModelRegistry.LEGO_DIMENSIONS_EXT));

        // Interior Door
        ESModelRegistry.TOMMY_INT_MDL = new SeaBlueDoorModel(entityModels.bakeLayer(ESModelRegistry.TOMMY_INT));
        ESModelRegistry.ENGINEERS_INT_MDL = new EngineerDoorModel(entityModels.bakeLayer(ESModelRegistry.ENGINEERS_INT));
        ESModelRegistry.ELLEN_INT_MDL = new EllenDoorModel(entityModels.bakeLayer(ESModelRegistry.ELLEN_INT));
        ESModelRegistry.MOFFAT_INT_MDL = new MoffatDoorModel(entityModels.bakeLayer(ESModelRegistry.MOFFAT_INT));
        ESModelRegistry.GLASGOW_INT_MDL = new GlasgowInspiredDoorModel(entityModels.bakeLayer(ESModelRegistry.GLASGOW_INT));
        ESModelRegistry.RTD_INT_MDL = new RTDDoorModel(entityModels.bakeLayer(ESModelRegistry.RTD_INT));
        ESModelRegistry.CHIBNALL_INT_MDL = new ChibnallDoorModel(entityModels.bakeLayer(ESModelRegistry.CHIBNALL_INT));
        ESModelRegistry.RTD2_INT_MDL = new RTD2DoorModel(entityModels.bakeLayer(ESModelRegistry.RTD2_INT));
        ESModelRegistry.LEGO_IDEAS_INT_MDL = new LegoIdeasDoorModel(entityModels.bakeLayer(ESModelRegistry.LEGO_IDEAS_INT));
        ESModelRegistry.HUDOLIN_INT_MDL = new HudolinDoorModel(entityModels.bakeLayer(ESModelRegistry.HUDOLIN_EXT));
        ESModelRegistry.JACK_CUSTOM_INT_MDL = new JackDoorModel(entityModels.bakeLayer(ESModelRegistry.JACK_CUSTOM_INT));
        ESModelRegistry.ELLEN_INT_MDL = new EllenDoorModel(entityModels.bakeLayer(ESModelRegistry.ELLEN_INT));
        ESModelRegistry.LEGO_PIECE_INT_MDL = new LegoPieceDoors(entityModels.bakeLayer(ESModelRegistry.LEGO_PIECE_INT));
        ESModelRegistry.OLDSCHOOL_INT_MDL = new OldSchoolDoorModel(entityModels.bakeLayer(ESModelRegistry.OLDSCHOOL_INT));

        ESModelRegistry.MADDOC_SMITHINT_MDL = new DualInteriorDoorModel(entityModels.bakeLayer(ESModelRegistry.MADDOC_SMITHINT), 300);
        ESModelRegistry.MADDOC_BRACHACKIINT_MDL = new DualInteriorDoorModel(entityModels.bakeLayer(ESModelRegistry.MADDOC_BRACHACKIINT), 300);
        ESModelRegistry.MADDOC_WHITTAKERINT_MDL = new DualInteriorDoorModel(entityModels.bakeLayer(ESModelRegistry.MADDOC_WHITTAKERINT), 300);
        ESModelRegistry.MADDOC_NEWBERRYINT_MDL = new DualInteriorDoorModel(entityModels.bakeLayer(ESModelRegistry.MADDOC_NEWBERYINT), 300);
        ESModelRegistry.MADDOC_TENNANTINT_MDL = new DualInteriorDoorModel(entityModels.bakeLayer(ESModelRegistry.MADDOC_TENNANTINT), 300);

        ESModelRegistry.MADDOC_SMITHEXT_MDL = new MadDocShellBase(entityModels.bakeLayer(ESModelRegistry.MADDOC_SMITHEXT));
        ESModelRegistry.MADDOC_TENNANTEXT_MDL = new MadDocShellBase(entityModels.bakeLayer(ESModelRegistry.MADDOC_TENNANTEXT));
        ESModelRegistry.MADDOC_BRACHACKIEXT_MDL = new MadDocShellBase(entityModels.bakeLayer(ESModelRegistry.MADDOC_BRACHACKIEXT));

        ESModelRegistry.MADDOC_TENNANTEXT_MDL = new MadDocShellBase(entityModels.bakeLayer(ESModelRegistry.MADDOC_TENNANTEXT));
        ESModelRegistry.MADDOC_WHITTAKEREXT_MDL = new MadDocShellBase(entityModels.bakeLayer(ESModelRegistry.MADDOC_WHITTAKEREXT));
        ESModelRegistry.MADDOC_NEWBERRYEXT_MDL = new MadDocShellBase(entityModels.bakeLayer(ESModelRegistry.MADDOC_NEWBERYEXT));

        ShellEntryRegistry.init();
    }

    @ExpectPlatform
    public static ModelLayerLocation register(ModelLayerLocation location, Supplier<LayerDefinition> definitionSupplier) {
        throw new RuntimeException(PlatformWarning.addWarning(ESModelRegistry.class));
    }

}
