package org.hbrs.se1.ws23.uebung1.test;

import org.hbrs.se1.ws23.uebung1.control.GermanTranslator;
import org.junit.jupiter.api.Test;
import org.hbrs.se1.ws23.uebung1.control.GermanTranslator;


import static org.junit.jupiter.api.Assertions.*;

class GermanTranslatorTest {

    @Test
    void aPositiveTest() {
        GermanTranslator translator = new GermanTranslator();
        String value = translator.translateNumber(1);
        assertEquals(value, "Eins");
        value= translator.translateNumber(4);
        assertEquals(value,"Vier");
        value= translator.translateNumber(8);
        assertEquals(value, "Acht");
        value= translator.translateNumber(10);
        assertEquals(value, "Zehn");


    }
    @Test
    void aNegativeTest(){

        GermanTranslator translator = new GermanTranslator();
        double TranslatorVersion = translator.version;
        String value = translator.translateNumber(-5);
        int number = -5;
        String message = "Übersetzung der Zahl "+ number +" nicht möglich " + "Translator version: " + translator.version;
        assertEquals(value, message);
        value = translator.translateNumber(0);
        number= 0;
        message = "Übersetzung der Zahl "+ number +" nicht möglich " + "Translator version: " + translator.version;
        assertEquals(value, message);
        value= translator.translateNumber(-3);
        number= -3;
        message = "Übersetzung der Zahl " + number + " nicht möglich " + "Translator version: " + translator.version;
        assertEquals(value, message);
        value= translator.translateNumber(15);
        number= 15;
        message = "Übersetzung der Zahl " + number + " nicht möglich " + "Translator version: " + translator.version;
        assertEquals(value, message);
    }
    @Test
    void aGrenzWert (){
        GermanTranslator translator = new GermanTranslator();
        String value = translator.translateNumber(0);
        int number = 0;
        assertEquals(value, "Übersetzung der Zahl " + number + " nicht möglich " +
                "Translator version: " + translator.version);
        value = translator.translateNumber(11);
        number = 11;
        assertEquals(value, "Übersetzung der Zahl " + number + " nicht möglich " +
                "Translator version: " + translator.version);
    }
}