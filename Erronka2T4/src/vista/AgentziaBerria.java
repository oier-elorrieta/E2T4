package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AgentziaBerria extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField nomAgenTxt;
	private JTextField codColor;
	private JTextField logoUrl;
	static boolean vuelta = true;

	public AgentziaBerria() {
		setBounds(100, 100, 761, 488);
		setLayout(null);
		setBackground(new Color(128, 128, 128));

		// Nombre Agencia
		JLabel nomAgen = new JLabel("Nombre Agencia");
		nomAgen.setBounds(86, 57, 126, 21);
		add(nomAgen);

		nomAgenTxt = new JTextField();
		nomAgenTxt.setBounds(244, 57, 163, 20);
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

		JComboBox numEmp = new JComboBox();
		numEmp.setModel(new DefaultComboBoxModel(
				new String[] { "", "2 eta 10 artean", "10 eta 100 artean", "100 eta 1000 artean" }));
		numEmp.setBounds(244, 163, 133, 22);
		add(numEmp);

		// Tipo de agencia
		JLabel agenMotaLb = new JLabel("Agentzia mota");
		agenMotaLb.setBounds(86, 215, 126, 21);
		add(agenMotaLb);

		JComboBox agenMota = new JComboBox();
		agenMota.setModel(new DefaultComboBoxModel(new String[] { "Bidai agentzia" }));
		agenMota.setBounds(244, 214, 133, 22);
		add(agenMota);

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
		

		// Listeners de botones
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
				String iAgen = nomAgenTxt.getText();
				String colore = codColor.getText();
				String empKop = Integer.toString(numEmp.getSelectedIndex());
				String logo = logoUrl.getText();
				// Lógica para guardar la agencia
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
