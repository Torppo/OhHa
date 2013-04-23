/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohhaprojekti.Kayttoliittyma;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import ohhaprojekti.Otukset.Otus;
import ohhaprojekti.Otukset.Pelaaja;
import ohhaprojekti.Toiminta.Pelilauta;
import ohhaprojekti.Toiminta.Ruutu;

/**
 *
 * @author pii
 */
public class NappaimistonKuuntelija implements KeyListener{
    private Pelaaja sankari;
    private Pelilauta lauta;
    private Piirtoalusta alusta;
    
    public NappaimistonKuuntelija(Pelaaja pelaaja, Pelilauta lauta, Piirtoalusta alusta) {
        this.sankari = pelaaja;
        this.lauta = lauta;
        this.alusta = alusta;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            if(sankari.liiku(0, -1, this.lauta)) {
                sankari.havaitse(lauta);
            }
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            if(sankari.liiku(0, 1, this.lauta)) {
                sankari.havaitse(lauta);
            }
        }
         else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            if(sankari.liiku(-1, 0, this.lauta)) {
                sankari.havaitse(lauta);
            }
        }
         else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if(sankari.liiku(1, 0, this.lauta)) {
                sankari.havaitse(lauta);
            }
        }
        ArrayList<Otus> monsteriLista = this.lauta.palautaListaLaudanMonstereista();
        for (int i = 0; i < monsteriLista.size(); i++) {
            monsteriLista.get(i).liiku(0, 0, this.lauta);
        }
        this.alusta.paivita();
        this.alusta.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
