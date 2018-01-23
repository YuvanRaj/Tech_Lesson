package com.tech.encoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ObjectLogic {
	
	public static void main(String str[]){
		
		/*Employee empFirst = new Employee(1,"Test");
		Employee empSecond = empFirst;
		empSecond = null;
		
		System.out.println(empFirst.getEmpId());
		System.out.println(empSecond.getEmpId());*/
		
		/*String input ="YES      leading spaces        are valid,    problemsetters are         evillllll";
		
		String[] terms = input.split("[\\s@!?._',]+");
		System.out.println(terms.length);
		for(String value : terms){
			System.out.println(value);
		}*/
		/*int[] test = new int[]{5,4,3,2,1};
		findNumber(test,2);*/
		Set<Integer> val = new HashSet<Integer>();
		int[] test = new int[]{1,2,9,1,2,3,1,4,1,5,7};
		for(Integer intValue : test){
			val.add(intValue);
		}
		List<Integer> list = new ArrayList(val);
		Collections.sort(list);
		for(Integer m : list){
			System.out.print(m+"\t");
		}
	}

	private static void findNumber(int[] arr, int k) {
		if(arr == null || arr.length ==0){
			System.out.println("NO");
			return;
		}
		boolean isMatchFound = false;
		for(Integer intValue : arr){
			if(intValue == k){
				isMatchFound = true;
				break;
			}
		}
		if(isMatchFound){
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}
}
