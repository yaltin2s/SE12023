package org.hbrs.se1.ws23.uebung4;

import java.io.Serializable;
import java.util.NoSuchElementException;

public class UserStory implements Serializable, Comparable<UserStory> {

    private String titel ="";
    private int aufwand = 0;
    private int id = 0;
    private int mehrwert = 0;
    private int risk = 0;
    private int strafe = 0;
    private String Akz;
    private double prio = 0.0;
    private String project = "";

    public String getProject() {
        return project;
    }

    public void setProject(String p) {
        project = p;
    }




    public UserStory(int id, String titel,String ak ,String prk,int mehrwert, int strafe,
                     int aufwand, int risk) {
        // Überprüfen der Eingabe einer negativen Zahl
        if(mehrwert < 0 | strafe < 0 | aufwand < 0 | risk < 0 | id < 0){
            throw new NoSuchElementException();
        }
        this.id = id;
        this.titel = titel;
        this.mehrwert = mehrwert;
        this.strafe = strafe;
        this.aufwand = aufwand;
        this.risk = risk;
        Akz = ak;
        project = prk;
        this.prio = calcPrio(getMehrwert(),getStrafe(),getRisk(),getAufwand());

    }

    public UserStory() {
    }

    public String getAkz() {
        return Akz;
    }

    public void setAkz(String akz) {
        Akz = akz;
    }

    public double getPrio() {
        return prio;
    }

    public String getTitel() {
        return titel;
    }
    public void setTitel(String titel) {
        this.titel = titel;
    }
    public int getAufwand() {
        return aufwand;
    }
    public void setAufwand(int aufwand) {
        this.aufwand = aufwand;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getMehrwert() {
        return mehrwert;
    }
    public void setMehrwert(int mehrwert) {
        this.mehrwert = mehrwert;
    }
    public int getRisk() {
        return risk;
    }
    public void setRisk(int risk) {
        this.risk = risk;
    }
    public int getStrafe() {
        return strafe;
    }
    public void setStrafe(int strafe) {
        this.strafe = strafe;
    }

    private   double calcPrio(int mehrwert, int strafe, int risiko, int aufwand) {
        return  (double) (mehrwert + strafe) / (double) (aufwand + risiko);
    }


    @Override
    public int compareTo(UserStory o) {
        return (int) (1000*o.getPrio() - 1000*getPrio());
    }
}