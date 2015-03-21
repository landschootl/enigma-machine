package dut2015;

public interface Rotor {
	//getter setter
	public Position getPosition();
	public void setPosition(Position position);
	public char getRotation();
	public void setRotation(char rotation) ;
	 //codage
	public int codageGauche(char lettre);
	public int codageDroit(char lettre);
	
	public void rotationRotor();
	
	public boolean rotationVoisin(char lettre);
}
