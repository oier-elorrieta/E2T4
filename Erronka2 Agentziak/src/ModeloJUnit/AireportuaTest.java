package ModeloJUnit;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ModeloPOJOS.*;
import ModeloDAO.*;

class AireportuaTest {
	
	private static final String URL = "jdbc:mysql://localhost:3307/db_erronka2";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    private Connection conn;
	
	/**
	* Aireportua klaseko eraikitzailearen testa.
	* Balio jakinak dituen objektu bat sortzean,
	* getterrek balio horiek itzultzen dituzte.
	*/
    @Test
    public void testConstructor() {
    	// Aireportuko instantzia bat sortu da, "A01" eta "Bilbo" IDekin
        Aireportua aireportua = new Aireportua("A01", "Bilbao");
        
        // Hasierako balioak behar bezala esleitu direla egiaztatzen dugu
        assertEquals("A01", aireportua.getId_aireportua());
        assertEquals("Bilbao", aireportua.getHiria());
    }

    /**
    * Aireportua klaseko setter-en testa.
    * Objektu bat sortzen da, haren atributuak aldatzen dira setter bidez
    * eta getterrek balio berriak itzultzen dituztela egiaztatzen da.
    */
    @Test
    public void testSettersEtaGetters() {
        Aireportua aireportua = new Aireportua("A01", "Bilbao");
        
        // Atributuak aldatzen dira setterrak erabiliz
        aireportua.setId_aireportua("A02");
        aireportua.setHiria("Donostia");
        
        // Egiaztatu dugu balio berriak behar bezala esleitu direla
        assertEquals("A02", aireportua.getId_aireportua(), "El id debe ser A02");
        assertEquals("Donostia", aireportua.getHiria(), "La ciudad debe ser Donostia");
    }
    
    @Test
    void testAireportuakKargatuDatuakZuzenaDira() throws SQLException {
        // Konexioa ireki
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

        // Metodoa exekutatu
        ArrayList<Aireportua> aireportuak = AireportuaDAO.aireportakKargatu();

        // Konexioa itxi
        connection.close();

        // Egiaztatu gutxienez aireportu bat dagoela
        assertFalse(aireportuak.isEmpty(), "Ez da aireporturik eskuratu!");

        // Egiaztatu lehen aireportuaren kodea eta hiria (benetako datuekin ordezkatu)
        assertEquals("ACA", aireportuak.get(0).getId_aireportua()); // Adibidez: BIO = Bilbao
        assertEquals("MÉXICO (ACAPULCO)", aireportuak.get(0).getHiria());

        // Gainerako balioak egiaztatu nahi badituzu:
        // assertTrue(aireportuak.stream().anyMatch(a -> a.getIataKod().equals("BCN")));
        // assertTrue(aireportuak.stream().anyMatch(a -> a.getHiria().equals("Madrid")));
    }
    
    @Test
    void testAireportakKargatu() throws Exception{
    	conn = DriverManager.getConnection(URL, USER, PASSWORD);
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("INSERT INTO iata (iata_kod, hiria) VALUES ('SBL', 'Sabadell')");
        }
    	
        ArrayList<Aireportua> aireportuak = AireportuaDAO.aireportakKargatu();
        assertNotNull(aireportuak);
    }
}