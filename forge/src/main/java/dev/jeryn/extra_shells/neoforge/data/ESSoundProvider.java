package dev.jeryn.extra_shells.neoforge.data;

import dev.jeryn.extra_shells.ESSounds;
import dev.jeryn.extra_shells.ExtraShells;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.SoundDefinition;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;
import whocraft.tardis_refined.common.data.SoundProvider;
import whocraft.tardis_refined.registry.TRSoundRegistry;

public class ESSoundProvider extends SoundDefinitionsProvider {


    public ESSoundProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, ExtraShells.MODID, helper);
    }

    @Override
    public void registerSounds() {
        this.add(ESSounds.DELOREAN_OPEN.get(), this.basicSound("delorean_open", new ResourceLocation(ExtraShells.MODID, "delorean_open")));
        this.add(ESSounds.DELOREAN_CLOSED.get(), this.basicSound("delorean_closed", new ResourceLocation(ExtraShells.MODID, "delorean_closed")));

    }

    public SoundDefinition basicSound(String langKey, ResourceLocation resourceLocation) {
        return SoundDefinition.definition().with(SoundDefinition.Sound.sound(resourceLocation, SoundDefinition.SoundType.SOUND)).subtitle(createSubtitle(langKey));
    }

    public static String createSubtitle(String langKey) {
        return "sound." + langKey + ".subtitle";
    }
}
