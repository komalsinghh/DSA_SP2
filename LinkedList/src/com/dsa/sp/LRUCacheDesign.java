/**
 * 
 */
package com.dsa.sp;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author komalsingh
 *
 */


public class LRUCacheDesign {
	class Node {
		int key, value;
		Node prev, next;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
		
	}
	int capacity, count;
	 HashMap<Integer, Node> hm;
	 Node head, curr;

	public LRUCacheDesign(int capacity) {
		this.capacity = capacity;
		hm = new HashMap<>();
		head = new Node(0, 0);
		curr = new Node(0,0);
		head.next = curr;
		curr.prev = head;
		head.prev = null;
		curr.next = null;
		count = 0;
	}

	 void deleteNode(Node node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}

	 void addToHead(Node node) {
		 node.next = head.next; 
			node.next.prev = node; 
			node.prev = head; 
			head.next = node; 
	}

	 int get(int key) {
		 if(hm.get(key)!=null) {
			 Node node=hm.get(key);
			 int value=node.value;
			 deleteNode(node);
			 addToHead(node);
			 System.out.println("Got the value "+value+" for the key"+key);
			 return value;
		 }
		 System.out.println("No result found for key "+key);
		 return -1;
	 }
	 void set(int key,int value) {
		System.out.println("Setting (key, value)= ("+key+" "+value+")");
		if(hm.get(key)!=null) {
			Node node=hm.get(key);
			node.value=value;
			deleteNode(node);
			addToHead(node);
		}
		else {
			Node node=new Node(key, value);
			hm.put(key, node);
			if(count<capacity) {
				count++;
				addToHead(node);
			}
			else {
				hm.remove(curr.prev.key);
				deleteNode(curr.prev);
				addToHead(node);
			}
		}
	}
	 public void printCache(){
	        System.out.print("Cache : ");
	        Node start = head;
	        while(start!=null){
	            System.out.print(start.key + " ");
	            start = start.next;
	        }
	        System.out.println();
	    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter capacity of cache");
		int capacity = sc.nextInt();
		LRUCacheDesign obj = new LRUCacheDesign(capacity);
		
		for(int i=0;i<capacity;i++) {
			System.out.println("Enter key and value");
			int key=sc.nextInt();
			int value=sc.nextInt();
			obj.set(key, value);
			}
		System.out.println("Enter key to get");
		int k=sc.nextInt();
		System.out.println("Value for the key "+k+" is "+obj.get(k));
		System.out.println("Enter key and value");
		int key=sc.nextInt();
		int value=sc.nextInt();
		obj.set(key, value);
		System.out.println("Enter key to get");
		int k1=sc.nextInt();
		System.out.println("Value for the key "+k1+" is "+obj.get(k1));
		obj.printCache();
		sc.close();
	}

}
