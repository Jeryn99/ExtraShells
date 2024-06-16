package mc.craig.software.extra_shells.custom_entries;

import mc.craig.software.extra_shells.ESModelRegistry;
import mc.craig.software.extra_shells.ExtraShells;
import whocraft.tardis_refined.client.model.blockentity.door.interior.ShellDoorModel;
import whocraft.tardis_refined.client.model.blockentity.shell.ShellEntry;
import whocraft.tardis_refined.client.model.blockentity.shell.ShellModel;
import whocraft.tardis_refined.patterns.ShellPattern;

public class RTDChibnallShellEntry extends ShellEntry {

    public RTDChibnallShellEntry(ShellModel shellModel, ShellDoorModel shellDoorModel) {
        super(shellModel, shellDoorModel);
    }

    @Override
    public ShellDoorModel getShellDoorModel(ShellPattern shellPattern) {

        if(shellPattern.id().getPath().contains("fourteen") && shellPattern.id().getNamespace().contains(ExtraShells.MODID)){
            return ESModelRegistry.RTD2_INT_MODEL;
        }

        return super.getShellDoorModel(shellPattern);
    }
}
