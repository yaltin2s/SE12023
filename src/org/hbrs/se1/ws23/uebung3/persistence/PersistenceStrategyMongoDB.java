package org.hbrs.se1.ws23.uebung3.persistence;

import java.util.ArrayList;
import java.util.List;

public  class PersistenceStrategyMongoDB<E> implements PersistenceStrategy<E> {

    @Override
    public void openConnection() throws PersistenceException {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public void closeConnection() throws PersistenceException {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public void save(List<E> member) throws PersistenceException {

    }

    @Override
    public List<E> load() {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public void save(ArrayList<E> memberList) {
        throw new UnsupportedOperationException("Not implemented!");
    }
}
