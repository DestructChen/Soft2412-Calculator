import java.lang.Math;

public class Calculator {

  public double Subtraction(double x, double y) {
    return x - y;
  }

  public double Addition(double x, double y) {
    return x + y;
  }

  public double Multiplication(double x, double y) {
      return x * y;
  }
  	
//  // Throws arithmetic exception when trying to divide by zero.
//  public double Division(double x, double y) throws ArithmeticException {
//	  if (y == 0) {
//		  throw new ArithmeticException("Math ERROR - cannot divide by 0");
//	  }
//	  return x / y;
//  }
//  
//  
//  // Throws arithmetic exception when trying to find the root of a negative number.
//  // this occurs when there is a negative base x, and a non-integer power y.
//  public double PowerOf(double x, double y) throws ArithmeticException {
//	  if (x < 0) {
//		  if (Math.ceil(y) != y) {
//			  throw new ArithmeticException("Math ERROR - cannot compute complex number");
//		  }
//	  }
//	  
//	  return Math.pow(x, y);
//  }
  
}
