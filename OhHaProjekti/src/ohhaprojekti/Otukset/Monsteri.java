/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohhaprojekti.Otukset;

import ohhaprojekti.Otukset.Otus;
import java.util.Random;
import ohhaprojekti.Toiminta.Hyokkays;
import ohhaprojekti.Toiminta.Paikka;

/**
 *
 * @author pii
 */
public class Monsteri extends Otus{
    private int taito = 0;
    private int voima = 0;
    private int kunto = 0;
    private int puolustus = 0;
    private Paikka paikka;
    
    public Monsteri(int taito, int voima, int kunto,int puolustus, Paikka paikka) {
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
}