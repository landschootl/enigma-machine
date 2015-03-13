package dut2015;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static dut2015.Position.*;

public abstract class AbstractInitialTests {

    private Enigma enigma;
    
    protected abstract Enigma makeEnigma();

    @Before
    public void init() {
        enigma = makeEnigma();
    }
    
    @Test
    public void enigmaMachineHasNoRotorByDefault() {
        assertEquals(0,enigma.getRotor(LEFT));
        assertEquals(0,enigma.getRotor(MIDDLE));
        assertEquals(0,enigma.getRotor(RIGHT));
        assertEquals(' ',enigma.getRotorLetter(LEFT));
        assertEquals(' ',enigma.getRotorLetter(MIDDLE));
        assertEquals(' ',enigma.getRotorLetter(RIGHT));
        assertEquals("   ",enigma.getCurrentLetters());
    }

    @Test
    public void rotorAreByDefaultSetToA() {
        enigma.setRotor(LEFT, 1);
        enigma.setRotor(MIDDLE, 2);
        enigma.setRotor(RIGHT, 3);
        assertEquals('A',enigma.getRotorLetter(LEFT));
        assertEquals('A',enigma.getRotorLetter(MIDDLE));
        assertEquals('A',enigma.getRotorLetter(RIGHT));
        assertEquals("AAA",enigma.getCurrentLetters());        
    }
    
    @Test
    public void testEncoding() {
        enigma.setRotor(LEFT, 1);
        enigma.setRotor(MIDDLE, 2);
        enigma.setRotor(RIGHT, 3);
        // taken from http://en.wikipedia.org/wiki/Enigma_rotor_details
        assertEquals('B',enigma.encode('A'));
        assertEquals('D',enigma.encode('A'));
        assertEquals('Z',enigma.encode('A'));
        assertEquals('G',enigma.encode('A'));
        assertEquals('O',enigma.encode('A'));
    }
    
    @Test
    public void simpleRotorChange() {
        // taken from http://en.wikipedia.org/wiki/Enigma_rotor_details
        enigma.setRotor(LEFT, 1);
        enigma.setRotor(MIDDLE, 2);
        enigma.setRotor(RIGHT, 3);
        enigma.moveRotorToLetter(RIGHT, 'U');
        enigma.encode('X');
        assertEquals("AAV",enigma.getCurrentLetters());
        enigma.encode('X');
        assertEquals("ABW",enigma.getCurrentLetters());
        enigma.encode('X');
        assertEquals("ABX",enigma.getCurrentLetters());
    }
    
    @Test
    public void doubleRotorChange() {
        // taken from http://en.wikipedia.org/wiki/Enigma_rotor_details
        enigma.setRotor(LEFT, 1);
        enigma.setRotor(MIDDLE, 2);
        enigma.setRotor(RIGHT, 3);
        enigma.moveRotorToLetter(MIDDLE, 'D');
        enigma.moveRotorToLetter(RIGHT, 'U');
        enigma.encode('X');
        assertEquals("ADV",enigma.getCurrentLetters());
        enigma.encode('X');
        assertEquals("AEW",enigma.getCurrentLetters());
        enigma.encode('X');
        assertEquals("BFX",enigma.getCurrentLetters());
        enigma.encode('X');
        assertEquals("BFY",enigma.getCurrentLetters());
    }
}
