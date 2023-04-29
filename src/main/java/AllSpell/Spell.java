package AllSpell;
import lombok.Getter;
import lombok.Setter;
import Character.Wizard;
import Character.Ennemy.Ennemy;
@Getter
@Setter
public abstract class Spell {

    public String name;
    public abstract void usespell(Wizard wizard, Ennemy ennemy);
}
