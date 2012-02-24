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
    private int vari;
    private Solmu vanhempi;
    private Solmu vasen;
    private Solmu oikea;
    
    /**
     * if avain == 0 --> nil
     * @param avain 
     */
    public Solmu(int avain){
        this.avain = avain;
        this.vasen = new Solmu(null);
        this.oikea = new Solmu(null);
        this.vari = 0;
    }
    
    public Solmu(String NIL) {
        if (NIL == null) {
            this.avain = 0;
            this.vari = 1;
        }
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
    
    public String annaVarinNimi(){
        if(this.annaVari()==1){
            return "musta";
        }else{
            return "punainen";
        }
    }
}
