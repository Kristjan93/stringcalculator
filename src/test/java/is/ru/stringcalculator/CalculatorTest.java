package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
       }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
    	public void testMultipleNumbers(){
    		assertEquals(6, Calculator.add("1,2,3"));
   	 }

	@Test
        public void testNewLines() {
        	assertEquals(6, Calculator.add("1\n2,3") );
        }

      @Test
        public void testDifferentDelimiters() {
        	assertEquals(3, Calculator.add("//;\n1;2") );
        }

       @Test
        public void testThrowNegativeException() {
        	try {
        		Calculator.add("-1,2");
        	}
        	catch (RuntimeException ex){
        		assertEquals("Negatives not allowed: -1", ex.getMessage() );

		}
        }
	
	 @Test
        public void testThrowNegativeExceptionForMultipleNumbers() {
        	try {
        		Calculator.add("2,-4,3,-5");
        	}
        	catch (RuntimeException ex){
        		assertEquals("Negatives not allowed: -4,-5", ex.getMessage() );
        	}	
        }
	
       @Test
        public void testNoneGreaterThanThousand() {
        	assertEquals(2, Calculator.add("1001,2") );
        }

       @Test
        public void delimitersOfAnyLength() {
        	assertEquals(6, Calculator.add("//[***]\n1***2***3") );
        }

	@Test
        public void multipleDelimiters() {
        	assertEquals(6, Calculator.add("//[*][%]\n1*2%3") );
        }

	@Test
        public void multipleDelimitersOfAnyLength() {
        	assertEquals(6, Calculator.add("//[**][%%]\n1**2%%3") );
        }
}
