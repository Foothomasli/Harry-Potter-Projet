package Potion;
import Character.Wizard;
public class StrengtheningPotion extends Potion{

    public StrengtheningPotion() {
        super.name = "StrengtheningPotion";
    }

    @Override
    public void usePotion(Wizard wizard) {

        if(wizard.house.equals("Hufflepuff")){

            wizard.Temporary_defense = wizard.defense + 75;
        }
        else {
            wizard.Temporary_defense = wizard.defense + 50;
        }
    }

}
