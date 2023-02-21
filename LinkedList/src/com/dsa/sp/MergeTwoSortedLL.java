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
public class MergeTwoSortedLL {
	static Node mergeLL(Node head1, Node head2) {
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;
		Node head = null, tail = null;
		if (head1.data <= head2.data) {
			head = tail = head1;
			head1 = head1.next;
		} else {
			head = tail = head2;
			head2 = head2.next;
		}
		while (head1 != null && head2 != null) {
			if(head1.data<=head2.data) {
				tail.next=head1;
				tail=head1;
				head1=head1.next;
			}
			else {
				tail.next=head2;
				tail=head2;
				head2=head2.next;
			}
		}
		if(head1==null) {
			tail.next=head2;
		}
		else
			tail.next=head1;
		return head;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many elements to add into LL?");
		int n = sc.nextInt();
		Node head = null;
		while (n-- > 0) {
			System.out.println("Enter an element in sorted order");
			int data = sc.nextInt();
			head = SingleLinkedList.insert(head, data);
		}
		System.out.println("How many elements to add into LL?");
		int m = sc.nextInt();
		Node head1 = null;
		while (m-- > 0) {
			System.out.println("Enter an element in sorted order");
			int data = sc.nextInt();
			head1 = SingleLinkedList.insert(head1, data);
		}
		SingleLinkedList.display(head);
		SingleLinkedList.display(head1);
		Node res = mergeLL(head, head1);
		SingleLinkedList.display(res);
		sc.close();
	}

}
