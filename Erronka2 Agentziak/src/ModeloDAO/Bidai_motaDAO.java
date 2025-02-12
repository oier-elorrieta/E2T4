package ModeloDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Bidai_motaDAO {
	private static final String URL = "jdbc:mysql://localhost:3307/db_erronka2";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	
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
}
