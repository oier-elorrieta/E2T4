package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import ModeloDAO.AgentziaDAO;
import ModeloDAO.BidaiaDAO;
import ModeloPOJOS.*;

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

public class LoginPantaila extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textAgentzia;
	private JTextField textPasahitza;
	static boolean vuelta = true;
	private static JPanel Login = new JPanel();
	private static JPanel background = new JPanel();
	private static JPanel OngiEtorri = new JPanel();
	//private static Connection conexioa = AgentziaDAO.konexioa();
	private static AgentziaBerria agentziaBerriaPanel = new AgentziaBerria();
	
	/**
	 * Launch the application.
	 * @param zerrendaAgentziak 
	 */
	public synchronized static void pantLogin(ArrayList<Agentzia> zerrendaAgentziak, ArrayList<Bidaia> zerrendaBidaiak) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPantaila frame = new LoginPantaila(zerrendaAgentziak, zerrendaBidaiak);
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
	public LoginPantaila(ArrayList<Agentzia> zerrendaAgenetziak, ArrayList<Bidaia> zerrendaBidaiak) {
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
				
				for(int i=0; i<zerrendaAgenetziak.size(); i++) { //Recorre el arrayList de agencias, y si el usuario y la contraseña son correctos, carga los viajes de la agencia y pasa a la siguiente pantalla.
					Agentzia agentzia = zerrendaAgenetziak.get(i); //Esto es para ir cogiendo cada agencia del array.
					if(erabiltzailea.equalsIgnoreCase(agentzia.getErabiltzailea()) && pasahitza.equalsIgnoreCase(agentzia.getPasahitza())) {
						JOptionPane.showMessageDialog(null, "Sartu zara");
						int agen_id = agentzia.getAgentzia_id();
						dispose();
						agentzia.setBidaiak(BidaiaDAO.bidaiaKargatu(agentzia.getBidaiak(), agentzia.getAgentzia_id())); // Le asigna a la agencia los bidaiak cargando solo los viajes de esa agencia
						HegaldiPantaila.pantViajes(agentzia.getBidaiak(), agen_id); // Llama a la siguiente pantalla y le pasa los viajes.
					}
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
