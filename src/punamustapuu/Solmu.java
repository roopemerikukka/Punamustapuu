/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package punamustapuu;

/**
 *
 * @author Roope
 */
public class Solmu {
    
    private static int avain;
    private static int vari;
    private static Solmu vanhempi;
    private static Solmu vasen;
    private static Solmu oikea;
    
    public Solmu(int avain){
        this.avain = avain;
    }
    
    /**
     * 1 == musta, 0 == punainen
     * @param vari 
     */
    private void asetaVari(int vari) {
        this.vari = vari;
    }
    
    private void asetaVasen(Solmu vasen) {
        this.vasen = vasen;
    }
    
    private void asetaOikea(Solmu oikea) {
        this.oikea = oikea;
    }
    
    private void asetaVanhempi(Solmu vanhempi) {
        this.vanhempi = vanhempi;
    }
    
    private int annaVari() {
        return this.vari;
    }
    
    private Solmu annaVasen() {
        return this.vasen;
    }
    
    private Solmu annaOikea() {
        return this.oikea;
    }
    
    private Solmu annaVanhempi() {
        return this.vanhempi;
    }
}
