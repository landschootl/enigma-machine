package dut2015;

public class MyEnigma implements Enigma {
	private Rotor tabRotor[]=new Rotor[5];
	private Rotor rotorActif[]=new Rotor[3];
	public MyEnigma (){
		tabRotor[0]=new RealRotor("EKMFLGDQVZNTOWYHXUSPAIBRCJ",'Q');
		tabRotor[1]=new RealRotor("AJDKSIRUXBLHWTMCQGZNPYFVOE",'E');
		tabRotor[2]=new RealRotor("BDFHJLCPRTXVZNYEIWGAKMUSQO",'V');
		tabRotor[3]=new RealRotor("ESOVPZJAYQUIRHXLNFTGKDCMWB",'J');
		tabRotor[4]=new RealRotor("VZBRGITYUPSDNHLXAWMJQOFECK",'Z');
	}
	
	@Override
	public void setRotor(Position pos, int rotorNumber) {
		// TODO Auto-generated method stub
		rotorActif[pos.ordinal()]=tabRotor[rotorNumber-1];
	}

	@Override
	public int getRotor(Position pos) {
		// TODO Auto-generated method stub
		if (rotorActif)
		return 0;
	}

	@Override
	public void moveRotorToLetter(Position pos, char letter) {
		// TODO Auto-generated method stub
		tabRotor[getRotor(pos)].setRotation(letter);
	}

	@Override
	public char getRotorLetter(Position pos) {
		// TODO Auto-generated method stub
		int rotor=getRotor(pos);
		if (rotor==0)
			return ' ';
		return tabRotor[rotor-1].getRotation();
	}

	@Override
	public String getCurrentLetters() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public char encode(char c) {
		// TODO Auto-generated method stub
		return 0;
	}

}
