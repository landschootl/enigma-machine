package dut2015;


public class RealRotor implements Rotor{
	private String code;
	private char rotation;
	private final String identite="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private int pointeur=0;
	
	public RealRotor(String code, char rotation) {
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
		return lettre==rotation;
	}

}
