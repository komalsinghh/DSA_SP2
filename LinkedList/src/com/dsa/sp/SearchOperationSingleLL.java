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
public class SearchOperationSingleLL {
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
	//iterative
	static int search(Node head, int n) {
		int pos=1;
		Node curr=head;
		while(curr!=null) {
			if(curr.data==n)
				return pos;
			else {
				pos++;
				curr=curr.next;
			}
		}
		return -1;
	}
	//recursive
	static int searchRecursive(Node head,int num) {
		if(head==null)
			return -1;
		if(head.data==num) {
			return 1;
		}
		else {
			int res=searchRecursive(head.next, num);
			if(res==-1) 
				return -1;
			
			else 
				return (res+1);
			
		}
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
		System.out.println("\nEnter a number to search");
		int num=sc.nextInt();
		System.out.println("Element is present at position "+search(head,num));
		System.out.println("Element is present at position "+searchRecursive(head,num));
		sc.close();
	}

}
