package punamustapuu;

/**
 * Luokka, joka mallintaa punamustan puun solmua.
 * @author Joonas Salovaara && Roope Merikukka
 */
public class Solmu {
    
    private int avain; // Solmun avaimen arvo
    private Solmu vanhempi; // Solmun isäsolmu
    private Solmu vasen; // Solmun vasen lapsisolmu
    private Solmu oikea; // Solmun oikea lapsisolmu
    private int vari; // Solmun väri
    private final int MUSTA = 1; // Mustan värin numerokoodi
    private final int PUNAINEN = 0; // Mustan värin numerokoodi
    
    /**
     * Syötteenään avaimen saava Solmun konstruktori.
     * @param avain kuuluu Z+ && != 0
     */
    public Solmu(int avain) {
        this.avain = avain;
        this.vanhempi = null;
        this.vasen = null;
        this.oikea = null;
        this.vari = PUNAINEN;
    }
    
    /**
     * NIL-solmun konstruktori.
     */
    public Solmu() {
        this.avain = 0;
        this.vanhempi = null;
        this.vasen = null;
        this.oikea = null;
        this.vari = this.MUSTA;
    }
    
    /**
     * Metodi, joka palauttaa solmun avaimen arvon.
     * @return Z+ && != 0
     */
    public int annaAvain() {
        return this.avain;
    }
    
    /**
     * Metodi, joka palauttaa solmun isäsolmun.
     * @return Solmu
     */
    public Solmu annaVanhempi() {
        return this.vanhempi;
    }
    
    /**
     * Metodi, joka palauttaa solmun vasemman lapsisolmun.
     * @return Solmu
     */
    public Solmu annaVasen() {
        return this.vasen;
    }
    
    /**
     * Metodi, joka palauttaa solmun oikean lapsisolmun.
     * @return Solmu
     */
    public Solmu annaOikea() {
        return this.oikea;
    }
    
    /**
     * Metodi, joka palautta solmun väriä vastaavan numerokoodin.
     * @return int = (PUNAINEN || MUSTA)
     */
    public int annaVari() {
        return this.vari;
    }
    
    /**
     * Metodi, jolla voidaan asettaa solmun avain.
     * @param uusiAvain Z+ != 0
     */
    public void asetaAvain(int uusiAvain) {
        this.avain = uusiAvain;
    }
    
    /**
     * Metodi, jolla voidaan asettaa solmun isäsolmu.
     * @param uusiVanhempi Solmu
     */
    public void asetaVanhempi(Solmu uusiVanhempi) {
        this.vanhempi = uusiVanhempi;
    }
    
    /**
     * Metodi, jolla voidaan asettaa solmun vasen lapsisolmu.
     * @param uusiVasen Solmu
     */
    public void asetaVasen(Solmu uusiVasen) {
        this.vasen = uusiVasen;
    }
    
    /**
     * Metodi, jolla voidaan asettaa solmun oikea lapsisolmu.
     * @param uusiOikea Solmu
     */
    public void asetaOikea(Solmu uusiOikea) {
        this.oikea = uusiOikea;
    }
    
    /**
     * Metodi, jolla voidaan asettaa solmun väri.
     * @param uusiVari int = (PUNAINEN || MUSTA)
     */
    public void asetaVari(int uusiVari) {
        this.vari = uusiVari;
    }
}