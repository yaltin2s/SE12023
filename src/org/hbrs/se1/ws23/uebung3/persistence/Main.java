package org.hbrs.se1.ws23.uebung3.persistence;
import org.hbrs.se1.ws23.uebung2.*;
public class Main {

    public static void main(String[] args) {
        PersistenceStrategy persistenceStrategy = new PersistenceStrategyStream();
        Container container = Container.getInstance();
        container.setPersistenceStrategy(persistenceStrategy);
    }
}
