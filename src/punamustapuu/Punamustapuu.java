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
        
        // puuhun lisättävien Solmujen avaimet
        int[] luvut ={3, 5, 2, 7, 6, 4};
        
        // luodaan uusi Puu
        Puu puu = new Puu();
        
        // lisätään puuhun Solmuja
        for (int i = 0; i < luvut.length; i++) {
            puu.lisaaSolmu(luvut[i]);
        }
        
        // tulostetaan puu Solmujen lisäyksen jälkeen
        puu.tulostaPuu();
        
        // poistetaan puusta Solmu, jonka avain on 3
        puu.poistaSolmu(puu.etsiSolmu(3));
        
        // tulostetaan puu poiston jälkeen
        puu.tulostaPuu();

    }
    
}
