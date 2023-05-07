package AllSpell;
import Character.Ennemy.Ennemy;
import Character.Wizard;
import lombok.Getter;


public class Expelliarmus extends Spell{

    @Getter String name = "Expelliarmus";

    @Override
    public boolean usespell(Wizard wizard, Ennemy ennemy) {

        System.out.println("\n");
        System.out.println("You use Expelliarmus");
        if(wizard.mp >= 5){

            System.out.println("You successfully used the spell");
            return true;
        }
        else {

            System.out.println("You don't have enough magic");
            return false;
        }
    }
}
