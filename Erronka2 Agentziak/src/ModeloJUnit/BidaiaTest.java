package ModeloJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import ModeloPOJOS.Bidaia;
import ModeloPOJOS.Zerbitzua;

class BidaiaTest {
    private Bidaia bidaia;
    private Zerbitzua zerbitzua1;
    private Zerbitzua zerbitzua2;

    @BeforeEach
    void setUp() {
        ArrayList<Zerbitzua> zerbitzuak = new ArrayList<>();
        bidaia = new Bidaia("Mendi Ibilaldia", "Abentura", 5, new Date(), new Date(), "Euskal Herria", "Mendi ibilaldi zoragarria", "Gida zerbitzua ez dago barne", zerbitzuak);
    }

    @Test
    void testBidaiaGetters() {
        assertEquals("Mendi Ibilaldia", bidaia.getBidaia());
        assertEquals("Abentura", bidaia.getMota());
        assertEquals(5, bidaia.getEgunak());
        assertEquals("Euskal Herria", bidaia.getHerrialde());
        assertEquals("Mendi ibilaldi zoragarria", bidaia.getDeskripzioa());
        assertEquals("Gida zerbitzua ez dago barne", bidaia.getServNoinc());
    }

    @Test
    void testBidaiaSetters() {
        bidaia.setBidaia("Hondartza Bidaia");
        bidaia.setMota("Oporrak");
        bidaia.setEgunak(7);
        bidaia.setHerrialde("Espainia");
        bidaia.setDeskripzioa("Hondartzan atseden hartu");
        bidaia.setServNoinc("Gosaria ez dago barne");
        
        assertEquals("Hondartza Bidaia", bidaia.getBidaia());
        assertEquals("Oporrak", bidaia.getMota());
        assertEquals(7, bidaia.getEgunak());
        assertEquals("Espainia", bidaia.getHerrialde());
        assertEquals("Hondartzan atseden hartu", bidaia.getDeskripzioa());
        assertEquals("Gosaria ez dago barne", bidaia.getServNoinc());
    }

    @Test
    void testZerbitzuakGehituEtaLortu() {
        bidaia.gehituZerbitzua(zerbitzua1);
        bidaia.gehituZerbitzua(zerbitzua2);
        
        ArrayList<Zerbitzua> zerbitzuak = bidaia.getZerbitzuak();
        assertEquals(2, zerbitzuak.size());
        assertTrue(zerbitzuak.contains(zerbitzua1));
        assertTrue(zerbitzuak.contains(zerbitzua2));
    }
}

