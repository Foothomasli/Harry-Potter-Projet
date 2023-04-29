package AllSpell;
import Character.Wizard;

public class Expelliarmus {

    public void usespell(Wizard wizard){

        System.out.println(wizard.name + "used Expelliarmus");
        wizard.Temporary_defense = 100;
    }
}
