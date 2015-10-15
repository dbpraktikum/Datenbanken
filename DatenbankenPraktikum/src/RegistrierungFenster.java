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

public class RegistrierungFenster extends javax.swing.JFrame{
	public RegistrierungFenster(JFrame parent){
		super("Registrierung");
		JFrame f = this;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(5,2,10,0));
		JLabel personid = new JLabel("PersonId:");
		JLabel benutzername = new JLabel("Benutzername:");
		JLabel passwort = new JLabel("Passwort:");
		JLabel anmeldung = new JLabel("Registrieren als");
		JLabel leer = new JLabel();
		JTextField person = new JTextField("");
		JTextField benutzer = new JTextField("");
		JPasswordField pass = new JPasswordField("");
		String[] auswahl = {"Flüchtling", "Helfer", "Sachbearbeiter"};
		JComboBox<String> auswahlComboBox = new JComboBox<String>(auswahl);
		auswahlComboBox.setSelectedIndex(2);
		JButton login = new JButton("Registrieren");
		
		login.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("Benutzername: " + benutzer.getText());
				System.out.println("Passwort: " + new String(pass.getPassword()));
				System.out.println("Registriert als " + auswahl[auswahlComboBox.getSelectedIndex()]);
				
				//TODO Registration überprüfen
				Registrierungsanwendung reg = new Registrierungsanwendung();
				//String[] loginData = login.login(benutzer.getText(), new String(pass.getPassword()), (String) auswahlComboBox.getSelectedItem());
				if(!reg.registrieren(Integer.parseInt(person.getText()), benutzer.getText(), new String(pass.getPassword()), (String) auswahlComboBox.getSelectedItem())){
					leer.setText("Registration Fehler!");
					leer.setForeground(Color.RED);
				}
				else {
					System.out.println("erfolgreich");
					f.dispose();
					parent.dispose();
					if (auswahlComboBox.getSelectedIndex() == 0) {
						new FluechtlingMainGUI();
					}
					if (auswahlComboBox.getSelectedIndex() == 1) {
						new HelferMainGUI();
					}
					if (auswahlComboBox.getSelectedIndex() == 2) {
						new SachbearbeiterMainGUI();
					}
				}
			}
			
		});
		
		this.add(personid);
		this.add(person);
		this.add(benutzername);
		this.add(benutzer);
		this.add(passwort);
		this.add(pass);
		this.add(anmeldung);
		this.add(auswahlComboBox);
		this.add(leer);
		this.add(login);
		this.pack();
		this.setSize(275, 150);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public static void main(String[] args){
		
	}
}
