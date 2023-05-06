package Wande;
import Character.Wizard;
import Character.Ennemy.*;
import java.util.Random;

public class PHOENIX_FEATHER extends Wande {

    public PHOENIX_FEATHER() {

        super.core = "PHOENIX FEATHER";

        super.size = 130;
    }


    @Override
    public void attack(Wizard wizard, Ennemy ennemy) {

        if(ennemy.hp > 0){

            ennemy.hp = ennemy.hp - ennemy.defense(this.size, ennemy.defense);
        }
        else{

            System.out.println(" This enemy was dead. ");
        }
    }

    public void magicattack(Wizard wizard, Ennemy ennemy) {

        if(ennemy.hp > 0){

            if (wizard.mp >= 5) {

                if (wizard.house.equals("Slytherin")) {

                    ennemy.hp = ennemy.hp - 1.5 * ennemy.defense(this.size, ennemy.defense);
                }
                else {

                    ennemy.hp = ennemy.hp - 1.2 * ennemy.defense(this.size, ennemy.defense);
                }
                wizard.mp = wizard.mp - 5;
            }
            else {

                System.out.println("You don't have enough mp");
            }
        }
        else {

            System.out.println(" This enemy was dead. ");
        }
    }
}
