package nl.novi.opdrachten.methodes;

import java.util.ArrayList;
import java.util.List;

/**
 * Schrijf een methode  die een List<Integer> ontvangt.
 *
 * Wanneer er twee getallen of meer in zijn:
 * Return het volgende:
 * "Het hoogste getal van de gegeven getallen is: %GETAL%"
 *
 * Je mag hier geen Collections.sort of java.streams gebruiken.
 *
 */
public class HoogsteGetalAbstract {
    public static void main(String[] args){
        List<Integer> listInt = new ArrayList<>() ;
        listInt.add(-3);
        listInt.add(-5);
        printHighestInt(listInt);
    }

    private static void printHighestInt(List<Integer> listInt){
        if (listInt.size()>1){
            int highestInt= listInt.get(0);
            for (Integer x:listInt){
                if (x>highestInt) highestInt=x;
            }
            System.out.printf("Het hoogste getal van de gegeven getallen is: %d",highestInt);
        }
    }

}
