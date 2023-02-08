/**
 * 
 */
package com.dsa.sp;

import java.util.Scanner;

/**
 * @author komalsingh
 *
 */
public class CircularDoublyLL {
	static class Node {
		int data;
		Node prev;
		Node next;

		public Node(int data) {
			this.data = data;
		}

	}

	static Node insertAtBegin(Node head, int ele) {
		Node temp = new Node(ele);
		if (head == null) {
			temp.next = temp;
			temp.prev = temp;
			return temp;
		}
		temp.prev = head.prev;
		temp.next = head;
		head.prev.next = temp;
		head.prev = temp;
		return temp;
	}

	static Node insertAtLast(Node head, int ele) {
		Node temp = new Node(ele);
		if (head == null) {
			temp.next = temp;
			temp.prev = temp;
			return temp;
		}
		temp.prev = head.prev;
		temp.next = head;
		head.prev.next = temp;
		head.prev = temp;
		return head;
	}

	static int countList(Node head) {
		int count = 0;
		Node curr = head;
		while (curr.next != head) {
			curr = curr.next;
			count++;
		}
		count++;
		return count;
	}

	static Node insertAtPosition(Node head, int pos, int ele) {
		Node newNode = new Node(ele);
		Node curr = head;
		int count = countList(head);
		if (head == null || count < pos)
			return head;
		if (pos == 1) {
			return insertAtBegin(head, ele);
		} else {
			for (int i = 1; i < pos - 1; i++) {
				curr = curr.next;
			}
			newNode.next = curr.next;
			curr.next.prev = newNode;
			curr.next = newNode;
			newNode.prev = curr;
			return head;
		}
	}

	static void display(Node head) {
		if (head == null)
			return;
		Node curr = head;
		do {
			System.out.print(curr.data + " ");
			curr = curr.next;
		} while (curr != head);
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many elements to add into LL?");
		int n = sc.nextInt();
		Node head = null;
		while (n-- > 0) {
			System.out.println("Enter an element");
			int data = sc.nextInt();
			head = insertAtLast(head, data);
		}
		display(head);
		System.out.println("Enter an element to insert at begin");
		int ele = sc.nextInt();
		head = insertAtBegin(head, ele);
		display(head);
		System.out.println("Enter position and element to insert");
		int elePos = sc.nextInt();
		int eleAtPos = sc.nextInt();
		head = insertAtPosition(head, elePos, eleAtPos);
		display(head);
		sc.close();
	}

}
