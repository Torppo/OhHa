/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohhaprojekti;

import javax.swing.SwingUtilities;
import ohhaprojekti.Otukset.Pelaaja;
import ohhaprojekti.Kayttoliittyma.Kayttoliittyma;
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
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(new Pelaaja("Sankari", 4, 6, 20, 16, new Paikka(10,10)));
        SwingUtilities.invokeLater(kayttoliittyma);
        
        
        
    }
}
