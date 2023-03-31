package Character.Ennemy.Boss;
import Character.Ennemy.Ennemy;
import Character.Wizard;

public class Mangemorts extends Ennemy {

    public Mangemorts(){

        super.name = "Mangemorts";
        super.hp = 500;
        super.defense = 40;
        super.attack = 55;
    }

    public void attack (Wizard wizard){

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


    public double defense( double size , double defense ){

        double damage;
        damage = size - defense;
        if (damage < 0)
        {damage = 0;}
        return damage;
    }

    @Override
    public void skill( Wizard wizard) {

    }
}