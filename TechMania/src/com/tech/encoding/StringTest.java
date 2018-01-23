package com.tech.encoding;

public class StringTest {

	public static void main(String[] args) {
		String input = "Yuvaraj";
		
		for(int i= input.length()-1;i>=0;i--){
			System.out.println(input.charAt(i));
		}
		
		System.out.println(input.substring(5));
		System.out.println(input.replace('v', 'm'));
	}

}
