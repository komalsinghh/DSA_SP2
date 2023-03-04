package com.dsa.sp.stack;

import java.util.Scanner;

/**
 * @author komalsingh
 *
 */
public class TwoStackInArray {
	int[] arr;
	int capacity, topl, topr;

	public TwoStackInArray(int capacity) {
		this.capacity = capacity;
		arr = new int[capacity];
		topl = -1;
		topr = capacity;
	}

	void pushLeft(int data) {
		if (topl < topr - 1) {
			arr[++topl] = data;
		} else {
			System.out.println("Stack Overflow");
			return;
		}
	}

	void pushRight(int data) {
		if (topl < topr - 1) {
			arr[--topr] = data;
		} else {
			System.out.println("Stack Overflow");
			return;
		}
	}

	int popLeft() {
		if (topl == -1) {
			System.out.println("Stack Underflow!");
			return -1;
		} else {
			int res = arr[topl];
			topl--;
			return res;
		}

	}

	int popRight() {
		if (topl == capacity) {
			System.out.println("Stack Underflow!");
			return -1;
		} else {
			int res = arr[topr];
			topr++;
			return res;
		}

	}

	int size1() {
		return topl + 1;
	}

	int size2() {
		return capacity - topr;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Capacity");
		int capacity = sc.nextInt();
		TwoStackInArray obj = new TwoStackInArray(capacity);
		char ans = 'y';
		do {
			System.out.println("Enter choice");
			int c = sc.nextInt();
			switch (c) {
			case 1:
				System.out.println("Enter element to push on first");
				obj.pushLeft(sc.nextInt());
				break;
			case 2:
				System.out.println("Enter element to push on second");
				obj.pushRight(sc.nextInt());
				break;
			case 3:
				System.out.println("Pooped from first is"+obj.popLeft());
				break;
			case 4:
				System.out.println("Pooped from first is"+obj.popRight());
				break;
			case 5:
				System.out.println("Size " + obj.size1() + " " + obj.size2());
				break;
			}
			System.out.println("Do you want to perform more operation?");
			ans = sc.next().charAt(0);
		} while (ans == 'y');
		sc.close();
	}

}
