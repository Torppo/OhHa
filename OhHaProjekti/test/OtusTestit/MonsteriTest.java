package OtusTestit;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import ohhaprojekti.Otukset.Monsteri;
import ohhaprojekti.Toiminta.Paikka;
import ohhaprojekti.Toiminta.Pelilauta;
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
public class MonsteriTest {
    Monsteri monsteri;
    Pelilauta lauta;
    
    public MonsteriTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.lauta = new Pelilauta(10,10);
        this.lauta.tyhjennaRuudut();
        this.monsteri = new Monsteri(2, 1, 9, 11, new Paikka(2,4));
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
    public void konstruktoriAsettaaTaidonOikein() {
        assertEquals(2, monsteri.palautaTaito());
    }
    @Test
    public void konstruktoriAsettaaKunnonOikein() {
        assertEquals(9, monsteri.palautaKunto());
    }
    @Test
    public void konstruktoriAsettaaVoimanOikein() {
        assertEquals(1, monsteri.palautaVoima());
    }
    @Test
    public void konstruktoriAsettaaPuolustuksenOikein() {
        assertEquals(11, monsteri.palautaPuolustus());
    }
    @Test
    public void konstruktoriAsettaaPaikanOikein() {
        assertEquals(2, monsteri.palautaPaikka().x);
        assertEquals(4, monsteri.palautaPaikka().y);
    }
    @Test
    public void liikuAsettaaPaikanOikein() {
        this.monsteri.liiku(0, 0, this.lauta);
        assertEquals(this.monsteri.palautaPaikka().x, 3);
        assertEquals(this.monsteri.palautaPaikka().y, 4);
    }
    @Test
    public void liikuPalauttaaEpatosi() {
        this.lauta.palautaRuutu(3, 4).seina = true;
        assertEquals(this.monsteri.liiku(0, 0, this.lauta), false);
    }
    @Test
    public void liikuPalauttaaTosi() {
        assertEquals(this.monsteri.liiku(0, 0, this.lauta), true);
    }
    @Test
    public void liikuLisaaYhdenLaskuriin() {
        this.monsteri.liiku(0, 0, this.lauta);
        assertEquals(1, this.monsteri.palautaLaskuri());
    }
    @Test
    public void liikuMuuttaaLaskurinTakaisinNollaksiKunSenArvoOn9() {
        Monsteri uusiMonsteri = new Monsteri(2, 1, 9, 11, new Paikka(3, 5));
        for (int i = 0; i < 10; i++) {
            uusiMonsteri.liiku(0, 0, this.lauta);
        }
        assertEquals(0, uusiMonsteri.palautaLaskuri());
    }
}
