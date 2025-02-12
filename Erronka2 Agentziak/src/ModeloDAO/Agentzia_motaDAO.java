package ModeloDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Agentzia_motaDAO {
	private static final String URL = "jdbc:mysql://localhost:3307/db_erronka2";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	
	public static ArrayList<String> agentzia_motaKargatu(){
		String sql = "SELECT * FROM agentzia_mota";
		ArrayList<String> motak = new ArrayList<>();
		
		try {
			Connection bidaiKonexioa = DriverManager.getConnection(URL,USER,PASSWORD);//BidaiaDAO.konexioa();
			Statement stmt = bidaiKonexioa.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String mota = rs.getString("desk");
				motak.add(mota);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return motak;
	}
	
	public static ArrayList<String> langile_kopuruKargatu(){
		String sql = "SELECT desk from langile_kop";
		ArrayList<String> kopuru = new ArrayList<>();
		
		try {
			Connection bidaiKonexioa = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = bidaiKonexioa.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String kop = rs.getString("Desk");
				kopuru.add(kop);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return kopuru;
	}
	
	public static String langile_kopAtera(String empKop) {
		String sql = "SELECT langile_kop_kod FROM langile_kop WHERE Desk = ?";
		String kopuruKode = "";
		try {
			Connection conn = AgentziaDAO.konexioa();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, empKop);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				kopuruKode = rs.getString("Langile_kop_kod");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kopuruKode;
	}
	
	public static String agentzia_motaAtera(String mota) {
		String sql = "SELECT agentzia_mota_kod FROM agentzia_mota WHERE desk = ?";
		String agentziaKode = "";
		try {
			Connection conn = AgentziaDAO.konexioa();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, mota);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				agentziaKode = rs.getString("agentzia_mota_kod");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return agentziaKode;
	}
}
