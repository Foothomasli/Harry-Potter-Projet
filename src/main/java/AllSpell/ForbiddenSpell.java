package AllSpell;
import Character.Ennemy.Ennemy;
import Character.Wizard;
public class ForbiddenSpell extends AbstractSpell{
    public boolean usespell(Wizard wizard, Ennemy ennemy) {

        wizard.hp = wizard.hp - 100;
        return true;
    }
}
