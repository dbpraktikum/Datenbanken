import java.awt.BorderLayout;
 
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
 


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
 
public class MeineFluechtlingeSehen_ScrollableJTable extends javax.swing.JFrame{
	
	private int id;
	  public MeineFluechtlingeSehen_ScrollableJTable(int idx, String databaseUsername, String databasePassword) throws SQLException{
	        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
	        this.setTitle("Fluechtlinge anzeigen");
	        
	        id=idx;
	          
	        JPanel mainPanel = new JPanel();
	        mainPanel.setLayout(new BorderLayout());
	        mainPanel.setPreferredSize(new Dimension(1750, 400));
	         
	       
	        Object[] spaltenbeschriftung = {"PersonId", "Vorname", "Nachname", "Original Vorname", "Original Nachname", "Geschelcht", "Geburtsdatum", "Telefonnummer", "Handynummer", "E-Mail", "Antragsstatus", "Thema"};
	       
	        ResultSet rsLaenge = Functions.sachbearbeiterSuchtSeineFluechtlinge(DatabaseConnector.connectToDatabase(databaseUsername, databasePassword), id); 
	        int n = 0;
	        while(rsLaenge.next()){
	        	n++;
	        }
	        
	        String[][] FDaten = new String[n][12];
	        
	        ResultSet rs = Functions.sachbearbeiterSuchtSeineFluechtlinge(DatabaseConnector.connectToDatabase(databaseUsername, databasePassword), id); 
	        int i =0;
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
			    FDaten[i][11] = rs.getString(12);
			    i++;
			     
			}
	          
	        JTable table = new JTable(FDaten, spaltenbeschriftung);
	        table.setRowHeight(25);
	        table.getTableHeader().setFont(new Font("Serif", Font.BOLD, 15));
	          
	         
	        JScrollPane pane = new JScrollPane(table);
	        mainPanel.add(pane, BorderLayout.CENTER);
	          
	        JButton Fanzeigen = new JButton("Fluechtling bearbeiten");
	        Fanzeigen.addActionListener(new ActionListener(){
	              
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // TODO Auto-generated method stub
	                 int index = table.getSelectedRow();
	                 int pid = Integer.parseInt( (String) table.getValueAt(index, 0));
	                 try {
						new FluechtlingBearbeiten(pid, databaseUsername, databasePassword);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	            }
	              
	        });
	         
	         
	        mainPanel.add(Fanzeigen, BorderLayout.SOUTH);
	        this.setContentPane(mainPanel);
	        this.pack();
	        this.setLocationRelativeTo(null);
	        this.setVisible(true);
	    }
	 
}
