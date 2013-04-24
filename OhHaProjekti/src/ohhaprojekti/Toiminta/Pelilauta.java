/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohhaprojekti.Toiminta;

import java.util.ArrayList;
import java.util.Random;
import ohhaprojekti.Otukset.Monsteri;
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
        Random noppa = new Random();
        int monsterit = noppa.nextInt(((this.leveys * this.korkeus) + 1)/10);
        int seinat = noppa.nextInt(((this.leveys * this.korkeus) + 1)/2);
        
        for (int i = 0; i < monsterit; i++){
            int k = noppa.nextInt(this.korkeus);
            int l = noppa.nextInt(this.leveys);
            this.ruudut.get(k * this.leveys + l).otus = new Monsteri(2, 1, 7, 9, new Paikka(k, this.leveys+l));
        }
         
        for (int i = 0; i < seinat; i++){
            int k = noppa.nextInt(this.korkeus);
            int l = noppa.nextInt(this.leveys);
            if(this.ruudut.get(k * this.leveys + l).otus == null) {
                this.ruudut.get(k * this.leveys + l).seina = true;
            }
        }
        
    }
    /**
     * Metodi kerää listaan kaikki pelilaudan monsterit ja palauttaa listan.
     * @return lista monstereista
     */
    public ArrayList<Otus> palautaListaLaudanMonstereista() {
        ArrayList<Otus> monsteriLista = new ArrayList<Otus>();
        for (int i = 0; i < this.ruudut.size(); i++) {
            if(this.ruudut.get(i).otus != null && this.ruudut.get(i).otus.palautaMerkki().equals("M")) {
                monsteriLista.add(this.ruudut.get(i).otus);
            }
        }
        return monsteriLista;
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
    /**
     * LisaaOtusRuutuun -metodi selvittää onko Pelilaudan ruudussa, jonka paikan se saa parametrina, tyhjä.
     * Jos Ruutu on tyhjä se poistaa parametrinaan saamansa otuksen sen lähtöruudusta ja asettaa sen tähän uuteen tyhjään ruutuun.
     * Tämän jälkeen se muuttaa saamansa otuksen paikan koordinaatit uuden ruudun koordinaateiksi.
     * Jos ruudussa olikin seinä otus pysyy paikallaan. Jos siinä oli toinen otus sen kimppuun hyökätään.
     * @param paikka on uuden ruudun paikkaa ilmaiseva olio.
     * @param otus on otus, jota on siirettävä.
     * @return true, jos siirto onnistui ja false, jos ei onnistunut. 
     */
    public boolean lisaaOtusRuutuun(Paikka paikka, Otus otus) {
         if(paikka.x < 0 || paikka.x >= this.leveys || paikka.y < 0 || paikka.y >= this.korkeus || this.ruudut.get(paikka.y*leveys+paikka.x).seina == true) {
            return false;
         }
         if(this.ruudut.get(paikka.y*leveys+paikka.x).otus != null) {
             while(true) {
                 this.ruudut.get(paikka.y*leveys+paikka.x).otus.puolusta(otus.hyokkaa());
                 otus.puolusta(this.ruudut.get(paikka.y*leveys+paikka.x).otus.hyokkaa());
                 
                 if(this.ruudut.get(paikka.y*leveys+paikka.x).otus.palautaKunto() < 1) {
                     break;
                 }
                 if(otus.palautaKunto() < 1) {
                     otus.muutaMerkkia("K");
                     return false;
                 }
             }
         }
        poistaOtusRuudusta(otus.palautaPaikka());
        this.ruudut.get(paikka.y*leveys+paikka.x).otus = otus;
        otus.muutaPaikkaa(paikka);
        return true;
    }
    /**
     * Metodi poistaa kaikki otukset ja seinät pelilaudalta.
     */
    public void tyhjennaRuudut() {
        for (int i = 0; i < this.ruudut.size(); i++) {
           this.ruudut.get(i).otus = null;
           this.ruudut.get(i).seina = false;
        }
    }
    /**
     * Metodi asettaa ruudun otuksen nulliksi, jonka paikan se saa parametrina.
     * @param paikka ilmaisee ruudun paikan Pelilaudalla.
     */
    public void poistaOtusRuudusta(Paikka paikka) {
        if(paikka.x > -1 && paikka.x < this.leveys && paikka.y > -1 && paikka.y < this.korkeus) {
           this.ruudut.get(paikka.y*this.leveys+paikka.x).otus = null;
         }
    } 
    /**
     * Tulostaa Pelilaudan ruudut koordinaatistossa.
     */
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
