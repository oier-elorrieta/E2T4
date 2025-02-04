package ModeloDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import Modelo.Bidaia;
import Modelo.Zerbitzua;

public class BidaiaDAO {
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
	
	public static void bidaiaKargatu(ArrayList<Bidaia> bidaiak, ArrayList<Zerbitzua> zerbitzuak) {
		String sql = "SELECT * FROM bidaia";
		
		int bidaia_id;
		String izena;
		String deskripzioa;
		Date hasieraData;
		Date amaieraData;
		int agentzia_id;
		String herrialde;
		String mota;
		
		try {
			Connection bidaiKonexioa = AgentziaDAO.konexioa();
			Statement stmt = bidaiKonexioa.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				bidaia_id = rs.getInt("Bidaia_id");
				izena = rs.getString("Izena");
				deskripzioa = rs.getString("Desk");
				hasieraData = rs.getDate("hasiera_data");
				amaieraData = rs.getDate("amaiera_data");
				agentzia_id = rs.getInt("agentzia_id");
				herrialde = rs.getString("herrialde_kod");
				mota = rs.getString("bidai_mota_kod");
				
				int diffInMillis = (int) (hasieraData.getTime() - amaieraData.getTime());
				int diffEgunetan = diffInMillis / (24 * 60 * 60 * 1000);
				Bidaia bidaia = new Bidaia(izena, mota, diffEgunetan, hasieraData, amaieraData, herrialde, deskripzioa, "", zerbitzuak);
		        bidaiak.add(bidaia);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
