/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohhaprojekti.Toiminta;

import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import ohhaprojekti.Otukset.Otus;

/**
 *
 * @author pii
 */
public class Kayttoliittyma implements Runnable {
    private JFrame kehys;
    private Pelilauta lauta;
    private Otus otus;
    
    public Kayttoliittyma(Otus otus) {
        this.lauta = new Pelilauta(20, 20);
        this.otus = otus;
    }
    
    @Override
    public void run() {
        this.kehys = new JFrame("Pako!");
        this.kehys.setPreferredSize(new Dimension(800, 800));
        this.kehys.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(this.kehys.getContentPane());
        this.kehys.pack();
        this.kehys.setVisible(true);
    }
    private void luoKomponentit(Container container) {
        this.kehys.addKeyListener(new NappaimistonKuuntelija(this.otus, this.lauta));
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
//        this.lauta.tuubaa();
        this.lauta.lisaaOtusRuutuun(new Paikka(0, 0), otus);
        ArrayList<String> jonot = this.lauta.palautaMerkkijonot();
        for (int i = 0; i < jonot.size(); i++) {
            JLabel piirto = new JLabel(jonot.get(i));
            container.add(piirto); 
        }
    }
    public JFrame getFrame() {
        return this.kehys;
    }
}
