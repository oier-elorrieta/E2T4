package ModeloJUnit;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ModeloPOJOS.Agentzia;
import ModeloPOJOS.Bidaia;
import ModeloPOJOS.Zerbitzua;
import ModeloDAO.*;

class AgentziaTest {
	private Agentzia agentzia;
	private Bidaia bidaia;
	
	private static final String URL = "jdbc:mysql://localhost:3307/db_erronka2";
    private static final String USER = "root";
    private static final String PASSWORD = "";
		/**
		* Eraikitzailearen testa agentziarik gabe_id.
		* Agentzia objektu bat sortzen da, ArrayList huts bat pasatuz bidaietarako.
		* Egiaztatu da:
		* - IDa lehenetsitako balioarekin geratzen da (0).
		* - Gainerako atributuak behar bezala esleitzen dira.
		*/
	    @Test
	    public void testIdGabe() {
	        ArrayList<Bidaia> bidaiak = new ArrayList<>();
	        Agentzia agentzia = new Agentzia("erabiltzailea", "pasahitza", "deskripzioa", "logo.png", "kolorea", "5", "agentzia_mota", bidaiak);

	     // Eraikitzailea id gabe erabiltzean, agentzia_id eremua 0an geratu behar da (int balio lehenetsia)
	        assertEquals(0, agentzia.getAgentzia_id());
	        assertEquals("erabiltzailea", agentzia.getErabiltzailea());
	        assertEquals("pasahitza", agentzia.getPasahitza());
	        assertEquals("deskripzioa", agentzia.getDeskripzioa());
	        assertEquals("logo.png", agentzia.getLogo());
	        assertEquals("kolorea", agentzia.getKolorea());
	        assertEquals("5", agentzia.getLangileKop());
	        assertEquals("agentzia_mota", agentzia.getAgentzia_mota_kod());
	        assertEquals(bidaiak, agentzia.getBidaiak());
	    }

	    /**
	    * Eraikitzailearen testa agentziarekin_id.
	    * Agentzia objektu bat sortzen da, bidaietarako ArrayList huts bat eta ID esplizitu bat pasatuz.
	    * Egiaztatu da:
	    * - IDa behar bezala esleitzen da.
	    * - Gainerako atributuak behar bezala esleitzen dira.
	    */
	    @Test
	    public void testIdrekin() {
	        ArrayList<Bidaia> bidaiak = new ArrayList<>();
	        Agentzia agentzia = new Agentzia(10, "erabiltzailea", "pasahitza", "deskripzioa", "logo2.png", "kolorea", "5", "agentzia_mota", bidaiak);

	        assertEquals(10, agentzia.getAgentzia_id());
	        assertEquals("erabiltzailea", agentzia.getErabiltzailea());
	        assertEquals("pasahitza", agentzia.getPasahitza());
	        assertEquals("deskripzioa", agentzia.getDeskripzioa());
	        assertEquals("logo2.png", agentzia.getLogo());
	        assertEquals("kolorea", agentzia.getKolorea());
	        assertEquals("5", agentzia.getLangileKop());
	        assertEquals("agentzia_mota", agentzia.getAgentzia_mota_kod());
	        assertEquals(bidaiak, agentzia.getBidaiak());
	    }

	    /**
	    * Getter eta setter testak.
	    * Agentzia objektu bat eskatzen da eta haren atributuak aldatzen dira setter,
	    * ondoren, getterrek aldatutako balioak itzultzen dituztela egiaztatuko da.
	    */
	    @Test
	    public void testSettersEtaGetters() {
	        ArrayList<Bidaia> bidaiak = new ArrayList<>();
	        Agentzia agentzia = new Agentzia("erabiltzailea", "pasahitza", "deskripzioa", "logo", "kolorea", "5", "agentzia_mota", bidaiak);

	        //Atributuen aldaketa
	        agentzia.setAgentzia_id(20);
	        agentzia.setErabiltzailea("admin");
	        agentzia.setPasahitza("admin");
	        agentzia.setDeskripzioa("desk");
	        agentzia.setLogo("logo.png");
	        agentzia.setKolorea("horia");
	        agentzia.setLangileKop("5");
	        agentzia.setAgentzia_mota_kod("Mayorista");

	        // Zerrenda huts berri bat sortu dugu Bidaiak ekimenari esleitzeko
	        ArrayList<Bidaia> bidaiak2 = new ArrayList<>();
	        agentzia.setBidaiak(bidaiak2);
	        
	        assertEquals(20, agentzia.getAgentzia_id());
	        assertEquals("admin", agentzia.getErabiltzailea());
	        assertEquals("admin", agentzia.getPasahitza());
	        assertEquals("desk", agentzia.getDeskripzioa());
	        assertEquals("logo.png", agentzia.getLogo());
	        assertEquals("horia", agentzia.getKolorea());
	        assertEquals("5", agentzia.getLangileKop());
	        assertEquals("Mayorista", agentzia.getAgentzia_mota_kod());
	        assertEquals(bidaiak2, agentzia.getBidaiak());
	    }
	    
	    @Test
	    public void testToString() {
	        // Testeko parametroak definitu
	        int agentzia_id = 1;
	        String erabiltzailea = "erabiltzailea";
	        String pasahitza = "pasahitza";
	        String deskripzioa = "deskripzioa";
	        String logo = "logo.png";
	        String kolorea = "kolorea";
	        String langileKop = "10";
	        String agentzia_mota_kod = "AMK1";
	        // Bidaiak zerrenda huts bat sortu
	        ArrayList<Bidaia> bidaiak = new ArrayList<>();
	        
	        // Agentzia objektua sortu, konstruktoreko parametro guztiak erabiliz
	        Agentzia agentzia = new Agentzia(agentzia_id, erabiltzailea, pasahitza, deskripzioa, 
	                                           logo, kolorea, langileKop, agentzia_mota_kod, bidaiak);
	        
	        // Lortu toString metodoaren emaitza
	        String result = agentzia.toString();
	        
	        // Egiaztatu emaitzan parametro guztiak sartzen direla
	        assertTrue(result.contains("1"));
	        assertTrue(result.contains("erabiltzailea"));
	        assertTrue(result.contains("pasahitza"));
	        assertTrue(result.contains("deskripzioa"));
	        assertTrue(result.contains("logo.png"));
	        assertTrue(result.contains("kolorea"));
	        assertTrue(result.contains("10"));
	        assertTrue(result.contains("AMK1"));
	    }
	    
	    @Test
	    void testAgentziaKargatuDatuakZuzenaDira() throws SQLException {
	        // Konexioa ireki
	        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
	        ArrayList<Agentzia> agentziak = new ArrayList<>();
	        ArrayList<Bidaia> bidaiak = new ArrayList<>();
	        
	        AgentziaDAO.agentziaKargatu(agentziak, bidaiak);
	        
	        // Konexioa itxi
	        connection.close();

	        // Egiaztatu gutxienez agentzia bat kargatu dela
	        assertFalse(agentziak.isEmpty());

	        // Lehenengo agentziaren datuak egiaztatu
	        Agentzia agentzia = agentziak.get(0);
	        assertNotNull(agentzia);
	        assertEquals("admin", agentzia.getErabiltzailea());
	        assertEquals("admin", agentzia.getPasahitza());

	        // Gainerako datuak null direla egiaztatu
	        assertNull(agentzia.getDeskripzioa());
	        assertNull(agentzia.getLogo());
	        assertNull(agentzia.getKolorea());
	        assertNull(agentzia.getLangileKop());
	        assertNull(agentzia.getAgentzia_mota_kod());
	    }
	    
	    @Test
	    void testAgentziaMotaKargatuDatuakZuzenaDira() throws SQLException {
	        // Konexioa ireki
	        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

	        // Metodoa exekutatu
	        ArrayList<String> motak = new ArrayList<String>();
	        motak = AgentziaDAO.agentzia_motaKargatu();

	        // Konexioa itxi
	        connection.close();

	        // Egiaztatu gutxienez mota bat dagoela
	        assertFalse(motak.isEmpty(), "Ez da agentzia motarik eskuratu!");

	        // Egiaztatu lehenengo motaren deskribapena (datu-basean egon beharko du)
	        assertEquals("Mayorista", motak.get(0)); // Aldatu benetako balioarekin

	        // Gainerako balioak egiaztatu nahi badituzu, hala egin dezakezu:
	        // assertTrue(motak.contains("Turismoa"));
	        // assertTrue(motak.contains("Abentura"));
	    }
	    
	    @Test
	    void testAgentziaKargatu() {
	        ArrayList<Agentzia> agentziak = new ArrayList<>();
	        ArrayList<Bidaia> bidaiak = new ArrayList<>();
	        
	        AgentziaDAO.agentziaKargatu(agentziak, bidaiak);
	        
	        assertFalse(agentziak.isEmpty(), "Agentzia zerrenda ezin da utzik egon");
	        Agentzia agentzia = agentziak.get(0);
	        assertEquals("admin", agentzia.getErabiltzailea(), "Erabiltzailea berdina izan behar");
	        assertEquals("admin", agentzia.getPasahitza(), "Pasahitza berdina izan behar da");
	    }
	    
	    @Test
	    void testAgentziaMotaKargatu() {
	        ArrayList<String> motak = AgentziaDAO.agentzia_motaKargatu();
	        assertNotNull(motak, "Kodigoa ezin da null izan");
	    }
	    
	    @Test
	    void testLangileKopuruKargatu() {
	        ArrayList<String> kopuru = AgentziaDAO.langile_kopuruKargatu();
	        assertNotNull(kopuru, "Kodigoa ezin da null izan");
	    }
	    
	    @Test
	    void testLangileKopAtera() {
	        String kod = AgentziaDAO.langile_kopAtera("Test deskripzioa");
	        assertNotNull(kod, "Kodigoa ezin da null izan");
	    }
	    
	    @Test
	    void testAgentziaMotaAtera() {
	        String kod = AgentziaDAO.agentzia_motaAtera("Test deskripzioa");
	        assertNotNull(kod, "Kodigoa ezin da null izan");
	    }
}
