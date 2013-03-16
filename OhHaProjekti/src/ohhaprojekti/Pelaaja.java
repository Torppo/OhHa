/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohhaprojekti;

import java.util.Random;

/**
 *
 * @author pii
 */
public class Pelaaja implements Otus {
    private String nimi;
    private int taito = 0;
    private int voima = 0;
    private int kunto = 0;
    private int puolustus = 0;
    private Paikka paikka;
    
     public Pelaaja(String nimi, int taito, int voima, int kunto, int puolustus, Paikka paikka) {
        this.nimi = nimi;
        this.kunto = kunto;
        this.paikka = paikka;
        this.taito = taito;
        this.voima = voima;
        this.puolustus = puolustus;
    }
    @Override
    public void liiku() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public Hyokkays hyokkaa() {
        Random noppa = new Random();
        int osuma = (noppa.nextInt(20) + 1) + this.taito;
        int vahinko = (noppa.nextInt(6) + 1) + this.voima;
        return new Hyokkays(osuma, vahinko);
    }
     public int palautaPuolustus() {
        return this.puolustus;
    }
    public void muutaKuntoa(int muutos) {
        this.kunto = this.kunto + muutos;
    }
    public int palautaKunto() {
        return this.kunto;
    }
    @Override
    public void Puolusta(Hyokkays hyokkays) {
        if(hyokkays.osumaSumma > this.puolustus) {
            this.kunto = this.kunto - hyokkays.vahinkoSumma;
        }
    }
    public String palautaNimi() {
        return this.nimi;
    }
    public int palautaTaito() {
        return this.taito;
    }
    public int palautaVoima() {
        return this.voima;
    }
    public Paikka palautaPaikka() {
        return this.paikka;
    }
}
