/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package punamustapuu;

/**
 *
 * @author Roope
 */
public class Puu {
    
    private Solmu juuri = new Solmu();
    private final int MUSTA = 1;
    private final int PUNAINEN = 0;
    
    // Tyhjän puun konstruktori
    public Puu(){
        
    }
    
    // INT ONLY, EIKÄ NOLLAA!
    public void lisaaSolmu(int avain) {
        System.out.println("Lisätään solmu: " + avain);
        Solmu uusi = new Solmu(avain);
        Solmu y = new Solmu();
        Solmu x = this.juuri;
        while (x.annaAvain() != 0) {
            y = x;
            if (uusi.annaAvain() < x.annaAvain()) {
                x = x.annaVasen();
            } else {
                x = x.annaOikea();
            }
        }
        uusi.asetaVanhempi(y);
        if (y.annaAvain() == 0) {
            this.juuri = uusi;
        } else {
            if (uusi.annaAvain() < y.annaAvain()) {
                y.asetaVasen(uusi);
            } else {
                y.asetaOikea(uusi);
            }
        }
        uusi.asetaVasen(new Solmu());
        uusi.asetaOikea(new Solmu());
        uusi.asetaVari(PUNAINEN);
        korjaaLisays(uusi);
        System.out.println("Solmu lisätty.");
    }
    
    // Vertailujen == syntaksia if ja while lauseissa täytyy miettiä, tuskin toimii,
    // sillä tarkistaa mielestäni tällähetkellä ainoastaan sitä, onko kyseessä täysin sama olio,
    // joka ei ikinä siis ole tosi? Pitäisikö toteuttaa myös se Comparable-rajapinta?
    // Vaihtuuko 2-tason else silmukassa vasen ja oikea päittäin vain annaVase/Oikea metodeissa vai myös kierroissa?
    public void korjaaLisays(Solmu z) {
        System.out.println("Aloitetaan korjaus solmulle: " + z.annaAvain());
        Solmu y;
        while (z.annaVanhempi().annaVari() == PUNAINEN) {
            if (z.annaVanhempi().annaAvain() == z.annaVanhempi().annaVanhempi().annaVasen().annaAvain()) {
                y = z.annaVanhempi().annaVanhempi().annaOikea();
                if (y.annaVari() == PUNAINEN) {
                    z.annaVanhempi().asetaVari(MUSTA);
                    y.asetaVari(MUSTA);
                    z.annaVanhempi().annaVanhempi().asetaVari(PUNAINEN);
                    z = z.annaVanhempi().annaVanhempi();
                }
                else {
                    if (z.annaAvain() == z.annaVanhempi().annaOikea().annaAvain()) {
                        z = z.annaVanhempi();
                        vasenKierto(z);
                    }
                    z.annaVanhempi().asetaVari(MUSTA);
                    z.annaVanhempi().annaVanhempi().asetaVari(PUNAINEN);
                    oikeaKierto(z.annaVanhempi().annaVanhempi());
                } 
                    
            } else {
                y = z.annaVanhempi().annaVanhempi().annaVasen();
                if (y.annaVari() == PUNAINEN) {
                    z.annaVanhempi().asetaVari(MUSTA);
                    y.asetaVari(MUSTA);
                    z.annaVanhempi().annaVanhempi().asetaVari(PUNAINEN);
                    z = z.annaVanhempi().annaVanhempi();
                }
                else {
                    if (z.annaAvain() == z.annaVanhempi().annaVasen().annaAvain()) {
                        z = z.annaVanhempi();
                        oikeaKierto(z);
                    }
                    z.annaVanhempi().asetaVari(MUSTA);
                    z.annaVanhempi().annaVanhempi().asetaVari(PUNAINEN);
                    vasenKierto(z.annaVanhempi().annaVanhempi());
                }
            }
        }
        this.juuri.asetaVari(MUSTA);
    }
    
    public void vasenKierto(Solmu x) {
        System.out.println("Aloitetaan vasen kierto solmulle " + x.annaAvain() + "...");
        Solmu y = x.annaOikea();
        x.asetaOikea(y.annaVasen());
        if (y.annaVasen().annaAvain() != 0) {
          y.annaVasen().asetaVanhempi(x);  
        }
        y.asetaVanhempi(x.annaVanhempi());
        if (x.annaVanhempi().annaAvain() == 0) {
            this.juuri = y;
        }
        else if (x.annaAvain() == x.annaVanhempi().annaVasen().annaAvain()) {
            x.annaVanhempi().asetaVasen(y);
        }
        else {
            x.annaVanhempi().asetaOikea(y);
        }
        y.asetaVasen(x);
        x.asetaVanhempi(y);
        System.out.println("Vasen kierto lopetettu.");
    }
    
    // Peilattu ylläolevastavaihtamalla kaikki oikea-sanat vasen-sanoiksi ja toisinpäin
    public void oikeaKierto(Solmu kierrettava) {
        System.out.println("Aloitetaan oikea kierto solmulle " + kierrettava.annaAvain() + "...");
        Solmu y = kierrettava.annaVasen();
        kierrettava.asetaVasen(y.annaOikea());
        if (y.annaOikea().annaAvain() != 0) {
          y.annaOikea().asetaVanhempi(kierrettava);  
        }
        y.asetaVanhempi(kierrettava.annaVanhempi());
        if (kierrettava.annaVanhempi().annaAvain() == 0) {
            this.juuri = y;
        }
        else if (kierrettava.annaAvain() == kierrettava.annaVanhempi().annaOikea().annaAvain()) {
            kierrettava.annaVanhempi().asetaOikea(y);
        }
        else {
            kierrettava.annaVanhempi().asetaVasen(y);
        }
        y.asetaOikea(kierrettava);
        kierrettava.asetaVanhempi(y);
        System.out.println("Oikea kierto lopetettu.");
    }
    
    public Solmu annaJuuri(){
        return this.juuri;
    }
    
    public void tulostaPuu(Solmu s) {
        System.out.print(s.annaAvain());
        if(s.annaVari() == 1){
            System.out.print(" MUSTA\n");
        }else{
            System.out.print(" PUNAINEN\n");
        }
        if(s.annaOikea()!=null){
            tulostaPuu(s.annaOikea());
        }
        if(s.annaVasen()!=null){
            tulostaPuu(s.annaVasen());
        }
        System.out.println("-");
    }
    
}