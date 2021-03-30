package edu.qc.seclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class MyCustomStringTest {

    private MyCustomStringInterface mycustomstring;

    @Before
    public void setUp() {
        mycustomstring = new MyCustomString();
    }

    @After
    public void tearDown() {
        mycustomstring = null;
    }
    //test if the countnumber method work well given good parameters
    @Test
    public void testCountNumbers1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals(7, mycustomstring.countNumbers());
    }
    //test the NullPointerException
    @Test(expected = NullPointerException.class)
    public void testCountNumbers2() {
        mycustomstring.setString(null);
        mycustomstring.countNumbers();
    }
    //test if the countnumber method work well given good parameters
    @Test
    public void testCountNumbers3() {

        mycustomstring.setString("7h3r3 a23 7h233");
        assertEquals(6, mycustomstring.countNumbers());
    }
    //test if the countnumber method work well given good parameters
    @Test
    public void testCountNumbers4() {
        mycustomstring.setString("there is no number");
        assertEquals(0,mycustomstring.countNumbers());
    }
    //return 0 if given empty string
    @Test
    public void testCountNumbers5() {
        mycustomstring.setString("");
        assertEquals(0,mycustomstring.countNumbers());
    }
    //test if the countnumber method work well given good parameters
    @Test
    public void testCountNumbers6() {
        mycustomstring.setString("4763528");
        assertEquals(1,mycustomstring.countNumbers());
    }
    //test the method with good parameters start from beginning
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("d33p md1  i51,it", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
    }
    //test the method with good parameters start from end
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd2() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("hr6r hns6 0t tb'", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true));
    }
    //test IllegalArgumentException when n<=0 start from end
    @Test(expected = IllegalArgumentException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd3() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(0,true);
    }
    //test IllegalArgumentException when n<=0 start from beginning
    @Test(expected = IllegalArgumentException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd4() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(0,false);
    }
    //test NullPointerException when null string and n>0 start from beginning
    @Test(expected = NullPointerException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd5() {
        mycustomstring.setString(null);
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1,false);
    }
    //test NullPointerException when null string and n>0 start from end
    @Test(expected = NullPointerException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd6() {
        mycustomstring.setString(null);
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1,true);
    }
    //test the getEveryNthCharacterFromBeginningOrEnd method with good parameters
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd7() {
        mycustomstring.setString("23 54 33 22 54");
        assertEquals("45 22 33 45 32", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1, true));
    }
    //should return empty string with given empty string and n>0 start from end
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd8() {
        mycustomstring.setString("");
        assertEquals(null, mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, true));
    }
    //test the getEveryNthCharacterFromBeginningOrEnd method with good parameters
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd9() {
        mycustomstring.setString("23 54 33 22 54");
        assertEquals("23 54 33 22 54", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1, false));
    }
    //should return empty string with given empty string and n>0 start from beginning
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd10() {
        mycustomstring.setString("");
        assertEquals(null, mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, false));
    }
    //should return empty string with given n<the length of the string start from beginning
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd11(){
        mycustomstring.setString("short");
        assertEquals(null, mycustomstring.getEveryNthCharacterFromBeginningOrEnd(6, false));

    }
    //should return empty string with given n<the length of the string start from end
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd12() {
        mycustomstring.setString("short");
        assertEquals(null, mycustomstring.getEveryNthCharacterFromBeginningOrEnd(6, true));
    }
    //test of the getEveryNthCharacterFromBeginningOrEnd method works well with good parameters start from end
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd13() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("n  r", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(10, true));

    }
    //test of the getEveryNthCharacterFromBeginningOrEnd method works well with good parameters start from beginning
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd14() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("r  n", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(10, false));
    }
    //test if the convertDigitsToNamesInSubstring works well given good parameters
    @Test
    public void testConvertDigitsToNamesInSubstring1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(17, 23);
        assertEquals("I'd b3tt3r put sZerome dOneSix1ts in this 5tr1n6, right?", mycustomstring.getString());
    }
    //test NullPointerException when the string is null and startposition <= endposition and both startposition and endposition are >0
    @Test(expected = NullPointerException.class)
    public void testConvertDigitsToNamesInSubstring2() {
        mycustomstring.setString(null);
        mycustomstring.convertDigitsToNamesInSubstring(1, 20);
    }
    //test MyIndexOutOfBoundsException with given good string when startposition <= endposition but startposition is out of bound
    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testConvertDigitsToNamesInSubstring3() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(-1, 20);
    }
    //test MyIndexOutOfBoundsException with good string when startposition <= endposition but endposition is out of bound
    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testConvertDigitsToNamesInSubstring4() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(10, 100);
    }
    //test MyIndexOutOfBoundsException with null string when startposition <= endposition but startposition is out of bound
    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testConvertDigitsToNamesInSubstring5() {
        mycustomstring.setString(null);
        mycustomstring.convertDigitsToNamesInSubstring(-1, 20);
    }
    //test if the convertDigitsToNamesInSubstring method works well with given good parameters
    @Test
    public void testConvertDigitsToNamesInSubstring6() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(4, 42);
        assertEquals("I'd bThreettThreer put sZerome dOneSixOnets in this FivetrOnenSix, right?", mycustomstring.getString());
    }
    //test IllegalArgumentException with null string when startposition > endposition
    @Test(expected = IllegalArgumentException.class)
    public void testConvertDigitsToNamesInSubstring7() {
        mycustomstring.setString(null);
        mycustomstring.convertDigitsToNamesInSubstring(20, 2);
    }
    //test IllegalArgumentException with good string when startposition > endposition
    @Test(expected = IllegalArgumentException.class)
    public void testConvertDigitsToNamesInSubstring8() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(10, 1);

    }

}

