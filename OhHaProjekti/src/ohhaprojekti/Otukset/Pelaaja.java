/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohhaprojekti.Otukset;

import java.util.Random;
import ohhaprojekti.Toiminta.Hyokkays;
import ohhaprojekti.Toiminta.Paikka;
import ohhaprojekti.Toiminta.Pelilauta;

/**
 *
 * @author pii
 */
public class Pelaaja extends Otus {
    private String nimi;
    
     public Pelaaja(String nimi, int taito, int voima, int kunto, int puolustus, Paikka paikka) {
        super(taito, voima, kunto, puolustus, paikka);
        this.nimi = nimi;
    }
     /**
      * Liiku -metodi kutsuu laudan lisaaOtusRuutuunMetodia. 
      * Se antaa tälle metodille paikan, jossa on määränpääruudun koordinaatit ja liikutettavan olion.
      * @param x Antaa x -koordinaatin pelilaudan koordinaatistoon.
      * @param y Antaa y -koordinaatin pelilaudan koordinaatistoon.
      * @param lauta Antaa Pelilaudan.
      * @return true, jos liikkuminen onnistui, muuten false.
      */
    @Override
    public boolean liiku(int x, int y, Pelilauta lauta) {
        System.out.println(super.paikka.x + ", " + super.paikka.y);
        return lauta.lisaaOtusRuutuun(new Paikka(super.paikka.x+x, super.paikka.y+y), this);
    }

    public String palautaNimi() {
        return this.nimi;
    }
}
