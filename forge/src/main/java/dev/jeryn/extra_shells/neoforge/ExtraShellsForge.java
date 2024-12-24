package dev.jeryn.extra_shells.neoforge;

import dev.jeryn.extra_shells.ExtraShells;
import dev.jeryn.extra_shells.neoforge.data.ESEnglish;
import dev.jeryn.extra_shells.neoforge.data.ESPatterns;
import dev.jeryn.extra_shells.neoforge.data.ESSoundProvider;
import net.minecraft.data.DataGenerator;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;
import net.neoforged.neoforge.data.event.GatherDataEvent;

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