package Character.Ennemy;
import Character.Wizard;
public class Ennemy1 extends Ennemy{


    public Ennemy1() {
        super.defense = 10;
        super.hp = 100;
        super.attack = 12;
    }

    public double defense( double size , double defense ){

        double damage = size - defense;
        if (damage < 0){
            damage = 0;
        }
        return damage;
    }

    public void attack (Wizard wizard){

        if(wizard.Temporary_defense != 0 ){

            double damage = wizard.defense(super.attack , wizard.Temporary_defense);
            wizard.hp = wizard.hp - damage;
            wizard.Temporary_defense = 0;
        }
        else {
            double damage = wizard.defense(super.attack,wizard.defense);
            wizard.hp = wizard.hp - damage;
        }
    }

    @Override
    public void skill(Wizard wizard) {

    }
}
