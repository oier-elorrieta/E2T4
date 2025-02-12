package ModeloDAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;


import ModeloPOJOS.*;


public class ZerbitzuaDAO {
	private static final String URL = "jdbc:mysql://localhost:3307/db_erronka2";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	
	/*
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
	*/


	public static ArrayList<Zerbitzua> zerbitzuKargatu(int bidaia_id) {
		String sql = "SELECT zerbitzua.zerbitzua_id, zerbitzua.bidaia_id, zerbitzua.zerbitzu_mota, "
				+ "ostatu.izena, ostatu.logela_mota_kod, ostatu.hiria, ostatu.prezioa, ostatu.hasiera_data, ostatu.amaiera_data, "
				+ "hegaldia.zerbitzua_id, hegaldia.hegaldi_izena, hegaldia.hegaldi_kod, hegaldia.ordua, hegaldia.hasiera_data, hegaldia.iraupena, hegaldia.prezioa, hegaldia.iata_kod_jatorri, hegaldia.iata_kod_helmuga, hegaldia.airelinea_kod, "
				+ "joan_etorria.zerbitzua_id, joan_etorria.hegaldi_kod, joan_etorria.ordua, joan_etorria.hasiera_data, joan_etorria.iraupena, joan_etorria.prezioa, joan_etorria.airelinea_kod, "
				+ "beste_batzuk.izena, beste_batzuk.data, beste_batzuk.desk, beste_batzuk.prezioa "
				+ "FROM zerbitzua "
				+ "LEFT JOIN ostatu ON zerbitzua.zerbitzua_id = ostatu.zerbitzua_id "
				+ "LEFT JOIN hegaldia ON zerbitzua.zerbitzua_id = hegaldia.zerbitzua_id "
				+ "LEFT JOIN joan_etorria ON zerbitzua.zerbitzua_id = joan_etorria.zerbitzua_id "
				+ "LEFT JOIN beste_batzuk ON zerbitzua.zerbitzua_id = beste_batzuk.zerbitzua_id;";
		ArrayList<Zerbitzua> zerbitzuak = new ArrayList<Zerbitzua>();
		try {
			Connection zerbitzuKonexioa = DriverManager.getConnection(URL, USER, PASSWORD);//ZerbitzuaDAO.konexioa();
			Statement stmt = zerbitzuKonexioa.createStatement();
			ResultSet rs = stmt.executeQuery(sql);


			while (rs.next()) {
				if(rs.getInt("zerbitzua.bidaia_id") == bidaia_id) {
					if("hegaldia".equalsIgnoreCase(rs.getString("zerbitzua.zerbitzu_mota"))) {
						Zerbitzua zerbitzua = new Zerbitzua(rs.getInt("zerbitzua.bidaia_id"), rs.getInt("zerbitzua.zerbitzua_id"), rs.getInt("hegaldia.hegaldi_kod"), rs.getString("hegaldia.hegaldi_izena"), rs.getTime("hegaldia.ordua"), rs.getDate("hegaldia.hasiera_data"), rs.getInt("hegaldia.iraupena"), rs.getDouble("hegaldia.prezioa"), rs.getString("hegaldia.iata_kod_jatorri"), rs.getString("hegaldia.iata_kod_helmuga"), rs.getString("hegaldia.airelinea_kod"));
						zerbitzuak.add(zerbitzua);
						if(rs.getInt("joan_etorria.zerbitzua_id") == rs.getInt("hegaldia.zerbitzua_id")) {
							Zerbitzua sub_zerbitzua = new Zerbitzua(rs.getInt("zerbitzua.bidaia_id"), rs.getInt("joan_etorria.zerbitzu_id"), rs.getInt("joan_etorria.hegaldi_kod"), rs.getDate("joan_etorria.hasiera_data"), rs.getString("joan_etorria.airelinea_kod"), rs.getDouble("joan_etorria.prezioa"), rs.getTime("joan_etorria.ordua"), rs.getInt("joan_etorria.iraupena"));
							zerbitzuak.add(sub_zerbitzua);
						}
					}else if("ostatua".equalsIgnoreCase(rs.getString("zerbitzua.zerbitzu_mota"))) {
						Zerbitzua zerbitzua = new Zerbitzua(rs.getInt("zerbitzua.bidaia_id"), rs.getInt("zerbitzua.zerbitzua_id"), rs.getString("ostatu.izena"), rs.getString("ostatu.logela_mota_kod"), rs.getString("ostatu.hiria"), rs.getDate("ostatu.hasiera_data"), rs.getDate("ostatu.amaiera_data"), rs.getDouble("ostatu.prezioa"));
						zerbitzuak.add(zerbitzua);
					}else if("jarduera".equalsIgnoreCase(rs.getString("zerbitzua.zerbitzu_id"))) {
						Zerbitzua zerbitzua = new Zerbitzua(rs.getInt("zerbitzua.bidaia_id"), rs.getInt("zerbitzua.zerbitzua_id"), rs.getString("beste_batzuk.izena"), rs.getString("beste_batzuk.desk"), rs.getDate("beste_batzuk.data"), rs.getDouble("beste_batzuk.prezioa"));
						zerbitzuak.add(zerbitzua);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(zerbitzuak.toString());
		return zerbitzuak;
	}
	
	public static void zerbitzuEzabatu(int zerbitzua_id) {
		String sql = "DELETE FROM zerbitzua WHERE zerbitzua_id = ?";

		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, zerbitzua_id);
			int filasAfectadas = stmt.executeUpdate();
			if(filasAfectadas > 0) {
				System.out.println("SIIIIIIIIIIIIIIIIIIIIIII");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void zerbitzuEzabatuGuztiak(int zerbitzua_id) {
		String sql = "DELETE FROM zerbitzua WHERE bidaia_id = ?";

		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, zerbitzua_id);
			int filasAfectadas = stmt.executeUpdate();
			if(filasAfectadas > 0) {
				System.out.println("SIIIIIIIIIIIIIIIIIIIIIII");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
