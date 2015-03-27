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
		int index=identite.indexOf(lettre)+pointeur%code.length();
		char c=code.charAt(index);
		return identite.charAt(Math.abs(identite.indexOf(c)-pointeur));
	}
	
	public int codageDroit(int i){
		char c;
		int index=i+pointeur;
		if (i<25){
			c= identite.charAt(index);
		}
		else
			c= identite.charAt(index%26);
		return code.indexOf(c)-pointeur;
	}
	
	public void rotationRotor(){
		if (pointeur ==0)
			pointeur++;
		else{
			pointeur++;
			pointeur=pointeur%code.length();
		}
	}
	
	public boolean rotationVoisin(char lettre){
		return lettre==rotation;
	}

}
