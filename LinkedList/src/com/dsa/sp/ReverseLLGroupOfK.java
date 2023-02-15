/**
 * 
 */
package com.dsa.sp;

import java.util.Scanner;

import com.dsa.sp.SingleLinkedList.Node;

/**
 * @author komalsingh01
 *
 */
public class ReverseLLGroupOfK {
	// Iterative T.C- O(n) S.C- O(1)
	static Node reverseInKSizeIterative(Node head, int n) {
		Node curr = head, prevFirst = null;
		boolean isFirstPass = true;
		while (curr != null) {
			Node prev = null, first = curr;
			int count = 0;
			while (curr != null && count < n) {
				Node next = curr.next; //reversing
				curr.next = prev;
				prev = curr;
				curr = next;
				count++;
			}
			if (isFirstPass) {
				head = prev;
				isFirstPass = false;
			} else {
				prevFirst.next = prev;
			}
			prevFirst = first;
		}
		return head;
	}

	// Recursive T.C- O(n) S.C- O(n)
	static Node reverseInKSize(Node head, int n) {
		Node curr = head, prev = null, next = null;
		int count = 0;
		while (curr != null && count < n) {
			next = curr.next;//reversing
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}
		if (next != null) {
			Node restHead = reverseInKSize(next, n);
			head.next = restHead;
		}
		return prev;
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
		System.out.println("Enter Size");
		int size = sc.nextInt();
		head = reverseInKSize(head, size);
		SingleLinkedList.display(head);
		head = reverseInKSizeIterative(head, size);
		SingleLinkedList.display(head);
		sc.close();
	}

}
