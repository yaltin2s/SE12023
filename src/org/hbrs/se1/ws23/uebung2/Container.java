package org.hbrs.se1.ws23.uebung2;

import java.util.*;


public class Container {

    ArrayList<Member> MemberList= new ArrayList<>();



    public  void addMember(Member member) throws ContainerException {

        for (Member i : MemberList) {
            if (MemberList.contains(member)) {
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
        for (Member n: MemberList) {
            if(n.getID().equals(id)){
                deleted = "Diese ID " + id +" wird entfernt...";
                MemberList.remove(n);
                return deleted;
            }
        }

        return "Diese ID " + id + " ist nicht vorhanden";
    }
}
