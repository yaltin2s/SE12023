package org.hbrs.se1.ws23.uebung3.persistence;

import org.hbrs.se1.ws23.uebung2.ContainerException;
import org.hbrs.se1.ws23.uebung2.Member;

import java.util.ArrayList;


public class Container {

    private static Container container;
    ArrayList<Member> MemberList= new ArrayList<>();


    private Container(){}

    public static Container getInstance(){
        if (container==null)
            container= new Container();

        return container;
    }

    public  void addMember(Member member) throws ContainerException {

        for (Member i : MemberList) {
            if (i.getID().equals(member.getID())) {
                throw new ContainerException("Das Member-Objekt mit der ID"
                        + member.getID() + " ist bereits vorhanden!");
            }
        }
        MemberList.add(member);

    }

    public void dump(){
        for (Member m : MemberList) {
            System.out.println(m);
        }
    }
    public int size(){

        return MemberList.size();
    }



    public String deleteMember(Integer id){
        String deleted;
        //System.out.println(MemberList);
        for (Member n: MemberList) {
            if(n.getID().equals(id)){
                deleted = "Diese ID " + id +" wird entfernt...";
                MemberList.remove(n);
                return deleted;
            }
        }

        return "Diese ID " + id + " ist nicht vorhanden";
    }


    public  void store() throws PersistenceException{}

    public  void load() throws PersistenceException{}
}
