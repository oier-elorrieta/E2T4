package ModeloDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import ModeloPOJOS.Aireportua;

public class AireportuaDAO {
	private static final String URL = "jdbc:mysql://localhost:3307/db_erronka2";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	
	public static ArrayList<Aireportua> aireportakKargatu(){
		String sql = "SELECT * FROM iata";
		
		ArrayList<Aireportua> aireportuak = new ArrayList<>();
		try {
			Connection agentziaKonexioa = DriverManager.getConnection(URL, USER, PASSWORD); //AgentziaDAO.konexioa();
			Statement stmt = agentziaKonexioa.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Aireportua aireportua = new Aireportua(rs.getString("iata_kod"), rs.getString("hiria"));
				aireportuak.add(aireportua);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return aireportuak;
	}
}
