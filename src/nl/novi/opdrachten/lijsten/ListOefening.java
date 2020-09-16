package nl.novi.opdrachten.lijsten;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListOefening {

    public static void main(String[] uitlegList) {

        //We hebben een list die de namen van voetbalclubs bevat
        List<String> clubNames = new ArrayList<>();
        //Die vullen we alvast voor de opdracht
        clubNames.add("Ajax");
        clubNames.add("PSV");
        clubNames.add("Feyenoord");
        clubNames.add("Fc Utrecht");
        clubNames.add("Fc Groningen");
        clubNames.add("FC Twente");

        addUnique(clubNames,"PSV");
        addUnique(clubNames,"Vitesse");

        // Vraag -1: Maak een methode die al taak heeft om de list per regel uit te printen.

        printList(clubNames);

        // Vraag 0: Maak een methode die als taak heeft om de list uit te printen: positie + inhoud.
        // Bovenstaande list zou dan dit zijn:
        // 0 - Ajax
        // 1 - PSv
        // etc...

        printList(clubNames,true);


        // Vraag 1: Maak een methode die checkt of een club al in de lijst zit en voeg deze anders toe.

        addUnique(clubNames,"PSV");
        addUnique(clubNames,"Vitesse");
        printList(clubNames);

        // Vraag 2: Maak een methode die de positie van de club in de lijst teruggeeft.

        String search="Ajax";
        System.out.println(search + " at pos " + getOrdinal(clubNames,search));

        // Vraag 3: Maak een methode die de lijst alfabetisch sorteert. Wanneer Ajax niet op positie 1 staat, moeten de
        // clubs die voor Ajax staan verwijderd worden.
        // We voegen nog wat clubs toe om de code te kunnen testen.
        clubNames.add("AA Aachen");
        clubNames.add("AFC Amsterdam");
        clubNames.add("AFC");

        System.out.println("clubNames:");
        printList(clubNames);

        System.out.println("clubNames after sortAsFirst:");
        printList(sortAsFirst(clubNames,"Ajax"));

        // Vraag 4: Kun je hetzelfde doen als hierboven, maar PSV moet dan laatste zijn.
        clubNames.add("Zlotty FC");
        clubNames.add("SC Eindhoven");

        System.out.println("Vraag 4: Kun je hetzelfde doen als hierboven, maar PSV moet dan laatste zijn.:");
        printList(sortAsFirst(clubNames,"Ajax","PSV"));


    }

    private static void printList(List<String> list) {
        for( String s:list  ){
            System.out.println(s);
        }
    }

    private static void printList(List<String> list,boolean bVerbose ) {
        if (bVerbose) System.out.println(list.size());
        for( String s:list  ){
            int idx = list.indexOf(s);
            String line = s;
            if (bVerbose){
                line = idx +" - " + s;
            }
            System.out.println(line);
        }
    }

    private static List<String> addUnique(List<String> list,String s){
        if (!list.contains(s)) list.add(s);
        return list;
    }

    private static int getOrdinal(List<String> list,String s){
        return list.indexOf(s);
    }

    private static List<String> sortAsFirst(List<String> list,String nameFirstClub){
        Collections.sort(list);
        //BvS: when using directly a for loop on list after sort exception??
        //#? Best way to prevent https://engineering.saltside.se/collections-sort-java-8-concurrentmodificationexception-73205e3a596
        List<String> outList = new ArrayList<>();
        boolean bAdd = false;
        for (String s:list) {
            if (!bAdd && s.equals(nameFirstClub)) bAdd=true;
            if (bAdd) outList.add(s);
        }
        return outList;
    }

    private static List<String> sortAsFirst(List<String> list,String nameFirstClub,String nameLastClub) {
        Collections.sort(list);
        //BvS: when using directly a for loop on list after sort exception??
        //#? Best way to prevent https://engineering.saltside.se/collections-sort-java-8-concurrentmodificationexception-73205e3a596
        List<String> outList = new ArrayList<>();
        boolean bAdd = false;
        for (String s:list) {
            if (!bAdd && s.equals(nameFirstClub)) bAdd=true;
            if (bAdd) outList.add(s);
            if (s.equals(nameLastClub)) break;
        }
        return outList;
    }
}
