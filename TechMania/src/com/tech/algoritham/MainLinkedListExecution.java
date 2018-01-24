package com.tech.algoritham;

public class MainLinkedListExecution {

	public static void main(String str[]){
		LinkedList li = new LinkedList();
		
		li.addAtBeginning(1);
		li.addAtBeginning(2);
		li.addAtBeginning(3);
		li.addAtBeginning(4);
		li.addAtBeginning(5);
		
		li.addAfterGivenNode(3, 6);
		
		li.printLinkedList();
		System.out.println("After Reverse");
		li.reverseLinkedList();
		li.printLinkedList();
	}
}
