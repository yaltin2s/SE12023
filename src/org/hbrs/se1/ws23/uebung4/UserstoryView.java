package org.hbrs.se1.ws23.uebung4;

import java.util.List;

public class UserstoryView {


    //Ausgabe Methode
    public static void dump ( List<UserStory> l) {
        System.out.println(
                "-----------------------------------------------------------------------------");
        System.out.printf("%5s %20s %20s %20s", "ID", "Titel", "Projekt", "Prio");
        System.out.println();
        System.out.println(
                "-----------------------------------------------------------------------------");
        for (UserStory e : l) {
            System.out.format("%5s %20s %20s %20s", e.getId(), e.getTitel(), e.getProject(), e.getPrio());
            System.out.println();
        }
        System.out.println(
                "-----------------------------------------------------------------------------");
    }
}