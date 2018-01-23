package com.tech.string;

public class HackerRankString {

	public static void main(String[] args) {
		char[] query = { 'h', 'a', 'c', 'k', 'e', 'r', 'r', 'a', 'n', 'k' };
		System.out.println(verifyAndPrint(query, "haacckkrrannkk"));

	}

	public static String verifyAndPrint(char[] query, String s) {
		char[] inputArray = s.toCharArray();
		int j = 0;
		for (int i = 0; i < query.length; i++) {
			for (; j < inputArray.length; j++) {
				if (query[i] == inputArray[j]) {
					if (i == query.length - 1) {
						return "YES";
					}
					j++;
					break;
				}
			}
		}
		return "NO";
	}

}
