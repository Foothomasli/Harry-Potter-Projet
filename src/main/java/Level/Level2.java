package Level;
import    AllSpell.Accio;
import AllSpell.WingardiumLeviosa;
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
    private Ennemy[] ennemies = new Ennemy[3];
    private Ennemy boss = new Basilic();
    private boolean invalid_operation;
    private Ennemy[] surviving_enemy = new Ennemy[3];

    public Level2(){

        for(int i = 0; i< ennemies.length; i++){
            ennemies[i] = new Ennemy2();
            ennemies[i].name = "Ennemy"+(i+1);
        }
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
        System.out.print(boss.name + ": " + boss.hp);

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

        wizard.attack(boss);
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

        wizard.magicattack(boss);
    }

    private void ennemy_attack(Wizard wizard){

        for (Ennemy ennemy : ennemies) {

            if (ennemy.hp > 0) {
                ennemy.attack(wizard);
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
        if(wizard.house.equals("Gryffindor")){

            wizard.wande = new Sword_of_Gryffindor();
            System.out.println("You got the Sword of Gryffindor");
        }
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

        System.out.println("You have successfully enrolled in your second year!\n");
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
            System.out.println("You learned new spell : Accio");
            Accio accio = new Accio();
            wizard.spell.put(accio.getName(), accio);
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

                do {
                    System.out.println("You need to use the spell Accio to get Basilic's tooth");
                    invalid_operation = wizard.useSpell(boss);
                    System.out.println("\n");
                }while (!invalid_operation);
                System.out.println("You have successfully pulled out a tusk.");
                System.out.println("You pulled out Basilic's tooth and destroyed Tom Jedusor's diary. \n");
            }
            settlement_boss(wizard);
            System.out.println("\n");}
        else {
            System.out.println("You died, game over");
        }
    }
}
