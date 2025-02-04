package vista;

import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;

import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import Modelo.Aireportua;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.CardLayout;

public class EkitaldiBerria2 extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textIzena;
	private JComboBox<String> comboMota;
	private JPanel cardsPanel; // Panel que contendrá las "cards" (secciones)
	private CardLayout cardLayout;

	public EkitaldiBerria2() {
		setBounds(0, 0, 748, 584);
		setLayout(null);

		JLabel lblIzena = new JLabel("Ekitaldi izena");
		lblIzena.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIzena.setBounds(90, 40, 100, 25);
		add(lblIzena);

		textIzena = new JTextField();
		textIzena.setBounds(190, 40, 150, 25);
		add(textIzena);
		textIzena.setColumns(10);

		JLabel lblMota = new JLabel("Ekitaldi mota");
		lblMota.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMota.setBounds(90, 80, 100, 25);
		add(lblMota);

		comboMota = new JComboBox<>();
		comboMota.setBounds(190, 80, 150, 25);
		comboMota.addItem("");
		comboMota.addItem("Hegaldia");
		comboMota.addItem("Ostatua");
		comboMota.addItem("Jarduera");
		add(comboMota);

		// Crear el contenedor con CardLayout
		cardsPanel = new JPanel();
		cardLayout = new CardLayout();
		cardsPanel.setLayout(cardLayout);
		cardsPanel.setBounds(0, 120, 748, 464); // Definir área para el panel de cards
		add(cardsPanel);

		// Crear paneles para cada tipo de evento
		JPanel hegaldiPanel = createHegaldiaPanel();
		JPanel ostatuaPanel = createOstatuaPanel();
		JPanel jardueraPanel = createJardueraPanel();

		// Añadir los paneles al CardLayout
		cardsPanel.add(hegaldiPanel, "Hegaldia");
		cardsPanel.add(ostatuaPanel, "Ostatua");
		cardsPanel.add(jardueraPanel, "Jarduera");

		comboMota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String aukera = (String) comboMota.getSelectedItem();
				cardLayout.show(cardsPanel, aukera); // Cambiar al panel correspondiente
			}
		});

		JButton btnAtzera = new JButton("<-");
		btnAtzera.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAtzera.setBounds(20, 20, 25, 25);
		add(btnAtzera);
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HegaldiPantaila.bueltatu();
			}
		});
	}

	// Método para crear el panel de Hegaldia
	private JPanel createHegaldiaPanel() {
		JPanel hegaldiPanel = new JPanel();
		hegaldiPanel.setLayout(null);

		JLabel lblBidaiMota = new JLabel("Bidaia Mota");
		lblBidaiMota.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBidaiMota.setBounds(90, 10, 100, 25);
		hegaldiPanel.add(lblBidaiMota);

		JComboBox<String> comboBidaiMota = new JComboBox<>();
		comboBidaiMota.setBounds(190, 10, 150, 25);
		comboBidaiMota.addItem("");
		comboBidaiMota.addItem("Joan");
		comboBidaiMota.addItem("Joan/Etorri");
		hegaldiPanel.add(comboBidaiMota);
		
		JPanel hegaldiMotaPanel = new JPanel();
		hegaldiMotaPanel.setBounds(0, 34, 748, 430);
		hegaldiMotaPanel.setLayout(null);
		hegaldiPanel.add(hegaldiMotaPanel);

		comboBidaiMota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bidaiMota = (String) comboBidaiMota.getSelectedItem();
				aldatuBidaia(hegaldiMotaPanel, bidaiMota);
			}
		});

		return hegaldiPanel;
	}

	// Método para crear el panel de Ostatua
	private JPanel createOstatuaPanel() {
		JPanel ostatuPanel = new JPanel();
		ostatuPanel.setLayout(null);

		JLabel lblLogelaMota = new JLabel("Logela Mota");
		lblLogelaMota.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLogelaMota.setBounds(90, 10, 100, 25);
		ostatuPanel.add(lblLogelaMota);

		JComboBox<String> comboLogelaMota = new JComboBox<>();
		comboLogelaMota.setBounds(190, 10, 150, 25);
		comboLogelaMota.addItem("Banakakoa");
		comboLogelaMota.addItem("Bikoitza");
		comboLogelaMota.addItem("Hirukoitza");
		ostatuPanel.add(comboLogelaMota);

		JLabel lblHiria = new JLabel("Hiria");
		lblHiria.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHiria.setBounds(90, 50, 100, 25);
		ostatuPanel.add(lblHiria);

		JTextField textHiria = new JTextField();
		textHiria.setBounds(190, 50, 150, 25);
		ostatuPanel.add(textHiria);

		JLabel lblPrezioa = new JLabel("Prezioa");
		lblPrezioa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrezioa.setBounds(90, 90, 100, 25);
		ostatuPanel.add(lblPrezioa);

		JTextField textPrezioa = new JTextField();
		textPrezioa.setBounds(190, 90, 150, 25);
		ostatuPanel.add(textPrezioa);

		JLabel lblSarreraData = new JLabel("Sarrera data");
		lblSarreraData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSarreraData.setBounds(90, 130, 100, 25);
		ostatuPanel.add(lblSarreraData);

		Date data1 = (Date) Date.valueOf(LocalDate.now());
		SpinnerDateModel model1 = new SpinnerDateModel(data1, null, null, java.util.Calendar.DAY_OF_MONTH);
		JSpinner spinner1 = new JSpinner(model1);
		JSpinner.DateEditor editor1 = new JSpinner.DateEditor(spinner1, "dd/MM/yyyy");
		spinner1.setEditor(editor1);
		spinner1.setBounds(190, 130, 150, 25);
		ostatuPanel.add(spinner1);

		JLabel lblIrteeraData = new JLabel("Irteera data");
		lblIrteeraData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIrteeraData.setBounds(350, 130, 100, 25);
		ostatuPanel.add(lblIrteeraData);

		Date data2 = (Date) Date.valueOf(LocalDate.now());
		SpinnerDateModel model2 = new SpinnerDateModel(data2, null, null, java.util.Calendar.DAY_OF_MONTH);
		JSpinner spinner2 = new JSpinner(model2);
		JSpinner.DateEditor editor2 = new JSpinner.DateEditor(spinner2, "dd/MM/yyyy");
		spinner2.setEditor(editor2);
		spinner2.setBounds(450, 130, 150, 25);
		ostatuPanel.add(spinner2);

		return ostatuPanel;
	}

	// Método para crear el panel de Jarduera
	private JPanel createJardueraPanel() {
		JPanel jardueraPanel = new JPanel();
		jardueraPanel.setLayout(null);

		JLabel lblDeskripzioa = new JLabel("Deskipzioa");
		lblDeskripzioa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDeskripzioa.setBounds(90, 50, 100, 25);
		jardueraPanel.add(lblDeskripzioa);

		JTextField textDeskripzioa = new JTextField();
		textDeskripzioa.setBounds(190, 10, 300, 100);
		jardueraPanel.add(textDeskripzioa);

		JLabel lblPrezioa = new JLabel("Prezioa");
		lblPrezioa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrezioa.setBounds(90, 130, 100, 25);
		jardueraPanel.add(lblPrezioa);

		JTextField textPrezioa = new JTextField();
		textPrezioa.setBounds(190, 130, 150, 25);
		jardueraPanel.add(textPrezioa);

		JLabel lblData = new JLabel("Data");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblData.setBounds(90, 170, 100, 25);
		jardueraPanel.add(lblData);

		Date data1 = (Date) Date.valueOf(LocalDate.now());
		SpinnerDateModel model1 = new SpinnerDateModel(data1, null, null, java.util.Calendar.DAY_OF_MONTH);
		JSpinner spinner1 = new JSpinner(model1);
		JSpinner.DateEditor editor1 = new JSpinner.DateEditor(spinner1, "dd/MM/yyyy");
		spinner1.setEditor(editor1);
		spinner1.setBounds(190, 170, 150, 25);
		jardueraPanel.add(spinner1);

		return jardueraPanel;
	}

	// Método para actualizar el panel de Hegaldia según el tipo de viaje
	private void aldatuBidaia(JPanel hegaldiMotaPanel, String bidaiMota) {
		hegaldiMotaPanel.removeAll();
		if (bidaiMota.equals("Joan")) {
			JLabel lblJatorriAireportu = new JLabel("Jatorrizko aireportua");
			lblJatorriAireportu.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblJatorriAireportu.setBounds(90, 30, 150, 25);
			hegaldiMotaPanel.add(lblJatorriAireportu);

			JComboBox<Aireportua> aireportuJatorri = new JComboBox<Aireportua>();
			aireportuJatorri.setBounds(240, 30, 150, 25);
			hegaldiMotaPanel.add(aireportuJatorri);

			JLabel lblHelmugaAireportu = new JLabel("Helmugako aireportua");
			lblHelmugaAireportu.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblHelmugaAireportu.setBounds(400, 30, 150, 25);
			hegaldiMotaPanel.add(lblHelmugaAireportu);

			JComboBox<Aireportua> aireportuHelmuga = new JComboBox<Aireportua>();
			aireportuHelmuga.setBounds(550, 30, 150, 25);
			hegaldiMotaPanel.add(aireportuHelmuga);

			JButton btnBilatuBidaia = new JButton("Bilatu Bidaia");
			btnBilatuBidaia.setBounds(299, 70, 150, 25);
			hegaldiMotaPanel.add(btnBilatuBidaia);

			JLabel lblJoanData = new JLabel("Joan data");
			lblJoanData.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblJoanData.setBounds(90, 110, 100, 25);
			hegaldiMotaPanel.add(lblJoanData);

			Date data1 = (Date) Date.valueOf(LocalDate.now());
			SpinnerDateModel model1 = new SpinnerDateModel(data1, null, null, java.util.Calendar.DAY_OF_MONTH);
			JSpinner spinner1 = new JSpinner(model1);
			JSpinner.DateEditor editor1 = new JSpinner.DateEditor(spinner1, "dd/MM/yyyy");
			spinner1.setEditor(editor1);
			spinner1.setBounds(190, 110, 150, 25);
			hegaldiMotaPanel.add(spinner1);

			JLabel lblKode1 = new JLabel("Hegaldi kodea");
			lblKode1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblKode1.setBounds(90, 150, 100, 25);
			hegaldiMotaPanel.add(lblKode1);

			JTextField textKode1 = new JTextField();
			textKode1.setBounds(190, 150, 150, 25);
			hegaldiMotaPanel.add(textKode1);

			JLabel lblAirelinea = new JLabel("Airelinea");
			lblAirelinea.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblAirelinea.setBounds(90, 190, 100, 25);
			hegaldiMotaPanel.add(lblAirelinea);

			JTextField textAirelinea = new JTextField();
			textAirelinea.setBounds(190, 190, 150, 25);
			hegaldiMotaPanel.add(textAirelinea);

			JLabel lblOrdua1 = new JLabel("Irteera-ordua");
			lblOrdua1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblOrdua1.setBounds(90, 230, 100, 25);
			hegaldiMotaPanel.add(lblOrdua1);

			SpinnerDateModel ordua1 = new SpinnerDateModel();
			JSpinner spinnerOrdua1 = new JSpinner(ordua1);
			JSpinner.DateEditor editorOrdua1 = new JSpinner.DateEditor(spinnerOrdua1, "HH:mm");
			spinnerOrdua1.setEditor(editorOrdua1);
			spinnerOrdua1.setBounds(190, 230, 150, 25);
			hegaldiMotaPanel.add(spinnerOrdua1);

			JLabel lblIraupena1 = new JLabel("Iraupena");
			lblIraupena1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblIraupena1.setBounds(90, 270, 100, 25);
			hegaldiMotaPanel.add(lblIraupena1);

			JTextField textIraupena1 = new JTextField();
			textIraupena1.setBounds(190, 270, 150, 25);
			hegaldiMotaPanel.add(textIraupena1);
			
		} else if (bidaiMota.equals("Joan/Etorri")) {
			JLabel lblJatorriAireportu = new JLabel("Jatorrizko aireportua");
			lblJatorriAireportu.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblJatorriAireportu.setBounds(90, 30, 150, 25);
			hegaldiMotaPanel.add(lblJatorriAireportu);

			JComboBox<Aireportua> aireportuJatorri = new JComboBox<Aireportua>();
			aireportuJatorri.setBounds(240, 30, 150, 25);
			hegaldiMotaPanel.add(aireportuJatorri);

			JLabel lblHelmugaAireportu = new JLabel("Helmugako aireportua");
			lblHelmugaAireportu.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblHelmugaAireportu.setBounds(400, 30, 150, 25);
			hegaldiMotaPanel.add(lblHelmugaAireportu);

			JComboBox<Aireportua> aireportuHelmuga = new JComboBox<Aireportua>();
			aireportuHelmuga.setBounds(550, 30, 150, 25);
			hegaldiMotaPanel.add(aireportuHelmuga);

			JButton btnBilatuBidaia = new JButton("Bilatu Bidaia");
			btnBilatuBidaia.setBounds(299, 70, 150, 25);
			hegaldiMotaPanel.add(btnBilatuBidaia);

			JLabel lblJoanData = new JLabel("Joan data");
			lblJoanData.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblJoanData.setBounds(90, 110, 100, 25);
			hegaldiMotaPanel.add(lblJoanData);

			Date data1 = (Date) Date.valueOf(LocalDate.now());
			SpinnerDateModel model1 = new SpinnerDateModel(data1, null, null, java.util.Calendar.DAY_OF_MONTH);
			JSpinner spinner1 = new JSpinner(model1);
			JSpinner.DateEditor editor1 = new JSpinner.DateEditor(spinner1, "dd/MM/yyyy");
			spinner1.setEditor(editor1);
			spinner1.setBounds(190, 110, 150, 25);
			hegaldiMotaPanel.add(spinner1);

			JLabel lblKode1 = new JLabel("Hegaldi kodea");
			lblKode1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblKode1.setBounds(90, 150, 100, 25);
			hegaldiMotaPanel.add(lblKode1);

			JTextField textKode1 = new JTextField();
			textKode1.setBounds(190, 150, 150, 25);
			hegaldiMotaPanel.add(textKode1);

			JLabel lblAirelinea = new JLabel("Airelinea");
			lblAirelinea.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblAirelinea.setBounds(90, 190, 100, 25);
			hegaldiMotaPanel.add(lblAirelinea);

			JTextField textAirelinea = new JTextField();
			textAirelinea.setBounds(190, 190, 150, 25);
			hegaldiMotaPanel.add(textAirelinea);

			JLabel lblOrdua1 = new JLabel("Irteera-ordua");
			lblOrdua1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblOrdua1.setBounds(90, 230, 100, 25);
			hegaldiMotaPanel.add(lblOrdua1);

			SpinnerDateModel ordua1 = new SpinnerDateModel();
			JSpinner spinnerOrdua1 = new JSpinner(ordua1);
			JSpinner.DateEditor editorOrdua1 = new JSpinner.DateEditor(spinnerOrdua1, "HH:mm");
			spinnerOrdua1.setEditor(editorOrdua1);
			spinnerOrdua1.setBounds(190, 230, 150, 25);
			hegaldiMotaPanel.add(spinnerOrdua1);

			JLabel lblIraupena1 = new JLabel("Iraupena");
			lblIraupena1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblIraupena1.setBounds(90, 270, 100, 25);
			hegaldiMotaPanel.add(lblIraupena1);

			JTextField textIraupena1 = new JTextField();
			textIraupena1.setBounds(190, 270, 150, 25);
			hegaldiMotaPanel.add(textIraupena1);

			JLabel lblItzuliData = new JLabel("Itzuli data");
			lblItzuliData.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblItzuliData.setBounds(350, 110, 100, 25);
			hegaldiMotaPanel.add(lblItzuliData);

			Date data2 = (Date) Date.valueOf(LocalDate.now());
			SpinnerDateModel model2 = new SpinnerDateModel(data2, null, null, java.util.Calendar.DAY_OF_MONTH);
			JSpinner spinner2 = new JSpinner(model2);
			JSpinner.DateEditor editor2 = new JSpinner.DateEditor(spinner2, "dd/MM/yyyy");
			spinner2.setEditor(editor2);
			spinner2.setBounds(450, 110, 150, 25);
			hegaldiMotaPanel.add(spinner2);

			JLabel lblKode2 = new JLabel("Hegaldi kodea");
			lblKode2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblKode2.setBounds(350, 150, 100, 25);
			hegaldiMotaPanel.add(lblKode2);

			JTextField textKode2 = new JTextField();
			textKode2.setBounds(450, 150, 150, 25);
			hegaldiMotaPanel.add(textKode2);

			JLabel lblAirelinea2 = new JLabel("Airelinea");
			lblAirelinea2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblAirelinea2.setBounds(350, 190, 100, 25);
			hegaldiMotaPanel.add(lblAirelinea2);

			JTextField textAirelinea2 = new JTextField();
			textAirelinea2.setBounds(450, 190, 150, 25);
			hegaldiMotaPanel.add(textAirelinea2);

			JLabel lblOrdua2 = new JLabel("Irteera-ortua");
			lblOrdua2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblOrdua2.setBounds(350, 230, 100, 25);
			hegaldiMotaPanel.add(lblOrdua2);

			SpinnerDateModel ordua2 = new SpinnerDateModel();
			JSpinner spinnerOrdua2 = new JSpinner(ordua2);
			JSpinner.DateEditor editorOrdua2 = new JSpinner.DateEditor(spinnerOrdua2, "HH:mm");
			spinnerOrdua2.setEditor(editorOrdua2);
			spinnerOrdua2.setBounds(450, 230, 150, 25);
			hegaldiMotaPanel.add(spinnerOrdua2);

			JLabel lblIraupena2 = new JLabel("Iraupena");
			lblIraupena2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblIraupena2.setBounds(350, 270, 100, 25);
			hegaldiMotaPanel.add(lblIraupena2);

			JTextField textIraupena2 = new JTextField();
			textIraupena2.setBounds(450, 270, 150, 25);
			hegaldiMotaPanel.add(textIraupena2);
		}

		hegaldiMotaPanel.revalidate();
		hegaldiMotaPanel.repaint();
	}
}
