/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohhaprojekti.Toiminta;

/**
 *Hyokkays on hyökkäävän otuksen luoma hyökkäys, jota vastaan toisen otuksen on puolustauduttava.
 * Hyökkäyksellä on osuma, jonka pitää ylittää puolustajan puolustus, 
 * jotta se voi aiheuttaa vahinkonsa puolustautuvaan otukseen.
 * @author pii
 */
public class Hyokkays {
    public int osumaSumma;
    public int vahinkoSumma;
    
    public Hyokkays(int osuma, int vahinko) {
        this.osumaSumma = osuma;
        this.vahinkoSumma = vahinko;
    }
}
