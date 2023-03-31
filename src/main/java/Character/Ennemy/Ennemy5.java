package Character.Ennemy;
import Character.Wizard;
public class Ennemy5 extends Ennemy{

    public Ennemy5() {
        super.defense = 30;
        super.hp = 250;
        super.attack = 60;
    }

    public double defense( double size , double defense ){

        double damage = size - defense;
        if (damage <= 0){
            damage = 0;
        }
        return damage;
    }

    @Override
    public void attack(Wizard wizard) {

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
