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
	
	public int codageGauche(char lettre){
		int index=identite.indexOf(lettre)+pointeur;
		if (index<=25)
			return identite.indexOf(code.charAt(index));
		return identite.indexOf(code.charAt(index-26));
		
	}
	
	public int codageDroit(char lettre){
		return code.indexOf(lettre);
	}
	
	public void rotationRotor(){
		pointeur=pointeur%identite.length();
	}
	
	public boolean rotationVoisin(char lettre){
		return lettre==rotation;
	}

}
