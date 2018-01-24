package com.tech.algoritham;

/**
 * LinkedList Store data in linear manner.
 * Testing
 * @author Yuvaraj 
 *
 */
public class LinkedList {
	Node head;

	class Node {
		Node next;
		int data;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public void printLinkedList() {
		Node n = head;
		while (n != null) {
			System.out.println("Linked List data " + n.data);
			n = n.next;
		}
	}

	public void addAtBeginning(int data) {
		if (head == null) {
			Node newNode = new Node(data);
			head = newNode;
			return;
		}

		Node newNode = new Node(data);
		newNode.next = null;
		Node n = head;
		while (n.next != null) {
			n = n.next;
		}
		n.next = newNode;
	}

	public void addAfterGivenNode(int key, int data) {
		if (head == null) {
			return;
		}

		Node n = head;
		while (n != null) {
			if (key == n.data) {
				Node newNode = new Node(data);
				newNode.next = n.next;
				n.next = newNode;
				break;
			}
			n = n.next;
		}
	}

	public void reverseLinkedList() {
		Node current = head;
		Node previous = null;
		while (current != null) {
			Node temp = current.next;
			current.next = previous;
			previous = current;
			current = temp;
		}
		head = previous;
	}

	public int midOfLinkedList() {
		Node fastPtr = head;
		Node slowPtr = head;
		int count = 0;
		while(fastPtr != null && fastPtr.next != null){
			fastPtr  = fastPtr.next.next;
			slowPtr  = slowPtr.next;
			count++;
		}
		return count;
	}
}
