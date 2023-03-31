package Level;
import    Spell.Accio;
import    Character.Ennemy.Boss.Basilic;
import    Character.Ennemy.Empty_ennemy;
import    Character.Ennemy.Ennemy;
import    Character.Ennemy.Ennemy2;
import    Character.Wizard;
import    Potion.LifePotion;
import    Potion.MagicPotion;
import    Potion.StrengtheningPotion;
import    Wande.Sword_of_Gryffindor;
import java.util.Random;
import java.util.Scanner;


public class Level2 {
    Ennemy[] ennemies = new Ennemy[3];
    Ennemy boss = new Basilic();
    boolean invalid_operation;
    Ennemy[] surviving_enemy = new Ennemy[3];

    public Level2(){

        for(int i = 0; i< ennemies.length; i++){
            ennemies[i] = new Ennemy2();
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
        System.out.print(boss.name + ": " + boss.hp);

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

        wizard.attack(boss);
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

        wizard.magicattack(boss);
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
        if(wizard.house.equals("Gryffindor")){

            wizard.wande = new Sword_of_Gryffindor();
            System.out.println("You got the Sword of Gryffindor");
        }
    }

    public void settlement_boss(Wizard wizard){

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

        System.out.println("You entered the second level\n");
        while( (ennemies[0].hp > 0 || ennemies[1].hp > 0 || ennemies[2].hp > 0) && wizard.hp > 0) {
            do {
                operater(wizard);
            } while (this.invalid_operation);
            ennemy_attack(wizard);
            System.out.println("The enemy has attacked you.");
            System.out.println("\n");
        }
        if(wizard.hp > 0){
            System.out.println("You learned Accio spell");
            System.out.println("Your abilities have been improved");
            settlement(wizard);
            System.out.println("\n");
        }
        else {
            System.out.println("You died, game over");
        }
    }

    public void boss_level(Wizard wizard){
        Random random = new Random();
        int a = random.nextInt(99)+1;
        System.out.println("You met Basilic\n");
        while( boss.hp > 0 && wizard.hp > 0){

            do {
                operater_boss(wizard);
            } while (this.invalid_operation);
            if (a < 80) {

                boss.attack(wizard);
                System.out.println("Boss has attacked you.");
            }
            else {
                boss.skill(wizard);
                System.out.println("The enemy has used a skill.");
            }
            System.out.println("\n");}
        if(wizard.hp > 0){

            if(wizard.house.equals("Gryffindor")){

                System.out.println("You destroyed Tom Jedusor's journal with the Sword of Gryffindor. \n");
                System.out.println("Your abilities have been improved");
            }
            else {
                Accio accio = new Accio();
                accio.usespell();
                System.out.println("You pulled out Basilic's tooth and destroyed Tom Jedusor's diary. \n");
            }
            settlement_boss(wizard);
            System.out.println("\n");}
        else {
            System.out.println("You died, game over");
        }
    }
}
