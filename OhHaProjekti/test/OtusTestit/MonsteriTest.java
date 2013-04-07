package OtusTestit;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import ohhaprojekti.Otukset.Monsteri;
import ohhaprojekti.Toiminta.Paikka;
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
        monsteri = new Monsteri(2, 1, 9, 11, new Paikka(2,4));
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
        assertEquals(2, monsteri.taito);
    }
    @Test
    public void konstruktoriAsettaaKunnonOikein() {
        assertEquals(9, monsteri.kunto);
    }
    @Test
    public void konstruktoriAsettssVoimanOikein() {
        assertEquals(1, monsteri.voima);
    }
    @Test
    public void konstruktoriAsettaaPuolustuksenOikein() {
        assertEquals(11, monsteri.puolustus);
    }
    @Test
    public void konstruktoriAsettaaPaikanOikein() {
        assertEquals(2, monsteri.paikka.x);
        assertEquals(4, monsteri.paikka.y);
    }
}
