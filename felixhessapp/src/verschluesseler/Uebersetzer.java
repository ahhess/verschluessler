/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package verschluesseler;

/**
 *
 * @author Felix
 */
public class Uebersetzer {
        
    private static final char[][] tabelle = {
            {'B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A'},
            {'C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B'},
            {'D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C'},
            {'E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D'},
            {'F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E'},
            {'G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F'},
            {'H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G'},
            {'I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H'},
            {'J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I'},
            {'K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J'},
            {'L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K'},
            {'M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L'},
            {'N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M'},
            {'O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N'},
            {'P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O'},
            {'Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P'},
            {'R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q'},
            {'S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R'},
            {'T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S'},
            {'U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T'},
            {'V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U'},
            {'W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V'},
            {'X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W'},
            {'Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X'},
            {'Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y'},
            {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'}
        };

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        if(args.length < 2) {
            System.out.println("usage: " + Uebersetzer.class.getName() + " <codewort> <eingabesatz>");
            System.exit(0);
        }
        
        //String[] myargs = {"NATHAN", "DIE KOENIGIN IST GUT"};
        
        Uebersetzer uebersetzer = new Uebersetzer();
        
        String s = uebersetzer.codiere(args[0], args[1]);
        
       // System.out.println(args[0]);
       // System.out.println(args[1]);
        System.out.println(s);
    }
    
    public String codiere(String codeword, String eingabe) {
        
        char[] codewortZeichen = codeword.toUpperCase().toCharArray();
        char[] eingabeZeichen = eingabe.toUpperCase().toCharArray();
        char[] ausgabeZeichen = new char[eingabeZeichen.length];
        int j=0;
        char uebersetztesZeichen;

        for (int i =0; i<eingabeZeichen.length; i++) {
            //Index des Buchstabens ermitteln
            int spalte = (int)eingabeZeichen[i] - 65;
            if (spalte < 0){
                // Kein Buchstabe, einfach übernehmen
                uebersetztesZeichen = eingabeZeichen[i];
            } else {
                //Index des codewort ermitteln
                // 'A' = 65
                int zeile = (int)codewortZeichen[j] - 66;
                if (zeile < 0){
                    zeile = 25;
                }
                
                //Eingabezeichen übersetzen
                uebersetztesZeichen = tabelle[zeile][spalte];

                //Index für keyword zurücksetzen, falls am Ende des Keywords angelangt
                if(j>=codewortZeichen.length - 1){
                    j=0;
                } else {
                    j++;
                }
            }
//            System.out.println(i + ": " + eingabeZeichen[i] + ", " + spalte + ", " + codewortZeichen[j] + ", " + uebersetztesZeichen);    
            ausgabeZeichen[i] = uebersetztesZeichen;
        }
        
        return new String(ausgabeZeichen);
    }
    
   public String decodiere(String codeword, String eingabe) {
        
        char[] codewortZeichen = codeword.toUpperCase().toCharArray();
        char[] eingabeZeichen = eingabe.toUpperCase().toCharArray();
        char[] ausgabeZeichen = new char[eingabeZeichen.length];
        int j=0;
        
        char uebersetztesZeichen=' ';
        for (int i =0; i<eingabeZeichen.length; i++) {

            /*
            Entschluessel-Logik:
            - prüfe, ob eingabezeichen ein Buchstabe ist. Wenn nicht, übernehmen
            - wert des codebuchataben ermitteln --> zeile (achtung wenn Länge überschritten: wieder von vorne)
            - in dieser zeile die spalte mit dem eingabezeichen suchen
            - aus dieser Spaltennummer den Buchstaben errechnen
            */
            
            
            
            int spalte = (int)eingabeZeichen[i] - 65;
            if (spalte < 0){
                //Leerzeichen wird übernommen
                uebersetztesZeichen = eingabeZeichen[i];
            } else {
                //Index des Codewortes wird übermittelt
                int zeile = (int)codewortZeichen[j] - 66;
                if (zeile < 0){
                    zeile = 25;                            
                }
                // Eingabe wird decodiert
                
                for  (int b = 0; b< 25; b++){
                    if (tabelle[zeile][b] ==  eingabeZeichen[i]){
                        uebersetztesZeichen =(char)(b + 65);
                        break;
                    }
                }

                //Index des Codewortes wird wiederhohlt falls es zu kurz ist
                if(j>=codewortZeichen.length - 1){
                    j=0;
                } else {
                    j++;
                }
            }
            ausgabeZeichen[i] = uebersetztesZeichen;
        }
        return new String(ausgabeZeichen);
    }
}
    
