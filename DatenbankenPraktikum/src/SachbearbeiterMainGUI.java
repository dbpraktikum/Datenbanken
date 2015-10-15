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

	public SachbearbeiterMainGUI(int idx) {
		super("Sachbearbeiter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		id = idx;
		this.setSize(1500,6000);
		this.setLayout(new BorderLayout(0,5));
		FluechtlingAnlegen = new JButton("Neuen Füchtling Anlegen");
		HelferAnlegen = new JButton("Neuen Helfer Anlegen");
		SachbearbeiterAnlegen = new JButton("Neuen Sachbearbeiter Anlegen");
		UnterkunftAnlegen = new JButton("Neue Unterkunft Anlegen ");
		MeineFluechtlingeSehen = new JButton("Flüechtlinge Anzeigen");
		BundeslaenderSehen = new JButton("Bundeslaender Anzeigen");
		AngeboteAnzeigen = new JButton("Angebote Anzeigen");
		SpendeAnlegen = new JButton("Spende Anlegen ");
		

		// Listener fuer Buttons
		FluechtlingAnlegen.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new FluechtlingAnlegen(id);
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
			 
				new SachbearbeiterAnlegen();
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
			
			}
			
		});
		MeineFluechtlingeSehen.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				new MeineFluechtlingeSehen_ScrollableJTable(id);
			}
			
			}
			
		);
		
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
		
	
		JPanel buttonGroupA = new JPanel(new GridLayout(6,1));
		JPanel buttonGroupB = new JPanel(new GridLayout(6,1));
		buttonGroupA.add(FluechtlingAnlegen);
		buttonGroupA.add(HelferAnlegen);
		buttonGroupA.add(SachbearbeiterAnlegen);
		buttonGroupA.add(UnterkunftAnlegen);
		buttonGroupA.add(SpendeAnlegen);
		buttonGroupB.add(MeineFluechtlingeSehen);
		buttonGroupB.add(BundeslaenderSehen);
		buttonGroupB.add(AngeboteAnzeigen);

		
		getContentPane().add(BorderLayout.WEST, buttonGroupA);

		getContentPane().add(BorderLayout.EAST, buttonGroupB);		
		pack();
		
	
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

	public static void main(String[] args) {
		new SachbearbeiterMainGUI(3);
	}
}