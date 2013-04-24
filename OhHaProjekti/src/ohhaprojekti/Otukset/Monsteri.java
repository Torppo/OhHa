/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohhaprojekti.Otukset;

import ohhaprojekti.Otukset.Otus;
import java.util.Random;
import ohhaprojekti.Toiminta.Hyokkays;
import ohhaprojekti.Toiminta.Paikka;
import ohhaprojekti.Toiminta.Pelilauta;

/**
 *
 * @author pii
 */
public class Monsteri extends Otus{
    private int laskuri;
    
    public Monsteri(int taito, int voima, int kunto,int puolustus, Paikka paikka) {
        super(taito, voima, kunto, puolustus, paikka);
        super.merkki = "M";
        this.laskuri = 0;
    }
    @Override
    public boolean liiku(int x, int y, Pelilauta lauta) {
        if(this.merkki.equals("K")) {
            return false;
        }
        if(this.laskuri > -1 && this.laskuri < 3) {
            this.laskuri++;
            return lauta.lisaaOtusRuutuun(new Paikka(super.paikka.x+1, super.paikka.y), this);
        }
        if(this.laskuri > 2 && this.laskuri < 5) {
            this.laskuri++;
            return lauta.lisaaOtusRuutuun(new Paikka(super.paikka.x, super.paikka.y+1), this);
        }
        if(this.laskuri > 4 && this.laskuri < 8) {
            this.laskuri++;
            return lauta.lisaaOtusRuutuun(new Paikka(super.paikka.x-1, super.paikka.y), this);
        }
        else {
            if(this.laskuri > 8) {
                this.laskuri = 0;
            }
            else {
                this.laskuri++;
            }
            return lauta.lisaaOtusRuutuun(new Paikka(super.paikka.x, super.paikka.y-1), this);
        }
    }
   public int palautaLaskuri() {
       return this.laskuri;
   }
}
