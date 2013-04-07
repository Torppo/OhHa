/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohhaprojekti;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author pii
 */
public class PeliLauta {
    private ArrayList<Ruutu> ruudut = new ArrayList<Ruutu>();
    private Integer leveys;
    private Integer korkeus;
    
    public PeliLauta(int korkeus, int leveys){
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.ruudut.clear();
        for (int i = 0; i < leveys * korkeus; i++) {
            ruudut.add(new Ruutu());
        }
        
    }
    
    public void tuubaa(){
        Random noppa = new Random();
        int maara = noppa.nextInt(((this.leveys * this.korkeus) + 1)/2);
        
        for (int i = 0; i < maara; i++){
            int k = noppa.nextInt(this.korkeus);
            int l = noppa.nextInt(this.leveys);
            ruudut.get(k * this.leveys + l).havaittu = true;
            ruudut.get(k * this.leveys + l).seina = true;
        }
        
    }
    
    public void tulosta(){
        for (int k = 0; k < korkeus; k++){
            String rivi = new String();
            for (int l = 0; l < leveys; l++){
                rivi += ruudut.get(k * this.leveys + l).toString();
            }
            System.out.println(rivi);
        }
        System.out.println("tralala!");
    }
}
