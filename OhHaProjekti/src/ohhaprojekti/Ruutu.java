/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohhaprojekti;

import java.util.ArrayList;

/**
 *
 * @author pii
 */
public class Ruutu {
    public Boolean seina;
    public Boolean havaittu;
    public Otus otus;
    public ArrayList<Esine> esineet;
    
    public Ruutu(){
        seina = false;
        havaittu = false;
        otus = null;
        esineet = new ArrayList<Esine>();        
    }
   
    @Override
    public String toString(){
        String merkki = new String(".");
        if (this.otus != null) merkki = "X";
        if (this.seina) merkki = "#";
        if (!this.esineet.isEmpty()) merkki = "%";
//        if (!this.havaittu) merkki = " ";
        
        return merkki;
    }
    
}
