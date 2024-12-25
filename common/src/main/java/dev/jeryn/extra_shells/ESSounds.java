
package dev.jeryn.extra_shells;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import whocraft.tardis_refined.registry.DeferredRegistry;
import whocraft.tardis_refined.registry.RegistrySupplier;

public class ESSounds {

    public static final DeferredRegistry<SoundEvent> SOUNDS = DeferredRegistry.create(ExtraShells.MODID, Registries.SOUND_EVENT);
    public static final RegistrySupplier<SoundEvent> DELOREAN_OPEN = setUpSound("delorean_open");
    public static final RegistrySupplier<SoundEvent> DELOREAN_CLOSED = setUpSound("delorean_closed");
    public static final RegistrySupplier<SoundEvent> DELOREAN_LOCKED = setUpSound("delorean_locked");


    private static RegistrySupplier<SoundEvent> setUpSound(String soundName) {
        SoundEvent sound = SoundEvent.createVariableRangeEvent(new ResourceLocation(ExtraShells.MODID, soundName));
        return SOUNDS.register(soundName, () -> {
            return sound;
        });
    }

}
