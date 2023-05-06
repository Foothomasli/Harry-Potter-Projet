package AllSpell;
import lombok.Getter;
import lombok.Setter;
import Character.Wizard;
import Character.Ennemy.Ennemy;
@Getter
@Setter
public abstract class Spell {

    public String name = "Accio";
    public abstract boolean usespell(Wizard wizard, Ennemy ennemy);
}
