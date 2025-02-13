package ModeloJUnit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

import ModeloDAO.*;

class AirelineakDAOTest {
    
    @Test
    void testAirelineakKargatu() {
        ArrayList<String> airelineak = ZerbitzuaDAO.airelineakKargatu();
        assertNotNull(airelineak, "La lista de aerolíneas no debe ser nula");
        assertTrue(airelineak.contains("AVIANCA-Ecuador dba AVIANCA")); //Debe contener la aerolínea insertada en setUp
    }
}

