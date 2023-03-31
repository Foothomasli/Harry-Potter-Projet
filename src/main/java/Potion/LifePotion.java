package Potion;
import Character.Wizard;
public class LifePotion extends Potion{



    public LifePotion() {
        super.name = "LifePotion";
    }

    @Override
    public void usePotion(Wizard wizard) {

        if(wizard.house.equals("Hufflepuff")){

            wizard.hp = wizard.hp + 75;
        }
        else {
            wizard.hp = wizard.hp + 50;
        }
        if (wizard.hp > wizard.hpmax){
            wizard.hp = wizard.hpmax;
        }
    }


}
