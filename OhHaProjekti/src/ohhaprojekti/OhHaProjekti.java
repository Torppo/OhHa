/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohhaprojekti;

import javax.swing.SwingUtilities;
import ohhaprojekti.Otukset.Pelaaja;
import ohhaprojekti.Toiminta.Kayttoliittyma;
import ohhaprojekti.Toiminta.Paikka;
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
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(new Pelaaja("Sankari", 1, 2, 10, 12, new Paikka(1,1)));
        SwingUtilities.invokeLater(kayttoliittyma);
        
        
        
    }
}
