package com.tech.string;

public class Runn {

	public static void main(String[] args) {
		int x = 2437;
		int y = 875;
		int count = 1;
		
		while(x > y || y > x) {
			if(x > y){
				x = x -y;
			}
			else if(y > x){
				y = y -x;
			}
		}
		System.out.println(x);
	}

}
