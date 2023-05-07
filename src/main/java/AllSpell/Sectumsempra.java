package AllSpell;
import Character.Ennemy.Ennemy;
import lombok.Getter;
import Character.Wizard;

import java.util.Random;

public class Sectumsempra extends Spell{

    @Getter String name = "Sectumsempra";

    @Override
    public boolean usespell(Wizard wizard, Ennemy ennemy) {

        System.out.println("\n");
        System.out.println("You use Sectumsempra to "+ ennemy.name + "\n");
        Random random = new Random();
        int a = random.nextInt(99)+1;
        if(wizard.mp >= 5){

            if(a <= 70){

                ennemy.state = "Weak";
                wizard.mp = wizard.mp - 5;
                System.out.println("You successfully used the spell");
                return true;
            }
            else {

                if(wizard.house.equals("Ravenclaw")){
                    System.out.println("You successfully used the spell");
                    ennemy.state = "Weak";
                    wizard.mp = wizard.mp - 5;
                    return true;
                }
                else {

                    System.out.println("Your spell has failed.");
                    wizard.mp = wizard.mp - 5;
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
