package com.dsa.sp.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author komalsingh
 *
 */
public class StackUsingCollection {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Deque<Integer> deq=new ArrayDeque<>();
		char ans='y';
		do {
			System.out.println("Enter choice");
			int c = sc.nextInt();
			switch (c) {
			case 1:
				System.out.println("Enter an element to push");
				int data = sc.nextInt();
				deq.push(data);
				break;
			case 2:
				System.out.println("The popped element is " + deq.pop());
				break;
			case 3:
				System.out.println("The top element is" + deq.peek());
				break;
			case 4:
				System.out.println("The stack is empty?" + deq.isEmpty());
				break;
			
			}
			System.out.println("Do you want to perform more operation?");
			ans = sc.next().charAt(0);
		} while (ans == 'y');
		sc.close();
	}

}
