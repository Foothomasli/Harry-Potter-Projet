package Wande;
import Character.Wizard;
import Character.Ennemy.*;


public class Sword_of_Gryffindor extends Wande{

    public Sword_of_Gryffindor(){
        super.core = "Sword_of_Gryffindor";
        super.size = 170;
    }

    public void attack(Wizard wizard, Ennemy ennemy){

        if(ennemy.hp > 0){

            ennemy.hp = ennemy.hp - ennemy.defense(this.size, ennemy.defense);
        }
        else {

            System.out.println(" This enemy was dead. ");
        }

    }

    public void magicattack(Wizard wizard, Ennemy ennemy){

        if(ennemy.hp >0){

            if(wizard.mp >= 5) {

                ennemy.hp = ennemy.hp - ennemy.defense(this.size, ennemy.defense * 0.5);
                wizard.mp = wizard.mp - 5;
            }
            else {

                System.out.println("You don't have enough mp");
            }
        }
        else {

            System.out.println("This enemy was dead.");
        }
    }
}

