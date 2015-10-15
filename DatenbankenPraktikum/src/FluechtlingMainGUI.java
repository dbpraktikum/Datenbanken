import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;


public class FluechtlingMainGUI extends JFrame{
	
	private String databaseUsername;
	
	private String databasePassword;
	
	private JButton BundeslaenderSehen;

	private JLabel Ueberschrift;
	
	private JPanel buttonGroup;

	private int id;
	
	public FluechtlingMainGUI(int idx, String databaseUsername, String databasePassword) {
		super("Fluechtling");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.databaseUsername = databaseUsername;
		this.databasePassword = databasePassword;
		this.setLayout(new BorderLayout(0,5));

		id = idx;
		BundeslaenderSehen = new JButton("Bundeslaender Anzeigen");
		
		
		BundeslaenderSehen.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					new Bundesland_ScrollableJTable(databaseUsername,databasePassword);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.out.println("Klasse: SacharbeiterMainGUI - AngeboteAnzeigen()");
					e1.printStackTrace();
				}
			}
			
		});
		
		// Labels erzeugen
		Ueberschrift = new JLabel("Optionen:");

		// Label zentrieren
		Ueberschrift.setHorizontalAlignment(JLabel.CENTER);


		getContentPane().add(BorderLayout.PAGE_START, Ueberschrift);
		
		
		buttonGroup = new JPanel(new GridLayout(5,1));
		
		buttonGroup.add(BundeslaenderSehen);

		getContentPane().add(BorderLayout.CENTER, buttonGroup);
		
		pack();
		
		this.setSize(300, 300);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

}