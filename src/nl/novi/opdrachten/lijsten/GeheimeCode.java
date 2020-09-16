package nl.novi.opdrachten.lijsten;

import java.util.ArrayList;
import java.util.List;

public class GeheimeCode {

    public static void main(String[] secret) {

        List<String> laResistanceMembers = new ArrayList<>();

        addMembers(laResistanceMembers, "Arie");
        addMembers(laResistanceMembers, "Sjaak");
        addMembers(laResistanceMembers, "Henrie");
        addMembers(laResistanceMembers, "Piet");
        addMembers(laResistanceMembers, "LeDroitCestMoi");
        addMembers(laResistanceMembers, "Piet");


        /*
        Opdracht 1: Hierboven zijn via de methode addMembers, leden aan de lijst toegevoegd. Pas de Methode zo aan dat
         er alleen unieke namen in voor mogen komen.
         */

        /*
        Opdracht 2: La Resistance wil niet dat de lijst met namen zo in handen komt te vallen van de bezetter. Versleutel
        Maak een methode die de lijst op de volgende manier versleuteld:
        a) Verander elke letter naar het nummer in het alfabet. Voeg na elke veranderde letter een - toe
        (behalve de laatste). Dus a wordt 1, b wordt 2 et cetera.
        Wanneer een letter een hoofdletter is, moet je beginnen met tellen bij 100. Dus A wordt 101, B wordt 102.
        Voorbeeld: Alex wordt versleuteld naar: 101-12-5-24
        b) Als de positie in de lijst een even getal is, dan moet de cijfercombinatie omgedraaid worden.
         */

        /*
        Opdracht 3:
        Schrijf een methode die de versleutelde lijst kan omzetten naar de ontsleutelde lijst.
         */

        //System.out.println(reverse("abcdef"));
        List<String> encodedList= encodeList(laResistanceMembers);
        print(laResistanceMembers,encodedList);
        printDecoded(encodedList);


        //System.out.println(laResistanceMembers.toString());

    }

    private static List<String> addMembers(List<String> members, String name) {
        if (!members.contains(name)) {
            members.add(name);
        }

        return members;
    }

    private static String encode(String s,boolean bReverseCode){   // #? best practice naming boolean?
        int baseLower=96;// ASCII 'a' = 97, to get ordinal number in alphabet substract from Ascii code
        int baseUpper=36;// ASCII 'A' = 65, to get ordinal number in alphabet substract from Ascii code but add 100 for uppercase chars (-64 + 100)
        List<String> arrCoded=new ArrayList<>();

        //Or use: for(char c: s.toCharArray())
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            String charCoded;
            if (Character.isLowerCase(c)){
                charCoded = String.valueOf(c - baseLower);
            }
            else {
                charCoded = String.valueOf(c + baseUpper);
            }

            arrCoded.add(charCoded);
        }

        String code= String.join("-",arrCoded);
        if (bReverseCode) code=reverse(code); //We assume the WHOLE code needs to be reversed not just the individual digit groups separated by "-"
        return code;
    }

    private static String decode(String s,boolean bReverseCode){   // #? best practice naming boolean?
        int baseLower=96;// ASCII 'a' = 97, to get ordinal number in alphabet substract from Ascii code
        int baseUpper=36;// ASCII 'A' = 65, to get ordinal number in alphabet substract from Ascii code but add 100 for uppercase chars (-64 + 100)

        if (bReverseCode) s=reverse(s); //We assume the WHOLE code needs to be reversed not just the individual digit groups separated by "-"

        StringBuilder decoded= new StringBuilder();
        for (String digitGroup: s.split("-")){
            int charCode = Integer.parseInt(digitGroup);
            if ( charCode > 100) {
                charCode-=baseUpper;//Get  the Ascii code of the character
            }
            else {
                charCode+=baseLower;
            }
            decoded.append ((char) charCode);
        }
        return decoded.toString();
    }

    private static String reverse(String s){
        StringBuilder sb= new StringBuilder();
        for (int i=s.length();i>0;i--){
            sb.append(s.charAt(i-1));
        }
        return sb.toString();
    }

    private static List<String> encodeList(List<String> list){
        List<String> encodedList = new ArrayList<>();
        for( String s:list  ){
            //System.out.println( list.indexOf(s) ) ;
            //reverse encoded string when position in list is even
            boolean bReverseString = (list.indexOf(s) % 2 ==0);
            //System.out.println(s + " coded:" + encode(s, bReverseString) );
            encodedList.add(encode(s, bReverseString));

        }
        return  encodedList;
    }

    private static List<String> decodeList(List<String> list){
        List<String> decodedList = new ArrayList<>();
        for( String s:list  ){
            //System.out.println( list.indexOf(s) ) ;
            //reverse encoded string when position in list is even
            boolean bReverseString = (list.indexOf(s) % 2 ==0);
            //System.out.println(s + " coded:" + encode(s, bReverseString) );
            decodedList.add(decode(s, bReverseString));
        }
        return  decodedList;
    }

    private static void print(List<String> list,List<String> encodedList) {
        System.out.println(list.size());
        for( String s:list  ){
            int idx = list.indexOf(s);
            String line = idx +": " + s;
            if (idx <= encodedList.size() ) line+=" encoded: "+encodedList.get(idx);
            System.out.println(line);
        }
    }

    private static void printDecoded(List<String> encodedList) {
        System.out.println(encodedList.size());
        List<String> decodedList = decodeList(encodedList);
        for( String s:encodedList  ){
            int idx = encodedList.indexOf(s);
            String line = idx +": " + s;
            if (idx <= encodedList.size() ) line+=" decoded: "+decodedList.get(idx);
            System.out.println(line);
        }
    }

}
