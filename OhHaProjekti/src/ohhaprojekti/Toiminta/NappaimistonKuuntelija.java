/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohhaprojekti.Toiminta;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import ohhaprojekti.Otukset.Otus;

/**
 *
 * @author pii
 */
public class NappaimistonKuuntelija implements KeyListener{
    private Otus otus;
    private Pelilauta lauta;
    
    public NappaimistonKuuntelija(Otus otus, Pelilauta lauta) {
        this.otus = otus;
        this.lauta = lauta;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            otus.liiku(0, 1, this.lauta);
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            otus.liiku(0, -1, this.lauta);
        }
         else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            otus.liiku(-1, 0, this.lauta);
        }
         else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            otus.liiku(1, 0, this.lauta);
        }
//        lauta.repaint() REPAINT TÄSSÄ!;
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
