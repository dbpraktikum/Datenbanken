
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MeineFluechtlingeSehen_ScrollableJTable extends javax.swing.JFrame{
	    public MeineFluechtlingeSehen_ScrollableJTable(){
	        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
	        this.setTitle("Fluechtlinge anzeigen");
	         
	        JPanel mainPanel = new JPanel();
	        mainPanel.setLayout(new BorderLayout());
	        mainPanel.setPreferredSize(new Dimension(1750, 400));
	         
	        /*1	[dbo].[Person].[PId], 
	         *2 [dbo].[Person].[Vorname], 
	         *3	[dbo].[Person].[Nachname],
	          4	[dbo].[Fluechtling].[Original Vorname], 
	          5 [dbo].[Fluechtling].[Original Nachname],
	          6 [dbo].[Fluechtling].[Geschlecht], 
	          7 [dbo].[Fluechtling].[Geburtsdatum],
	        8	[dbo].[Person].[Tel], 
	        9	[dbo].[Person].[Handy], 
	        10	[dbo].[Person].[eMail],
	        11   [dbo].[Fluechtling].[Antragsstatus], 
	        12   [dbo].[hatEinen].[Thema]*/
	      
	        Object[] spaltenbeschriftung = {"PersonId", "Vorname", "Nachname", "Original Vorname", "Original Nachname", "Geschelcht", "Geburtsdatum", "Telefonnummer", "Handynummer", "E-Mail", "Antragsstatus", "Thema"};
	      
	        ResultSet rs = Functions.sachbearbeiterSuchtSeineFluechtlinge(DatabaseConnector.connectToDatabase("DB_PR2015_02_01", "Test123!"), 3); 
	        String[][] FDaten = new String[20][12];
	        int i =0;
	        try {
				while(rs.next()){
					
					FDaten[i][0] = rs.getString(1);
					FDaten[i][1] = rs.getString(2);
					FDaten[i][2] = rs.getString(3);
					FDaten[i][3] = rs.getString(4);
					FDaten[i][4] = rs.getString(5);
					FDaten[i][5] = rs.getString(6);
					FDaten[i][6] = rs.getString(7);
					FDaten[i][7] = rs.getString(8);
					FDaten[i][8] = rs.getString(9);
					FDaten[i][9] = rs.getString(10);
					FDaten[i][10] = rs.getString(11);
					FDaten[i][10] = rs.getString(12);
					i++;
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
		MeineFluechtlingeSehen_ScrollableJTable test = new MeineFluechtlingeSehen_ScrollableJTable();

    }
}
