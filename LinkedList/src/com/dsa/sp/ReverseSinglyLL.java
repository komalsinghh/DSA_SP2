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
public class ReverseSinglyLL {
	static Node reverse(Node head) {
		Node curr=head,prev=null,next=null;
		if(head==null || head.next==null) {
			return head;
		}
		while(curr!=null) {
			next=curr.next;
			curr.next=prev;
			prev=curr;
			
			curr=next;
		}
	
		return prev;
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
		head=reverse(head);
		SingleLinkedList.display(head);
		sc.close();
	}

}
