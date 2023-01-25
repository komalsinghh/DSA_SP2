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
public class InsertOperationSingleLL {
	static Node insertAtBegin(Node head,int data) {
		Node temp=new Node(data);
		temp.next=head;
		return temp;
	}
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
	static Node insertAtPosition(Node head, int pos,int data) {
		Node temp=new Node(data);
		if(pos==1) {
			temp.next=head;
			return temp;
		}
		Node curr=head;
		for(int i=1;i<=pos-2 && curr!=null;i++) {
			curr=curr.next;
		}
		if(curr==null) {
			return head;
		}
		temp.next=curr.next;
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
		Node head=null;
		System.out.println("How many elements to add into LL?");
		int t = sc.nextInt();
		while (t-- > 0) {
			System.out.println("Enter an element");
			int data = sc.nextInt();
			head = insert(head, data);
		}
		System.out.println("Enter number in switch case");
		int n = sc.nextInt();
		switch (n) {
		case 1:
			System.out.println("Enter a number at begining");
			int num = sc.nextInt();
			head=insertAtBegin(head, num);
			break;
		case 2:System.out.println("Enter a position for insertion");
		  	    int pos=sc.nextInt();
		  	    System.out.println("Enter number for that position");
		  	    int posNum=sc.nextInt();
		  	    head=insertAtPosition(head,pos,posNum);
		  	    break;
		}
		display(head);
		sc.close();
	}

}
