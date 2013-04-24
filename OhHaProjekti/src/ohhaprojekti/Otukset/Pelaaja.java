/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohhaprojekti.Otukset;

import java.util.ArrayDeque;
import java.util.Random;
import ohhaprojekti.Toiminta.Hyokkays;
import ohhaprojekti.Toiminta.Paikka;
import ohhaprojekti.Toiminta.Pelilauta;
import ohhaprojekti.Toiminta.Ruutu;

/**
 *
 * @author pii
 */
public class Pelaaja extends Otus {
    private String nimi;
    private int havaintoEtaisyys;
    
     public Pelaaja(String nimi, int taito, int voima, int kunto, int puolustus, Paikka paikka) {
        super(taito, voima, kunto, puolustus, paikka);
        this.nimi = nimi;
        super.merkki = "X";
        this.havaintoEtaisyys = 6;
    }
     /**
      * Liiku -metodi kutsuu laudan lisaaOtusRuutuunMetodia, jos pelaaja ei ole kuollut.
      * Se antaa tälle metodille paikan, jossa on määränpääruudun koordinaatit sekä liikutettavan olion.
      * @param x Antaa x -koordinaatin pelilaudan koordinaatistoon.
      * @param y Antaa y -koordinaatin pelilaudan koordinaatistoon.
      * @param lauta Antaa Pelilaudan.
      * @return true, jos liikkuminen onnistui, muuten false.
      */
    @Override
    public boolean liiku(int x, int y, Pelilauta lauta) {
        if(this.merkki.equals("K")) {
            return false;
        }
        return lauta.lisaaOtusRuutuun(new Paikka(super.paikka.x+x, super.paikka.y+y), this);
    }

    public String palautaNimi() {
        return this.nimi;
    }
    /**
     * Metodi saa paikan ja tarkistaa onko se pelaajan näköetäisyydellä phytagoraan lausetta apunaan käyttäen.
     * @param paikka on testattava paikka.
     * @return 
     */
    public boolean onkoHavaintoEtaisyydella(Paikka paikka) {
        double etaisyys = Math.sqrt(Math.pow(paikka.x, 2) + Math.pow(paikka.y, 2));
        if(etaisyys <= this.havaintoEtaisyys) {
            return true;
        }
        return false;
    }
    /**
     * Metodi muodostaa alueen, jonka pelaaja havaitsee. 
     * Se muodostaa ensiksi neliön, jonka sivut ovat kaksi kertaa havaintoEtaisyyden pituiset.
     * Metodi laskee tämän neliön sisälle jääneiden ruutujen etäisyyden pelaajasta
     * ja testaa onkoHavaintoEtaisyydella -metodin avulla ovatkoruudut havaintoetäisyydellä.
     * Tähän pitäisi saada vielä seinien tarkistus ja rajaus.
     * @param lauta kuvaa Pelilautaa, joka annetaan, jotta ruutujen tiedot voidaan hakea.
     */
    public void havaitse(Pelilauta lauta) {
        int vasenReuna = Math.max(-this.havaintoEtaisyys, -super.paikka.x);
        int oikeaReuna = Math.min(this.havaintoEtaisyys, lauta.palautaLeveys()-super.paikka.x-1);
        int ylaReuna = Math.max(-this.havaintoEtaisyys, -super.paikka.y);
        int alaReuna = Math.min(this.havaintoEtaisyys, lauta.palautaKorkeus()-super.paikka.y-1);
        for (int i = ylaReuna; i <= alaReuna; i++) {
            for (int j = vasenReuna; j <= oikeaReuna; j++) {
                if(onkoHavaintoEtaisyydella(new Paikka(j, i))) {
                    lauta.palautaRuutu(j+super.paikka.x, i+super.paikka.y).havaittu = true;
                }
            }
        }
    }
}
