/**
 * 
 */
package com.dsa.sp;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author komalsingh
 *
 */
public class PalindromeLL {
	static class Node {
		char data;
		Node next;

		Node(char data) {
			this.data = data;
		}
	}

	static Node reverse(Node head) {
		Node curr = head;
		Node prev = null, next = null;
		if (head == null || head.next == null)
			return null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	// T.C- O(n) S.C- O(1)
	static boolean isPalindromeEfficient(Node head) {
		if (head == null)
			return true;
		Node slow = head;
		Node fast = head;// finding middle of ll
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		Node rev = reverse(slow.next);
		Node curr = head;
		while (rev != null) {
			if (curr.data != rev.data)
				return false;
			rev = rev.next;
			curr = curr.next;
		}
		return true;
	}

	// T.C- O(n) S.C- O(n)
	static boolean isPalindrome(Node head) {
		Deque<Character> stack = new ArrayDeque<>();
		for (Node curr = head; curr != null; curr = curr.next) {
			stack.push(curr.data);
		}
		for (Node curr = head; curr != null; curr = curr.next) {
			if (stack.pop() != curr.data)
				return false;
		}
		return true;
	}

	static Node addAtLast(Node head, char data) {
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
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter length of String");
		int n = sc.nextInt();
		Node head = null;
		while (n-- > 0) {
			System.out.println("Enter Character");
			char c = sc.next().charAt(0);
			head = addAtLast(head, c);
		}
		display(head);
		System.out.println(isPalindrome(head));
		System.out.println(isPalindromeEfficient(head));
		display(head);
		sc.close();
	}

}
