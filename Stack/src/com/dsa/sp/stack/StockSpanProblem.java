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
public class StockSpanProblem {
	
	//Efficient Solution O(n) S.C- O(n)
	static void stockSpan(int[] arr, int n) {
		Stack<Integer> s = new Stack<>();
		int span = 0;
		s.add(0);
		System.out.print(1 + " ");
		for (int i = 1; i < n; i++) {
			while (s.isEmpty() == false && arr[s.peek()] <= arr[i]) {
				s.pop();
			}
			span = s.isEmpty() ? i + 1 : i - s.peek();
			s.push(i);
			System.out.print(span + " ");
		}
	}
	
	//Naive Solution T.C- O(n^2) 
	/*static void stockSpan(int[] arr, int n) {
		for(int i=0;i<n;i++) {
			int span=1;
			for(int j=i-1;j>=0 && arr[i]>=arr[j]; j--) {
				span++;
			}
			System.out.print(span+" ");
		}
	}*/
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Capacity");
		int capacity = sc.nextInt();
		int[] arr = new int[capacity];
		System.out.println("Enter element");
		for (int i = 0; i < capacity; i++) {
			arr[i] = sc.nextInt();
		}
		stockSpan(arr, capacity);
		sc.close();
	}

}
