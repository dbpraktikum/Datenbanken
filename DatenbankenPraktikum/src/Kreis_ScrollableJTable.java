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


public class Kreis_ScrollableJTable extends javax.swing.JFrame{
	
	private final String databaseUsername;
	private final String databasePassword;
	
	public Kreis_ScrollableJTable(String bundesland, String databaseUsername, String databasePassword) throws SQLException{
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setTitle("Kreise im Bundesland " + bundesland);
        this.databaseUsername = databaseUsername;
        this.databasePassword = databasePassword;
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setPreferredSize(new Dimension(1000, 400));
        
        int n = 0;
        ResultSet testLaenge = Functions.kreiseImBundesland(DatabaseConnector.connectToDatabase(databaseUsername, databasePassword), bundesland);
        
        while(testLaenge.next()){
			n++;
		}
        
        String[] spaltenbeschriftung = {"Name", "Aufnahme%", "Anzahl Flüchtlinge"};
        
        ResultSet rs = Functions.kreiseImBundesland(DatabaseConnector.connectToDatabase(databaseUsername, databasePassword), bundesland);
        String[][] KDaten = new String[n][3];
        
		/*for(int i = 0; i < KDaten.length; i++){
			for(int j = 0; j < KDaten[i].length; j++){
				KDaten[i][j] = "Kreis " + i + " " + j;
			}
		}*/
		
		int index = 0;
		while(rs.next()){
			KDaten[index][0] = rs.getString(1);
			KDaten[index][1] = rs.getString(2);
			KDaten[index][2] = rs.getString(3);
			index++;
		}
        
		
        JTable table = new JTable(KDaten, spaltenbeschriftung);
        table.setRowHeight(25);
        table.getTableHeader().setFont(new Font("Serif", Font.BOLD, 15));
        
        
        table.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				//if(e.getButton() == 1){
					//System.out.println("1 - Linksklick");
					try {
						new Gemeinde_ScrollableJTable("" + table.getValueAt(table.rowAtPoint(e.getPoint()),0));
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						System.out.println("Klasse: Kreis_ScrollableJTable - Gemeinde_ScrollableJTable()");
						e1.printStackTrace();
					}
				//}
				/*if(e.getButton() == 3){
					System.out.println("3 - Rechtsklick");
					try {
						new FluechtlingeInKreis_ScrollableJTable("" + table.getValueAt(table.rowAtPoint(e.getPoint()),0));
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						System.out.println("Klasse: Kreis_ScrollableJTable - FluechtlingeInKreis_ScrollableJTable()");
						e1.printStackTrace();
					}
				}*/
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
