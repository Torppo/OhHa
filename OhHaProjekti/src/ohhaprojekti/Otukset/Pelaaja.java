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
    private String merkki;
    private int havaintoEtaisyys;
    
     public Pelaaja(String nimi, int taito, int voima, int kunto, int puolustus, Paikka paikka) {
        super(taito, voima, kunto, puolustus, paikka);
        this.nimi = nimi;
        this.merkki = "X";
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
    @Override
    public String palautaMerkki() {
        return this.merkki;
    }
    /**
     * Muuttaa Pelaaja -luokan merkkin arvon.
     * @param uusiMerkki on uusi arvo.
     */
    @Override
    public void muutaMerkkia(String uusiMerkki) {
        this.merkki = uusiMerkki;
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
    @Override
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
        
        
        
//        boolean[] kayty = new boolean[lauta.palautaRuutuLista().size()];
//        for (int i = 0; i < lauta.palautaRuutuLista().size(); i++) {
//            kayty[i] = false;
//        }
//        ArrayDeque<HavaintoPaikka> jono = new ArrayDeque<HavaintoPaikka>();
//        jono.add(new HavaintoPaikka(super.paikka.x, super.paikka.y, 0));
//        lauta.palautaRuutu(super.paikka.x, super.paikka.y).havaittu = true;
//        while(!jono.isEmpty()) {
//            HavaintoPaikka hPaikka = jono.poll();
//            kayty[hPaikka.y*lauta.palautaLeveys()+hPaikka.x] = true;
//            if(hPaikka.y-1 > -1 && kayty[(hPaikka.y-1)*lauta.palautaLeveys()+hPaikka.x] == false && lauta.palautaRuutu(hPaikka.x, hPaikka.y-1).seina == false && hPaikka.kierros < this.havaintoEtaisyys) {
//                lauta.palautaRuutu(hPaikka.x, hPaikka.y-1).havaittu = true;
//                jono.add(new HavaintoPaikka(hPaikka.x, hPaikka.y-1, hPaikka.kierros+1));
//            }
//            if(hPaikka.y+1 < lauta.palautaKorkeus() && kayty[(hPaikka.y+1)*lauta.palautaLeveys()+hPaikka.x] == false && lauta.palautaRuutu(hPaikka.x, hPaikka.y+1).seina == false && hPaikka.kierros < this.havaintoEtaisyys) {
//                lauta.palautaRuutu(hPaikka.x, hPaikka.y+1).havaittu = true;
//                jono.add(new HavaintoPaikka(hPaikka.x, hPaikka.y+1, hPaikka.kierros+1));
//            }
//            if(hPaikka.x-1 > -1 && kayty[hPaikka.y*lauta.palautaLeveys()+(hPaikka.x-1)] == false && lauta.palautaRuutu(hPaikka.x-1, hPaikka.y).seina == false && hPaikka.kierros < this.havaintoEtaisyys) {
//                lauta.palautaRuutu(hPaikka.x-1, hPaikka.y).havaittu = true;
//                jono.add(new HavaintoPaikka(hPaikka.x-1, hPaikka.y, hPaikka.kierros+1));
//            }
//            if(hPaikka.x+1 < lauta.palautaLeveys() && kayty[hPaikka.y*lauta.palautaLeveys()+(hPaikka.x+1)] == false && lauta.palautaRuutu(hPaikka.x+1, hPaikka.y).seina == false && hPaikka.kierros < this.havaintoEtaisyys) {
//                lauta.palautaRuutu(hPaikka.x+1, hPaikka.y).havaittu = true;
//                jono.add(new HavaintoPaikka(hPaikka.x+1, hPaikka.y, hPaikka.kierros+1));
//            }
//        }
    }
}
