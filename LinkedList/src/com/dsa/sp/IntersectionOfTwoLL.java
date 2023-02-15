/**
 * 
 */
package com.dsa.sp;

import java.util.HashSet;
import java.util.Scanner;

import com.dsa.sp.SingleLinkedList.Node;

/**
 * @author komalsingh
 *
 */
public class IntersectionOfTwoLL {
	//T.C- O(n+m) S.C- O(1)
	static int getCount(Node head) {
		int count=0;
		Node current=head;
		while (current != null) { 
			count++; 
			current = current.next; 
		} 

		return count; 
	}
	static int getIntersectionNode(Node head1, Node head2, int d) {
		Node curr1=head1, curr2=head2;
		for(int i=0;i<d;i++) {
			if(curr1==null)
				return -1;
			curr1=curr1.next;
		}
		while(curr1!=null && curr2!=null) {
			if(curr1.data==curr2.data)
				return curr1.data;
			curr1=curr1.next;
			curr2=curr2.next;
		}
		return -1;
	}
	static int getNode(Node head1, Node head2) {
		int c1=getCount(head1);
		int c2=getCount(head2);
		int d;
		if(c1>c2) {
			d=c1-c2;
			return getIntersectionNode(head1,head2,d);
		}
		else {
			d=c2-c1;
			return getIntersectionNode(head2,head1,d);
		}
	}
	
	//Using Hashing T.C- O(n+m) S.C- O(m)
	static int intersection(Node head1, Node head2) {
		HashSet<Node> hs = new HashSet<>();
		Node curr = head1;
		while (curr != null) {
			hs.add(curr);
			curr = curr.next;
		}
		curr = head2;
		while (curr != null) {
			if (hs.contains(curr))
				return curr.data;
			curr = curr.next;
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many elements to add into LL1?");
		int n = sc.nextInt();
		int a1 = sc.nextInt();
		Node head1 = new Node(a1);
		Node curr1 = head1;

		while (n-- > 1) {
			System.out.println("Enter an element");
			int data = sc.nextInt();
			if (curr1 == null) {
				head1 = new Node(data);
			} else {
				while (curr1.next != null) {
					curr1 = curr1.next;
				}
				curr1.next = new Node(data);
			}
		}
		SingleLinkedList.display(head1);

		System.out.println("How many elements to add into LL2?");
		int m = sc.nextInt();
		int a2 = sc.nextInt();
		Node head2 = new Node(a2);
		Node curr2 = head2;
		while (m-- > 1) {
			System.out.println("Enter an element");
			int data = sc.nextInt();
			if (curr2 == null) {
				head1 = new Node(data);
			} else {
				while (curr2.next != null) {
					curr2 = curr2.next;
				}
				curr2.next = new Node(data);
			}
		}
		SingleLinkedList.display(head2);

		System.out.println("How many common elements?");
		int common = sc.nextInt();
		System.out.println("Enter an element");
		int c1 = sc.nextInt();
		Node head3 = new Node(c1);
		curr1.next = head3;
		curr2.next = head3;
		Node curr3 = head3;
		while (common-- > 1) {
			System.out.println("Enter an element");
			int c = sc.nextInt();
			curr3.next = new Node(c);
			curr3 = curr3.next;
		}
		System.out.println(intersection(head1, head2));
		System.out.println("Optimised Solution "+getNode(head1, head2));
		sc.close();
	}

}
