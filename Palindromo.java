/**
 * Write a description of class Palindromo here.
 *
 * @author (Leonel Zeballos Aldunate)
 * @version (22 / 05 / 23)
 */
public class Palindromo
{
    public String palindromoGrande(String s) {
        String palLargo = "";
        String cadenaAux;
       
        for (int i = 0; i < s.length(); i++) {
            cadenaAux = "";
            for (int a = i; a < s.length(); a++) {
                cadenaAux += s.charAt(a);
                if (cadenaAux.length() >= 2) {
                    if (esPalindromo(cadenaAux)) {
                        if (cadenaAux.length() > palLargo.length()) {
                            palLargo = cadenaAux;
                        }
                    }
                }
            }
        }
       
        return palLargo;
    }
   
    public boolean esPalindromo(String s) {
        boolean esPal = true;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - (1 + i))) {
                esPal = false;
            }
        }
       
        return esPal;
    }
}