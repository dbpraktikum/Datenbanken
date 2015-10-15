import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;


public class SachbearbeiterMainGUI extends JFrame{
	private JButton FluechtlingAnlegen;
	private JButton HelferAnlegen;
	private JButton SachbearbeiterAnlegen;
	private JButton UnterkunftAnlegen;
	private JButton MeineFluechtlingeSehen;
	private JButton BundeslaenderSehen;
	private JButton AngeboteAnzeigen;

	private JButton SpendeAnlegen;
	private JLabel Ueberschrift;
	
	private JPanel buttonGroup;
	private int id;

	public SachbearbeiterMainGUI(int idx, String databaseUsername, String databasePassword) {
		super("Sachbearbeiter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		id = idx;
		this.setLayout(new BorderLayout(0,5));
		FluechtlingAnlegen = new JButton("Neuen Fuechtling Anlegen");
		HelferAnlegen = new JButton("Neuen Helfer Anlegen");
		SachbearbeiterAnlegen = new JButton("Neuen Sachbearbeiter Anlegen");
		UnterkunftAnlegen = new JButton("Neue Unterkunft Anlegen ");
		MeineFluechtlingeSehen = new JButton("Flueechtlinge Anzeigen");
		BundeslaenderSehen = new JButton("Bundeslaender Anzeigen");
		AngeboteAnzeigen = new JButton("Angebote Anzeigen");
		SpendeAnlegen = new JButton("Spende Anlegen ");
		

		// Listener fuer Buttons
		FluechtlingAnlegen.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new FluechtlingAnlegen(id, databaseUsername, databasePassword);
			}	
		});
		HelferAnlegen.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new HelferAnlegen(databaseUsername, databasePassword);
			}
			
		});
		SachbearbeiterAnlegen.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
			 
				new SachbearbeiterAnlegen(databaseUsername, databasePassword);
			}
			
		});
		UnterkunftAnlegen.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		SpendeAnlegen.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new SpendenAnlegen(databaseUsername,databasePassword);
			}
			
		});
		MeineFluechtlingeSehen.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					new MeineFluechtlingeSehen_ScrollableJTable(id, databaseUsername, databasePassword);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			}
			
		);
		
		BundeslaenderSehen.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					new Bundesland_ScrollableJTable_Sachbearbeiter(databaseUsername, databasePassword);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.out.println("Klasse: SacharbeiterMainGUI - Bundesland_ScrollableJTable()");
					e1.printStackTrace();
				}
			}
			
		});
		
		AngeboteAnzeigen.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					new AngeboteAnzeigen(databaseUsername, databasePassword);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("Klasse: SacharbeiterMainGUI - AngeboteAnzeigen()");
					e.printStackTrace();
				}
			}
			
		});
		
		// Labels erzeugen
		Ueberschrift = new JLabel("Optionen:");

		// Label zentrieren
		Ueberschrift.setHorizontalAlignment(JLabel.CENTER);


		getContentPane().add(BorderLayout.PAGE_START, Ueberschrift);
		GridLayout gridL = new GridLayout(4,2);
		JPanel panel = new JPanel(gridL);
		this.getContentPane().add(panel);
		panel.add(FluechtlingAnlegen);
		panel.add(HelferAnlegen);
		panel.add(SachbearbeiterAnlegen);
		panel.add(UnterkunftAnlegen);
		panel.add(SpendeAnlegen);
		panel.add(MeineFluechtlingeSehen);
		panel.add(BundeslaenderSehen);
		panel.add(AngeboteAnzeigen);
		
		pack();
		
		this.setSize(450, 250);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

}