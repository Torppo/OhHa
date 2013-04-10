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
    
    public Monsteri(int taito, int voima, int kunto,int puolustus, Paikka paikka) {
        super(taito, voima, kunto, puolustus, paikka);
    }

    @Override
    public boolean liiku(int x, int y, Pelilauta lauta) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
