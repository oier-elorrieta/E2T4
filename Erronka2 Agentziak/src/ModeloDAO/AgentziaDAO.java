package ModeloDAO;

import java.sql.*;
import controlador.Metodos;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import ModeloPOJOS.*;

public class AgentziaDAO {
	private static final String URL = "jdbc:mysql://localhost:3307/db_erronka2";
	private static final String USER = "root";
	private static final String PASSWORD = "";

	public static void agentziaKargatu(ArrayList<Agentzia> agentziak, ArrayList<Bidaia> bidaiak) {
		String sql = "SELECT * FROM agentzia";

		try {
			Connection agentziaKonexioa = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = agentziaKonexioa.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Agentzia agentzia = new Agentzia(rs.getInt("Agentzia_id"), rs.getString("erabiltzailea"),
						rs.getString("pasahitza"), rs.getString("Desk"), rs.getString("Logoa"), rs.getString("Kolorea"),
						rs.getString("Langile_kop_kod"), rs.getString("agentzia_mota_kod"), bidaiak);
				agentziak.add(agentzia);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
