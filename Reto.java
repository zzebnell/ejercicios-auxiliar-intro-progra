/**
 * Write a description of class Reto here.
 *
 * @author (OJO)
 * @version (a version number or a date)
 */
public class Reto
{
    private int[][] matriz = { {2, 3, 1, 2, 1, 4},
                               {5, 4, 7, 6, 4, 6},
                               {3, 5, 8, 3, 4, 7},
                               {2, 7, 7, 3, 6, 2},
                               {1, 3, 4, 5, 1, 2},
                               {5, 7, 4, 6, 6, 3},
                               {4, 2, 5, 1, 2, 4}};
                               
    /*public Reto(int[][] matriz) {
        this.matriz = matriz;
    }*/
   
    private boolean mismaColFil(int i, int j, int x, int y) {
        boolean esta = false;
       
        if (i == x || j == y) {
            esta = true;
        }
       
        return esta;
    }
   
    private int vertical(int infX, int supX, int columnaComun) {
        int suma = 0;
       
        for (int i = infX; i > supX; i--) {
            suma += matriz[i][columnaComun];
        }
       
        return suma;
    }
   
    public int caminoCorto(int x1, int y1, int x2, int y2) {
        int suma = 0;
       
        x1--;
        y1--;
        x2--;
        y2--;
       
        int supX = 0;
        int supY = 0;
        int infX = 0;
        int infY = 0;
       
        if (x1 > x2) { // El punto bajo es el 1            
            supX = x2;
            supY = y2;
            infX = x1;
            infY = y1;          
        } else if (x1 == x2) {
           
            if (y1 > y2) {
               
                for (int i = y2 + 1; i < y1; i++) {
                    suma += matriz[x1][i];
                }
               
            } else {
                for (int i = y1 + 1; i < y2; i++) {
                    suma += matriz[x1][i];
                }
            }
           
        } else {
            supX = x1;
            supY = y1;
            infX = x2;
            infY = y2;  
        }
       
        if (infY > supY) {
            // Diagonal izquierda superior
           
            int i = infX;
            int j = infY;
           
            while (mismaColFil(--i, --j, supX, supY) == false) {                
                suma += matriz[i][j];
            }
           
            if (i != supX && j == supY) {
                suma += vertical(i, j, j);
            }
           
        } else if (infY == supY) {
           
            suma += vertical(infX - 1, supX, infY);
           
        } else { // Diagonal derecha superior
           
            int i = infX;
            int j = infY;
           
            while (mismaColFil(--i, ++j, supX, supY) == false) {
                suma += matriz[i][j];
            }
           
            if (i != supX && j == supY) {
                suma += vertical(i, j, j);
            }
           
        }
       
        return suma;
    }
   
}