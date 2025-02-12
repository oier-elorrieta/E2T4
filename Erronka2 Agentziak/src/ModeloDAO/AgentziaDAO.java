package ModeloDAO;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import ModeloPOJOS.*;

public class AgentziaDAO {
	private static final String URL = "jdbc:mysql://localhost:3307/db_erronka2";
	private static final String USER = "root";
	private static final String PASSWORD = "";

	public static Connection konexioa() {
		Connection konexioa = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			konexioa = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Konexioa egin da");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return konexioa;
	}

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

	public static void agentziaSartu(String iAgen, String passAgen1, String empKop, String mota, String colore,
			String logo) {
		 String sql = "INSERT INTO agentzia (erabiltzailea, pasahitza, logoa, kolorea, langile_kop_kod, agentzia_mota_kod)"
		 + "VALUES ( ?, ?, ?, ?, ?, ?)";
		try {
			Connection conn = AgentziaDAO.konexioa();
			PreparedStatement stmt = conn.prepareStatement(sql);
			String empKop_kod = Agentzia_motaDAO.langile_kopAtera(empKop);
			String mota_kod = Agentzia_motaDAO.agentzia_motaAtera(mota);
			System.out.println(empKop_kod.length());
			empKop_kod = empKop_kod.trim();
			stmt.setString(1, iAgen);
			stmt.setString(2, passAgen1);
			stmt.setString(3,  colore);
			stmt.setString(4, logo);
			stmt.setString(5, empKop_kod);
			stmt.setString(6, mota_kod);
			if (stmt.executeUpdate() > 0) {
                System.out.println("AAAA");
            } else {
                System.out.println("NOOO");
            }
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
