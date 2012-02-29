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
            System.out.println();
            puu.tulostaPuu();
            System.out.println();
        }
        
        System.out.println("Aloitetaan 3 poisto...");
        puu.poistaSolmu(puu.etsiSolmu(3));
        System.out.println("3 poistettu! Tulostetaan puu...");
        System.out.println();
        puu.tulostaPuu();
        System.out.println();
        
//        System.out.println("Aloitetaan juuren poisto...");
//        puu.poistaSolmu(puu.annaJuuri());
//        System.out.println("Juuri poistettu! Tulostetaan puu...");
//        System.out.println();
//        puu.tulostaPuu();
//        System.out.println();
    }
    
}
