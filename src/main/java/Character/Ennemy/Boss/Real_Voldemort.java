package Character.Ennemy.Boss;
import Character.Ennemy.Ennemy;
import Character.Wizard;
import java.util.Random;
import AllSpell.ForbiddenSpell;

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
        if(a < 40){

            this.skill(wizard);
            System.out.println("Voldemort uses Avada Kedavra , You need to use Expelliarmus to protect yourself, otherwise you will die instantly.");
            if(wizard.mp >=5){
                wizard.useSpell(this);
            }
            else {
                wizard.hp = 0;
            }
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

        ForbiddenSpell forbiddenSpell = new ForbiddenSpell();
        forbiddenSpell.usespell(wizard,this);
    }
}

