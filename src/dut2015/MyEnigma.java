package dut2015;

public class MyEnigma implements Enigma {
	private Rotor tabRotor[]=new Rotor[5];
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
		tabRotor[rotorNumber-1].setPosition(pos);
		
	}

	@Override
	public int getRotor(Position pos) {
		// TODO Auto-generated method stub
		for(int i=0;i<tabRotor.length;i++){
			if (tabRotor[i].getPosition()==pos)
				return i+1;
		}
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
