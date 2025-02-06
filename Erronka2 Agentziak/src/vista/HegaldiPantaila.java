package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class HegaldiPantaila extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JPanel HegaldiPantaila = new JPanel();
	private static JPanel bidaiBerriaPanel = new BidaiBerria();
	private static JPanel ekitaldiBerriaPanel = new EkitaldiBerria();

	/**
	 * Launch the application.
	 */
	public static void pantViajes(Connection conexioa, int agentzia_id) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HegaldiPantaila frame = new HegaldiPantaila(conexioa, agentzia_id);
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
	public HegaldiPantaila(Connection conexioa, int agentzia_id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 755, 615);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		HegaldiPantaila.setBounds(0, 0, 748, 584);
		contentPane.add(HegaldiPantaila);
		HegaldiPantaila.setLayout(null);
		
		JScrollPane scrollBidaiak = new JScrollPane();
		scrollBidaiak.setBounds(40, 80, 420, 130);
		HegaldiPantaila.add(scrollBidaiak);
		
		DefaultTableModel bidaiaTaula = new DefaultTableModel(new String[] {"Bidaia", "Mota", "Egunak", "Hasi data", "Amaitu data", "Herrialdea"}, 0);
		JTable taulaBidaiak = new JTable(bidaiaTaula);
		scrollBidaiak.setViewportView(taulaBidaiak);
		
		try {
			String sql = "SELECT Izena, bidai_mota_kod, hasiera_data, amaiera_data, herrialde_kod FROM bidaia INNER JOIN agentzia USING(agentzia_id) WHERE agentzia_id="+ agentzia_id;
			Statement stmt = conexioa.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String izena = rs.getString("Izena");
				String mota = rs.getString("bidai_mota_kod");
				Date hasiera = rs.getDate("hasiera_data");
				Date amaiera = rs.getDate("amaiera_data");
				String herrialdea = rs.getString("herrialde_kod");
				bidaiaTaula.addRow(new Object[] {izena, mota, "", hasiera, amaiera, herrialdea});
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		JScrollPane scrollEkitaldiak = new JScrollPane();
		scrollEkitaldiak.setBounds(40, 250, 420, 130);
		HegaldiPantaila.add(scrollEkitaldiak);
		
		DefaultTableModel table2 = new DefaultTableModel(new String[] {"Ekitaldi izena", "Mota", "Data", "Prezioa"}, 0);
		JTable taulaEkitaldiak = new JTable(table2);
		scrollEkitaldiak.setViewportView(taulaEkitaldiak);
		
		JButton btnBidaiBerria = new JButton("Bidai Berria");
		btnBidaiBerria.setBounds(550, 133, 150, 25);
		HegaldiPantaila.add(btnBidaiBerria);
		
		bidaiBerriaPanel.setBounds(0, 0, 748, 584);
	    contentPane.add(bidaiBerriaPanel);
	    bidaiBerriaPanel.setVisible(false);
		
		btnBidaiBerria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HegaldiPantaila.setVisible(false);
				ekitaldiBerriaPanel.setVisible(false);
				bidaiBerriaPanel.setVisible(true);
			}
		});
		
		JButton btnEkitaldiBerria = new JButton("Ekitaldi Berria");
		btnEkitaldiBerria.setBounds(550, 303, 150, 25);
		HegaldiPantaila.add(btnEkitaldiBerria);
		
		ekitaldiBerriaPanel.setBounds(0, 0, 748, 584);
	    contentPane.add(ekitaldiBerriaPanel);
	    ekitaldiBerriaPanel.setVisible(false);
		
		btnEkitaldiBerria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HegaldiPantaila.setVisible(false);
				bidaiBerriaPanel.setVisible(false);
				ekitaldiBerriaPanel.setVisible(true);
			}
		});
		
		JButton btnDeskonektatu = new JButton("Deskonektatu");
		btnDeskonektatu.setBounds(550, 430, 150, 25);
		HegaldiPantaila.add(btnDeskonektatu);
		
		JButton btnGOC = new JButton("Generar Oferta Cliente");
		btnGOC.setBounds(40, 430, 200, 25);
		HegaldiPantaila.add(btnGOC);
		
		JButton btnEzabatuBidaia = new JButton("");
		btnEzabatuBidaia.setBounds(470, 80, 25, 25);
		HegaldiPantaila.add(btnEzabatuBidaia);
		
		JButton btnEzabatuEkitaldia = new JButton("");
		btnEzabatuEkitaldia.setBounds(470, 250, 25, 25);
		HegaldiPantaila.add(btnEzabatuEkitaldia);
	}
	
	public static void bueltatu() {
		bidaiBerriaPanel.setVisible(false);
		ekitaldiBerriaPanel.setVisible(false);
		HegaldiPantaila.setVisible(true);
	}
}
