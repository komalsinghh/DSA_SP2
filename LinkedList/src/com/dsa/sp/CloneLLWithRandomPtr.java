/**
 * 
 */
package com.dsa.sp;

/**
 * @author komalsingh
 *
 */
import java.util.*;

class Node {
	int data;
	Node next, random;

	Node(int x) {
		data = x;
		next = random = null;
	}
}

class CloneLLWithRandomPtr {
	// T.C- O(n) S.C- O(1)
	static Node cloneLL(Node head) {
		Node curr = head;
		while (curr != null) {
			Node next = curr.next; // Inserting clone nodes alternatively
			curr.next = new Node(curr.data);
			curr.next.next = next;
			curr = next;
		}
		for (curr = head; curr != null; curr = curr.next.next) {
			curr.next.random = (curr.random != null) ? curr.random.next : null; // connecting random nodes
		}
		Node cloneHead = head.next;
		Node clone = cloneHead;
		for (Node original = head; original != null && cloneHead != null; original = original.next) {
			original.next = (original.next != null) ? original.next.next : original.next; // Separating odd and even
																							// nodes
			clone.next = clone.next != null ? clone.next.next : clone.next;
			clone = clone.next;
		}
		return cloneHead;
	}

	// T.C- O(n) S.C- O(n)
	public static Node clone(Node head) {
		HashMap<Node, Node> hm = new HashMap<>();
		for (Node curr = head; curr != null; curr = curr.next) {
			hm.put(curr, new Node(curr.data));
		}
		for (Node curr = head; curr != null; curr = curr.next) {
			Node clone = hm.get(curr);
			clone.next = hm.get(curr.next);
			clone.random = hm.get(curr.random);
		}
		return hm.get(head);
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

	public static void print(Node start) {
		Node ptr = start;
		while (ptr != null) {
			if (ptr.random == null) {
				System.out.println("Data = " + ptr.data + ", Random  = null");
			} else
				System.out.println("Data = " + ptr.data + ", Random  = " + ptr.random.data);
			ptr = ptr.next;
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
		System.out.println("Enter number of random pointer");
		int m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			System.out.println("Enter position of parent of random node");
			int pn = sc.nextInt();
			System.out.println("Enter position of random node");
			int rn = sc.nextInt();
			Node curr = head;
			int count = 0;
			while (curr != null) {
				if (count == pn)
					break;
				++count;
				curr = curr.next;
			}
			Node currR = head;
			count = 0;
			while (currR != null) {
				if (count == rn)
					break;
				++count;
				currR = currR.next;
			}
			curr.random = currR;
		}

		System.out.print("Original list : \n");
		print(head);

		System.out.print("\nCloned list : \n");
		Node cloned_list = clone(head);
		print(cloned_list);
		Node efficientSoln = cloneLL(head);
		print(efficientSoln);
		sc.close();
	}
}
