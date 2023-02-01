/**
 * 
 */
package com.dsa.sp;

import java.util.Scanner;


/**
 * @author komalsingh
 *
 */
public class DoublyLinkedList {
	static class Node{
		int data;
		Node prev;
		Node next;
		public Node(int data) {
			this.data = data;
			}
		
	}
	static Node insert(Node head,int data) {
		Node temp=new Node(data);
		if(head==null)
			return temp;
		Node curr=head;
			while(curr.next!=null) {
				curr=curr.next;
			}
			curr.next=temp;
			temp.prev=curr;
			return head;
		
	}
	static Node insertAtBegin(Node head,int n) {
		Node temp=new Node(n);
		temp.next=head;
		if(head!=null)
			head.prev=temp;
		return temp;
	}
	static Node insertAtPosition(Node head, int pos, int ele) {
		Node temp=new Node(ele);
		if(pos==1) {
			temp.next=head;
			if(head!=null)
				head.prev=temp;
			return temp;
		}
		Node curr=head;
		for(int i=1;i<pos-1 && curr!=null;i++) {
			curr=curr.next;
		}
		if(curr==null)
			return head;
		temp.next=curr.next;
		temp.prev=curr;
		curr.next=temp;
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
		int n = sc.nextInt();
		Node head = null;
		while (n-- > 0) {
			System.out.println("Enter an element");
			int data = sc.nextInt();
			head = insert(head, data);
		}
		display(head);
//		System.out.println("\nEnter an element to insert at begin");
//		int ele=sc.nextInt();
//		head=insertAtBegin(head,ele);
//		display(head);
		System.out.println("Enter position and element");
		int pos=sc.nextInt();
		int posEle=sc.nextInt();
		head=insertAtPosition(head,pos,posEle);
		display(head);
		sc.close();
	}

}
