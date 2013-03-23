/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohhaprojekti;

import ohhaprojekti.Toiminta.Pelilauta;

/**
 *
 * @author pisapisa
 */
public class OhHaProjekti {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Pelilauta lauta = new Pelilauta(10,10);
        lauta.tuubaa();
        lauta.tulosta();
        System.out.println(lauta.palautaRuutu(9, 5));
    }
}
