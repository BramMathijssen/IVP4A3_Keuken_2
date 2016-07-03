package main.java.presentation;

import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;


public class GUI extends JFrame {
	/**
	 * @Author Menno Bakker
	 */
     
	private static final long serialVersionUID = 1L;
	private JTextField txtLogin;
	private JPasswordField pwdWachtwoord;
	public GUI() {
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.GRAY);
		tabbedPane.setBounds(0, 0, 783, 579);
		getContentPane().add(tabbedPane);
		
		JPanel Logintab = new JPanel();
		Logintab.setBackground(Color.GRAY);
		tabbedPane.addTab("Login", null, Logintab, null);
		Logintab.setLayout(null);
		
		txtLogin = new JTextField();
		txtLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtLogin.setText("login");
		txtLogin.setBounds(143, 172, 116, 30);
		Logintab.add(txtLogin);
		txtLogin.setColumns(10);
		
		pwdWachtwoord = new JPasswordField();
		pwdWachtwoord.setText("Wachtwoord");
		pwdWachtwoord.setBounds(147, 256, 112, 22);
		Logintab.add(pwdWachtwoord);
		
		
		//Gebruikersnaam
		JLabel lblGebruikersnaam = new JLabel("Gebruikersnaam: ");
		lblGebruikersnaam.setBounds(141, 143, 118, 16);
		Logintab.add(lblGebruikersnaam);
		
		
		//Wachtwoord
		JLabel lblWachtwoord = new JLabel("Wachtwoord: ");
		lblWachtwoord.setBounds(143, 229, 116, 16);
		Logintab.add(lblWachtwoord);
		
		
		//Login 
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(149, 317, 97, 25);
		Logintab.add(btnLogin);
		
		
		//Overzicht met bestellingen
		JPanel Bestellingentab = new JPanel();
		Bestellingentab.setBackground(Color.GRAY);
		tabbedPane.addTab("Bestellingen", null, Bestellingentab, null);
		Bestellingentab.setLayout(null);
		
		
		//Toevoegen van een gerecht
		JPanel Toevoegen_Gerechttab = new JPanel();
		Toevoegen_Gerechttab.setBackground(Color.GRAY);
		tabbedPane.addTab("Toevoegen Gerecht", null, Toevoegen_Gerechttab, null);
		Toevoegen_Gerechttab.setLayout(null);
		
		
		//Status
		JPanel StatusTab = new JPanel();
		StatusTab.setBackground(Color.GRAY);
		tabbedPane.addTab("Status", null, StatusTab, null);
		StatusTab.setLayout(null);
		
		//Gerecht toewijzen
		JPanel GerechtTab = new JPanel();
		GerechtTab.setBackground(Color.GRAY);
		tabbedPane.addTab("Gerecht toewijzen", null, GerechtTab, null);
		GerechtTab.setLayout(null);
		
		
		/*
		 * Maak het alleen mogelijk om de andere panels (tabbladen) te gebruiken, als een gebruiker correct is ingelogd.
		 */
		Logintab.setEnabled(true);
		Bestellingentab.setEnabled(false);
		Toevoegen_Gerechttab.setEnabled(false);
		StatusTab.setEnabled(false);
		GerechtTab.setEnabled(false);
		
	}
}