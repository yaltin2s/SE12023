package org.hbrs.se1.ws23.uebung2;

import org.hbrs.se1.ws23.uebung2.*;

import java.util.List;




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
