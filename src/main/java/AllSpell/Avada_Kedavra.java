package AllSpell;
import Character.Wizard;
public class Avada_Kedavra {

    public void usespell(Wizard wizard){

        System.out.println("Voldemort used Avada Kedavra");
        wizard.hp = wizard.hp - 50;
    }
}
