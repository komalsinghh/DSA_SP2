package com.dsa.sp.stack;

import java.util.Scanner;

/**
 * @author komalsingh
 *
 */
class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
	}
}

public class StackImplUsingLL {
	Node head;
	int size;

	public StackImplUsingLL() {
		head = null;
		size = 0;
	}

	void push(int data) {
		Node temp = new Node(data);
		temp.next = head;
		head = temp;
		size++;
	}

	int pop() {
		if (head == null) {
			return Integer.MAX_VALUE;
		}
		int res = head.data;
		head = head.next;
		return res;
	}

	int peek() {
		if (head == null) {
			return Integer.MAX_VALUE;
		}
		return head.data;
	}

	int size() {
		return size;
	}

	boolean isEmpty() {
		return head == null;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StackImplUsingLL obj = new StackImplUsingLL();
		char ans = 'y';
		do {
			System.out.println("Enter choice");
			int c = sc.nextInt();
			switch (c) {
			case 1:
				System.out.println("Enter an element to push");
				int data = sc.nextInt();
				obj.push(data);
				break;
			case 2:
				System.out.println("The popped element is " + obj.pop());
				break;
			case 3:
				System.out.println(obj.size());
				break;
			case 4:
				System.out.println("The top element is" + obj.peek());
				break;
			case 5:
				System.out.println("The stack is empty?" + obj.isEmpty());
				break;

			}
			System.out.println("Do you want to perform more operation?");
			ans = sc.next().charAt(0);
		} while (ans == 'y');
		sc.close();
	}

}
