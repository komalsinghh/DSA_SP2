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
public class DeleteOperationDoublyLL {
	static Node deleteAtBegin(Node head) {
		if(head==null || head.next==null)
			return head;
		else {
			head=head.next;
			head.prev=null;
			return head;
		}
	}
	static Node deleteAtLast(Node head) {
		if(head==null || head.next==null)
			return head;
		Node curr=head;
		while(curr.next!=null)
			curr=curr.next;
		curr.prev.next=null;
		return head;
	}
	static Node deleteAtPosition(Node head, int pos) {
		Node curr=head;
		if(pos<1)
			return head;
		if(pos==1 && head!=null) {
			head=head.next;
			if(head!=null)
				head.prev=null;
			return head;
		}
		else {
			for(int i=1; i<pos-1 && curr!=null;i++) {
				curr=curr.next;
			}
				if(curr!=null && curr.next!=null) {
				curr.next=curr.next.next;
				if(curr.next!=null)//if node to be deleted is not last
					curr.next.prev=curr.prev;
				}
		}
		return head;
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
		head=deleteAtBegin(head);
		DoublyLinkedList.display(head);
		head=deleteAtLast(head);
		DoublyLinkedList.display(head);
		System.out.println("Enter position to delete");
		int pos=sc.nextInt();
		head=deleteAtPosition(head,pos);
		DoublyLinkedList.display(head);
		sc.close();
	}

}
