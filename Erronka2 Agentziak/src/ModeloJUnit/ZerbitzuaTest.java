package ModeloJUnit;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ModeloDAO.ZerbitzuaDAO;
import ModeloPOJOS.Zerbitzua;


class ZerbitzuaTest {
	//Hegaldi motako zerbitzuaren konstruktorearen testa
    @Test
    void testHegaldia() {
        int bidaia_id = 1;
        int zerbitzu_id = 101;
        int hegaldi_kod_joan = 1001;
        String zerbitzu_izena = "Hegaldi Joan";
        // Erabili 10:30:00 den ordua
        Time orduIrteera = new Time(10 * 3600 * 1000 + 30 * 60 * 1000);
        Date dataJoan = new Date();
        int iraupen_joan = 120;
        double prezioa_joan = 150.50;
        String iata_kod_jatorri = "JTR";
        String iata_kod_helmuga = "HLM";
        String airelinea_kod = "AL123";
        
        Zerbitzua zerbitzua = new Zerbitzua(bidaia_id, zerbitzu_id, hegaldi_kod_joan, zerbitzu_izena, orduIrteera, dataJoan, iraupen_joan, prezioa_joan,
                                    iata_kod_jatorri, iata_kod_helmuga, airelinea_kod);
        
        // Egiaztatu parametro guztiak getter-ak erabiliz
        assertEquals(bidaia_id, zerbitzua.getBidaia_id());
        assertEquals(zerbitzu_id, zerbitzua.getZerbitzu_id());
        // Zerbitzu mota "hegaldia" ezarri da konstruktorean
        assertEquals("hegaldia", zerbitzua.getZerbitzu_mota());
        assertEquals(hegaldi_kod_joan, zerbitzua.getHegaldi_kod_joan());
        assertEquals(zerbitzu_izena, zerbitzua.getZerbitzu_izena());
        assertEquals(orduIrteera, zerbitzua.getOrduIrteera());
        assertEquals(dataJoan, zerbitzua.getZerbitzu_data());
        assertEquals(iraupen_joan, zerbitzua.getIraupen_joan());
        assertEquals(prezioa_joan, zerbitzua.getZerbitzu_prezioa(), 0.001);
        assertEquals(iata_kod_jatorri, zerbitzua.getIata_kod_jatorri());
        assertEquals(iata_kod_helmuga, zerbitzua.getIata_kod_helmuga());
        assertEquals(airelinea_kod, zerbitzua.getAirelinea_kod());
    }
    
    //Joan_etorria (bueltako hegaldia) motako zerbitzuaren konstruktorearen testa
    @Test
    void testJoan_etorria() {
        int bidaia_id = 2;
        int zerbitzu_id = 202;
        int hegaldi_kod_itzuli = 2002;
        Date dataItzul = new Date();
        String aerolineaItzul = "Iberia";
        double prezio = 175.50;
        // Erabili 15:45:00 den ordua
        Time orduItzul = new Time(15 * 3600 * 1000 + 45 * 60 * 1000);
        int iraupenItzuli = 130;
        
        Zerbitzua z = new Zerbitzua(bidaia_id, zerbitzu_id, hegaldi_kod_itzuli, dataItzul,
                                    aerolineaItzul, prezio, orduItzul, iraupenItzuli);
        
        // Egiaztatu parametro guztiak
        assertEquals(bidaia_id, z.getBidaia_id());
        assertEquals(zerbitzu_id, z.getZerbitzu_id());
        // Zerbitzu mota "hegaldia" ezarri da
        assertEquals("hegaldia", z.getZerbitzu_mota());
        assertEquals(hegaldi_kod_itzuli, z.getHegaldi_kod_itzuli());
        assertEquals(dataItzul, z.getZerbitzu_data());
        assertEquals(aerolineaItzul, z.getAerolineaItzul());
        assertEquals(prezio, z.getZerbitzu_prezioa(), 0.001);
        assertEquals(orduItzul, z.getOrduItzul());
        assertEquals(iraupenItzuli, z.getIraupenItzuli());
    }
    
    // Ostatu motako zerbitzuaren konstruktorearen tesa
    @Test
    void testOstatua() {
        int bidaia_id = 3;
        int zerbitzu_id = 303;
        String ostatu_izena = "Hotel Test";
        String logela_mota_kod = "LMK1";
        String hiria = "Barcelona";
        Date hasiera_data = new Date();
        // Amaiera data hasiera dataren 2 egun barru
        Date amaiera_data = new Date(hasiera_data.getTime() + 2 * 86400000L);
        double ostatu_prezioa = 200.0;
        
        Zerbitzua z = new Zerbitzua(bidaia_id, zerbitzu_id, ostatu_izena, logela_mota_kod,
                                    hiria, hasiera_data, amaiera_data, ostatu_prezioa);
        
        // Egiaztatu parametro guztiak
        assertEquals(bidaia_id, z.getBidaia_id());
        assertEquals(zerbitzu_id, z.getZerbitzu_id());
        // Zerbitzu mota "ostatua" ezarri da
        assertEquals("ostatua", z.getZerbitzu_mota());
        assertEquals(ostatu_izena, z.getZerbitzu_izena());
        assertEquals(logela_mota_kod, z.getLogela_mota_kod());
        assertEquals(hiria, z.getHiria());
        assertEquals(hasiera_data, z.getZerbitzu_data());
        assertEquals(amaiera_data, z.getAmaiera_data());
        assertEquals(ostatu_prezioa, z.getZerbitzu_prezioa(), 0.001);
    }
    
    // Jarduera motako zerbitzuaren tesa
    @Test
    void testJarduera() {
        int bidaia_id = 4;
        int zerbitzu_id = 404;
        String jarduera_izena = "Jarduera Test";
        String jarduera_desk = "Deskribapen jarduera";
        Date jarduera_data = new Date();
        double jarduera_prezioa = 75.25;
        
        Zerbitzua zerbitzua = new Zerbitzua(bidaia_id, zerbitzu_id, jarduera_izena, jarduera_desk,
                                    jarduera_data, jarduera_prezioa);
        
        // Egiaztatu parametro guztiak
        assertEquals(bidaia_id, zerbitzua.getBidaia_id());
        assertEquals(zerbitzu_id, zerbitzua.getZerbitzu_id());
        // Zerbitzu mota "jarduera" ezarri da
        assertEquals("jarduera", zerbitzua.getZerbitzu_mota());
        assertEquals(jarduera_izena, zerbitzua.getZerbitzu_izena());
        assertEquals(jarduera_desk, zerbitzua.getJarduera_desk());
        assertEquals(jarduera_data, zerbitzua.getZerbitzu_data());
        assertEquals(jarduera_prezioa, zerbitzua.getZerbitzu_prezioa(), 0.001);
    }
    
    /**
     * Test Getter eta Setter metodo guztiak.
     */
    @Test
    void testGettersAndSetters() {
        // Sortu zerbitzu objektu bat Constructor 1 erabiliiz
        int bidaia_id = 10;
        int zerbitzu_id = 1010;
        int hegaldi_kod_joan = 1100;
        String zerbitzu_izena = "Initial Izena";
        Time orduIrteera = new Time(8 * 3600 * 1000); // 08:00:00
        Date dataJoan = new Date();
        int iraupen_joan = 90;
        double prezioa_joan = 100.0;
        String iata_kod_jatorri = "IATA1";
        String iata_kod_helmuga = "IATA2";
        String airelinea_kod = "AIR123";
        
        Zerbitzua zerbitzua = new Zerbitzua(bidaia_id, zerbitzu_id, hegaldi_kod_joan, zerbitzu_izena,
                                    orduIrteera, dataJoan, iraupen_joan, prezioa_joan,
                                    iata_kod_jatorri, iata_kod_helmuga, airelinea_kod);
        
        // Bidaia_id
        zerbitzua.setBidaia_id(20);
        assertEquals(20, zerbitzua.getBidaia_id());
        
        // Zerbitzu_id
        zerbitzua.setZerbitzu_id(2020);
        assertEquals(2020, zerbitzua.getZerbitzu_id());
        
        // Zerbitzu_mota
        zerbitzua.setZerbitzu_mota("test_mota");
        assertEquals("test_mota", zerbitzua.getZerbitzu_mota());
        
        // Zerbitzu_data
        Date newDate = new Date(dataJoan.getTime() + 3600000); // +1 ordu
        zerbitzua.setZerbitzu_data(newDate);
        assertEquals(newDate, zerbitzua.getZerbitzu_data());
        
        // Zerbitzu_prezioa
        zerbitzua.setZerbitzu_prezioa(250.5);
        assertEquals(250.5, zerbitzua.getZerbitzu_prezioa(), 0.001);
        
        // Zerbitzu_izena
        zerbitzua.setZerbitzu_izena("New Izena");
        assertEquals("New Izena", zerbitzua.getZerbitzu_izena());
        
        // Hegaldi_kod_joan
        zerbitzua.setHegaldi_kod_joan(999);
        assertEquals(999, zerbitzua.getHegaldi_kod_joan());
        
        // OrduIrteera
        Time newTime = new Time(9 * 3600 * 1000 + 15 * 60 * 1000); // 09:15:00
        zerbitzua.setOrduIrteera(newTime);
        assertEquals(newTime, zerbitzua.getOrduIrteera());
        
        // Iraupen_joan
        zerbitzua.setIraupen_joan(110);
        assertEquals(110, zerbitzua.getIraupen_joan());
        
        // Iata_kod_jatorri
        zerbitzua.setIata_kod_jatorri("NEW_IATA1");
        assertEquals("NEW_IATA1", zerbitzua.getIata_kod_jatorri());
        
        // Iata_kod_helmuga
        zerbitzua.setIata_kod_helmuga("NEW_IATA2");
        assertEquals("NEW_IATA2", zerbitzua.getIata_kod_helmuga());
        
        // Airelinea_kod
        zerbitzua.setAirelinea_kod("NEW_AIR123");
        assertEquals("NEW_AIR123", zerbitzua.getAirelinea_kod());
        
        // Hegaldi_kod_itzuli
        zerbitzua.setHegaldi_kod_itzuli(888);
        assertEquals(888, zerbitzua.getHegaldi_kod_itzuli());
        
        // AerolineaItzul
        zerbitzua.setAerolineaItzul("AERO_RET");
        assertEquals("AERO_RET", zerbitzua.getAerolineaItzul());
        
        // OrduItzul
        Time newTimeReturn = new Time(17 * 3600 * 1000 + 30 * 60 * 1000); // 17:30:00
        zerbitzua.setOrduItzul(newTimeReturn);
        assertEquals(newTimeReturn, zerbitzua.getOrduItzul());
        
        // IraupenItzuli
        zerbitzua.setIraupenItzuli(95);
        assertEquals(95, zerbitzua.getIraupenItzuli());
        
        // Jarduera_desk
        zerbitzua.setJarduera_desk("New Jarduera Desk");
        assertEquals("New Jarduera Desk", zerbitzua.getJarduera_desk());
        
        // Logela_mota_kod
        zerbitzua.setLogela_mota_kod("LMK_NEW");
        assertEquals("LMK_NEW", zerbitzua.getLogela_mota_kod());
        
        // Hiria
        zerbitzua.setHiria("Madrid");
        assertEquals("Madrid", zerbitzua.getHiria());
        
        // Amaiera_data
        Date endDate = new Date(newDate.getTime() + 86400000); // +1 egun
        zerbitzua.setAmaiera_data(endDate);
        assertEquals(endDate, zerbitzua.getAmaiera_data());
    }
    
    @Test
    void testToString() {
        int bidaia_id = 5;
        int zerbitzu_id = 505;
        String jarduera_izena = "Jarduera ToString Test";
        String jarduera_desk = "Jarduera desk";
        Date jarduera_data = new Date();
        double jarduera_prezioa = 99.99;
        
        // Erabili Constructor 4 adibidez
        Zerbitzua zerbitzua = new Zerbitzua(bidaia_id, zerbitzu_id, jarduera_izena, jarduera_desk,
                                    jarduera_data, jarduera_prezioa);
        
        String result = zerbitzua.toString();
        // Egiaztatu emaitzan parametro nagusiak daudela
        assertTrue(result.contains("bidaia_id=" + bidaia_id));
        assertTrue(result.contains("zerbitzu_id=" + zerbitzu_id));
        assertTrue(result.contains("zerbitzu_mota=" + "jarduera"));
        assertTrue(result.contains("zerbitzu_izena=" + jarduera_izena));
        assertTrue(result.contains("jarduera_desk=" + jarduera_desk));
        assertTrue(result.contains("zerbitzu_prezioa=" + jarduera_prezioa));
    }
    
    @Test
    void testLogela_motaKargatu() {
        ArrayList<String> motak = ZerbitzuaDAO.logela_motaKargatu();
        assertNotNull(motak, "Logela moten zerrenda ez da nulua izan behar");
    }
}
