package org.hbrs.se1.ws23.uebung4;

import java.util.*;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Utilties {



    // Sortieren
    public static List<UserStory> sort(List<UserStory> liste){
        Collections.sort(liste);
        return liste;
    }


    //Suche nach vorhandenen Titels!
    public static List<UserStory> projektSearch(List<UserStory> l, String n) {

        return l.stream()
                .filter((UserStory zz )-> {return zz.getProject().equals(n);})
                .collect(Collectors.toList());
    }
}