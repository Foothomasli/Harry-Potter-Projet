package AllSpell;
import lombok.Getter;
import lombok.Setter;
import Character.Wizard;
import Character.Ennemy.Ennemy;
@Getter
@Setter
public abstract class AbstractSpell {

    public String name;
    public abstract boolean usespell(Wizard wizard, Ennemy ennemy);
}
