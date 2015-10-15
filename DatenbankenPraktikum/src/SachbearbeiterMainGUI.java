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

	private JLabel Ueberschrift;
	
	private JPanel buttonGroup;

	public SachbearbeiterMainGUI() {
		super("Sachbearbeiter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setLayout(new BorderLayout(0,5));

		FluechtlingAnlegen = new JButton("Neuen Fluechtling Anlegen");
		HelferAnlegen = new JButton("Neuen Helfer Anlegen");
		SachbearbeiterAnlegen = new JButton("Neuen Sachbearbeiter Anlegen");
		UnterkunftAnlegen = new JButton("Neue Unterkunft Anlegen");
		MeineFluechtlingeSehen = new JButton("Meine Fluechtlinge Sehen");
		BundeslaenderSehen = new JButton("Bundeslaender Anzeigen");
		AngeboteAnzeigen = new JButton("Angebote Anzeigen");
		

		// Listener fuer Buttons
		FluechtlingAnlegen.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new FluechtlingAnlegen();
			}	
		});
		HelferAnlegen.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new HelferAnlegen();
			}
			
		});
		SachbearbeiterAnlegen.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Sachbearbeiter Anlegen"); 
				new SachbearbeiterAnlegen();
			}
			
		});
		UnterkunftAnlegen.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		MeineFluechtlingeSehen.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					new MeineFluechtlingeSehen_ScrollableJTable();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.out.println("Klasse: SacharbeiterMainGUI - MeineFluechtlingeSehen_ScrollableJTable()");
					e1.printStackTrace();
				}
				
			}
			
		});
		
		BundeslaenderSehen.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					new Bundesland_ScrollableJTable_Sachbearbeiter();
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
					new AngeboteAnzeigen();
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
		
		
		buttonGroup = new JPanel(new GridLayout(6,1));
		
		buttonGroup.add(HelferAnlegen);
		buttonGroup.add(SachbearbeiterAnlegen);
		buttonGroup.add(UnterkunftAnlegen);
		buttonGroup.add(MeineFluechtlingeSehen);
		buttonGroup.add(BundeslaenderSehen);
		buttonGroup.add(AngeboteAnzeigen);

		getContentPane().add(BorderLayout.CENTER, buttonGroup);
		
		pack();
		
		this.setSize(300, 400);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

	public static void main(String[] args) {
		new SachbearbeiterMainGUI();
	}

}