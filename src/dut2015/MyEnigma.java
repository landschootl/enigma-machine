package dut2015;

public class MyEnigma implements Enigma {
	private Rotor tabRotor[]=new Rotor[8];
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
		
	}

	@Override
	public char getRotorLetter(Position pos) {
		// TODO Auto-generated method stub
		return 0;
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
