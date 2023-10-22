package org.hbrs.se1.ws23.uebung1.control;
public class
/*
  Anwendung
  Problem: Inkonsistente Objek-Erzeugung und Parameterizing
  Lösung: Service
 */

TranslatorFactory {
    public static Translator creatGermanTranslator(){
        return new GermanTranslator();
    }
}