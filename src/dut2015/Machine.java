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
	private List<JButton> keybord;
	
	public Machine() {
		super();
		keybord = new ArrayList<JButton>();
		 
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
		add(BorderLayout.CENTER,buildRotorPane());
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
	
	private JPanel buildRotorPane(){
		JPanel panelTitle = new JPanel();
		panelTitle.setLayout(new FlowLayout());
	 
		JLabel label = new JLabel("Machine Enigma");
	 
		panelTitle.add(label);
	 
		return panelTitle;
	}
	
	private JPanel buildKeybordPane(){
		JButton button;
		JPanel panelKeybord = new JPanel();
		panelKeybord.setLayout(new GridLayout(4,7));
	 
		for(char i='a'; i<='z';i++){
			System.out.println(""+i);
			keybord.add(button = new JButton(""+i));
			panelKeybord.add(button);
		}
		
		return panelKeybord;
	}
}
