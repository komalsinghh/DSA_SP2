/**
 * 
 */
package com.dsa.sp;

import java.util.Scanner;

import com.dsa.sp.CircularLinkedList.Node;

/**
 * @author komalsingh01
 *
 */
public class DeleteKthCircularLL {
	static Node deleteKthNode(Node head,int pos) {
		if(head==null)
			return null;
		if(pos==1)
			return DeleteOperationCircularLL.deleteHeadEfficiently(head);
		Node curr=head;
		for(int i=1;i<pos-1 ;i++) {
			curr=curr.next;
		}
		curr.next=curr.next.next;
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
			head = CircularLinkedList.insert(head, data);
		}
		CircularLinkedList.display(head);
		System.out.println("Enter Position to be deleted");
		int pos=sc.nextInt();
		head=deleteKthNode(head,pos);
		CircularLinkedList.display(head);
		sc.close();
	}

}
