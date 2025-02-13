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
import vista.LoginPantaila;

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
	}
	
	public static String bidai_mota_kodAtera(String mota) {
		String sql = "SELECT bidai_mota_kod FROM bidai_mota WHERE desk = " + "'" + mota + "'";
		String motaKod = "";
		try {
			Connection conn = KonexioDAO.konexioa();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				motaKod = rs.getString("bidai_mota_kod");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return motaKod;
	}
	
	public static ArrayList<String> bidai_motaKargatu() {
		String sql = "SELECT * FROM bidai_mota";
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
	
	
	//INSERTER
	
	public static void bidaiaSartu(String bidaiIzena, String bidaiMota, Date bidaiHasi, Date bidaiAmaiera, String bidaiIraupen, String bidaiHerri, String bidaiDesk, String textSGZerbitzu) {
		String sql = "INSERT INTO bidaia (izena, Desk, hasiera_data, amaiera_data, agentzia_id, herrialde_kod, bidai_mota_kod)" + "VALUES (?, ?, ?, ?, ?, ?, ?)";
		int agen_id = LoginPantaila.agentziaId();
		try {
			Connection conn = KonexioDAO.konexioa();
			PreparedStatement stmt = conn.prepareStatement(sql);
			String herriKod = HerrialdeaDAO.herrialde_kodAtera(bidaiHerri);
			String motaKod = BidaiaDAO.bidai_mota_kodAtera(bidaiMota);
			stmt.setString(1, bidaiIzena);
			stmt.setString(2, bidaiDesk);
			java.util.Date bidaiH = new java.util.Date(); //Conversor "correcto" de date de Java a date de MySQL ft. ChatGPT :)
			java.sql.Date bidaiHsql = new java.sql.Date(bidaiH.getTime());
			stmt.setDate(3, bidaiHsql);
			java.util.Date bidaiA = new java.util.Date(); //Mismo conversor
			java.sql.Date bidaiAsql = new java.sql.Date(bidaiA.getTime());
			stmt.setDate(4, bidaiAsql);
			stmt.setInt(5, agen_id);
			stmt.setString(6, herriKod);
			stmt.setString(7, motaKod);
			if (stmt.executeUpdate() > 0) {
                System.out.println("AAAA");
            } else {
                System.out.println("NOOO");
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
