package com.tech.encoding;

public class CountOne {

	public static void main(String[] args) {
		int[] binaryArray = new int[] {1, 1, 1, 1, 1, 1, 1 };
		int oneCount = printOne(binaryArray, 0, binaryArray.length - 1);
		System.out.println(oneCount);
	}

	private static int printOne(int[] arr, int low, int high) {
		int mid = (low + high) / 2;

		while (high >= low) {
			if (arr[mid] == 1) {
				return arr.length - mid;
			} else {
				low = mid+1;
				return printOne(arr, low, high);
			}
		}
		return 0;

	}

}
