package dut2015;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UIRotor extends JPanel{
	private JLabel letterl = new JLabel("-");
	private JLabel rotorl = new JLabel("-");
	private Enigma enigma;
	private Position pos;
	
	public UIRotor(final Enigma enigma, final Position pos){
		this.enigma = enigma;
		this.pos=pos;
		letterl.setText(""+enigma.getRotorLetter(pos));
		rotorl.setText(""+enigma.getRotor(pos));
		setLayout(new GridLayout(4,1));
		JButton plus = new JButton("+");
		plus.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				char current=enigma.getRotorLetter(pos);
				enigma.moveRotorToLetter(pos,next(current));
				letterl.setText(""+enigma.getRotorLetter(pos));
			}
		});
		JButton minus = new JButton("-");
		plus.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				char current=enigma.getRotorLetter(pos);
				enigma.moveRotorToLetter(pos,last(current));
				letterl.setText(""+enigma.getRotorLetter(pos));
			}
		});
		add(plus);
		add(letterl);
		add(minus);
		add(rotorl);
	}
	
	private char next(char current){
		return '1';
	}
	
	private char last(char current){
		return '1';
	}

}
