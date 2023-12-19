package mc.craig.software.extra_shells.forge;

import mc.craig.software.extra_shells.ExtraShells;
import mc.craig.software.extra_shells.forge.data.ESEnglish;
import mc.craig.software.extra_shells.forge.data.TEPatterns;
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
        generator.addProvider(e.includeServer(), new TEPatterns(generator));
        generator.addProvider(e.includeClient(), new ESEnglish(generator));
    }

}