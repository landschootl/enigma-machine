package dut2015;
import static dut2015.Position.LEFT;
import static dut2015.Position.RIGHT;
import static dut2015.Position.MIDDLE;
public class MyEnigma implements Enigma {
	public static Rotor tabRotor[]=new Rotor[5];
	private Rotor rotorActif[]=new Rotor[3];
	private Reflector reflector=new Reflector();
	
	static{
		tabRotor[0]=new RealRotor(1,"I","EKMFLGDQVZNTOWYHXUSPAIBRCJ",'Q');
		tabRotor[1]=new RealRotor(2,"II","AJDKSIRUXBLHWTMCQGZNPYFVOE",'E');
		tabRotor[2]=new RealRotor(3,"III","BDFHJLCPRTXVZNYEIWGAKMUSQO",'V');
		tabRotor[3]=new RealRotor(4,"IV","ESOVPZJAYQUIRHXLNFTGKDCMWB",'J');
		tabRotor[4]=new RealRotor(5,"V","VZBRGITYUPSDNHLXAWMJQOFECK",'Z');
	}
	
	@Override
	public void setRotor(Position pos, int rotorNumber) {
		// TODO Auto-generated method stub
		rotorActif[pos.ordinal()]=tabRotor[rotorNumber-1];
		rotorActif[pos.ordinal()].setPointeur('A');
	}

	@Override
	public int getRotor(Position pos) {
		// TODO Auto-generated method stub
		if (rotorActif[pos.ordinal()]!=null)
			return pos.ordinal();
		return -1;
	}

	@Override
	public void moveRotorToLetter(Position pos, char letter) {
		// TODO Auto-generated method stub
			
		rotorActif[pos.ordinal()].setPointeur(letter);
	}

	@Override
	public char getRotorLetter(Position pos) {
		// TODO Auto-generated method stub
		int rotor=getRotor(pos);
		if (rotor==-1)
			return ' ';
		return rotorActif[pos.ordinal()].getPointeur();
	}

	@Override
	public String getCurrentLetters() {
		// TODO Auto-generated method stub
		return ""+getRotorLetter(LEFT)+getRotorLetter(MIDDLE)+getRotorLetter(RIGHT);
	}

	@Override
	public char encode(char c) {
		// TODO Auto-generated method stub
		for (int i=0;i<2;i++){
			if (i==0){
				c=encodeGauche(c);
			}
			else 
				c=encodeDroit(reflector.reflect(c));
		}
		return c;
	}
	
	private char encodeGauche(char c){
		rotorActif[2].rotationRotor();
		if (rotorActif[2].isTourner())
			rotorActif[1].rotationRotor();
		for (int i=rotorActif.length-1;i>=0;i--){
			c=rotorActif[i].codageGauche(c);
			if (i!=0 && rotation(i,c)){
				rotorActif[i-1].rotationRotor();
			}
		}
		return c;
	}
	
	private char encodeDroit(int i){
		for (int j=0;j<rotorActif.length;j++){
			i=rotorActif[j].codageDroit(i);
		}
		return (char)(i+'A');
	}
	
	private boolean rotation(int indiceRotor,char c){
		return rotorActif[indiceRotor].rotationVoisin(c);
	}
}
