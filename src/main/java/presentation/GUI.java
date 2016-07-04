package main.java.presentation;

import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Vector;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import main.java.businesslogic.LoginManager;
import main.java.businesslogic.OrderManager;
import main.java.domain.Dish;
import main.java.domain.Order;

public class GUI extends JFrame {

    /**
     * @Author Menno Bakker
     */

    private static final long serialVersionUID = 1L;
    private JTextField txtLogin;
    private JPasswordField pwdWachtwoord;
    private LoginManager loginManager;
    private OrderManager orderManager;

    public GUI() {
        getContentPane().setLayout(null);

        loginManager = new LoginManager();

        orderManager = new OrderManager();

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

        //Overzicht met bestellingen
        JPanel Bestellingentab = new BestellingenPanel();
        Bestellingentab.setBackground(Color.WHITE);
        Bestellingentab.setVisible(false);

        //Toevoegen van een gerecht
        JPanel Toevoegen_Gerechttab = new JPanel();
        Toevoegen_Gerechttab.setBackground(Color.GRAY);
        Toevoegen_Gerechttab.setLayout(null);
        Toevoegen_Gerechttab.setVisible(false);

        //Status
        JPanel StatusTab = new JPanel();
        StatusTab.setBackground(Color.GRAY);
        StatusTab.setLayout(null);
        StatusTab.setVisible(false);
        

        //Gerecht toewijzen
        JPanel GerechtTab = new JPanel();
        GerechtTab.setBackground(Color.GRAY);
        GerechtTab.setLayout(null);
        GerechtTab.setVisible(false);
        
        //Login 
        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener((ActionEvent e) -> {
            if (loginManager.checkPassword(txtLogin.getText(), pwdWachtwoord.getText()) == false) {
                loginManager.setLoggedIn(false);
            } else {
                loginManager.setLoggedIn(true);
                tabbedPane.addTab("Bestellingen", null, Bestellingentab, null);
                tabbedPane.addTab("Toevoegen Gerecht", null, Toevoegen_Gerechttab, null);
                tabbedPane.addTab("Status", null, StatusTab, null);
                tabbedPane.addTab("Gerecht toewijzen", null, GerechtTab, null);
            }
        });
        btnLogin.setBounds(149, 317, 97, 25);
        Logintab.add(btnLogin);

        /*
		 * Maak het alleen mogelijk om de andere panels (tabbladen) te gebruiken, als een gebruiker correct is ingelogd.
         */
        Logintab.setEnabled(true);
        Bestellingentab.setEnabled(false);
        Toevoegen_Gerechttab.setEnabled(false);
        StatusTab.setEnabled(false);
        GerechtTab.setEnabled(false);

    }

    class BestellingenPanel extends JPanel {

        private JTextArea orderArea;

        public BestellingenPanel() {
            StringBuilder builder = new StringBuilder();
            
            orderArea = new JTextArea();
            
            builder.append("Geplaatste bestellingen:\n________________________________\n");
            
            for (Order order : orderManager.getPlacedOrders()) {
                builder.append("Id: " + order.getId() + " Datum: " + order.getDate().toString() + " Status: geplaatst\n");
                for (Dish dish : order.getDishList()) {
                    builder.append("   Gerecht " + dish.getId() + ": " + dish.getDishName() + "\n");
                }
            }
            
            orderArea.setText(builder.toString());
            
            add(orderArea);
        }
    }
}
