package Character;
import Character.Ennemy.*;
import Pet.*;
import Wande.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.Callable;

import Potion.*;
import AllSpell.*;

public class Wizard extends Character{

    public String name;
    public double hp = 1000;
    public double hpmax = 1000;
    public double mp = 100;
    public double mpmax = 100;
    public double defense = 10;
    public double Temporary_defense = 0;
    public Wande wande;
    public String house;
    public Pet pet;
    public Potion[] potions = new Potion[15];
    public Map<String, AbstractSpell> spell = new HashMap<>();

    public Wizard(){


        Scanner scanner = new Scanner(System.in);
        //创建名字
        System.out.println("Please name your character");
        this.name = scanner.nextLine();

        // 创建魔杖
        get_Wande();

        // 创建药水库
        for(int i = 0; i<5; i++){
            potions[i] = new LifePotion();
        }
        for(int i = 5; i<10; i++){
            potions[i] = new MagicPotion();
        }
        for(int i = 10; i<15; i++){
            potions[i] = new StrengtheningPotion();
        }
    }

    public void get_Wande(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("which wand would you like to choose: 1.DRAGON_HEARTSTRING 2.PHOENIX_FEATHER");
        int core = scanner.nextInt();

        switch (core) {
            case 2 -> this.wande = new PHOENIX_FEATHER();
            case 1 -> this.wande = new DRAGON_HEARTSTRING();
            default -> System.out.println("Fail to get a wande , you can't start the game");
        }

    }
    public double defense( double attack , double defense ){

        double damage;

        if(this.house.equals("Gryffindor")){

            damage = attack - defense * 1.2;
        }
        else {damage = attack - defense;}
        if (damage <= 0){damage = 0;}
        return damage;
    }
    public void attack(Ennemy ennemy){
        this.wande.attack(this, ennemy);
    }
    public void magicattack(Ennemy ennemy){
        this.wande.magicattack(this, ennemy);
    }
    public void useLifePotion(){

        for (int i = 0; i < potions.length; i++) {
            if (potions[i].name.equals("LifePotion")) {
                potions[i].usePotion(this);
                potions[i] = new EmptyPotion();
                break;
            }
        }
    }
    public void useMagicPotion(){

        for (int i = 0; i < potions.length; i++) {

            if (potions[i].name.equals("MagicPotion")) {
                potions[i].usePotion(this);
                potions[i] = new EmptyPotion();
                break;
            }
        }
    }
    public void useStrengtheningPotion(){

        for (int i = 0; i < potions.length; i++) {

            if (potions[i].name.equals("StrengtheningPotion")) {
                potions[i].usePotion(this);
                potions[i] = new EmptyPotion();
                break;
            }
        }
    }
    public void usePotion(){
        Scanner scanner = new Scanner(System.in);
        Quantity_Detector quantityDetector = new Quantity_Detector();
        System.out.println("Which potion do you want to use ? 1.LifePotion 2.MagicPotion 3.StrengtheningPotion");
        int Potion = scanner.nextInt();
        switch (Potion) {
            case 1 -> {
                if(quantityDetector.LifePotionVide(potions)){
                    System.out.println("This potion has run out,you wasted this opportunity");
                }
                else {useLifePotion();}}

            case 2 -> {
                if(quantityDetector.MagicPotionVide(potions)){
                    System.out.println("This potion has run out,you wasted this opportunity");
                }
                else {useMagicPotion();}}

            case 3 -> {
                if(quantityDetector.StrengtheningPotionVide(potions)){
                    System.out.println("This potion has run out,you wasted this opportunity");}
                else {useStrengtheningPotion();}}
            default -> System.out.println("You don't have this potion,you wasted this opportunity");
        }
    }
    public boolean useSpell(Ennemy ennemy){
/*
        System.out.println("You already learned these spell:\n");
        Iterator<Map.Entry<String, AbstractSpell>> iterator = spell.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, AbstractSpell> entry = iterator.next();
            String name = entry.getKey();
            System.out.print("[" + name + "]" + "    ");
        }
        System.out.println("\n");
        System.out.println("Which spell do you want to use ? Please spell it:");
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        AbstractSpell spellused = spell.get(a);
        return spellused.usespell(this,ennemy);*/

            System.out.println("You already learned these spell:\n");
            Iterator<Map.Entry<String, AbstractSpell>> iterator = spell.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, AbstractSpell> entry = iterator.next();
                String name = entry.getKey();
                System.out.print("[" + name + "]" + "    ");
            }
            System.out.println("\n");
            System.out.println("Which spell do you want to use ? Please spell it:");
            Scanner scanner = new Scanner(System.in);
            String a = scanner.nextLine();
            AbstractSpell spellused = spell.get(a);
            if (spellused == null) {
                System.out.println("You have not learned this spell yet. Please try again.");
                return false;
            } else {
                return spellused.usespell(this,ennemy);
            }
    }
    public void getPet(){
        System.out.println("Which pet do you want to choose；1.Cat  2. Mouse  3.Owl  4.Toad");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        switch (a) {
            case 1 -> this.pet = new Cat();
            case 2 -> this.pet = new Mouse();
            case 3 -> this.pet = new Owl();
            default -> this.pet = new Toad();
        }
    }
}

