/**
 * 
 */
package com.dsa.sp;

import java.util.Scanner;

import com.dsa.sp.DoublyLinkedList.Node;

/**
 * @author komalsingh
 *
 */
public class ReverseDoublyLL {
	static Node reverse(Node head) {
		Node curr=head,prev=null;
		if(head==null || head.next==null)
			return head;
		while(curr!=null) {
			prev=curr.prev;
			curr.prev=curr.next;	//swapping
			curr.next=prev;
			
			curr=curr.prev;
		}
		return prev.prev;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many elements to add into LL?");
		int n = sc.nextInt();
		Node head = null;
		while (n-- > 0) {
			System.out.println("Enter an element");
			int data = sc.nextInt();
			head = DoublyLinkedList.insert(head, data);
		}
		DoublyLinkedList.display(head);
		head=reverse(head);
		DoublyLinkedList.display(head);
		sc.close();
	}

}
