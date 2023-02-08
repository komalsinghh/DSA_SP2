/**
 * 
 */
package com.dsa.sp;

import java.util.Scanner;

import com.dsa.sp.SingleLinkedList.Node;

/**
 * @author komalsingh01
 *
 */
public class MiddleOfLL {
	//Efficient Approach
	static int middleElementEfficient(Node head) {
		if(head==null)
			return 0;
		Node slow=head,fast=head;
		while(fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow.data;
	}
	//Naive Approach
	static int middleElement(Node head) {
		if (head == null)
			return 0;
		int count = 0;
		Node curr;
		for (curr = head; curr != null; curr = curr.next) {
			count++;
		}
		curr = head;
		for (int i = 0; i < count / 2; i++) {
			curr = curr.next;
		}
		return curr.data;
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
		System.out.println(middleElement(head)+"\n"+middleElementEfficient(head));

		sc.close();
	}

}
