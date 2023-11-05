package mc.craig.software.extra_shells.forge;

import mc.craig.software.extra_shells.ExtraShells;
import mc.craig.software.extra_shells.forge.data.ESEnglish;
import mc.craig.software.extra_shells.forge.data.TEPatterns;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ExtraShells.MODID)
public class ExtraShellsForge {
    public ExtraShellsForge() {
        ExtraShells.init();
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::onGatherData);
    }

    public void onGatherData(GatherDataEvent e) {
        DataGenerator generator = e.getGenerator();
        /*Data Pack*/
        generator.addProvider(e.includeServer(), new TEPatterns(generator));
        generator.addProvider(e.includeClient(), new ESEnglish(generator));
    }

}