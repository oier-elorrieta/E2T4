package controlador;
import java.util.ArrayList;

import ModeloDAO.*;
import ModeloPOJOS.*;
import vista.*;

import java.sql.*;

public class Metodos {
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
			Connection conn = Metodos.konexioa();
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
			Connection conn = Metodos.konexioa();
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
	
	//INSERTERS
	
	public static void agentziaSartu(String iAgen, String passAgen1, String empKop, String mota, String colore,
			String logo) {
		 String sql = "INSERT INTO agentzia (erabiltzailea, pasahitza, logoa, kolorea, langile_kop_kod, agentzia_mota_kod)"
		 + "VALUES ( ?, ?, ?, ?, ?, ?)";
		try {
			Connection conn = Metodos.konexioa();
			PreparedStatement stmt = conn.prepareStatement(sql);
			String empKop_kod = Metodos.langile_kopAtera(empKop);
			String mota_kod = Metodos.agentzia_motaAtera(mota);
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
	
	public static void bidaiaSartu(String bidaiIzena, String bidaiMota, String bidaiHasi, String bidaiAmaiera, String bidaiIraupen, String bidaiHerri, String bideiDesk, String textSGZerbitzu) {
		String sql = "INSERT INTO bidaia (izena, Desk, hasiera_data, amaiera_data, agentzia_id, herrialde_kod, bidai_mota_kod" + "VALUES (?, ?, ?, ?, ?, ?, ?)";
	}
}
