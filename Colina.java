
/**
 * Write a description of class Colina here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Colina
{
    
    
    public int ancho(int[] arr) {
        int ancho = 0;
        int anchoMayor = 0;
        
        for (int i = 0; i < arr.length; i++) { // Puntos Criticos
            ancho++;
            if (i != 0) {
                if (i == arr.length - 1) {                
                    if (ancho > anchoMayor) {
                        anchoMayor = ancho;
                    }
                
                    ancho = 0;
                } else {
                    if ((arr[i - 1] > arr[i]) && (arr[i] < arr[i + 1])) {
                        if (ancho > anchoMayor) {
                            anchoMayor = ancho;
                        }
                        
                        ancho = 0;
                    }
                }
            } 
        }
        
        return anchoMayor;   
    }
}
