package com.dsa.sp.stack;

import java.util.Scanner;

/**
 * @author komalsingh
 *
 */
public class KStackInArray {
	int arr[], top[], next[];
	int freeTop = 0, k, capacity;

	public KStackInArray(int k, int capacity) {
		this.k = k;
		this.capacity = capacity;
		arr = new int[capacity];
		top = new int[k];
		next=new int[capacity];
		for (int i = 0; i < k; i++)
			top[i] = -1;
		for (int i = 0; i < capacity - 1; i++)
			next[i] = i + 1;
		next[capacity - 1] = -1;
	}

	void push(int sn, int ele) {
		if (freeTop == -1)
			return;
		// find index
		int index = freeTop;
		// update freeTop
		freeTop = next[index];
		// insert element to array
		arr[index] = ele;
		// update next
		next[index] = top[sn];
		// update top
		top[sn] = index;

	}

	int pop(int sn) {
		if (top[sn] == -1)
			return -1;
		int index = top[sn];
		top[sn] = next[index];
		next[index] = freeTop;
		freeTop = index;
		return arr[index];

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of an array");
		int n = sc.nextInt();
		System.out.println("Enter the value of K");
		int k = sc.nextInt();
		KStackInArray obj = new KStackInArray(k, n);
		System.out.println("Enter no. of queries");
		int q = sc.nextInt();
		while (q-- > 0) {
			System.out.println("Enter choice");
			int c = sc.nextInt();
			switch (c) {
			case 1:
				System.out.println("Enter stack num and element to push");
				int sn = sc.nextInt();
				int ele = sc.nextInt();
				obj.push(sn, ele);
				break;
			case 2:
				System.out.println("Enter Stack number");
				int sno = sc.nextInt();
				System.out.println("Popped element " + obj.pop(sno));
				break;
			}
		}
		sc.close();
	}

}
