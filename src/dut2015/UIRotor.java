package dut2015;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.TransferHandler;

public class UIRotor extends JPanel {
	private JLabel letterl = new JLabel("-");
	private JLabel rotorl = new JLabel("-");
	private Enigma enigma;
	private Position pos;

	public UIRotor(final Enigma enigma, final Position pos) {
		this.enigma = enigma;
		this.pos = pos;
		//letterl.setText("" + enigma.getRotorLetter(pos));
		letterl.setHorizontalAlignment(SwingConstants.CENTER);
		letterl.setBackground(new Color(221,179,80));
		letterl.setOpaque(true);
		letterl.setFont(new Font("Arial", Font.BOLD, 35));
		//rotorl.setText("" + enigma.getRotor(pos));
		rotorl.setHorizontalAlignment(SwingConstants.CENTER);
		rotorl.setBackground(new Color(221,179,80));
		rotorl.setOpaque(true);
		rotorl.setFont(new Font("Arial", Font.BOLD, 35));
		setLayout(new GridLayout(4, 1));
		//bouton +
		JButton plus = new JButton("+");
		plus.setFont(plus.getFont().deriveFont(40f));
		plus.setPreferredSize(new Dimension(100,80));
		plus.setBackground(new Color(152,5,5));
		plus.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				char current = enigma.getRotorLetter(pos);
				enigma.moveRotorToLetter(pos, next(current));
				letterl.setText("" + enigma.getRotorLetter(pos));
			}
		});
		//bouton -
		JButton minus = new JButton("-");
		minus.setFont(minus.getFont().deriveFont(40f));
		minus.setPreferredSize(new Dimension(100,80));
		minus.setBackground(new Color(152,5,5));
		minus.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				char current = enigma.getRotorLetter(pos);
				enigma.moveRotorToLetter(pos, last(current));
				letterl.setText("" + enigma.getRotorLetter(pos));
			}
		});
		add(plus);
		add(letterl);
		add(minus);
		add(rotorl);
		TransferHandler receiveRotor = new TransferHandler() {
			@Override
			public boolean canImport(TransferSupport ts) {
				return ts.isDataFlavorSupported(RealRotor.ROTOR_FLAVOR);
			}

			@Override
			public boolean importData(TransferSupport ts) {
				try {
					if (ts.isDrop()) {
						int rotorNumber = (Integer) ts.getTransferable().getTransferData(RealRotor.ROTOR_FLAVOR);
						enigma.setRotor(pos, rotorNumber);
						letterl.setText("" + enigma.getRotorLetter(pos));
						rotorl.setText(""+rotorNumber);
						return true;
					}
				} catch (Exception e) {
					System.err.println(e);
					return false;
				}
				return false;
			}
		};
		setTransferHandler(receiveRotor);
	}

	private char next(char current) {
		if(current=='Z')
			return 'A';
		else
			return (char) (current+1);
	}

	private char last(char current) {
		if(current=='A')
			return 'Z';
		else
			return (char) (current-1);
	}
	
	public void setLetterl(char c){
		letterl.setText(c+"");
	}
}
