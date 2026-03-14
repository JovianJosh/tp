package seedu.equipmentmaster.semester;

import org.junit.jupiter.api.Test;
import seedu.equipmentmaster.exception.EquipmentMasterException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Tests the logic of the AcademicSemester class, including parsing and age calculation.
 */
public class AcademicSemesterTest {

    @Test
    public void constructor_validFormat_success() throws EquipmentMasterException {
        AcademicSemester sem = new AcademicSemester("AY2024/25 Sem1");
        assertEquals("AY2024/25 Sem1", sem.toString());
    }

    @Test
    public void constructor_invalidYearGap_throwsException() {
        // Gap is more than 1 year (2024 to 26)
        assertThrows(EquipmentMasterException.class, () -> new AcademicSemester("AY2024/26 Sem1"));
    }

    @Test
    public void constructor_invalidFormat_throwsException() {
        // Missing "AY" prefix
        assertThrows(EquipmentMasterException.class, () -> new AcademicSemester("2024/25 Sem1"));
        // Invalid Semester number
        assertThrows(EquipmentMasterException.class, () -> new AcademicSemester("AY2024/25 Sem3"));
    }

    @Test
    public void calculateAge_fiveSemestersGap_returnsCorrectYears() throws EquipmentMasterException {
        AcademicSemester purchase = new AcademicSemester("AY2024/25 Sem1");
        AcademicSemester current = new AcademicSemester("AY2026/27 Sem2");

        // Calculation: ((2026 - 2024) * 2) + (2 - 1) = 5 Semesters = 2.5 Years
        assertEquals(2.5, purchase.calculateAgeInYears(current), 0.01);
    }
}