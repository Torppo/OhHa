/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohhaprojekti.Toiminta;


import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author pii
 */
public class Piirtoalusta extends JPanel{
    private Pelilauta lauta;
    
    public Piirtoalusta(Pelilauta lauta_) {
        this.lauta = lauta_;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        ArrayList<String> jonot = this.lauta.palautaMerkkijonot();
        for (int i = 0; i < jonot.size(); i++) {
            JLabel piirto = new JLabel(jonot.get(i));
            super.add(piirto);
        }
    }
    
 /*   @Override
    public void repaint() {
        if(lauta != null) { 
            ArrayList<String> jonot = this.lauta.palautaMerkkijonot();
            for (int i = 0; i < jonot.size(); i++) {
                JLabel piirto = new JLabel(jonot.get(i));
                super.add(piirto);
            }
        }
    }*/
    
   
    
}
