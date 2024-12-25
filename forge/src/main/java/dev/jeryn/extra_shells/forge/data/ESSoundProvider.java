package dev.jeryn.extra_shells.forge.data;

import dev.jeryn.extra_shells.ESSounds;
import dev.jeryn.extra_shells.ExtraShells;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SoundDefinition;
import net.minecraftforge.common.data.SoundDefinitionsProvider;

public class ESSoundProvider extends SoundDefinitionsProvider {


    public ESSoundProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, ExtraShells.MODID, helper);
    }

    @Override
    public void registerSounds() {
        this.add(ESSounds.DELOREAN_OPEN.get(), this.basicSound("delorean_open", new ResourceLocation(ExtraShells.MODID, "delorean_open")));
        this.add(ESSounds.DELOREAN_CLOSED.get(), this.basicSound("delorean_closed", new ResourceLocation(ExtraShells.MODID, "delorean_closed")));
        this.add(ESSounds.DELOREAN_LOCKED.get(), this.basicSound("delorean_locked", new ResourceLocation(ExtraShells.MODID, "delorean_locked")));

    }

    public SoundDefinition basicSound(String langKey, ResourceLocation resourceLocation) {
        return SoundDefinition.definition().with(SoundDefinition.Sound.sound(resourceLocation, SoundDefinition.SoundType.SOUND)).subtitle(createSubtitle(langKey));
    }

    public static String createSubtitle(String langKey) {
        return "sound." + langKey + ".subtitle";
    }
}
