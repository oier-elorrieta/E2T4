package ModeloJUnit;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ModeloPOJOS.Agentzia;
import ModeloPOJOS.Bidaia;

class AgentziaTest {
	private Agentzia agentzia;
	private Bidaia bidaia;

	@BeforeEach
	void setUp() {
		ArrayList<Bidaia> bidaiak = new ArrayList<>();
		agentzia = new Agentzia(1, "erabiltzailea1", "pasahitza1", "Deskribapena", "logo.png", "Urdina", "10", "Mota1",
				bidaiak);
		bidaia = new Bidaia();
	}

	@Test
	void testConstructor() {
		assertEquals(1, agentzia.getAgentzia_id());
		assertEquals("erabiltzailea1", agentzia.getErabiltzailea());
		assertEquals("pasahitza1", agentzia.getPasahitza());
		assertEquals("Deskribapena", agentzia.getDeskripzioa());
		assertEquals("logo.png", agentzia.getLogo());
		assertEquals("Urdina", agentzia.getKolorea());
		assertEquals("10", agentzia.getLangileKop());
		assertEquals("Mota1", agentzia.getAgentzia_mota_kod());
		assertNotNull(agentzia.getBidaiak());
		assertTrue(agentzia.getBidaiak().isEmpty());
	}

	@Test
	void testSetters() {
		agentzia.setAgentzia_id(2);
		assertEquals(2, agentzia.getAgentzia_id());

		agentzia.setErabiltzailea("erabiltzailea2");
		assertEquals("erabiltzailea2", agentzia.getErabiltzailea());

		agentzia.setPasahitza("pasahitza2");
		assertEquals("pasahitza2", agentzia.getPasahitza());

		agentzia.setDeskripzioa("Deskribapena2");
		assertEquals("Deskribapena2", agentzia.getDeskripzioa());

		agentzia.setLogo("logo2.png");
		assertEquals("logo2.png", agentzia.getLogo());

		agentzia.setKolorea("Gorria");
		assertEquals("Gorria", agentzia.getKolorea());

		agentzia.setLangileKop("20");
		assertEquals("20", agentzia.getLangileKop());

		agentzia.setAgentzia_mota_kod("Mota2");
		assertEquals("Mota2", agentzia.getAgentzia_mota_kod());
	}

	@Test
	void testBidaiak() {
		assertTrue(agentzia.getBidaiak().isEmpty());
		agentzia.getBidaiak().add(bidaia);
		assertFalse(agentzia.getBidaiak().isEmpty());
		assertEquals(1, agentzia.getBidaiak().size());
		assertEquals(bidaia, agentzia.getBidaiak().get(0));
	}
}
