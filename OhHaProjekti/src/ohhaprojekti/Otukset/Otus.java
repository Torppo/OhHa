/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohhaprojekti.Otukset;

import java.util.Random;
import ohhaprojekti.Toiminta.Hyokkays;
import ohhaprojekti.Toiminta.Paikka;

/**
 *
 * @author pii
 */
public abstract class Otus {
    private int taito = 0;
    private int voima = 0;
    private int kunto = 0;
    private int puolustus = 0;
    private Paikka paikka;
    
    public abstract boolean liiku(int x, int y);
    
    public Hyokkays hyokkaa() {
        Random noppa = new Random();
        int osuma = (noppa.nextInt(20) + 1) + this.taito;
        int vahinko = (noppa.nextInt(6) + 1) + this.voima;
        return new Hyokkays(osuma, vahinko);
    }
    
    public void puolusta(Hyokkays hyokkays) {
        if(hyokkays.osumaSumma > this.puolustus) {
            this.kunto = this.kunto - hyokkays.vahinkoSumma;
        }
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
