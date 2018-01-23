package com.tech.encoding;

import java.util.Scanner;

public class ReverseInteger {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        printReverseOrder(arr);
    }

	private static void printReverseOrder(int[] arr) {
		for (int j = arr.length - 1; j >= 0; j--) {
			System.out.print(arr[j]);
			if (j != 0) {
				System.out.print(" ");
			}
		}
	}
	
}
