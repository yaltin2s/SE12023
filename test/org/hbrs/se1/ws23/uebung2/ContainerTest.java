package org.hbrs.se1.ws23.uebung2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {

    Container c;
    Member m1, m2, m3, m4, m5;


    @BeforeEach
    void neu() {
        c = new Container();
        m1 = new ConcreteMember(1);
        m2 = new ConcreteMember(2);
        m3 = new ConcreteMember(3);
        m4 = new ConcreteMember(4);
        m5 = new ConcreteMember(5);
    }

    @Test
    void addMember() throws ContainerException {
        c.addMember(m1);
        c.addMember(m2);
        c.addMember(m3);
        c.addMember(m4);

        assertThrows(ContainerException.class, () -> c.addMember(m4));
    }

    @Test
    void dump() throws ContainerException {
        c.addMember(m1);
        c.addMember(m2);
        c.addMember(m3);
        c.addMember(m4);
        c.dump();
    }

    @Test
    void size() throws ContainerException {
        c.addMember(m1);
        assertEquals(1, c.size());
        c.addMember(m2);
        assertEquals(2, c.size());
        c.addMember(m3);
        assertEquals(3, c.size());
        c.addMember(m4);
        assertEquals(4, c.size());
        c.addMember(m5);
        assertEquals(5, c.size());

    }

    @Test
    void deleteMember() throws ContainerException {
        c.addMember(m1);
        c.addMember(m2);
        c.addMember(m3);
        c.addMember(m4);

        assertEquals("Diese ID " + 4 + " wird entfernt...",
                c.deleteMember(4));

        assertEquals(2,c.size());
            assertEquals("Diese ID " + 5 + " ist nicht vorhanden",
                  c.deleteMember(5));
            assertEquals("Diese ID " + 4 + " ist nicht vorhanden",
                   c.deleteMember(4));

    }
}