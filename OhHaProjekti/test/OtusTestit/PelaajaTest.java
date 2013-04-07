package OtusTestit;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import ohhaprojekti.Toiminta.Hyokkays;
import ohhaprojekti.Toiminta.Paikka;
import ohhaprojekti.Otukset.Pelaaja;
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
public class PelaajaTest {
    Pelaaja pelaaja;
    Pelilauta lauta;
    
    public PelaajaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.pelaaja = new Pelaaja("Sankari", 1, 2, 10, 12, new Paikka(1,3));
        this.lauta = new Pelilauta(10,10);
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
    public void konstruktoriAsettaaNimenOikein() {
        assertEquals("Sankari", pelaaja.palautaNimi());
    }
    @Test
    public void konstruktoriAsettaaTaidonOikein() {
        assertEquals(1, pelaaja.taito);
    }
    @Test
    public void konstruktoriAsettaaKunnonOikein() {
        assertEquals(10, pelaaja.kunto);
    }
    @Test
    public void konstruktoriAsettssVoimanOikein() {
        assertEquals(2, pelaaja.voima);
    }
    @Test
    public void konstruktoriAsettaaPuolustuksenOikein() {
        assertEquals(12, pelaaja.puolustus);
    }
    @Test
    public void konstruktoriAsettaaPaikanOikein() {
        assertEquals(1, pelaaja.paikka.x);
        assertEquals(3, pelaaja.paikka.y);
    }
    @Test
    public void hyokkaaAsettaaOsumanHyokkaykseen() {
        Hyokkays hyokkays = pelaaja.hyokkaa();
        assert(hyokkays.osumaSumma > 1 && hyokkays.osumaSumma < 22);
    }
    @Test
    public void hyokkaaAsettaaVahingonHyokkaykseen() {
        Hyokkays hyokkays = pelaaja.hyokkaa();
        assert(hyokkays.vahinkoSumma > 2 && hyokkays.vahinkoSumma < 9);
    }
    @Test
    public void liikuAsettaaPaikanOikein() {
        this.pelaaja.liiku(0, 1, this.lauta);
        assertEquals(this.pelaaja.paikka.x, 1);
        assertEquals(this.pelaaja.paikka.y, 4);
    }
}
