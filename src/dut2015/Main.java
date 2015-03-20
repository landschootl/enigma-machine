package dut2015;

public class Main {

	public static void main(String[] args) {
		Enigma enigma = new Rotor();
		enigma.setRotor(Position.LEFT,1);
		// TODO Auto-generated method stub
		Machine machine = new Machine(enigma);
	}

}
