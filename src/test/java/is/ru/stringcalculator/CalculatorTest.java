package is.ru.stringcalculator;
        
        import static org.hamcrest.core.IsEqual.equalTo;
        import static org.junit.Assert.assertEquals;

        import org.junit.Rule;
        import org.junit.Test;
        import org.junit.rules.ExpectedException;

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

    @Test
    public void testStringWithNewLineDelimiter(){
        assertEquals(10, Calculator.add("5\n2,3"));
    }

    @Test
    public void testStringWithAnyDelimiter(){
        assertEquals(5, Calculator.add("//;\n2;3"));
    }
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();
    @Test
    public void testStringWithNegativeNumber(){
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage(equalTo("Negatives not allowed: -1"));
        Calculator.add("-1,2");
    }
    @Test
    public void testStringWithNegativeNumbers(){
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage(equalTo("Negatives not allowed: -1,-3,-7"));
        Calculator.add("-1,-3,-7,2");
    }
    @Test
    public void testStringWithNumberOver1000(){
        assertEquals(3, Calculator.add("1001,3"));
    }
    @Test
    public void testStringWithDelimitersOfAnyLenght(){
        assertEquals(6, Calculator.add("//[***]\n1***2***3"));
    }
        @Test
    public void testStringWithMultDelims(){
        assertEquals(6, Calculator.add("//[*][%]\n1*2%3"));
    }
}
