/**
 * 
 */
package com.dsa.sp;

import java.util.Scanner;

import com.dsa.sp.SingleLinkedList.Node;

/**
 * @author komalsingh
 *
 */
public class DetectAndRemoveLoop {
	static void detectRemoveLoop(Node head) {
		Node slow=head, fast=head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				break;
		}
		if(slow!=fast)
			return;
		slow=head;
		while(slow.next!=fast.next) {
			slow=slow.next;
			fast=fast.next;
		}
		fast.next=null;
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
		head.next.next.next.next=head.next; //creating loop
		detectRemoveLoop(head);
		if(DetectLoopByFloydAlgo.isLoop(head)) {
			System.out.println("Yes, loop detected!");
		}
		else
			System.out.println("No loop!");
		
		sc.close();
	}

}
