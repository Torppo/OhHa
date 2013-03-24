/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ToimintaTestit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ohhaprojekti.Toiminta.Ruutu;

/**
 *
 * @author pii
 */
public class RuutuTest {
    private Ruutu ruutu;
    
    public RuutuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.ruutu = new Ruutu();
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
//     @Test
//     public void hello() {}
    @Test
    public void konstruktoriAsettaaSeinanFalseksi() {
        assertEquals(false, this.ruutu.seina);
    }
    @Test
    public void konstruktoriHavaitunFalseksi() {
        assertEquals(false, this.ruutu.havaittu);
    }
    @Test
    public void konstruktoriAsettaaOtuksenNulliksi() {
        assertEquals(null, this.ruutu.otus);
    }
    @Test
    public void konstruktoriLuoTyhjanEsinelistan() {
        assertEquals(true, this.ruutu.esineet.isEmpty());
    }
}
