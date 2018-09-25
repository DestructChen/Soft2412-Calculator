import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

import java.time.Duration;

public class CalculatorTest {

	private static final double epsilon = 0.000001;
	
	private String failMessage(double expected, double actual) {
		return "Expected " + expected + " but was " + actual + ".";
	}

	@Test public void testAppHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull("app should have a greeting", classUnderTest.getGreeting());
    }
	
	// Tests that Addition produces correct results when using positive 
	// integer and float values.
	
	@Test
	public void testAdditionSimple() {
		Calculator calc = new Calculator();
		
		double a = 5;
		double b = 15;
		double c = 20;
		
		double d = 2.4;
		double e = 13.2;
		double f = 15.6;
		double g = 28.8;
		
		assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
	        	
	        List<Double> expected = Arrays.asList(c, f, g);
	        List<Double> actual = Arrays.asList(
	        		calc.Addition(a, b),
	        		calc.Addition(d, e),
	        		calc.Addition(e, f));
	        
	       	for (int i = 0; i < expected.size(); i++) {
		        assertEquals(expected.get(i), actual.get(i), epsilon, 
		        		failMessage(expected.get(i), actual.get(i)));
	       	}
	    }, "Test timed out.");
		
	}
	
	
	// Tests that Addition produces correct results with negative values
	@Test
	public void testAdditionNegativeValues() {
		Calculator calc = new Calculator();
		
		double a = 5.0;
		double b = -14.1;
		double c = -9.1;
		
		double d = -4;
		double e = -9.2;
		double f = -13.2;
		assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
        	
	        List<Double> expected = Arrays.asList(c, f);
	        List<Double> actual = Arrays.asList(
	        		calc.Addition(a, b),
	        		calc.Addition(d, e));
	        
	       	for (int i = 0; i < expected.size(); i++) {
		        assertEquals(expected.get(i), actual.get(i), epsilon, 
		        		failMessage(expected.get(i), actual.get(i)));
	       	}
	    }, "Test timed out.");
	}
	
	
	// Tests that Addition produces correct results when using 0
	@Test
	public void testAdditionZero() {
		Calculator calc = new Calculator();
		
		double a = 5.0;
		double b = 0;
		double c = 5.0;
		
		double d = 0;
		double e = -4;
		double f = -4;
		assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
        	
	        List<Double> expected = Arrays.asList(c, f);
	        List<Double> actual = Arrays.asList(
	        		calc.Addition(a, b),
	        		calc.Addition(d, e));
	        
	       	for (int i = 0; i < expected.size(); i++) {
		        assertEquals(expected.get(i), actual.get(i), epsilon, 
		        		failMessage(expected.get(i), actual.get(i)));
	       	}
	    }, "Test timed out.");
	}
	
/* 	
	
	// Tests that Subtraction produces correct results with positive integer and floating point values
	@Test
	public void testSubtractionSimple() {
		Calculator calc = new Calculator();
			
		double a = 5;
		double b = 14;
		double c = -9;
			
		double d = 9.2;
		double e = 2.1;
		double f = 7.1;
		assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
	        	
		       List<Double> expected = Arrays.asList(c, f);
		       List<Double> actual = Arrays.asList(
		       calc.Subtraction(a, b),
		       calc.Subtraction(d, e));
		        
		       	for (int i = 0; i < expected.size(); i++) {
			        assertEquals(expected.get(i), actual.get(i), epsilon, 
			        	failMessage(expected.get(i), actual.get(i)));
		       	}
		}, "Test timed out.");
	}
		
	// Tests that Subtraction produces correct results with negative values
	@Test
	public void testSubtractionNegative() {
		Calculator calc = new Calculator();
					
		double a = 5;
		double b = -14.2;
		double c = 19.2;
					
		double d = -9.2;
		double e = 2.1;
		double f = -11.3;
		assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
		        	
			      List<Double> expected = Arrays.asList(c, f);
			      List<Double> actual = Arrays.asList(
			      calc.Subtraction(a, b),
			      calc.Subtraction(d, e));
				        
				  for (int i = 0; i < expected.size(); i++) {
					  assertEquals(expected.get(i), actual.get(i), epsilon, 
					     failMessage(expected.get(i), actual.get(i)));
				  }
		}, "Test timed out.");
	}	
	
	
	
	// Tests that Subtraction produces correct results with 0
	@Test
	public void testSubtractionZero() {
		Calculator calc = new Calculator();
					
		double a = 5;
		double b = 0;
		double c = 5;
					
		double d = 0;
		double e = 2.1;
		double f = -2.1;
		assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
		        	
			      List<Double> expected = Arrays.asList(c, f);
			      List<Double> actual = Arrays.asList(
			      calc.Subtraction(a, b),
			      calc.Subtraction(d, e));
				        
				  for (int i = 0; i < expected.size(); i++) {
					  assertEquals(expected.get(i), actual.get(i), epsilon, 
					     failMessage(expected.get(i), actual.get(i)));
				  }
		}, "Test timed out.");
	}	

	
			
	// Ensure Multiplication with a zero in either
	// argument returns 0
    @Test
    public void testMultiplicationByZero() {

        Calculator calc = new Calculator();

        double a = 0.0;
        double b = 1.0;
        double c = -1.0;
        
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
        	
        	List<Double> expected = Arrays.asList(a, a, a, a);
        	List<Double> actual = Arrays.asList(
        			calc.Multiplication(a, b),
        			calc.Multiplication(a, c),
        			calc.Multiplication(b, a),	
        			calc.Multiplication(c, a));
        	
        	for (int i = 0; i < expected.size(); i++) {
		        assertEquals(expected.get(i), actual.get(i), epsilon, 
		        		failMessage(expected.get(i), actual.get(i)));
        	}
        }, "Test timed out.");
    }
    
    // Ensure that Multiplication performs correctly
    // with negative values such that neg * neg is a positive
    // and pos * neg and neg * pos are negatives
    @Test
    public void testMultiplicationByNegativeValues() {
        Calculator calc = new Calculator();

        double a = -1.0;
        double b = -20.0;
        double c = 10.0;
        double d = 20.0;
        double e = -200.0;
        double f = -10.0;
        double g = 1.0;
        double h = 400.0;
        
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
        	
        	List<Double> expected = Arrays.asList(g, d, e, h, a, f);
        	List<Double> actual = Arrays.asList(
        			calc.Multiplication(a, a),
        			calc.Multiplication(a, b),
        			calc.Multiplication(b, c),
        			calc.Multiplication(b, b),
        			calc.Multiplication(g, a),
        			calc.Multiplication(c, a));
        	
        	for (int i = 0; i < expected.size(); i++) {
		        assertEquals(expected.get(i), actual.get(i), epsilon, 
		        		failMessage(expected.get(i), actual.get(i)));
        	}
        }, "Test timed out.");
    }
    
    // Ensure the Calculator does not take too long
    // to perform Multiplication
    @Test
    public void testMultiplicationTimeout() {
    	assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
    		
    		Calculator calc = new Calculator();
    		
    		for (int i = 0; i < 1000000; i++) {
    			calc.Multiplication(i, i);
    		}
    	}, "Test timed out");
    }
    
    // Ensure Multiplication is performed correctly
    // to a certain number of decimal places determined
    // by epsilon
    @Test
    public void testMultiplicationAfterDecimal() {
    	Calculator calc = new Calculator();

        double a = 3.2;
        double b = 1.5;
        double c = 7.2;
        double d = -3.2;
        double e = -23.04;
        double f = 4.8;
        double g = 23.04;
        double h = 2.25;
        double j = 7.59375;
        double k = 3.375;
        
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
        	
        	List<Double> expected = Arrays.asList(f, e, c, g, h, k, j);
        	List<Double> actual = Arrays.asList(
        			calc.Multiplication(a, b),
        			calc.Multiplication(c, d),
        			calc.Multiplication(b, f),
        			calc.Multiplication(f, f),
        			calc.Multiplication(b, b),
        			calc.Multiplication(b, h),
        			calc.Multiplication(k, h));
        	
        	for (int i = 0; i < expected.size(); i++) {
		        assertEquals(expected.get(i), actual.get(i), epsilon, 
		        		failMessage(expected.get(i), actual.get(i)));
        	}
        }, "Test timed out.");
    }
    
    
 // Tests that Division produces correct results with positive integers and floats
 	@Test
 	public void testDivisionSimple() {
 		Calculator calc = new Calculator();
 					
 		double a = 6;
 		double b = 3;
 		double c = 2;
 					
 		double d = 16.0;
 		double e = 2.5;
 		double f = 6.4;
 		assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
 		        	
 			      List<Double> expected = Arrays.asList(c, f);
 			      List<Double> actual = Arrays.asList(
 			      calc.Division(a, b),
 			      calc.Division(d, e));
 				        
 				  for (int i = 0; i < expected.size(); i++) {
 					  assertEquals(expected.get(i), actual.get(i), epsilon, 
 					     failMessage(expected.get(i), actual.get(i)));
 				  }
 		}, "Test timed out.");
 	}
 	
 	
 	 // Tests that Division produces correct results with negative integers and floats
 	@Test
 	public void testDivisionNegative() {
 		Calculator calc = new Calculator();
 					
 		double a = 6;
 		double b = -3;
 		double c = -2;
 					
 		double d = -16.0;
 		double e = -2.5;
 		double f = 6.4;
 		
 		assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
 		        	
 			      List<Double> expected = Arrays.asList(c, f);
 			      List<Double> actual = Arrays.asList(
 			      calc.Division(a, b),
 			      calc.Division(d, e));
 				        
 				  for (int i = 0; i < expected.size(); i++) {
 					  assertEquals(expected.get(i), actual.get(i), epsilon, 
 					     failMessage(expected.get(i), actual.get(i)));
 				  }
 		}, "Test timed out.");
 	}	

	// Tests that Division produces correct results when a zero is divided by a
	// non-zero value --> always returns 0
	@Test
	public void testDividingZero() {
		Calculator calc = new Calculator();
					
		double a = 0;
		double b = 60.2;
		double c = 0;
		
		assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
		        	
			      List<Double> expected = Arrays.asList(c);
			      List<Double> actual = Arrays.asList(
			      calc.Division(a, b));

				        
				  for (int i = 0; i < expected.size(); i++) {
					  assertEquals(expected.get(i), actual.get(i), epsilon, 
					     failMessage(expected.get(i), actual.get(i)));
				  }
		}, "Test timed out.");
	}	
	
	// Tests that Division produces correct results when any value
	// is divided by 0 --> cannot be computed --> exception thrown
	@Test
	public void testDivideByZero() {
		assertThrows(ArithmeticException.class, ()->{
			Calculator calc = new Calculator();
			double a = -5;
			double b = 0;
			
			calc.Division(a, b);
		});
		
	}
	
	
	// Tests that for any base value, given an integer power, will return the correct results.
	@Test
	public void testPowerOfInteger() {
		Calculator calc = new Calculator();
					
		double a = 2;
		double b = 3;
		double c = 8;
		
		double d = -2.5;
		double e = 2;
		double f = 6.25;
		
		double g = 5;
		double h = -2;
		double i = 0.04;
		
		assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
		        	
			      List<Double> expected = Arrays.asList(c, f, i);
			      List<Double> actual = Arrays.asList(
			      calc.PowerOf(a, b),
			      calc.PowerOf(d, e),
			      calc.PowerOf(g, h));

				        
				  for (int j = 0; j < expected.size(); j++) {
					  assertEquals(expected.get(j), actual.get(j), epsilon, 
					     failMessage(expected.get(j), actual.get(j)));
				  }
		}, "Test timed out.");
	}	
	
	
	// Tests that for any positive base value, given a floating point power
	// will return the correct results.
	@Test
	public void testPowerOfPositiveBase() {
		Calculator calc = new Calculator();
					
		double a = 2;
		double b = 3.2;
		double c = 9.18958684;
		
		double d = 2;
		double e = -3.2;
		double f = 0.1088188204; 
		
		assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
		        	
			      List<Double> expected = Arrays.asList(c, f);
			      List<Double> actual = Arrays.asList(
			      calc.PowerOf(a, b),
			      calc.PowerOf(d, e));

				        
				  for (int i = 0; i < expected.size(); i++) {
					  assertEquals(expected.get(i), actual.get(i), epsilon, 
					     failMessage(expected.get(i), actual.get(i)));
				  }
		}, "Test timed out.");
	}
	

	
	// Tests that with a negative base, it throws an exception when the power is a floating point
	// number. This is because it will be taking some x-th power and some y-th root of 
	// a negative number - resulting in an imaginary number.
	@Test
	public void testFloatingPointPowerOfNegativeBase() {
		assertThrows(ArithmeticException.class, ()->{
			Calculator calc = new Calculator();
			double a = -5;
			double b = 2.1;
			
			calc.PowerOf(a, b);
		});
		
	}
	
	@Test
	public void testZeroToThePowerOf() {
		Calculator calc = new Calculator();
					
		double a = 0;
		double b = 3.2;
		double c = 0;
		
		
		assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
		        	
			      List<Double> expected = Arrays.asList(c);
			      List<Double> actual = Arrays.asList(
			      calc.PowerOf(a, b));

				        
				  for (int i = 0; i < expected.size(); i++) {
					  assertEquals(expected.get(i), actual.get(i), epsilon, 
					     failMessage(expected.get(i), actual.get(i)));
				  }
		}, "Test timed out.");
	}
	
	
	@Test
	public void testPowerOfZero() {
		Calculator calc = new Calculator();
					
		double a = -3.5;
		double b = 0;
		double c = 1;
		
		
		assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
		        	
			      List<Double> expected = Arrays.asList(c);
			      List<Double> actual = Arrays.asList(
			      calc.PowerOf(a, b));

				        
				  for (int i = 0; i < expected.size(); i++) {
					  assertEquals(expected.get(i), actual.get(i), epsilon, 
					     failMessage(expected.get(i), actual.get(i)));
				  }
		}, "Test timed out.");
	} */
}
