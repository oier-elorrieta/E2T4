package vista;

import java.awt.Color;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ModeloDAO.BidaiaDAO;
import ModeloDAO.HerrialdeaDAO;
import ModeloPOJOS.*;

import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.DropMode;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;

public class BidaiBerria extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textIzena;
	private JTextField textIraupen;

	public BidaiBerria(ArrayList<Bidaia> bidaiak) {
		setBounds(0, 0, 748, 584);
		setLayout(null);
		
		JLabel lblIzena = new JLabel("Bidai izena");
		lblIzena.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIzena.setBounds(90, 38, 104, 20);
		add(lblIzena);
		
		JLabel lblMota = new JLabel("Bidai mota");
		lblMota.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMota.setBounds(90, 81, 104, 21);
		add(lblMota);
		
		JLabel lblBidaiHasiera = new JLabel("Bidai hasiera");
		lblBidaiHasiera.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBidaiHasiera.setBounds(90, 125, 104, 21);
		add(lblBidaiHasiera);
		
		JLabel lblBidaiAmaiera = new JLabel("Bidai amaiera");
		lblBidaiAmaiera.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBidaiAmaiera.setBounds(90, 168, 104, 20);
		add(lblBidaiAmaiera);
		
		JLabel lblEgun = new JLabel("Bidai egun irapuen");
		lblEgun.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEgun.setBounds(82, 209, 120, 20);
		add(lblEgun);
		
		JLabel lblHerrialdea = new JLabel("Herrialdea");
		lblHerrialdea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHerrialdea.setBounds(90, 253, 104, 21);
		add(lblHerrialdea);
		
		JLabel lblDeskripzioa = new JLabel("Deskripzioa");
		lblDeskripzioa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDeskripzioa.setBounds(90, 335, 104, 14);
		add(lblDeskripzioa);
		
		JLabel lblSGZ = new JLabel("Sartu gabeko zerbitzuak");
		lblSGZ.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSGZ.setBounds(90, 472, 104, 14);
		add(lblSGZ);
		
		textIzena = new JTextField();
		textIzena.setBounds(239, 38, 194, 20);
		add(textIzena);
		textIzena.setColumns(10);
		
		JComboBox<String> comboMota = new JComboBox<String>();
		comboMota.setBounds(239, 80, 194, 22);
		add(comboMota);
		ArrayList<String> motak = new ArrayList<>();
		motak = BidaiaDAO.bidai_motaKargatu();
		for(int i=0; i<motak.size(); i++) {
			String mota = motak.get(i);
			comboMota.addItem(mota);
		}
		
		textIraupen = new JTextField();
		textIraupen.setColumns(10);
		textIraupen.setBounds(239, 209, 97, 20);
		add(textIraupen);
		
		JComboBox<String> comboHerrialdea = new JComboBox<String>();
		comboHerrialdea.setBounds(239, 252, 194, 22);
		add(comboHerrialdea);
		ArrayList<Herrialdea> herrialdeak = new ArrayList<>();
		herrialdeak = HerrialdeaDAO.herrialdeaKargatu();
		for(int i=0; i < herrialdeak.size(); i++) {
			Herrialdea herrialdea = herrialdeak.get(i);
			comboHerrialdea.addItem(herrialdea.getIzena());
		}
		
		JTextArea textDeskripzioa = new JTextArea();
		textDeskripzioa.setBounds(239, 296, 309, 115);
		add(textDeskripzioa);
		
		JTextArea textSGZ = new JTextArea();
		textSGZ.setBounds(239, 440, 309, 115);
		add(textSGZ);
		
		JButton btnAtzera = new JButton("<-");
		btnAtzera.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAtzera.setBounds(20, 20, 25, 25);
		add(btnAtzera);
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HegaldiPantaila.bueltatu(bidaiak);
			}
		});
		
		JButton btnGorde = new JButton("Gorde");
		btnGorde.setBounds(649, 21, 89, 23);
		add(btnGorde);
		
		JDateChooser bidaiHasieraData = new JDateChooser();
		bidaiHasieraData.setBounds(239, 125, 194, 20);
		add(bidaiHasieraData);
		
		JDateChooser bidaiAmaieraData = new JDateChooser();
		bidaiAmaieraData.setBounds(239, 168, 194, 20);
		add(bidaiAmaieraData);
		btnGorde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bidaiIzena = textIzena.getText();
				String bidaiMota = (String) comboMota.getSelectedItem();
				Date bidaiHasi = bidaiHasieraData.getDate();
				Date bidaiAmaiera = bidaiAmaieraData.getDate();
				String bidaiIraupen = textIraupen.getText();
				String bidaiHerri = (String) comboHerrialdea.getSelectedItem();
				String bidaiDesk = textDeskripzioa.getText();
				String textSGZerbitzu = textSGZ.getText();
				if(bidaiIzena.equals("") || bidaiMota.equals("") || bidaiHasi.equals("") || bidaiAmaiera.equals("") || bidaiIraupen.equals("") || bidaiHerri.equals("") || bidaiDesk.equals("") || textSGZerbitzu.equals("")) {
					JOptionPane.showMessageDialog(null, "Sartu informazioa zati guztietan");
				} else {
					BidaiaDAO.bidaiaSartu(bidaiIzena, bidaiMota, bidaiHasi, bidaiAmaiera, bidaiIraupen, bidaiHerri, bidaiDesk, textSGZerbitzu);
				}
			}
		});
	}
}
