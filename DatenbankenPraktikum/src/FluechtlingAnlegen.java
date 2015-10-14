import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.*;


public class FluechtlingAnlegen extends JFrame {
	
	JLabel eMail = new JLabel();
	JLabel vorname = new JLabel();
	JLabel nachname = new JLabel();
	JLabel tel = new JLabel();
	JLabel handy = new JLabel();
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
	
	JButton save;

   public FluechtlingAnlegen(){
	   super("Flüchtling Anlegen");
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setLayout(new GridLayout(27,5));
		this.setLocation(600,300);
		this.setSize(2000, 2000);
		
	   
	  eMail.setText("E-Mail");
	  vorname.setText("Vorname");
	  nachname.setText("Nachname");
	  tel.setText("Telefon");
	  handy.setText("Handy");

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
	  Thema.setText("Thema");
	  Date.setText("Date");
	  Sprache.setText("Sprache");
	  Sprachniveau.setText("Sprachniveau");
	  Schreibniveau.setText("Schreibniveau");
	  Leseniveau.setText("Leseniveau");
	  Bezeichnung.setText("Bezeichnung");
	  Art.setText("Art");
	  
	  this.getContentPane().add ( eMail ) ;
	  this.getContentPane().add ( eMail1 ) ;
	  this.getContentPane().add ( vorname ) ;
	  this.getContentPane().add ( vorname1 ) ;
	  this.getContentPane().add ( nachname) ;
	  this.getContentPane().add ( nachname1 ) ;
	  this.getContentPane().add ( tel ) ;
	  this.getContentPane().add ( tel1 ) ;
	  this.getContentPane().add ( handy ) ;
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
	  
	  
	  save = new JButton("Fluechtling speichern");
	 save.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent arg0) {
             // TODO Auto-generated method stub
        	 DateFormat df = new SimpleDateFormat("E MM dd kk:mm:ss z yyyy"); 
        	 
              String email = eMail1.getText();
              String vorname2 =vorname1.getText();
              String nachname2 =nachname1.getText();
              String tel2 = tel1.getText();
              String handy2 =handy1.getText();
              String geschlecht2 =Geschlecht1.getText();
              String passExistiert2 =Pass1.getText();
              Date gebDatum2 = null;
			try {
				gebDatum2 = (java.sql.Date) df.parse(Geburtsdatum1.getText());
			} catch (ParseException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
              String registriert2 =registriert1.getText();
              int unterkunft2 =Integer.parseInt(Unterkunft1.getText());
              
              Date einzugsdatum2 = null;
			try {
				einzugsdatum2 = (java.sql.Date)df.parse(Einzugsdatum1.getText());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
              String wunschland2 =Wunschland1.getText();
              String orginalNachname2 =OriginalNachname1.getText();
              String orginalVorname2 =OriginalVorname1.getText();
              String aufenthalt2 =Aufenhaltsland1.getText();
              String gebdatValidiert2 =OriginalVorname1.getText();    /* 	String email, String vorname, String nachname, String tel,
		                                                               	String handy, String geschlecht, String passExistiert,
		                                                                 	Date gebDatum, String registriert, int unterkunft,
			                                                            Date einzugsdatum, String wunschland, String orginalNachname,
			                                                             String orginalVorname, String aufenthalt, String gebdatValidiert,
			                                                          String antragstatus, String kommtAus, int sid, String thema,
			                                                           Date date, String sprache, String sprachniveau,
			                                                            String schreibniveau, String leseniveau,
			                                                              String bezeichnung, String art) {*/
              String antragstatus2 =OriginalVorname1.getText();
              String originalvorname2 =OriginalVorname1.getText();
              int sid2=3;
              String thema2 =Thema1.getText();
              
              Date date2=null;
			try {
				date2 = (java.sql.Date)df.parse(Date1.getText());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
              String sprache2 =Sprache1.getText();
              String sprachniveau2 =Sprachniveau1.getText();
              String schreibniveau2 =Schreibniveau1.getText();
              String  lesenivau2 =Leseniveau1.getText();
             
              String bezeichnung2 =Bezeichnung1.getText();
              String art2 =Art1.getText();
              String KommtAus2 =kommtAus1.getText();
        
              StoredProcedure.anlegenFluechtling(DatabaseConnector.connectToDatabase("DB_PR2015_02_01", "Test123!"), email, vorname2, nachname2,
            		  tel2, handy2, geschlecht2, passExistiert2, gebDatum2, registriert2, unterkunft2, einzugsdatum2, wunschland2, 
            		  orginalNachname2,
            		  orginalVorname2, aufenthalt2, gebdatValidiert2, antragstatus2, KommtAus2, sid2, thema2, date2, sprache2, 
            		  sprachniveau2, schreibniveau2,
            		  lesenivau2, bezeichnung2, art2);
         }   
     });
	 this.getContentPane().add(save);
	  pack();
   }
   
   public static void main (String...args){
	   FluechtlingAnlegen fa = new FluechtlingAnlegen();
	   fa.setVisible(true);
   }
}


