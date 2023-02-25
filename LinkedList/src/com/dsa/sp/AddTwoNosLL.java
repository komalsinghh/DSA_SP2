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
public class AddTwoNosLL {
	static Node reverse(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node curr = head, prev = null;
		while (curr != null) {
			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	// Function to add two numbers represented by linked list.
	static Node addTwoLists(Node first, Node second) {
		
		first = reverse(first);
		second = reverse(second);
		Node ans = new Node(-1);
		Node curr = ans;
		int carry = 0;
		while (first != null || second != null || carry >= 1) {
			int sum = 0;
			if (first != null) {
				sum += first.data;
				first = first.next;
			}
			if (second != null) {
				sum += second.data;
				second = second.next;
			}
			sum += carry;
			carry = sum / 10;
			Node newNode = new Node(sum % 10);
			curr.next = newNode;
			curr = curr.next;
		}
		return reverse(ans.next);

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
		System.out.println("How many elements to add into LL?");
		int m = sc.nextInt();
		Node head1 = null;
		while (m-- > 0) {
			System.out.println("Enter an element");
			int data = sc.nextInt();
			head1 = SingleLinkedList.insert(head1, data);
		}
		SingleLinkedList.display(head1);
		Node res = addTwoLists(head, head1);
		SingleLinkedList.display(res);
		sc.close();
	}

}
