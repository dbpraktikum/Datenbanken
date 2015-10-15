import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class SachbearbeiterAnlegen extends JFrame { 
	
	 JLabel Strasse = new JLabel();
	    JLabel PLZ = new JLabel();
	    JLabel Hausnummer = new JLabel();
	    JLabel Gemeinde = new JLabel();
	    JLabel Bundesland = new JLabel();
	    JLabel Kreis = new JLabel();
	    JLabel Stadt = new JLabel();
	     
	    JLabel email = new JLabel();
	    JLabel Vorname = new JLabel();
	    JLabel Nachname = new JLabel();
	    JLabel Tel = new JLabel();
	    JLabel Handy = new JLabel();
	     
	    JLabel GId = new JLabel();
	    JLabel aktiv = new JLabel();
	    JLabel Ebene = new JLabel();
	      
	     
	    JTextField Strasse1 = new JTextField();
	    JTextField PLZ1 = new JTextField();
	    JTextField Hausnummer1 = new JTextField();
	
	    JTextField Bundesland1 = new JTextField();
	    JTextField Kreis1 = new JTextField();
	     
	    JTextField Stadt1 = new JTextField();
	     
	    JTextField email1 = new JTextField();
	    JTextField Vorname1 = new JTextField();
	    JTextField Nachname1 = new JTextField();
	    JTextField Tel1 = new JTextField();
	    JTextField Handy1 = new JTextField();
	     
	    JTextField GId1 = new JTextField();
	    JTextField aktiv1 = new JTextField();
	    JTextField Ebene1 = new JTextField();
	  
	 
	    JButton save;
	   public SachbearbeiterAnlegen(){
	       super("Sachbearbeiter Anlegen");
	        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	        this.setLayout(new GridLayout(16,2));
	        this.setLocation(600,300);
	        this.setSize(400,400);
	        
	      Strasse.setText("Strasse * ");
	      PLZ.setText("PLZ * ");
	      Hausnummer.setText("Hausnummer * ");
	      
	      Stadt.setText("Stadt * ");
	       
	      email.setText("EMail * ");
	      Vorname.setText("Vorname * ");
	      Nachname.setText("Nachname * ");
	      Tel.setText("Tel * ");
	      Handy.setText("Handy");
	         
	      GId.setText("arbeitet in Gemeinde (ID) * ");
	      Bundesland.setText("oder Bundesland (Name)");
	      Kreis.setText("oder Kreis (Name)");
	      
	      aktiv.setText("activ * ");
	      Ebene.setText("Ebene * ");
	      
	       
	      save = new JButton("Sachbearbeiter speichern");
	       
	 
	      this.getContentPane().add (Vorname ) ;
	      this.getContentPane().add (Vorname1 ) ;
	      this.getContentPane().add (Nachname ) ;
	      this.getContentPane().add (Nachname1 ) ;
	      this.getContentPane().add ( Stadt ) ;
	      this.getContentPane().add ( Stadt1 ) ;
	      this.getContentPane().add ( Strasse ) ;
	      this.getContentPane().add ( Strasse1 ) ;
	      this.getContentPane().add ( Hausnummer ) ;
	      this.getContentPane().add ( Hausnummer1 ) ;
	      this.getContentPane().add ( PLZ ) ;
	      this.getContentPane().add ( PLZ1 ) ;
	      this.getContentPane().add ( Tel ) ;
	      this.getContentPane().add ( Tel1 ) ;
	      this.getContentPane().add ( Handy ) ;
	      this.getContentPane().add ( Handy1 ) ;
	      this.getContentPane().add ( GId ) ;
	      this.getContentPane().add ( GId1 ) ;
	      this.getContentPane().add ( Kreis ) ;
	      this.getContentPane().add ( Kreis1 ) ;
	      this.getContentPane().add ( Bundesland ) ;
	      this.getContentPane().add ( Bundesland1 ) ; 
	      this.getContentPane().add ( email ) ;
	      this.getContentPane().add ( email1 ) ;
	      this.getContentPane().add (aktiv ) ;
	      this.getContentPane().add (aktiv1) ;
	      this.getContentPane().add (Ebene ) ;
	      this.getContentPane().add (Ebene1) ;
	      this.getContentPane().add(save);
	       
	       
	      save.addActionListener(new ActionListener(){
	             @Override
	             public void actionPerformed(ActionEvent arg0) {
	                 // TODO Auto-generated method stub
	 
	                  String strasse = Strasse1.getText();
	                  int plz =Integer.parseInt(PLZ1.getText());
	                  String hausnummer =Hausnummer1.getText();
	                  String stadt = Stadt1.getText();
	                  String email2 =email1.getText();
	                  String vorname =Vorname1.getText();
	                  String nachname =Nachname1.getText();
	                  String tel =Tel1.getText();
	                  String handy =Handy1.getText();
	                  if(GId1.getText() == "")
	                	  GId1.setText("0");
	                  
	                int gid = Integer.parseInt(GId1.getText());
	                  String kreis = Kreis1.getText();
	                  String bundesland = Bundesland1.getText();
	               
	                  String aktiv=aktiv1.getText();
	                  String ebene =Ebene1.getText();
	                  /*   String email,
			String vorname, String nachname, String tel, String handy,
			int gemeinde, String aktiv, String strasse, int plz,
			String hausnummer, String stadt, String ebene, String kreis, String bundesland*/
	             
	                  StoredProcedure.anlegenSacharbeiter(DatabaseConnector.connectToDatabase("DB_PR2015_02_01", "Test123!"),email2,  vorname, nachname, tel, handy,
	                		   gid, aktiv, strasse, plz, hausnummer,
	                		  stadt,  ebene, kreis, bundesland );
	             }   
	         });
	      
	      pack();
		  this.setVisible(true);
	   }
	    
	   public static void main (String...args){
	       SachbearbeiterAnlegen sa = new SachbearbeiterAnlegen();
	       sa.setVisible(true);
	   }
	 


}
