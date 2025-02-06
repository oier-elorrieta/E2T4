package ModeloJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ModeloPOJOS.Herrialdea;

class HerrialdeaTest {

    private Herrialdea herrialdea;
    
    @BeforeEach
    void setUp() {
        herrialdea = new Herrialdea("Espainia", "ES");
    }

    @Test
    void testConstructor() {
        assertEquals("Espainia", herrialdea.getIzena());
        assertEquals("ES", herrialdea.getHerrialde_kod());
    }
    
    @Test
    void testSetters() {
        herrialdea.setIzena("Frantzia");
        assertEquals("Frantzia", herrialdea.getIzena());
        
        herrialdea.setHerrialde_kod("FR");
        assertEquals("FR", herrialdea.getHerrialde_kod());
    }
}
