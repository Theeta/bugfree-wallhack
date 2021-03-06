
package ohtu.intjoukkosovellus;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IntJoukkoKaksiparametrisellaKonstruktorillaTest extends IntJoukkoTest {
    
    @Before
    public void setUp() {
        joukko = new IntJoukko(4, 2);
        joukko.lisaa(10);
        joukko.lisaa(3);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void konstruktoriHeittaaPoikkeuksenJosKapasiteettiOnNegatiivinen() {
        new IntJoukko(-4, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void konstruktoriHeittaaPoikkeuksenJosKasvatuskokoOnNegatiivinen() {
        new IntJoukko(4, -2);
    }
}
