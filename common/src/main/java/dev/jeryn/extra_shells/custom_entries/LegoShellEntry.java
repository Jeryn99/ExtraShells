package dev.jeryn.extra_shells.custom_entries;

import dev.jeryn.extra_shells.ESModelRegistry;
import dev.jeryn.extra_shells.ExtraShells;
import whocraft.tardis_refined.client.model.blockentity.door.interior.ShellDoorModel;
import whocraft.tardis_refined.client.model.blockentity.shell.ShellEntry;
import whocraft.tardis_refined.client.model.blockentity.shell.ShellModel;
import whocraft.tardis_refined.patterns.ShellPattern;

public class LegoShellEntry extends ShellEntry {

    public LegoShellEntry(ShellModel shellModel, ShellDoorModel shellDoorModel) {
        super(shellModel, shellDoorModel);
    }

    @Override
    public ShellModel getShellModel(ShellPattern shellPattern) {

        if(shellPattern.id().getPath().contains("dimensions") && shellPattern.id().getNamespace().contains(ExtraShells.MODID)){
            return ESModelRegistry.LEGO_DIMENSIONS_EXT_MDL;
        }

        if(shellPattern.id().getPath().contains("piece") && shellPattern.id().getNamespace().contains(ExtraShells.MODID)){
            return ESModelRegistry.LEGO_PIECE_EXT_MDL;
        }

        return super.getShellModel(shellPattern);
    }

    @Override
    public ShellDoorModel getShellDoorModel(ShellPattern shellPattern) {

        if(shellPattern.id().getPath().contains("piece") && shellPattern.id().getNamespace().contains(ExtraShells.MODID)){
            return ESModelRegistry.LEGO_PIECE_INT_MDL;
        }

        return super.getShellDoorModel(shellPattern);
    }
}
