
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

//import com.apple.eawt.Application;


public class MainWindow extends JFrame {
	
	JLabel username;
	JLabel loginFailed;
	JPasswordField textfield_password;
	JTextField  textfield_username;
	JButton		button_login;
	JComboBox combobox_rolle;

	
	
	public MainWindow() {
		
		
		
		this.getContentPane().setLayout(null);
		
		this.initWindow();
		
		this.addWindowListener(new WindowListener() {

			public void windowClosed(WindowEvent arg0) {
				
				
			}

			public void windowActivated(WindowEvent e) {
				
				
			}

			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

			public void windowDeactivated(WindowEvent e) {
				
				
			}

			public void windowDeiconified(WindowEvent e) {
				
				
			}

			public void windowIconified(WindowEvent e) {
				
				
			}

			public void windowOpened(WindowEvent e) {
				
				
			}

			
			
		});
		
	}
		
	protected void initWindow() 
	{
		// Instanzieren:
		username = new JLabel("Geben Sie Ihren Benutzernamen und Ihr Passwort ein.");
		textfield_username = new JTextField();
		textfield_password = new JPasswordField();
		button_login = new JButton("Login");
		loginFailed = new JLabel("Fehler beim Login. Benutzername oder Passwort falsch.");
		String[] rollen = {"Flüchtling","Helfer","Sachbearbeiter"}; 
		combobox_rolle = new JComboBox(rollen);
		combobox_rolle.setSelectedIndex(2);
		button_login.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				login();
				
				
			}
		});
		
		
		// Positionen festlegen
		username.setBounds(5,10,400,25);
		textfield_username.setBounds(5,50,400,25);
		textfield_password.setBounds(5,90,400,25);
		combobox_rolle.setBounds(5,130,400,25);
		button_login.setBounds(5, 200, 100, 25);
		loginFailed.setBounds(5,170,400,25);
		loginFailed.setForeground(Color.RED);
		loginFailed.setVisible(false);
		
		// Elemente dem Fenster hinzufŸgen:
		this.getContentPane().add(username);
		this.getContentPane().add(textfield_username);
		this.getContentPane().add(textfield_password);
		this.getContentPane().add(button_login);
		this.getContentPane().add(loginFailed);
		this.getContentPane().add(combobox_rolle);
		
		this.pack();
	}
	public void login(){
		Loginanwendung login = new Loginanwendung();
		String rolle = (String)combobox_rolle.getSelectedItem();
		String[] loginData = login.login(this.textfield_username.getText(), textfield_password.getText(), (String) combobox_rolle.getSelectedItem());
		System.out.println(textfield_password.getText());
		if(loginData[0] == null){
			loginFailed.setVisible(true);
		}else{
			switch(rolle){
			case "Sachbearbeiter":
				System.out.println("TEST");
				new SachbearbeiterMainGUI().main(null);;
				break;
			case "Helfer":
				break;
			case "Flüchtling":
				break;
			}
			this.dispose();
		}
		
	}
}
