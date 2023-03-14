package com.dsa.sp.stack;

import java.util.Scanner;

/**
 * @author komalsingh
 *
 */
class MyStack {
	int top, capacity;
	int[] arr;

	public MyStack(int capacity) {
		this.capacity = capacity;
		top = -1;
		arr = new int[capacity];
	}

	void push(int data) throws Exception {
		if (top == capacity - 1) {
			throw new Exception("Stack is Full");
		}
		top++;
		arr[top] = data;
	}

	int pop() throws Exception {
		if (top == -1) {
			throw new Exception("Stack is Empty");
		}
		int res = arr[top];
		--top;
		return res;
	}

	int peek() throws Exception {
		if (top == -1) {
			throw new Exception("Stack is Empty");
		}
		return arr[top];
	}

	boolean isEmpty() {
		return top == -1;
	}

	void display() throws Exception {
		if (top == -1) {
			throw new Exception("Stack is Empty");
		}
		for (int i = 0; i <= top; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}

public class StackImplementation {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Capacity");
		int n = sc.nextInt();
		char ans = 'y';
		MyStack obj = new MyStack(n);

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
				obj.display();
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
