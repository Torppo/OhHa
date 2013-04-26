/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohhaprojekti.Kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import java.util.Random;
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
        Random noppa = new Random();
        
        while(true) {
            int x = noppa.nextInt(this.lauta.palautaLeveys());
            int y = noppa.nextInt(this.lauta.palautaKorkeus());
            if(this.lauta.palautaRuutu(x, y).seina == false) {
                 this.lauta.lisaaOtusRuutuun(new Paikka(x,y), sankari);
                 break;
            }
        }
//        Monsteri monsu = new Monsteri(2, 1, 7, 9, new Paikka(3, 7));
//        this.lauta.lisaaOtusRuutuun(monsu.palautaPaikka(), monsu);
        sankari.havaitse(lauta);
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
