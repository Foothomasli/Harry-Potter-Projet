package AllSpell;
import Character.Ennemy.Ennemy;
import Character.Wizard;
import java.util.Random;
import lombok.Getter;

public class WingardiumLeviosa extends Spell{

    @Getter
    public String name = "Wingardium Leviosa";
    public boolean usespell(Wizard wizard, Ennemy ennemy){

        System.out.println("\n");
        System.out.println("You use Wingardium Leviosa to "+ ennemy.name + "\n");
        Random random = new Random();
        int a = random.nextInt(99)+1;
        if(wizard.mp >= 5){

            if(a <= 30){

                ennemy.state = "Floating";
                wizard.mp = wizard.mp - 5;
                System.out.println("You successfully used the spell");
                return true;
            }
            else {

                if(wizard.house.equals("Ravenclaw")){
                    System.out.println("You successfully used the spell");
                    ennemy.state = "Floating";
                    wizard.mp = wizard.mp - 5;
                    return true;
                }
                else {

                    System.out.println("Your spell has failed.");
                    wizard.mp = wizard.mp - 5;
                    return false;
                }
            }
        }
        else {
            System.out.println("You don't have enough magic");
            return false;
        }
    }

}