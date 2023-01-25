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
public class DeleteOperationSingleLL {
	static Node insert(Node head, int data) {
		Node curr = head;
		if (curr == null) {
			head = new Node(data);
		} else {
			while (curr.next != null) {
				curr = curr.next;
			}
			curr.next = new Node(data);
		}
		return head;
	}
	static Node deleteAtBegin(Node head) {
		if(head==null)
			return null;
		else 
			return head.next;
	}
	static Node deleteAtLast(Node head) {
		if(head==null)
			return null;
		if(head.next==null)
			return null;
		Node curr=head;
		while(curr.next.next!=null) {
			curr=curr.next;
		}
		curr.next=null;
		return head;
	}
	static Node deleteAtPosition(Node head,int pos) {
		Node temp=head;
		if(pos==1 && head!=null) {
			return head.next;
		}
		else {
			for(int i=1;i<pos-1;i++) {
				if(temp!=null)
					temp=temp.next;
			}
			if(temp!=null && temp.next!=null) {
				temp.next=temp.next.next;
			}
			
		}
		return head;
	}
	static void display(Node head) {
		Node curr = head;
		if (curr == null) {
			System.out.println("List is empty");
		} else {
			while (curr != null) {
				System.out.print(curr.data + " ");
				curr = curr.next;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many elements to add into LL?");
		int t = sc.nextInt();
		Node head = null;
		while (t-- > 0) {
			System.out.println("Enter an element");
			int data = sc.nextInt();
			head = insert(head, data);
		}
		System.out.println("Enter number in switch case");
		int n = sc.nextInt();
		switch (n) {
		case 1:
			head=deleteAtBegin(head);
			break;
		case 2:System.out.println("Deleting at last");
				head=deleteAtLast(head);
				break;
		case 3:System.out.println("Enter a position to delete");
		  	    int pos=sc.nextInt();
		  	    head=deleteAtPosition(head,pos);
		  	    break;
		}
		display(head);
		sc.close();
	}

}
