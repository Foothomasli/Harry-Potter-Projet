package  Level;
import   AllSpell.WingardiumLeviosa;
import   Character.Ennemy.Boss.Troll;
import   Character.Ennemy.Empty_ennemy;
import   Character.Ennemy.Ennemy;
import   Character.Ennemy.Ennemy1;
import   Character.Wizard;
import   Potion.LifePotion;
import   Potion.MagicPotion;
import   Potion.StrengtheningPotion;
import   java.util.Scanner;

public class Level1 {

    Ennemy[] ennemies = new Ennemy[3];
    Ennemy boss = new Troll();
    boolean invalid_operation;
    Ennemy[] surviving_enemy = new Ennemy[3];


    public Level1(){

        for(int i = 0; i< ennemies.length; i++){
            ennemies[i] = new Ennemy1();
            ennemies[i].name = "Ennemy"+(i+1);
        }
    }

    public void affiche(Wizard wizard){

        System.out.print(wizard.name + " :" + wizard.hp + "   mp: " + wizard.mp + "     ");
        int potion1 = 0 , potion2 = 0, potion3 = 0;
        for (int i = 0; i<wizard.potions.length; i++){

            switch (wizard.potions[i].name){

                case "LifePotion"->potion1++;
                case "MagicPotion"->potion2++;
                case "StrengtheningPotion"->potion3++;
            }
        }
        System.out.print("LifePotion: "+potion1+"  "+"MagicPotion: "+potion2+"  "+"StrengtheningPotion: "+potion3+"  ");
        System.out.print("                   ");
        for (Ennemy ennemy : ennemies) {

            if (ennemy.hp > 0) {

                System.out.print(ennemy.name + ": " + ennemy.hp + "   ");
            }
        }
    }

    public void affiche_boss(Wizard wizard){

        System.out.print(wizard.name + " :" + wizard.hp + "   mp: " + wizard.mp + "     ");
        int potion1 = 0 , potion2 = 0, potion3 = 0;
        for (int i = 0; i<wizard.potions.length; i++){

            switch (wizard.potions[i].name){

                case "LifePotion"->potion1++;
                case "MagicPotion"->potion2++;
                case "StrengtheningPotion"->potion3++;
            }
        }
        System.out.print("LifePotion: "+potion1+"  "+"MagicPotion: "+potion2+"  "+"StrengtheningPotion: "+potion3+"  ");
        System.out.print("                   ");
        System.out.print(boss.name + ": " + boss.hp + "    " + "State: " + boss.state);

    }

    void surviving_enemy_nb(){

        for(int i = 0; i < surviving_enemy.length; i++){

            surviving_enemy[i] = new Empty_ennemy();
        }


        for (Ennemy ennemy : ennemies) {

            if (ennemy.hp > 0) {

                for (int a = 0; a < surviving_enemy.length; a++) {

                    if (surviving_enemy[a].name.equals("null")) {

                        surviving_enemy[a] = ennemy;
                        break;
                    }
                }
            }
        }
    }

    public void attack(Wizard wizard){

        surviving_enemy_nb();
        System.out.print("Choose the ennemy you want to attack: ");
        for( int i = 0; i < surviving_enemy.length; i++){

            if(surviving_enemy[i].hp > 0){

                System.out.print( (i+1) + "." + surviving_enemy[i].name + "  ");
            }
        }
        System.out.println(" ");
        Scanner scanner = new Scanner(System.in);
        int ennemy = scanner.nextInt();

        switch (ennemy){
            case (1)-> wizard.attack(surviving_enemy[0]);
            case (2)-> wizard.attack(surviving_enemy[1]);
            case (3)-> wizard.attack(surviving_enemy[2]);
            default -> {
                System.out.println("Cannot attack this ennemy, please select action again.\n");
                this.invalid_operation = true;
            }
        }
    }

    public void attack_boss(Wizard wizard){

        if(boss.state.equals("Floating")){

            wizard.attack(boss);
        }
        else {
            System.out.println("You cannot attack the boss, he is not floating.");
        }
    }

    public void magic_attack(Wizard wizard){

        surviving_enemy_nb();
        System.out.print("Choose the ennemy you want to attack: ");
        for( int i = 0; i < surviving_enemy.length; i++){

            if(surviving_enemy[i].hp > 0){

                System.out.print( (i+1) + "." + surviving_enemy[i].name + "  ");
            }
        }
        System.out.println(" ");
        Scanner scanner = new Scanner(System.in);
        int ennemy = scanner.nextInt();

        switch (ennemy){

            case (1)-> wizard.magicattack(surviving_enemy[0]);
            case (2)-> wizard.magicattack(surviving_enemy[1]);
            case (3)-> wizard.magicattack(surviving_enemy[2]);
            default -> {
                System.out.println("Cannot attack this ennemy, please select action again.\n");
                this.invalid_operation = true;
            }
        }
    }

    public void magic_attack_boss(Wizard wizard){

        if(boss.state.equals("Floating")){

            wizard.magicattack(boss);
        }
        else {
            System.out.println("You cannot attack the boss, he is not floating.");
        }
    }

    public void ennemy_attack(Wizard wizard){

        for (Ennemy ennemy : ennemies) {

            if (ennemy.hp > 0) {
                ennemy.attack(wizard);
            }
        }
    }

    public void operater( Wizard wizard){

        Scanner scanner = new Scanner(System.in);
        affiche(wizard);
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Choose what you want to do : 1. attack  2. magicattack  3. use the potion");
        int a = scanner.nextInt();
        this.invalid_operation = false;
        switch (a){
            case 1 -> attack(wizard);
            case 2 -> magic_attack(wizard);
            case 3 -> wizard.usePotion();
            default -> {
                System.out.println("This operation is invalid, please select action again.\n");
                this.invalid_operation = true;
            }
        }
    }

    public void operater_boss(Wizard wizard){

        Scanner scanner = new Scanner(System.in);
        affiche_boss(wizard);
        System.out.println("\n");
        wizard.useSpell(boss);
        affiche_boss(wizard);
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Choose what you want to do : 1. attack  2. magicattack  3. use the potion");
        int a = scanner.nextInt();
        this.invalid_operation = false;
        switch (a){
            case 1 -> {attack_boss(wizard); System.out.println("You attacked the enemy.");}
            case 2 -> {magic_attack_boss(wizard); System.out.println("You attacked the enemy.");}
            case 3 -> {wizard.usePotion(); System.out.println("You used a potion.");}
            default -> {
                System.out.println("This operation is invalid, please select action again.\n");
                this.invalid_operation = true;
            }
        }
    }

    public void settlement(Wizard wizard){

        wizard.hpmax = wizard.hpmax + 50;
        wizard.mpmax = wizard.mpmax + 25;
        wizard.defense = wizard.defense + 5;
        wizard.hp = wizard.hpmax;
        wizard.mp = wizard.mpmax;
        for(int i = 0; i<5; i++){
            wizard.potions[i] = new LifePotion();
        }
        for(int i = 5; i<10; i++){
            wizard.potions[i] = new MagicPotion();
        }
        for(int i = 10; i<15; i++){
            wizard.potions[i] = new StrengtheningPotion();
        }
    }

    public void normal_level(Wizard wizard){

        System.out.println("You entered the first level\n");
        while( (ennemies[0].hp > 0 || ennemies[1].hp > 0 || ennemies[2].hp > 0) && wizard.hp > 0) {
            do {
                operater(wizard);
            } while (this.invalid_operation);
            ennemy_attack(wizard);
            System.out.println("The enemy has attacked you.");
            System.out.println("\n");
        }
        if(wizard.hp > 0){

            System.out.println("You learned Wingardium Leviosa");
            WingardiumLeviosa wingardiumLeviosa = new WingardiumLeviosa();
            wizard.spell.put(wingardiumLeviosa.getName(), wingardiumLeviosa);
            settlement(wizard);
            System.out.println("Your abilities have been improved\n");
            System.out.println("\n");
        }
        else {
            System.out.println("You died, game over");
        }
    }

    public void boss_level(Wizard wizard){

        System.out.println("You met Troll\n");
        while( boss.hp > 0 && wizard.hp > 0){

            do {
                operater_boss(wizard);
            } while (this.invalid_operation);
            boss.attack(wizard);
            System.out.println("Boss has attacked you.");
            boss.state = "null";
            System.out.println("\n");

        }
        if(wizard.hp > 0){

            settlement(wizard);
            System.out.println("Your abilities have been improved\n");
        }
        else {
            System.out.println("You died, game over");
        }
    }

}
