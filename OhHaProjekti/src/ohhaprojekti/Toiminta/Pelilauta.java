/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohhaprojekti.Toiminta;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author pii
 */
public class Pelilauta {
    private ArrayList<Ruutu> ruudut = new ArrayList<Ruutu>();
    private Integer leveys;
    private Integer korkeus;
    
    public Pelilauta(int korkeus, int leveys){
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.ruudut.clear();
        for (int i = 0; i < leveys * korkeus; i++) {
            this.ruudut.add(new Ruutu());
        }
        
    }
    public int palautaLeveys() {
        return this.leveys;
    }
    public int palautaKorkeus() {
        return this.korkeus;
    }
    public ArrayList<Ruutu> palautaRuutuLista() {
        return this.ruudut;
    }
    public Ruutu palautaRuutu(int x, int y) {
        return ruudut.get(y * this.leveys + x);
    }
    
    public void tuubaa(){
        Random noppa = new Random();
        int maara = noppa.nextInt(((this.leveys * this.korkeus) + 1)/2);
        
        for (int i = 0; i < maara; i++){
            int k = noppa.nextInt(this.korkeus);
            int l = noppa.nextInt(this.leveys);
            this.ruudut.get(k * this.leveys + l).havaittu = true;
            this.ruudut.get(k * this.leveys + l).seina = true;
        }
        
    }
    
    public void tulosta(){
        for (int k = 0; k < this.korkeus; k++){
            String rivi = new String();
            for (int l = 0; l < this.leveys; l++){
                rivi += this.ruudut.get(k * this.leveys + l).toString();
            }
            System.out.println(rivi);
        }
    }
}
