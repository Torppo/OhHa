package OtusTestit;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import ohhaprojekti.Toiminta.Hyokkays;
import ohhaprojekti.Toiminta.Paikka;
import ohhaprojekti.Otukset.Pelaaja;
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
        pelaaja = new Pelaaja("Sankari", 1, 2, 10, 12, new Paikka(1,3));
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
        assertEquals(1, pelaaja.palautaTaito());
    }
    @Test
    public void konstruktoriAsettaaKunnonOikein() {
        assertEquals(10, pelaaja.palautaKunto());
    }
    @Test
    public void konstruktoriAsettssVoimanOikein() {
        assertEquals(2, pelaaja.palautaVoima());
    }
    @Test
    public void konstruktoriAsettaaPuolustuksenOikein() {
        assertEquals(12, pelaaja.palautaPuolustus());
    }
    @Test
    public void konstruktoriAsettaaPaikanOikein() {
        assertEquals(1, pelaaja.palautaPaikka().x);
        assertEquals(3, pelaaja.palautaPaikka().y);
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
}
