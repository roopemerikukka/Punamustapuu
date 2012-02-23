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
    
    private Solmu juuri;
    
    public Puu(int avain){
        this.juuri = new Solmu(avain);
    }
    
    // 1 = musta & 0 = punainen
    public void lisaaSolmu(int avain) {
        Solmu uusi = new Solmu(avain);
        Solmu y = new NILSolmu(0);
        Solmu x = this.juuri;
        while (x.annaAvain() != 0) {
            y = x;
            if (uusi.annaAvain() < x.annaAvain()) {
                x.asetaVasen(uusi);
            } else {
                x.asetaOikea(uusi);
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
        uusi.asetaVasen(new NILSolmu(0));
        uusi.asetaOikea(new NILSolmu(0));
        uusi.asetaVari(0);
        korjaaLisays(uusi);
    }
    
    // Vertailujen == syntaksia if ja while lauseissa täytyy miettiä, tuskin toimii,
    // sillä tarkistaa mielestäni tällähetkellä ainoastaan sitä, onko kyseessä täysin sama olio,
    // joka ei ikinä siis ole tosi? Pitäisikö toteuttaa myös se Comparable-rajapinta?
    // Vaihtuuko 2-tason else silmukassa vasen ja oikea päittäin vain annaVase/Oikea metodeissa vai myös kierroissa?
    public void korjaaLisays(Solmu korjattava) {
        Solmu y;
        while (korjattava.annaVanhempi().annaVari() == 0) {
            if (korjattava.annaVanhempi() == korjattava.annaVanhempi().annaVanhempi().annaVasen()) {
                y = korjattava.annaVanhempi().annaVanhempi().annaOikea();
                if (y.annaVari() == 0) {
                    korjattava.annaVanhempi().asetaVari(1);
                    y.asetaVari(1);
                    korjattava.annaVanhempi().annaVanhempi().asetaVari(0);
                    korjattava = korjattava.annaVanhempi().annaVanhempi();
                } else if (korjattava == korjattava.annaVanhempi().annaOikea()) {
                    korjattava = korjattava.annaVanhempi();
                    vasenKierto(korjattava);
                    korjattava.annaVanhempi().asetaVari(1);
                    korjattava.annaVanhempi().annaVanhempi().asetaVari(0);
                    oikeaKierto(korjattava.annaVanhempi().annaVanhempi());
                }
            } else {
                y = korjattava.annaVanhempi().annaVanhempi().annaVasen();
                if (y.annaVari() == 0) {
                    korjattava.annaVanhempi().asetaVari(1);
                    y.asetaVari(1);
                    korjattava.annaVanhempi().annaVanhempi().asetaVari(0);
                    korjattava = korjattava.annaVanhempi().annaVanhempi();
                } else if (korjattava == korjattava.annaVanhempi().annaVasen()) {
                    korjattava = korjattava.annaVanhempi();
                    oikeaKierto(korjattava);
                    korjattava.annaVanhempi().asetaVari(1);
                    korjattava.annaVanhempi().annaVanhempi().asetaVari(0);
                    vasenKierto(korjattava.annaVanhempi().annaVanhempi());
                }
            }
        }
        this.juuri.asetaVari(1);
    }
    
    public void vasenKierto(Solmu kierrettävä) {
        
    }
    
    public void oikeaKierto(Solmu kierrettävä) {
        
    }
    
}