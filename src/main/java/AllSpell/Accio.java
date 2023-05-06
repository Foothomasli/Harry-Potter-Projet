package AllSpell;
import Character.Ennemy.Ennemy;
import lombok.Getter;
import Character.Wizard;

import java.util.Random;


public class Accio extends Spell{

    @Getter public String name = "Accio";
    public boolean usespell(Wizard wizard, Ennemy ennemy){

        Random random = new Random();
        int a = random.nextInt(99)+1;
        if(wizard.mp >= 10) {

            if (a <= 30) {
                System.out.println("You have successfully pulled out a tusk.");
                return true;
            }
            else {

                if (wizard.house.equals("Ravenclaw")) {

                    System.out.println("You have successfully pulled out a tusk.");
                    return true;

                } else {
                    System.out.println("The spell has failed, please try again.");
                    return false;
                }
            }
        }
        else {
            System.out.println("You don't have enough magic");
            return false;
        }

    }
}
