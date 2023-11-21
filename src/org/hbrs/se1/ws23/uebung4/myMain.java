package org.hbrs.se1.ws23.uebung4;



import java.util.*;
import java.util.stream.Collectors;

public class myMain {

    public static void main(String[] args) throws ContainerException {
        Container c = Container.getInstance();
        UserStory a =new UserStory(1,"1","1","TEST",5,1,4,1);
        UserStory b =new UserStory(2,"2","1","TEST",1,1,9,1);
        UserStory cc =new UserStory(3,"3","3","TEST",1,4,3,1);
        UserStory d =new UserStory(4,"4","4","TEST",1,31,1,1);
        UserStory e = new UserStory(5,"5","1","TEST",1,9,1,1);

        c.addUserStory(a);
        c.addUserStory(b);
        c.addUserStory(cc);
        c.addUserStory(d);
        c.addUserStory(e);

        System.out.println(d.getProject());




        List<UserStory> nn = c.getCurrentList().stream()
                .filter((UserStory zz )-> {return zz.getProject().equals("TEST");})
                .sorted()
                .collect(Collectors.toList());


        UserstoryView.dump(nn);
        //System.out.println(k);

    }
}