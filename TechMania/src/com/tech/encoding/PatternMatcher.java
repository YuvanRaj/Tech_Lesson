package com.tech.encoding;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 *  1. Class will Split the Equation by "="
 *  2. String will split into LHS,RHS String array.
 *  3. Process the LHS array, collect the X variable Co efficient values and add up the values , collect the constant values and add up the values.
 *  4. Add the final cumulative value of X co efficient and constant value in list
 *  5. Do the Step3,4 for RHS
 *  6. Calculate the X by  (LHS Cumulative Constant Value - RHS Cumulative Constant Value)( LHS X variable Cumulative Co efficient Value -  RHS X variable Cumulative Co efficient Value)
 */

public class PatternMatcher {

	public static void main(String[] args) {
		Pattern p = Pattern.compile("(?=[-+])");   // Match the Pattern After  ?= if want to include *,/ we can use (?=[-+*/])
		String equation = "2x+5-3x = 7-x +3x";
		
		String[] splitArray = equation.split("=");
		List<Double> finalSolutionList = new ArrayList<Double>();
		for(String lhsrhsSpliArray : splitArray) {
			String[] str = p.split(lhsrhsSpliArray);
			double xCoff = 0;
			double constant = 0;
			for (String value : str) {
				if (value.contains("x")) {
					String[] insideValue = value.split("x");
					Double coEffValue = insideValue[0].matches(".*\\d+.*") ? Double.parseDouble(insideValue[0]) : insideValue[0].contains("+") ? 1 : -1;
					xCoff = xCoff + coEffValue;
				} else {
					constant = constant + Double.parseDouble(value.trim());
				}
			}
			finalSolutionList.add(xCoff);
			finalSolutionList.add(constant);
		}
		double solution  = (finalSolutionList.get(0) - finalSolutionList.get(2)) != 0 ? (finalSolutionList.get(3) - finalSolutionList.get(1)) / (finalSolutionList.get(0) - finalSolutionList.get(2)) : 0;
		System.out.println(solution);
	}

}
