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
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setLayout(new GridLayout(4,2,10,0));
		JLabel personid = new JLabel("PersonId:");
		JLabel benutzername = new JLabel("Benutzername:");
		JLabel passwort = new JLabel("Passwort:");
		JLabel leer = new JLabel();
		JTextField person = new JTextField("");
		JTextField benutzer = new JTextField("");
		JPasswordField pass = new JPasswordField("");
		JButton login = new JButton("Registrieren");
		
		login.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				//TODO Registration überprüfen
				Registrierungsanwendung reg = new Registrierungsanwendung();
				//String[] loginData = login.login(benutzer.getText(), new String(pass.getPassword()), (String) auswahlComboBox.getSelectedItem());
				if(!reg.registrieren(Integer.parseInt(person.getText()), benutzer.getText(), new String(pass.getPassword()))){
					leer.setText("Registration Fehler!");
					leer.setForeground(Color.RED);
				}
				else {
					f.dispose();
					new LoginFenster(parent);
				}
			}
			
		});
		
		this.add(personid);
		this.add(person);
		this.add(benutzername);
		this.add(benutzer);
		this.add(passwort);
		this.add(pass);
		this.add(leer);
		this.add(login);
		this.pack();
		this.setSize(285, 150);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public static void main(String[] args){
		
	}
}
