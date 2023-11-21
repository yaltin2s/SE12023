package org.hbrs.se1.ws23.uebung4;

import org.hbrs.se1.ws23.solutions.uebung3.persistence.PersistenceException;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Eingabe {

    private static Container c = Container.getInstance();
    private static Scanner sc = new Scanner(System.in);
    private static PSStream ps = new PSStream();

    private static void Usereingabe() throws ContainerException {
        System.out.println("Geben Sie ID der Userstory");
        Integer id = sc.nextInt();

        //Überprüfen ob die ID exsistiert?
        System.out.println("Geben Sie eine Beschreibung an");
        String b = sc.next();

        System.out.println("Geben Sie eine Akzeptanzkriterium an");
        String ak = sc.next();

        System.out.println("Geben Sie ein Projekt an");
        String ppp = sc.next();

        // Eingabe der Kennzahlen zur Berechnung
        System.out.println("Geben Sie folgende Zahlen an");

        System.out.println("Aufwand");
        Integer aufwand = sc.nextInt();

        while(checkaufwand(aufwand)){
            System.out.println("bitte ein Wert zwischen 1 und 13");
            aufwand = sc.nextInt();
        }

        System.out.println("Mehrwert");
        Integer mehrwert = sc.nextInt();

        System.out.println("Risk");
        Integer risk = sc.nextInt();

        System.out.println("Strafe");
        Integer strafe = sc.nextInt();

        c.addUserStory(new UserStory(id,b,ak,ppp,mehrwert,strafe,aufwand,risk));
        //sc.close();
    }
    public static void start() throws ContainerException, PersistenceException, Exception {
        String strInput = null;
        // Initialisierung des Eingabe-View
        Scanner scanner = new Scanner( System.in );
        System.out.println("UserStory-Tool New Version :-)");

        while ( true ) {
            // Ausgabe eines Texts zur Begruessung
            System.out.print( "> "  );

            strInput = scanner.nextLine();

            // Extrahiert ein Array aus der Eingabe
            String[] strings = strInput.split(" ");

            // 	Falls 'help' eingegeben wurde, werden alle Befehle ausgedruckt
            if ( strings[0].equals("help") ) {
                System.out.println("Folgende Befehle stehen zur Verfuegung: \n" +
                        "help, dump, enter, store, load, search, exit");
            }
            // Auswahl der bisher implementierten Befehle:
            if ( strings[0].equals("dump") ) {
                UserstoryView.dump(c.getCurrentList());
            }
            // Auswahl der bisher implementierten Befehle:
            if ( strings[0].equals("enter") ) {
                try {
                    Usereingabe();
                    // Daten einlesen ...
                } catch (ContainerException ex){
                    System.out.println(ex.getMessage() + "\n verwenden Sie eine andere ID");
                }

            }

            if (  strings[0].equals("store")  ) {
                //Sortiere die Liste
                ps.save(Utilties.sort(c.getCurrentList()));
            }
            if(strings[0].equals("load")){
                try{
                    List<UserStory> k = ps.laden();
                    ps.close();
                    c.setListe(k);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            if(strings[0].equals("search")){
                System.out.println("Welches Projekt suchen Sie nach:");
                System.out.println("Projekt eingeben: ");
                String n = sc.next();
                UserstoryView.dump(Utilties.projektSearch(c.getCurrentList(),n));
            }
            if(strings[0].equals("exit")){
                scanner.close();
                System.out.println("Programm wird beendet...... ciao!");
                System.exit(0);
            }
        } // Ende der Schleife
    }


    static boolean checkaufwand(int i){
        return i > 14 | i < 1;
    }
}