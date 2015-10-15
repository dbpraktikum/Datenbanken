import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;


public class HelferMainGUI extends JFrame{
	private JButton AlleAngeboteSehen;
	private JButton EigeneAngeboteSehen;
	private JButton VorsteherDerUnterkuenfteSehen;
	private JButton BundeslaenderSehen;

	private JLabel Ueberschrift;
	
	private JPanel buttonGroup;
	
	private int id;

	public HelferMainGUI(int idx, String databaseUsername, String databasePassword) {
		super("Helfer");
		//setLocation(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setLayout(new BorderLayout(0,5));
		id = idx;
		AlleAngeboteSehen = new JButton("Alle Angebote Anzeigen");
		EigeneAngeboteSehen = new JButton("Eigene Angebote Anzeigen");
		VorsteherDerUnterkuenfteSehen = new JButton("Vorsteher der Unterkuenfte Anzeigen");
		BundeslaenderSehen = new JButton("Bundeslaender Anzeigen");
		
		
		
		AlleAngeboteSehen.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					new AngeboteAnzeigen(databaseUsername, databasePassword);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.out.println("Klasse: HelferMainGUI - AngeboteAnzeigen()");
					e1.printStackTrace();
				}
			}
		});
		
		EigeneAngeboteSehen.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Eigene Angebote Anzeigen");
			}
		});
		
		VorsteherDerUnterkuenfteSehen.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					new VorsteherVonHelfer(id, databaseUsername, databasePassword);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
		BundeslaenderSehen.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					new Bundesland_ScrollableJTable(databaseUsername, databasePassword);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("Klasse: HelferMainGUI - Bundesland_ScrollableJTable()");
					e.printStackTrace();
				}
			}
			
		});
		
		// Labels erzeugen
		Ueberschrift = new JLabel("Optionen:");

		// Label zentrieren
		Ueberschrift.setHorizontalAlignment(JLabel.CENTER);


		getContentPane().add(BorderLayout.PAGE_START, Ueberschrift);
		
		
		buttonGroup = new JPanel(new GridLayout(5,1));
		
		buttonGroup.add(AlleAngeboteSehen);
		buttonGroup.add(EigeneAngeboteSehen);
		buttonGroup.add(VorsteherDerUnterkuenfteSehen);
		buttonGroup.add(BundeslaenderSehen);
		

		getContentPane().add(BorderLayout.CENTER, buttonGroup);
		
		pack();
		
		this.setSize(300, 300);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

}