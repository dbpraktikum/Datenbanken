import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;



public class UnterkunftInGemeinde_ScrollableJTable extends javax.swing.JFrame{
	
	private final String databaseUsername = "DB_Pr2015_02_01";
	private final String databasePassword = "Test123!";
	
	
	public UnterkunftInGemeinde_ScrollableJTable(String gemeindeId, String gemeindeName) throws SQLException{
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setTitle("Unterkünfte in der Gemeinde " + gemeindeName);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setPreferredSize(new Dimension(1000, 400));
        
        int n = 0;
        ResultSet testLaenge = Functions.unterkuenfteInGemeinde(DatabaseConnector.connectToDatabase(databaseUsername, databasePassword), gemeindeId);
        
        while(testLaenge.next()){
			n++;
		}

        
        /*
         * UId, Straße, Hausnummer, PLZ, Stadt, Kapazität, Anzahl-F, Vorname Vorsteher, Nachname Vorsteher, Tel, Handy, eMail
         */
        
        String[] spaltenbeschriftung = {"UId", "PLZ", "Stadt", "Straße", "Hausnummer", "Kapazität", "Anzahl Flüchtlinge", "Vorsteher - Vorname", "Vorsteher - Nachname"};
        
        String[][] GDaten = new String[n][spaltenbeschriftung.length];
		/*for(int i = 0; i < GDaten.length; i++){
			for(int j = 0; j < GDaten[i].length; j++){
				GDaten[i][j] = "Gemeinde " + i + " " + j;
			}
		}*/
        
        ResultSet rs = Functions.unterkuenfteInGemeinde(DatabaseConnector.connectToDatabase(databaseUsername, databasePassword), gemeindeId);
        
        int index = 0;
		while (rs.next()) {
			System.out.println("Unterkunft: " + rs.getString(1));
			GDaten[index][0] = rs.getString(1);
			GDaten[index][1] = rs.getString(4);
			GDaten[index][2] = rs.getString(5);
			GDaten[index][3] = rs.getString(2);
			GDaten[index][4] = rs.getString(3);
			GDaten[index][5] = rs.getString(6);
			GDaten[index][6] = rs.getString(7);
			GDaten[index][7] = rs.getString(8);
			GDaten[index][8] = rs.getString(9);
			index++;
		}
        
        
        JTable table = new JTable(GDaten, spaltenbeschriftung);
        table.setRowHeight(25);
        table.getTableHeader().setFont(new Font("Serif", Font.BOLD, 15));
        
        JScrollPane pane = new JScrollPane(table);
        mainPanel.add(pane, BorderLayout.CENTER);
        
                
        
        
        this.setContentPane(mainPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
	}
	
}
