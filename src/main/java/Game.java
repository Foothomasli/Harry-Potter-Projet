
import    Character.Wizard;
import    Level.*;


public class Game{
    
    // Project Li Qiushi

    public static void main(String[] args) {

        //创建角色
        Wizard wizard = new Wizard();

        //分配学院
        SortingHat sortingHat = new SortingHat();
        sortingHat.sortingHat(wizard);
        System.out.println("Your house is : " + wizard.house + "\n");

        System.out.println("Game start");
        System.out.println(" ");

        Level1 level1 = new Level1();
        Level2 level2 = new Level2();
        Level3 level3 = new Level3();
        Level4 level4 = new Level4();
        Level5 level5 = new Level5();
        Level6 level6 = new Level6();
        Level7 level7 = new Level7();


        level1.normal_level(wizard);

        if (wizard.hp > 0){
            level1.boss_level(wizard);
        }

        if (wizard.hp > 0){
            level2.normal_level(wizard);
        }

        if (wizard.hp > 0){
            level2.boss_level(wizard);
        }

        if (wizard.hp > 0){
            level3.normal_level(wizard);
        }

        if (wizard.hp > 0){
            level3.boss_level(wizard);
        }

        if (wizard.hp > 0){
            level4.normal_level(wizard);
        }

        if (wizard.hp > 0){

            level4.boss_level(wizard);
        }

        if (wizard.hp > 0){
            level5.normal_level(wizard);
        }

        if (wizard.hp > 0){
            level5.boss_level(wizard);
        }


        if (wizard.hp > 0){
            level6.normal_level(wizard);
        }

        if (wizard.hp > 0){
            level6.boss_level(wizard);
        }

        if (wizard.hp > 0){
            level7.normal_level(wizard);
        }

        if (wizard.hp > 0){
            level7.boss_level(wizard);
        }

        if (wizard.hp > 0){

            System.out.println("You have successfully defeated Voldemort, now you are the strongest wizard in the world!");
        }

    }
}


