package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import Modelo.Agentzia;

public class LoginPantaila extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textAgentzia;
	private JTextField textPasahitza;
	static boolean vuelta = true;
	private static JPanel Login = new JPanel();
	private static JPanel background = new JPanel();
	private static JPanel OngiEtorri = new JPanel();
	private static AgentziaBerria agentziaBerriaPanel = new AgentziaBerria();

	/**
	 * Launch the application.
	 * @param listaAgencias 
	 */
	public synchronized static void pantLogin(ArrayList<Agentzia> listaAgencias) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPantaila frame = new LoginPantaila(listaAgencias);
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginPantaila(ArrayList<Agentzia> listaAgencias) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 761, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		background.setBackground(new Color(192, 192, 192));
		background.setBounds(0, 0, 745, 449);
		contentPane.add(background);
		background.setLayout(null);
		
		
		OngiEtorri.setBounds(0, 156, 745, 136);
		background.add(OngiEtorri);
		OngiEtorri.setLayout(null);
		
		JButton btnOngiEtorri = new JButton("Ongi Etorri");
		btnOngiEtorri.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnOngiEtorri.setBounds(290, 36, 165, 64);
		OngiEtorri.add(btnOngiEtorri);
		
		
		Login.setLayout(null);
		Login.setBounds(0, 156, 745, 136);
		background.add(Login);
		
		JLabel lblAgencia = new JLabel("Nombre agencia");
		lblAgencia.setBounds(234, 22, 88, 20);
		Login.add(lblAgencia);
		
		textAgentzia = new JTextField();
		textAgentzia.setBounds(332, 22, 154, 20);
		Login.add(textAgentzia);
		textAgentzia.setColumns(10);
		
		textPasahitza = new JPasswordField();
		textPasahitza.setColumns(10);
		textPasahitza.setBounds(332, 63, 154, 20);
		Login.add(textPasahitza);
		
		JLabel lblPasahitza = new JLabel("Contraseña");
		lblPasahitza.setBounds(234, 66, 88, 20);
		Login.add(lblPasahitza);
		
		JButton btnHasiSaioa = new JButton("Iniciar sesion");
		btnHasiSaioa.setBounds(213, 102, 110, 23);
		Login.add(btnHasiSaioa);
		
		JButton btnAgentziaBerria = new JButton("Nueva agencia");
		btnAgentziaBerria.setBounds(397, 102, 110, 23);
		Login.add(btnAgentziaBerria);
		
	    agentziaBerriaPanel.setBounds(0, 0, 745, 449);
	    contentPane.add(agentziaBerriaPanel);
	    agentziaBerriaPanel.setVisible(false);
		
		btnAgentziaBerria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.setVisible(false);
			    background.setVisible(false);
			    OngiEtorri.setVisible(false);
			    agentziaBerriaPanel.setVisible(true);	
			}
		});
		
		
		btnOngiEtorri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OngiEtorri.setVisible(false);
				Login.setVisible(true);
			}
		});
		Login.setVisible(false);
		
		btnHasiSaioa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String erabiltzailea = textAgentzia.getText();
				String pasahitza = textPasahitza.getText();
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					
					Connection conexioa = DriverManager.getConnection("jdbc:mysql://localhost:3307/db_erronka2", "root", "");
					
					Statement sentencia = conexioa.createStatement();
					String sql = "SELECT DISTINCT erabiltzailea, pasahitza FROM agentzia";
					ResultSet resul = sentencia.executeQuery(sql);
					
					while(resul.next()) {
						if(erabiltzailea.equals(resul.getString(1)) && pasahitza.equals(resul.getString(2))) {
							JOptionPane.showMessageDialog(null, "Sartu zara");
							dispose();
							vuelta = false;
							HegaldiPantaila.pantViajes(conexioa);
						}
					}
					
					resul.close();
					sentencia.close();
					//conexioa.close();
				}catch(ClassNotFoundException cn){
					cn.printStackTrace();
				}catch(SQLException s) {
					s.printStackTrace();
				}
			}
		});
	}
	
	public static boolean checkVuelta() {
		return vuelta;
	}
	
	public static void bueltatu() {
		Login.setVisible(true);
	    background.setVisible(true);
	    agentziaBerriaPanel.setVisible(false);
	}
}
