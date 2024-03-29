/**
 * 
 */
package com.dsa.sp.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author komalsingh
 *
 */
public class LargestRectangularAreaHistogram {
	//Best Approach O(n)
	static int bestLargestArea(int[] arr,int n) {
		Stack <Integer> s=new Stack<>();
		int res=0, curr=0;
		for(int i=0;i<n;i++) {
			while(!s.isEmpty() && arr[s.peek()]>=arr[i]) {
				int top=s.peek();
				s.pop();
				curr=arr[top]*(s.isEmpty()?i:i-s.peek()-1);
				res=Math.max(res, curr);
			}
			s.push(i);
		}
		while(s.isEmpty()==false) {
			int top=s.peek();
			s.pop();
			curr=arr[top]*(s.isEmpty()?n:n-s.peek()-1);
			res=Math.max(res, curr);
		}
		return res;
	}
	
	//Better Approach O(n)
	static int largestArea(int[] arr, int n) {
		int res=0;
        int[] ps=new int[n];
        int[] ns=new int[n];
   
       Stack <Integer> s=new Stack<>();
       s.add(0);
       for(int i=0;i<n;i++){
           while(s.isEmpty()==false && arr[s.peek()]>=arr[i])
               s.pop();
           int pse=s.isEmpty()?-1:s.peek();
           ps[i]=pse;
           s.push(i);
       }
       
       while(s.isEmpty()==false){
           s.pop();
       }
       
       s.push(n-1);
       for(int i=n-1;i>0;i--){
           while(s.isEmpty()==false && arr[s.peek()]>=arr[i])
               s.pop();
           int nse=s.isEmpty()?n:s.peek();
           ns[i]=nse;
           s.add(i);
       }
       
       for(int i=0;i<n;i++){
           int curr=arr[i];
           curr+=(i-ps[i]-1)*arr[i];
           curr+=(ns[i]-i-1)*arr[i];
           res=Math.max(res,curr);
       }
       return res;
	}
	
	//Naive Approach O(n^2)
	/*static int largestArea(int[] arr, int n) {
		int res=0;
		for(int i=0;i<n;i++) {
			int curr=arr[i];
			for(int j=i-1;j>=0;j--) {
				if(arr[j]>=arr[i])
					curr+=arr[i];
				else
					break;
			}
			for(int j=i+1;j<n;j++) {
				if(arr[j]>=arr[i])
					curr+=arr[i];
				else
					break;
			}
			res=Math.max(res, curr);
		}
		return res;
	}*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Capacity");
		int capacity = sc.nextInt();
		int[] arr = new int[capacity];
		System.out.println("Enter element");
		for (int i = 0; i < capacity; i++) {
			arr[i] = sc.nextInt();
		}
		//System.out.println(largestArea(arr, capacity));
		System.out.println(bestLargestArea(arr, capacity));
		sc.close();
	}

}
