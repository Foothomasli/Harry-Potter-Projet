package Character.Ennemy;
import Character.Wizard;


public class Empty_ennemy extends Ennemy{

    public Empty_ennemy() {
        super.name = "null";
    }

    @Override
    public void attack(Wizard wizard) {

    }

    @Override
    public double defense(double size, double defense) {
        return 0;
    }

    @Override
    public void skill(  Wizard wizard) {

    }
}

