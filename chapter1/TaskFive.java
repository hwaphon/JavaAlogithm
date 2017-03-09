package com.chapter1;

/*
 *  假定有一个方法 isSubstring， 可检查一个单词是否为其它字符串的子串。给定两个字符串 s1 和 s2，请编写代码检查
 *	s2 是否为 s1 旋转而成，要求只能调用一次 isSubstring(比如， waterbottle 是 erbottlewat 的字符串)。
 *	
 *	解题核心： s2 无论如何旋转始终是 s1s1 的子串。
 */
import java.util.Scanner;

public class TaskFive {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String source = input.nextLine();
		String target = input.nextLine();

		input.close();

		boolean result = isSubstring(target, source);
		System.out.println(result);

	}

	public static boolean isSubstring(String t, String s) {
		StringBuffer buffer = new StringBuffer(s + s);
		return buffer.indexOf(t) > -1;
	}

}
