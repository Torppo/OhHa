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
      * 
      * @param x
      * @param y
      * @param lauta
      * @return 
      */
    @Override
    public boolean liiku(int x, int y, Pelilauta lauta) {
        System.out.println(super.paikka.x + ", " + super.paikka.y);
        return lauta.lisaaOtusRuutuun(new Paikka(super.paikka.x+x, super.paikka.y+y), this);
    }
    @Override
    public Hyokkays hyokkaa() {
        Random noppa = new Random();
        int osuma = (noppa.nextInt(20) + 1) + super.taito;
        int vahinko = (noppa.nextInt(6) + 1) + super.voima;
        return new Hyokkays(osuma, vahinko);
    }
    @Override
     public int palautaPuolustus() {
        return this.puolustus;
    }
    @Override
    public void muutaKuntoa(int muutos) {
        this.kunto = this.kunto + muutos;
    }
    @Override
    public int palautaKunto() {
        return this.kunto;
    }
    @Override
    public void puolusta(Hyokkays hyokkays) {
        if(hyokkays.osumaSumma > super.puolustus) {
            super.kunto = super.kunto - hyokkays.vahinkoSumma;
        }
    }
    public String palautaNimi() {
        return this.nimi;
    }
    @Override
    public int palautaTaito() {
        return this.taito;
    }
    @Override
    public int palautaVoima() {
        return this.voima;
    }
    @Override
    public Paikka palautaPaikka() {
        return this.paikka;
    }
    @Override
    public void muutaPaikkaa(Paikka paikka) {
        this.paikka = paikka;
    }
}
