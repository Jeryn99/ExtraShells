package mc.craig.software.extra_shells;

import dev.architectury.injectables.annotations.ExpectPlatform;
import mc.craig.software.extra_shells.client.models.tommy.EllenShellModel;
import mc.craig.software.extra_shells.client.models.tommy.EngineersShellModel;
import mc.craig.software.extra_shells.client.models.tommy.MoffatShellModel;
import mc.craig.software.extra_shells.client.models.tommy.SeaBlueShellModel;
import mc.craig.software.extra_shells.client.models.tommy.doors.EllenDoorModel;
import mc.craig.software.extra_shells.client.models.tommy.doors.EngineerDoorModel;
import mc.craig.software.extra_shells.client.models.tommy.doors.MoffatDoorModel;
import mc.craig.software.extra_shells.client.models.tommy.doors.SeaBlueDoorModel;
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
    public static MoffatShellModel  MOFFAT_EXT_MODEL;

    public static SeaBlueDoorModel TOMMY_INT_MODEL;
    public static EngineerDoorModel ENGINEERS_INT_MODEL;
    public static EllenDoorModel  ELLEN_INT_MODEL;
    public static MoffatDoorModel  MOFFAT_INT_MODEL;

    public static ModelLayerLocation TOMMY_EXT, ENGINEERS_EXT, ELLEN_EXT, MOFFAT_EXT;
    public static ModelLayerLocation TOMMY_INT, ENGINEERS_INT, ELLEN_INT, MOFFAT_INT;



    public static void init() {
        ENGINEERS_EXT = register(new ModelLayerLocation(new ResourceLocation(TardisRefined.MODID, "engineers_ext"), "engineers_ext"), EngineersShellModel::createBodyLayer);
        TOMMY_EXT = register(new ModelLayerLocation(new ResourceLocation(TardisRefined.MODID, "tommy_ext"), "tommy_ext"), SeaBlueShellModel::createBodyLayer);
        ELLEN_EXT = register(new ModelLayerLocation(new ResourceLocation(TardisRefined.MODID, "ellen_ext"), "ellen_ext"), EllenShellModel::createBodyLayer);
        MOFFAT_EXT = register(new ModelLayerLocation(new ResourceLocation(TardisRefined.MODID, "moffat_ext"), "moffat_ext"), MoffatShellModel::createBodyLayer);

        ENGINEERS_INT = register(new ModelLayerLocation(new ResourceLocation(TardisRefined.MODID, "engineers_int"), "engineers_int"), EngineerDoorModel::createBodyLayer);
        TOMMY_INT = register(new ModelLayerLocation(new ResourceLocation(TardisRefined.MODID, "tommy_int"), "tommy_int"), SeaBlueDoorModel::createBodyLayer);
        ELLEN_INT = register(new ModelLayerLocation(new ResourceLocation(TardisRefined.MODID, "ellen_int"), "ellen_int"), EllenDoorModel::createBodyLayer);
        MOFFAT_INT = register(new ModelLayerLocation(new ResourceLocation(TardisRefined.MODID, "moffat_int"), "moffat_int"), MoffatDoorModel::createBodyLayer);


    }

    @ExpectPlatform
    public static ModelLayerLocation register(ModelLayerLocation location, Supplier<LayerDefinition> definitionSupplier) {
        throw new RuntimeException(PlatformWarning.addWarning(ESModelRegistry.class));
    }

}
