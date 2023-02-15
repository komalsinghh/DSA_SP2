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
public class RecursiveReverseLL {
	static Node recursiveReverse(Node curr, Node prev) {
		if(curr==null)
			return prev;
		Node next=curr.next;
		curr.next=prev;
		return recursiveReverse(next, curr);
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
		head=recursiveReverse(head,null);
		SingleLinkedList.display(head);
		sc.close();
	}

}
