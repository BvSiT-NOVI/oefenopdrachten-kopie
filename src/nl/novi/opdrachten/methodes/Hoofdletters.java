package nl.novi.opdrachten.methodes;

import java.util.ArrayList;
import java.util.List;

/**
 * Gegeven: een lijst met namen zonder hoofdletters van klanten.
 * Opdracht: Een luie stagiair heeft alle klanten in het systeem gezet, maar deze kon de Shift-knop niet vinden.
 * Het is aan jou om alle namen van een hoofdletter aan het begin te voorzien. Maak een methode die een List als
 * parameter ontvangt en de inhoud vervolgens van hoofdletters voorziet.
 *
 * Bonus 1: Zorg ervoor dat tussenvoegsels geen hoofdletter krijgen.
 * Bonus 2: Zorg ervoor dat de eerste letter na een '-' wel een hoofdletter krijgt.
 *
 *
 */

public class Hoofdletters {

    public static void main(String[] args) {
        List<String> curstomerNames = new ArrayList<>();

        curstomerNames.add("nick piraat");
        curstomerNames.add("michael jackson");
        curstomerNames.add("glennis grace");
        curstomerNames.add("dreetje hazes");
        curstomerNames.add("robbie williams");
        curstomerNames.add("michiel de ruyter");
        curstomerNames.add("sjaak polak");
        curstomerNames.add("jan van jansen");
        curstomerNames.add("henk den hartog");
        curstomerNames.add("mo el-mecky");
        curstomerNames.add("fredje kadetje");

        printList(capitalizeNames(curstomerNames));
    }

    private static List<String> capitalizeNames(List<String> list){
        for(String s:list){
            list.set(list.indexOf(s),capitalizeName2(s));
        }
        return list;
    }

    private static String capitalizeName(String s){
        String[] words=s.split(" ");
        for (int i=0;i<words.length;i++){
            words[i]= words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
        }
        return String.join(" ",words);
    }

    private static String capitalizeName2(String s){
        String[] words=s.split(" ");
        //Capitalize first word
        words[0]= words[0].substring(0, 1).toUpperCase() + words[0].substring(1);
        words[0]=capitalizeAfterHyphen(words[0]);
        int len = words.length;
        //Capitalize last word
        if (len>1) {
            words[len-1]= words[len-1].substring(0, 1).toUpperCase() + words[len-1].substring(1);
            words[len-1]=capitalizeAfterHyphen(words[len-1]);
        }

        return String.join(" ",words);
    }

    private static String capitalizeAfterHyphen(String s){
        String[] words=s.split("-");
        for (int i=0;i<words.length;i++){
            if (i>0) words[i]= words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
        }
        return String.join("-",words);
    }

    private static void printList(List<String> list) {
        for( String s:list  ){
            System.out.println(s);
        }
    }

}
