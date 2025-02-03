package controlador;
import java.util.ArrayList;

import java.sql.*;
import Modelo.Agentzia;
import Modelo.Bidaia;

public class Metodos {
	public static void añadirAgencias(ArrayList<Agentzia> listaAgencias) {
		ArrayList<Bidaia> bidaiakA1 = new ArrayList<>();
		ArrayList<Bidaia> bidaiakA2 = new ArrayList<>();
		ArrayList<Bidaia> bidaiakA3 = new ArrayList<>();
		
		Agentzia agencia1 = new Agentzia("admin", "ff12345", "50", "https://example.com/logo1.png", bidaiakA1);
        listaAgencias.add(agencia1);
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	
        	Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/db_erronka2", "root", "");
        	
        	Statement sentencia = conexion.createStatement();
        	String sql = "";
        	ResultSet resul = sentencia.executeQuery(sql);
        	
        	while(resul.next()) {
        		
        	}
        	
        	
        }catch(ClassNotFoundException cn) {
        	
        }catch(SQLException e) {
        	
        }
	}
	
	public static void nuevaAgencia(String nomAgen, String colorAgen, String trabajadores, String logoUrl) {
		
	}
}
