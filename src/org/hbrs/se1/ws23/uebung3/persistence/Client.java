package org.hbrs.se1.ws23.uebung3.persistence;

import org.hbrs.se1.ws23.uebung2.ContainerException;
import org.hbrs.se1.ws23.uebung2.Member;

import java.util.List;

import static org.hbrs.se1.ws23.uebung3.persistence.Container.*;


public class Client {

    public Container c= Container.getInstance();

    public void addMember(Member member) throws ContainerException {
        Container.addMember(member);
    }
    public String removeMember(Member m) {
        return Container.deleteMember(m.getID());
    }

    public List<Member> getListe() {
        return Container.getCurrentList();
    }

}
