/**
 * 
 */
package com.dsa.sp;

import java.util.Scanner;

/**
 * The Class SingleLinkedList.
 *
 * @author komalsingh
 */
public class SingleLinkedList {
	
	/**
	 * The Class Node.
	 */
	static class Node {
		
		/** The data. */
		int data;
		
		/** The next. */
		Node next;

		/**
		 * Instantiates a new node.
		 *
		 * @param data the data
		 */
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	/**
	 * Insert.
	 *
	 * @param head the head
	 * @param data the data
	 * @return the node
	 */
	static Node insert(Node head, int data) {
		Node curr = head;
		if (curr == null) {
			head = new Node(data);
		} else {
			while (curr.next != null) {
				curr = curr.next;
			}
			curr.next = new Node(data);
		}
		return head;
	}

	/**
	 * Display.
	 *
	 * @param head the head
	 */
	static void display(Node head) {
		Node curr = head;
		if (curr == null) {
			System.out.println("List is empty");
		} else {
			while (curr != null) {
				System.out.print(curr.data + " ");
				curr = curr.next;
			}
		}
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many elements to add into LL?");
		int n = sc.nextInt();
		Node head = null;
		while (n-- > 0) {
			System.out.println("Enter an element");
			int data = sc.nextInt();
			head = insert(head, data);
		}
		display(head);
		sc.close();
	}

}
