package nl.novi.opdrachten.methodes;

/**
 * Schrijf een methode die twee Integers ontvangt.
 * De eerste parameter heet 'number', de tweede 'divisible'
 *
 * Het is de bedoeling dat je checkt of 'number' deelbaar is door 'divisible'
 *
 * Wanneer het deelbaar is, return het volgende:
 * Het getal: %HIER GETAL% is deelbaar door %HIER DIVISIBLE%.
 * Wanneer het niet deelbaar is:
 * Het getal: %HIER GETAL% is niet deelbaar door %HIER DIVISIBLE%. Verlaag of verhoog het getal
 * %HET GETAL WAARMEE HET VERHOOGT OF VERLAAGD MOET WORDEN%
 *
 * VOORBEELD:
 *
 * De methode ontvangt de getallen 13 en 3, dan zou het resultaat moeten zijn:
 * Het getal: 13 is niet deelbaar door 3. Verlaag het getal met 1.
 *
 * VOORBEELD 2:
 * De methode ontvangt de getallen 14 en 3, dan zou het resultaat moeten zijn:
 * Het getal: 14 is niet deelbaar door 3. Verhoog het getal met 1.
 *
 */

public class DeelbaarDoorX {

    public static void main(String[] args){
        int number=85682;
        int divisible=3;
        divisibleBy(number,divisible);
    }

    private static void divisibleBy(int number, int divisible){
        String out ="%d is %sdivisible by %d";
        String txtNotDivisible=" %s het getal met %d.";

        if (number % divisible == 0) {
            out = String.format(out,number,"",divisible);
        }
        else {
            out = String.format(out,number,"in",divisible);

            int remainder = number % divisible;
            if (remainder > (divisible/2)) {
                txtNotDivisible=String.format(txtNotDivisible,"Verhoog",divisible-remainder);
            }
            else {
                txtNotDivisible=String.format(txtNotDivisible,"Verlaag",remainder);
            }
            out+=txtNotDivisible;
        }
        System.out.println(out);
    }
}
