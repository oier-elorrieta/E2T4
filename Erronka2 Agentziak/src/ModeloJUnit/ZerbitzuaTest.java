package ModeloJUnit;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Time;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ModeloPOJOS.Zerbitzua;


class ZerbitzuaTest {
    private Zerbitzua zerbitzua;
    
    @BeforeEach
    void setUp() {
        zerbitzua = new Zerbitzua(1, 2, 3, "Izen Hegaldi", "Mota Hegaldi", "Jatorri Portua", "Helmuga Portua",
                new Date(), "Norako Aerolinea", new Time(System.currentTimeMillis()), 120, 200.0);
    }
    
    @Test
    void testGettersAndSetters() {
        zerbitzua.setBidaia_id(10);
        assertEquals(10, zerbitzua.getBidaia_id());
        
        zerbitzua.setZerbitzu_id(20);
        assertEquals(20, zerbitzua.getZerbitzu_id());
        
        zerbitzua.setHegaldiId(30);
        assertEquals(30, zerbitzua.getHegaldiId());
        
        zerbitzua.setHegaldiIzen("Hegaldi Berria");
        assertEquals("Hegaldi Berria", zerbitzua.getHegaldiIzen());
        
        zerbitzua.sethMota("Mota Berria");
        assertEquals("Mota Berria", zerbitzua.gethMota());
        
        zerbitzua.setPortuJatorri("Portu Jatorri Berria");
        assertEquals("Portu Jatorri Berria", zerbitzua.getPortuJatorri());
        
        zerbitzua.setPortuHelmuga("Portu Helmuga Berria");
        assertEquals("Portu Helmuga Berria", zerbitzua.getPortuHelmuga());
        
        Date newDate = new Date();
        zerbitzua.setDataNorako(newDate);
        assertEquals(newDate, zerbitzua.getDataNorako());
        
        zerbitzua.setAerolineaNorako("Aerolinea Berria");
        assertEquals("Aerolinea Berria", zerbitzua.getAerolineaNorako());
        
        Time newTime = new Time(System.currentTimeMillis());
        zerbitzua.setHorduIrteera(newTime);
        assertEquals(newTime, zerbitzua.getHorduIrteera());
        
        zerbitzua.setIraupenJoan(300);
        assertEquals(300, zerbitzua.getIraupenJoan());
        
        zerbitzua.setPrezio(350.0);
        assertEquals(350.0, zerbitzua.getPrezio());
    }
}
