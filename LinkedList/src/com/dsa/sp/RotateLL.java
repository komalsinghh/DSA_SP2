/**
 * 
 */
package com.dsa.sp;

import java.util.Scanner;

import com.dsa.sp.SingleLinkedList.Node;

/**
 * @author komalsingh
 *
 */
public class RotateLL {
	static Node rotate(Node head, int k) {
		if (head == null || head.next == null)
			return head;
		Node firstHead = new Node(-1);
		Node secondHead = new Node(-1);
		Node first = firstHead, second = secondHead;
		for (int i = 0; i < k; i++) {
			if (head == null)
				break;
			first.next = head;
			first = head;
			head = head.next;
		}
		first.next = null;
		while (head != null) {
			second.next = head;
			second = head;
			head = head.next;
		}
		second.next = firstHead.next;
		return secondHead.next;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many elements to add into LL?");
		int n = sc.nextInt();
		Node head = null;
		while (n-- > 0) {
			System.out.println("Enter an element");
			int data = sc.nextInt();
			head = SingleLinkedList.insert(head, data);
		}
		SingleLinkedList.display(head);
		System.out.println("Enter K");
		int k = sc.nextInt();
		head = rotate(head, k);
		SingleLinkedList.display(head);
		sc.close();
	}

}
