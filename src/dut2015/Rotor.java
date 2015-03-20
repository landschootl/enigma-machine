package dut2015;

public class Rotor {
	private String code;
	private Position position;
	private String rotation;
	private String identite="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private int pointeur=0;
	
	public Rotor(String code, Position position, String rotation) {
		this.code = code;
		this.position = position;
		this.rotation = rotation;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public String getRotation() {
		return rotation;
	}

	public void setRotation(String rotation) {
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
	
	public boolean rotationVoisin(String lettre){
		return lettre==rotation;
	}
}
