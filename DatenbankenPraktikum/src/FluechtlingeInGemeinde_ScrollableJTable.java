import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;



public class FluechtlingeInGemeinde_ScrollableJTable extends javax.swing.JFrame{	
	
	public FluechtlingeInGemeinde_ScrollableJTable(String gemeindeId, String gemeindeName, String databaseUsername, String databasePassword) throws SQLException{
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setTitle("Fluechtlinge in der Gemeinde " + gemeindeName);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setPreferredSize(new Dimension(1000, 400));
        
        int n = 0;
        ResultSet testLaenge = Functions.fluechtlingeInGemeinde(DatabaseConnector.connectToDatabase(databaseUsername, databasePassword), gemeindeId);
        
        while(testLaenge.next()){
			n++;
		}

        
        /*
         * [dbo].[Person].[Vorname], [dbo].[Person].[Nachname],
            [dbo].[Flüchtling].[Geschlecht], [dbo].[Flüchtling].[Geburtsdatum],
            [dbo].[Person].[Tel], [dbo].[Person].[Handy], [dbo].[Person].[eMail]
         */
        
        String[] spaltenbeschriftung = {"Vorname", "Nachname", "Geschlecht", "Geburtsdatum", "Telefonnummer", "Handynummer", "E-Mail"};
        
        String[][] FDaten = new String[n][spaltenbeschriftung.length];
        
        ResultSet rs = Functions.fluechtlingeInGemeinde(DatabaseConnector.connectToDatabase(databaseUsername, databasePassword), gemeindeId);
        
        int index = 0;
		while (rs.next()) {
			FDaten[index][0] = rs.getString(1);
			FDaten[index][1] = rs.getString(2);
			FDaten[index][2] = rs.getString(3);
			FDaten[index][3] = rs.getString(4);
			FDaten[index][4] = rs.getString(5);
			FDaten[index][5] = rs.getString(6);
			FDaten[index][6] = rs.getString(7);
			index++;
		}
        
        
        JTable table = new JTable(FDaten, spaltenbeschriftung);
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
