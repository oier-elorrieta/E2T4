package ModeloJUnit;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ModeloDAO.HerrialdeaDAO;
import ModeloPOJOS.Herrialdea;

class HerrialdeaTest {

	private Herrialdea herrialdea;
	
	private static final String URL = "jdbc:mysql://localhost:3307/db_erronka2";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    private Connection conn;
/*
    @BeforeEach
    void setUp() throws Exception{
        // Testeko Herrialdea objektua sortu: izena "Espainia" eta herrialde_kod "ESP"
        herrialdea = new Herrialdea("ESP", "Espainia");
        
        conn = DriverManager.getConnection(URL, USER, PASSWORD);
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("INSERT INTO herrialdea (herrialde_kod, izena) VALUES ('CAN', 'Cancun')");
        }
    }
*/
    @Test
    void testConstructor() {
        // Konstruktorearen test: parametroak behar bezala ezarri direla egiaztatu
        Herrialdea h = new Herrialdea("Frantzia", "FRA");
        assertEquals("Frantzia", h.getIzena());
        assertEquals("FRA", h.getHerrialde_kod());
    }
/*
    @Test
    void testGettersAndSetters() {
        // Getter eta setter metodoak probatu
        
        // Izena aldaketa eta egiaztapena
        herrialdea.setIzena("MÉXICO (ACAPULCO)");
        assertEquals("MÉXICO (ACAPULCO)", herrialdea.getIzena());
        
        // Herrialde_kod aldaketa eta egiaztapena
        herrialdea.setHerrialde_kod("ACA");
        assertEquals("ACA", herrialdea.getHerrialde_kod());
    }

    @Test
    void testToString() {
        // toString metodoaren emaitza egiaztatu:
        // Test honetan "Herriak", "Espainia" eta "ESP" duten presentzia egiaztatzen dugu.
        String result = herrialdea.toString();
        assertTrue(result.contains("Herriak"));
        assertTrue(result.contains("Espainia"));
        assertTrue(result.contains("ESP"));
    }
*/    
    @Test
    void testHerrialdeaKargatu() {
        ArrayList<Herrialdea> herrialdeak = HerrialdeaDAO.herrialdeaKargatu();
        assertNotNull(herrialdeak, "Herrialdeen zerrenda ezin da nulua izan");
    }
}
