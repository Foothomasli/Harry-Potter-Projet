package Wande;
import Character.Wizard;
import Character.Ennemy.*;
import java.util.Random;

public class Sword_of_Gryffindor extends Wande{

    public Sword_of_Gryffindor(){

        super.core = "Sword_of_Gryffindor";
        super.size = 70;
    }

    public void attack(Wizard wizard, Ennemy ennemy){

        Random random = new Random();
        int a = random.nextInt(100)+1;

        if(ennemy.hp > 0){

            if (a > 20) {
                ennemy.hp = ennemy.hp - ennemy.defense(this.size, ennemy.defense);
            }
            else {
                System.out.println("Your attack was dodged.");
            }
        }
        else{
            System.out.println(" This enemy is dead. ");
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
            System.out.println("This enemy is dead.");
        }
    }
}

