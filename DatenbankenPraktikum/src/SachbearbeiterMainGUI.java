
 
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import java.sql.SQLException;

import javax.swing.*;
 
 
public class SachbearbeiterMainGUI extends JFrame{
    private JButton Fl�chtlingAnlegen;
    private JButton HelferAnlegen;
    private JButton SachbearbeiterAnlegen;
    private JButton UnterkunftAnlegen;
    private JButton MeineFl�chtlingeSehen;
    private JButton AngeboteAnzeigen;
 
    private JLabel �berschrift;
     
    private JPanel buttonGroup;
 
    public SachbearbeiterMainGUI() {
        super("Fl�chtling anlegen");
        //setLocation(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        this.setLayout(new BorderLayout(0,5));
 
        Fl�chtlingAnlegen = new JButton("Neuen Fl�chtling Anlegen");
        HelferAnlegen = new JButton("Neuen Helfer Anlegen");
        SachbearbeiterAnlegen = new JButton("Neuen Sachbearbeiter Anlegen");
        UnterkunftAnlegen = new JButton("Neue Unterkunft Anlegen");
        MeineFl�chtlingeSehen = new JButton("Meine Fl�chtlinge Sehen");
        AngeboteAnzeigen = new JButton("Alle Angebote Anzeigen");
        
         
 
        // Listener f�r Buttons
        Fl�chtlingAnlegen.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                 
            }   
        });
        HelferAnlegen.addActionListener(new ActionListener(){
 
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                 
            }
             
        });
        SachbearbeiterAnlegen.addActionListener(new ActionListener(){
 
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Sachbearbeiter Anlegen"); 
                 
            }
             
        });
        UnterkunftAnlegen.addActionListener(new ActionListener(){
 
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                 
            }
             
        });
        MeineFl�chtlingeSehen.addActionListener(new ActionListener(){
 
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                /*SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        ScrollableJTable.showFrame();
                    }
                });*/
                new MeineFl�chtlingeSehen_ScrollableJTable();
                 
            }
             
        });
        AngeboteAnzeigen.addActionListener(new ActionListener(){
        	@Override
            public void actionPerformed(ActionEvent e) {
                
                try {
					new AngeboteAnzeigen();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                 
            }
        });
         
        // Labels erzeugen
        �berschrift = new JLabel("Neuen Fl�chtling anlegen: ");
 
        // Label zentrieren
        �berschrift.setHorizontalAlignment(JLabel.CENTER);
 
 
        getContentPane().add(BorderLayout.PAGE_START, �berschrift);
         
         
        buttonGroup = new JPanel(new GridLayout(4,1));
         
        buttonGroup.add(HelferAnlegen);
        buttonGroup.add(SachbearbeiterAnlegen);
        buttonGroup.add(UnterkunftAnlegen);
        buttonGroup.add(MeineFl�chtlingeSehen);
        buttonGroup.add(AngeboteAnzeigen);
 
        getContentPane().add(BorderLayout.CENTER, buttonGroup);
         
        pack();
         
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);
 
    }
 
    public static void main(String[] args) {
        SachbearbeiterMainGUI bl = new SachbearbeiterMainGUI();
        bl.setVisible(true);
    }
 
}
