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
    
    private int avain;
    private int vari;
    private Solmu vanhempi;
    private Solmu vasen;
    private Solmu oikea;
    
    public Solmu(int avain){
        this.avain = avain;
    }
    
    /**
     * 1 == musta, 0 == punainen
     * @param vari 
     */
    public void asetaVari(int vari) {
        this.vari = vari;
    }
    
    public void asetaVasen(Solmu vasen) {
        this.vasen = vasen;
    }
    
    public void asetaOikea(Solmu oikea) {
        this.oikea = oikea;
    }
    
    public void asetaVanhempi(Solmu vanhempi) {
        this.vanhempi = vanhempi;
    }
    
    public int annaAvain() {
        return this.avain;
    }
    
    public int annaVari() {
        return this.vari;
    }
    
    public Solmu annaVasen() {
        return this.vasen;
    }
    
    public Solmu annaOikea() {
        return this.oikea;
    }
    
    public Solmu annaVanhempi() {
        return this.vanhempi;
    }
}
