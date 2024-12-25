package dev.jeryn.extra_shells.forge;

import dev.jeryn.extra_shells.ExtraShells;
import dev.jeryn.extra_shells.forge.data.ESEnglish;
import dev.jeryn.extra_shells.forge.data.ESPatterns;
import dev.jeryn.extra_shells.forge.data.ESSoundProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ExtraShells.MODID)
public class ExtraShellsForge {
    public ExtraShellsForge() {
        ExtraShells.init();
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::onGatherData);
    }


    public void onGatherData(GatherDataEvent e) {
        DataGenerator generator = e.getGenerator();
        /*Data Pack*/
        generator.addProvider(e.includeServer(), new ESPatterns(generator));
        generator.addProvider(e.includeClient(), new ESEnglish(generator));
        generator.addProvider(e.includeClient(), new ESSoundProvider(generator.getPackOutput(), e.getExistingFileHelper()));
    }

}