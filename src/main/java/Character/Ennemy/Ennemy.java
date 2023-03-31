package Character.Ennemy;
import Character.Wizard;
public abstract class Ennemy {

    public String name;
    public double hp ;
    public double defense;
    public double attack;
    public String state;
    public String core;

    public abstract double defense( double size , double defense );
    public abstract void attack(Wizard wizard);
    public abstract void skill(Wizard wizard);
}
