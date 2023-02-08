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
public class SortedInsertSinglyLL {
	static Node sortedInsert(Node head, int ele) {
		Node temp = new Node(ele);
		if (head == null)
			return temp;
		if (ele < head.data) {
			temp.next = head;
			return temp;
		}
		Node curr = head;
		while (curr.next != null && ele > curr.next.data)
			curr = curr.next;

		temp.next = curr.next;
		curr.next = temp;

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
		System.out.println("Enter an element to insert");
		int ele = sc.nextInt();
		head = sortedInsert(head, ele);
		SingleLinkedList.display(head);
		sc.close();
	}

}
