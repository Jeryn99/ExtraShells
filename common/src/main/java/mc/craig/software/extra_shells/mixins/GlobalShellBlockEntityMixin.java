package mc.craig.software.extra_shells.mixins;

import mc.craig.software.extra_shells.AnimationHackery;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;
import whocraft.tardis_refined.common.blockentity.door.GlobalDoorBlockEntity;
import whocraft.tardis_refined.common.blockentity.shell.GlobalShellBlockEntity;

@Mixin(GlobalShellBlockEntity.class)
public class GlobalShellBlockEntityMixin implements AnimationHackery {


    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {

    }

    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return geoCache;
    }

    @Override
    public double getTick(Object object) {
        return getShellEntity().getLevel().getGameTime();
    }

    @Override
    public @Nullable GlobalShellBlockEntity getShellEntity() {
        return ((GlobalShellBlockEntity) (Object) this);
    }

    @Override
    public @Nullable GlobalDoorBlockEntity getDoorEntity() {
        return null;
    }
}
