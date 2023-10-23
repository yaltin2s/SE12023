package org.hbrs.se1.ws23.uebung2;

public class ConcreteMember implements Member{
private Member M;
    private Integer  ID;

    public ConcreteMember(Integer Id) {
        ID= Id;

    }

    public ConcreteMember(int i) {
    }



    public String toString() {

        return "Member (ID [" + getID() +"])";
    }

    @Override
    public Integer getID() {
        return ID;
    }
}
