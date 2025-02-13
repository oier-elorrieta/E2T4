package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;

import ModeloDAO.BidaiaDAO;
import ModeloDAO.ZerbitzuaDAO;
import ModeloPOJOS.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class HegaldiPantaila extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JPanel HegaldiPantaila = new JPanel();
	private static JPanel bidaiBerriaPanel = new BidaiBerria(null);
	private static JPanel ekitaldiBerriaPanel = new EkitaldiBerria(null);
	
	private static int bidaia_id;
	/**
	 * Launch the application.
	 * @param agen_id 
	 */
	public static void pantViajes(ArrayList<Bidaia> bidaiak, int agen_id) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HegaldiPantaila frame = new HegaldiPantaila(bidaiak, agen_id);
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
	public HegaldiPantaila(ArrayList<Bidaia> bidaiak, int agen_id) {
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
		
		DefaultTableModel bidaiaTaula = new DefaultTableModel(new String[] {"bidaia_id", "Bidaia", "Mota", "Egunak", "Hasi data", "Amaitu data", "Herrialdea"}, 0);
		JTable taulaBidaiak = new JTable(bidaiaTaula);
		
		scrollBidaiak.setViewportView(taulaBidaiak);
		taulaBidaiak.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		for(int i=0; i<bidaiak.size(); i++) { //Recorre el ArrayList de agencias 
			Bidaia bidaia = bidaiak.get(i);
			bidaiaTaula.addRow(new Object[] {bidaia.getBidaia_id(), bidaia.getBidaia_izena(), bidaia.getMota(), bidaia.getEgunak(), bidaia.getHasiData(), bidaia.getAmaituData(), bidaia.getHerrialde()});
		}
		TableColumn zutabe_bidaia_id = taulaBidaiak.getColumnModel().getColumn(0);
		zutabe_bidaia_id.setMinWidth(0);
		zutabe_bidaia_id.setMaxWidth(0);
		zutabe_bidaia_id.setPreferredWidth(0);
		
		JScrollPane scrollEkitaldiak = new JScrollPane();
		scrollEkitaldiak.setBounds(40, 250, 420, 130);
		HegaldiPantaila.add(scrollEkitaldiak);
		
		DefaultTableModel zerbitzuTaula = new DefaultTableModel(new String[] {"zerbitzu_id", "Zerbitzu izena", "Mota", "Data", "Prezioa"}, 0);
		JTable taulaEkitaldiak = new JTable(zerbitzuTaula);
		scrollEkitaldiak.setViewportView(taulaEkitaldiak);
		TableColumn zutabe_zerbitzu_id = taulaEkitaldiak.getColumnModel().getColumn(0);
		zutabe_zerbitzu_id.setMinWidth(0);
		zutabe_zerbitzu_id.setMaxWidth(0);
		zutabe_zerbitzu_id.setPreferredWidth(0);
		
		taulaBidaiak.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(!e.getValueIsAdjusting()) {
					int aukeratua = taulaBidaiak.getSelectedRow();
					
					if(aukeratua != -1) {
						Bidaia bidaia = bidaiak.get(aukeratua);
						ArrayList<Zerbitzua> zerbitzuak = new ArrayList<>();
						int bidaiId = (bidaia.getBidaia_id());
						zerbitzuak = ZerbitzuaDAO.zerbitzuKargatu(bidaiId);
						zerbitzuTaula.setRowCount(0);
						for(int i=0; i<zerbitzuak.size(); i++) {
							Zerbitzua zerbitzua = zerbitzuak.get(i);
							zerbitzuTaula.addRow(new Object[] {zerbitzua.getZerbitzu_id(), zerbitzua.getZerbitzu_izena(), zerbitzua.getZerbitzu_mota(), zerbitzua.getZerbitzu_data(), zerbitzua.getZerbitzu_prezioa()});
						}
					}
				}
			}
		});
		
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
		
		JButton btnBES = new JButton("Bezeroaren Eskaintza Sortu");
		btnBES.setBounds(40, 430, 200, 25);
		HegaldiPantaila.add(btnBES);
		btnBES.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int aukeratua = taulaBidaiak.getSelectedRow();
				Bidaia bidaia = bidaiak.get(aukeratua);
				
				ArrayList<Zerbitzua> zerbitzuak = new ArrayList<>();
				zerbitzuak = bidaia.getZerbitzuak();
				String eskaintza = "Eskaintza.txt";
				String edukia = "BIDAIA: "+bidaia.getBidaia_izena()+" "+bidaia.getMota()+" "+bidaia.getEgunak()+" "+bidaia.getHasiData()+" "+bidaia.getAmaituData()+" "+bidaia.getHerrialde();
				try(PrintWriter writer = new PrintWriter(new FileWriter(eskaintza))){
					writer.println(edukia);
					System.out.println("Eskaintza sortu da");
				}catch(IOException w) {
					System.err.println("Ezin izan da eskaintza sortu " + w.getMessage());
				}
			}
		});
		
		JButton btnEzabatuBidaia = new JButton("");
		btnEzabatuBidaia.setBounds(470, 80, 25, 25);
		HegaldiPantaila.add(btnEzabatuBidaia);
		DefaultTableModel model = (DefaultTableModel) taulaBidaiak.getModel();
		
		
		JButton btnEzabatuEkitaldia = new JButton("");
		btnEzabatuEkitaldia.setBounds(470, 250, 25, 25);
		HegaldiPantaila.add(btnEzabatuEkitaldia);
		DefaultTableModel modelEkitaldi = (DefaultTableModel) taulaEkitaldiak.getModel();
		
		btnEzabatuBidaia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = taulaBidaiak.getSelectedRow();
				if (n != -1) {
					int id = bidaiak.get(n).getBidaia_id();
					BidaiaDAO.BidaiaEzabatu(id);
					if(taulaEkitaldiak.getRowCount() > 0) {
						ZerbitzuaDAO.zerbitzuEzabatuGuztiak(id);
						modelEkitaldi.setRowCount(0);
					}
					model.removeRow(n);
				}
			}
		});
		btnEzabatuEkitaldia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int l = taulaEkitaldiak.getSelectedRow();
				if (l != -1) {
					int zerbitzu_id = (int) taulaEkitaldiak.getValueAt(l, 0);
					ZerbitzuaDAO.zerbitzuEzabatu(zerbitzu_id);
					modelEkitaldi.removeRow(l);
				}
			}
		});
	}
	
	public static void bueltatu(ArrayList<Bidaia> bidaiak) {
		BidaiaDAO.bidaiaKargatu(bidaiak, bidaia_id);
		bidaiBerriaPanel.setVisible(false);
		ekitaldiBerriaPanel.setVisible(false);
		HegaldiPantaila.setVisible(true);
		
	}
}
