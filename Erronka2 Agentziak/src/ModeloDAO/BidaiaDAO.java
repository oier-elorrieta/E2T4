package ModeloDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import ModeloPOJOS.Bidaia;
import ModeloPOJOS.Zerbitzua;

public class BidaiaDAO {
	private static final String URL = "jdbc:mysql://localhost:3307/db_erronka2";
	private static final String USER = "root";
	private static final String PASSWORD = "";

	// Metodo honek bidaiak kargatzen ditu ArrayList-etan
	public static ArrayList<Bidaia> bidaiaKargatu(ArrayList<Bidaia> bidaiak, int agentzia_id) {
		String sql = "SELECT * FROM bidaia";
		
		Date hasiera;
		Date amaiera;
		ArrayList<Zerbitzua> zerbitzuak = new ArrayList<Zerbitzua>();
		
		try {
			Connection bidaiKonexioa = DriverManager.getConnection(URL,USER,PASSWORD);//BidaiaDAO.konexioa();
			Statement stmt = bidaiKonexioa.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				if(rs.getInt("agentzia_id")==agentzia_id) {
					hasiera = rs.getDate("hasiera_data");
					amaiera = rs.getDate("amaiera_data");
					int diffInMillis = (int) (amaiera.getTime() - hasiera.getTime());
					int diffEgunetan = diffInMillis / (24 * 60 * 60 * 1000);
					
					Bidaia bidaia = new Bidaia(rs.getInt("agentzia_id"), rs.getInt("Bidaia_id"), rs.getString("Izena"), rs.getString("bidai_mota_kod"), diffEgunetan, rs.getDate("hasiera_data"), rs.getDate("amaiera_data"), rs.getString("herrialde_kod"), rs.getString("Desk"), "", zerbitzuak = ZerbitzuaDAO.zerbitzuKargatu(rs.getInt("Bidaia_id"))); // Le asigno a cada viaje sus servicios llamado al ZerbitzuaDAO
			        bidaiak.add(bidaia);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return bidaiak;
		/*
		for(int i=0; i<bidaiak.size(); i++) {
			System.out.println(bidaiak.get(i));
			
		}
		*/
	}

	// Metodoa bidaiak ezabatzeko
	public static void BidaiaEzabatu(int Bidaia_Id) {
		String sql = "DELETE FROM bidaia WHERE bidaia_id = ?";

		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, Bidaia_Id);
			int filasAfectadas = stmt.executeUpdate();
			if (filasAfectadas > 0) {
				System.out.println("SIIIIIIIIIIIIIIIIIIIIIII");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
