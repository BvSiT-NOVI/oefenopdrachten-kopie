package nl.novi.opdrachten.methodes;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Schrijf een methode  die een List<Integer> ontvangt.
 *
 * Check in de methode of deze list 3 entries heeft.
 *
 * Wanneer dit niet zo is: return de foutmelding: "Er zijn te veel of te weinig getallen in de lijst."
 * BONUS: Kun je een foutmelding voor te veel en een foutmelding voor te weinig maken?
 *
 * Wanneer er wel drie getallen in zijn:
 * Return het volgende:
 * Een list met getallen gesorteerd van laag naar hoog.
 *
 * Je mag hier geen Collections.sort of java.streams gebruiken.
 *
 */
public class SorteerLijst {

    public static void main(String[] argeblabla) {

        List<Integer> wrongList = new ArrayList<>(Arrays.asList(1, 2, 4, 5, 6, 7, 8));
        List<Integer> correctList = new ArrayList<>(Arrays.asList(88, 888, 909909));

        sortNumbers(wrongList);
        sortNumbers(correctList);

    }

    private static void sortNumbers(List<Integer> listInt){
        String errMsg= "Er zijn %s getallen in de lijst.";
        String errType="te weinig";
        if (listInt.size()==3){
            //https://www.java67.com/2014/07/quicksort-algorithm-in-java-in-place-example.html#:~:text=The%20Quicksort%20is%20also%20one,the%20same%20algorithm%20on%20those.
            //https://stackoverflow.com/questions/31377448/how-to-do-sorting-in-array-list-without-using-collections-in-java
        }
        else {
            if (listInt.size()>3) errType="te veel";
            System.out.printf(errMsg,errType);
        }
    }


}
