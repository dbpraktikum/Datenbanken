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
 
	JLabel Unterkunft = new JLabel();
	JLabel Einzugsdatum = new JLabel();
	JLabel Wunschland = new JLabel();
	JLabel OriginalNachname = new JLabel();
	JLabel OriginalVorname = new JLabel();
	JLabel Aufenhaltsland = new JLabel();
	JLabel GeburtsdatumV = new JLabel();
	JLabel antragstatus = new JLabel();
	 
	JLabel Thema = new JLabel();
	JLabel Date = new JLabel();
	JLabel Sprache = new JLabel();
	JLabel Sprachniveau = new JLabel();
	JLabel Schreibniveau = new JLabel();
	JLabel Leseniveau = new JLabel();
	
	JLabel Bezeichnung = new JLabel();
	JLabel Art = new JLabel();
	JLabel lat = new JLabel();
	JLabel lonG = new JLabel();
	JLabel latr = new JLabel();
	JLabel longr = new JLabel();
	JLabel staat = new JLabel();
	JLabel stadt = new JLabel();
	JLabel staatreg = new JLabel();
	JLabel stadtreg = new JLabel();                                
	
	JTextField eMail1 = new JTextField();
	JTextField vorname1 = new JTextField();
	JTextField nachname1 = new JTextField();
	JTextField tel1 = new JTextField();
	JTextField handy1 = new JTextField();
	JTextField Geschlecht1 = new JTextField();
	JTextField Pass1 = new JTextField();
	JTextField Geburtsdatum1 = new JTextField();
	 
	JTextField Unterkunft1 = new JTextField();
	JTextField Einzugsdatum1 = new JTextField();
	JTextField Wunschland1 = new JTextField();
	JTextField OriginalNachname1 = new JTextField();
	JTextField OriginalVorname1 = new JTextField();
	JTextField Aufenhaltsland1 = new JTextField();
	JTextField GeburtsdatumV1 = new JTextField();
	JTextField antragstatus1 = new JTextField();
 
	JTextField Thema1 = new JTextField();
	JTextField Date1 = new JTextField();
	JTextField Sprache1 = new JTextField();
	JTextField Sprachniveau1 = new JTextField();
	JTextField Schreibniveau1 = new JTextField();
	JTextField Leseniveau1 = new JTextField();
	JTextField Bezeichnung1 = new JTextField();
	JTextField Art1 = new JTextField();
	JTextField lat1 = new JTextField();
	JTextField lonG1 = new JTextField();
	JTextField latr1 = new JTextField();
	JTextField longr1 = new JTextField();
	JTextField staat1 = new JTextField();
	JTextField stadt1 = new JTextField();
	JTextField staatreg1 = new JTextField();
	JTextField stadtreg1 = new JTextField();
	
	JButton save;

   public FluechtlingAnlegen(){
	   super("Flüchtling Anlegen");
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setLayout(new GridLayout(36,5));
		this.setLocation(500,0);
		this.setSize(2000, 2000);
		
	   
	  eMail.setText("E-Mail");
	  vorname.setText("Vorname");
	  nachname.setText("Nachname");
	  tel.setText("Telefon");
	  handy.setText("Handy");

	  Geschlecht.setText("Geschlecht (m/w/u)");
	  Pass.setText("Pass (ja/nein)");
	  Geburtsdatum.setText("Geburtsdatum yyyy-mm-tt");
	  
	  Unterkunft.setText("Unterkunft (Id)");
	  Einzugsdatum.setText("Einzugsdatum");
	  Wunschland.setText("Wuschland");
	  OriginalNachname.setText("OriginalNachname");
	  OriginalVorname.setText("OriginalVorname");
	  Aufenhaltsland.setText("Aufenhaltsland");  
	  GeburtsdatumV.setText("Geburtsdaum bestätigt (j/n)");
	  antragstatus.setText("Antragsstatus");
	 
	  Thema.setText("Thema");
	  Date.setText("Date yyyy-mm-tt");
	  Sprache.setText("Sprache");
	  Sprachniveau.setText("Sprachniveau  (schlecht,ausreichend,gut,fließend)");
	  Schreibniveau.setText("Schreibniveau  (schlecht,ausreichend,gut,fließend)");
	  Leseniveau.setText("Leseniveau  (schlecht,ausreichend,gut,fließend)");
	  Bezeichnung.setText("Bezeichnung");
	  Art.setText("Art");
	  lat.setText("breitengrad herkunft");
	  lonG.setText("längengrad herkunft");
	  latr.setText("breitengrad registration");
	  longr.setText("längengrad registration");
	  staat.setText("staat herkunft");
	  stadt.setText("stadt herkunft");
	  staatreg.setText("staat reg");
	  stadtreg.setText("stadt reg");
	  
	 

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
	   this.getContentPane().add(Geschlecht);
	   this.getContentPane().add(Geschlecht1);
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
	  this.getContentPane().add ( antragstatus ) ;
	  this.getContentPane().add ( antragstatus1 ) ;
	 
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
	  this.getContentPane().add ( lat) ;
	  this.getContentPane().add ( lat1) ;
	  this.getContentPane().add ( lonG) ;
	  this.getContentPane().add (lonG1) ;
	  this.getContentPane().add ( latr) ;
	  this.getContentPane().add ( latr1) ;
	  this.getContentPane().add ( longr) ;
	  this.getContentPane().add (longr1) ;
	  this.getContentPane().add ( staat) ;
	  this.getContentPane().add ( staat1) ;
	  this.getContentPane().add ( stadt) ;
	  this.getContentPane().add (stadt1) ;
	  this.getContentPane().add ( staatreg) ;
	  this.getContentPane().add ( staatreg1) ;
	  this.getContentPane().add ( stadtreg) ;
	  this.getContentPane().add (stadtreg1) ;
	  
	  
	  
	
	  
	  
	  save = new JButton("Fluechtling speichern");
	 save.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent arg0) {
             // TODO Auto-generated method stub
        	         	 
              String email2 = eMail1.getText();
              String vorname2 =vorname1.getText();
              String nachname2 =nachname1.getText();
              String tel2 = tel1.getText();
              String handy2 =handy1.getText();
              String geschlecht2 =Geschlecht1.getText();
              String passExistiert2 =Pass1.getText();
           
              String gebDatum2 = Geburtsdatum1.getText();
			//gebDatum2 =java.sql.Date.valueOf(Geburtsdatum1.getText());
              int unterkunft2 =Integer.parseInt(Unterkunft1.getText());
              
              
              String einzugsdatum2 = Einzugsdatum1.getText();
		//	einzugsdatum2 = java.sql.Date.valueOf(Einzugsdatum1.getText());
              String wunschland2 =Wunschland1.getText();
              String originalNachname2 =OriginalNachname1.getText();
              String originalVorname2 =OriginalVorname1.getText();
              String aufenthalt2 =Aufenhaltsland1.getText();
              String gebdatValidiert2 =GeburtsdatumV1.getText();    /* 	String email, String vorname, String nachname, String tel,
		                                                               	String handy, String geschlecht, String passExistiert,
		                                                                 	Date gebDatum, String registriert, int unterkunft,
			                                                            Date einzugsdatum, String wunschland, String orginalNachname,
			                                                             String orginalVorname, String aufenthalt, String gebdatValidiert,
			                                                          String antragstatus, String kommtAus, int sid, String thema,
			                                                           Date date, String sprache, String sprachniveau,
			                                                            String schreibniveau, String leseniveau,
			                                                              String bezeichnung, String art) {*/
              String antragstatus2 =antragstatus1.getText();
              
              int sid2=3;
              String thema2 =Thema1.getText();
              
              String date2=Date1.getText();
			//date2 = java.sql.Date.valueOf(Date1.getText());
              String sprache2 =Sprache1.getText();
              String sprachniveau2 =Sprachniveau1.getText();
              String schreibniveau2 =Schreibniveau1.getText();
              String  lesenivau2 =Leseniveau1.getText();
             
              String bezeichnung2 =Bezeichnung1.getText();
              String art2 =Art1.getText();
            
              String lat2=lat1.getText();
              String lonG2=lonG1.getText();
              String latr2=latr1.getText();
              String longr2=longr1.getText();
              String staat2=staat1.getText();
              String stadt2=stadt1.getText();
              String staatreg2=staatreg1.getText();
              String stadtreg2=stadtreg1.getText();
              /*  float lat, float lonG, float latr,
              float longr, String staat, String stadt, String staatreg, String stadtreg*/
        
              StoredProcedure.anlegenFluechtling(DatabaseConnector.connectToDatabase("DB_PR2015_02_01", "Test123!"), email2, vorname2, nachname2,
            		  tel2, handy2, geschlecht2, passExistiert2, gebDatum2,   unterkunft2, einzugsdatum2, wunschland2, 
            		  originalNachname2,
            		  originalVorname2, aufenthalt2, gebdatValidiert2, antragstatus2, sid2, thema2, date2, sprache2, 
            		  sprachniveau2, schreibniveau2,
            		  lesenivau2, bezeichnung2, art2,lat2,lonG2,latr2,longr2,staat2,stadt2,staatreg2,stadtreg2);
         }   
     });
	 this.getContentPane().add(save);
	  pack();
   }
   /* String email,
	            String vorname, String nachname, String tel, String handy,
	            String geschlecht, String passExistiert, Date gebDatum,
	              int unterkunft, Date einzugsdatum,
	            String wunschland, String originalNachname, String originalVorname,
	            String aufenthalt, String gebdatValidiert, String antragstatus,
	             int sid, String thema, Date date, String sprache,
	            String sprachniveau, String schreibniveau, String leseniveau,
	            String bezeichnung, String art, float lat, float lonG, float latr,
	            float longr, String staat, String stadt, String staatreg, String stadtreg*/
   
   public static void main (String...args){
	   FluechtlingAnlegen fa = new FluechtlingAnlegen();
	   fa.setVisible(true);
   }
}


