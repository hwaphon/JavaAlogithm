package com.chapter2;
/*
 * 找出单链表中的倒数第 k 个节点。
 * 
 * 解题思想： 如果不要求返回节点元素，可以使用递归的方式，递归方法的思想就是遍历到链表的最后一个元素，然后开始计数，
 * 直到数值达到 k，由于此时是倒着计数的，所以这就是要找的倒数第 k 个节点。如果要求返回节点元素，那么就可以使用快行指针，
 * 思想就是设置两个指针，让两个指针间隔为 k-1， 这样的话，当快行指针到达尾部的时候，正常指针的位置正好到达倒数第k个节点。
 */
public class TaskTwo {

	public static void main(String[] args) {

		Node head = new Node(1);

		for (int i = 2; i <= 10; i++) {
			head.append(i);
		}

		head.print(head);
		System.out.println();

		find1(head, 1);

		if (find2(head, 1) != null) {
			System.out.println(find2(head, 3).data);
		}
	}

	// 解法1： 如果不用返回元素，直接打印

	public static int find1(Node n, int k) {
		if (n == null) {
			return 0;
		}

		int i = find1(n.next, k) + 1;
		if (i == k) {
			System.out.println(n.data);
		}

		return i;
	}

	// 解法2： 设置快行指针
	public static Node find2(Node n, int k) {
		if (n == null) {
			return null;
		}

		Node current = n, fast = n;
		int i = 1;

		while (i++ < k) {
			if (fast == null) {
				return null;
			}
			fast = fast.next;
		}

		if (fast == null) {
			return null;
		}

		while (fast.next != null) {
			fast = fast.next;
			current = current.next;
		}
		return current;
	}
}
