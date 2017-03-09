package com.chapter1;
/*
 *   利用字符串重复的次数，编写一个方法，实现基本的字符串压缩功能。比如，字符串 "aabcccccaaa" 会变为 "a2b1c5a3"。若
 *   压缩后的字符串没有变短，则返回原来的字符串。
 */
import java.util.Scanner;

public class TaskFour {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String source = input.next();

		String result = zipString(source);

		System.out.println(result);

	}

	public static String zipString(String s) {

		if (countCompression(s) >= s.length()) {
			return s;
		}

		int length = s.length(), count = 1;
		char last = s.charAt(0);
		StringBuffer buffer = new StringBuffer();

		for (int i = 1; i < length; i++) {
			if (s.charAt(i) == last) {
				count++;
			} else {
				buffer.append(last);
				buffer.append(count);
				count = 1;
				last = s.charAt(i);
			}
		}

		buffer.append(last);
		buffer.append(count);

		return buffer.toString();
	}

	public static int countCompression(String s) {
		if (s == null || s.isEmpty()) {
			return 0;
		}

		int count = 1, size = 0, length = s.length();
		char last = s.charAt(0);

		for (int i = 1; i < length; i++) {
			if (s.charAt(i) == last) {
				count++;
			} else {
				size += 1 + String.valueOf(count).length();
				count = 1;
				last = s.charAt(i);
			}
		}

		size += 1 + String.valueOf(count).length();
		return size;
	}

}
