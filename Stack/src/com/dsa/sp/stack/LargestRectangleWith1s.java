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
public class LargestRectangleWith1s {
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
	static int maxRectangle(int[][] arr, int r,int c) {
		int res=largestArea(arr[0], c);
		for(int i=1;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(arr[i][j]==1) {
					arr[i][j]+=arr[i-1][j];
				}
			}
			res=Math.max(res, largestArea(arr[i], c));
		}
		return res;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter row size ");
		int n=sc.nextInt();
		System.out.println("Enter column size");
		int m=sc.nextInt();
		int[][] arr=new int[n][m];
		System.out.println("Enter Elements in 2-D");
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		System.out.println(maxRectangle(arr,n,m));
		sc.close();
	}

}
