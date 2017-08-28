package com.angular.rest;



public class PolynomialCalculator {
	public static void main(String[] args) {
		PolynomialCalculator polynomialCalculator = new PolynomialCalculator();
		Double[] outputValue = polynomialCalculator.getSolutionForPolynomialEquation(2,3,4);
		
		System.out.println("X value1 "+outputValue[0]);
		System.out.println("X value2 "+outputValue[1]);
	}
	
	/**
	 * Method will find the root solution for second order polynomial
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public Double[] getSolutionForPolynomialEquation(double a,double b,double c){
		double root = Math.sqrt((b * b) - (4 * a * c));
		double solution1 = 0.0;
		double solution2 = 0.0;
		System.out.println("Qudratic Equation *** "+a+"x^2+"+b+"x+"+c);
		if(Double.compare(root, 0.0) == 0){
			solution1 = -(b/(2*a));
			solution2 = -(b/(2*a));
			System.out.println("*************** Root1 is "+solution1);
			System.out.println("*************** Root2 is "+solution2);
			
		}else if(root > 0.0){
			solution1 = (-b + root) /(2 * a);
			solution2 = (-b - root) /(2 * a);
			System.out.println("*************** Root1 is "+solution1);
			System.out.println("*************** Root2 is "+solution2);
		}
		else {
			System.out.println("Roots are Imaginary !!!!");
		}
		return new Double[]{solution1,solution2};
	}
	
	public Double[] getSolutionsForUnknownLinearEquByTwoVariable(Double[] equation1,Double[] equation2){
		
		if(isZeroCoefficent(equation1,equation2)){
			return new Double[]{0.0,0.0};	
		}
		
		if(Double.compare(equation1[1], 0.0) == 1 && Double.compare(equation2[1], 0.0) == 1){
			// Multiply Equation 1 by Equation 2 Co efficient.
			Double[] modifiedArray1 = new Double[]{equation1[1]*equation2[1],equation1[2]*equation2[1],equation1[3]*equation2[1]};
			Double[] modifiedArray2 = new Double[]{equation2[1]*equation1[1],equation2[2]*equation1[1],equation2[3]*equation1[1]};
			
			Double secondCoffient = (modifiedArray1[3]-modifiedArray2[3]) / (modifiedArray1[2] - modifiedArray2[2]);
			Double firstCoEfficient = 0.0;
		}
		
		return new Double[]{0.0,0.0};
	}

	private boolean isZeroCoefficent(Double[] equation1, Double[] equation2) {
		if(equation1[1].equals("0") && equation1[2].equals("0")){
			return true;	
		}
		if(equation2[1].equals("0") && equation2[2].equals("0")){
			return true;	
		}
		return false;
	}



}
