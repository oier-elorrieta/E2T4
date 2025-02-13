package ModeloDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import ModeloPOJOS.*;

public class HerrialdeaDAO {
	private static final String URL = "jdbc:mysql://localhost:3307/db_erronka2";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	
	public static ArrayList<Herrialdea> herrialdeaKargatu(){
		String sql = "SELECT * FROM herrialdea";
		
		ArrayList<Herrialdea> herrialdeak = new ArrayList<>();
		
		try {
			Connection agentziaKonexioa = DriverManager.getConnection(URL, USER, PASSWORD); //AgentziaDAO.konexioa();
			Statement stmt = agentziaKonexioa.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Herrialdea herrialdea = new Herrialdea(rs.getString("izena"), rs.getString("herrialde_kod"));
				herrialdeak.add(herrialdea);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return herrialdeak;
	}
	
	public static String herrialde_kodAtera(String herrialde) {
		String sql = "SELECT herrialde_kod FROM herrialdea WHERE izena = " + "'" + herrialde + "'";
		String herrialdeKod = "";
		try {
			Connection conn = KonexioDAO.konexioa();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				herrialdeKod = rs.getString("herrialde_kod");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return herrialdeKod;
	}
}
