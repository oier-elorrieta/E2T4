package ModeloDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

import Modelo.Zerbitzua;

public class ZerbitzuaDAO {
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

	public static void zerbitzuKargatu(int bidaia_id, ArrayList<Zerbitzua> zerbitzuak) {
		String sql = "SELECT Zerbitzua.zerbitzua_id, Zerbitzua.bidaia_id,"
				+ " Hegaldia.hegaldi_id, Hegaldia.hegaldiIzen, Hegaldia.hegaldiMota, Hegaldia.ordua, Hegaldia.hasiera_data,"
				+ " Hegaldia.iraupena, Hegaldia.prezioa, Hegaldia.iata_kod_jatorri, Hegaldia.iata_kod_helmuga, Hegaldia.airelinea_kod,"
				+ " joan_etorria.hegaldia_kod, joan_etorria.ordua, joan_etorria.hasiera_data, joan_etorria.iraupena,"
				+ " joan_etorria.prezioa, joan_etorria.airelinea_kod,"
				+ " Ostatu.ostatu_id, Ostatu.izena, Ostatu.hiria, Ostatu.prezioa, Ostatu.hasiera_data, Ostatu.amaitu_data,"
				+ " Ostatu.logela_mota_kod,"
				+ " beste_batzuk.bb_id, beste_batzuk.izena, beste_batzuk.desk, beste_batzuk.data, beste_batzuk.prezioa"
				+ " FROM Zerbitzua" + " LEFT JOIN Hegaldia ON Zerbitzua.zerbitzua_id = Hegaldia.zerbitzua_id"
				+ " LEFT JOIN joan_etorria ON Zerbitzua.zerbitzua_id = joan_etorria.zerbitzua_id"
				+ " LEFT JOIN Ostatu ON Zerbitzua.zerbitzua_id = Ostatu.zerbitzua_id"
				+ " LEFT JOIN beste_batzuk ON Zerbitzua.zerbitzua_id = beste_batzuk.zerbitzua_id";

		try {
			Connection zerbitzuKonexioa = AgentziaDAO.konexioa();
			Statement stmt = zerbitzuKonexioa.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Zerbitzua zerbitzua = null;

				if (rs.getInt("hegaldi_id") != 0) {
					if (rs.getString("hegaldiMota").equalsIgnoreCase("joan")) {
						zerbitzua = new Zerbitzua(rs.getInt("bidaia_id"), rs.getInt("zerbitzua_id"), rs.getInt("hegaldi_id"), rs.getString("Hegaldia.hegaldiIzen"), rs.getString("Hegaldia.hegaldiMota"), rs.getString("Hegaldia.iata_kod_jatorri"), rs.getString("Hegaldia.iata_kod_helmuga"), rs.getDate("Hegaldia.hasiera_data"), rs.getString("Hegaldia.airelinea_kod"), rs.getTime("Hegaldia.ordua"), rs.getInt("Hegaldia.iraupena"), rs.getDouble("Hegaldia.prezioa"));
					} else {
						zerbitzua = new Zerbitzua(rs.getInt("bidaia_id"), rs.getInt("zerbitzua_id"), rs.getInt("hegaldi_id"), rs.getString("Hegaldia.hegaldiIzen"), rs.getString("Hegaldia.hegaldiMota"), rs.getString("Hegaldia.iata_kod_jatorri"), rs.getString("Hegaldia.iata_kod_helmuga"), rs.getDate("Hegaldia.hasiera_data"), rs.getString("Hegaldia.airelinea_kod"), rs.getTime("Hegaldia.ordua"), rs.getInt("Hegaldia.iraupena"), rs.getDate("joan_etorria.hasiera_data"), rs.getString("joan_etorria.hegaldia_kod"), rs.getString("joan_etorria.airelinea_kod"), rs.getDouble("joan_etorria.prezioa"), rs.getTime("joan_etorria.ordua"), rs.getInt("joan_etorria.iraupena"));
					}
				} else if (rs.getInt("ostatua_id") != 0) {
					zerbitzua = new Zerbitzua(rs.getInt("bidaia_id"), rs.getInt("zerbitzua_id"), rs.getInt("ostatua_id"), rs.getString("Ostatu.izena"), rs.getString("Ostatu.logela_mota_kod"), rs.getString("Ostatu.hiria"), rs.getDate("Ostatu.hasiera_data"), rs.getDate("Ostatu.amaitu_data"), rs.getDouble("Ostatu.prezioa"));
				} else if (rs.getInt("bb_id") != 0) {
					zerbitzua = new Zerbitzua(rs.getInt("bidaia_id"), rs.getInt("zerbitzua_id"), rs.getInt("bb_id"), rs.getString("beste_batzuk.izena"), rs.getString("beste_batzuk.desk"), rs.getDate("beste_batzuk.data"), rs.getDouble("beste_batzuk.prezioa"));
				}

				zerbitzuak.add(zerbitzua);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
