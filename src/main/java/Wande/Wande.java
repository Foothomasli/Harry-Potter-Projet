package Wande;
import Character.Wizard;
import Character.Ennemy.Ennemy;
public abstract class Wande {

    public String core;

    public int size;

    public abstract void attack(Wizard wizard, Ennemy ennemy);

    public abstract void magicattack(Wizard wizard, Ennemy ennemy);
}
