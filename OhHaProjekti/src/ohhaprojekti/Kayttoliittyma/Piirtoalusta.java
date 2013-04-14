/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohhaprojekti.Kayttoliittyma;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import ohhaprojekti.Toiminta.Pelilauta;

/**
 *
 * @author pii
 */
public class Piirtoalusta extends JPanel{
    private Pelilauta lauta;
    private JLabel[][] merkit;
    
    public Piirtoalusta(Pelilauta lauta) {
        this.lauta = lauta;
        this.merkit = new JLabel[this.lauta.palautaKorkeus()][this.lauta.palautaLeveys()];
        GridLayout experimentLayout = new GridLayout(0,this.lauta.palautaLeveys());
        this.setLayout(experimentLayout);
        
        for (int i = 0; i < this.merkit.length; i++) {
            for (int j = 0; j < this.merkit[0].length; j++) {
                this.merkit[i][j] = new JLabel(this.lauta.palautaRuutuLista().get(i*this.lauta.palautaLeveys()+j).toString());
                this.add(this.merkit[i][j]);
            }
        }
    }
    /**
     * Metodi hakee Pelilaudalta tiedot ruutujen sisällöstä ja asettaa ne taulukkoon merkit JLabel -olioiden sisään.
     */
    public void paivita() {
         for (int i = 0; i < this.merkit.length; i++) {
            for (int j = 0; j < this.merkit[0].length; j++) {
                this.merkit[i][j].setText(this.lauta.palautaRuutuLista().get(i*this.lauta.palautaLeveys()+j).toString());
            }
        }
    }

   
    
   
    
}
