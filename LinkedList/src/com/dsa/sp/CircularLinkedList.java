/**
 * 
 */
package com.dsa.sp;

import java.util.Scanner;


/**
 * @author komalsingh
 *
 */
public class CircularLinkedList {
	static class Node{
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
		}
		
	}
	static Node temp=null;
	static Node insert(Node head, int data) {
		Node newEle=new Node(data);
		if(head==null) {
			newEle.next=newEle;
			temp=newEle;
			return newEle;
		}
		else {
			temp.next=newEle;
			temp=newEle;
			temp.next=head;
		}
		return head;
	}
	static void display(Node head) {
		if(head==null)
			return;
		Node curr=head;
		do {
			System.out.print(curr.data+" ");
			curr=curr.next;
		}while(curr!=head);
		System.out.println();
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
		sc.close();
	}

}
