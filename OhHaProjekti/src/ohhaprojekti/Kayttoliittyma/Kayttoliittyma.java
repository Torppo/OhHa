/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohhaprojekti.Kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import ohhaprojekti.Otukset.Monsteri;
import ohhaprojekti.Otukset.Otus;
import ohhaprojekti.Otukset.Pelaaja;
import ohhaprojekti.Toiminta.Paikka;
import ohhaprojekti.Toiminta.Pelilauta;

/**
 *
 * @author pii
 */
public class Kayttoliittyma implements Runnable {
    private JFrame kehys;
    private Pelilauta lauta;
    private Pelaaja sankari;
    
    public Kayttoliittyma(Pelaaja pelaaja) {
        this.lauta = new Pelilauta(20, 20);
        this.sankari = pelaaja;
        this.lauta.lisaaOtusRuutuun(sankari.palautaPaikka(), sankari);
        sankari.havaitse(lauta);
        this.lauta.lisaaOtusRuutuun(new Paikka(2,2), new Monsteri(2, 1, 20, 9, new Paikka(2,2)));
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
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        Piirtoalusta piirtoalusta = new Piirtoalusta(this.lauta);
        container.add(piirtoalusta);
        this.kehys.addKeyListener(new NappaimistonKuuntelija(this.sankari, this.lauta, piirtoalusta));
    }

    public JFrame getFrame() {
        return this.kehys;
    }
}
