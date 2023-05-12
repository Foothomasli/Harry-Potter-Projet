package Character.Ennemy.Boss;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrollTest {

    @Test
    void defense() {

        var troll = new Troll();
        assertEquals(20,troll.defense(40,20));
    }
}