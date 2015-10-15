import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFenster extends javax.swing.JFrame{
	
	public LoginFenster(JFrame parent){
		super("Anmeldung");
		JFrame f = this;
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setLayout(new GridLayout(4,2,10,0));
		JLabel benutzername = new JLabel("Benutzername:");
		JLabel passwort = new JLabel("Passwort:");
		JLabel anmeldung = new JLabel("Anmelden als");
		JLabel leer = new JLabel();
		JTextField benutzer = new JTextField("");
		JPasswordField pass = new JPasswordField("");
		String[] auswahl = {"Flüchtling", "Helfer", "Sachbearbeiter"};
		JComboBox<String> auswahlComboBox = new JComboBox<String>(auswahl);
		auswahlComboBox.setSelectedIndex(2);
		JButton login = new JButton("Login");
		
		login.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				/*System.out.println("Benutzername: " + benutzer.getText());
				System.out.println("Passwort: " + new String(pass.getPassword()));
				System.out.println("Anmelden als " + auswahl[auswahlComboBox.getSelectedIndex()]);*/
				
				Loginanwendung login = new Loginanwendung();
				int personId = login.login(benutzer.getText(), new String(pass.getPassword()), (String) auswahlComboBox.getSelectedItem());
				if(personId == -1){
					leer.setText("Login Fehler!");
					leer.setForeground(Color.RED);
				}
				else {
					f.dispose();
					parent.dispose();
					if (auswahlComboBox.getSelectedIndex() == 0) {
						new FluechtlingMainGUI(personId,"DB_PR2015_02_01","Test123!");
					}
					if (auswahlComboBox.getSelectedIndex() == 1) {
						new HelferMainGUI(personId,"DB_PR2015_02_02","Test123!");
					}
					if (auswahlComboBox.getSelectedIndex() == 2) {
						new SachbearbeiterMainGUI(personId,"DB_PR2015_02_03","Test123!");
					}
				}
			}
			
		});
		
		
		this.add(benutzername);
		this.add(benutzer);
		this.add(passwort);
		this.add(pass);
		this.add(anmeldung);
		this.add(auswahlComboBox);
		this.add(leer);
		this.add(login);
		this.pack();
		this.setSize(285, 150);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
