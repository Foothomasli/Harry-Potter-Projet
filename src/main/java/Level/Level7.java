package Level;

import AllSpell.Expelliarmus;
import AllSpell.Sectumsempra;
import    Character.Ennemy.Boss.Bellatrix_Lestrange;
import    Character.Ennemy.Boss.Real_Voldemort;
import    Character.Ennemy.Empty_ennemy;
import    Character.Ennemy.Ennemy;
import    Character.Ennemy.Ennemy7;
import    Character.Wizard;
import    Potion.LifePotion;
import    Potion.MagicPotion;
import    Potion.StrengtheningPotion;
import java.util.Scanner;

public class Level7 {

    Ennemy[] ennemies = new Ennemy[3];
    Ennemy[] boss = new Ennemy[2];
    boolean invalid_operation;
    Ennemy[] surviving_enemy = new Ennemy[3];
    Ennemy[] surviving_boss = new Ennemy[2];

    public Level7(){

        for(int i = 0; i< ennemies.length; i++){
            ennemies[i] = new Ennemy7();
            ennemies[i].name = "Ennemy"+(i+1);
        }
        boss[0] = new Real_Voldemort();
        boss[1] = new Bellatrix_Lestrange();
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
        for (Ennemy ennemy : boss) {

            if (ennemy.hp > 0) {

                System.out.print(ennemy.name + ": " + ennemy.hp + "   ");
            }
        }

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

    void surviving_boss_nb() {

        for(int i = 0; i < surviving_boss.length; i++){

            surviving_boss[i] = new Empty_ennemy();
        }

        for (Ennemy ennemy : boss) {

            if (ennemy.hp > 0) {

                for (int a = 0; a < boss.length; a++) {

                    if (surviving_boss[a].name.equals("null")) {
                        surviving_boss[a] = ennemy;
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

        surviving_boss_nb();
        System.out.print("Choose the boss you want to attack: ");
        for( int i = 0; i < surviving_boss.length; i++){

            if(surviving_boss[i].hp > 0){

                System.out.print( (i+1) + "." + surviving_boss[i].name + "  ");
            }
        }
        System.out.println(" ");
        Scanner scanner = new Scanner(System.in);
        int ennemy = scanner.nextInt();
        switch (ennemy){
            case (1)-> wizard.attack(surviving_boss[0]);
            case (2)-> wizard.attack(surviving_boss[1]);
            default -> {
                System.out.println("Cannot attack this boss, please select action again.\n");
                this.invalid_operation = true;
            }
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

        surviving_boss_nb();
        System.out.print("Choose the boss you want to attack: ");
        for( int i = 0; i < surviving_boss.length; i++){

            if(surviving_boss[i].hp > 0){

                System.out.print( (i+1) + "." + surviving_boss[i].name + "  ");
            }
        }
        System.out.println(" ");
        Scanner scanner = new Scanner(System.in);
        int ennemy = scanner.nextInt();

        switch (ennemy){

            case (1)-> wizard.magicattack(surviving_boss[0]);
            case (2)-> wizard.magicattack(surviving_boss[1]);
            default -> {
                System.out.println("Cannot attack this boss, please select action again.\n");
                this.invalid_operation = true;
            }
        }
    }

    public void ennemy_attack(Wizard wizard){

        for (Ennemy ennemy : ennemies) {

            if (ennemy.hp > 0) {
                ennemy.attack(wizard);
            }
        }
    }

    public void boss_attack(Wizard wizard){

        for (Ennemy ennemy : boss) {

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

        System.out.println("Choose your reward: 1. Increase health and mana 2. Increase defense 3. Increase attack");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        switch (a) {
            case 1 -> {
                wizard.hpmax = wizard.hpmax + 50;
                wizard.mpmax = wizard.mpmax + 25;
            }
            case 2 -> wizard.defense = wizard.defense + 5;
            case 3 -> wizard.wande.size = wizard.wande.size + 5;
        }
        for(int i = 0; i<5; i++){
            wizard.potions[i] = new LifePotion();
        }
        for(int i = 5; i<10; i++){
            wizard.potions[i] = new MagicPotion();
        }
        for(int i = 10; i<15; i++){
            wizard.potions[i] = new StrengtheningPotion();
        }
        wizard.hp = wizard.hpmax;
        wizard.mp = wizard.mpmax;
    }

    public void normal_level(Wizard wizard){

        System.out.println("This is your last year of study, so get ready for the final test.\n");
        System.out.println("To improve abilities, defeat these enemies.");
        while( (ennemies[0].hp > 0 || ennemies[1].hp > 0 || ennemies[2].hp > 0) && wizard.hp > 0) {
            do {
                operater(wizard);
            } while (this.invalid_operation);
            ennemy_attack(wizard);
            System.out.println("The enemy has attacked you.");
            System.out.println("\n");
        }
        if(wizard.hp > 0){
            System.out.println("You learned Expelliarmus");
            Expelliarmus expelliarmus = new Expelliarmus();
            wizard.spell.put(expelliarmus.getName(), expelliarmus);
            System.out.println("Your abilities have been improved\n");
            settlement(wizard);
            System.out.println("\n");
        }
        else {
            System.out.println("You died, game over");
        }
    }

    public void boss_level(Wizard wizard){


        System.out.println("You met Voldemort and Bellatrix Lestrange\n");
        if (boss[0].core.equals(wizard.wande.core)){
            System.out.println("Your wand is the same as Voldemort's, and your attack power has been reduced.");
            boss[0].attack = boss[0].attack - 20;
            wizard.wande.size = wizard.wande.size - 20;
        }

        while( (boss[0].hp > 0 || boss[1].hp >0) && wizard.hp > 0){

            do {
                operater_boss(wizard);
            } while (this.invalid_operation);
            boss_attack(wizard);
            System.out.println("Boss has attacked you.");
            System.out.println("\n");
        }
        if(wizard.hp < 0){

            System.out.println("You died, game over");
        }

    }
}
