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
    private void korjaaLisays(Solmu z) {
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
    
    private void vasenKierto(Solmu x) {
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
    private void oikeaKierto(Solmu kierrettava) {
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
    
    public Solmu poistaSolmu(Solmu z) {
        Solmu y;
        Solmu x;
        if (z.annaVasen().annaAvain() == 0 || z.annaOikea().annaAvain() == 0) {
            y = z;
        } else {
            y = seuraajaBinaarisessaHakupuussa(z);
        }
        if (y.annaVasen().annaAvain() != 0) {
            x = y.annaVasen();
        } else {
            x = y.annaOikea();
        }
        x.asetaVanhempi(y.annaVanhempi());
        if (y.annaVanhempi().annaAvain() == 0) {
            this.juuri = x;
        } else {
            if (y.annaAvain() == y.annaVanhempi().annaVasen().annaAvain()) {
                y.annaVanhempi().asetaVasen(x);
            }
            else {
                y.annaVanhempi().asetaOikea(x);
            }
        }
        if (y.annaAvain() != z.annaAvain()) {
            z.asetaAvain(y.annaAvain());
        }
        if (y.annaVari() == MUSTA) {
            korjaaPoistoPunamustapuusta(x);
        }
        return y;
    }
    
    private Solmu seuraajaBinaarisessaHakupuussa(Solmu x) {
        Solmu y;
        if (x.annaOikea().annaAvain() != 0) {
            return binaariseHakupuunMinimi(x.annaOikea());
        }
        y = x.annaVanhempi();
        while (y.annaAvain() != 0 && x.annaAvain() == y.annaOikea().annaAvain()) {
            x = y;
            y = y.annaVanhempi();
        }
        return x;
    }
    
    private Solmu binaariseHakupuunMinimi(Solmu x) {
        if (x.annaAvain() != 0) {
            while (x.annaVasen().annaAvain() != 0) {
                x = x.annaVasen();
            }
            return x;
        } else {
            System.out.println("Puu tyhjä: minimiä ei ole määritelty. Funktion binaarisenHakupuunMinimi palautti NIL-solmun.");
            return new Solmu();
        }
    }
    
    private void korjaaPoistoPunamustapuusta(Solmu x) {
        Solmu w;
        while (x.annaAvain() != this.juuri.annaAvain() && x.annaVari() == MUSTA) {
            if (x.annaAvain() == x.annaVanhempi().annaVasen().annaAvain()) {
                w = x.annaVanhempi().annaOikea();
                if (w.annaVari() == PUNAINEN) {
                    w.asetaVari(MUSTA); // Tapaus 1
                    x.annaVanhempi().asetaVari(PUNAINEN);
                    vasenKierto(x.annaVanhempi());
                    w = x.annaVanhempi().annaOikea();
                }
                if (w.annaVasen().annaVari() == MUSTA && w.annaOikea().annaVari() == MUSTA) {
                    w.asetaVari(PUNAINEN); // Tapaus 2
                    x = x.annaVanhempi();
                } else {
                    if (w.annaOikea().annaVari() == MUSTA) {
                        w.annaVasen().asetaVari(MUSTA); // Tapaus 3
                        w.asetaVari(PUNAINEN);
                        oikeaKierto(w);
                        w = x.annaVanhempi().annaOikea();
                    }
                    w.asetaVari(x.annaVanhempi().annaVari());
                    x.annaVanhempi().asetaVari(MUSTA);
                    w.annaOikea().asetaVari(MUSTA);
                    vasenKierto(x.annaVanhempi());
                    x = this.juuri;
                }
            } else {
                w = x.annaVanhempi().annaVasen();
                if (w.annaVari() == PUNAINEN) {
                    w.asetaVari(MUSTA);
                    x.annaVanhempi().asetaVari(PUNAINEN);
                    oikeaKierto(x.annaVanhempi());
                    w = x.annaVanhempi().annaVasen();
                }
                if (w.annaOikea().annaVari() == MUSTA && w.annaVasen().annaVari() == MUSTA) {
                    w.asetaVari(PUNAINEN);
                    x = x.annaVanhempi();
                } else {
                    if (w.annaVasen().annaVari() == MUSTA) {
                        w.annaOikea().asetaVari(MUSTA);
                        w.asetaVari(PUNAINEN);
                        vasenKierto(w);
                        w = x.annaVanhempi().annaVasen();
                    }
                    w.asetaVari(x.annaVanhempi().annaVari());
                    x.annaVanhempi().asetaVari(MUSTA);
                    w.annaVasen().asetaVari(MUSTA);
                    oikeaKierto(x.annaVanhempi());
                    x = this.juuri;
                }
                x.asetaVari(MUSTA);
            }
        }
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