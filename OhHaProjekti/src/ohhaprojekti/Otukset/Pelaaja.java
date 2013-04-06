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
    private int taito = 0;
    private int voima = 0;
    private int kunto = 0;
    private int puolustus = 0;
    private Paikka paikka;
    
     public Pelaaja(String nimi, int taito, int voima, int kunto, int puolustus, Paikka paikka) {
        super(taito, voima, kunto, puolustus, paikka);
        this.nimi = nimi;
    }
    @Override
    public boolean liiku(int x, int y, Pelilauta lauta) {
        if(this.paikka.x + x < 0 || this.paikka.x + x >= lauta.palautaLeveys() || this.paikka.y + y < 0 || this.paikka.y >= lauta.palautaKorkeus()) {
            return false;
        }
        this.paikka.x += x;
        this.paikka.y += y;
        return true;
    }
    @Override
    public Hyokkays hyokkaa() {
        Random noppa = new Random();
        int osuma = (noppa.nextInt(20) + 1) + this.taito;
        int vahinko = (noppa.nextInt(6) + 1) + this.voima;
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
        if(hyokkays.osumaSumma > this.puolustus) {
            this.kunto = this.kunto - hyokkays.vahinkoSumma;
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
