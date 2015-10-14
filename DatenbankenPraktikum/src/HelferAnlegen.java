import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class HelferAnlegen extends JFrame {       /*   @pid int,
	   @eMail nvarchar(30),
	   @vorname nvarchar(25),
	   @nachname nvarchar(25),
	   @tel nvarchar(20),
	   @handy nvarchar(30),
	   @gemeinde int,
	   @adresse int,
	   @Straße nvarchar(50),
	   @PLZ int,
	   @Hausnummer nvarchar(5),
	   @AId int,
	   @Stadt nvarchar(20)*/
	                                         
	   
	 
	JLabel eMail = new JLabel();
	JLabel vorname = new JLabel();
	JLabel nachname = new JLabel();
	JLabel tel = new JLabel();
	JLabel handy = new JLabel();
	JLabel gemeinde = new JLabel();
	JLabel adresse = new JLabel();
	JLabel Straße = new JLabel();
	JLabel PLZ = new JLabel();
	JLabel Hausnummer = new JLabel();
    JLabel Stadt = new JLabel();
	 
	
	JTextField PId1 = new JTextField(null);
	JTextField eMail1 = new JTextField();
	JTextField vorname1 = new JTextField();
	JTextField nachname1 = new JTextField();
	JTextField tel1 = new JTextField();
	JTextField handy1 = new JTextField();
	JTextField gemeinde1 = new JTextField();
	JTextField adresse1 = new JTextField();
	JTextField Straße1 = new JTextField();
	JTextField PLZ1 = new JTextField();
	JTextField Hausnummer1 = new JTextField();
    JTextField Stadt1 = new JTextField();
	 
	JButton save;
	
   public HelferAnlegen(){
	   super("Helfer Anlegen");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(11,2));
		this.setLocation(600,300);
		this.setSize(2000, 2000);
	   
 
	  eMail.setText("EMail");
	  vorname.setText("Vorname");
	  nachname.setText("Nachname");
	  tel.setText("Tel");
	  handy.setText("Handy");
	  gemeinde.setText("Gemeinde");
	  adresse.setText("Adresse");
	  Straße.setText("Straße");
	  PLZ.setText("PLZ");
	  Hausnummer.setText("Hausnummer");
	  Stadt.setText("Stadt");
	  
	  
	 
	 
	  this.getContentPane().add ( vorname ) ;
	  this.getContentPane().add ( vorname1 ) ;
	  this.getContentPane().add ( nachname ) ;
	  this.getContentPane().add ( nachname1 ) ;
	  this.getContentPane().add ( tel ) ;
	  this.getContentPane().add ( tel1 ) ;
	  this.getContentPane().add (handy ) ;
	  this.getContentPane().add ( handy1 ) ;
	  this.getContentPane().add ( eMail ) ;
	  this.getContentPane().add ( eMail1 ) ;
	  this.getContentPane().add ( gemeinde ) ;
	  this.getContentPane().add ( gemeinde1 ) ;
	  this.getContentPane().add ( adresse ) ;
	  this.getContentPane().add ( adresse1 ) ;
	  this.getContentPane().add ( Stadt ) ;
	  this.getContentPane().add ( Stadt1 ) ;
	  this.getContentPane().add ( Straße ) ;
	  this.getContentPane().add ( Straße1 ) ;
	  this.getContentPane().add ( Hausnummer ) ;
	  this.getContentPane().add ( Hausnummer1 ) ;
	  this.getContentPane().add ( PLZ ) ;
	  this.getContentPane().add ( PLZ1 ) ;
	   
	  
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
	              int gemeinde2 =Integer.parseInt(gemeinde1.getText());
	              String Adresse2 =adresse1.getText();
	              String Stadt2 =Stadt1.getText();
	              String Strasse2 =Straße1.getText();
	              int PLZ2 =Integer.parseInt(PLZ1.getText());
	              String Hausnummer2 =Hausnummer1.getText();
	            
	             
	             	        
	              StoredProcedure.anlegenHelfer(DatabaseConnector.connectToDatabase("DB_PR2015_02_01", "Test123!"), email2, vorname2, nachname2, tel2, handy2, gemeinde2, Adresse2,Strasse2, PLZ2, Hausnummer2, Stadt2 );
	         }   
	     });
		 this.getContentPane().add(save);
		  pack();
	  
   }
   
   public static void main (String...args){
	   HelferAnlegen he = new HelferAnlegen();
	   he.setVisible(true);
   }
}

