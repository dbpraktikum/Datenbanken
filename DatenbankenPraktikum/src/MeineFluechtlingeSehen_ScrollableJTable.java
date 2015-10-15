package Merge;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MeineFluechtlingeSehen_ScrollableJTable extends javax.swing.JFrame{
	
	private final String databaseUsername = "DB_Pr2015_02_01";
	private final String databasePassword = "Test123!";
	
	public MeineFluechtlingeSehen_ScrollableJTable() throws SQLException{
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setTitle("Fluechtlinge anzeigen");
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setPreferredSize(new Dimension(1750, 400));
        
        /*[dbo].[Person].[PId], [dbo].[Person].[Vorname], [dbo].[Person].[Nachname],
		   [dbo].[Flüchtling].[Original Vorname], [dbo].[Flüchtling].[Original Nachname],
		   [dbo].[Flüchtling].[Geschlecht], [dbo].[Flüchtling].[Geburtsdatum],
        [dbo].[Person].[Tel], [dbo].[Person].[Handy], [dbo].[Person].[eMail],
		   [dbo].[Flüchtling].[Antragsstatus], [dbo].[hatEinen].[Thema]*/
     
        String[] spaltenbeschriftung = {"PersonId", "Vorname", "Nachname", "Original Vorname", "Original Nachname", "Geschelcht", "Geburtsdatum", "Telefonnummer", "Handynummer", "E-Mail", "Antragsstatus", "Thema"};
     
        
        ResultSet rs1 = Functions.sachbearbeiterSuchtSeineFluechtlinge(DatabaseConnector.connectToDatabase(databaseUsername, databasePassword), 3);         
        
        int n = 0;
        while(rs1.next()){
			n++;
		}
       
        String[][] FDaten = new String[n][12];
        
        ResultSet rs2 = Functions.sachbearbeiterSuchtSeineFluechtlinge(DatabaseConnector.connectToDatabase(databaseUsername, databasePassword), 3);         
        
        int i = 0;
        while(rs2.next()){

			FDaten[i][0] = rs2.getString(1);
			FDaten[i][1] = rs2.getString(2);
			FDaten[i][2] = rs2.getString(3);
			FDaten[i][3] = rs2.getString(4);
			FDaten[i][4] = rs2.getString(5);
			FDaten[i][5] = rs2.getString(6);
			FDaten[i][6] = rs2.getString(7);
			FDaten[i][7] = rs2.getString(8);
			FDaten[i][8] = rs2.getString(9);
			FDaten[i][9] = rs2.getString(10);
			FDaten[i][10] = rs2.getString(11);
			FDaten[i][11] = rs2.getString(12);
			i++;
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
	
	public static void main(String[] args) {
		try {
			MeineFluechtlingeSehen_ScrollableJTable test = new MeineFluechtlingeSehen_ScrollableJTable();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
}
