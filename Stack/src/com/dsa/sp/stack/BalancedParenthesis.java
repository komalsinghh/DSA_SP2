package com.dsa.sp.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author komalsingh
 *
 */
public class BalancedParenthesis {
	static boolean matching(char a, char b) {
		return ((a == '(' && b == ')') || (a == '[' && b == ']') || (a == '{' && b == '}'));
	}

	// T.C- O(n)
	static boolean checkBracket(String str) {
		Deque<Character> stack = new ArrayDeque<>();
		for (int i = 0; i < str.length(); i++) {
			char x = str.charAt(i);
			if (x == '(' || x == '{' || x == '[')
				stack.push(x);
			else {
				if (stack.isEmpty())
					return false;
				else if (matching(stack.peek(), x) == false)
					return false;
				else
					stack.pop();
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Bracket");
		String br = sc.next();
		System.out.println("Brackets are balanced? " + checkBracket(br));
		sc.close();
	}

}
