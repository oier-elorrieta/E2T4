package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ModeloDAO.AgentziaDAO;
import ModeloDAO.Agentzia_motaDAO;

public class AgentziaBerria extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField nomAgenTxt;
	private JTextField codColor;
	private JTextField logoUrl;
	static boolean vuelta = true;
	private JTextField passAgenTxt1;
	private JTextField passAgenTxt2;

	public AgentziaBerria() {
		ArrayList<String> agenMotak = new ArrayList<String>();
		String[] array = agenMotak.toArray(new String[0]);
		setBounds(100, 100, 761, 488);
		setLayout(null);
		setBackground(new Color(128, 128, 128));

		// Nombre Agencia
		JLabel nomAgen = new JLabel("Agentzia Izena");
		nomAgen.setBounds(86, 47, 126, 21);
		add(nomAgen);

		nomAgenTxt = new JTextField();
		nomAgenTxt.setBounds(244, 47, 163, 20);
		add(nomAgenTxt);
		nomAgenTxt.setColumns(10);

		// Color de marca
		JLabel colorLb = new JLabel("Color de marca");
		colorLb.setBounds(86, 111, 126, 21);
		add(colorLb);

		codColor = new JTextField();
		codColor.setFont(new Font("Tahoma", Font.PLAIN, 17));
		codColor.setColumns(10);
		codColor.setBounds(244, 111, 111, 20);
		add(codColor);

		JTextField colorPreview = new JTextField("");
		colorPreview.setEditable(false);
		colorPreview.setEnabled(false);
		colorPreview.setBackground(new Color(255, 255, 255));
		colorPreview.setBounds(381, 111, 58, 21);
		add(colorPreview);

		JButton selectColorButton = new JButton("Kolorea Aukeratu");
		selectColorButton.setBounds(450, 111, 150, 23);
		add(selectColorButton);

		// Número de empleados
		JLabel numEmpLb = new JLabel("Numero de empleados");
		numEmpLb.setBounds(86, 164, 126, 21);
		add(numEmpLb);

		JComboBox<String> numEmp = new JComboBox();
		numEmp.setBounds(244, 163, 133, 22);
		add(numEmp);
		// For y metodo para añadir número de empleados
		ArrayList<String> langile_kopuru = new ArrayList<>();
		langile_kopuru = Agentzia_motaDAO.langile_kopuruKargatu();
		for(int i = 0;i<langile_kopuru.size();i++) {
			numEmp.addItem(langile_kopuru.get(i));
		}

		// Tipo de agencia
		JLabel agenMotaLb = new JLabel("Agentzia mota");
		agenMotaLb.setBounds(86, 215, 126, 21);
		add(agenMotaLb);
		// For y metodo para añadir tipos de agnecias
		JComboBox<String> agenMota = new JComboBox();
		agenMota.setBounds(244, 214, 133, 22);
		add(agenMota);
		ArrayList<String> agentzia_motak = new ArrayList<>();
		agentzia_motak = Agentzia_motaDAO.agentzia_motaKargatu();
		for(int i=0; i<agentzia_motak.size(); i++) {
			agenMota.addItem(agentzia_motak.get(i));
		}
		
		// Logo
		JLabel logoLb = new JLabel("Logo");
		logoLb.setBounds(86, 269, 126, 21);
		add(logoLb);

		logoUrl = new JTextField();
		logoUrl.setColumns(10);
		logoUrl.setBounds(244, 269, 356, 20);
		add(logoUrl);

		// Botón Guardar
		JButton gordeBt = new JButton("Gorde");
		gordeBt.setBounds(123, 351, 89, 23);
		add(gordeBt);

		// Botón Cancelar
		JButton kantzelatuBt = new JButton("Kantzelatu");
		kantzelatuBt.setBounds(373, 351, 89, 23);
		add(kantzelatuBt);
		
		JLabel passAgen1 = new JLabel("Pasahitza");
		passAgen1.setBounds(417, 47, 69, 21);
		add(passAgen1);
		
		passAgenTxt1 = new JTextField();
		passAgenTxt1.setColumns(10);
		passAgenTxt1.setBounds(487, 47, 163, 20);
		add(passAgenTxt1);
		
		JLabel passAgen2 = new JLabel("Pasahitza berridatzi");
		passAgen2.setBounds(381, 79, 105, 21);
		add(passAgen2);
		
		passAgenTxt2 = new JTextField();
		passAgenTxt2.setColumns(10);
		passAgenTxt2.setBounds(487, 79, 163, 20);
		add(passAgenTxt2);
		
		
		/*
		// Listeners de botones
		try {
			String sql = "SELECT desk FROM agentzia_mota";
			Statement stmt = conexioa.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String mota = rs.getString("desk");
				agenMotak.add(mota);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		*/
		
		kantzelatuBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				nomAgenTxt.setText("");
				codColor.setText("FFFFFF");
				numEmp.setSelectedIndex(0);
				logoUrl.setText("");
				LoginPantaila.bueltatu();
			}
		});

		gordeBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica para guardar la agencia
				String iAgen = nomAgenTxt.getText();
				String passAgen1 = passAgenTxt1.getText();
				String passAgen2 = passAgenTxt2.getText();
				String colore = "#" + codColor.getText();
				String empKop = (String) numEmp.getSelectedItem();
				String mota = (String) agenMota.getSelectedItem();
				String logo = logoUrl.getText();
				if(iAgen.equals("") || passAgen1.equals("") || passAgen2.equals("") || colore.equals("#") || numEmp.equals("")  || mota.equals("") || logo.equals("") ) {
					JOptionPane.showMessageDialog(null, "Mesedez sartu informazio guztia");
				} else  if(passAgen1.equals(passAgen2)){
					AgentziaDAO.agentziaSartu(iAgen, passAgen1, empKop, mota, colore, logo);
					JOptionPane.showMessageDialog(null, "Agentzia sortu da!");
				}
			}
		});

		selectColorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color color = javax.swing.JColorChooser.showDialog(null, "Elige un color", Color.WHITE);
				if (color != null) {
					String hex = String.format("%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue())
							.toUpperCase();
					codColor.setText(hex);
					colorPreview.setBackground(color);
				}
			}
		});
	}

	public static boolean checkVuelta() {
		return vuelta;
	}
}
