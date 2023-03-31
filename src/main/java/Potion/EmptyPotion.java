package Potion;
import Character.Wizard;
public class EmptyPotion extends Potion{

    public EmptyPotion(){
        super.name = "Empty";
    }

    @Override
    public void usePotion(Wizard wizard) {
    }
}
