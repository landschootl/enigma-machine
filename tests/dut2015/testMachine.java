package dut2015;

public class testMachine extends AbstractInitialTests {

	@Override
	protected Enigma makeEnigma() {
		// TODO Auto-generated method stub
		return new MyEnigma();
	}

}
