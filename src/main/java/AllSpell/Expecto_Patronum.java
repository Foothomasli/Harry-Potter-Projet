package AllSpell;
import Character.Ennemy.Ennemy;
import lombok.Getter;
import Character.Wizard;
import java.util.Random;


public class Expecto_Patronum extends AbstractSpell {

    @Getter
    public String name = "Expecto Patronum";
    public boolean usespell(Wizard wizard, Ennemy ennemy){

        System.out.println("\n");
        System.out.println("You use Expecto Patronum to "+ ennemy.name + "\n");
        Random random = new Random();
        int a = random.nextInt(99)+1;
        if(wizard.mp >= 5){

            if(a <= 70){

                wizard.mp = wizard.mp - 5;
                ennemy.state = "Oppressed";
                System.out.println("You successfully used the spell");
                return true;
            }
            else {

                if(wizard.house.equals("Ravenclaw")){
                    System.out.println("You successfully used the spell");
                    ennemy.state = "oppressed";
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

