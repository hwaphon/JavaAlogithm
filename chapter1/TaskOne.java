package com.chapter1;

/*
 *  实现一个算法，确定字符串的所有字符是否全都不同，假设是 ASCII 字符
 */
import java.util.Scanner;

public class TaskOne {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		String source = input.next();

		boolean result = check(source);

		System.out.println(result);

	}

	public static boolean check(String source) {

		if (source.length() > 256) {
			return false;
		}

		boolean[] marker = new boolean[256];

		int length = source.length();

		for (int i = 0; i < length; i++) {
			int index = source.charAt(i);

			if (marker[index]) {
				return false;
			}
			marker[index] = true;
		}
		return true;
	}
}
