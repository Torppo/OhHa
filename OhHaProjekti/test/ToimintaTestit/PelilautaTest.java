/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ToimintaTestit;

import ohhaprojekti.Otukset.Otus;
import ohhaprojekti.Otukset.Pelaaja;
import ohhaprojekti.Toiminta.Paikka;
import ohhaprojekti.Toiminta.Pelilauta;
import ohhaprojekti.Toiminta.Ruutu;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pii
 */
public class PelilautaTest {
    private Pelilauta lauta;
    private Otus otus;
    private Paikka paikka;
    
    public PelilautaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.lauta = new Pelilauta(10, 12);
        this.lauta.tyhjennaRuudut();
        this.otus = new Pelaaja("Sankari", 1, 2, 10, 12, new Paikka(1,1));
        this.paikka = new Paikka(1, 2);
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void konstruktoriAsettaaKorkeudenOikein() {
        assertEquals(10, this.lauta.palautaKorkeus());
    }
    @Test
    public void konstruktoriAsettaaLeveydenOikein() {
        assertEquals(12, this.lauta.palautaLeveys());
    }
    @Test
    public void konstruktoriLuoRuutujaOikeanMaaran() {
        assertEquals(10*12, this.lauta.palautaRuutuLista().size());
    }
    @Test
    public void lisaaOtusRuutuunKunRuutuOnTyhja() {
        assertEquals(true, this.lauta.lisaaOtusRuutuun(paikka, otus));
    }
    @Test
    public void eiLisaaOtustaRuutuunKunRuudussaOnSeina() {
        this.lauta.palautaRuutu(this.paikka.x, this.paikka.y).seina = true;
        assertEquals(false, this.lauta.lisaaOtusRuutuun(paikka, otus));
    }
    @Test
    public void PoistaaOtuksenRuudusta() {
        this.lauta.lisaaOtusRuutuun(paikka, otus);
        this.lauta.poistaOtusRuudusta(paikka);
        assertEquals(null, this.lauta.palautaRuutu(paikka.x, paikka.y).otus);
    }
}
