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
        
        int[] luvut ={1, 2, 3, 4};
        
        System.out.println("Alustetaan puu alkiolla: " + luvut[0]);
        Puu puu = new Puu();
        
        for (int i = 0; i < luvut.length; i++) {
            puu.lisaaSolmu(luvut[i]);
            puu.tulostaPuu(puu.annaJuuri());
        }
    }
    
}
