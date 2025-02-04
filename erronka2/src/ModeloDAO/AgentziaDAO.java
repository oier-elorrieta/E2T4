package ModeloDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

import Modelo.*;

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
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return konexioa;
	}
	
	public static void agentziaKargatu(ArrayList<Agentzia> agentziak, ArrayList<Bidaia> bidaiak) {
		String sql = "SELECT * FROM agentzia";
		
		try {
			Connection agentziaKonexioa = AgentziaDAO.konexioa();
			Statement stmt = agentziaKonexioa.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {				
				Agentzia agentzia = new Agentzia(rs.getInt("Agentzia_id"), rs.getString("erabiltzailea"), rs.getString("pasahitza"), rs.getString("Desk"), rs.getString("Logoa"), rs.getString("Kolorea"), rs.getString("Langile_kop_kod"), rs.getString("agentzia_mota_kod"), bidaiak);
				agentziak.add(agentzia);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
