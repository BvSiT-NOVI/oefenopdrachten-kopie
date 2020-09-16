package nl.novi.opdrachten.methodes;

/**
 * Schrijf een methode die een Integer ontvangt.
 * Wanner het getal deelbaar is door 11, laat hem de volgende tekst returnen:
 * 'deelbaar door vijf'
 * Wanneer het getal niet deelbaar is door vijf:
 * 'ondeelbaar door vijf'
 */
public class DeelbaarDoorVijf {

    public static void main(String[] sammieKijkOmhoog) {
        int chosenNumber = 44;
        divisibleByFive(chosenNumber);

        chosenNumber = 35;
        divisibleByFive(chosenNumber);

    }

    private static void divisibleByFive(int x){
        String out ="%d is %sdivisible by 5";
        if (x % 5 == 0) {
            out = String.format(out,x,"");
        }
        else {
            out = String.format(out,x,"in");
        }
        System.out.println(out);
    }

}
