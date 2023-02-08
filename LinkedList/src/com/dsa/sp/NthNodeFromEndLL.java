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
public class NthNodeFromEndLL {
	// Method 2 using two pointer/reference
	static int nthNodeEfficient(Node head, int pos) {
		if (head == null)
			return -1;
		Node fast = head, slow = head;
		for (int i = 0; i < pos; i++) {
			if (fast == null)
				return -1;
			fast = fast.next;
		}
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow.data;
	}

	// Method 1 using length of LL
	static int nthNode(Node head, int pos) {
		int len = 0;
		for (Node curr = head; curr != null; curr = curr.next, ++len);
		if (len < pos)
			return -1;
		Node curr = head;
		for (int i = 0; i < (len - pos); i++) {
			curr = curr.next;
		}
		return curr.data;
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
		System.out.println("Enter position");
		int pos = sc.nextInt();
		System.out.println(nthNode(head, pos) + " efficient->" + nthNodeEfficient(head, pos));
		sc.close();
	}

}
