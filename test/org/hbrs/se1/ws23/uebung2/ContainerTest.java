package org.hbrs.se1.ws23.uebung2;
import org.hbrs.se1.ws23.uebung3.persistence.*;
import org.junit.jupiter.api.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {
    Container c;
    PersistenceStrategy<Member> ps;
    Member mem1,mem2,mem3;
    List<Member> memList;
    @BeforeEach
    void setUp() {
        c = Container.getInstance(); // Initialize the class-level field
        ps = null;
        mem1 = new ConcreteMember(1); // Initialize the class-level field
        mem2 = new ConcreteMember(2); // Initialize the class-level field
        mem3 = new ConcreteMember(3); // Initialize the class-level field
    }


    @Test
    void roundTripTest() throws PersistenceException,ContainerException {
        // Objekt hinzufügen
        Container.addMember(mem1);
        Container.addMember(mem2);
        Container.addMember(mem3);
        System.out.println("after adding: \n" + c);
        // Liste persistent abspeichern
        ps = new PersistenceStrategyStream<Member>();
        c.setPersistenceStrategy(ps);
        c.store();
        System.out.println("after store: \n" + c);
        //Objekt aus Container löschen
        Container.deleteMember(1);
        Container.deleteMember(2);
        Container.deleteMember(3);
        System.out.println("after delete: \n" + c);
        // Liste wieder einladen.
        c.load();
        memList = Container.getCurrentList();
        System.out.println("after load: \n" + c);

    }

    @Test
    void setPersistenceStrategy() throws ContainerException {
        //Test auf Null
        c.setPersistenceStrategy(null);
        assertNull(c.getPersistenceStrategy());

        //Test auf MongoDB
        ps = new PersistenceStrategyMongoDB();
        c.setPersistenceStrategy(ps);
        assertThrows(UnsupportedOperationException.class,() -> c.load());
    }

    @Test
    void store() throws PersistenceException {
        PersistenceStrategyStream<Member> ps = new PersistenceStrategyStream();
        c.setPersistenceStrategy(ps);
        ps.setLocation("D:\\SE1\\src\\org\\hbrs\\se1\\ws23\\uebung3\\persistence");
        assertThrows(PersistenceException.class, ()->c.store());
    }

    @Test
    void load() throws PersistenceException {
        PersistenceStrategyStream<Member> ps = new PersistenceStrategyStream();
        c.setPersistenceStrategy(ps);
        ps.setLocation("D:\\SE1\\src\\org\\hbrs\\se1\\ws23\\uebung3\\persistence");
        assertThrows(PersistenceException.class, ()->c.load());
    }
}