import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class FlüchtlingBearbeiten extends JFrame {

	JLabel eMail = new JLabel();
	JLabel Vorname = new JLabel();
	JLabel Nachname = new JLabel();
	JLabel Tel = new JLabel();
	JLabel Handy = new JLabel();
	JLabel Geschlecht = new JLabel();
	JLabel Pass = new JLabel();
	JLabel Geburtsdatum = new JLabel();
	JLabel registriert = new JLabel();
	JLabel Unterkunft = new JLabel();
	JLabel Einzugsdatum = new JLabel();
	JLabel Wunschland = new JLabel();
	JLabel OriginalNachname = new JLabel();
	JLabel OriginalVorname = new JLabel();
	JLabel Aufenhaltsland = new JLabel();
	JLabel GeburtsdatumV = new JLabel();
	JLabel Antragsstatus = new JLabel();
	JLabel kommtAus = new JLabel();
	JLabel Thema = new JLabel();
	JLabel Date = new JLabel();
	JLabel Sprache = new JLabel();
	JLabel Sprachniveau = new JLabel();
	JLabel Schreibniveau = new JLabel();
	JLabel Leseniveau = new JLabel();
	
	JLabel Bezeichnung = new JLabel();
	JLabel Art = new JLabel();
	
	
	JTextField eMail1 = new JTextField();
	JTextField vorname1 = new JTextField();
	JTextField nachname1 = new JTextField();
	JTextField tel1 = new JTextField();
	JTextField handy1 = new JTextField();
	JTextField Geschlecht1 = new JTextField();
	JTextField Pass1 = new JTextField();
	JTextField Geburtsdatum1 = new JTextField();
	JTextField registriert1 = new JTextField();
	JTextField Unterkunft1 = new JTextField();
	JTextField Einzugsdatum1 = new JTextField();
	JTextField Wunschland1 = new JTextField();
	JTextField OriginalNachname1 = new JTextField();
	JTextField OriginalVorname1 = new JTextField();
	JTextField Aufenhaltsland1 = new JTextField();
	JTextField GeburtsdatumV1 = new JTextField();
	JTextField Antragsstatus1 = new JTextField();
	JTextField kommtAus1 = new JTextField();
	JTextField Thema1 = new JTextField();
	JTextField Date1 = new JTextField();
	JTextField Sprache1 = new JTextField();
	JTextField Sprachniveau1 = new JTextField();
	JTextField Schreibniveau1 = new JTextField();
	JTextField Leseniveau1 = new JTextField();
	JTextField Bezeichnung1 = new JTextField();
	JTextField Art1 = new JTextField();
	
	JButton speichern;
	public FlüchtlingBearbeiten (int fid) throws SQLException{
		super("Flüchtling Anlegen");
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setLayout(new GridLayout(27,5));
		this.setLocation(600,300);
		this.setSize(2000, 2000);
		
	   
	  eMail.setText("E-Mail");
	  Vorname.setText("Vorname");
	  Nachname.setText("Nachname");
	  Tel.setText("Telefon");
	  Handy.setText("Handy");

	  Geschlecht.setText("Geschlecht");
	  Pass.setText("Pass");
	  Geburtsdatum.setText("Geburtsdatum");
	  registriert.setText("registriert");
	  Unterkunft.setText("Unterkunft");
	  Einzugsdatum.setText("Einzugsdatum");
	  Wunschland.setText("Wuschland");
	  OriginalNachname.setText("OriginalNachname");
	  OriginalVorname.setText("OriginalVorname");
	  Aufenhaltsland.setText("Aufenhaltsland");  
	  GeburtsdatumV.setText("GeburtsdaumV");
	  Antragsstatus.setText("Antragsstatus");
	  kommtAus.setText("kommtAus");

	  

	  ResultSet rs = Functions.sachbearbeiterSuchtSpezielleFluechtlinge(DatabaseConnector.connectToDatabase("DB_PR2015_02_01", "Test123!"), fid); 
      String[][] FDaten = new String[2][20];

      
      try {
			while(rs.next()){
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				FDaten[1][0] = rs.getString(1);
				FDaten[1][1] = rs.getString(2);
				FDaten[1][2] = rs.getString(3);
				FDaten[1][3] = rs.getString(4);
				FDaten[1][4] = rs.getString(5);
				FDaten[1][5] = rs.getString(6);
				FDaten[1][6] = rs.getString(7);
				FDaten[1][7] = rs.getString(8);
				FDaten[1][8] = rs.getString(9);
				FDaten[1][9] = rs.getString(10);
				FDaten[1][10] = rs.getString(11);
				FDaten[1][11] = rs.getString(12);
				FDaten[1][12] = rs.getString(13);
				FDaten[1][13] = rs.getString(14);
				FDaten[1][14] = rs.getString(15);
				FDaten[1][15] = rs.getString(16);
				FDaten[1][16] = rs.getString(17);
				FDaten[1][17] = rs.getString(18);
				FDaten[1][18] = rs.getString(19);
				
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	  
	  
	  
	  eMail1.setText(FDaten[1][4]);
	  vorname1.setText(FDaten[1][0]);
	  nachname1.setText(FDaten[1][1]);
	  tel1.setText(FDaten[1][2]);
	  handy1.setText(FDaten[1][3]);
	  Geschlecht1.setText(FDaten[1][7]);
	  Pass1.setText(FDaten[1][15]);
	  Geburtsdatum1.setText(FDaten[1][8]);
	  registriert1.setText(FDaten[1][18]);
	  Unterkunft1.setText(FDaten[1][12]);
	  Einzugsdatum1.setText(FDaten[1][13]);
	  Wunschland1.setText(FDaten[1][11]);
	  OriginalNachname1.setText(FDaten[1][6]);
	  OriginalVorname1.setText(FDaten[1][5]);
	  Aufenhaltsland1.setText(FDaten[1][10]);  
	  GeburtsdatumV1.setText(FDaten[1][14]);
	  Antragsstatus1.setText(FDaten[1][9]);
	  kommtAus1.setText(FDaten[1][16]);
	  
	  
	  
	  speichern = new JButton("Daten speichern");
	  
	  this.getContentPane().add ( eMail ) ;
	  this.getContentPane().add ( eMail1 ) ;
	  this.getContentPane().add ( Vorname ) ;
	  this.getContentPane().add ( vorname1 ) ;
	  this.getContentPane().add ( Nachname) ;
	  this.getContentPane().add ( nachname1 ) ;
	  this.getContentPane().add ( Tel ) ;
	  this.getContentPane().add ( tel1 ) ;
	  this.getContentPane().add ( Handy ) ;
	  this.getContentPane().add ( handy1 ) ;
	  this.getContentPane().add ( Pass ) ;
	  this.getContentPane().add ( Pass1 ) ;
	  this.getContentPane().add ( Geburtsdatum ) ;
	  this.getContentPane().add ( Geburtsdatum1 ) ;
	  this.getContentPane().add ( registriert ) ;
	  this.getContentPane().add ( registriert1 ) ;
	  this.getContentPane().add ( Unterkunft ) ;
	  this.getContentPane().add ( Unterkunft1 ) ;
	  this.getContentPane().add ( Einzugsdatum ) ;
	  this.getContentPane().add ( Einzugsdatum1 ) ;
	  this.getContentPane().add ( Wunschland ) ;
	  this.getContentPane().add ( Wunschland1 ) ;
	  this.getContentPane().add ( OriginalNachname ) ;
	  this.getContentPane().add ( OriginalNachname1 ) ;
	  this.getContentPane().add ( OriginalVorname ) ;
	  this.getContentPane().add ( OriginalVorname1 ) ;
	  this.getContentPane().add ( Aufenhaltsland ) ;
	  this.getContentPane().add ( Aufenhaltsland1 ) ;
	  this.getContentPane().add ( GeburtsdatumV ) ;
	  this.getContentPane().add ( GeburtsdatumV1 ) ;
	  this.getContentPane().add ( Antragsstatus ) ;
	  this.getContentPane().add ( Antragsstatus1 ) ;
	  this.getContentPane().add ( kommtAus ) ;
	  this.getContentPane().add ( kommtAus1 ) ;
	  this.getContentPane().add (Thema  ) ;
	  this.getContentPane().add ( Thema1 ) ;
	  this.getContentPane().add (Date  ) ;
	  this.getContentPane().add ( Date1 ) ;
	  this.getContentPane().add ( Sprache  ) ;
	  this.getContentPane().add ( Sprache1 ) ;
	  this.getContentPane().add ( Sprachniveau ) ;
	  this.getContentPane().add ( Sprachniveau1 ) ;
	  this.getContentPane().add ( Schreibniveau ) ;
	  this.getContentPane().add ( Schreibniveau1 ) ;
	  this.getContentPane().add ( Leseniveau ) ;
	  this.getContentPane().add ( Leseniveau1 ) ;

	  this.getContentPane().add ( Bezeichnung) ;
	  this.getContentPane().add ( Bezeichnung1) ;
	  this.getContentPane().add ( Art) ;
	  this.getContentPane().add (Art1) ;
	  this.getContentPane().add(speichern);
	  
	  speichern.addActionListener(new ActionListener(){
     	 
          @Override
          public void actionPerformed(ActionEvent e) {
              // TODO Auto-generated method stub
        	  String email = eMail1.getText();
              String vorname2 =vorname1.getText();
              String nachname2 =nachname1.getText();
              String tel2 = tel1.getText();
              String handy2 =handy1.getText();
              String geschlecht2 =Geschlecht1.getText();
              String pass2 =Pass1.getText();
              String gebDatum2 =Geburtsdatum1.getText();
              int registriert2 =Integer.parseInt(registriert1.getText());
              int unterkunft2 =Integer.parseInt(Unterkunft1.getText());
              String einzugsdatum2 =Einzugsdatum1.getText();
              String wunschland2 =Wunschland1.getText();
              String orginalNachname2 =OriginalNachname1.getText();
              String orginalVorname2 =OriginalVorname1.getText();
              String aufenthalt2 =Aufenhaltsland1.getText();
              String gebdatValidiert2 =OriginalVorname1.getText();
              String antragstatus2 =OriginalVorname1.getText();
              String originalvorname2 =OriginalVorname1.getText();
             
              int KommtAus2 =Integer.parseInt(kommtAus1.getText());
          
          /*
           * hier muss noch der richtige Befehl him damit updateFlüchtling 
           * aufgerufen wird. Variablen die übergegeben werden sollten schon stimmen
           */
           //   StoredProcedure.updateGesFluechtling(DatabaseConnector.connectToDatabase("DB_PR2015_02_01", "Test123!"), fid, email, vorname2, nachname2, tel2, handy2, geschlecht2, pass2, gebDatum2, registriert2, unterkunft2, einzugsdatum2, wunschland2, orginalNachname2, orginalVorname2, aufenthalt2, gebdatValidiert2, antragstatus2, KommtAus2);
          }
           
      });

	}
	public static void main (String...args) throws SQLException{
		   FlüchtlingBearbeiten fb = new FlüchtlingBearbeiten(5);
		   fb.setVisible(true);
	   }

}
