package dut2015;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;
import javax.swing.TransferHandler;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Machine extends JFrame implements KeyListener{
	private Enigma enigma;
	private List<JButton> keybord;
	private JLabel labelCode = new JLabel("message codé : ", SwingConstants.LEFT);
	private char encode;
	
	public Machine(Enigma enigma) {
		super();
		keybord = new ArrayList<JButton>();
		this.enigma = enigma;
		
		build(); // On initialise notre fenêtre
	}
	
	UIRotor rotor1;
	UIRotor rotor2;
	UIRotor rotor3;
	private void build() {
		/******* Creation fenetre *******/
		setTitle("Enigma"); // On donne un titre à l'application
		setSize(1100,1100); // On donne une taille à notre fenêtre
		setLocationRelativeTo(null); // On centre la fenêtre sur l'écran
		ImageIcon icone = new ImageIcon("icone.png"); // On charge l'icone de la fenetre
		this.setIconImage(icone.getImage()); // On ajoute l'icone à la fenetre
		//setResizable(false); // On interdit la redimensionnement de la fenêtre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // On dit à l'application de se fermer lors du clic sur la croix
		this.setVisible(true); // On rend visible la fenetre.

		/******* Creation North *******/
		// Création rotor
		rotor1 = new UIRotor(enigma, Position.LEFT);
		rotor2 = new UIRotor(enigma, Position.MIDDLE);
		rotor3 = new UIRotor(enigma, Position.RIGHT);
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(1, 4));
		center.add(rotor1);
		center.add(rotor2);
		center.add(rotor3);

		// Création JList
		DefaultListModel<RealRotor> model = new DefaultListModel<RealRotor>();
		for (int i = 0; i < 5; i++)
			model.addElement((RealRotor) MyEnigma.tabRotor[i]);

		JList<RealRotor> jList = new JList<RealRotor>(model);

		ListCellRenderer<RealRotor> renderer = new ListCellRenderer<RealRotor>() {
			public Component getListCellRendererComponent(
					JList<? extends RealRotor> list, RealRotor value,
					int index, boolean isSelected, boolean cellHasFocus) {
				JLabel label = new JLabel(value.toString());
				label.setFont(label.getFont().deriveFont(25f));
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setVerticalAlignment(SwingConstants.CENTER);
				label.setBackground(Color.WHITE);
				label.setPreferredSize(new Dimension(100, 60));
				label.setBorder(new LineBorder(Color.BLACK,5));
				return label;
			}
		};
		
		jList.setCellRenderer(renderer);
		
		TransferHandler provide = new TransferHandler() {
			public int getSourceActions(JComponent c) {
				return MOVE;
			}

			protected Transferable createTransferable(JComponent c) {
				return ((JList<RealRotor>) c).getSelectedValue();
			}
			protected void exportDone(JComponent source, Transferable data,
					int action) {
				if (action == MOVE) {
					JList<Rotor> list = (JList<Rotor>) source;
					((DefaultListModel) list.getModel()).removeElement(data);
				}
			}
		};
		jList.setTransferHandler(provide);
		MouseListener mouseListener = new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				JComponent comp = (JComponent) me.getSource();
				TransferHandler handler = comp.getTransferHandler();
				handler.exportAsDrag(comp, me, TransferHandler.MOVE);
			}
		};
		jList.setBackground(new Color(221,179,80));
		jList.addMouseListener(mouseListener);
		center.add(jList);

		add(BorderLayout.NORTH, center);

		/******* Creation Center *******/
		add(BorderLayout.CENTER, buildKeybordPane());
		
		/******* Creation South *******/
		add(BorderLayout.SOUTH, buildTextEncodePane());
		pack();
	}

	private JPanel buildKeybordPane() {
		JButton button;
		JPanel panelKeybord = new JPanel();
		panelKeybord.setLayout(new GridLayout(4, 7));

		for (char i = 'A'; i <= 'Z'; i++) {
			keybord.add(button = new JButton("" + i));
			button.setPreferredSize(new Dimension(130,100));
			button.setBackground(new Color(189,118,71));
			button.setFont(button.getFont().deriveFont(20.0f));
			button.setBorder(new LineBorder(Color.BLACK,1));
			panelKeybord.add(button);
		}

		panelKeybord.setBackground(new Color(221,179,80));
		return panelKeybord;
	}
	
	private JPanel buildTextEncodePane() {
		JPanel panelTextEncode = new JPanel();
		panelTextEncode.setLayout(new BorderLayout());		
		
		Border border=LineBorder.createGrayLineBorder();
		
		JTextArea  textArea = new JTextArea ("Ecrire ici ...",5,1);
		textArea.setFont(textArea.getFont().deriveFont(18.0f));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setBorder(border);
		textArea.addKeyListener(this); // On actionne les événements
		
		labelCode.setFont(labelCode.getFont().deriveFont(18.0f));
		labelCode.setBorder(border);
		labelCode.setBackground(new Color(227,186,87));
		labelCode.setOpaque(true);
		
		panelTextEncode.add(BorderLayout.NORTH,labelCode);
		panelTextEncode.add(BorderLayout.CENTER,textArea);
		
		return panelTextEncode;
	}

	private boolean appuyer=false;
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		char code = Character.toUpperCase(arg0.getKeyChar());
		if (!appuyer){
			if(code >= 'A' && code <= 'Z'){
				encode = enigma.encode(code);
				labelCode.setText(labelCode.getText()+encode);
				keybord.get(encode-65).setBackground(Color.YELLOW);
				appuyer=true;
				
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(appuyer){
			keybord.get(encode-65).setBackground(new Color(189,118,71));
			rotor1.setLetterl(enigma.getRotorLetter(Position.LEFT));
			rotor2.setLetterl(enigma.getRotorLetter(Position.MIDDLE));
			rotor3.setLetterl(enigma.getRotorLetter(Position.RIGHT));
			appuyer=false;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
