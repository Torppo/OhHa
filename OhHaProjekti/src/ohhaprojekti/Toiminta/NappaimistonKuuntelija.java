/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohhaprojekti.Toiminta;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import ohhaprojekti.Otukset.Otus;
import ohhaprojekti.Otukset.Pelaaja;

/**
 *
 * @author pii
 */
public class NappaimistonKuuntelija implements KeyListener{
    private Pelaaja sankari;
    private Pelilauta lauta;
    private Component komponentti;
    
    public NappaimistonKuuntelija(Pelaaja pelaaja, Pelilauta lauta, Component komponentti) {
        this.sankari = pelaaja;
        this.lauta = lauta;
        this.komponentti = komponentti;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            sankari.liiku(0, -1, this.lauta);
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            sankari.liiku(0, 1, this.lauta);
        }
         else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            sankari.liiku(-1, 0, this.lauta);
        }
         else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            sankari.liiku(1, 0, this.lauta);
        }
        komponentti.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
