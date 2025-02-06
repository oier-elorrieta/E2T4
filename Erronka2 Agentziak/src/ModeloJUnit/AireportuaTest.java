package ModeloJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ModeloPOJOS.*;

class AireportuaTest {

    private Aireportua aireportua;
    
    @BeforeEach
    void setUp() {
        aireportua = new Aireportua("BIO", "ES", "Bilbo");
    }

    @Test
    void testConstructor() {
        assertEquals("BIO", aireportua.getId_aireportua());
        assertEquals("ES", aireportua.getHerrialde_kod());
        assertEquals("Bilbo", aireportua.getHiria());
    }
    
    @Test
    void testSetters() {
        aireportua.setId_aireportua("MAD");
        assertEquals("MAD", aireportua.getId_aireportua());
        
        aireportua.setHerrialde_kod("FR");
        assertEquals("FR", aireportua.getHerrialde_kod());
        
        aireportua.setHiria("Paris");
        assertEquals("Paris", aireportua.getHiria());
    }
}