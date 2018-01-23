package com.tech.encoding;

import java.util.Arrays;
import java.util.Collections;

public class KThLargest {

	public static void main(String[] args) {
		Integer[] array = new Integer[] { 1, 5, 2, 4, 3, 50, 33 };

		Integer kThSmallestElement = getKthSmallestElement(array, 2);
		Integer kThLargestElement = getKthLargestElement(array, 2);

		System.out.println(kThSmallestElement);
		System.out.println(kThLargestElement);
	}

	private static Integer getKthLargestElement(Integer[] array, int i) {
		Arrays.sort(array, Collections.reverseOrder());
		return array[i - 1];
	}

	private static Integer getKthSmallestElement(Integer[] array, int i) {
		Arrays.sort(array);
		return array[i - 1];
	}

}
