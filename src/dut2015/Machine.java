package dut2015;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Machine extends JFrame{
	private Enigma enigma;
	private List<JButton> keybord;
	
	public Machine(Enigma enigma) {
		super();
		keybord = new ArrayList<JButton>();
		this.enigma=enigma;
		 
		build();//On initialise notre fenêtre
	}
	
	private void build(){
		setTitle("Enigma"); //On donne un titre à l'application
		setSize(700,400); //On donne une taille à notre fenêtre
		setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
		setResizable(false); //On interdit la redimensionnement de la fenêtre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
		this.setVisible(true); //On rend visible la fenetre.
		add(BorderLayout.NORTH,buildTitlePane());
		UIRotor rotor1 = new UIRotor(enigma,Position.LEFT);
		UIRotor rotor2 = new UIRotor(enigma,Position.MIDDLE);
		UIRotor rotor3 = new UIRotor(enigma,Position.RIGHT);
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(1,3));
		center.add(rotor1);
		center.add(rotor2);
		center.add(rotor3);
		add(BorderLayout.CENTER,center);
		add(BorderLayout.SOUTH,buildKeybordPane());
		pack();
	}
	
	private JPanel buildTitlePane(){
		JPanel panelTitle = new JPanel();
		panelTitle.setLayout(new FlowLayout());
	 
		JLabel label = new JLabel("Machine Enigma");
	 
		panelTitle.add(label);
	 
		return panelTitle;
	}
	
	/*private JPanel buildRotorRightPane(final Position pos){
		JPanel panelRotor = new JPanel();
		panelRotor.setLayout(new GridLayout(4,1));
	 
		//button accremente
		JButton button = new JButton("+");
		button.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				enigma.moveRotorToLetter(pos,next(enigma.getRotorLetter(pos)));
			}
		});
		//lavel charactere
		JLabel label = new JLabel(enigma.getRotorLetter(pos)+"");
		//button desacremente
		JButton button2 = new JButton("-");
		button2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				enigma.moveRotorToLetter(pos,next(enigma.getRotorLetter(pos)));
			}
		});
		//label rotor
		JLabel label2 = new JLabel(enigma.getRotor(pos)+"");
		
		panelRotor.add(button);
		panelRotor.add(label);
		panelRotor.add(button);
		panelRotor.add(label2);
	 
		return panelRotor;
	}*/
	
	private char next(char current){
		throw new UnsupportedOperationException("Not implemented yet");
	}
	
	private JPanel buildKeybordPane(){
		JButton button;
		JPanel panelKeybord = new JPanel();
		panelKeybord.setLayout(new GridLayout(4,7));
	 
		for(char i='A'; i<='Z';i++){
			keybord.add(button = new JButton(""+i));
			panelKeybord.add(button);
		}
		
		return panelKeybord;
	}
}
