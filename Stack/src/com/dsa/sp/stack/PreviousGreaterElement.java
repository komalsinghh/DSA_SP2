/**
 * 
 */
package com.dsa.sp.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author komalsingh
 *
 */
public class PreviousGreaterElement {

	static void prevGreater(int[] arr, int n) {
		Stack<Integer> s = new Stack<>();
		s.push(arr[0]);
		System.out.print(-1 + " ");
		for (int i = 1; i < n; i++) {
			while (s.isEmpty() == false && s.peek() <= arr[i]) {
				s.pop();
			}
			int span = s.isEmpty() ? -1 : s.peek();
			s.push(arr[i]);
			System.out.print(span + " ");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Capacity");
		int capacity = sc.nextInt();
		int[] arr = new int[capacity];
		System.out.println("Enter element");
		for (int i = 0; i < capacity; i++) {
			arr[i] = sc.nextInt();
		}
		prevGreater(arr, capacity);
		sc.close();

	}

}
