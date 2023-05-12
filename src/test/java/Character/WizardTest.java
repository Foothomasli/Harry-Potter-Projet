package Character;
import static org.junit.jupiter.api.Assertions.*;

class WizardTest {

    @org.junit.jupiter.api.Test
    void defense() {

        var wizard = new Wizard();
        wizard.house = "Gryffindor";
        assertEquals(16,wizard.defense(40,20));
    }
}