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



public class Gemeinde_ScrollableJTable extends javax.swing.JFrame{
	
	private final String databaseUsername = "DB_Pr2015_02_01";
	private final String databasePassword = "Test123!";
	
	
	public Gemeinde_ScrollableJTable(String kreis) throws SQLException{
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setTitle("Gemeinden im Kreis " + kreis);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setPreferredSize(new Dimension(1000, 400));
        
        int n = 0;
        ResultSet testLaenge = Functions.gemeindenImKreis(DatabaseConnector.connectToDatabase(databaseUsername, databasePassword), kreis);
        
        while(testLaenge.next()){
			n++;
		}

        String[] spaltenbeschriftung = {"GId", "Name", "Einwohner", "Geodaten"};
        
        String[][] GDaten = new String[n][4];
        
        ResultSet rs = Functions.gemeindenImKreis(DatabaseConnector.connectToDatabase(databaseUsername, databasePassword), kreis);
        
        int index = 0;
		while (rs.next()) {
			GDaten[index][0] = rs.getString(1);
			GDaten[index][1] = rs.getString(2);
			GDaten[index][2] = rs.getString(3);
			GDaten[index][3] = rs.getString(4);
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
				//if(e.getButton() == 1){
				//System.out.println("1 - Linksklick");
				try {
					new UnterkunftInGemeinde_ScrollableJTable("" + table.getValueAt(table.rowAtPoint(e.getPoint()),0), "" + table.getValueAt(table.rowAtPoint(e.getPoint()),1), databaseUsername, databasePassword);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.out.println("Klasse: Gemeinde_ScrollableJTable - UnterkunftInGemeinde_ScrollableJTable()");
					e1.printStackTrace();
				}
				//}
				/*if(e.getButton() == 3){
					System.out.println("3 - Rechtsklick");
					try {
						new FluechtlingeInGemeinde_ScrollableJTable("" + table.getValueAt(table.rowAtPoint(e.getPoint()),0), "" + table.getValueAt(table.rowAtPoint(e.getPoint()),1));
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						System.out.println("Klasse: Gemeinde_ScrollableJTable - FluechtlingeInGemeinde_ScrollableJTable()");
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
        
        
        
        
        
        this.setContentPane(mainPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
	}
	
	public static void main(String[] args) {
		try {
			Gemeinde_ScrollableJTable test = new Gemeinde_ScrollableJTable("Alzey-Worms");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
}
