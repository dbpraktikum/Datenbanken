import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;



public class VorsteherVonHelfer extends javax.swing.JFrame{	
	
	public VorsteherVonHelfer(int helferId, String databaseUsername, String databasePassword) throws SQLException{
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setTitle("Vorsteher");
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setPreferredSize(new Dimension(1000, 400));
        
        int n = 0;
        ResultSet testLaenge = Functions.anzeigenVorsteherVonHelfer(DatabaseConnector.connectToDatabase(databaseUsername, databasePassword), helferId);
        
        while(testLaenge.next()){
			n++;
		}

        
        /*
         * UId, Straﬂe, Hausnummer, PLZ, Stadt, Kapazit‰t, Anzahl-F, Vorname Vorsteher, Nachname Vorsteher, Tel, Handy, eMail
         */
        
        String[] spaltenbeschriftung = {"UId", "Vorname", "Nachname", "Telefonnummer", "Handynummer", "Email"};
        
        String[][] GDaten = new String[n][spaltenbeschriftung.length];
        
        ResultSet rs = Functions.anzeigenVorsteherVonHelfer(DatabaseConnector.connectToDatabase(databaseUsername, databasePassword), helferId);
        
        int index = 0;
		while (rs.next()) {
			GDaten[index][0] = rs.getString(1);
			GDaten[index][1] = rs.getString(2);
			GDaten[index][2] = rs.getString(3);
			GDaten[index][3] = rs.getString(4);
			GDaten[index][4] = rs.getString(5);
			GDaten[index][5] = rs.getString(6);
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
