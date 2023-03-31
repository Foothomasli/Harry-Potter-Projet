package Potion;
import Character.Wizard;
public class MagicPotion extends Potion {

    public MagicPotion() {
        super.name = "MagicPotion";
    }

    @Override
    public void usePotion(Wizard wizard) {

        if (wizard.house.equals("Hufflepuff")){

            wizard.mp = wizard.mp + 40;
        }
        else {
            wizard.mp = wizard.mp + 25;
        }

        if (wizard.mp > wizard.mpmax){
            wizard.mp = wizard.mpmax;
        }
    }


}
