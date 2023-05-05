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

	static void stockSpan(int[] arr, int n) {
		Stack<Integer> s=new Stack<>();
		int span=0;
		s.add(0);
		System.out.print(1+" ");
		for(int i=1;i<n;i++) {
			while(s.isEmpty()==false && arr[s.peek()]<=arr[i]) {
				s.pop();
			}
		span=s.isEmpty()?i+1:i-s.peek();
		s.push(i);
		System.out.print(span+" ");
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Capacity");
		int capacity = sc.nextInt();
		int[] arr =new int[capacity];
		for(int i=0;i<capacity;i++) {
			arr[i]=sc.nextInt();
		}
		stockSpan(arr,capacity);
		sc.close();
	}

}
