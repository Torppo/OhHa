/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ToimintaTestit;

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
public class PelilautaTest {
    private Pelilauta lauta;
    
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
}
