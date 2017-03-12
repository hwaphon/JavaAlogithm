package com.chapter1;

/*
 * 给定两个字符串，请编写程序，确定其中一个字符串的字符重新排序后，能否变成另一个字符串。 
 */

import java.util.Scanner;

public class TaskTwo {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		String source = input.next();
		String compare = input.next();

		boolean result = check1(source, compare);

		System.out.println(result);
	}

	// 解法 1
	public static boolean check1(String source, String compare) {

		int[] marker = new int[256];
		int lengthS = source.length();
		int lengthC = compare.length();

		if (lengthC != lengthS) {
			return false;
		}

		for (int i = 0; i < 256; i++) {
			marker[i] = 0;
		}

		for (int i = 0; i < lengthS; i++) {
			int index = source.charAt(i);
			marker[index]++;
		}

		for (int i = 0; i < lengthC; i++) {
			int index = compare.charAt(i);
			marker[index]--;

			if (marker[index] < 0) {
				return false;
			}
		}

		return true;
	}
	
	// 解法 2
	
	public static boolean check2(String source, String compare) {
		if(source.length() != compare.length()) {
			return false;
		}
		
		return sort(source).equals(sort(compare));
	}
	
	public static String sort(String s) {
		
		char[] content = s.toCharArray();
		java.util.Arrays.sort(content);
		
		return new String(content);
	}
}
