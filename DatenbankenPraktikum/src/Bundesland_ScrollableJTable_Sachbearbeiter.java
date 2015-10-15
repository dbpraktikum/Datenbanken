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


public class Bundesland_ScrollableJTable_Sachbearbeiter extends javax.swing.JFrame{
	
	
	public Bundesland_ScrollableJTable_Sachbearbeiter(String databaseUsername, String databasePassword) throws SQLException{
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setTitle("Bundeslaender anzeigen");
        
        int n = 0;
        ResultSet testLaenge = Functions.alleBundeslaenderSehen(DatabaseConnector.connectToDatabase(databaseUsername, databasePassword));
        
        while(testLaenge.next()){
			n++;
		}
        
        ResultSet rs = Functions.alleBundeslaenderSehen(DatabaseConnector.connectToDatabase(databaseUsername, databasePassword));
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setPreferredSize(new Dimension(1000, 400));
        
        String[] spaltenbeschriftung = {"Name", "Anzahl Fluechtlinge", "Aufnahme%"};
        
        String[][] BDaten = new String[n][3];
		
		int index = 0;
		while (rs.next()) {
			BDaten[index][0] = rs.getString(1);
			BDaten[index][1] = rs.getString(2);
			BDaten[index][2] = rs.getString(3);
			index++;
		}
		
        JTable table = new JTable(BDaten, spaltenbeschriftung);
        table.setRowHeight(25);
        table.getTableHeader().setFont(new Font("Serif", Font.BOLD, 15));
        
        
        table.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton() == 1){
					try {
						new Kreis_ScrollableJTable_Sachbearbeiter("" + table.getValueAt(table.rowAtPoint(e.getPoint()),0), databaseUsername, databasePassword);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						System.out.println("Klasse: Bundesland_ScrollableJTable - Kreis_ScrollableJTable()");
						e1.printStackTrace();
					}
				}
				if(e.getButton() == 3){
					try {
						new FluechtlingeInBundesland_ScrollableJTable("" + table.getValueAt(table.rowAtPoint(e.getPoint()),0),databaseUsername, databasePassword);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						System.out.println("Klasse: Bundesland_ScrollableJTable - FluechtlingeInBundesland_ScrollableJTable()");
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
        
        
        
        JScrollPane pane = new JScrollPane(table);
        mainPanel.add(pane, BorderLayout.CENTER);
        
                
        
        
        this.setContentPane(mainPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
	}
	
}
