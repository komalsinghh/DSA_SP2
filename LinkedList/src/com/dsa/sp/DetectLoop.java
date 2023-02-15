/**
 * 
 */
package com.dsa.sp;

import java.util.HashSet;
import java.util.Scanner;

import com.dsa.sp.SingleLinkedList.Node;

/**
 * @author komalsingh
 *
 */
public class DetectLoop {
	// By using Hashing T.C S.C= O(n)
	static boolean isLoopHashing(Node head) {
		HashSet<Node> hashSet = new HashSet<Node>();
		for (Node curr = head; curr != null; curr = curr.next) {
			if (hashSet.contains(curr))
				return true;
			hashSet.add(curr);
		}
		return false;
	}

	// By changing reference T.C- O(n) but it will destroy the whole list
	static boolean isLoop(Node head) {
		Node temp = new Node(0);
		Node curr = head;
		while (curr != null) {
			if (curr.next == null)
				return false;
			if (curr.next == temp)
				return true;
			Node curr_next = curr.next;
			curr.next = temp;
			curr = curr_next;
		}
		return false;
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
		head.next.next.next.next = head.next; // creating loop
		if (isLoop(head)) {
			System.out.println("Yes, loop detected!");
		} else
			System.out.println("No loop!");
		System.out.println(isLoopHashing(head));
		sc.close();
	}

}
