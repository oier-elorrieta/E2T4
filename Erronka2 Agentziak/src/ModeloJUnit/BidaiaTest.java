package ModeloJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import ModeloPOJOS.Bidaia;
import ModeloPOJOS.Zerbitzua;
import ModeloDAO.*;

class BidaiaTest {
	private Bidaia bidaia = new Bidaia(0, 0, null, null, 0, null, null, null, null, null, null);
    private Zerbitzua zerbitzua1;
    
    private static final String URL = "jdbc:mysql://localhost:3307/db_erronka2";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    private Connection conn;

    /*
    @BeforeEach
    void setUp() throws Exception{
        conn = DriverManager.getConnection(URL, USER, PASSWORD);
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("INSERT INTO bidaia (bidaia_id, izena, bidai_mota_kod, hasiera_data, amaiera_data, agentzia_id, herrialde_kod, desk) "
                    + "VALUES (1, 'Test Bidaia', 'BM001', '2024-01-01', '2024-01-10', 1, 'HR001', 'Test Description')");
        }
    }
	*/
    @Test
    void testKonstruktorea() {
        // Konstruktorearen test: parametro guztiek behar bezala ezarri direla egiaztatu
        int agentzia_id = 2;
        int bidaia_id = 200;
        String bidaia_izena = "Test Bidaia";
        String mota = "Probaldia";
        int egunak = 15;
        Date hasiData = new Date();
        Date amaituData = new Date();
        String herrialdea = "Espainia";
        String deskripzioa = "Test deskribapena";
        String servNoinc = "Test serv";
        
        ArrayList<Zerbitzua> zerbitzuak = new ArrayList<>();
        zerbitzuak.add(zerbitzua1);
        
        // Konstruktorean, pasatutako zerbitzuak zerrenda beti berriz sortzen da eta hutsik gelditzen da.
        Bidaia testBidaia = new Bidaia(agentzia_id, bidaia_id, bidaia_izena, mota, egunak, hasiData, amaituData, herrialdea, deskripzioa, servNoinc, zerbitzuak);
        
        assertEquals(agentzia_id, testBidaia.getAgentzia_id());
        assertEquals(bidaia_id, testBidaia.getBidaia_id());
        assertEquals(bidaia_izena, testBidaia.getBidaia_izena());
        assertEquals(mota, testBidaia.getMota());
        assertEquals(egunak, testBidaia.getEgunak());
        assertEquals(hasiData, testBidaia.getHasiData());
        assertEquals(amaituData, testBidaia.getAmaituData());
        assertEquals(herrialdea, testBidaia.getHerrialde());
        assertEquals(deskripzioa, testBidaia.getDeskripzioa());
        assertEquals(servNoinc, testBidaia.getServNoinc());
        // Zerbitzuak zerrenda, konstruktorean berriz sortzen denez, hutsik egon behar du.
        assertTrue(testBidaia.getZerbitzuak().isEmpty());
    }
    
    @Test
    void testGettersEtaSetters() {
        // Test guztien getter eta setter metodoak
        
        // agentzia_id test
        bidaia.setAgentzia_id(5);
        assertEquals(5, bidaia.getAgentzia_id());
        
        // bidaia_id test
        bidaia.setBidaia_id(500);
        assertEquals(500, bidaia.getBidaia_id());
        
        // bidaia izena: setBidaia metodoa erabiliz (getBidaia_izena bidez eskuratu)
        bidaia.setBidaia("Bidai Testa");
        assertEquals("Bidai Testa", bidaia.getBidaia_izena());
        
        // mota test
        bidaia.setMota("Probaldia");
        assertEquals("Probaldia", bidaia.getMota());
        
        // egunak test
        bidaia.setEgunak(20);
        assertEquals(20, bidaia.getEgunak());
        
        // hasiData eta amaituData test
        Date now = new Date();
        Date later = new Date(now.getTime() + 1000);
        bidaia.setHasiData(now);
        assertEquals(now, bidaia.getHasiData());
        bidaia.setAmaituData(later);
        assertEquals(later, bidaia.getAmaituData());
        
        // herrialde test
        bidaia.setHerrialde("Frantzia");
        assertEquals("Frantzia", bidaia.getHerrialde());
        
        // deskripzioa test
        bidaia.setDeskripzioa("Test deskribapena");
        assertEquals("Test deskribapena", bidaia.getDeskripzioa());
        
        // servNoinc test
        bidaia.setServNoinc("Test serv");
        assertEquals("Test serv", bidaia.getServNoinc());
        
        // zerbitzuak zerrenda test: setter eta getter metodoak erabiliz
        ArrayList<Zerbitzua>zerbitzuaks = new ArrayList<>();
       zerbitzuaks.add(zerbitzua1);
        bidaia.setZerbituzak(zerbitzuaks);
        assertEquals(1, bidaia.getZerbitzuak().size());
        assertEquals(zerbitzua1, bidaia.getZerbitzuak().get(0));
    }
    
    @Test
    void testBidaiaKargatuDatuakZuzenaDira() throws SQLException {
        // Konexioa ireki
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        
        // Datuak gordetzeko zerrenda
        ArrayList<Bidaia> bidaiak = new ArrayList<>();
        int agentziaId = 1; // Aldatu balio hau benetako datu-baseko IDarekin

        // Metodoa exekutatu
        BidaiaDAO.bidaiaKargatu(bidaiak, agentziaId);

        // Konexioa itxi
        connection.close();

        // Egiaztatu gutxienez bidaia bat dagoela
        assertFalse(bidaiak.isEmpty(), "Ez da bidaiarik eskuratu!");

        // Lehen bidaia egiaztatu (balioak benetako datuekin aldatu)
        Bidaia bidaia = bidaiak.get(0);
        assertEquals(agentziaId, bidaia.getAgentzia_id());
        assertNotNull(bidaia.getBidaia_izena());
        assertNotNull(bidaia.getHasiData());
        assertNotNull(bidaia.getAmaituData());
        
        // Egun kopurua kalkulatzen du
        long diffEgunetan = (bidaia.getAmaituData().getTime() - bidaia.getHasiData().getTime()) / (24 * 60 * 60 * 1000);
        assertEquals(diffEgunetan, bidaia.getEgunak());

        // Egiaztatu zerbitzuak ez direla null
        assertNotNull(bidaia.getZerbitzuak());
    }
    
    void testBidaiMotaKargatuDatuakZuzenaDira() throws SQLException {
        // Konexioa ireki
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

        // Metodoa exekutatu
        ArrayList<String> motak = BidaiaDAO.bidai_motaKargatu();

        // Konexioa itxi
        connection.close();

        // Egiaztatu gutxienez bidaia mota bat dagoela
        assertFalse(motak.isEmpty(), "Ez da bidai mota bat bera ere eskuratu!");

        // Lehen bidaia mota egiaztatu (balioa benetako datuekin ordezkatu)
        assertEquals("Mayorista", motak.get(0)); // Datu-baseko lehen mota balioarekin ordezkatu
    }
    
    @Test
    void testBidaiaKargatu() {
        ArrayList<Bidaia> bidaiak = new ArrayList<>();
        BidaiaDAO.bidaiaKargatu(bidaiak, 1);
        
        assertFalse(bidaiak.isEmpty());
        Bidaia bidaia = bidaiak.get(0);
        assertEquals("Viaje Mediterraneo", bidaia.getBidaia_izena());
    }
    
    @Test
    void testBidaiMotaKodAtera() {
        String kod = BidaiaDAO.bidai_mota_kodAtera("Test Description");
        assertNotNull(kod);
    }
    
    @Test
    void testBidaiMotaKargatu() {
        ArrayList<String> motak = BidaiaDAO.bidai_motaKargatu();
        assertNotNull(motak);
    }
}

