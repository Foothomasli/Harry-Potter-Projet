package Character.Ennemy.Boss;
import Character.Ennemy.Ennemy;
import Character.Wizard;

public class Détraqueurs extends Ennemy {

    public Détraqueurs() {
        super.name = "Détraqueurs";
        super.hp = 250;
        super.defense = 25;
        super.attack = 45;
        super.state = "null";
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

        if(wizard.Temporary_defense > 0 ){

            double damage = wizard.defense(super.attack * 0.8 , wizard.Temporary_defense*0.6);
            wizard.hp = wizard.hp - damage;
            wizard.Temporary_defense = 0;
        }
        else {
            double damage = wizard.defense(super.attack *0.8,wizard.defense*0.6);
            wizard.hp = wizard.hp - damage;
        }
    }

}

