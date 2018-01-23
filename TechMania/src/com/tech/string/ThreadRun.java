package com.tech.string;

public class ThreadRun {

	public static void main(String str[]) {
		/*String[] in = new String[] { "ab", "aab", "abb", "abab" };
		int[] opArr = minOps(in);
		for (Integer val : opArr) {
			System.out.println(val);
		}*/
		System.out.println(Character.isUpperCase('C'));
	}

	private static int[] minOps(String[] in) {
		int[] opArr = new int[in.length];
		for (int j = 0; j < in.length; j++) {
			char previousChar = '$';
			int isReplaceCount = 0;
			String val = in[j];
			for (int i = 0; i < val.length(); i++) {
				char currentChar = val.charAt(i);
				if (previousChar == currentChar) {
					isReplaceCount = isReplaceCount + 1;
					previousChar = '#';
				} else {
					previousChar = currentChar;
				}
			}
			opArr[j] = isReplaceCount;
		}
		return opArr;
	}
}
