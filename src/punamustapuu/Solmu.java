/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package punamustapuu;

/**
 *
 * @author Roope Merikukka & Joonas Salovaara
 */
public class Solmu {
    
    private int avain;
    private Solmu vanhempi;
    private Solmu vasen;
    private Solmu oikea;
    private int vari;
    private final int MUSTA = 1;
    private final int PUNAINEN = 0;
    
    // Konstruktorit
    public Solmu(int avain) {
        this.avain = avain;
        this.vanhempi = null;
        this.vasen = null;
        this.oikea = null;
        this.vari = this.PUNAINEN;
    }
    
    // NOLLA ON NIL, NÄIN.
    public Solmu() {
        this.avain = 0;
        this.vanhempi = null;
        this.vasen = null;
        this.oikea = null;
        this.vari = this.MUSTA;
    }
    
    // Antajat
    public int annaAvain() {
        return this.avain;
    }
    
    public Solmu annaVanhempi() {
        return this.vanhempi;
    }
    
    public Solmu annaVasen() {
        return this.vasen;
    }
    
    public Solmu annaOikea() {
        return this.oikea;
    }
    
    public int annaVari() {
        return this.vari;
    }
    
    // Asettajat
    public void asetaAvain(int uusiAvain) {
        this.avain = uusiAvain;
    }
    
    public void asetaVanhempi(Solmu uusiVanhempi) {
        this.vanhempi = uusiVanhempi;
    }
    
    public void asetaVasen(Solmu uusiVasen) {
        this.vasen = uusiVasen;
    }
    
    public void asetaOikea(Solmu uusiOikea) {
        this.oikea = uusiOikea;
    }
    
    public void asetaVari(int uusiVari) {
        this.vari = uusiVari;
    }
}
