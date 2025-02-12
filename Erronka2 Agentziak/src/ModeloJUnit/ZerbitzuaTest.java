package ModeloJUnit;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Time;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ModeloPOJOS.Zerbitzua;


class ZerbitzuaTest {
    private Zerbitzua zerbitzuaHegaldiJoan;
    private Zerbitzua zerbitzuaHegaldiItzuli;
    private Zerbitzua zerbitzuaOstatua;
    private Zerbitzua zerbitzuaJarduera;

    @BeforeEach
    void setUp() {
        Date testDate = new Date();
        Time testTime = new Time(System.currentTimeMillis());
        
        zerbitzuaHegaldiJoan = new Zerbitzua(1, 101, 5001, "Flight 101", testTime, testDate, 120, 199.99, "JFK", "LAX", "AA");
        zerbitzuaHegaldiItzuli = new Zerbitzua(1, 102, 5002, testDate, "AA", 199.99, testTime, 120);
        zerbitzuaOstatua = new Zerbitzua(1, 103, "Hotel ABC", "Suite", "Paris", testDate, testDate, 499.99);
        zerbitzuaJarduera = new Zerbitzua(1, 104, "Tour Eiffel", "Visita guiada", testDate, 49.99);
    }

    @Test
    void testHegaldiJoanKonstruktorea() {
        assertEquals(1, zerbitzuaHegaldiJoan.getBidaia_id());
        assertEquals(101, zerbitzuaHegaldiJoan.getZerbitzu_id());
        assertEquals("hegaldia", zerbitzuaHegaldiJoan.getZerbitzu_mota());
        assertEquals("JFK", zerbitzuaHegaldiJoan.getIata_kod_jatorri());
        assertEquals("LAX", zerbitzuaHegaldiJoan.getIata_kod_helmuga());
        assertEquals(199.99, zerbitzuaHegaldiJoan.getZerbitzu_prezioa());
    }

    @Test
    void testHegaldiItzuliConstructor() {
        assertEquals(1, zerbitzuaHegaldiItzuli.getBidaia_id());
        assertEquals(102, zerbitzuaHegaldiItzuli.getZerbitzu_id());
        assertEquals("hegaldia", zerbitzuaHegaldiItzuli.getZerbitzu_mota());
        assertEquals("AA", zerbitzuaHegaldiItzuli.getAerolineaItzul());
        assertEquals(199.99, zerbitzuaHegaldiItzuli.getZerbitzu_prezioa());
    }

    @Test
    void testOstatuaConstructor() {
        assertEquals(1, zerbitzuaOstatua.getBidaia_id());
        assertEquals(103, zerbitzuaOstatua.getZerbitzu_id());
        assertEquals("ostatua", zerbitzuaOstatua.getZerbitzu_mota());
        assertEquals("Paris", zerbitzuaOstatua.getHiria());
        assertEquals(499.99, zerbitzuaOstatua.getZerbitzu_prezioa());
    }

    @Test
    void testJardueraConstructor() {
        assertEquals(1, zerbitzuaJarduera.getBidaia_id());
        assertEquals(104, zerbitzuaJarduera.getZerbitzu_id());
        assertEquals("jarduera", zerbitzuaJarduera.getZerbitzu_mota());
        assertEquals("Tour Eiffel", zerbitzuaJarduera.getZerbitzu_izena());
        assertEquals("Visita guiada", zerbitzuaJarduera.getJarduera_desk());
        assertEquals(49.99, zerbitzuaJarduera.getZerbitzu_prezioa());
    }
}
