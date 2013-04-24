/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohhaprojekti.Toiminta;

import java.util.ArrayList;
import ohhaprojekti.Otukset.Monsteri;
import ohhaprojekti.Otukset.Otus;
import ohhaprojekti.Otukset.Pelaaja;

/**
 *Ruutu kuvaa pelilaudan ruutuja. 
 * Ruudussa voi olla seinä tai otus ja se voi olla pelaajan vaitsema.
 * @author pii
 */
public class Ruutu {
    public Boolean seina;
    public Boolean havaittu;
    public Otus otus;
    
    public Ruutu(){
        this.seina = false;
        this.havaittu = false;
        this.otus = null;
    }
    /**
     * Palauttaa ruudussa olevaa asiaa ilmaisevan merkin.
     * @return String -merkin.
     */
    @Override
    public String toString(){
        String merkki = (".");
        if (this.otus != null) {
            merkki = this.otus.palautaMerkki();
        }
        if (this.seina) {
            merkki = "#";
        }
        if (!this.havaittu) {
            merkki = " ";
        }
        return merkki;
    }
}
