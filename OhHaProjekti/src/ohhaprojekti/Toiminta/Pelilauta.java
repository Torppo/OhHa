/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohhaprojekti.Toiminta;

import java.util.ArrayList;
import java.util.Random;
import ohhaprojekti.Otukset.Otus;

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
    public ArrayList<String> palautaMerkkijonot() {
        ArrayList<String> jonot = new ArrayList<String>();
        for (int i = 0; i < this.korkeus; i++) {
            String jono = new String();
            for (int j = 0; j < this.leveys; j++) {
                jono += this.ruudut.get(i*this.leveys+j).toString();
            }
            jonot.add(jono);
        }
        return jonot;
    }
    public boolean lisaaOtusRuutuun(Paikka paikka, Otus otus) {
         if(this.ruudut.get(paikka.y*leveys+paikka.x).seina == true) {
            return false;
         }
         if(this.ruudut.get(paikka.y*leveys+paikka.x).otus != null) {
             otus.hyokkaa();
         }
         if(!this.ruudut.get(paikka.y*leveys+paikka.x).esineet.isEmpty()) {
             return false;
         }
        this.ruudut.get(paikka.y*leveys+paikka.x).otus = otus;
        otus.muutaPaikkaa(paikka);
        System.out.println(otus.palautaPaikka().x + ", " + otus.paikka.y);
        return true;
    }
    public void poistaOtusRuudusta(Paikka paikka) {
        this.ruudut.get(paikka.y*this.leveys+paikka.x).otus = null;
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
