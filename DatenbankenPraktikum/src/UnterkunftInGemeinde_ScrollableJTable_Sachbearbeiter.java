import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;



public class UnterkunftInGemeinde_ScrollableJTable_Sachbearbeiter extends javax.swing.JFrame{	
	
	public UnterkunftInGemeinde_ScrollableJTable_Sachbearbeiter(String gemeindeId, String gemeindeName, String databaseUsername, String databasePassword) throws SQLException{
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setTitle("Unterkuenfte in der Gemeinde " + gemeindeName);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setPreferredSize(new Dimension(1000, 400));
        
        int n = 0;
        ResultSet testLaenge = Functions.unterkuenfteInGemeinde(DatabaseConnector.connectToDatabase(databaseUsername, databasePassword), gemeindeId);
        
        while(testLaenge.next()){
			n++;
		}

        
        /*
         * UId, Straﬂe, Hausnummer, PLZ, Stadt, Kapazit‰t, Anzahl-F, Vorname Vorsteher, Nachname Vorsteher, Tel, Handy, eMail
         */
        
        String[] spaltenbeschriftung = {"UId", "PLZ", "Stadt", "Straﬂe", "Hausnummer", "Kapazitaet", "Anzahl Fluechtlinge", "Vorsteher - Vorname", "Vorsteher - Nachname"};
        
        String[][] GDaten = new String[n][spaltenbeschriftung.length];
        
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
        
         
        table.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton() == 3){
					try {
						new FluechtlingeInUnterkunft_ScrollableJTable(Integer.parseInt("" + table.getValueAt(table.rowAtPoint(e.getPoint()),0)), databaseUsername, databasePassword);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						System.out.println("Klasse: UnterkunftInGemeinde_ScrollableJTable_Sachbearbeiter - FluechtlingeInGemeinde_ScrollableJTable()");
						e1.printStackTrace();
					}
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
        	
        });
        
        
        
        this.setContentPane(mainPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
	}
	
}
