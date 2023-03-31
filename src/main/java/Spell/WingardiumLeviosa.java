package Spell;

import Character.Ennemy.Ennemy;
import Character.Wizard;
import java.util.Random;


public class WingardiumLeviosa {
    public void usespell(Wizard wizard, Ennemy ennemy){

        Random random = new Random();
        int a = random.nextInt(99)+1;
        if(wizard.mp >= 10){

            if(a>20){
                ennemy.state = "Floating";
                wizard.mp = wizard.mp - 10;
                System.out.println("You successfully used floating spell");
            }
            else {
                System.out.println("Your spell has failed.");
                wizard.mp = wizard.mp - 10;
            }
        }
        else {
            System.out.println("You don't have enough magic");
        }
    }


}