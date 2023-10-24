package org.hbrs.se1.ws23.uebung2;

public class ConcreteMember implements Member{
    private final Integer  ID;

    public ConcreteMember(Integer Id) {
        ID= Id;

    }



    public String toString() {

        return "Member (ID [" + getID() +"])";
    }

    @Override
    public Integer getID() {
        return ID;
    }
}
