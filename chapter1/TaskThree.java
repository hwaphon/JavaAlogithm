package com.chapter1;

/*
 * 	编写一个方法，将字符串中的空格全都替换成 %20 ， 假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的真实长度。
 */
import java.util.Scanner;

public class TaskThree {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String source = input.nextLine();
		input.close();

		char[] target = new char[512];
		int length = source.length();

		for (int i = 0; i < length; i++) {
			target[i] = source.charAt(i);
		}

		String result = replace(target, length);
		System.out.println(result);
	}

	public static String replace(char[] s, int length) {

		int space = 0;

		for (int i = 0; i < length; i++) {
			if (s[i] == ' ') {
				space++;
			}
		}

		if (space == 0) {
			return new String(s);
		}

		int newLength = length + space * 2;

		s[newLength] = '\0';
		for (int i = length - 1; i >= 0; i--) {
			if (s[i] == ' ') {
				s[--newLength] = '0';
				s[--newLength] = '2';
				s[--newLength] = '%';
			} else {
				s[--newLength] = s[i];
			}
		}

		return new String(s);
	}

}
