package nl.novi.opdrachten.whilelussen;

public class Snoepjes {

    public static void main (String[] snoepjes) {
        int aantalSnoepjes = 22;

        // Deze code is uitgecommentarieerd, omdat de code niet compileert zonder dat er aanpassingen plaatsvinden.

        /*while() { // Voeg hier de conditionele statement toe tussen de haakjes.
            System.out.println("Er zijn nog " + aantalSnoepjes + " snoepjes over. Tijd om er nog een op te eten.");

            // Zorg er hier voor dat het aantal snoepjes minder wordt.

        }*/

        while(aantalSnoepjes>0){
            System.out.println("Er zijn nog " + aantalSnoepjes + " snoepjes over. Tijd om er nog een op te eten.");
            aantalSnoepjes--;
        }

        System.out.println("De snoepjes zijn op.");
    }
}
