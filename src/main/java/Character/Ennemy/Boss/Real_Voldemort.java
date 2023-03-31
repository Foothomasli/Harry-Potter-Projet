package Character.Ennemy.Boss;
import Character.Ennemy.Ennemy;
import Character.Wizard;
import java.util.Random;
import Spell.Avada_Kedavra;
import Spell.Expelliarmus;
public class Real_Voldemort extends Ennemy {

    public Real_Voldemort(){

        super.name = "Voldemort";
        super.hp = 300;
        super.defense = 35;
        super.attack = 85;
        Random random = new Random();
        int a = random.nextInt(49) + 1;
        if (a < 25){

            super.core = "DRAGON HEARTSTRING";
        }
        else {
            super.core = "PHOENIX FEATHER";
        }
    }
    public void attack (Wizard wizard){

        Random random = new Random();
        int a = random.nextInt(100);
        if(a < 12){

            Avada_Kedavra avada_kedavra = new Avada_Kedavra();
            avada_kedavra.usespell(wizard);
            Expelliarmus expelliarmus = new Expelliarmus();
            expelliarmus.usespell(wizard);
        }
        else {

            if(wizard.Temporary_defense > 0 ){

                double damage = wizard.defense(super.attack , wizard.Temporary_defense);
                wizard.hp = wizard.hp - damage;
                wizard.Temporary_defense = 0;
            }
            else {
                double damage = wizard.defense(super.attack,wizard.defense);
                wizard.hp = wizard.hp - damage;
            }
        }

    }
    public double defense( double size , double defense ){

        double damage;
        damage = size - defense;
        if (damage < 0)
        {damage = 0;}
        return damage;
    }

    @Override
    public void skill( Wizard wizard) {

        Avada_Kedavra avada_kedavra = new Avada_Kedavra();
        avada_kedavra.usespell(wizard);
    }
}

