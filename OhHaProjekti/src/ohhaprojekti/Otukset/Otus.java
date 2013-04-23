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
public abstract class Otus {
    protected int taito = 0;
    protected int voima = 0;
    protected int kunto = 0;
    protected int puolustus = 0;
    protected String merkki;
    protected Paikka paikka;
    
    public Otus(int taito, int voima, int kunto, int puolustus, Paikka paikka) {
        this.kunto = kunto;
        this.paikka = paikka;
        this.taito = taito;
        this.voima = voima;
        this.puolustus = puolustus;
    }
    
    public abstract boolean liiku(int x, int y, Pelilauta lauta);
    /**
     * Metodi luo Dungeons & Dragons 3.5 painoksen sääntöjen mukaan hyokkayksen. 
     * @return palauttaa metodin luoman hyokkayksen. 
     */
    public Hyokkays hyokkaa() {
        Random noppa = new Random();
        int osuma = (noppa.nextInt(20) + 1) + this.taito;
        int vahinko = (noppa.nextInt(6) + 1) + this.voima;
        return new Hyokkays(osuma, vahinko);
    }
    /**
     * Metodi saa Hyokkayksen, jonka parametrejä käyttäen se tarkistaa Dungeons & Dragons 3.5 painoksen sääntöjen mukaisesti,
     * onnistuuko hyökkäys. Jos hyökkäys onnistui metodi laskee sen tuottaman vahingon.
     * @param hyokkays on Hyokkays jota vastaan puolustaudutaan. 
     */
    public void puolusta(Hyokkays hyokkays) {
        if(hyokkays.osumaSumma > this.puolustus) {
            this.kunto = this.kunto - hyokkays.vahinkoSumma;
        }
    }
    public String palautaMerkki() {
        return this.merkki;
    }
     /**
     *  Muuttaa Otus -luokan merkkin arvon.
     * @param uusiMerkki on uusi arvo.
     */
    public void muutaMerkkia(String uusiMerkki) {
        this.merkki = uusiMerkki;
    }
    
    public int palautaPuolustus() {
        return this.puolustus;
    }
    /**
     * Muuttaa otuksen kunnon arvon.
     * @param muutos on uusi arvo.
     */
    public void muutaKuntoa(int muutos) {
        this.kunto = this.kunto + muutos;
    }
    public int palautaKunto() {
        return this.kunto;
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
    /**
     * Muuttaa otuksen paikan.
     * @param paikka on uusi paikka.
     */
    public void muutaPaikkaa(Paikka paikka) {
        this.paikka = paikka;
    }
}
