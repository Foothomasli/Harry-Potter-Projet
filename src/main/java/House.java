import java.util.Random;
import Character.Wizard;
public class House {

    public void SortingHat(Wizard wizard){

            Random random = new Random();
            int a = random.nextInt(100)+1;
            if( a<=25){
                wizard.house = "Hufflepuff";
            }
            else if ( a<=50) {
                wizard.house = "Slytherin";
            }
            else if(a<=75){
                wizard.house = "Gryffindor";
            }
            else{
                wizard.house = "Ravenclaw";
            }

        }
}

