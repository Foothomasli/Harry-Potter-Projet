package Level;

import    Character.Ennemy.Boss.Peter_Pettigrow;
import    Character.Ennemy.Boss.Voldemort;
import    Character.Ennemy.Empty_ennemy;
import    Character.Ennemy.Ennemy;
import    Character.Ennemy.Ennemy4;
import    Character.Wizard;
import    Potion.LifePotion;
import    Potion.MagicPotion;
import    Potion.StrengtheningPotion;

import java.util.Scanner;

public class Level4 {

    private Ennemy[] ennemies = new Ennemy[3];
    private Ennemy[] boss = new Ennemy[2];
    private boolean invalid_operation;
    private Ennemy[] surviving_enemy = new Ennemy[3];
    private Ennemy[] surviving_boss = new Ennemy[2];

    public Level4(){

        for(int i = 0; i< ennemies.length; i++){
            ennemies[i] = new Ennemy4();
            ennemies[i].name = "Ennemy"+(i+1);
        }
        boss[0] = new Voldemort();
        boss[1] = new Peter_Pettigrow();
    }

    private void affiche(Wizard wizard){

        System.out.print(wizard.name + " :" + wizard.hp + "   Mp: " + wizard.mp + "   Defense: " + wizard.defense + "   Attack: " + wizard.wande.size + "     ");
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

    private void affiche_boss(Wizard wizard){

        System.out.print(wizard.name + " :" + wizard.hp + "   Mp: " + wizard.mp + "   Defense: " + wizard.defense + "   Attack: " + wizard.wande.size + "     ");
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

    private void surviving_enemy_nb(){

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

    private void surviving_boss_nb() {

        for(int i = 0; i < surviving_boss.length; i++){

            surviving_boss[i] = new Empty_ennemy();
        }

        for (int i = 0; i < boss.length; i++) {

            if (boss[i].hp > 0) {

                for (int a = 0; a < boss.length; a++) {

                    if (surviving_boss[a].name.equals("null")) {
                        surviving_boss[a] = boss[i];
                        break;
                    }
                }
            }
        }
    }

    private void attack(Wizard wizard){

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

    private void attack_boss(Wizard wizard){

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

    private void magic_attack(Wizard wizard){

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

    private void magic_attack_boss(Wizard wizard){

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

    private void ennemy_attack(Wizard wizard){

        for (Ennemy ennemy : ennemies) {

            if (ennemy.hp > 0) {
                ennemy.attack(wizard);
            }
        }
    }

    private void boss_attack(Wizard wizard){

        for (int i = 0; i < boss.length; i++) {

            if (boss[i].hp > 0) {
                boss[i].attack(wizard);
            }
        }
    }

    private void operater( Wizard wizard){

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

    private void operater_boss(Wizard wizard){

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

    private void settlement(Wizard wizard){

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

    private void settlement_boss(Wizard wizard){

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

        System.out.println("You have successfully enrolled in your forth year!\n");
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
            System.out.println("Your abilities have been improved\n");
            settlement(wizard);
            System.out.println("\n");
        }
        else {
            System.out.println("You died, game over");
        }
    }

    public void boss_level(Wizard wizard){


        System.out.println("You met Voldemort and Peter Pettigrow\n");
        while( (boss[0].hp > 0 || boss[1].hp >0) && wizard.hp > 0){

            do {
                operater_boss(wizard);
            } while (this.invalid_operation);
            boss_attack(wizard);
            System.out.println("Boss has attacked you.");
            System.out.println("\n");
        }
        if(wizard.hp > 0){

            System.out.println("You'll be able to escape in no time, now you need to get the key.");
            do {
                System.out.println("You need to use spell Accio to get the key");
                invalid_operation = wizard.useSpell(boss[0]);
                System.out.println("\n");
            }while (!invalid_operation);
            System.out.println("You got the key and escaped successfully.");
            System.out.println("Your abilities have been improved\n");
            settlement_boss(wizard);
        }
        else {
            System.out.println("You died, game over");
        }
    }
}
