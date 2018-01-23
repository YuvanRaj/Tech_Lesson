package com.tech.encoding;

import java.util.HashSet;
import java.util.Set;

public class SumOfTwoNumber {

	public static void main(String[] str) {
		int[] testArr = {0, 14, 0, 4, 7, 8, 3, 5, 7};

		printPairsUsingSet(testArr, 11);
	}

	public static void printPairsUsingSet(int[] numbers, int n) {
		if (numbers.length < 2) {
			return;
		}
		Set set = new HashSet(numbers.length);
		for (int value : numbers) {
			int target = n - value;
			if (!set.contains(target)) {
				set.add(value);
			} else {
				System.out.printf("(%d, %d) %n", value, target);
			}
		}
	}

}
