package com.tech.encoding;

public class SimplyLinkedList {

	Node head;
	
	public void printList(){
		Node node = head;
		while(node != null){
			System.out.println(node.data);
			node = node.next;
		}
	}
	
	
	public static void main(String str[]){
		SimplyLinkedList test = new SimplyLinkedList();
		
		// Created Three nodes
		test.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		
		//We need to link each node
		
		test.head.next = second;
		second.next = third;
		
		test.printList();
		
	}
	
}
