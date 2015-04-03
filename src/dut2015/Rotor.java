package dut2015;

import java.awt.datatransfer.DataFlavor;

public interface Rotor {
	//getter setter
	public char getRotation();
	public void setRotation(char rotation) ;
	public char getPointeur();
	public void setPointeur(char letter);
	//codage
	public char codageGauche(char lettre);
	public int codageDroit(int i);
	
	public void rotationRotor();
	
	public boolean rotationVoisin(char lettre);
	
	public boolean isTourner();
	public void setTourner(boolean tourner);
	
}
