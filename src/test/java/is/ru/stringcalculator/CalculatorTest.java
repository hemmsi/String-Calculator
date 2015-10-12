package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

    public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }
    @Test
    public void testEmptyString(){
	assertEquals(0, Calculator.add(""));
    }
    
    @Test
    public void testStringWithOneNum(){
	    assertEquals(1, Calculator.add("1"));
    }
    
    @Test
    public void testStringWithTwoNum(){
        assertEquals(7, Calculator.add("5,2"));
    }

    @Test
    public void testStringWithManyNum(){
        assertEquals(24, Calculator.add("5,2,3,4,1,9"));
    }
}
