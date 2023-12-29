package mc.craig.software.extra_shells.mixins;

import org.spongepowered.asm.mixin.Mixin;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import whocraft.tardis_refined.common.blockentity.shell.GlobalShellBlockEntity;

@Mixin(GlobalShellBlockEntity.class)
public class GlobalShellBlockEntityMixin implements GeoAnimatable {

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return null;
    }

    @Override
    public double getTick(Object object) {
        return 0;
    }
}
