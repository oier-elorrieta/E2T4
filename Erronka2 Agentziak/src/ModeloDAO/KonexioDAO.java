package ModeloDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KonexioDAO {
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
}
