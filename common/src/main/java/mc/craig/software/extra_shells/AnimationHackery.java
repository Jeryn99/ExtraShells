package mc.craig.software.extra_shells;

import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import whocraft.tardis_refined.common.blockentity.door.GlobalDoorBlockEntity;
import whocraft.tardis_refined.common.blockentity.shell.GlobalShellBlockEntity;

public interface AnimationHackery extends GeoAnimatable {

    @Nullable GlobalShellBlockEntity getShellEntity();
    @Nullable GlobalDoorBlockEntity getDoorEntity();
}
