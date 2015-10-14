
	

 
import java.awt.BorderLayout;

 
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
 
 
public class AngeboteAnzeigen extends JFrame {
	
	private JLabel SprachkurseL;
	private JLabel AnderekurseL;
	
    private final String databaseUsername = "DB_PR2015_02_01";
	private final String databasePassword = "Test123!";
    private JLabel ueberschrift1;
    private JLabel ueberschrift2;
     

 
    public AngeboteAnzeigen() throws SQLException {
        super("Angebote der Gemeinde");
        //setLocation(500, 500);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        ResultSet rs = Functions.angeboteSehenSprachkurse(DatabaseConnector.connectToDatabase(databaseUsername, databasePassword), 1); 

        Object ADatenS[][] = new String[20][11];
        int i =0;
        while(rs.next()){
        	
			ADatenS[i][0] = rs.getString(1);
			ADatenS[i][1] = rs.getString(3);
			ADatenS[i][2] = rs.getString(8);
			ADatenS[i][3] = rs.getString(5);
			ADatenS[i][4] = rs.getString(6);
			ADatenS[i][5] = rs.getString(4);
			ADatenS[i][6] = rs.getString(2);
			ADatenS[i][7] = rs.getString(9);
			ADatenS[i][8] = rs.getString(11);
			ADatenS[i][9] = rs.getString(10);
			ADatenS[i][10] = rs.getString(12);
			
        }
        
        ResultSet rs2 = Functions.angeboteSehenAndere(DatabaseConnector.connectToDatabase(databaseUsername, databasePassword), 1); 
        Object ADatenA[][] = new String[20][8];
        int j = 0;
        while(rs2.next()){
        	ADatenA[i][0] = rs2.getString(1);
			ADatenA[i][1] = rs2.getString(3);
			ADatenA[i][2] = rs2.getString(8);
			ADatenA[i][3] = rs2.getString(5);
			ADatenA[i][4] = rs2.getString(6);
			ADatenA[i][5] = rs2.getString(4);
			ADatenA[i][6] = rs2.getString(2);
			ADatenA[i][7] = rs2.getString(9);
        }
        
        
        	ueberschrift1 = new JLabel("Sprachkursangebote");
        	ueberschrift2 = new JLabel("Andere Kursangebote");
            Object sprachColumns[] = {"Angebotsnummer","Name","Wochentag","Zeit","Ort","max. Belegung","Kontaktnummer","fuer Sprachniveau","f�r Leseniveau","f�r Schreibniveau","Beschreibung"};
            Object andereColumns[] = {"Angebotsnummer","Name","Wochentag","Zeit","Ort","max. Belegung","Kontaktnummer","Beschreibung"};
            		
            JTable sprach = new JTable(ADatenS,sprachColumns);
            JTable andere = new JTable(ADatenA,andereColumns);
            
            JScrollPane sprachScroll = new JScrollPane(sprach);
            JScrollPane andereScroll = new JScrollPane(andere);
            
            JPanel sprachkurseP = new JPanel();
            sprachkurseP.setLayout(new BorderLayout());
            sprachkurseP.add(ueberschrift1, BorderLayout.NORTH);
            sprachkurseP.add(sprachScroll, BorderLayout.SOUTH);
            JPanel anderekurseP = new JPanel();
            anderekurseP.setLayout(new BorderLayout());
            anderekurseP.add(ueberschrift2, BorderLayout.NORTH);
            anderekurseP.add(andereScroll, BorderLayout.SOUTH);
            
            JPanel pan = new JPanel();
            pan.setLayout(new BorderLayout());
            pan.add(sprachkurseP, BorderLayout.NORTH);
            pan.add(anderekurseP, BorderLayout.SOUTH);
            
            JScrollPane scroll = new JScrollPane(pan);
            this.add(scroll, BorderLayout.CENTER);
 
            this.setVisible(true);
    
    
             
            pack();
             
            this.setSize(1500, 500);
            this.setLocationRelativeTo(null);
     
             
        }
         
        
     
    
 
    public static void main(String[] args) throws SQLException {
        AngeboteAnzeigen bl = new AngeboteAnzeigen();
        bl.setVisible(true);
    }
 


}
