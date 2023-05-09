package Potion;

public class Quantity_Detector {

    public boolean LifePotionVide(Potion[] potions){
        for (Potion potion : potions) {
            if (potion.name.equals("LifePotion")) {
                return false;
            }
        }
        return true;
    }

    public boolean MagicPotionVide(Potion[] potions){
        for (Potion potion : potions) {
            if (potion.name.equals("MagicPotion")) {
                return false;
            }
        }
        return true;
    }

    public boolean StrengtheningPotionVide(Potion[] potions){

        for (Potion potion : potions) {
            if (potion.name.equals("StrengtheningPotion")) {
                return false;
            }
        }
        return true;
    }
}
