package mc.craig.software.extra_shells.geo;

import mc.craig.software.extra_shells.AnimationHackery;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.model.GeoModel;
import whocraft.tardis_refined.TardisRefined;
import whocraft.tardis_refined.common.blockentity.shell.GlobalShellBlockEntity;
import whocraft.tardis_refined.patterns.ShellPattern;

public class GeoShellModel extends GeoModel<AnimationHackery> {
    @Override
    public ResourceLocation getModelResource(AnimationHackery animatable) {
        @Nullable GlobalShellBlockEntity shell = animatable.getShellEntity();
        ResourceLocation currentTheme = shell.theme();
        return new ResourceLocation(currentTheme.getNamespace(), "geo/" + currentTheme.getPath() + ".geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AnimationHackery animatable) {
        @Nullable GlobalShellBlockEntity shell = animatable.getShellEntity();
        ShellPattern shellPattern = shell.pattern();
        return shellPattern.exteriorDoorTexture().texture();
    }

    @Override
    public ResourceLocation getAnimationResource(AnimationHackery animatable) {
        return null;
    }
}
