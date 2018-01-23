package com.tech.string;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CountMaxOccurChar {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		String convertString = input.toLowerCase();
		String trimmedString = convertString.replaceAll("\\s+", "");

		boolean isPangram = false;
		char[] charArray = trimmedString.toCharArray();
		Set<Character> alphabetSet = new HashSet<Character>();
		for (Character character : charArray) {
			alphabetSet.add(character);
			if (alphabetSet.size() == 26) {
				System.out.println("pangram");
				isPangram = true;
				break;
			}
		}
		if (!isPangram) {
			System.out.println("not pangram");
		}
		scanner.close();
	}

}
