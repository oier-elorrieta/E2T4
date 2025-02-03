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
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import Modelo.Agentzia;

public class LoginPantaila extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField agenTxt;
	private JTextField conTxt;
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
		
		JButton OngiEtorriBT = new JButton("Ongi Etorri");
		OngiEtorriBT.setFont(new Font("Tahoma", Font.PLAIN, 22));
		OngiEtorriBT.setBounds(290, 36, 165, 64);
		OngiEtorri.add(OngiEtorriBT);
		
		
		Login.setLayout(null);
		Login.setBounds(0, 156, 745, 136);
		background.add(Login);
		
		JLabel agenciaLB = new JLabel("Nombre agencia");
		agenciaLB.setBounds(234, 22, 88, 20);
		Login.add(agenciaLB);
		
		agenTxt = new JTextField();
		agenTxt.setBounds(332, 22, 154, 20);
		Login.add(agenTxt);
		agenTxt.setColumns(10);
		
		conTxt = new JPasswordField();
		conTxt.setColumns(10);
		conTxt.setBounds(332, 63, 154, 20);
		Login.add(conTxt);
		
		JLabel contraseñaLB = new JLabel("Contraseña");
		contraseñaLB.setBounds(234, 66, 88, 20);
		Login.add(contraseñaLB);
		
		JButton inicSesion = new JButton("Iniciar sesion");
		inicSesion.setBounds(213, 102, 110, 23);
		Login.add(inicSesion);
		
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
		
		
		OngiEtorriBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OngiEtorri.setVisible(false);
				Login.setVisible(true);
			}
		});
		Login.setVisible(false);
		
		inicSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean user = false;
				boolean cont = false;
				for (int i = 0;i<listaAgencias.size();i++) {
					String a = listaAgencias.get(i).getNombreAgencia();
					String b = agenTxt.getText();
					if(b.equals(a)) {
						user = true;
					}
				}
				String c = conTxt.getText();
				if (c.equals("admin")) {
					cont = true;
				}
				if (cont == true && user == true) {
					JOptionPane.showMessageDialog(null, "Sartu zara");
					dispose();
					vuelta = false;
					return;
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
