package dut2015;

import static dut2015.Position.LEFT;
import static dut2015.Position.MIDDLE;
import static dut2015.Position.RIGHT;

public class Main {

	public static void main(String[] args) {
		Enigma enigma=new MyEnigma();
        enigma.setRotor(LEFT, 1);
        enigma.setRotor(MIDDLE, 2);
        enigma.setRotor(RIGHT, 3);
        System.out.println(enigma.encode('A'));
        System.out.println(enigma.encode('A'));
        System.out.println(enigma.encode('A'));
        System.out.println(enigma.encode('A'));
        System.out.println(enigma.encode('A'));

	}

}
