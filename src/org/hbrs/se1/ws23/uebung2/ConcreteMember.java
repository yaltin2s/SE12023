package org.hbrs.se1.ws23.uebung2;

public class ConcreteMember implements Member{
    private final Member M1;
    public ConcreteMember(Member ID) {

        M1=ID;
    }
    @Override
    public String toString() {
        return "ConcreteMember{" +
                "M1=" + M1 +
                '}';
    }


    @Override
    public Integer getID() {
        return null;
    }
}
