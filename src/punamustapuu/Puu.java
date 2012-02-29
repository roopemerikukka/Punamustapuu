package punamustapuu;

/**
 * Luokka, joka mallintaa punamustaa puuta ja sen toimintaa.
 * @author Joonas Salovaara && Roope Merikukka && Eero Suvanto
 */
public class Puu {
    
    private Solmu juuri; // Puun juuri
    public final int MUSTA = 1; // Mustan värin numerokoodi
    public final int PUNAINEN = 0; // Punaisen värin numerokoodi
    private static final int SISENNYS_ASKEL = 6; // Tulostuksen sisennyksen määrä
    
    // Konstruktori
    public Puu(){
        this.juuri = new Solmu(); // Alustetaan puu NIL-Solmulla
    }
    
    /**
     * Lisätään Puuhun uusi Solmu annetusta avaimesta
     * @param avain kuuluu Z+ != 0 
     */
    public void lisaaSolmu(int avain) {
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
    }
    
    // Korjataan Puuhun tehty lisäys
    private void korjaaLisays(Solmu z) {
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
    
    // Suoritetaan vasen kierto Solmulle x
    private void vasenKierto(Solmu x) {
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
    }
    
    // Suoritetaan oikea kierto Solmulle x
    private void oikeaKierto(Solmu x) {
        Solmu y = x.annaVasen();
        x.asetaVasen(y.annaOikea());
        if (y.annaOikea().annaAvain() != 0) {
          y.annaOikea().asetaVanhempi(x);  
        }
        y.asetaVanhempi(x.annaVanhempi());
        if (x.annaVanhempi().annaAvain() == 0) {
            this.juuri = y;
        }
        else if (x.annaAvain() == x.annaVanhempi().annaOikea().annaAvain()) {
            x.annaVanhempi().asetaOikea(y);
        }
        else {
            x.annaVanhempi().asetaVasen(y);
        }
        y.asetaOikea(x);
        x.asetaVanhempi(y);
    }
    
    // Palauttaa Puun juurisolmun
    public Solmu annaJuuri(){
        return this.juuri;
    }
    
    // Poistetaan annettu Solmu z
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
    
    // Haetaan Solmun x seuraaja oikealta
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
    
    // Haetaan Puun Solmu, jolla on pienin avain
    private Solmu binaariseHakupuunMinimi(Solmu x) {
        if (x.annaAvain() != 0) {
            while (x.annaVasen().annaAvain() != 0) {
                x = x.annaVasen();
            }
            return x;
        } else {
            return new Solmu();
        }
    }
    
    // Korjataan mahdolliset virheet poiston jälkeen
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
                }
                else {
                    if (w.annaOikea().annaVari() == MUSTA) {
                        w.annaVasen().asetaVari(MUSTA); // Tapaus 3
                        w.asetaVari(PUNAINEN);
                        oikeaKierto(w);
                        w = x.annaVanhempi().annaOikea();
                    }
                    w.asetaVari(x.annaVanhempi().annaVari()); // Tapaus 4
                    x.annaVanhempi().asetaVari(MUSTA);
                    w.annaOikea().asetaVari(MUSTA);
                    vasenKierto(x.annaVanhempi());
                    x = this.juuri;
                }
            }
            else {
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
                }
                else {
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
            }
        }
        x.asetaVari(MUSTA);
    }
    
    // Etsitään Solmu, jonka avain on k
    public Solmu etsiSolmu(int k) {
        Solmu x = this.juuri;
        while (x.annaAvain() != 0 && k != x.annaAvain()) {
            if (k < x.annaAvain()) {
                x = x.annaVasen();
            }
            else {
                x = x.annaOikea();
            }
        }
        return x;
    }
    
    // Tulostaa puun aloittaen juuresta
    public void tulostaPuu(){
        apuTulostus(annaJuuri(), 0);
    }
    
     // Apumetodi, joka tulostaa puun sivuttaissuunnassa aloittaen puun oikeasta reunasta
    public void apuTulostus(Solmu s, int sisennys){
        if(s == null){
            // Jos puu on tyhjä, ei jatketa
            System.out.println("<tyhjä puu>");
            return;
        }
        if(s.annaOikea() != null){
            apuTulostus(s.annaOikea(), sisennys + SISENNYS_ASKEL);
        }
        for(int i = 0; i < sisennys; i++){
            System.out.print(" ");
        }
        if(s.annaVari() == MUSTA){
            if(s.annaAvain() == 0){
                System.out.println("(NIL)");
            } else {
                System.out.println("(" + s.annaAvain() + "M) <");
            }
        } else {
            System.out.println("(" + s.annaAvain() + "P) <");
        }
        if(s.annaVasen() != null){
            apuTulostus(s.annaVasen(), sisennys + SISENNYS_ASKEL);
        }
    }
    
}
