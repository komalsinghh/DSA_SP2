package com.dsa.sp;

import java.util.Scanner;

import com.dsa.sp.SingleLinkedList.Node;

public class MergeSortForLL {
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
				temp = left;
				left = left.next;
			} else {
				temp.next = right;
				temp = right;
				right = right.next;
			}
		}
		while (left != null) {
			temp.next = left;
			temp = left;
			left = left.next;
		}
		while (right != null) {
			temp.next = right;
			temp = right;
			right = right.next;
		}
		ans = ans.next;
		return ans;
	}

	// Function to sort the given linked list using Merge Sort.
	static Node mergeSort(Node head) {
		if (head == null || head.next == null)
			return head;
		// breaking linked list into two halves
		Node mid = findMid(head);
		Node left = head;
		Node right = mid.next;
		mid.next = null;
		// Recursive call to sort both the list
		left = mergeSort(left);
		right = mergeSort(right);
		// Merging both left and right half
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
			head = SingleLinkedList.insert(head, data);
		}
		SingleLinkedList.display(head);
		head = mergeSort(head);
		SingleLinkedList.display(head);
		sc.close();
	}

}
