package dut2015;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;


public class RealRotor implements Rotor, Transferable {
	static DataFlavor ROTOR_FLAVOR=new DataFlavor(Rotor.class,"ROTOR_FLAVOR");
	
	private int num;
	private String name;
	private String code;
	private char rotation;
	private final String identite="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private int pointeur=0;
	private boolean tourner=false;
	
	public boolean isTourner() {
		return pointeur>code.indexOf(rotation);
	}

	public void setTourner(boolean tourner) {
		this.tourner = tourner;
	}

	public RealRotor(int num, String name, String code, char rotation) {
		this.num=num;
		this.name = name;
		this.code = code;
		this.rotation = rotation;
	}

	public char getRotation() {
		return rotation;
	}

	public void setRotation(char rotation) {
		this.rotation = rotation;
	}
	
	public void setPointeur(char letter){
		
		pointeur=identite.indexOf(letter);
	}
	public char getPointeur(){
		return identite.charAt(pointeur);
	}
	public char codageGauche(char lettre){
		int index=(identite.indexOf(lettre)+pointeur)%code.length();
		char c=code.charAt(index);
		return identite.charAt(Math.abs(identite.indexOf(c)-pointeur));
	}
	
	public int codageDroit(int i){
		char c=identite.charAt((i+pointeur)%code.length());
		int e=code.indexOf(c)-pointeur;
		if (e>=0)
			return e;
		return 25;
	}
	
	public void rotationRotor(){
		if (pointeur ==0)
			pointeur++;
		else if (pointeur==25)
			pointeur=0;
		else{
			pointeur++;
			pointeur=pointeur%code.length();
		}
	}
	
	public boolean rotationVoisin(char lettre){
		if (lettre==rotation){
			tourner=true;
			return true;
		}
		return false;
	}

	@Override
	public DataFlavor[] getTransferDataFlavors() {
		return new DataFlavor[]{ROTOR_FLAVOR};
	}

	@Override
	public boolean isDataFlavorSupported(DataFlavor flavor) {
		return flavor == ROTOR_FLAVOR;
	}

	@Override
	public Object getTransferData(DataFlavor flavor)
			throws UnsupportedFlavorException, IOException {
		return num;
	}

	public String toString(){
		return "rotor " + name;
	}
}
