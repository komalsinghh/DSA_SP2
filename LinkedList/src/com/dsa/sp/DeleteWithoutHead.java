/**
 * 
 */
package com.dsa.sp;
import com.dsa.sp.SingleLinkedList.Node;

/**
 * @author komalsingh
 *
 */
public class DeleteWithoutHead {
	static void deleteNode(Node ptr) {
		ptr.data=ptr.next.data;
		ptr.next=ptr.next.next;
	}
	public static void main(String[] args) {
		Node head=new Node(10);
    	head.next=new Node(20);
    	Node ptr=new Node(30);
	    head.next.next=ptr;
    	head.next.next.next=new Node(40);
    	head.next.next.next.next=new Node(25);
    	SingleLinkedList.display(head);
	    deleteNode(ptr);
    	SingleLinkedList.display(head);

	}

}
