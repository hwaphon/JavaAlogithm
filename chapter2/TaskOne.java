package com.chapter2;

/*
 *  编写代码，移除未排序链表中的重复节点。
 *  
 *  解题思想： 如果允许使用临时缓冲区，那么可以利用 Hashtable 来存储链表的各个元素，以去除重复节点，不过这要求节点的 key 是
 *  对象属性。如果不允许使用临时缓冲区，那么只能利用循环检测，此时时间复杂度为 O(N^2)
 */
public class TaskOne {
	public static void main(String[] args) {

		Node head = new Node(10);
		head.append(9);
		head.append(9);
		head.append(8);
		head.append(7);
		head.append(7);
		head.print(head);

		deleteDups(head);
		System.out.println();

		head.print(head);
	}

	public static void deleteDups(Node n) {
		if (n == null) {
			return;
		}

		Node current = n;
		while (current != null) {
			Node runner = current;

			while (runner.next != null) {
				if (runner.next.data == current.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}

			current = current.next;
		}
	}
}
