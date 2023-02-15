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
public class SegregateEvenOddNode {
	static Node segregateNode(Node head) {
		Node es = null, ee = null, os = null, oe= null;
		for(Node curr=head;curr!=null;curr=curr.next) {
			int x=curr.data;
			if(x%2==0) {
				if(es==null) { //it is checking it is first even node or not
					es=ee=curr;
				}
				else {
					ee.next=curr;
					ee=ee.next;
				}
			}
			else {
				if(os==null) { //it is checking it is first odd node or not
					os=oe=curr;
				}
				else {
					oe.next=curr;
					oe=oe.next;
				}
			}
		}
		if(os==null || es==null) //if all the nodes are either even or odd
			return head;
		ee.next=os;
		oe.next=null;
		return es;
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
		head = segregateNode(head);
		SingleLinkedList.display(head);
		sc.close();
	}

}
