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
public class RemoveDuplicateSortedLL {
	static Node removeDuplicate(Node head) {
		if(head==null)
			return null;
		Node curr=head;
		while(curr!=null && curr.next!=null) {
			if(curr.data==curr.next.data) {
				curr.next=curr.next.next;
			}
			else {
				curr=curr.next;
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
			head = SingleLinkedList.insert(head, data);
		}
		SingleLinkedList.display(head);
		head=removeDuplicate(head);
		SingleLinkedList.display(head);
		sc.close();
	}

}
