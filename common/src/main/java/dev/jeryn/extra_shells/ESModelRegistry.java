package dev.jeryn.extra_shells;

import dev.architectury.injectables.annotations.ExpectPlatform;
import dev.jeryn.extra_shells.client.models.*;
import dev.jeryn.extra_shells.client.models.DeloreanShellDoorModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.resources.ResourceLocation;
import whocraft.tardis_refined.client.model.blockentity.door.interior.DualInteriorDoorModel;
import whocraft.tardis_refined.client.model.blockentity.door.interior.DualTexInteriorDoorModel;
import whocraft.tardis_refined.client.model.blockentity.door.interior.SingleInteriorDoorModel;
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

    public static SingleInteriorDoorModel OLDSCHOOL_INT_MDL;
    public static DualTexInteriorDoorModel LEGO_PIECE_INT_MDL;
    public static DualInteriorDoorModel ENGINEERS_INT_MDL, LEGO_IDEAS_INT_MDL, JACK_CUSTOM_INT_MDL, GLASGOW_INT_MDL, RTD2_INT_MDL, CHIBNALL_INT_MDL, RTD_INT_MDL, MOFFAT_INT_MDL, TOMMY_INT_MDL, ELLEN_INT_MDL, MADDOC_NEWBERRYINT_MDL, MADDOC_SMITHINT_MDL, MADDOC_TENNANTINT_MDL, MADDOC_WHITTAKERINT_MDL, MADDOC_BRACHACKIINT_MDL;
    public static MadDocShellBase MADDOC_NEWBERRYEXT_MDL, MADDOC_SMITHEXT_MDL, MADDOC_TENNANTEXT_MDL, MADDOC_WHITTAKEREXT_MDL, MADDOC_BRACHACKIEXT_MDL;

    public static DeloreanShellModel DELOREAN_MDL;
    public static DeloreanShellDoorModel DELOREAN_INT_MDL;

    public static ModelLayerLocation DELOREAN_EXT = shell("delorean");
    public static ModelLayerLocation JACK_EXT = shell("jack");
    public static ModelLayerLocation TOMMY_EXT = shell("tommy");
    public static ModelLayerLocation ENGINEERS_EXT = shell("engineers");
    public static ModelLayerLocation ELLEN_EXT = shell("ellen");
    public static ModelLayerLocation MOFFAT_EXT = shell("moffat");
    public static ModelLayerLocation OLDSCHOOL_EXT = shell("oldschool");
    public static ModelLayerLocation RTD_EXT = shell("rtd");
    public static ModelLayerLocation CHIBNALL_EXT = shell("chibnall");
    public static ModelLayerLocation GLASGOW_EXT = shell("glasgow");
    public static ModelLayerLocation LEGO_IDEAS_EXT = shell("lego_ideas");
    public static ModelLayerLocation LEGO_PIECE_EXT = shell("lego_piece");
    public static ModelLayerLocation LEGO_DIMENSIONS_EXT = shell("lego_dimensions");

    public static ModelLayerLocation DELOREAN_INT = interiorDoor("delorean_door");
    public static ModelLayerLocation JACK_CUSTOM_INT = interiorDoor("jack_door");
    public static ModelLayerLocation OLDSCHOOL_INT = interiorDoor("oldschool_door");
    public static ModelLayerLocation TOMMY_INT = interiorDoor("tommy_door");
    public static ModelLayerLocation ENGINEERS_INT = interiorDoor("engineers_door");
    public static ModelLayerLocation ELLEN_INT = interiorDoor("ellen_door");
    public static ModelLayerLocation MOFFAT_INT = interiorDoor("moffat_door");
    public static ModelLayerLocation RTD_INT = interiorDoor("rtd_door");
    public static ModelLayerLocation RTD2_INT = interiorDoor("rtd2_door");
    public static ModelLayerLocation CHIBNALL_INT = interiorDoor("chibnall_door");
    public static ModelLayerLocation GLASGOW_INT = interiorDoor("glasgow_door");
    public static ModelLayerLocation LEGO_IDEAS_INT = interiorDoor("lego_ideas_door");
    public static ModelLayerLocation LEGO_PIECE_INT = interiorDoor("lego_piece_door");

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
        ESModelRegistry.JACK_CUSTOM_EXT_MDL = new JackShellModel(entityModels.bakeLayer(ESModelRegistry.JACK_EXT));
        ESModelRegistry.ELLEN_EXT_MDL = new EllenShellModel(entityModels.bakeLayer(ESModelRegistry.ELLEN_EXT));
        ESModelRegistry.LEGO_PIECE_EXT_MDL = new LegoPieceShellModel(entityModels.bakeLayer(ESModelRegistry.LEGO_PIECE_EXT));
        ESModelRegistry.LEGO_DIMENSIONS_EXT_MDL = new LegoDimensionsShellModel(entityModels.bakeLayer(ESModelRegistry.LEGO_DIMENSIONS_EXT));

        // Interior Door
        ESModelRegistry.TOMMY_INT_MDL = new DualInteriorDoorModel(entityModels.bakeLayer(ESModelRegistry.TOMMY_INT), -275.0F);
        ESModelRegistry.ENGINEERS_INT_MDL = new DualInteriorDoorModel(entityModels.bakeLayer(ESModelRegistry.ENGINEERS_INT), -275.0F);
        ESModelRegistry.MOFFAT_INT_MDL = new DualInteriorDoorModel(entityModels.bakeLayer(ESModelRegistry.MOFFAT_INT), -275.0F);
        ESModelRegistry.GLASGOW_INT_MDL = new DualInteriorDoorModel(entityModels.bakeLayer(ESModelRegistry.GLASGOW_INT), -275.0F);
        ESModelRegistry.RTD_INT_MDL = new DualInteriorDoorModel(entityModels.bakeLayer(ESModelRegistry.RTD_INT), -275.0F);
        ESModelRegistry.CHIBNALL_INT_MDL = new DualInteriorDoorModel(entityModels.bakeLayer(ESModelRegistry.CHIBNALL_INT), -275.0F);
        ESModelRegistry.RTD2_INT_MDL = new DualInteriorDoorModel(entityModels.bakeLayer(ESModelRegistry.RTD2_INT), -275.0F);
        ESModelRegistry.LEGO_IDEAS_INT_MDL = new DualInteriorDoorModel(entityModels.bakeLayer(ESModelRegistry.LEGO_IDEAS_INT), -275.0F);
        ESModelRegistry.JACK_CUSTOM_INT_MDL = new DualInteriorDoorModel(entityModels.bakeLayer(ESModelRegistry.JACK_CUSTOM_INT), -275.0F);
        ESModelRegistry.ELLEN_INT_MDL = new DualInteriorDoorModel(entityModels.bakeLayer(ESModelRegistry.ELLEN_INT), -275.0F, true, false);
        ESModelRegistry.LEGO_PIECE_INT_MDL = new DualTexInteriorDoorModel(entityModels.bakeLayer(ESModelRegistry.LEGO_PIECE_INT));
        ESModelRegistry.OLDSCHOOL_INT_MDL = new SingleInteriorDoorModel(entityModels.bakeLayer(ESModelRegistry.OLDSCHOOL_INT), 90);

        ESModelRegistry.MADDOC_SMITHINT_MDL = new DualInteriorDoorModel(entityModels.bakeLayer(ESModelRegistry.MADDOC_SMITHINT), 300);
        ESModelRegistry.MADDOC_BRACHACKIINT_MDL = new DualInteriorDoorModel(entityModels.bakeLayer(ESModelRegistry.MADDOC_BRACHACKIINT), 300);
        ESModelRegistry.MADDOC_WHITTAKERINT_MDL = new DualInteriorDoorModel(entityModels.bakeLayer(ESModelRegistry.MADDOC_WHITTAKERINT), 300);
        ESModelRegistry.MADDOC_NEWBERRYINT_MDL = new DualInteriorDoorModel(entityModels.bakeLayer(ESModelRegistry.MADDOC_NEWBERYINT), 300);
        ESModelRegistry.MADDOC_TENNANTINT_MDL = new DualInteriorDoorModel(entityModels.bakeLayer(ESModelRegistry.MADDOC_TENNANTINT), 300);
        ESModelRegistry.DELOREAN_INT_MDL = new DeloreanShellDoorModel(entityModels.bakeLayer(ESModelRegistry.DELOREAN_INT));

        ESModelRegistry.MADDOC_SMITHEXT_MDL = new MadDocShellBase(entityModels.bakeLayer(ESModelRegistry.MADDOC_SMITHEXT));
        ESModelRegistry.MADDOC_TENNANTEXT_MDL = new MadDocShellBase(entityModels.bakeLayer(ESModelRegistry.MADDOC_TENNANTEXT));
        ESModelRegistry.MADDOC_BRACHACKIEXT_MDL = new MadDocShellBase(entityModels.bakeLayer(ESModelRegistry.MADDOC_BRACHACKIEXT));

        ESModelRegistry.MADDOC_TENNANTEXT_MDL = new MadDocShellBase(entityModels.bakeLayer(ESModelRegistry.MADDOC_TENNANTEXT));
        ESModelRegistry.MADDOC_WHITTAKEREXT_MDL = new MadDocShellBase(entityModels.bakeLayer(ESModelRegistry.MADDOC_WHITTAKEREXT));
        ESModelRegistry.MADDOC_NEWBERRYEXT_MDL = new MadDocShellBase(entityModels.bakeLayer(ESModelRegistry.MADDOC_NEWBERYEXT));
        ESModelRegistry.DELOREAN_MDL = new DeloreanShellModel(entityModels.bakeLayer(ESModelRegistry.DELOREAN_EXT));

        ShellEntryRegistry.init();
    }

    @ExpectPlatform
    public static ModelLayerLocation register(ModelLayerLocation location, Supplier<LayerDefinition> definitionSupplier) {
        throw new RuntimeException(PlatformWarning.addWarning(ESModelRegistry.class));
    }

}
