import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class SpendenAnlegen extends JFrame{
	/*@SId int,
	@Name nvarchar(30),
	@Anzahl int,
	@GId int,
	@PId int,
	@eMail nvarchar(30),
	@Vorname nvarchar(25),
	@Nachname nvarchar(25),
	@Tel nvarchar(20),
	@Handy nvarchar(30)
	   */
	 
	 
	 JLabel Vorname = new JLabel();
	    JLabel Nachname = new JLabel();
	    JLabel Tel = new JLabel();
	    JLabel Handy = new JLabel();
	    JLabel eMail = new JLabel();
	    JLabel Name = new JLabel();
	    JLabel Anzahl = new JLabel();
	    JLabel Gemeinde = new JLabel();
	     
	    JTextField Vorname1 = new JTextField();
	    JTextField Nachname1 = new JTextField();
	    JTextField Tel1 = new JTextField();
	    JTextField Handy1 = new JTextField(null);
	    JTextField eMail1 = new JTextField();
	    JTextField Name1 = new JTextField(null);
	    JTextField Anzahl1 = new JTextField();
	    JTextField GId1 = new JTextField();
	     
	    JButton speichern;
	     
	    public SpendenAnlegen(String databaseUsername, String databasePassword){
	        super("Spende Anlegen");
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setLayout(new GridLayout(9,2));
	        this.setLocation(6000,3000);
	        this.setSize(400,400);
	       
	        Name.setText("Spenden Name *");
	        Anzahl.setText("Anzahl *");
	        Gemeinde.setText("Gemeinde ID *");
	        Vorname.setText("Vorname *");
	        Nachname.setText("Nachname *");
	        Tel.setText("Tel");
	        Handy.setText("Handy");
	        eMail.setText("eMail");
	       
	       
	      speichern = new JButton("Spende speichern");
	    speichern.addActionListener(new ActionListener(){
	          
	       

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				/*  @Name nvarchar(30),
	            @Anzahl int,
	            @GId int,
	             
	            @eMail nvarchar(30),
	            @Vorname nvarchar(25),
	            @Nachname nvarchar(25),
	            @Tel nvarchar(20),
	            @Handy nvarchar(30)*/
	                
	            String name = Name1.getText();
	            int anzahl = Integer.parseInt(Anzahl1.getText());
	            int gid = Integer.parseInt(GId1.getText());
	            String email = eMail1.getText();
	            String vorname = Vorname1.getText();
	            String nachname = Nachname1.getText();
	            String tel = Tel1.getText();
	            String handy = Handy1.getText();
	         
	            StoredProcedure.anlegenSpenden(DatabaseConnector.connectToDatabase(databaseUsername, databasePassword), name, anzahl, gid, email, vorname, nachname, tel, handy);

			}
	          
	    });
	       
	      this.getContentPane().add ( Name ) ;
	      this.getContentPane().add ( Name1 ) ;
	      this.getContentPane().add (Anzahl ) ;
	      this.getContentPane().add (Anzahl1);
	      this.getContentPane().add(Gemeinde);
	      this.getContentPane().add(GId1);
	      this.getContentPane().add (Vorname ) ;
	      this.getContentPane().add (Vorname1 ) ;
	      this.getContentPane().add (Nachname ) ;
	      this.getContentPane().add (Nachname1 ) ;
	      this.getContentPane().add (Tel ) ;
	      this.getContentPane().add (Tel1 ) ;
	      this.getContentPane().add ( Handy ) ;
	      this.getContentPane().add ( Handy1 ) ;
	      this.getContentPane().add (eMail ) ;
	      this.getContentPane().add (eMail1 ) ;
	      this.getContentPane().add(speichern);
	         
	      pack();
	      this.setLocationRelativeTo(null);
	      this.setVisible(true);
	    }
	    public static void main(String[] args){
	    	new SpendenAnlegen("DB_PR2015_02_03", "Test123!");
	    }
}
