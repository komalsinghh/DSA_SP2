/**
 * 
 */
package com.dsa.sp;

import java.util.Scanner;

import com.dsa.sp.CircularLinkedList.Node;

/**
 * @author komalsingh
 *
 */
public class DeleteOperationCircularLL {
	//Efficient Approach
	static Node deleteHeadEfficiently(Node head) {
		if(head==null||head.next==head) {
			return null;
		}
		head.data=head.next.data;
		head.next=head.next.next;
		return head;
	}
	//Naive Approach
	static Node deleteHead(Node head) {
		if(head==null||head.next==head) {
			return null;
		}
		else {
			Node curr=head;
		
			while(curr.next!=head) {
				curr=curr.next;
			}
			curr.next=head.next;
			return curr.next;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many elements to add into LL?");
		int n = sc.nextInt();
		Node head = null;
		while (n-- > 0) {
			System.out.println("Enter an element");
			int data = sc.nextInt();
			head = CircularLinkedList.insert(head, data);
		}
		CircularLinkedList.display(head);
		head=deleteHead(head);
		CircularLinkedList.display(head);
		deleteHeadEfficiently(head);
		CircularLinkedList.display(head);
		sc.close();
	}

}
