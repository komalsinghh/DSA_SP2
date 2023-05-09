/**
 * 
 */
package com.dsa.sp.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author komalsingh
 *
 */
public class NextGreaterElement {
	//Efficient Approach O(n)
	static void nextGreater(int[] arr, int n) {
		ArrayList<Integer> al=new ArrayList<>();
		Stack<Integer> s = new Stack<>();
		s.push(arr[n-1]);
		al.add(-1);
		for(int i=n-2;i>=0;i--) {
			while(s.isEmpty()==false && s.peek()<=arr[i]) {
				s.pop();
			}
			int ng=s.isEmpty()?-1:s.peek();
			al.add(ng);
			s.push(arr[i]);
		}
		Collections.reverse(al);
		for(int i:al) {
			System.out.print(i+" ");
		}
	}
	
	//Naive Approach O(n^2)
	/*
	static void nextGreater(int[] arr, int n) {
		for(int i=0;i<n;i++) {
			int j;
			for( j=i+1;j<n;j++) {
				if(arr[j]>arr[i]) {
					System.out.print(arr[j]+" ");
					break;
				}
			}
			if(j==n)
				System.out.print(-1);
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
		nextGreater(arr, capacity);
		sc.close();
	}

}
