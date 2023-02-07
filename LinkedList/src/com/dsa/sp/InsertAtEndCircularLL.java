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
public class InsertAtEndCircularLL {
	//Efficient Approach with swapping (O(1))
	static Node insertAtEndEfficiently(Node head, int ele) {
		Node temp=new Node(ele);
		if(head==null) {
			temp.next=temp;
			return temp;
		}
		else {
			temp.next=head.next;
			head.next=temp;
			int t=head.data;
			head.data=temp.data;
			temp.data=t;
			return temp;
		}
	}
	//Naive Approach(O(n))
	static Node insertAtEnd(Node head, int ele) {
		Node temp=new Node(ele);
		if(head==null) {
			temp.next=temp;
			return temp;
		}
		else {
			Node curr=head;
			while(curr.next!=head) {
				curr=curr.next;
			}
			curr.next=temp;
			temp.next=head;
			return head;
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
		System.out.println("\nEnter an element to insert at begin");
		int ele=sc.nextInt();
		head=insertAtEnd(head,ele);
		CircularLinkedList.display(head);
		head=insertAtEndEfficiently(head,ele);
		CircularLinkedList.display(head);
		sc.close();
	}

}
