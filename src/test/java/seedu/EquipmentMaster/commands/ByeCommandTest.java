package seedu.EquipmentMaster.commands;

import static org.junit.jupiter.api.Assertions.*;
import static seedu.EquipmentMaster.common.Messages.MESSAGE_GOODBYE;

import org.junit.jupiter.api.Test;

import seedu.EquipmentMaster.equipmentlist.EquipmentList;
import seedu.EquipmentMaster.storage.Storage;
import seedu.EquipmentMaster.ui.Ui;

class ByeCommandTest {

    @Test
    void isExit_returnsTrue() {
        ByeCommand command = new ByeCommand();
        assertTrue(command.isExit());
    }
}