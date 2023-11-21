package org.hbrs.se1.ws23.uebung2;

import java.util.*;

public class MemberView {
    Client client =new Client();

    public void dump(List<Member> list){
        List<Member> List = client.getListe();
        for (Member mem: List) {
            System.out.println(mem);
        }
    }
}
