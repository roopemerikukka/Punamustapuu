/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package punamustapuu;
import java.util.List;

/**
 *
 * @author Roope
 */
public class Puu {
    
    private Solmu juuri;
    
    public Puu(int avain){
        this.juuri = new Solmu(avain);
        this.juuri.asetaVari(1);
    }
    
    // 1 = musta & 0 = punainen
    public void lisaaSolmu(int avain) {
        System.out.println("Lisätään solmu: " + avain);
        Solmu uusi = new Solmu(avain);
        Solmu y = new Solmu(null);
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
        uusi.asetaVasen(new Solmu(null));
        uusi.asetaOikea(new Solmu(null));
        uusi.asetaVari(0);
        korjaaLisays(uusi);
        System.out.println("Solmu lisätty.");
    }
    
    // Vertailujen == syntaksia if ja while lauseissa täytyy miettiä, tuskin toimii,
    // sillä tarkistaa mielestäni tällähetkellä ainoastaan sitä, onko kyseessä täysin sama olio,
    // joka ei ikinä siis ole tosi? Pitäisikö toteuttaa myös se Comparable-rajapinta?
    // Vaihtuuko 2-tason else silmukassa vasen ja oikea päittäin vain annaVase/Oikea metodeissa vai myös kierroissa?
    public void korjaaLisays(Solmu korjattava) {
        System.out.println("Korjataan solmun " + korjattava.annaAvain() + " perusteella...");
        Solmu y;
        while (korjattava.annaVanhempi().annaVari() == 0) {
            if (korjattava.annaVanhempi().annaAvain() == korjattava.annaVanhempi().annaVanhempi().annaVasen().annaAvain()) {
                y = korjattava.annaVanhempi().annaVanhempi().annaOikea();
                if (y.annaVari() == 0) {
                    korjattava.annaVanhempi().asetaVari(1);
                    y.asetaVari(1);
                    korjattava.annaVanhempi().annaVanhempi().asetaVari(0);
                    korjattava = korjattava.annaVanhempi().annaVanhempi();
                } else if (korjattava.annaAvain() == korjattava.annaVanhempi().annaOikea().annaAvain()) {
                    korjattava = korjattava.annaVanhempi();
                    vasenKierto(korjattava);
                }
                korjattava.annaVanhempi().asetaVari(1);
                korjattava.annaVanhempi().annaVanhempi().asetaVari(0);
                oikeaKierto(korjattava.annaVanhempi().annaVanhempi());
            } else {
                y = korjattava.annaVanhempi().annaVanhempi().annaVasen();
                if (y.annaVari() == 0) {
                    korjattava.annaVanhempi().asetaVari(1);
                    y.asetaVari(1);
                    korjattava.annaVanhempi().annaVanhempi().asetaVari(0);
                    korjattava = korjattava.annaVanhempi().annaVanhempi();
                } else if (korjattava.annaAvain() == korjattava.annaVanhempi().annaVasen().annaAvain()) {
                    korjattava = korjattava.annaVanhempi();
                    oikeaKierto(korjattava);
                }
                korjattava.annaVanhempi().asetaVari(1);
                korjattava.annaVanhempi().annaVanhempi().asetaVari(0);
                vasenKierto(korjattava.annaVanhempi().annaVanhempi());
            }
            System.out.println("Lisäyksen korjaus lopetettu.");
        }
        this.juuri.asetaVari(1);
        System.out.println("Korjaus päättynyt.");
    }
    
    public void vasenKierto(Solmu kierrettava) {
        System.out.println("Aloitetaan vasen kierto solmulle " + kierrettava.annaAvain() + "...");
        Solmu y = kierrettava.annaOikea();
        kierrettava.asetaOikea(y.annaVasen());
        if (y.annaVasen() != null) {
          y.annaVasen().asetaVanhempi(kierrettava);  
        }
        y.asetaVanhempi(kierrettava.annaVanhempi());
        if (kierrettava.annaVanhempi() == null) {
            this.juuri = y;
        }
        else if (kierrettava.annaAvain() == kierrettava.annaVanhempi().annaVasen().annaAvain()) {
            kierrettava.annaVanhempi().asetaVasen(y);
        }
        else {
            kierrettava.annaVanhempi().asetaOikea(y);
        }
        y.asetaVasen(kierrettava);
        kierrettava.asetaVanhempi(y);
        System.out.println("Vasen kierto lopetettu.");
    }
    
    // Peilattu ylläolevastavaihtamalla kaikki oikea-sanat vasen-sanoiksi ja toisinpäin
    public void oikeaKierto(Solmu kierrettava) {
        System.out.println("Aloitetaan oikea kierto solmulle " + kierrettava.annaAvain() + "...");
        Solmu y = kierrettava.annaVasen();
        kierrettava.asetaVasen(y.annaOikea());
        if (y.annaOikea() != null) {
          y.annaOikea().asetaVanhempi(kierrettava);  
        }
        y.asetaVanhempi(kierrettava.annaVanhempi());
        if (kierrettava.annaVanhempi() == null) {
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
            System.out.print(" musta\n");
        }else{
            System.out.print(" punainen\n");
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