/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package punamustapuu;

/**
 *
 * @author Roope Merikukka & Joonas Salovaara
 */
public class Punamustapuu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] luvut ={3, 8, 14, 5, 22, 1};
        
        System.out.println("Alustetaan puu alkiolla: " + luvut[0]);
        Puu puu = new Puu(luvut[0]);
        
        for (int i = 1; i < luvut.length; i++) {
            puu.lisaaSolmu(luvut[i]);
        }
        

    }
    
}
