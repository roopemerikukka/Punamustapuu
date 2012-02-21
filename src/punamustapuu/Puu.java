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
    
    public void korjaaLisays(Solmu korjattava) {
        
    }
    
}