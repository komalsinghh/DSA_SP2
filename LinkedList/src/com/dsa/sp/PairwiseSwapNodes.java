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
public class PairwiseSwapNodes {
	// Efficient method
	static Node pairwiseSwapNodeEfficient(Node head) {
		if (head == null || head.next == null)
			return head;
		Node curr = head.next.next;
		Node prev = head;
		head = head.next;
		head.next = prev;
		while (curr != null && curr.next != null) {
			prev.next = curr.next;
			prev = curr;
			Node next = curr.next.next;
			curr.next.next = curr;
			curr = next;
		}
		prev.next = curr;
		return head;
	}

	// This method is not recommended for object.
	static Node pairwiseSwapNode(Node head) {
		Node curr = head;
		while (curr != null && curr.next != null) {
			int temp = curr.data;
			curr.data = curr.next.data;
			curr.next.data = temp;

			curr = curr.next.next;
		}
		return head;
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
		head = pairwiseSwapNode(head);
		SingleLinkedList.display(head);
		head = pairwiseSwapNodeEfficient(head);
		SingleLinkedList.display(head);
		sc.close();
	}

}
