/**
 * 
 */
package com.dsa.sp;

import java.util.Scanner;

import com.dsa.sp.DoublyLinkedList.Node;

/**
 * @author komalsingh
 *
 */
public class MergeSortDoublyLL {
	static Node findMid(Node head) {
		Node slow = head, fast = head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	static Node merging(Node left, Node right) {
		if (left == null)
			return right;
		if (right == null)
			return left;
		Node ans = new Node(-1);
		Node temp = ans;
		while (left != null && right != null) {
			if (left.data <= right.data) {
				temp.next = left;
				left.prev = temp;
				temp = left;
				left = left.next;
			} else {
				temp.next = right;
				right.prev = temp;
				temp = right;
				right = right.next;
			}
		}
		while (left != null) {
			temp.next = left;
			left.prev = temp;
			temp = left;
			left = left.next;
		}
		while (right != null) {
			temp.next = right;
			right.prev = temp;
			temp = right;
			right = right.next;
		}

		ans = ans.next;
		ans.prev = null;
		return ans;
	}

	static Node sortDoubly(Node head) {
		if (head == null || head.next == null)
			return head;
		Node mid = findMid(head);
		Node left = head;
		Node right = mid.next;
		mid.next = null;
		left = sortDoubly(left);
		right = sortDoubly(right);
		Node res = merging(left, right);
		return res;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many elements to add into LL?");
		int n = sc.nextInt();
		Node head = null;
		while (n-- > 0) {
			System.out.println("Enter an element");
			int data = sc.nextInt();
			head = DoublyLinkedList.insert(head, data);
		}
		DoublyLinkedList.display(head);
		head = sortDoubly(head);
		DoublyLinkedList.display(head);
		sc.close();
	}

}
