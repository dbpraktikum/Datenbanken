import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainGUI extends javax.swing.JFrame{

	private JButton anmelden;
	private JButton registrieren;
	private JPanel panel1;
	private JPanel panel2;
	private JLabel text;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JFrame child;
	
	public MainGUI(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JFrame frame = this;
		this.setTitle("FVS");
		
		panel1 = new JPanel();
		text = new JLabel("Flüchtlings-Verwaltungssystem");
		text.setForeground(Color.blue);
		text.setFont(new Font("Serif", Font.BOLD, 30));
		panel1.add(text);
		
		panel2 = new JPanel(new GridLayout(0, 5));
		anmelden = new JButton("Anmelden");
		anmelden.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//frame.dispose();
				//new LoginFenster();
				if(child != null){
					child.dispose();
				}
				child = new LoginFenster(frame);
			}	
		});
		registrieren = new JButton("Registrieren");
		registrieren.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//frame.dispose();
				if(child != null){
					child.dispose();
				}
				child = new RegistrierungFenster(frame);
			}
		});
		label1 = new JLabel();
		label2 = new JLabel();
		label3 = new JLabel();
		label4 = new JLabel();
		label5 = new JLabel();
		panel2.add(label1);
		panel2.add(anmelden);
		panel2.add(label2);
		//panel2.add(label3);
		panel2.add(registrieren);
		panel2.add(label4);
		panel2.add(label5);
		
		this.setLayout(new BorderLayout(1,0));
		this.add(panel1, BorderLayout.CENTER);
		this.add(panel2, BorderLayout.SOUTH);
		this.pack();
		this.setSize(800, 250);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainGUI();
	}

}
