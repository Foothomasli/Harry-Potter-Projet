package Character.Ennemy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ennemy1Test {

    @Test
    void defense() {

        var ennemy = new Ennemy1();
        assertEquals(20,ennemy.defense(40,20));
        assertEquals(0,ennemy.defense(10,20));
        assertEquals(0,ennemy.defense(10,10));
    }
}